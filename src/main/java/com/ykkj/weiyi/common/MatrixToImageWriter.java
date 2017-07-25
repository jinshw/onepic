package com.ykkj.weiyi.common;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.google.zxing.common.BitMatrix;

public final class MatrixToImageWriter {
	   
	   private static final int BLACK = 0xFF000000;  
	   private static final int WHITE = 0xFFFFFFFF;  
	   
	   private MatrixToImageWriter() {}  
	   
	     
	   public static BufferedImage toBufferedImage(BitMatrix matrix) {  
	     int width = matrix.getWidth();  
	     int height = matrix.getHeight();  
	     BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
	     for (int x = 0; x < width; x++) {  
	       for (int y = 0; y < height; y++) {  
	         image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);  
	       }  
	     }  
	     return image;  
	   }  
	   
	     
	   public static void writeToFile(BitMatrix matrix, String format, File file) throws IOException {  
		     BufferedImage image = toBufferedImage(matrix);  
		     if (!ImageIO.write(image, format, file)) {  
		       throw new IOException("Could not write an image of format " + format + " to " + file);  
		     }  
	   }  
	   
	     
	   public static void writeToStream(BitMatrix matrix, String format, OutputStream stream) throws IOException {  
		     BufferedImage image = toBufferedImage(matrix);  
		     if (!ImageIO.write(image, format, stream)) {  
		       throw new IOException("Could not write an image of format " + format);  
		     }  
	   }
	   
	   /**
	    * 二维码添加自定义logo（关键部分）
	    */
	   public static void overlapImage(BitMatrix matrix,String format,String imgPath, String logoPath){
		    try{ 
		    	   BufferedImage image = toBufferedImage(matrix);
		           BufferedImage logo = ImageIO.read(new File(logoPath)); 
		           Graphics2D g = image.createGraphics(); 
		           //logo宽高
		           int width=image.getWidth()/5; 
		           int height=image.getHeight()/5;
		           //logo起始位置，此目的是为logo居中显示
		           int x=(image.getWidth()-width)/2;
		           int y=(image.getHeight()-height)/2;
		           g.drawImage(logo, x, y, width, height, null); 
		           g.dispose(); 
		           ImageIO.write(image,format, new File(imgPath)); 
		        }catch (Exception e) { 
		           e.printStackTrace(); 
		        } 
	   }
	   
	
}
