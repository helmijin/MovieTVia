package com.saeyan.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/*---------- - ------------- 
ID           VARCHAR2(10)  
TITLE        VARCHAR2(100) 
RATE         VARCHAR2(10)  
DIB          NUMBER(1)     
REVIEW       VARCHAR2(400) 
PICTUREURL   VARCHAR2(50)
*/

public class MovieVO {

	private int num;
	private String title;
	private String year;
	private String genre;
	private String time;
	private String country;
	private String age;
	private String rate;
	private String summary;
	private String rank;
	private String aud;
	private String review;
	private String img;
	private String bimg;

}
