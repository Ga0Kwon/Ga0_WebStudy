/*
    -SQL 질의어[대소문자 구분X]
    
		1. DDL : 데이터 베이스 정의어
			1) CREATE TABLE/DATABASE 이름; => 테이블/데이터베이스 생성
				CREATE DATABASE 데이터베이스명;
                USE 데이터베이스명;
                CREATE TABLE 테이블명(필드명 타입 제약조건, 필드명 타입 제약조건);
            2) DROP TABLE/DATABASE 이름; => 테이블/데이터베이스 삭제
				DROP DATABASE 데이터베이스명;
                DROP TABLE 테이블명;
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
            
            
	- 필드 타입
		1. 정수형 : int : 정수
        2. 문자형 : varchar(길이) : 길이만큼 문자열 저장 가능 
        3. 실수형 : double, float : 실수
        4. 날짜형 : date, time, datatime
        5. 대용량 : text

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

# 예7 : 해당 테이블 삭제
DROP TABLE member;
drop database java;

/*
	문제1 : 웹개발 하는데 DB저장소[스키마] 'JSP' 이름으로 생성
		1. 테이블 2개 [member, board] 생성
        2. member 테이블의 필드 구성
			id, password
		3. board 테이블의 필드 구성 
			title, content
*/
CREATE DATABASE JSP;
use JSP;
create table member(
	id varchar(15),
    password varchar(15)
);

create table board(
	title varchar(15),
    content text
);

select * from member;
select * from board;

drop database jsp; # 데이터 베이스 삭제시 안에 있던 테이블도 같이 삭제

/*
	문제2 :
		1. 'spring' 데이터베이스 생성
        2. 'member' 테이블 생성 [회원 번호[정수], id[문자(20)], password[문자(20)]
        3. 'product' 테이블 생성 [제품 번호[정수], name[최대 30글자], price[정수]]
        4. 생성한 테이블 2개 검색[확인]
        5. 데이터 베이스 삭제

*/
# 1.
create database spring;
use spring;

# 2.
create table member(
	id varchar(20),
    password varchar(20)
);

# 3.
create table product(
	productNo int,
    name varchar(30),
    productPrice int
);

# 4.
select * from member;
select * from product;

# 5.
drop database spring;

# DML
# 예1 : INSERT
create database java;
use java;
create table noticeBoard(
	title varchar(20),
    content varchar(100)
);

select * from noticeBoard;

# insert into 테이블명 values (데이터1, 데이터2); => 필드 순서대로 데이터가 추가 
# 필드명이 명시되어 있지 않기 때문에 선언된 필드 순서대로 데이터가 삽입
insert into noticeBoard values('제목구역', '내용구역');

select * from noticeBoard;
# insert into 테이블명(필드명1, 필드명2) values (데이터1, 데이터2); => 필드명대로 저장됨
# 필드명이 명시되어 있기 때문에 명시된 필드 순으로 데이터 삽입 
insert into noticeBoard(title, content) values('제목구역2', '내용구역2');
insert into noticeBoard(content, title) values('내용구역3', '제목구역3');
select * from noticeBoard;

# 예) insert에 매개변수 형식 [JDBC에서 사용할 예정]
	# ? : 변수가 들어가는 자리를 뜻 함 
insert into noticeBoard(title, contnet) values( ?, ? ); -- 여기서는 실행이 안됨 => JAVA에서 됨.

/*
	문제3 : 
		1. 'JSP'라는 이름으로 데이터베이스 생성
        2. 'member'이라는 이름으로 테이블 생성
			회원번호[정수], 아이디[20], 비밀번호[20]
		3. 회원가입 2명 하기
			insert 2번  
            1. 이젠, 1234
            2. 삼성, 4567
		4. 테이블 확인 
        5. 데이터베이스 삭제
*/
create database JSP;
use JSP;

create table member(
	no int,
    id varchar(20),
    password varchar(20)
);

insert into member(no, id, password) values (1, '이젠', '1234');
insert into member(id, password) values ('삼성', '4567');

select * from member; -- 레코드 생성시 데이터를 생략하면 NULL 대입

drop database JSP;

/*
	문제4 : 
		1. 'spring' 이라는 이름으로 데이터베이스 생성
        2. 'product'라는 이름으로 테이블 생성
			제품번호[정수], 제품명[20글자내], 가격[정수]
		3. 제품등록 3개 [레코드 3개] 추가
			1) '냉장고', 200000
            2) '선풍기', 300000
            3) NULL, '컴퓨터', NULL
*/

create database spring;
use spring;

create table product(
	productNo int,
    name varchar(30),
    productPrice int
);

insert into product(productNo, name, productPrice) values (1, '냉장고', 200000);
insert into product(productNo, name, productPrice) values (2, '선풍기', 300000);
insert into product(name) values ('컴퓨터');

select * from product; -- 레코드 생성시 데이터를 생략하면 NULL 대입

DROP Database spring;