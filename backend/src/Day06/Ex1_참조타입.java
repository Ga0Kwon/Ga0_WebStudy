package Day06;

public class Ex1_참조타입 {//class s
	public static void main(String[] args) {//main s
		int[] arr1; //int형 배열 선언 [스택 영역에 변수 만들기]
		int[] arr2; //int형 배열 선언 [스택 영역에 변수 만들기]
		int[] arr3; //int형 배열 선언 [스택 영역에 변수 만들기]
		
		//new를 쓰면 다 힙영역[new를 두번썼으니까 주소도 2개]
		arr1 = new int[] {1, 2, 3}; //[힙 영역에 1,2,3 이라는 메모리 3개]
		arr2 = new int[] {1, 2, 3}; //[배열은 첫번째 메모리('1')주소를 스택영역에 대입]
		arr3 = arr2; //arr2가 가지고 있던 메모리주소를 arr3에 대입
		
		// == : 스택 영역의 데이터 비교 [스택영역에는 주소값이 들어가있음 => 즉, 스택여역의 데이터값이지만 주소를 비교한 것!]
		System.out.println(arr1 == arr2); //데이터가 똑같아도 주소값은 다르기 때문에
		System.out.println(arr2 == arr3); //같은 주소값이기때문에 같다.
		
		
		int [] inArray = null; //int 배열 선언 [스택 영역 변수 만들기]
		
		
		
		/*
		  ERROR :: Exception in thread "main" java.lang.NullPointerException: Cannot load from 
		
		System.out.println(inArray[0]);
		inArray[0] = 10; // 오류 발생 : 힙 영역이 없기 때문에 저장 불가능
		
		String str = null;
		System.out.println(str.length()); //오류 발생 : 힙 영역이 없기 대문에 길이 불가눙
		
		 */
		
		String hobby = "여행"; //스택 영역에 hobby 이름으로 변수 선언 "여행" 힙의 메모리 주소 저장
		hobby = null;		  //hobby 변수를 null 변경하면 힙에 있던 "여행" 메모리 제거
		
		String kind1 = "자동차"; //ex. '자동차' 힙의 메모리가 32번지를 스택 영역의 kind1 지정
		String kind2 = kind1;  //kind1 가지고 있던 32번지를 kind2에게 대입
		kind1 = null; //kind1 번지를 지우기
		System.out.println("kind2 : " +kind2); //객체의 주소를 한 변수라도 가지고 있으면 제거X
		
	}//main e
}//class e

/*
  	스택 영역						힙 영역
  	arr1	<----주소대입----  new int[]{1,2,3}
    arr2	<----주소대입----  new int[]{1,2,3}
    arr3	<----arr2의 주소대입----  arr2 (= arr2의 new int[]{1,2,3})
    
    *new : 힙영역에 메모리 생성하는 연산자
    
    *  스택 영역  								힙영역 [별도의 제거 없음]
     	유재석 : 안산시 상록구 65번지				안산 OO아파트 : 안산시 상록구 65번지
     		유재석 이사
     	유재석 : 수원시 구 100번지				수원 OO아파트 : 수원시 구 100번지
     		유재석 해외 이사
    	유재석 : null 						-> null값이 들어가면 힙 영역의 수원, 안산 아파트가 가비지컬렉터에 의해 자동 제거
 */
