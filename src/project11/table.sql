show tables;

/* 회원 목록 */
create table customer(
  idx  int not null auto_increment primary key,
  name varchar(20) not null,  	/* 성명 */
  mId varchar(20) not null,  	/* 아이디 */
  password varchar(20) not null,/* 비밀번호 */
  birth date not null,			/* 생년월일 */
  gender char(2) not null,		/* 성별 */
  address varchar(15) not null,	/* 주소 */
  phone varchar(20) not null 	/* 연락처 */
);

/* 예약자 목록 */
create table roomRes(
  mId varchar(20) not null,					/* 예약자 아이디 */
  rName	varchar(20) not null,				/* 방 이름 */
  inDate date not null,  					/* 체크인 날짜 */
  outDate date not null,   					/* 체크아웃 날짜 */
  animalExperience boolean default false,  	/* 동물먹이체험 */
  breakfast boolean default false,  		/* 아침식사 */
  bbq boolean default false					/* 바베큐 */
);

/* 펜션 목록 */
create table roomIntro(
  rName varchar(20) not null,				/* 방 이름 */
  rIntro varchar(100) not null,				/* 방 소개 */
  animalIn boolean default false  	    	/* 반려견 반입가능 여부 */
);

drop table customer;
drop table roomRes;
drop table roomIntro;

desc customer;
desc roomRes;
desc roomIntro;

insert into customer values (default, '홍길동', 'kouire', 1234, '1995-11-23', '남자', '청주', '01027342745');
insert into roomRes values ('kouire','2인실', "20230720", "20230725", true, default, default);
insert into roomIntro values ('room2', '2인실방', false);
insert into roomIntro values ('room4', '4인실방', false);
insert into roomIntro values ('room4Animal', '4인실방(반려동물 반입가능)', true);
insert into roomIntro values ('room6', '6인실방', false);

DELETE FROM customer WHERE mId = "kouire";

select * from customer;
select * from roomRes;
select * from roomIntro;
