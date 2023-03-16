package com.saeyan.dto;




import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class BoardVO {
	private int num;
	private String userid;
	private String title;
	private String content;
	private Date writedate;
	private int readcount;
	private int bgroup;
	private int bsequence;
	private int blevel;
	
	
}
