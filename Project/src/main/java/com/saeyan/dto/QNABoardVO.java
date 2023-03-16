package com.saeyan.dto;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class QNABoardVO {
	private int num;
	private String pass;
	private String title;
	private String content;
	private int readcount;
	private Date writedate;
	private int bgroup;
	private int bsequence;
	private int blevel;
	private String userid;
	
}
