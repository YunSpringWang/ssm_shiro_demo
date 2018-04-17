package com.md5password;

import java.security.MessageDigest;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Md5SaltTool {
	/**
	 * 字节数组转化为16进制字符串
	 * @param bytes
	 * @return
	 */
	public static String bytesToHexString(byte[] bytes) {
		StringBuffer sb = new StringBuffer();
		if (bytes == null || bytes.length <= 0) {
			return null;
		}
		for (int i = 0; i < bytes.length; i++) {
			int temp = bytes[i] & 0xFF;// 与运算，将byte转化为整型
			String hex = Integer.toHexString(temp);// int型转化为16进制字符串
			if (hex.length() < 2) {
				sb.append(0);
			}
			sb.append(hex);
		}
		return sb.toString();
	}
	   public static final String KEY_SHA = "SHA";  
	    public static final String KEY_MD5 = "MD5";  
	   
	    /** 
	     * MAC算法可选以下多种算法 
	     *  
	     * <pre> 
	     * HmacMD5  
	     * HmacSHA1  
	     * HmacSHA256  
	     * HmacSHA384  
	     * HmacSHA512 
	     * </pre> 
	     */  
	    public static final String KEY_MAC = "HmacMD5"; 
	    /** 
	     * MD5加密 
	     *  
	     * @param data 
	     * @return 
	     * @throws Exception 
	     */  
	    public static byte[] encryptMD5(byte[] data) throws Exception {  
	   
	        MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);  
	        md5.update(data);  
	   
	        return md5.digest();  
	   
	    }  
	   
	    /** 
	     * SHA加密 
	     *  
	     * @param data 
	     * @return 
	     * @throws Exception 
	     */  
	    public static byte[] encryptSHA(byte[] data) throws Exception {  
	   
	        MessageDigest sha = MessageDigest.getInstance(KEY_SHA);  
	        sha.update(data);  
	   
	        return sha.digest();  
	    }  
	   
	  
}
