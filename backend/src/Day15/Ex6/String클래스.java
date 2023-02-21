package Day15.Ex6;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class String클래스 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		//해당 문자열 -> 바이트열로 변환 getBytes() 인코딩 타입 : UTF-8(전세계 공용어) [한글 3바이트]
		String data = "자바"; //문자열 저장하고 조작하는 클래스
		
		byte[] arr1 = data.getBytes(); // 해당 문자열을 바이트열로 변환
		System.out.println(arr1); // 배열의 주소값 출력
		System.out.println(Arrays.toString(arr1)); //배열내 데이터 출력 Arrays.toString(배열명)
		// 3개 3개
		
		//문자열 -> 바이트열로 변환 getBytes() / getBytes("EUC-KR"); 인코딩 타입 : EUC-KR(영어와 한글만) [2바이트]
		byte[] arr2 = data.getBytes("EUC-KR"); //예외 던짐 UnsupportedEncodingException
		System.out.println(Arrays.toString(arr2));
		//2개 2개
		
		//바이트열 -> 문자열 new String(배열명);
		String st1 = new String(arr1);
		String st2 = new String(arr2, "EUC-KR"); //EUC-KR안쓰면 이상한 값이 보임
		
		System.out.println(st1);
		System.out.println(st2);
	}
}
