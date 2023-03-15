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

-- 관리자 추가해야하는 항목
insert into member (mid, mpwd, memail) values ('admin', '1', 'admin1@kakao.co.kr');
insert into mpoint(mpcomment, mpamount, mno) values ('관리자[포인트X]', 0, 1); -- 관리자

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


