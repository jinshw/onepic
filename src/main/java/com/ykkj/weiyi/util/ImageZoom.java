package com.ykkj.weiyi.util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageZoom {

	 private String destDir;
	    private ImageSize destImgSize;

	    public ImageZoom()
	    {
	    }

	    /**
	     * 设置目标图片文件的存放目录
	     * @param destDir 缩放后目标图片文件的存放目录
	     */
	    public void setDestDir(String destDir)
	    {
	        this.destDir = destDir;
	    }

	    /**
	     * 获得目标图片文件的存放目录
	     * @return 目标图片文件的存放目录
	     */
	    public String getDestDir()
	    {
	        return this.destDir;
	    }

	    /**
	     * 设置图片缩放的大小
	     * @param imgSize 图片缩放的大小
	     */
	    public void setDestImageSize(ImageSize imgSize)
	    {
	        this.destImgSize = imgSize;
	    }

	    /**
	     * 获得图片缩放的大小
	     * @return 图片缩放的大小
	     */
	    public ImageSize getDestImageSize()
	    {
	        return this.destImgSize;
	    }

	    /**
	     * 图片缩放，如果是gif和png图转换为png图，如果是jpg图转换为jpg。
	     * @param srcImageFile 源图片文件的全路径名
	     * @param destFilePref 目标图片文件的名字（不带扩展名）
	     * @throws java.lang.Exception
	     */
	    public String zoom(String srcImageFile, String destFilePref) throws Exception
	    {
	        String ext = "";
	        String fromdir = "";
	        String imgfile = "";
	        int jpgIndex = -1;
	        int gifIndex = -1;
	        int pngIndex = -1;
	        jpgIndex = srcImageFile.toLowerCase().indexOf(".jpg") > srcImageFile.toLowerCase().indexOf(".jpeg") ? srcImageFile.toLowerCase().indexOf(".jpg") : srcImageFile.toLowerCase().indexOf(".jpeg");
	        gifIndex = srcImageFile.toLowerCase().indexOf(".gif");
	        pngIndex = srcImageFile.toLowerCase().indexOf(".png");
	        //String fileSP = System.getProperty("file.separator");
	        String fileSP=""+File.separatorChar;
	        if (jpgIndex > 0)
	        {
	            fromdir = srcImageFile.substring(0, srcImageFile.lastIndexOf(fileSP));
	            imgfile = srcImageFile.substring(srcImageFile.lastIndexOf(fileSP) + 1);
	            ext = imgfile.substring(imgfile.lastIndexOf(".") + 1);
	        }
	        else if (gifIndex > 0)
	        {
	            fromdir = srcImageFile.substring(0, srcImageFile.lastIndexOf(fileSP));
	            imgfile = srcImageFile.substring(srcImageFile.lastIndexOf(fileSP) + 1);
	            ext = "png";
	        }
	        else if (pngIndex > 0)
	        {
	            fromdir = srcImageFile.substring(0, srcImageFile.lastIndexOf(fileSP));
	            imgfile = srcImageFile.substring(srcImageFile.lastIndexOf(fileSP) + 1);
	            ext = "png";
	        }
	        double heightRatio = 1.0;
	        double widthRatio = 1.0;
	        File srcfile = new File(fromdir, imgfile);
	        if (!srcfile.isFile())
	            throw new Exception(
	                srcfile + " is not image file error in CreateThumbnail!");
	        File destfile = new File(this.destDir, destFilePref + "." + ext);
	        BufferedImage Bi = ImageIO.read(srcfile);
	        if ( (this.destImgSize.getImageHeight() <= 0 ||
	              this.destImgSize.getImageWidth() <= 0))
	        {
	            return null;
	        }
	        else
	        {
	            if(Bi.getHeight() > Bi.getWidth())
	            {
	                heightRatio = (double)this.destImgSize.getImageHeight() / (double)Bi.getHeight();
	                widthRatio = heightRatio;
	            }
	            else
	            {
	                widthRatio = (double)this.destImgSize.getImageWidth() / (double)Bi.getWidth();
	                heightRatio = widthRatio;
	            }
	        }
	        AffineTransformOp op =
	            new AffineTransformOp(
	            AffineTransform.getScaleInstance(heightRatio, widthRatio),
	            null);
	        Image image = op.filter(Bi, null);
	        ImageIO.write( (BufferedImage) image, ext, destfile);
	        return destFilePref + "." + ext;
	    }

	    /**
	     * 图片缩放，如果是gif和png图转换为png图，如果是jpg图转换为jpg。
	     * @param srcImageFile 源图片文件的全路径名
	     * @param destFilePref 目标图片文件的名字（不带扩展名）
	     * @param destDir 目标图片文件的存放路径
	     * @param destImgSize 目标图片文件的大小
	     * @throws java.lang.Exception
	     */
	    public String zoom(String srcImageFile, String destFilePref, String destDir,
	                     ImageSize destImgSize) throws Exception
	    {
	        this.destDir = destDir;
	        this.destImgSize = destImgSize;
	        return zoom(srcImageFile, destFilePref);
	    }

	    /**   
	     * 生成缩略图 ，能够解决像素有问题的图片
	     * @param srcImageFile 源图片文件的File实例.   
	     * @param dstImageFileName 待生成的缩略图片文件名   
	     * @param maxWidth 最大宽度 
	     * @param maxHeight 最大高度 
	     * @param isScale 是否按比例缩放 
	     * @throws Exception   
	     */
		public void makeSmallImage(File srcImageFile, String dstImageFileName,
				int maxWidth, int maxHeight, boolean isScale) {
			FileOutputStream fileOutputStream = null;
			JPEGImageEncoder encoder = null;
			BufferedImage tagImage = null;
			Image srcImage = null;
			try {
				File srcImageFileGood = new File(dstImageFileName);
				JPEGImageDecoder decoder = JPEGCodec
						.createJPEGDecoder(new FileInputStream(srcImageFile));
				BufferedImage image = decoder.decodeAsBufferedImage();
				ImageIO.write(image, "JPEG", srcImageFileGood);

				srcImage = ImageIO.read(srcImageFileGood);
				int srcWidth = srcImage.getWidth(null);// 原图片宽度
				int srcHeight = srcImage.getHeight(null);// 原图片高度
				int dstMaxWidth = maxWidth;// 目标缩略图的最大宽度
				int dstmaxHeight = maxHeight;// 目标缩略图的最大高度
				int dstWidth = srcWidth;// 缩略图宽度
				int dstHeight = srcHeight;// 缩略图高度
				float scale = 0;
				// 计算缩略图的宽和高
				if (isScale) {
					if (srcWidth > maxWidth) {
						dstWidth = dstMaxWidth;
						scale = (float) srcWidth / (float) dstMaxWidth;
						dstHeight = Math.round((float) srcHeight / scale);
					}
					if (dstHeight > maxHeight) {
						dstHeight = maxHeight;
						scale = (float) srcHeight / (float) maxHeight;
						dstWidth = Math.round((float) srcWidth / scale);
					}
				} else {
					dstWidth = maxWidth;
					dstHeight = maxHeight;
				}
				// 生成缩略图
				tagImage = new BufferedImage(dstWidth, dstHeight,
						BufferedImage.TYPE_INT_RGB);
				tagImage.getGraphics().drawImage(
						srcImage.getScaledInstance(dstWidth, dstHeight,
								Image.SCALE_SMOOTH), 0, 0, null);
				fileOutputStream = new FileOutputStream(dstImageFileName);
				encoder = JPEGCodec.createJPEGEncoder(fileOutputStream);
				JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tagImage);  
	            jep.setQuality((float) 1.0, true);  
				encoder.encode(tagImage);
				fileOutputStream.close();
				fileOutputStream = null;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (fileOutputStream != null) {
					try {
						fileOutputStream.close();
					} catch (Exception e) {
					}
					fileOutputStream = null;
				}
				encoder = null;
				tagImage = null;
				srcImage = null;
				System.gc();
			}
		}
		public static void writeJPEG(File source, File dest, int quality) throws IOException
	    {
	        String formatName = "jpeg";
	        BufferedImage image = ImageIO.read(source);
	        //如果图像是透明的，就丢弃Alpha通道
	        if(image.getTransparency() == Transparency.TRANSLUCENT)
	            image = get24BitImage(image);
	            //image = get24BitImage(image, Color.BLACK);
	        ImageWriter writer = ImageIO.getImageWritersByFormatName(formatName).next();
	        ImageWriteParam writeParam = writer.getDefaultWriteParam();
	        FileOutputStream out = new FileOutputStream(dest);
	        writeParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
	        writeParam.setCompressionQuality((float)quality/100f);
	        writer.setOutput(ImageIO.createImageOutputStream(out));
	        writer.write(null, new IIOImage(image, null, null), writeParam);
	        out.flush();
	        out.close();
	        writer.dispose();
	    }

	    /**
	     * 使用删除alpha值的方式去掉图像的alpha通道
	     * @param image
	     * @return
	     */
	    protected static BufferedImage get24BitImage(BufferedImage image)
	    {
	        int w = image.getWidth();
	        int h = image.getHeight();
	        int[] imgARGB = getRGBs(image.getRGB(0, 0, w, h, null, 0, w));
	        BufferedImage newImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	        newImg.setRGB(0, 0, w, h, imgARGB, 0, w);
	        return newImg;
	    }

	    /**
	     * 使用绘制的方式去掉图像的alpha值
	     * @param image
	     * @param bgColor
	     * @return
	     */
	    protected static BufferedImage get24BitImage(BufferedImage image, Color bgColor)
	    {
	        int w = image.getWidth();
	        int h = image.getHeight();
	        BufferedImage bimage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	        Graphics2D graphic = bimage.createGraphics();
	        graphic.setColor(bgColor);
	        graphic.fillRect(0,0,w,h);
	        graphic.drawRenderedImage(image, null);
	        graphic.dispose();
	        return bimage; 
	    }

	    /**
	     * 将32位色彩转换成24位色彩（丢弃Alpha通道）
	     * @param argb
	     * @return
	     */
	    public static int[] getRGBs(int[] argb)
	    {
	        int[] rgbs = new int[argb.length];
	        for(int i=0;i<argb.length;i++)
	        {
	            rgbs[i] = argb[i] & 0xFFFFFF;
	        }
	        return rgbs;
	    }

	   /* public static void main(String args[]) throws Exception
	    {
	        ImageZoom iz = new ImageZoom();
	        ImageSize is = new ImageSize();
	        is.setImageHeight(1024);
	        is.setImageWidth(1024);
	        iz.setDestImageSize(is);
	        iz.makeSmallImage(new File("d:/0.png"), "d:/a.png",500,500,true);
	        //iz.zoom("d:\\a.jpg", "d:\\b.jpg");
	        //iz.makeSmallImage(new File("d:\\c.jpg"), "d:\\d.jpg", 500, 1024, true);
	        //iz.zoom("d:\\e5ef9a80-d984-4319-9363-86b21984a31a.jpeg", "d:\\d.jpg");
	    }*/
	    public static void main(String[] args) throws IOException
	    {
//	        File __pngFile = new File("d:/0.png");
//	        File __jpgFile = new File("d:/a.jpg");
//	        writeJPEG(__pngFile, __jpgFile, 100);
	        ImageZoom iz = new ImageZoom();
	        File f = new File("d:/d.png");
	        
	        File srcImageFileGood = new File("d:/d.jpg");
			JPEGImageDecoder decoder = JPEGCodec
					.createJPEGDecoder(new FileInputStream("d:/d.jpg"));
			BufferedImage image = decoder.decodeAsBufferedImage();
			ImageIO.write(image, "JPEG", srcImageFileGood);

			Image srcImage = ImageIO.read(srcImageFileGood);
			int srcWidth = srcImage.getWidth(null);// 原图片宽度
			int srcHeight = srcImage.getHeight(null);// 原图片高度
			System.out.println(srcHeight+":"+srcWidth);
	        iz.makeSmallImage(new File("d:/d.jpg"), "d:/d.jpg",srcWidth,srcHeight,true);
	    }

}