package com.ykkj.weiyi.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.IOException;

public class ZoomCutImage {
	/**
	 * @param srcImageFile 原图地址
	 * @param savedImagePath 生成图地址
	 * @param x x坐标
	 * @param y y坐标
	 * @param destWidth 裁剪图高
	 * @param destHeight 裁剪图宽
	 * @param finalWidth 缩放宽
	 * @param finalHeight 缩放高
	 */
	 public void zoomcut(String srcImageFile,String savedImagePath, int x, int y, 
			 int destWidth, int destHeight, int finalWidth, int finalHeight) {
        Image img;
        ImageFilter cropFilter;
        // 读取源图像
        BufferedImage bi;
        try {
            bi = ImageIO.read(new File(srcImageFile));
			Image image = bi.getScaledInstance(finalWidth, finalHeight,Image.SCALE_DEFAULT);//获取缩放后的图片大小
			cropFilter = new CropImageFilter(x, y, destWidth, destHeight);
			img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
			BufferedImage tag = new BufferedImage(destWidth, destHeight,BufferedImage.TYPE_INT_RGB);
			// 获取Graphics2D 
			Graphics2D g2d = tag.createGraphics(); 
			if(getExtention(srcImageFile).equalsIgnoreCase("png")){
				// ---------- 增加下面的代码使得背景透明 ----------------- 
				tag = g2d.getDeviceConfiguration().createCompatibleImage(destWidth, destHeight, Transparency.TRANSLUCENT); 
				g2d.dispose(); 
				g2d = tag.createGraphics(); 
				// ---------- 背景透明代码结束 ----------------- 
			}
			// 画图 
			g2d.drawImage(img, 0, 0, null); // 绘制截取后的图
			//释放对象 
			g2d.dispose(); 
			if (makedirs(savedImagePath)) {
				// 输出为文件
				ImageIO.write(tag, getExtention(srcImageFile), new File(savedImagePath));
			}
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
	 /**
     * 功能：提取文件名的后缀
     * 
     * @param fileName
     * @return
     */
    private static  String getExtention(String fileName) {
        int pos = fileName.lastIndexOf(".");
        return fileName.substring(pos + 1);
    }
    
    /**
     * 判断路径目录是否创建，没有时创建它
     * @param filepath
     * @return
     */
	public static boolean makedirs(String filepath) {
		File file = new File(filepath);
		File parentdir = file.getParentFile();
		if (parentdir == null) {
			return false;
		}
		if (parentdir.isDirectory()) {
			return true;
		}
		return parentdir.mkdirs();
	}
    
    public static void main(String[] args) throws IOException {
    	ZoomCutImage o = new ZoomCutImage();
    	String img = "d:/cut/07152641.png";
    	String newimg = "d:/cut/new/07152641.png";
    	BufferedImage bi;
    	bi = ImageIO.read(new File(img));
    	int srcWidth = bi.getWidth(); // 源图宽度
    	int srcHeight = bi.getHeight(); // 源图高度
    	int scalHeight = (700* srcHeight)/srcWidth;
    	int x = 0;
    	int y = (scalHeight-700)/2<0?0:(scalHeight-700)/2;
    	o.zoomcut(img, newimg, x, y, 700, scalHeight>=700?700:scalHeight, 700, scalHeight);
	}
}
