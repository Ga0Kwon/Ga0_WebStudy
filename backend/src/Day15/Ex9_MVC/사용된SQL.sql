-- 1. DB 생성
create database day15;

-- 2. DB 선택
use day15;

-- 3. table 생성
create table member(
	mno int auto_increment primary key, -- 회원 번호 [자동번호, 식별자]
    mid varchar(20), -- 회원아이디 [최대 20글자 저장]
    mpw varchar(20) -- 회원비밀번호 [최대 20글자 저장]
);

select * from member;