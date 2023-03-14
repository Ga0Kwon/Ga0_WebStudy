drop database if exists jsphomewrok1;
create database jsphomewrok1;

use jsphomewrok1;

drop table if exists employee;
create table employee( -- 사원 테이블
	emno int auto_increment primary key, -- 사원번호 
    emimg longtext, -- 사원 사진
    emname varchar(10) not null, -- 사원이름
    emrank varchar(7) not null, -- 사원 직급
    emdepartno int not null, -- 사원 부서 코드
    emtype varchar(5),
    emindate datetime default now(), -- 입사일
    emoutdate datetime, -- 퇴사일
	emoutreason longtext, -- 퇴사 사유
    foreign key (emdepartno) references department(departno)
);

drop table if exists department;

create table department( -- 부서 테이블
	departno int auto_increment primary key, -- 부서 코드
    departname varchar(5) not null, -- 부서명
    departdirectoer varchar(10) -- 부서 담장자
);

select * from employee;
select * from department;

select * from department  where departname = "영업팀";

insert into department(departname, departdirectoer) values ('인사팀', '박명수');
insert into department(departname, departdirectoer) values ('영업팀', '유재석');
insert into department(departname, departdirectoer) values ('개발팀', '김현수');
delete from employee where emno = 1;

select * from employee where emoutdate is null or emoutdate is not null; -- 전체
select * from employee where emoutdate is null; -- 직무
select * from employee where emoutdate is not null; -- 퇴사

insert into employee(emimg, emname, emrank, emdepartno, emtype) values ('유재석.jpg', '유재석', '부장', 1, '정규직');
insert into employee(emimg, emname, emrank, emdepartno, emtype) values ('하하.jpg', '하동훈', '사원', 1, '정규직');
insert into employee(emimg, emname, emrank, emdepartno, emindate, emtype, emoutdate, emoutreason) values ('노홍철.jpg', '노홍철', '사원', 1, '2022-03-14','일용직', now(), '건강상의 이유');