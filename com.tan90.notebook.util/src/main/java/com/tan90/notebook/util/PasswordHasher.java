package com.tan90.notebook.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {

	private static final String ALGO = "MD5";
	
	
	public static String hash(String password) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance(ALGO);
		messageDigest.update(password.getBytes());
        
        byte byteData[] = messageDigest.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
        	sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
		return sb.toString();
	}
}
