package com.ykkj.weiyi.util;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * *关于小数组快10倍(10 - 1000字节)和2 - 3倍 大数组相比(10000 - 1000000字节) <代码>
 * sun.misc.Encoder()/解码器()< /代码>
 * 
 * @version 2.2
 * @author 张晓东
 */

public class Base64 {
	private static final char[] CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
	private static final int[] IA = new int[256];
	static {
		Arrays.fill(IA, -1);
		for (int i = 0, iS = CA.length; i < iS; i++)
			IA[CA[i]] = i;
		IA['='] = 0;
	}

	// ****************************************************************************************
	// * char[] version
	// ****************************************************************************************

	/**
	 * 原始字节数组编码为BASE64 表示
	 * 
	 * @参数 sArr
	 *            转换的字节，如果空或长度为0将返回空数组。
	 * @参数 lineSep
	 *            可选“76个字符\ r \ n”后,除非文件结束。没有行分隔符将违反RFC 2045，指定每行最大步数76但会快一点。
	 * @return BASE64编码字符数组
	 */
	public final static char[] encodeToChar(byte[] sArr, boolean lineSep) {
		//检查特殊字符转换
		int sLen = sArr != null ? sArr.length : 0;
		if (sLen == 0)
			return new char[0];

		int eLen = (sLen / 3) * 3; //至少24-bits.
		int cCnt = ((sLen - 1) / 3 + 1) << 2; //返回字符数
		int dLen = cCnt + (lineSep ? (cCnt - 1) / 76 << 1 : 0); //返回字符数组长度
		char[] dArr = new char[dLen];

		//加密24-bits
		for (int s = 0, d = 0, cc = 0; s < eLen;) {
			//下三个字节复制到低24位的int,
			//签字
			int i = (sArr[s++] & 0xff) << 16 | (sArr[s++] & 0xff) << 8 | (sArr[s++] & 0xff);

			//解密，以四个字符为主
			dArr[d++] = CA[(i >>> 18) & 0x3f];
			dArr[d++] = CA[(i >>> 12) & 0x3f];
			dArr[d++] = CA[(i >>> 6) & 0x3f];
			dArr[d++] = CA[i & 0x3f];

			//添加特殊行分隔符
			if (lineSep && ++cc == 19 && d < dLen - 2) {
				dArr[d++] = '\r';
				dArr[d++] = '\n';
				cc = 0;
			}
		}

		//判断最后剩下的字符是不是 24 bits.
		int left = sLen - eLen; // 0 - 2.
		if (left > 0) {
			
			int i = ((sArr[eLen] & 0xff) << 10) | (left == 2 ? ((sArr[sLen - 1] & 0xff) << 2) : 0);

			//设置最后四个字符
			dArr[dLen - 4] = CA[i >> 12];
			dArr[dLen - 3] = CA[(i >>> 6) & 0x3f];
			dArr[dLen - 2] = left == 2 ? CA[i & 0x3f] : '=';
			dArr[dLen - 1] = '=';
		}
		return dArr;
	}

	/** */
	/**
	 * 解密一个64位编码的字符数组
	 * 
	 * @参数 sArr 源数组中空或长度将返回一个0或空数组
	 * @return 解密过得字节数组
	 */
	public final static byte[] decode(char[] sArr) {
		//检查特殊字符
		int sLen = sArr != null ? sArr.length : 0;
		if (sLen == 0)
			return new byte[0];

		//计数非法字符(包括“\ r”、“\ n”)知道返回的数组大小,所以我们不需要重新分配和复制。
		int sepCnt = 0; // Number of separator characters. (Actually illegal
						// characters, but that's a bonus)
		for (int i = 0; i < sLen; i++)
			// If input is "pure" (I.e. no line separators or illegal chars)
			// base64 this loop can be commented out.
			if (IA[sArr[i]] < 0)
				sepCnt++;

		// Check so that legal chars (including '=') are evenly divideable by 4
		// as specified in RFC 2045.
		if ((sLen - sepCnt) % 4 != 0)
			return null;

		int pad = 0;
		for (int i = sLen; i > 1 && IA[sArr[--i]] <= 0;)
			if (sArr[i] == '=')
				pad++;

		int len = ((sLen - sepCnt) * 6 >> 3) - pad;

		byte[] dArr = new byte[len]; // Preallocate byte[] of exact length

		for (int s = 0, d = 0; d < len;) {
			// Assemble three bytes into an int from four "valid" characters.
			int i = 0;
			for (int j = 0; j < 4; j++) { // j only increased if a valid char
											// was found.
				int c = IA[sArr[s++]];
				if (c >= 0)
					i |= c << (18 - j * 6);
				else
					j--;
			}
			// Add the bytes
			dArr[d++] = (byte) (i >> 16);
			if (d < len) {
				dArr[d++] = (byte) (i >> 8);
				if (d < len)
					dArr[d++] = (byte) i;
			}
		}
		return dArr;
	}

	/** */
	/**
	 * Decodes a BASE64 encoded char array that is known to be resonably well
	 * formatted. The method is about twice as fast as {@link #decode(char[])}.
	 * The preconditions are:<br>
	 * + The array must have a line length of 76 chars OR no line separators at
	 * all (one line).<br>
	 * + Line separator must be "\r\n", as specified in RFC 2045 + The array
	 * must not contain illegal characters within the encoded string<br>
	 * + The array CAN have illegal characters at the beginning and end, those
	 * will be dealt with appropriately.<br>
	 * 
	 * @参数 sArr
	 *            The source array. Length 0 will return an empty array.
	 *            <code>null</code> will throw an exception.
	 * @return The decoded array of bytes. May be of length 0.
	 */
	public final static byte[] decodeFast(char[] sArr) {
		// Check special case
		int sLen = sArr.length;
		if (sLen == 0)
			return new byte[0];

		int sIx = 0, eIx = sLen - 1; // Start and end index after trimming.

		// Trim illegal chars from start
		while (sIx < eIx && IA[sArr[sIx]] < 0)
			sIx++;

		// Trim illegal chars from end
		while (eIx > 0 && IA[sArr[eIx]] < 0)
			eIx--;

		// get the padding count (=) (0, 1 or 2)
		int pad = sArr[eIx] == '=' ? (sArr[eIx - 1] == '=' ? 2 : 1) : 0; // Count
																			// '='
																			// at
																			// end.
		int cCnt = eIx - sIx + 1; // Content count including possible
									// separators
		int sepCnt = sLen > 76 ? (sArr[76] == '\r' ? cCnt / 78 : 0) << 1 : 0;

		int len = ((cCnt - sepCnt) * 6 >> 3) - pad; // The number of decoded
													// bytes
		byte[] dArr = new byte[len]; // Preallocate byte[] of exact length

		// Decode all but the last 0 - 2 bytes.
		int d = 0;
		for (int cc = 0, eLen = (len / 3) * 3; d < eLen;) {
			// Assemble three bytes into an int from four "valid" characters.
			int i = IA[sArr[sIx++]] << 18 | IA[sArr[sIx++]] << 12 | IA[sArr[sIx++]] << 6 | IA[sArr[sIx++]];

			// Add the bytes
			dArr[d++] = (byte) (i >> 16);
			dArr[d++] = (byte) (i >> 8);
			dArr[d++] = (byte) i;

			// If line separator, jump over it.
			if (sepCnt > 0 && ++cc == 19) {
				sIx += 2;
				cc = 0;
			}
		}

		if (d < len) {
			// Decode last 1-3 bytes (incl '=') into 1-3 bytes
			int i = 0;
			for (int j = 0; sIx <= eIx - pad; j++)
				i |= IA[sArr[sIx++]] << (18 - j * 6);

			for (int r = 16; d < len; r -= 8)
				dArr[d++] = (byte) (i >> r);
		}

		return dArr;
	}

	// ****************************************************************************************
	// * byte[] version
	// ****************************************************************************************

	/** */
	/**
	 * Encodes a raw byte array into a BASE64 <code>byte[]</code> representation
	 * i accordance with RFC 2045.
	 * 
	 * @参数 sArr
	 *            The bytes to convert. If <code>null</code> or length 0 an
	 *            empty array will be returned.
	 * @参数 lineSep
	 *            Optional "\r\n" after 76 characters, unless end of file.<br>
	 *            No line separator will be in breach of RFC 2045 which
	 *            specifies max 76 per line but will be a little faster.
	 * @return A BASE64 encoded array. Never <code>null</code>.
	 */
	public final static byte[] encodeToByte(byte[] sArr, boolean lineSep) {
		// Check special case
		int sLen = sArr != null ? sArr.length : 0;
		if (sLen == 0)
			return new byte[0];

		int eLen = (sLen / 3) * 3; // Length of even 24-bits.
		int cCnt = ((sLen - 1) / 3 + 1) << 2; // Returned character count
		int dLen = cCnt + (lineSep ? (cCnt - 1) / 76 << 1 : 0); // Length of
																// returned
																// array
		byte[] dArr = new byte[dLen];

		// Encode even 24-bits
		for (int s = 0, d = 0, cc = 0; s < eLen;) {
			// Copy next three bytes into lower 24 bits of int, paying attension
			// to sign.
			int i = (sArr[s++] & 0xff) << 16 | (sArr[s++] & 0xff) << 8 | (sArr[s++] & 0xff);

			// Encode the int into four chars
			dArr[d++] = (byte) CA[(i >>> 18) & 0x3f];
			dArr[d++] = (byte) CA[(i >>> 12) & 0x3f];
			dArr[d++] = (byte) CA[(i >>> 6) & 0x3f];
			dArr[d++] = (byte) CA[i & 0x3f];

			// Add optional line separator
			if (lineSep && ++cc == 19 && d < dLen - 2) {
				dArr[d++] = '\r';
				dArr[d++] = '\n';
				cc = 0;
			}
		}

		// Pad and encode last bits if source isn't an even 24 bits.
		int left = sLen - eLen; // 0 - 2.
		if (left > 0) {
			// Prepare the int
			int i = ((sArr[eLen] & 0xff) << 10) | (left == 2 ? ((sArr[sLen - 1] & 0xff) << 2) : 0);

			// Set last four chars
			dArr[dLen - 4] = (byte) CA[i >> 12];
			dArr[dLen - 3] = (byte) CA[(i >>> 6) & 0x3f];
			dArr[dLen - 2] = left == 2 ? (byte) CA[i & 0x3f] : (byte) '=';
			dArr[dLen - 1] = '=';
		}
		return dArr;
	}

	/** */
	/**
	 * Decodes a BASE64 encoded byte array. All illegal characters will be
	 * ignored and can handle both arrays with and without line separators.
	 * 
	 * @参数 sArr
	 *            The source array. Length 0 will return an empty array.
	 *            <code>null</code> will throw an exception.
	 * @return The decoded array of bytes. May be of length 0. Will be
	 *         <code>null</code> if the legal characters (including '=') isn't
	 *         divideable by 4. (I.e. definitely corrupted).
	 */
	public final static byte[] decode(byte[] sArr) {
		// Check special case
		int sLen = sArr.length;

		// Count illegal characters (including '\r', '\n') to know what size the
		// returned array will be,
		// so we don't have to reallocate & copy it later.
		int sepCnt = 0; // Number of separator characters. (Actually illegal
						// characters, but that's a bonus)
		for (int i = 0; i < sLen; i++)
			// If input is "pure" (I.e. no line separators or illegal chars)
			// base64 this loop can be commented out.
			if (IA[sArr[i] & 0xff] < 0)
				sepCnt++;

		// Check so that legal chars (including '=') are evenly divideable by 4
		// as specified in RFC 2045.
		if ((sLen - sepCnt) % 4 != 0)
			return null;

		int pad = 0;
		for (int i = sLen; i > 1 && IA[sArr[--i] & 0xff] <= 0;)
			if (sArr[i] == '=')
				pad++;

		int len = ((sLen - sepCnt) * 6 >> 3) - pad;

		byte[] dArr = new byte[len]; // Preallocate byte[] of exact length

		for (int s = 0, d = 0; d < len;) {
			// Assemble three bytes into an int from four "valid" characters.
			int i = 0;
			for (int j = 0; j < 4; j++) { // j only increased if a valid char
											// was found.
				int c = IA[sArr[s++] & 0xff];
				if (c >= 0)
					i |= c << (18 - j * 6);
				else
					j--;
			}

			// Add the bytes
			dArr[d++] = (byte) (i >> 16);
			if (d < len) {
				dArr[d++] = (byte) (i >> 8);
				if (d < len)
					dArr[d++] = (byte) i;
			}
		}

		return dArr;
	}

	/** */
	/**
	 * Decodes a BASE64 encoded byte array that is known to be resonably well
	 * formatted. The method is about twice as fast as {@link #decode(byte[])}.
	 * The preconditions are:<br>
	 * + The array must have a line length of 76 chars OR no line separators at
	 * all (one line).<br>
	 * + Line separator must be "\r\n", as specified in RFC 2045 + The array
	 * must not contain illegal characters within the encoded string<br>
	 * + The array CAN have illegal characters at the beginning and end, those
	 * will be dealt with appropriately.<br>
	 * 
	 * @参数 sArr
	 *            The source array. Length 0 will return an empty array.
	 *            <code>null</code> will throw an exception.
	 * @return The decoded array of bytes. May be of length 0.
	 */
	public final static byte[] decodeFast(byte[] sArr) {
		// Check special case
		int sLen = sArr.length;
		if (sLen == 0)
			return new byte[0];

		int sIx = 0, eIx = sLen - 1; // Start and end index after trimming.

		// Trim illegal chars from start
		while (sIx < eIx && IA[sArr[sIx] & 0xff] < 0)
			sIx++;

		// Trim illegal chars from end
		while (eIx > 0 && IA[sArr[eIx] & 0xff] < 0)
			eIx--;

		// get the padding count (=) (0, 1 or 2)
		int pad = sArr[eIx] == '=' ? (sArr[eIx - 1] == '=' ? 2 : 1) : 0; // Count
																			// '='
																			// at
																			// end.
		int cCnt = eIx - sIx + 1; // Content count including possible
									// separators
		int sepCnt = sLen > 76 ? (sArr[76] == '\r' ? cCnt / 78 : 0) << 1 : 0;

		int len = ((cCnt - sepCnt) * 6 >> 3) - pad; // The number of decoded
													// bytes
		byte[] dArr = new byte[len]; // Preallocate byte[] of exact length

		// Decode all but the last 0 - 2 bytes.
		int d = 0;
		for (int cc = 0, eLen = (len / 3) * 3; d < eLen;) {
			// Assemble three bytes into an int from four "valid" characters.
			int i = IA[sArr[sIx++]] << 18 | IA[sArr[sIx++]] << 12 | IA[sArr[sIx++]] << 6 | IA[sArr[sIx++]];

			// Add the bytes
			dArr[d++] = (byte) (i >> 16);
			dArr[d++] = (byte) (i >> 8);
			dArr[d++] = (byte) i;

			// If line separator, jump over it.
			if (sepCnt > 0 && ++cc == 19) {
				sIx += 2;
				cc = 0;
			}
		}

		if (d < len) {
			// Decode last 1-3 bytes (incl '=') into 1-3 bytes
			int i = 0;
			for (int j = 0; sIx <= eIx - pad; j++)
				i |= IA[sArr[sIx++]] << (18 - j * 6);

			for (int r = 16; d < len; r -= 8)
				dArr[d++] = (byte) (i >> r);
		}

		return dArr;
	}

	// ****************************************************************************************
	// * String version
	// ****************************************************************************************

	/** */
	/**
	 * Encodes a raw byte array into a BASE64 <code>String</code> representation
	 * i accordance with RFC 2045.
	 * 
	 * @参数 sArr
	 *            The bytes to convert. If <code>null</code> or length 0 an
	 *            empty array will be returned.
	 * @参数 lineSep
	 *            Optional "\r\n" after 76 characters, unless end of file.<br>
	 *            No line separator will be in breach of RFC 2045 which
	 *            specifies max 76 per line but will be a little faster.
	 * @return A BASE64 encoded array. Never <code>null</code>.
	 */
	public final static String encodeToString(byte[] sArr, boolean lineSep) {
		// Reuse char[] since we can't create a String incrementally anyway and
		// StringBuffer/Builder would be slower.
		return new String(encodeToChar(sArr, lineSep));
	}

	public final static String encode(String s) {
		// Reuse char[] since we can't create a String incrementally anyway and
		// StringBuffer/Builder would be slower.
		if (s == null) {
			return null;
		}
		try {
			return new String(encodeToChar(s.getBytes("UTF-8"), false));
		} catch (UnsupportedEncodingException e) {
			System.err.println("Base64 encoding error: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	/** */
	/**
	 * Decodes a BASE64 encoded <code>String</code>. All illegal characters will
	 * be ignored and can handle both strings with and without line separators.<br>
	 * <b>Note!</b> It can be up to about 2x the speed to call
	 * <code>decode(str.toCharArray())</code> instead. That will create a
	 * temporary array though. This version will use <code>str.charAt(i)</code>
	 * to iterate the string.
	 * 
	 * @参数 str
	 *            The source string. <code>null</code> or length 0 will return
	 *            an empty array.
	 * @return The decoded array of bytes. May be of length 0. Will be
	 *         <code>null</code> if the legal characters (including '=') isn't
	 *         divideable by 4. (I.e. definitely corrupted).
	 */
	public final static byte[] decode(String str, boolean used) {
		// Check special case
		int sLen = str != null ? str.length() : 0;
		if (sLen == 0)
			return new byte[0];

		// Count illegal characters (including '\r', '\n') to know what size the
		// returned array will be,
		// so we don't have to reallocate & copy it later.
		int sepCnt = 0; // Number of separator characters. (Actually illegal
						// characters, but that's a bonus)
		for (int i = 0; i < sLen; i++)
			// If input is "pure" (I.e. no line separators or illegal chars)
			// base64 this loop can be commented out.
			if (IA[str.charAt(i)] < 0)
				sepCnt++;

		// Check so that legal chars (including '=') are evenly divideable by 4
		// as specified in RFC 2045.
		if ((sLen - sepCnt) % 4 != 0)
			return null;

		// Count '=' at end
		int pad = 0;
		for (int i = sLen; i > 1 && IA[str.charAt(--i)] <= 0;)
			if (str.charAt(i) == '=')
				pad++;

		int len = ((sLen - sepCnt) * 6 >> 3) - pad;

		byte[] dArr = new byte[len]; // Preallocate byte[] of exact length

		for (int s = 0, d = 0; d < len;) {
			// Assemble three bytes into an int from four "valid" characters.
			int i = 0;
			for (int j = 0; j < 4; j++) { // j only increased if a valid char
											// was found.
				int c = IA[str.charAt(s++)];
				if (c >= 0)
					i |= c << (18 - j * 6);
				else
					j--;
			}
			// Add the bytes
			dArr[d++] = (byte) (i >> 16);
			if (d < len) {
				dArr[d++] = (byte) (i >> 8);
				if (d < len)
					dArr[d++] = (byte) i;
			}
		}
		return dArr;
	}

	/** */
	/**
	 * Decodes a BASE64 encoded string that is known to be resonably well
	 * formatted. The method is about twice as fast as {@link #decode(String)}.
	 * The preconditions are:<br>
	 * + The array must have a line length of 76 chars OR no line separators at
	 * all (one line).<br>
	 * + Line separator must be "\r\n", as specified in RFC 2045 + The array
	 * must not contain illegal characters within the encoded string<br>
	 * + The array CAN have illegal characters at the beginning and end, those
	 * will be dealt with appropriately.<br>
	 * 
	 * @参数 s
	 *            The source string. Length 0 will return an empty array.
	 *            <code>null</code> will throw an exception.
	 * @return The decoded array of bytes. May be of length 0.
	 */
	public final static byte[] decodeFast(String s) {
		// Check special case
		int sLen = s.length();
		if (sLen == 0)
			return new byte[0];

		int sIx = 0, eIx = sLen - 1; // Start and end index after trimming.

		// Trim illegal chars from start
		while (sIx < eIx && IA[s.charAt(sIx) & 0xff] < 0)
			sIx++;

		// Trim illegal chars from end
		while (eIx > 0 && IA[s.charAt(eIx) & 0xff] < 0)
			eIx--;

		// get the padding count (=) (0, 1 or 2)
		int pad = s.charAt(eIx) == '=' ? (s.charAt(eIx - 1) == '=' ? 2 : 1) : 0; // Count
																					// '='
																					// at
																					// end.
		int cCnt = eIx - sIx + 1; // Content count including possible
									// separators
		int sepCnt = sLen > 76 ? (s.charAt(76) == '\r' ? cCnt / 78 : 0) << 1 : 0;

		int len = ((cCnt - sepCnt) * 6 >> 3) - pad; // The number of decoded
													// bytes
		byte[] dArr = new byte[len]; // Preallocate byte[] of exact length

		// Decode all but the last 0 - 2 bytes.
		int d = 0;
		for (int cc = 0, eLen = (len / 3) * 3; d < eLen;) {
			// Assemble three bytes into an int from four "valid" characters.
			int i = IA[s.charAt(sIx++)] << 18 | IA[s.charAt(sIx++)] << 12 | IA[s.charAt(sIx++)] << 6 | IA[s.charAt(sIx++)];

			// Add the bytes
			dArr[d++] = (byte) (i >> 16);
			dArr[d++] = (byte) (i >> 8);
			dArr[d++] = (byte) i;

			// If line separator, jump over it.
			if (sepCnt > 0 && ++cc == 19) {
				sIx += 2;
				cc = 0;
			}
		}

		if (d < len) {
			// Decode last 1-3 bytes (incl '=') into 1-3 bytes
			int i = 0;
			for (int j = 0; sIx <= eIx - pad; j++)
				i |= IA[s.charAt(sIx++)] << (18 - j * 6);

			for (int r = 16; d < len; r -= 8)
				dArr[d++] = (byte) (i >> r);
		}

		return dArr;
	}

	public static String decode(String s) {
		if (s == null) {
			return null;
		} else {
			try {
				return new String(Base64.decodeFast(s), "UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
				return s;
			}
		}
	}

	public static String decode_eps(String s) {
		return decode(s.replaceAll("_", "\\+"));
	}

	public static String encode_eps(String s) {
		return encode(s).replaceAll("\\+", "_");
	}

	/**
	 * base64加密解密主方法测试
	 * 
	 * @修改记录（修改时间、作者、原因）：
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		String pass = "测试密码cs2015年0615192907";
		String encodePass = Base64.encode_eps(pass);//加密

		System.out.println("原始字节为：" + new String(encodeToChar(pass.getBytes("UTF-8"), false)).toString());
		System.out.println("原始密码为：" + pass);
		System.out.println("'测试密码cs2015年0615192907'处理加密后：" + encodePass);
		System.out.println("'测试密码cs2015年0615192907'解密后：" + Base64.decode_eps(encodePass));
		System.out.println("解密测试结果：" + pass.equals(Base64.decode_eps("5rWL6K_V5a_G56CBY3MyMDE15bm0MDYxNTE5MjkwNw==")));
	}
}
