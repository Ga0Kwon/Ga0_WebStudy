package controller.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/api1")
public class Api1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Api1() {
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 공공데이터 포털에서 신청한 데이터 가져오기 [안산시 전기차 충전소 현황]
			//URL 클래스
			//1) .openStream() : 해당 객체의 연결된 url 스트림 제공 함수
		/* URL url = new URL("URL주소"); */
		/*file 클래스가 아니고 url 클래스를 사용한 이유는 외부에서 가져오기 때문!*/
		URL url = new URL("https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=yGK0ktRbG%2BTL3dCkYWNRIAi0bHut%2FYjDdi8lXd9MeZnPxhXf8rkoOMfgZJQfrB0f%2B%2BGERokC79iVDaO%2BexWAlw%3D%3D");
		
	
		/*InputStream input = url.openStream(); //한글로 인코딩하는 기능을 지원안한다.*/
		
		//2. 해당 URL 의 데이터 [스트림(바이트)] 읽어오기 위한 스트림 객체 생성 [외부에서 받아온 정보를 url 객체에 담은 거기 때문에 response.이라던가 request.은 사용X]
		/* InputStreamReader is = new InputStreamReader(url.openStream(), "UTF-8"); *///인코딩[한글도] -> char 밖에 못가져옴
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8")); // char 밖에 못가져오는 것을 문자열로 한꺼번에 가져옴
		
		
		/* char[] cs = new char[100000]; */ //10만바이트 글자까지만 저장
		
		/* byte[] bs = new byte[100000]; => 바이트가 필요한 애 */
		
		
		//3. 스트림 객체로 부터 바이트 읽어오기
		
		/* input.read(); */ // 바이트배열로 읽어오기
		/* is.read(cs); */ // 문자 배열로 읽어오기
		String result = br.readLine(); //모든 바이트 읽은 후 문자열String 반환
		
		
		//3-1. 
		/* input.read(bs); */
		/* System.out.println(cs); */
		System.out.println(result);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
