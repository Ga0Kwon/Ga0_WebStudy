
drop database if exists boardDB;

create database boardDB;
use boardDB;

drop table if exists member;
create table member(
	member_no  int auto_increment primary key,
    member_id varchar(20) not null unique,
    member_pw varchar(10) not null,
    member_name varchar(30) not null,
    member_phone varchar(13)
);


drop table if exists Category;
create table Category(
	category_no int auto_increment primary key,
    cateogry_name varchar(20) not null
);


drop table if exists board;
create table board(
	board_no int auto_increment primary key,
    category_no int,
    board_title varchar(1000) not null, 
    board_content longtext not null,  -- 긴글 텍스트
    member_no int,
    board_date datetime default now(),  -- insert시 자동 날짜/시간 대입
    board_view int default 0,  -- 조회수 시작 0
    foreign key (category_no) references Category(category_no) on delete set null, -- pk 삭제시 fk 필드는 null
    foreign key (member_no) references member(member_no) on delete cascade -- pk 삭제시 fk 필드 같이 삭제
);


drop table if exists reply;
create table reply(
	reply_no int auto_increment primary key,
	reply_content text not null,
    reply_index int default 0, -- 대댓글 위해[상위 댓글 0 : 최상위 그외 : 해당 댓글 번호]
    reply_date datetime default now(),
    member_no int,
    board_no int,
    foreign key (member_no) references member(member_no) on delete set null,
    foreign key (board_no) references board(board_no) on delete cascade
);