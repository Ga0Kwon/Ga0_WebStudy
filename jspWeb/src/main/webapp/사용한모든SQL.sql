drop database if exists jspweb;
create database jspweb;

use jspweb;


-- 회원 테이블
drop table if exists member;

create table member(
	mno int auto_increment primary key, -- 식별 번호
    mid varchar(30) not null unique, -- 회원 아이디[null값 X, 중복 X]
    mpwd varchar(20) not null, -- 회원 비밀번호 [null값 X]
    mimg longtext, -- 서버에 저장된 사진 경로 [ null 가능]
    memail varchar(100) not null unique -- @ 포함해서 저장할 예정 [회원 이메일] [null값 X, 중복 X]
);

-- 친추 테이블
drop table if exists friend;
create table friend(
	fno int auto_increment primary key, -- 식별 번호
    ffrom int , -- 보내는 사람[ 친구 신청 회원 ] - fk
    fto int , -- 친추 받는 사람 [ 친구 신청 받은 회원 ] - fk
	foreign key (ffrom) references member(mno) on delete set null, -- 친구가 탈퇴하면 null값
	foreign key (fto) references member(mno) on delete set null -- 친구가 탈퇴하면 null값
);

-- 포인트 테이블
drop table if exists mpoint;

create table mpoint(
	mpno int auto_increment primary key,
    mpcomment varchar(1000) not null, -- 포인트 내역(왜 감소하고 왜 증가했는지)
    mpamount int default 0, -- 포인트 수량
    mpdate datetime default now(), -- 포인트 받은 날짜
    mno int, -- 누구 포인트 인지 
    foreign key (mno) references member(mno) on delete set null -- 탈퇴한 회원 포인트도 같이 사라짐
);
use jspweb;
select * from member where mid = 'qwe123' and mpwd = 'qwe1234';

select * from member;
select * from member where mid = 'admin' and mpwd = 1;
select mid from member where memail = 'qwe123@naver.com';
delete from member where mno = 1 or mno = 2 or mno = 3;

insert into member (mid, mpwd, memail) values ('admin', '1', 'admin1@kakao.co.kr');
insert into mpoint(mpcomment, mpamount, mno) values ('관리자[포인트X]', 0, 1); -- 관리자
select * from mpoint;

select m.mno, m.mid, m.mimg, m.memail, sum(p.mpamount) as mpoint
	from member m, mpoint p
	where m.mno = p.mno and m.mid = 1;
    
                
insert into mpoint(mpcomment, mpamount, mno) values ('회원가입축하', 100, 2);
/*
	테이블 설계 주의점
		1. 서로 다른 테이블간의 중복필드 X
        2. 예외)) 단, 서로 다른 테이블 간의 관계[연결 PK-FK]은 제외 : 무결성 유지
			- 테이블당 pk 1개 이상 권장 
*/
-- 아이디에 해당하는 회원정보[레코드] 호출
select * from member where mid = 'qwe123'; 
-- 아이디에 해당하는 회원정보[레코드] + 보유 포인트 호출

-- 1. 특정 회원의 포인트 내역
select * from mpoint where mno = 1;

-- 2. 특정 회원 보유 포인트
select sum(mpamount) from mpoint where mno = 1;

-- 3. 아이디에 해당하는 보유 회원의 보유 포인트 [ 조인 -- 교집합 = 1. pk - fk] 
select * from member m, mpoint p where m.mno = p.mno; -- 다른 조건과 헷갈릴 수 있다.
select * from member m natural join mpoint; -- 암뭄적으로 pk와 fk를 찾아서 조인

-- 4. 조인 후 필요한 출력하고 싶은 것만 [ 통계구할때 두개 이상 필드를 출력시 그룹 필수! ]
select m.mno, m.mid, m.mimg, m.memail, sum(p.mpamount) as 보유포인트 
	from member m, mpoint p
    where m.mno = p.mno
    group by mno;  -- 집계할 기준 [ ~~별] : 회원 별

-- 5. 특정 1명에 대한 회원정보+보유포인트)
select m.mno, m.mid, m.mimg, m.memail, sum(p.mpamount) as 보유포인트 
	from member m, mpoint p
    where m.mno = p.mno and m.mid = 'qwe123';

select * from member;
-- * 포인트 지급
insert into mpoint(mpcomment, mpamount, mno) values ('회원가입축하', 100, 1);

-- * 포인트 결제
insert into mpoint(mpcomment, mpamount, mno) values ('구매적립포인트', 5000, 1);

-- * 포인트 사용
insert into mpoint(mpcomment, mpamount, mno) values('제품구매' , -3000, 1);

select * from mpoint where mno = 1;

-- * 포인트 지급
insert into mpoint(mpcomment, mpamount, mno) values ('회원가입축하', 100, 2);

-- * 포인트 결제
insert into mpoint(mpcomment, mpamount, mno) values ('구매적립포인트', 1200, 2);

-- * 포인트 사용
insert into mpoint(mpcomment, mpamount, mno) values('제품구매' , -570, 2);

-- 카테고리 테이블 [ 카테고리번호, 카테고리 이름(공지사항, 커뮤니티, QnA, 노하우 등등)]
drop table if exists category;
create table category(
	cno int auto_increment primary key,
    cname varchar(100) not null unique
);

-- 게시물 테이블 [번호 , 제목, 내용, 첨부파일 1개, 작성일, 작성자, 조회수, 좋아요수, 싫어요수, 작성자]
drop table if exists board;
create table board(
	bno int auto_increment primary key,
    btitle varchar(1000) not null,
    bcontent longtext not null,
    bfile longtext,
    bwritedate datetime default now(),
    bview int default 0,
    blike int default 0,
    bhate int default 0,
    mno int, -- member 테이블의 mno
    cno int, -- category 테이블의 cno
    foreign key (mno) references member(mno) on delete set null, 
    foreign key (cno) references category(cno) on delete cascade
);
-- on delete cascade : pk가 삭제되면 fk도 같이 삭제 
-- on delete set null : pk가 삭제되면 fk는 null로 변경
-- 생략                 : fk에 존재하는 식별키[pk]는 삭제 불가능 

-- 카테고리 데이터 미리 추가
insert into category(cname) value('공지사항');
insert into category(cname) value('커뮤니티');
insert into category(cname) value('QnA');
insert into category(cname) value('노하우');

-- board 테이블에 mno가 있다 원하건 mno[fk] ---> member테이블의 mno[pk]외 다른 필드 접근 

select * from member, board;

-- 1. where을 이용한 조인 [ *다른 조건과 가독성이 떨어짐 ]
select * from member, board where member.mno = board.mno;

-- 2. 테이블명 별칭[별명]
select * from member m, board b where m.mno = b.mno;

-- 3. A테이블명 natural join(자연조인) B테이블 [* pk와 fk 1개씩 존재하는 테이블에서 자주 사용]
select * from member natural join board;

-- 4. A테이블명 join B테이블명 on 교집합필드조건(=조인조건) [* on 키워드를 사용해서 교집합조건 사용하면 다른 where 구분]
select * from member m join board b on m.mno = b.mno;

-- 결론 
select board.*, member.mid from member natural join board; -- board테이블 전부와 memmber의 id


-- 1. 조건[where] 조인[합집합]
drop table if exists ex4;
create table ex4(
	mno int 
);
insert into ex4 value(1);
insert into ex4 value(2), (3), (4), (5);

select * from ex4;

drop table if exists ex5;
create table ex5(
	mno int
);

insert into ex5 value (3), (4), (5), (6), (7);

select * from ex5;

select * from ex4, ex5; -- 5(ex4레코드수)*5(ex5레코드수) =  25 레코드 [합집합]

select * from ex4, ex5 where ex4.mno = ex5.mno; -- 3레코드 [교집합의 두 레코드의 일치값 (pk -fk)]

select * from ex4 natural join ex5; -- 자연조인[교집합] => 암묵적으로 동일한 레코드이 일치값]
