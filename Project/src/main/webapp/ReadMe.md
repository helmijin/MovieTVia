create table movie(
CODE      NUMBER(5),     
TITLE     VARCHAR2(100),  
YEAR      VARCHAR2(25),   
GENRE     VARCHAR2(100),  
TIME      VARCHAR2(50),   
COUNTRY   VARCHAR2(50),   
AGE       VARCHAR2(30),   
RATE      VARCHAR2(50),   
SUMMARY   VARCHAR2(2000), 
RANK      VARCHAR2(50),   
AUD       VARCHAR2(50),   
IMG       VARCHAR2(2000), 
BIMG      VARCHAR2(2000), 
REVIEW    VARCHAR2(500)
);

create table member(
NAME            VARCHAR2(10), 
USERID NOT NULL VARCHAR2(10), 
PWD             VARCHAR2(10), 
EMAIL           VARCHAR2(20), 
PHONE           CHAR(13),     
ADMIN           VARCHAR2(10) 
);

create table qnaboard(
NUM       NOT NULL NUMBER(5),    
TITLE              VARCHAR2(30), 
CONTENT            VARCHAR2(30), 
READCOUNT          NUMBER(4),    
WRITEDATE          DATE,         
BGROUP             NUMBER(5),    
BSEQUENCE          NUMBER(5),    
BLEVEL             NUMBER(5),    
USERID             VARCHAR2(20)
)

create table board(
NUM       NOT NULL NUMBER(5),    
TITLE              VARCHAR2(30), 
CONTENT            VARCHAR2(30), 
READCOUNT          NUMBER(4),    
WRITEDATE          DATE,         
BGROUP             NUMBER(5),    
BSEQUENCE          NUMBER(5),    
BLEVEL             NUMBER(5),    
USERID             VARCHAR2(20)
);

create table mypage(
ID         VARCHAR2(10),  
TITLE      VARCHAR2(100), 
CATEGORY   VARCHAR2(10),  
IMG        VARCHAR2(200) 
);

create table(
CODE      NUMBER(5),      
TITLE     VARCHAR2(100),  
YEAR      VARCHAR2(25),   
GENRE     VARCHAR2(100),  
CHANNEL   VARCHAR2(100),  
COUNTRY   VARCHAR2(100),  
AGE       VARCHAR2(50),   
RATE      VARCHAR2(50),   
SUMMARY   VARCHAR2(2000), 
IMG       VARCHAR2(2000), 
BIMG      VARCHAR2(2000), 
REVIEW    VARCHAR2(500),
);

create table(
RNO                NUMBER(11),    
CODE      NOT NULL NUMBER(11),    
WRITER             VARCHAR2(50),  
CONTENTS           VARCHAR2(50),  
RGROUP             NUMBER(10),    
RSEQUENCE          NUMBER(10),    
TITLE              VARCHAR2(100), 
);