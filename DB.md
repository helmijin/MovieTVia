# DB
create table board (
    num NUMBER(20),
    userid varchar2(20),
	title varchar2(300),
	content varchar2(1000),
	writedate date default sysdate,
	readcount NUMBER(20),
	bgroup NUMBER(20),
	bsequence NUMBER(20),
	blevel NUMBER(20)
    );
    
create table member (
    name varchar2(20),
	userid varchar2(20),
	pwd NUMBER(20),
	email varchar2(30),
    phone NUMBER(13),
    admin varchar2(20),
    gender varchar2(10)
    );
    
    create table movie(
    num NUMBER(20),
	title  varchar2(300),
	year  varchar2(20),
	genre varchar2(50),
	time varchar2(30),
	country varchar2(30),
	age varchar2(10),
	rate varchar2(10),
	summary varchar2(1000),
	rank varchar2(30),
	aud varchar2(30),
	review varchar2(1000),
	img varchar2(100),
	bimg varchar2(100)
    );
    
    create table mylist (
    id varchar2(20),
	title varchar2(300),
	category varchar2(100),
	img varchar2(100),
	num varchar2(100)
    );
    
    create table qnaboard (
    num NUMBER(20),
	pass varchar2(10),
	title varchar2(300),
	content varchar2(1000),
	readcount NUMBER(20),
	writedate date default sysdate,
	bgroup NUMBER(20),
	bsequence NUMBER(20),
	blevel NUMBER(20),
	userid varchar2(20)
    );
    
    create table reply(
    rno NUMBER(20),
	code NUMBER(20),
	userid varchar2(20),
	contents varchar2(1000),
	rgroup NUMBER(20),
    rsequence NUMBER(20),
	title varchar2(300)
    );
    
    create table tv (
    num NUMBER(20),
    title varchar2(300),
	year varchar2(20),
	genre varchar2(50),
	channel varchar2(50),
	country varchar2(30),
  	age varchar2(10),
	rate varchar2(10),
	summary varchar2(1000),
	review varchar2(1000),
	img varchar2(100),
	bimg varchar2(100)
    );
    
    commit;
