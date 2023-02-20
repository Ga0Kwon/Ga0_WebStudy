/*
    -SQL 질의어[대소문자 구분X]
    
		1. DDL : 데이터 베이스 정의어
			1) CREATE TABLE/DATABASE 이름; => 테이블/데이터베이스 생성
            2) DROP TABLE/DATABASE 이름; => 테이블/데이터베이스 삭제
            3) ALTER                    => 수정
            4) TRUNCATE                 => 테이블 데이터 영구 삭제
            
        2. DML : 데이터 베이스 조작어
			1) SELECT => 데이터 검색 
            2) INSERT => 데이터 추가
            3) UPDATE => 데이터 수정
            4) DELETE => 데이터 삭제
            
        3. DCL : 데이터 베이스 제어어
			1) GRANT => 사용자 계정 권한 부여
            2) REVOKE => 사용자 계정 권한 취소
            
        4. TCL : 트랜잭션 제어어
			1) COMMIT => 트랜잭션 완료
            2) ROLLBACK => 트랜잭션 취소
            
	- 테이블 [표 = 열[필드/속성] 행[레코드]]
		* 여러개의 자료들을 효율적으로 관리하기 위해서 관계형데이터베이스[표]
			
            -필드1[열1 - column]			-필드2[열2 - column]
			아이디 						비밀번호 
            qwe							qwe			- 레코드1[행1 - row]
            asd							asd			- 레코드2[행2]
			zxc							zxc			- 레코드3[행3]

*/

# 예1 : 데이터 베이스 [저장소 - 여러개 테이블 저장할 수 있는 공간]
create database test; 
# create : 생성한다.
	#  database : 데이터베이스를
		# test : 데이터베이름[아무거나] => 대소문자 구분 X => 카멜표기법 or 언더바
			# ; : 명령어 마침 
				# ctrl + enter : 커서 위치에 있는 ; 단위 명령어 실행
					# 새로고침 : 자동으로 새로고침이 안돼서 schemas에 추가된것을 바로 볼 수 없음! => 왼쪽 schemas에 새로고침 버튼 누르기 => 수동 새로고침
                    
# 예2 : 데이터 베이스 목록보기
show databases; 

# 예3 : 데이터베이스 사용[선택] 하기 [* 데이터베이스가 여러개 이므로 선택]
use test;

# 예4 : 데이터베이스 삭제 [새로고침을 안해도 바로 확인 가능]
drop database test;

# 예5 : 테이블 생성 [ * 데이터베이스 선택 => 어떤 데이터베이스에 테이블을 생성할 것인지]
create database java; -- 1. 데이터베이스 생성
use java;			  -- 2. 데이터베이스 선택
create table member(  -- 3. 선택된 데이터베이스의 표 만들기

# crate : 생성하다 / table : 테이블 / member : 테이블명[아무거나]
	# 필드명1 	타입1 	키워드1
    # 필드명2 	타입2 	키워드2
    
    id  text,
    password text
);

# 예6 : 테이블 검색
select *from member;
# select : 검색[선택]   /  * : 와일드카드[모든 필드]    from : 테이블명
# select 필드명 from 테이블명