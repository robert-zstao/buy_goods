package com.robert.goods.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

	//固定salt
	private static final String salt = "9z7s2t6";

	private static final char HEX_DIGITS[] = { '0', '1', '2', '3', '4', '5',
			'6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	public static String toHexString(byte[] b) {
		// String to byte
		StringBuilder sb = new StringBuilder(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			sb.append(HEX_DIGITS[(b[i] & 0xf0) >>> 4]);
			sb.append(HEX_DIGITS[b[i] & 0x0f]);
		}
		return sb.toString();
	}

	public static String md5(String str) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(str.getBytes());
	        byte messageDigest[] = digest.digest();
			return toHexString(messageDigest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	// 第一次md5:将原始密码和固定的salt进行加盐md5加密，在浏览器端进行加密
	public static String inputPassToFormPass(String inputPass) {
		String str = ""+salt.charAt(1) + salt.charAt(3) + inputPass + salt.charAt(2) + salt.charAt(4);
		return md5(str);
	}

	// 第二次md5：将第一次的值转为数据库存储，这一次加密每个用户的salt是不一样的
	public static String formPassToDBPass(String formPass, String salt) {
		String str = ""+salt.charAt(1) + salt.charAt(3) + formPass + salt.charAt(2) + salt.charAt(4);
		return md5(str);
	}

	// 执行两次MD5
	public static String inputPassToDbPass(String inputPass, String saltDB) {
		return formPassToDBPass(inputPassToFormPass(inputPass), saltDB);
	}

}
