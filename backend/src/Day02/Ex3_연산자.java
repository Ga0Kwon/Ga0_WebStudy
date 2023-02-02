package Day02;

public class Ex3_연산자 { //class s
	public static void main(String[] args) { //main s
		//1. 부호/증감연산자
		int x = +10;
		int y = -10;
		
		System.out.println("x : " + x);
		System.out.println("y : " + y);
		
		/*후위 연산자*/
		System.out.println("x++ :" + (x++)); // 10
		System.out.println("x : " + x); //11
		System.out.println("x-- :" + (x--)); // 11
		System.out.println("x : " + x); //10
		
		/*전위 연산자*/
		System.out.println("--y :" + (--y)); //-11
		System.out.println("y : " + y); //-11
		System.out.println("++y :" + (++y)); //-10
		System.out.println("y : " + y); //-10
		
		//2.산술연산자
		
		System.out.println("x + y :" +(x+y)); //0
		System.out.println("x - y :" +(x-y)); //20
		System.out.println("x * y :" +(x*y)); //-100
		System.out.println("x / y :" +(x/y));// -1 (몫)
		System.out.println("x % y :" +(x%y));// 0 (나머지)
		
		//3. 비교연산자
		System.out.println("x == y : " + (x==y)); //10 == -10 ; false(같다)
		System.out.println("x != y : " + (x!=y)); //10 != -10 ; true (다르다)
		System.out.println("x > y : " + (x>y)); //10 > -10 ; true (x가 y초과)
		System.out.println("x >= y : " + (x>=y)); // 10>= -10 ; true(x가 y이상)
		System.out.println("x < y : " + (x<y)); //10 < -10 ; false(x가 y미만)
		System.out.println("x <= y : " + (x<=y)); //10 <= -10 ; false (x가 y이하)
		
		System.out.println("str1.equals(str2) :" + ("유재석".equals("유재석"))); //true
		System.out.println("str1.equals(str2) :" +( !("유재석".equals("유재석")))); //true -> 부정[!] -> false
		
		//4. 논리연산자
		System.out.println("5 < x < 20 : " + (x > 5 && x < 20)); //x는 10 => true [true and true => true]
		System.out.println("5 < x < 9 : " + (x > 5 && x < 9)); //x는 10 => false [true and false => false]
		System.out.println("5 >= x 거나 x <= 20 : " + (x <= 5 || x <= 20)); //x는 10 => true [true or false => true]
		System.out.println("5 >= x 거나 x >= 20 : "+ (x > 5 && x >= 20)); //x는 10 => false [false and false => false]
		System.out.println("!(5 <= y) : "+ !(y >= 5)); //y는 -10 => false => true
		
		//5. 대입연산자
		int z = 30; //대입
		z+=x ; // 30 + 10 => 40; 오른쪽을 더해서 왼쪽에 넣음. [z = z+x]
		z-=x; // 40 -10 => 30; 오른쪽을 빼서 왼쪽에 넣음 [z = z-x]
		z*=x; // 30*10 => 300; 오른쪽을 곱해서 왼쪽에 넣음 [z = z*x]
		z/=x; // 300/10 => 30; 오른쪽을 나눈 몫을 왼쪽에 넣음 [z = z/x]
		z%=x; // 30%10 => 0; 오른쪽을 나눈 나머지를 왼쪽에 넣음 [z = z%x]
		
		//6. 삼항연산자 [조건 ? 참 : 거짓]
		String 결과 = (x>=20) ? "합격" : "불합격";
		System.out.println(결과);
		
		//7.연결연산자
		System.out.println("문자열A" + "문자열B" );
		String 연결문자1 = "유재석" + "10"; //유재석10
		System.out.println(연결문자1);
		String 연결문자2 = "유재석" + 10; //유재석10
		System.out.println(연결문자2);
		String 연결문자3 = "유재석" +10 + 20; //유재석1020
		System.out.println(연결문자3);
		String 연결문자4 = "유재석" + (10+20); //유재석30
		System.out.println(연결문자4);
		
		
	}//main e 
}//class e
