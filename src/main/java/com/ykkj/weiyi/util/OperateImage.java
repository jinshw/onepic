package com.ykkj.weiyi.util;

import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * 处理图片裁剪,Base64编码转换图片
 * 
 * @author hxl Date:2015-04-22
 */
public class OperateImage {
	public static boolean GenerateImage(String imgStr,String imgFilePath){
		 //对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) //图像数据为空
			return false;
	    imgStr = imgStr.substring(imgStr.lastIndexOf(",")+1, imgStr.length());
	    BASE64Decoder decoder = new BASE64Decoder();
	    FileOutputStream write = null;
	    try{
	    	write = new FileOutputStream(new File(imgFilePath));
	    	byte[] decoderBytes = decoder.decodeBuffer(imgStr);
	    	write.write(decoderBytes);
	    	write.close();
	        return true;
        }catch (Exception e) {
        	return false;
        }finally{
    		if (write != null){
				try {
					write.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	    	}
	    }
	}

	// ===源图片路径名称如：c:\1.jpg
	private String srcpath;

	// ===剪切图片存放路径名称。如：c:\2.jpg
	private String subpath;

	// ===剪切点x坐标

	private int x;

	private int y;

	// ===剪切点宽度

	private int width;

	private int height;

	public OperateImage() {

	}

	public OperateImage(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * 
	 * 对图片裁剪，并把裁剪完的新图片保存 。
	 * 
	 */
	public void cut() throws IOException {
		FileInputStream is = null;
		ImageInputStream iis = null;
		try {
			// 读取图片文件
			is = new FileInputStream(srcpath);
			String formatName="jpg";
			int index=srcpath.lastIndexOf(".");
			if(index>0){
				formatName=srcpath.substring(index+1, srcpath.length()).toLowerCase();
			}
			
			/**
			 * 
			 * 返回包含所有当前已注册 ImageReader 的 Iterator，这些 ImageReader
			 * 
			 * 声称能够解码指定格式。 参数：formatName - 包含非正式格式名称 .
			 * 
			 * (例如 "jpeg" 或 "tiff")等 。
			 * 
			 */
			Iterator<ImageReader> it = ImageIO
					.getImageReadersByFormatName(formatName);
			ImageReader reader = it.next();
			// 获取图片流
			iis = ImageIO.createImageInputStream(is);
			/**
			 * 
			 * <p>
			 * iis:读取源。true:只向前搜索
			 * </p>
			 * .将它标记为 ‘只向前搜索’。
			 * 
			 * 此设置意味着包含在输入源中的图像将只按顺序读取，可能允许 reader
			 * 
			 * 避免缓存包含与以前已经读取的图像关联的数据的那些输入部分。
			 * 
			 */
			reader.setInput(iis, true);
			/**
			 * 
			 * <p>
			 * 描述如何对流进行解码的类
			 * <p>
			 * .用于指定如何在输入时从 Java Image I/O
			 * 
			 * 框架的上下文中的流转换一幅图像或一组图像。用于特定图像格式的插件
			 * 
			 * 将从其 ImageReader 实现的 getDefaultReadParam 方法中返回
			 * 
			 * ImageReadParam 的实例。
			 * 
			 */
			ImageReadParam param = reader.getDefaultReadParam();
			/**
			 * 
			 * 图片裁剪区域。Rectangle 指定了坐标空间中的一个区域，通过 Rectangle 对象
			 * 
			 * 的左上顶点的坐标(x，y)、宽度和高度可以定义这个区域。
			 * 
			 */
			Rectangle rect = new Rectangle(x, y, width, height);
			// 提供一个 BufferedImage，将其用作解码像素数据的目标。
			param.setSourceRegion(rect);
			/**
			 * 
			 * 使用所提供的 ImageReadParam 读取通过索引 imageIndex 指定的对象，并将
			 * 
			 * 它作为一个完整的 BufferedImage 返回。
			 * 
			 */
			BufferedImage bi = reader.read(0, param);
			// 保存新图片
			ImageIO.write(bi, formatName, new File(subpath));
		} finally {
			if (is != null)
				is.close();
			if (iis != null)
				iis.close();
		}
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public String getSrcpath() {
		return srcpath;
	}

	public void setSrcpath(String srcpath) {
		this.srcpath = srcpath;
	}

	public String getSubpath() {
		return subpath;
	}

	public void setSubpath(String subpath) {
		this.subpath = subpath;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public static void main(String[] args) throws Exception {
		 
        String name = "d:\\iconpng.png";
 
        OperateImage o = new OperateImage();
 
        o.setSrcpath(name);
 
        o.setSubpath("D:\\2.png");
 
        o.cut();
       
 
    }
	
}
