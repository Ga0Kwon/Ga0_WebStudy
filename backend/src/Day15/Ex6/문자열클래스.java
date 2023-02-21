package Day15.Ex6;

import java.util.Arrays;
import java.util.StringTokenizer;

public class 문자열클래스 {
	public static void main(String[] args) {
		
		//String vs. StringBuilder
		
		//String은 값을 변경할때마다 주소값이 바뀜 => 비효율적
		String data = "ABC";
		System.out.println("주소값 : " +data.hashCode()); 
		
		data += "DEF"; //변경된 것처럼 보이지만 새로운 참조가 할당 [효율성 떨어짐]
		System.out.println(data);
		System.out.println("주소값 : " + data.hashCode());
		
		
		String sbData = new StringBuilder()
				.append("DEF") //문자열 끝에 저장
				.insert(0, "ABC") // 시작위치(0)에 문자열 추가
				.delete(3,4) //해당 인덱스 시작(3)부터 끝(4)전까지 삭제
				.toString(); //완성된 문자열 리턴
		
		System.out.println(sbData);
		
		StringBuilder sbData2 = new StringBuilder();
		sbData2.append("ABC");
		System.out.println("주소값 : " + sbData2.hashCode());
		sbData2.append("DEF");
		System.out.println("주소값 : " + sbData2.hashCode());
		
		System.out.println(sbData2);
		
		
		//
		String data1 = "홍길동&이수홍-박연수";
		
		String[] arr = data1.split("&|-"); //split은 String 배열로 반환 / &나 -로 문자열을 자름
		System.out.println(Arrays.toString(arr));
//		System.out.println(arr[0]);
//		System.out.println(arr[1]);
//		System.out.println(arr[2]);
		
		String data2 = "홍길동/이수홍/박연수";
		
		StringTokenizer st = new StringTokenizer(data2, "/"); //객체로 만듬
//		System.out.println(st.nextToken()); //nextToken() : 자른 것을 하나씩 가져옴
		
		System.out.println("조각수 : " + st.countTokens());
		for(int i = 0; i <= st.countTokens(); i++) {
			System.out.println(st.nextToken());
		}
		
		
	}
}	
