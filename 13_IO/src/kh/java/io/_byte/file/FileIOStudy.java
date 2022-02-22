package kh.java.io._byte.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOStudy {

	public static void main(String[] args) {
		FileIOStudy study = new FileIOStudy();
		study.test1();
	}
	
	/**
	 * 대상이 file인 입출력스트림
	 *  - 기본스트림 : FileInputStream | FileOutputStream
	 *  - 보조스트림 : BufferedInputStream | BufferedOutputStream
	 *  
	 *  sample file 출력하기
	 */
	private void test1() {
		// 파일경로는 프로젝트 루트 기준으로 조회한다. (13_IO)밑에 있는 file
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream("/Users/camilee/Documents/dev/KH수업관련문서/서류/asd.pdf"));
			bos = new BufferedOutputStream(new FileOutputStream("qrcode.pdf"));
			
			//file이 존재하지 않으면 새로 생성한다.
			//해당 경로가 디렉토리 또는 권한부족 시 FileNotFoundException을 던진다.
			
			int len = 0; //읽어온 byte수
			byte[] bytes = new byte[8192]; //BufferedReader가 내부적으로 사용하는 버퍼크기
			//파일을 byte단위로 읽어서 리턴
			//파일을 모두 읽었으면 값없음(-1)리턴
			while((len = bis.read(bytes)) != -1) {
//				System.out.println((char)data); //한글은 깨짐 (3바이트 짜리를 2바이트로 읽고있어서)
				System.out.println(len);
				bos.write(bytes, 0, len); //sampleCopy에 1byte씩 출력
			}
			
		} catch(IOException e) { 
			e.printStackTrace();
		} finally {
			// 사용한 자원은 반드시 반납해야한다.
			// 보조스트림만 반납하면 주스트림도 내부적으로 함께 반납된다.
			try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
