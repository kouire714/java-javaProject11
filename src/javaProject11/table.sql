show tables;

create table customer(
  idx  int not null auto_increment primary key,
  id varchar(20) not null,  	/* 아이디 */
  password int not null,		/* 비밀번호 */
  name varchar(20) not null,  	/* 성명 */
  birth  int not null,		/* 생년월일 */
  gender char(2) not null,		/* 성별 */
  address varchar(15) not null,	 	/* 주소 */
  phone int not null 			/* 연락처 */
);

create table room2(
  idx  int not null auto_increment primary key,
  idate date not null,  	/* 체크인 날짜 */
  odate date not null		/* 체크아웃 날짜 */
);

create table room4(
  idx  int not null auto_increment primary key,
  idate date not null,  	/* 체크인 날짜 */
  odate date not null,		/* 체크아웃 날짜 */
);

create table room6(
  idx  int not null auto_increment primary key,
  idate date not null,  	/* 체크인 날짜 */
  odate date not null,		/* 체크아웃 날짜 */
);

/*
create table service(
  idx  int not null auto_increment primary key,
  mn boolean default false,  	/* 아침식사 */
  odate  boolean default false,		/* 바베큐 */
);
*/



-- drop table ;

desc customer;

insert into insa (name) values ('홍길동');

select * from customer;
