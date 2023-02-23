/*
	SQL
		DDL
			create
				create database DB명;
                create table 테이블명();
            drop
				drop database DB명;
                drop database if exists DB명;
                drop table 테이블명;
                drop table if exists 테이블명;
		DML
        DCL
	
    - 타입 [DBMS 회사마다 다름]
		1. 정수형
			thinyint
            smallint
            int 
            bigint
		2. 문자형
			char(길이) : 고정길이
            varchar(길이) : 가변길이
		3. 대용량[긴글, 첨부파일]
			text
            longtext
		4. 실수형 
			float
            double
		5. 날짜형
			date 
            time 
            datetime 
        
    - 제약조건
		
*/

drop database market; -- 무조건 삭제
-- 1. DB 생성
drop database if exists market; -- 존재한다면 삭제 
create database market;

-- 2. 테이블 생성
drop table if exists member; -- 존재한다면 삭제 
create table member(
	-- 필드 선언
		-- 필드명은 테이블 앞글자_필드명 
        m_id char(8) not null primary key,
			-- char(길이) : 길이 만큼 문자 저장 [최대 길이 글자]
            -- not null : 공백 저장 불가능 [만일 공백이면 저장 실패]
            -- primary key : (기본키)식별키 [ 필드내 중복불가능, 공백 불가능] => primary key인 경우는 not null 생략 가능
				-- 주민등록번호, 학번, 회원번호, 사번, 제품번호 등...
		m_name varchar(10) not null,
			-- varchar(길이) : 가변 길이 [데이터의 길이가 일정하지 않을 때]
			-- 가변길이 : 저장된 데이터만큼 메모리 할당
				-- varchar(8)에서 'ABC' 저장시 5칸 메모리 자동 제거
			-- 고정길이 : 선언된 길이 만큼 메모리 할당 
				-- char(8)에서 'ABC' 저장시 8칸 메모리 고정 [3칸 : ABC, 5칸 : 빈공간]
		m_no int not null, 
			-- int : 정수 +-20억 정도 저장 가능 [공백 불가눙]
		m_address char(2) not null, -- 최대 2글자 저장 [ 공백 불가능]
        m_phone1 char(3), -- 국번> 최대 3글자 저장 [공백 가능]
        m_phone2 char(8), -- 전화번호> 최대 8글자 저장 [공백 가능]
        m_height smallint,
			-- smallint : +-3만 정도 저장 가능 
		m_debut date
			-- date : 날짜 타입
);

INSERT INTO member VALUES('TWC', '트와이스', 9, '서울', '02', '11111111', 167, '2015.10.19');
INSERT INTO member VALUES('BLK', '블랙핑크', 4, '경남', '055', '22222222', 163, '2016.08.08');
INSERT INTO member VALUES('WMN', '여자친구', 6, '경기', '031', '33333333', 166, '2015.01.15');
INSERT INTO member VALUES('OMY', '오마이걸', 7, '서울', NULL, NULL, 160, '2015.04.21');
INSERT INTO member VALUES('GRL', '소녀시대', 8, '서울', '02', '44444444', 168, '2007.08.02');
INSERT INTO member VALUES('ITZ', '잇지', 5, '경남', NULL, NULL, 167, '2019.02.12');
INSERT INTO member VALUES('RED', '레드벨벳', 4, '경북', '054', '55555555', 161, '2014.08.01');
INSERT INTO member VALUES('APN', '에이핑크', 6, '경기', '031', '77777777', 164, '2011.02.10');
INSERT INTO member VALUES('SPC', '우주소녀', 13, '서울', '02', '88888888', 162, '2016.02.25');
INSERT INTO member VALUES('MMU', '마마무', 4, '전남', '061', '99999999', 165, '2014.06.19');

select * from member;

-- -------------------------------------------------------
drop table if exists buy;

create table buy(
	b_no int auto_increment primary key, -- 1. 구매번호
		-- auto_increment : 레코드 추가시 자동 번호 부여 [무조건 pk[not null 자동] 필드만 가능]
	m_id char(8),-- 2. 구매한 회원
    b_pName char(6) not null, -- 3. 제품 이름
    b_gName char(4), -- 4. 분류명
    b_price int not null, -- 5. 가격
    b_amount smallint not null, -- 6. 수량
    
    -- 일반적으로 외래키는 마지막에 넣는게 좋음!
    foreign key (m_id) references member(m_id) -- 관계
    -- 외래키설정필드(현재테이블의 필드명) 참조하다 pk가 일치한 테이블명(pk필드명)
	--  foreign key(외래키) [기본키와 연결된 필드]
		-- 해당 pk의 필드가 다른 테이블에서 사용하게 되면 fk
		-- references : 다른 곳에 참조하다.
);


INSERT INTO buy VALUES(NULL, 'BLK', '지갑', NULL, 30, 2);
INSERT INTO buy VALUES(NULL, 'BLK', '맥북프로', '디지털', 1000, 1);
INSERT INTO buy VALUES(NULL, 'APN', '아이폰', '디지털', 200, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '아이폰', '디지털', 200, 5);
INSERT INTO buy VALUES(NULL, 'BLK', '청바지', '패션', 50, 3);
INSERT INTO buy VALUES(NULL, 'MMU', '에어팟', '디지털', 80, 10);
INSERT INTO buy VALUES(NULL, 'GRL', '혼공SQL', '서적', 15, 5);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 2);
INSERT INTO buy VALUES(NULL, 'APN', '청바지', '패션', 50, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 1);
INSERT INTO buy VALUES(NULL, 'APN', '혼공SQL', '서적', 15, 1);
INSERT INTO buy VALUES(NULL, 'MMU', '지갑', NULL, 30, 4);

select * from buy;

-- select : 검색
-- 1. select 필드명 from 테이블명 /  select 필드명1, 필드명2 from 테이블명
select m_id from member;
select m_id, m_name from member;

-- 2. select * from 테이블명 
	-- *(와일드카드) : 모든 것 의미 = 모든 필드 뜻 
select * from member;

-- 3. select 필드명 as '별칭명' from 테이블명
select m_id as '회원아이디' from member;
select m_id '회원아이디' from member; -- as 생략 가능 => 필드명은 띄어쓰기 안되므로 구분 가능
-- 4. select 필드명 from 테이블명 where 조건
select * from member where m_name = "블랙핑크"; -- 회원명이 '블랙핑크'인 레코드 검색 
select * from member where m_no = 4; -- 멤버수가 4명인 레코드 검색
select * from member where m_height <= 162; -- 키 필드가 162이하이면 레코드 검색
select * from member where m_height >= 165 and m_no > 6; -- 키 필드가 165이상이면서 멤버 수 필드가 6초과이면 
select * from member where m_height >= 165 or m_no > 6; -- 키 필드가 165이상이거나 멤버 수 필드가 6초과이면
select * from member where member.m_height >= 165;

select * from member m where m.m_height >= 163 and m.m_height <= 165; -- 키 필드 163~165
select * from member where m_height between 163 and 165; -- 키 필드 163~165

select * from member where m_address = '경기' or m_address = '전남' or m_address = '경남';
select * from member where m_address in ('경기', '전남', '경남');

select * from member where m_name = '우주소녀'; -- = 같다 [모두 동일했을 때]
-- % : 문자 수 관련X
select * from member where m_name like '우%'; -- 우로 시작하는 문자 찾기
select * from member where m_name like '%우'; -- 우로 끝나는 문자 찾기 
select * from member where m_name like '%우%'; -- 우를 포함한 문자 찾기 

-- _ : 문자 수 관련O
select * from member where m_name like '우___'; -- 언더바 수만큼. 즉 우로 시작하고 4글자인 레코드 찾기
select * from member where m_name like '___우'; -- 언더바 수만큼. 즉 우로 끝나고 4글자인 레코드 찾기
select * from member where m_name like '_우_'; -- 3글자 중에 가운데 글자가 우인 문자 찾기 => 두번째 글자가 무조건 우

select m_no, m_no+1 as 멤버1명추가, m_no-1 as 멤버1명제거 from member;
select m_no,m_no/2 as 멤버2나누기 from member;
select m_no,m_no div 2 as 멤버2나누기몫 from member;
select m_no,m_no mod 2 as 멤버2나누기나머지 from member;

select m_no * m_height 멤버키점수 from member;

-- 5. select * from 테이블명 order by 정렬기준필드
-- select * from 테이블명 where 조건 order by 정렬기준필드
-- select * from 테이블명 where 조건 order by 정렬기준필드1, 정렬기준필드2
	-- 다중 정렬 : 앞 정렬에서 동일한 데이터가 있을경우 하위 정렬
select * from member order by m_debut asc; -- 데뷔날짜 기준으로 정렬 [기본 값 오름차순 => asc 생략해도 OK]
select * from member order by m_debut desc; -- 데뷔날짜 기준으로 정렬 [내림차순] => 과거 날짜가 작다/ 최근 날짜가 크다
select * from member where m_height >= 164 order by m_height desc;  -- 조건 다음에 정렬해야함! 
-- 키를 내림차순으로 정렬후 동일한 키가 있을 경우 동일한 키 중에서 데뷔날짜 오름차순
select * from member order by m_height desc, m_debut asc; 

/*
	학년 점수 		학년 정렬 -> 점수 정렬			학년 점수
    1 	50										1	50
    3	20										1	60
    1	60										3 	20
*/

-- 6. select * from 테이블명 limit 레코드수 
-- select * from 테이블명 limit 시작레코드, 개수;
select * from member limit 3;
select * from member limit 0, 3; -- 에이핑크, 블랙핑크, 소녀시대... 0번부터 3개
select * from member limit 1, 5; -- 1번부터 5개 
select * from member order by m_height desc limit 3;

-- 7. select distinct 필드명 from 테이블; : 필드 내 데이터 중복 제거
select m_address from member;
select distinct m_address from member;

-- 8. select * from 테이블명 group by 그룹기준필드;
select b_amount from buy; -- 판매 수량 필드 검색
select sum(b_amount) from buy; -- 판매 수량 필드 합계
select avg(b_amount) from buy; -- 판매 수량 필드 평균
select max(b_amount) from buy; -- 판매 수량 필드내 최대값
select min(b_amount) from buy; -- 판매 수량 필드내 최소값
select count(b_amount) from buy; -- 판매 수량 레코드 수 [null 미포함]
select count(*) from buy; -- 전체 레코드 수 [null 포함]

	-- 1) 회원 아이디[그룹]별로 판매수량 합계
select m_id 회원아이디, sum(b_amount) as 구매수량총합 from buy group by m_id;

	-- 2) 회원 아이디[그룹]별로 총매출액[가격*수량] 합계
select m_id 회원아이디, sum(b_price*b_amount) as 회원구매금액 from buy group by m_id;

	-- 3) 회원 아이디[그룹]별로 판매수량 평균
select m_id 회원아이디, avg(b_amount) as 판매수량평균 from buy group by m_id;
	
    -- 5) 구매한 회원 수 
select m_id 회원아이디, count(*) as 결제수 from buy group by m_id;

-- 9. select * from 테이블명 group by 그룹기준필드 having 그룹내조건
	--  회원 아이디[그룹]별로 총매출액[가격*수량] 합계가 1000이상 검색
select m_id 회원아이디, sum(b_price*b_amount) as 총매출액 
from buy
group by m_id
having sum(b_price*b_amount) >= 1000;

-- 필드를 2개 검색할 경우는 group by를 해줘야한다.
-- select m_id 회원아이디, sum(b_price*b_amount) as 총매출액
-- from buy
-- where sum(b_price*b_amount) 
-- group by mid;
-- => X [sum(b_price*b_amount) 은 그룹하고 나서 집계이기 때문에 where로 안됨!] => having 써야함!!

-- where은 그룹하기 전에 연산이고, having은 그릅 후의 연산

-- 10 [전체]
	-- select * from 테이블명 where 조건 group by 그룹 having 그룹조건 order by 정렬 limit 레코드수 제한  : [순서]

-- insert 
	-- 1. 특정필드에 값 삽입 : insert into 테이블명(필드명1, 필드명2) values(값1, 값2);
    -- 2. 전체필드에 값 삽입 : insert into 테이블명 values (값1, 값2);
	-- 3. 다중 레코드 삽입 : insert into 테이블명 values (값1, 값2) , (값1, 값2);
    -- 4. 검색된 결과를 삽입 : insert into 테이블명 select
			-- 검색한 필드와 삽입할 테이블내 필드명이 동일할 경우/순서도 동일해야함!
	-- 5. 마지막으로 추가된 레코드이 pk 확인 : select last_insert_id();
    
create table mAddr( -- 회원 아이디, ㅈ소 필드를 갖는 테이블
	m_id char(8),
    m_address char(2)
);
select * from member limit 5;

insert into mAddr select m_id, m_address from member limit 5;

select * from mAddr;

select last_insert_id();

-- update
	-- update 테이블명 set 필드명 = 수정할 값 where 조건식
    -- 1. 해당 테이블에서 주소가 서울이면 'seoul'
update member set m_address = 'seoul' where m_address = '서울'; -- m_addresss가 char(2)이여서 안됨. 
-- workbench에서는 update delete 기본적으로 사용 불가능
	-- 메뉴 -> edit -> preferences[가장 아래] -> SQL Query -> 가장 밑 save update....있는거 체크 해제
update member set m_address = 'se' where m_address = '서울';
select * from member;
update member set m_no = m_no/3; -- 연산가능
update member set m_address = '안산';


-- delete
	-- delete from 테이블명 where 조건식
	-- *만약 관계테이블 일 경우 다른 테이블에서 fk필드로 사용된 레코드는 삭제 불가능  [*제약조건] 
    -- 1. 만약에 핑크가 포함된 이름 삭제
delete from member where m_name like '%핑크%'; -- ??? 오류 : [관계가 있는 테이블에서 pk에 포함된 레코드를 삭제하면 fk????] => 삭제할 수 X
delete from member where m_name = '잇지'; -- ??성공 [ 관계가 있는 테이블에서 fk필드가 없을 경우 pk필드 삭제 가능]

update member set m_address = '서울' where m_phone1 = '02';
update member set m_address = '경북' where m_phone1 = '054';
update member set m_address = '경남' where m_phone1 = '055';
update member set m_address = '전북' where m_phone1 = '061';

select * from buy;
/*
	연산자
		1. 산술연산자 :  +더하기, -빼기, *곱하기, /나누기, div몫, mod나머지
		2. 비교연산자 : >=이상, <=이하, >초과, <미만, =같다, !=같지 않다
        3. 논리연산자 : and 이면서, or이거나, not 부정
        4. 기타연산자 :
				in(값1, 값2, 값3) : 값1~값3 하나라도 존재하면 [값1 or 값2 or 값3]
                값 between 값1 and 값2 : 값1 부터 값2 사이이면 true [값 >= 값1 and 값 <= 값2] => 값1 : 시작값 / 값2 : 끝값
                like : 패턴 검색 
					% : 모든 문자수 대응 
                    _ : _개수 만큼 문자수대응
		5. null 관련 연산자
			= null[X]
            필드명 is null : null 이면 [ = null[X]]
			필드명 is not null : null이 아니면 [!= null[X]]
            
		6. 집계함수
			sum(필드명) : 해당 필드내 데이터 총합
            avg(필드명) : 해당 필드내 데이터 평균
            max(필드명) : 해당 필드내 데이터 최대값
            min(필드명) : 해당 필드내 데이터 최소값
            count(필드명) : 해당 필드내 데이터 수 [null 미포함] 
            count(*) : 레코드 수 [null 포함]
*/

-- 타입 확인
drop table if exists testType;

create table testType(
	tinyint_col tinyint, -- 정수[1바이트] : 약 +- 128
    smallint_col  smallint, -- 정수[2바이트] 약 +- 3만정도
    int_col int, -- 정수[4바이트] 약 +- 21억 정도
	int_col2 int unsigned, -- 정수[4바이트] 약 +43억정도 [unsigned : 음수 사용X -> 음수용량을 양수로 사용]
    bigint_col bigint, -- 정수[8바이트] 약 +- 20억 이상
    char_col char(10), -- char(길이) : 고정 길이[1 ~ 255]
    varchar_col varchar(10), -- varchar(길이) : 가변길이[1~16383] *MySQL 5버전 이상일때만 
    text_col text, -- text 1~65535
    longtext_col longtext, -- longtext 1~42억정도 
    float_col float, -- 실수[소수점 7자리까지 저장]
    date_col date, -- 날짜 저장 [yyyy - MM - dd]
    time_col time, -- 시간 저장 [hh : mm : ss]
    dateTime_col datetime -- 날짜/시간 저장[yyyy-MM-dd hh:mm:ss]
);

select * from testType