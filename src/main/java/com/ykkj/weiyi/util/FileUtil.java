package com.ykkj.weiyi.util;

/**
 * 此类中封装一些常用的文件操作。
 * 所有方法都是静态方法，不需要生成此类的实例，
 * 为避免生成此类的实例，构造方法被申明为private类型的。
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	/**
	 * 私有构造方法，防止类的实例化，因为工具类不需要实例化。
	 */
	private FileUtil() {

	}

	/**
	 * 判断指定的文件是否存在。
	 * 
	 * @param fileName
	 *            要判断的文件的文件名
	 * @return 存在时返回true，否则返回false。
	 * 
	 */
	public static boolean isFileExist(String fileName) {
		return new File(fileName).isFile();
	}

	/**
	 * 创建指定的目录。 如果指定的目录的父目录不存在则创建其目录书上所有需要的父目录。 <b>注意：可能会在返回false的时候创建部分父目录。</b>
	 * 
	 * @param file
	 *            要创建的目录
	 * @return 完全创建成功时返回true，否则返回false。
	 * 
	 */
	public static boolean makeDirectory(File file) {
		if (file.isDirectory()) {
			return file.mkdirs();
		} else {
			File parent = file.getParentFile();
			if (parent != null) {
				return parent.mkdirs();
			}
		}
		return false;
	}

	/**
	 * 创建指定的目录。 如果指定的目录的父目录不存在则创建其目录书上所有需要的父目录。 <b>注意：可能会在返回false的时候创建部分父目录。</b>
	 * 
	 * @param fileName
	 *            要创建的目录的目录名
	 * @return 完全创建成功时返回true，否则返回false。
	 * 
	 */
	public static boolean makeDirectory(String fileName) {
		File file = new File(fileName);
		return makeDirectory(file);
	}

	/**
	 * 从文件路径得到文件名。
	 * 
	 * @param filePath
	 *            文件的路径，可以是相对路径也可以是绝对路径
	 * @return 对应的文件名
	 * 
	 */
	public static String getFileName(String filePath) {
		File file = new File(filePath);
		return file.getName();
	}

	/**
	 * 从文件名得到文件绝对路径。
	 * 
	 * @param fileName
	 *            文件名
	 * @return 对应的文件路径
	 * 
	 */
	public static String getFilePath(String fileName) {
		File file = new File(fileName);
		return file.getAbsolutePath();
	}

	/**
	 * 将DOS/Windows格式的路径转换为UNIX/Linux格式的路径。
	 * 其实就是将路径中的"\"全部换为"/"，因为在某些情况下我们转换为这种方式比较方便，
	 * 某中程度上说"/"比"\"更适合作为路径分隔符，而且DOS/Windows也将它当作路径分隔符。
	 * 
	 * @param filePath
	 *            转换前的路径
	 * @return 转换后的路径
	 * 
	 */
	public static String toUNIXpath(String filePath) {
		return filePath.replace('\\', '/');
	}

	/**
	 * 从文件名得到UNIX风格的文件绝对路径。
	 * 
	 * @param fileName
	 *            文件名
	 * @return 对应的UNIX风格的文件路径
	 * 
	 * @see #toUNIXpath(String filePath) toUNIXpath
	 */
	public static String getUNIXfilePath(String fileName) {
		File file = new File(fileName);
		return toUNIXpath(file.getAbsolutePath());
	}

	/**
	 * 得到文件的类型。 实际上就是得到文件名中最后一个“.”后面的部分。
	 * 
	 * @param fileName
	 *            文件名
	 * @return 文件名中的类型部分
	 * 
	 */
	public static String getTypePart(String fileName) {
		int point = fileName.lastIndexOf('.');
		int length = fileName.length();
		if (point == -1 || point == length - 1) {
			return "";
		} else {
			return fileName.substring(point + 1, length);
		}
	}

	/**
	 * 得到文件的类型。 实际上就是得到文件名中最后一个“.”后面的部分。
	 * 
	 * @param file
	 *            文件
	 * @return 文件名中的类型部分
	 * 
	 */
	public static String getFileType(File file) {
		return getTypePart(file.getName());
	}

	/**
	 * 得到文件的名字部分。 实际上就是路径中的最后一个路径分隔符后的部分。
	 * 
	 * @param fileName
	 *            文件名
	 * @return 文件名中的名字部分
	 * 
	 */
	public static String getNamePart(String fileName) {
		int point = getPathLsatIndex(fileName);
		int length = fileName.length();
		if (point == -1) {
			return fileName;
		} else if (point == length - 1) {
			int secondPoint = getPathLsatIndex(fileName, point - 1);
			if (secondPoint == -1) {
				if (length == 1) {
					return fileName;
				} else {
					return fileName.substring(0, point);
				}
			} else {
				return fileName.substring(secondPoint + 1, point);
			}
		} else {
			return fileName.substring(point + 1);
		}
	}

	/**
	 * 得到文件名中的父路径部分。 对两种路径分隔符都有效。 不存在时返回""。
	 * 如果文件名是以路径分隔符结尾的则不考虑该分隔符，例如"/path/"返回""。
	 * 
	 * @param fileName
	 *            文件名
	 * @return 父路径，不存在或者已经是父目录时返回""
	 * 
	 */
	public static String getPathPart(String fileName) {
		int point = getPathLsatIndex(fileName);
		int length = fileName.length();
		if (point == -1) {
			return "";
		} else if (point == length - 1) {
			int secondPoint = getPathLsatIndex(fileName, point - 1);
			if (secondPoint == -1) {
				return "";
			} else {
				return fileName.substring(0, secondPoint);
			}
		} else {
			return fileName.substring(0, point);
		}
	}

	/**
	 * 得到路径分隔符在文件路径中首次出现的位置。 对于DOS或者UNIX风格的分隔符都可以。
	 * 
	 * @param fileName
	 *            文件路径
	 * @return 路径分隔符在路径中首次出现的位置，没有出现时返回-1。
	 * 
	 */
	public static int getPathIndex(String fileName) {
		int point = fileName.indexOf('/');
		if (point == -1) {
			point = fileName.indexOf('\\');
		}
		return point;
	}

	/**
	 * 得到路径分隔符在文件路径中指定位置后首次出现的位置。 对于DOS或者UNIX风格的分隔符都可以。
	 * 
	 * @param fileName
	 *            文件路径
	 * @param fromIndex
	 *            开始查找的位置
	 * @return 路径分隔符在路径中指定位置后首次出现的位置，没有出现时返回-1。
	 * 
	 */
	public static int getPathIndex(String fileName, int fromIndex) {
		int point = fileName.indexOf('/', fromIndex);
		if (point == -1) {
			point = fileName.indexOf('\\', fromIndex);
		}
		return point;
	}

	/**
	 * 得到路径分隔符在文件路径中最后出现的位置。 对于DOS或者UNIX风格的分隔符都可以。
	 * 
	 * @param fileName
	 *            文件路径
	 * @return 路径分隔符在路径中最后出现的位置，没有出现时返回-1。
	 * 
	 */
	public static int getPathLsatIndex(String fileName) {
		int point = fileName.lastIndexOf('/');
		if (point == -1) {
			point = fileName.lastIndexOf('\\');
		}
		return point;
	}

	/**
	 * 得到路径分隔符在文件路径中指定位置前最后出现的位置。 对于DOS或者UNIX风格的分隔符都可以。
	 * 
	 * @param fileName
	 *            文件路径
	 * @param fromIndex
	 *            开始查找的位置
	 * @return 路径分隔符在路径中指定位置前最后出现的位置，没有出现时返回-1。
	 * 
	 */
	public static int getPathLsatIndex(String fileName, int fromIndex) {
		int point = fileName.lastIndexOf('/', fromIndex);
		if (point == -1) {
			point = fileName.lastIndexOf('\\', fromIndex);
		}
		return point;
	}

	/**
	 * 将文件名中的类型部分去掉。
	 * 
	 * @param filename
	 *            文件名
	 * @return 去掉类型部分的结果
	 * 
	 */
	public static String trimType(String filename) {
		int index = filename.lastIndexOf(".");
		if (index != -1) {
			return filename.substring(0, index);
		} else {
			return filename;
		}
	}

	/**
	 * 得到相对路径。 文件名不是目录名的子节点时返回文件名。
	 * 
	 * @param pathName
	 *            目录名
	 * @param fileName
	 *            文件名
	 * @return 得到文件名相对于目录名的相对路径，目录下不存在该文件时返回文件名
	 * 
	 */
	public static String getSubpath(String pathName, String fileName) {
		pathName = getUNIXfilePath(pathName).toLowerCase();
		fileName = getUNIXfilePath(fileName).toLowerCase();
		if (pathName.endsWith("/"))
			pathName = pathName.substring(0, pathName.length() - 1);
		int index = fileName.indexOf(pathName);
		if (index != -1) {
			return fileName.substring(index + pathName.length());
		} else {
			return fileName;
		}
	}

	public static String toPath(String path, String suffix) {
		if (!path.endsWith(suffix))
			path += suffix;
		return path;
	}

	public static File getFile(String fileid, String root) {
		String filename = toPath(root, "/") + fileid.replace("$", "/");
		return new File(filename);
	}

	/**
	 * 复制目录
	 * 
	 * @param src_path
	 * @param dest_path
	 */
	public static void copyDir(File src_path, File dest_path) {
		File[] files = src_path.listFiles();
		for (int i = 0; i < files.length; i++) {
			File src = files[i];
			File dest = new File(dest_path.getPath() + File.separator + files[i].getName());
			if (src.isDirectory()) {
				copyDir(src, dest);
			} else {
				copyFile(src, dest);
			}
		}
	}

	/**
	 * 复制文件
	 * 
	 * @param src
	 * @param dest
	 * @throws IOException
	 */
	public static void copyFile(File src, File dest) {

		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			// 源文件的绝对路径
			String srcCanonical = src.getCanonicalPath();
			// 目标文件的绝对路径
			String destCanonical = dest.getCanonicalPath();
			if (srcCanonical.equalsIgnoreCase(destCanonical)) {// 如果两个文件的路径相同，不必拷贝
				return;
			}

			File fPath = new File(dest.getParent());
			if (!fPath.exists()) {
				fPath.mkdirs();
			}
			in = new FileInputStream(src);
			out = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length = -1;
			while ((length = in.read(buffer)) != -1) {
				out.write(buffer, 0, length);
			}
			out.flush();
		} catch (Exception e) {
			throw new MisException(e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	/**
	 * 目录过滤器
	 */
	public static FilenameFilter Dirfilter = new FilenameFilter() {
		public boolean accept(File dir, String name) {
			File file = new File(dir, name);
			return file.isDirectory();
		}
	};

	/**
	 * 文件过滤器
	 */
	public static FilenameFilter Filefilter = new FilenameFilter() {
		public boolean accept(File dir, String name) {
			File file = new File(dir, name);
			return file.isFile();
		}
	};

	// 读取文件内容
	public static String readFileContent(File file) {
		FileReader reader = null;
		BufferedReader br = null;
		String contents = "";
		try {
			if (!file.exists()) {
				FileUtil.makeDirectory(file.getParentFile());
				file.createNewFile();
			}
			reader = new FileReader(file);
			br = new BufferedReader(reader);
			String s1 = null;
			while ((s1 = br.readLine()) != null) {
				contents = contents + s1 + "\r\n";
			}
		} catch (Exception e) {
			throw new MisException(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		return contents;
	}

	/**
	 * 更换扩展名
	 * 
	 * @param file
	 * @return
	 */
	public static File changeExt(File file, String newExt) {
		String fname = "";
		if (file.getParent() != null) {
			fname = file.getParent() + File.separator + trimType(file.getName()) + "." + newExt;
		} else {
			fname = trimType(file.getName()) + "." + newExt;
		}
		return new File(fname);
	}

	public static void saveFileContent(File file, String content) {
		BufferedWriter out = null;
		try {
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			out = new BufferedWriter(new FileWriter(file));
			out.write(content);
		} catch (Exception e) {
			throw new MisException(e);
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	/**
	 * 保存文件内容
	 * 
	 * @作者: 张晓东 @创建日期： 2015年12月7日
	 * 
	 * @param file
	 *            文件
	 * @param content
	 *            文件内容
	 * @param encode
	 *            编码格式
	 * @throws IOException
	 * 			@返回值： void
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public static void saveFileContent(File file, String content, String encode) throws IOException {
		if (!file.exists()) {
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			file.createNewFile();
		}
		BufferedWriter out;
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file), encode);
		out = new BufferedWriter(osw);
		out.write(content);
		out.close();
	}

	/**
	 * 格式化文件路径
	 * 
	 * @作者: 张晓东 @创建日期： 2015年12月7日
	 * 
	 * @param filePath
	 * 			@返回值： String
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public static String formatPath(String filePath) {
		if (StringUtils.isEmpty(filePath)) {
			return filePath;
		}
		// 正则表达式(“/”一个或者多个，“\\”一个或多个),对于“/\”格式需要格式化两次
		filePath = filePath.replaceAll("(/+)|(\\\\+)", "/");
		filePath = filePath.replaceAll("(/+)|(\\\\+)", "/");
		return filePath;
	}

	public static String readFileContent(File file, String encode) {
		try {
			if (!file.exists()) {
				if (!file.getParentFile().exists()) {
					file.getParentFile().mkdirs();
				}
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), encode));
			String s1 = null;
			String contents = "";
			while ((s1 = br.readLine()) != null) {
				contents = contents + s1 + "\r\n";
			}
			br.close();
			return contents;
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 删除文件夹下所有内容，包括此文件夹
	 *
	 * @作者: 张晓东 @创建日期： 2015年12月7日
	 *
	 * @param f
	 *            文件夹
	 * @throws MisException
	 * 			@返回值： void
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	public static boolean delAllByFile(File f) throws MisException {
		if (!f.exists()) {
			// 文件夹不存在不存在
			throw new MisException("指定目录不存在:" + f.getName());
		}

		boolean rslt = true;// 保存中间结果
		if (!(rslt = f.delete())) {// 先尝试直接删除
			// 若文件夹非空。枚举、递归删除里面内容
			File subs[] = f.listFiles();
			for (int i = 0; i <= subs.length - 1; i++) {
				if (subs[i].isDirectory())
					delAllByFile(subs[i]);// 递归删除子文件夹内容
				rslt = subs[i].delete();// 删除子文件夹本身
			}
			rslt = f.delete();// 删除此文件夹本身
		}

		if (!rslt) {
			throw new MisException("无法删除:" + f.getName());
		}
		return true;
	}

	/**
	 * 删除文件或文件夹
	 * 
	 * @作者: 张晓东 @创建日期： 2015年12月7日
	 * 
	 * @param path
	 *            文件夹路劲 @返回值： boolean
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public static boolean delAllByPath(String path) {
		if (path == null) {
			throw new MisException("指定目录为空");
		}
		File file = new File(path);
		return delAllByFile(file);
	}

	/**
	 * 清空指定目录中的文件。 这个方法将尽可能删除所有的文件，但是只要有一个文件没有被删除都会返回false。
	 * 另外这个方法不会迭代删除，即不会删除子目录及其内容。
	 * 
	 * @param directory
	 *            要清空的目录
	 * @return 目录下的所有文件都被成功删除时返回true，否则返回false.
	 * 
	 */
	public static boolean emptyDirectory(File directory) {
		@SuppressWarnings("unused")
		boolean result = false;
		File[] entries = directory.listFiles();
		for (int i = 0; i < entries.length; i++) {
			if (!entries[i].delete()) {
				result = false;
			}
		}
		return true;
	}

	/**
	 * 清空指定目录中的文件。 这个方法将尽可能删除所有的文件，但是只要有一个文件没有被删除都会返回false。
	 * 另外这个方法不会迭代删除，即不会删除子目录及其内容。
	 * 
	 * @param directoryName
	 *            要清空的目录的目录名
	 * @return 目录下的所有文件都被成功删除时返回true，否则返回false。
	 * 
	 */
	public static boolean emptyDirectory(String directoryName) {
		File dir = new File(directoryName);
		return emptyDirectory(dir);
	}

	/**
	 * 根据文件long类型大小的b得到显示的MB,GB和KB方法
	 *
	 * @作者: 张晓东 @创建日期： 2015年12月12日
	 *
	 * @param size
	 * 			@返回值： String
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	public static String convertFileSize(long size) {
		long kb = 1024;
		long mb = kb * 1024;
		long gb = mb * 1024;

		if (size >= gb) {
			return String.format("%.2f GB", (float) size / gb);
		} else if (size >= mb) {
			float f = (float) size / mb;
			return String.format(f > 100 ? "%.0f MB" : "%.1f MB", f);
		} else if (size >= kb) {
			float f = (float) size / kb;
			return String.format(f > 100 ? "%.0f KB" : "%.1f KB", f);
		} else
			return String.format("%d B", size);
	}

	/**
	 * 根据文件路径得到文件大小
	 *
	 * @作者: 张晓东 @创建日期： 2015年12月17日
	 *
	 * @param filePath
	 * 			@返回值： long
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	public static long getFileSize(String filePath) {
		File f = new File(filePath);
		return getFileSize(f);
	}

	/**
	 * 根据文件路径得到文件大小
	 *
	 * @作者: 张晓东 @创建日期： 2015年12月17日
	 *
	 * @param srcFile
	 *            源文件 @返回值： long
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	public static long getFileSize(File srcFile) {
		FileChannel fc = null;// 这种方式比f.length()准确
		FileInputStream fis = null;
		try {
			if (srcFile.exists() && srcFile.isFile()) {
				fis = new FileInputStream(srcFile);
				fc = fis.getChannel();
				return fc.size();
			} else {
				System.out.println("file doesn't exist or is not a file");
				return 0;
			}
		} catch (FileNotFoundException e) {
			throw new MisException("文件未找到");
		} catch (IOException e) {
			throw new MisException("IO异常");
		} finally {
			if (null != fc) {
				try {
					fc.close();
					fis.close();
				} catch (IOException e) {
					throw new MisException("文件流关闭异常");
				}
			}
		}
	}

	//上传图片
		public static Map<String,Object> uploadLogo(MultipartFile multipartFile, String uploadPath, HttpServletRequest request){
			Map<String, Object> resultMap = new HashMap<String, Object>();
			//验证文件是否为空
			if(multipartFile.isEmpty()) throw new RuntimeException("上传文件为空");
			//上传文件名称
			String oldName = multipartFile.getOriginalFilename();
			//判断图片类型
			String extName = oldName.substring(oldName.lastIndexOf("."), oldName.length());
	        String approveExtName = ".jpg.JPG.gif.GIF.png.PNG";
	        if (approveExtName.contains(extName)) {
	        	
	        
			//文件后缀名   转换为小写
			String suffixName = oldName.substring(oldName.lastIndexOf(".")).toLowerCase();
			//文件上传路径
			String path = uploadPath;

			//新文件名称(uuid+后缀名)
			String newName = UUID.randomUUID().toString().replace("-", "").toUpperCase()+suffixName;

			//判断上传路径是不是存在,若不存在,则新建
			File filePath = new File(path);
			if(!filePath.exists()){
				filePath.mkdirs();
			}
			//上传文件路径(路径+newName)
			path += File.separator + newName;
			System.out.println(path);

			File newFIle = new File(path);
			try {//上传
				multipartFile.transferTo(newFIle);
				String md5code = MD5Util.getFileMD5String(newFIle);
				resultMap.put("path", path);
				resultMap.put("oldName", oldName);
				resultMap.put("newName", newName);
				resultMap.put("suffixName", suffixName);
				resultMap.put("md5code", md5code);
				return resultMap;
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("上传失败");
			}
			
	        }throw new RuntimeException("上传文件类型错误");
		}
}
