/*
	사람[개발자] : DBA 							DBMS								컴퓨터 
		언어 : 영어, 한글(문자)												   			  기계어 : 0, 1

	"표만들어줘"							create table 회원();
    create table 회원();					위 문법을 기계어로 번역 --------------------------> 메모리 할당
    
    - SQL 질의어
		1. DDL
			create
				create database DB명;  => DB생성
                create table 테이블명(필드명 타입 제약조건, 필드명 타입 제약조건); => 테이블 생성
            drop
				drop database DB명;
				drop table 테이블명;
            alter
            truncate
        2. DML
			insert
				모든 필드에 데이터를 추가할 경우 : insert into 테이블명 values (데이터1, 데이터2)
                특정 필드에 데이터를 추가할 경우 : insert into 테이블명(필드명1, 필드명2)  values (데이터1, 데이터2);
            select
				테이블의 모든 필드 검색 : select * from 테이블명;
                테이블의 특정 필드 검색 : select 필드명, 필드명 from 테이블명;
                테이블 조건 검색 : selct * from 테이블명 where 조건;
            update
				모든 레코드에 대한 수정 : update 테이블명 set 필드명1 = 새로운값1;
                특정 레코드에 대한 수정 : update 테이블명 set 필드명1 = 새로운값1, 필드명2 = 새로운값2 where 조건;
            delete
				모든 레코드 삭제 : delete from 테이블명
                특정 레코드 삭제 : delete from 테이블명 where 조건
                
                *절
					where 절
                    
        3. DCL
			grant
            revoke
        4. TCL
			commit
            rollback
            
		* 그외
			use DB명 => 해당 DB선택/사용alter
	
    -데이터 타입
		정수형 : TINYINT, SMALLINT, INT, BIGINT
        실수형 : FLOAT, DOUBLE
        문자형 : CHAR(길이) : 고정 길이 / VARCHAR(길이) : 가변 길이
        날짜형 : DATE, TIME, DATETIME
        대용량 : TEXT, LONGTEXT, BLOB, LONGBLOB
        
	레코드 = 행 = 가로 = 튜플
    필드 = 속성 = 컬럼 = 세로
*/

drop database java; /*ctrl + 엔터 : 해당 커서의 명령어 실행*/
-- 1. DB 생성
create database java;
-- 2. DB 사용/선택
use java;
-- 3. 테이블 생성
create table member(
	mno int auto_increment primary key,
		-- auto_increment : 자동 번호 부여 [*pk 길이 사용]
        -- primary key : 식별 용도[기본키] => * 중복 X, 공백null X
        -- auto_increment와 primary key는 세트
	mid varchar(20),
    mpw varchar(20),
    mname varchar(10),
    mphone varchar(13) -- 마지막은 , 안함
);

-- 4. 회원가입 1명 ['qwe', 'qwe', '유재석', '010-4444-4444']
insert into member (mid, mpw, mname, mphone) value  ('qwe', 'qwe', '유재석', '010-4444-4444');
-- [java] insert into member (mid, mpw, mname, mphone) value  (?, ?, ?, ?); => PreparedStatement 매개변수 가능

-- 5. 테이블 확인 [모든 필드 검색]
select * from member;

-- 6 회원가입 1명 추가 ['asd', 'asd', '강호동', '010-5555-5555']
insert into member (mid, mpw, mname, mphone) value  ('asd', 'asd', '강호동', '010-5555-5555');

-- 7. 로그인 하기, 아이디와 비밀번호가 일치하면 ['asd', 'zxc']
select * from member where mid = 'asd' and mpw = 'zxc'; -- 레코드가 존쟇면 로그인 성공 없으면 로그인 실패
			-- 조건 where절 필드명 = 찾을 값 : 해당 필드의 값이 찾을 값과 같으면 true
            -- 조건 and 조건, 조건 or 조건  
            -- 검색된 결과[레코드=행]가 존재하면 로그인 성공, 없으면 실패 

-- 8. 로그인 하기, 아이디와 비밀번호가 일치한지 ['qwe', 'qwe']
select * from member where mid = 'qwe' and mpw = 'qwe'; -- 필드명 = 값 and 필드명 = 값

-- 9. 특정 회원의 모든 정보 호출 [회원번호 : 3, 2]
select * from member where mno = 3; -- 3번 회원의 레코드[행] 확인 -> 없다
select * from member where mno = 2; -- 2번 회원의 레코드[행] 확인

-- 10. 특정 회원의 비밀번호 변경 [2번 회원의 비밀번호 'zxc' 변경]
update member set mpw = 'zxc'; -- 모든 회원의 비밀번호 'zxc'
update member set mpw = 'zxc' where mno = 2; -- mno 2번인 레코드의 비밀번호를 'zxc'변경

-- 11. 특정 회원의 탈퇴
delete from member; -- 모든 회원 탈퇴
delete from member where mno = 2; -- mno가 2번이 레코드 삭제