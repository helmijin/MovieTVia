package com.saeyan.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplyVO {
	int rno;
	int code;
	String userid;
	String contents;
	int rgroup;
	int rsequence;
	String title;
}