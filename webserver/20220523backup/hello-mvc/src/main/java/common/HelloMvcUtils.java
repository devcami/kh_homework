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

	/**
	 * 
	 * @param cPage
	 * @param numPerPage 10
	 * @param totalContents 116
	 * @param url /mvc/admin/memberList
	 * @return
	 * 
	 * 1 2 3 4 5 	/pagebarStart = 1 , pagebarEnd = 5
	 * 6 7 8 9 10 	/pagebarStart = 6 , pagebarEnd = 10
	 * 11 12 		/pagebarStart = 11 , pagebarEnd = 12
	 * 
	 * <a href='/mvc/admin/memberList?cPage=1'>1</a>
	 * <a href='/mvc/admin/memberList?cPage=2'>2</a>
	 * <a href='/mvc/admin/memberList?cPage=3'>3</a>
	 * <a href='/mvc/admin/memberList?cPage=4'>4</a>
	 * <span class='cPage'>5</span>
	 * <a href='/mvc/admin/memberList?cPage=6'>next</a>
	 */
	public static String getPagebar(int cPage, int numPerPage, int totalContents, String url) {
		StringBuilder pagebar = new StringBuilder();
		int totalPages = (int) Math.ceil((double) totalContents / numPerPage); // 10.1, 10.0 을 분기 : 1 ~ 12
		int pagebarSize = 5; // 1~5 6~10 ..
		int pagebarStart = ((cPage - 1) / pagebarSize) * pagebarSize + 1; // 1, 6, 11
		int pagebarEnd = pagebarStart + pagebarSize - 1; // 5, 10, 12 ..
		int pageNo = pagebarStart;
		
		url += "?cPage="; 
	
		// 이전 prev 영역
		if(pageNo == 1) {
			// prev 버튼 비활성화
		}
		else {
			// prev 버튼 활성화
			pagebar.append("<a href='" + url + (pageNo - 1) + "'>prev</a>"); // 5 or 10
			pagebar.append("\n");
		}
		
		// 페이지 번호 영역
		while(pageNo <= pagebarEnd && pageNo <= totalPages) { // pageNo <= 15 && pageNo <= 12 마지막 페이지를 위해
			if(pageNo == cPage) {
				// 현재 페이지인 경우
				pagebar.append("<span class='cPage'>" + pageNo + "</span>");
				pagebar.append("\n");
			}
			else {
				// 현재 페이지가 아닌 경우(링크필요)
				pagebar.append("<a href='" + url + pageNo + "'>" + pageNo + "</a>"); // /mvc/admin/memberList?cPage=2,3,4,5 로 이동하는 a tag
				pagebar.append("\n");
			}
			pageNo++; 
		}
		
		// 다음 next 영역
		if(pageNo > totalPages) {
			
		}
		else {
			pagebar.append("<a href='" + url + pageNo + "'>next</a>");
			pagebar.append("\n");
		}
		
		return pagebar.toString();
	}

}
