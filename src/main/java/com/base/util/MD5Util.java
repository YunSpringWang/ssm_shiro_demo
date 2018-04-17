package com.base.util;

import java.security.MessageDigest;

public class MD5Util {
	/* 判断密码是否相等 */
	public static boolean checkPassword(String inputPwd, String dbPwd) throws Exception {
		String result = string2MD5(inputPwd);
		if (result.equals(dbPwd)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Title: MD5加密
	 * 
	 * @param inStr
	 * @return
	 */
	public static String string2MD5(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();

	}

	public static void main(String[] args) {
		String s = new String("test");
		String salt="t";
		try {
			System.out.println("原始：" + s);
			String stringToMD5 = string2MD5(s+salt);
			System.out.println("MD5后：" + stringToMD5);

			System.out.println(checkPassword(s+salt, stringToMD5));

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-----------------------");
	}
}