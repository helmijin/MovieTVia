package com.saeyan.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//CREATE table tv(
//CODE        NUMBER(5),         --순번       
//NAME       VARCHAR2(50),       --tv프로 이름  
//YGC         VARCHAR2(30),      --방송년도,장르,방송사
//rate	      VARCHAR2(10),	     --평점
//genre	      VARCHAR2(2000),   --줄거리
//review	     VARCHAR2(2000)    --코멘트
//);

@Getter
@Setter
@ToString
public class TVVO {

	private int num;
	private String title;
	private String year;
	private String genre;
	private String channel;
	private String country;
	private String age;
	private String rate;
	private String summary;
	private String review;
	private String img;
	private String bimg;

}
