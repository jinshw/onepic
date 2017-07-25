package com.ykkj.weiyi.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class QRCodeGenerator {

	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;

	// 取得矩阵
	private static BitMatrix generateBitMatrix(String text, int width,
			int height, String format) throws WriterException {
		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(text,
				BarcodeFormat.QR_CODE, width, height, hints);
		return bitMatrix;
	}

	// 生成二维码图片
	public static BufferedImage generateBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
			}
		}
		return image;
	}

	// 保存为图片文件
	public static boolean saveFile(String text, int widht, int height,
			String format, File file) throws Exception {
		BufferedImage image = generateBufferedImage(generateBitMatrix(text,
				widht, height, format));
		try {
			return ImageIO.write(image, format, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 保存到输出流中
	public static boolean saveStream(String text, int widht, int height,
			String format, OutputStream stream) throws Exception {
		BufferedImage image = generateBufferedImage(generateBitMatrix(text,
				widht, height, format));
		try {
			return ImageIO.write(image, format, stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
