show tables;

create table customer(
  idx  int not null auto_increment primary key,
  id varchar(20) not null,  	/* 아이디 */
  password carchar(20) not null,/* 비밀번호 */
  name varchar(20) not null,  	/* 성명 */
  birth  varchar(20) not null,	/* 생년월일 */
  gender char(2) not null,		/* 성별 */
  address varchar(15) not null,	/* 주소 */
  phone varchar(20) not null 	/* 연락처 */
);

create table room(
  id varchar(20) not null,						/* 예약자 아이디 */
  inDate varchar(20) not null,  				/* 체크인 날짜 */
  outDate varchar(20) not null,   				/* 체크아웃 날짜 */
  animalExperience boolean default false,  	/* 동물먹이체험 */
  breakfast boolean default false,  		/* 아침식사 */
  bbq boolean default false					/* 바베큐 */
);

drop table customer;
drop table room;

desc customer;
desc room;

insert into customer values (default, 'honggildong', 1234, '홍길동', 951123, '남자', '청주', 01027342745);
insert into room values ('honggildong', "2023-07-20", "2023-07-25", default, default, default);

select * from customer;
select * from room;
