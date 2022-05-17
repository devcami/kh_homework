package common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;

public class HelloMvcUtils {
	
//	public static void main(String[] args) {
//		수작업바꾸기
//		System.out.println(encrypt("1234", "yoobj"));
//	}
	
	/**
	 * SHA256 | SHA512 (SHA1 또는 MD5는 사용하지 말것)
	 * @param salt 
	 * 
	 * @param parameter
	 * @return
	 */
	public static String encrypt(String password, String salt) {
		// 1. 암호화 (Hashing)
		MessageDigest md = null;
		byte[] encrypted = null;
		try {
			md = MessageDigest.getInstance("SHA-512");
			byte[] input = password.getBytes("utf-8");
			byte[] saltBytes = salt.getBytes("utf-8");
			md.update(saltBytes); //salt값으로 MessageDigest 객체 갱신
			encrypted = md.digest(input); //MessageDigest객체에 raw password 전달 및 hashing
//			System.out.println(new String(encrypted)); 깨진 값 나온다.
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 2. 인코딩 : 단순문자로 변환
		Encoder encoder = Base64.getEncoder();
		return encoder.encodeToString(encrypted);
	}

}
