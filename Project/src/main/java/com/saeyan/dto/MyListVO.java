package com.saeyan.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
---------- - ------------- 
ID           VARCHAR2(10)  
TITLE        VARCHAR2(100) 
RATE         VARCHAR2(10)  
DIB          NUMBER(1)     
REVIEW       VARCHAR2(400) 
PICTUREURL   VARCHAR2(50)
*/

@Getter
@Setter
@ToString

public class MyListVO {
	
	private String id;
	private String title;
	private String category;
	private String img;
}
