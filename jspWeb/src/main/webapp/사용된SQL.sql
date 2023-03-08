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

