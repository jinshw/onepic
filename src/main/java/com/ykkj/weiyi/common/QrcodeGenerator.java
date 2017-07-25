package com.ykkj.weiyi.common;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QrcodeGenerator {
	private static final String CODE = "utf-8";
	private static final int BLACK = 0xff000000;
	private static final int WHITE = 0xFFFFFFFF;

	/**
	 * 生成200*200 png格式二维码
	 * 
	 * @param content
	 *            二维码网址
	 * @param qrcodeDir
	 *            生成图片存放地址
	 * @param fileName
	 *            图片名
	 * @return 生成图片路径
	 * @throws Exception
	 */
	public static String defaultGenerator(String content, String qrcodeDir,
			String fileName) throws Exception {
		// 二维码的图片格式
		String format = "png";
		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
		// 指定纠错等级 H = ~30% correction\Q = ~25% correction\M = ~15% correction\ L
		// = ~7% correction
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		// 内容所使用编码
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		// 设置白色边框区域的大小
		hints.put(EncodeHintType.MARGIN, 0);// 必须是大于等于0的数

		BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
				BarcodeFormat.QR_CODE, 280, 280, hints);

		// 生成二维码
		String outputPath = qrcodeDir + "/" + fileName;
		File outputFile = new File(outputPath);
		MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile); // 生成正常二维码
		return outputPath;
	}

	/**
	 * 
	 * @param content
	 *            二维码网址
	 * @param width
	 *            二维码 宽
	 * @param height
	 *            二维码高
	 * @param qrcodeDir
	 *            二维码存放地址
	 * @param format
	 *            二维码格式
	 * @param logoPath
	 *            网址logo
	 * @return
	 * @throws Exception
	 */
	public static String generator(String content, Integer width,
			Integer height, String qrcodeDir, String format, String logoPath)
			throws Exception {

		// 二维码的图片格式
		if (StringUtils.isNotBlank(format)) {
			format = "png";// //gif、png
		}
		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
		// 指定纠错等级 H = ~30% correction\Q = ~25% correction\M = ~15% correction\ L
		// = ~7% correction
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		// 内容所使用编码
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		// 设置白色边框区域的大小
		hints.put(EncodeHintType.MARGIN, 0);// 必须是大于等于0的数

		BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
				BarcodeFormat.QR_CODE, width, height, hints);

		// 生成二维码
		String outputPath = qrcodeDir + "/" + System.currentTimeMillis() + "."
				+ format;
		File outputFile = new File(outputPath);
		if (StringUtils.isNotBlank(logoPath)) {
			MatrixToImageWriter.overlapImage(bitMatrix, format, outputPath,
					logoPath);// 生成带logo的二维码
		} else {
			MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile); // 生成正常二维码
		}
		return outputPath;
	}

	/**
	 * 生成一维码（128）
	 * 
	 * @author wuhongbo
	 * @param str
	 * @param width
	 * @param height
	 * @return
	 */
	public static BufferedImage getBarcode(String str, Integer width,
			Integer height) {

		if (width == null || width < 200) {
			width = 200;
		}

		if (height == null || height < 50) {
			height = 50;
		}

		try {
			// 文字编码
			Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
			hints.put(EncodeHintType.CHARACTER_SET, CODE);

			BitMatrix bitMatrix = new MultiFormatWriter().encode(str,
					BarcodeFormat.CODE_128, width, height, hints);

			return toBufferedImage(bitMatrix);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 生成一维码，写到文件中
	 * 
	 * @author wuhongbo
	 * @param str
	 * @param height
	 * @param file
	 * @throws IOException
	 */
	public static void getBarcodeWriteFile(String str, Integer width,
			Integer height, File file) throws IOException {
		BufferedImage image = getBarcode(str, width, height);
		ImageIO.write(image, "png", file);
	}

	/**
	 * 转换成图片
	 * 
	 * @author wuhongbo
	 * @param matrix
	 * @return
	 */
	private static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
			}
		}
		return image;
	}
}
