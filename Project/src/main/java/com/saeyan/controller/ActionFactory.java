package com.saeyan.controller;

import com.saeyan.controller.action.Action;
import com.saeyan.controller.action.board.BoardCheckPassAction;
import com.saeyan.controller.action.member.MemberDelete;
import com.saeyan.controller.action.member.MemberDeletePro;
import com.saeyan.controller.action.tv.TVDelete;
import com.saeyan.controller.action.UploadPost;
import com.saeyan.controller.action.board.BoardCheckPassFormAction;
import com.saeyan.controller.action.board.BoardDeleteAction;
import com.saeyan.controller.action.board.BoardListAction;
import com.saeyan.controller.action.board.BoardReplyAction;
import com.saeyan.controller.action.board.BoardReplyFormAction;
import com.saeyan.controller.action.board.BoardSearch;
import com.saeyan.controller.action.board.BoardUpdateAction;
import com.saeyan.controller.action.board.BoardUpdateFormAction;
import com.saeyan.controller.action.board.BoardViewAction;
import com.saeyan.controller.action.board.BoardWriteAction;
import com.saeyan.controller.action.board.BoardWriteFormAction;
import com.saeyan.controller.action.member.MemberIdCheck;
import com.saeyan.controller.action.member.MemberJoin;
import com.saeyan.controller.action.member.MemberJoinPost;
import com.saeyan.controller.action.member.MemberLogin;
import com.saeyan.controller.action.member.MemberLoginPost;
import com.saeyan.controller.action.member.MemberLogout;
import com.saeyan.controller.action.member.MemberUpdate;
import com.saeyan.controller.action.member.MemberUpdatePost;
import com.saeyan.controller.action.member.MemberpwdCheck;
import com.saeyan.controller.action.movie.MovieCrawling;
import com.saeyan.controller.action.movie.MovieDelete;
import com.saeyan.controller.action.movie.MovieDeletePost;
import com.saeyan.controller.action.movie.MovieList;
import com.saeyan.controller.action.movie.MovieReply;
import com.saeyan.controller.action.movie.MovieUpdate;
import com.saeyan.controller.action.movie.MovieUpdatePost;
import com.saeyan.controller.action.movie.MovieView;
import com.saeyan.controller.action.movie.MovieViewMore;
import com.saeyan.controller.action.movie.MovieWrite;
import com.saeyan.controller.action.movie.MovieWritePost;
import com.saeyan.controller.action.mylist.MovieAddMyList;
import com.saeyan.controller.action.mylist.MyListDelete;
import com.saeyan.controller.action.mylist.MyListMovie;
import com.saeyan.controller.action.mylist.MyListTV;
import com.saeyan.controller.action.mylist.MyPage;
import com.saeyan.controller.action.qnaboard.QNABoardCheckPassAction;
import com.saeyan.controller.action.qnaboard.QNABoardCheckPassFormAction;
import com.saeyan.controller.action.qnaboard.QNABoardDeleteAction;
import com.saeyan.controller.action.qnaboard.QNABoardListAction;
import com.saeyan.controller.action.qnaboard.QNABoardReplyAction;
import com.saeyan.controller.action.qnaboard.QNABoardReplyFormAction;
import com.saeyan.controller.action.qnaboard.QNABoardSearch;
import com.saeyan.controller.action.qnaboard.QNABoardUpdateAction;
import com.saeyan.controller.action.qnaboard.QNABoardUpdateFormAction;
import com.saeyan.controller.action.qnaboard.QNABoardViewAction;
import com.saeyan.controller.action.qnaboard.QNABoardWriteAction;
import com.saeyan.controller.action.qnaboard.QNABoardWriteFormAction;
import com.saeyan.controller.action.tv.TVDeletePost;
import com.saeyan.controller.action.tv.TVList;
import com.saeyan.controller.action.tv.TVUpdate;
import com.saeyan.controller.action.tv.TVUpdatePost;
import com.saeyan.controller.action.tv.TVView;
import com.saeyan.controller.action.tv.TVViewMore;
import com.saeyan.controller.action.tv.TVWrite;
import com.saeyan.controller.action.tv.TVWritePost;
import com.saeyan.controller.header.HeaderSearch;


public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory :" + command);
		/* 추가된 부분 */
		if (command.equals("board_list")) {
			action = new BoardListAction();
		} else if (command.equals("board_write_form")) {
			action = new BoardWriteFormAction();
		} else if (command.equals("board_write")) {
			action = new BoardWriteAction();
		} else if (command.equals("board_view")) {
			action = new BoardViewAction();
		} else if (command.equals("board_check_pass_form")) {
			action = new BoardCheckPassFormAction();
		} else if (command.equals("board_check_pass")) {
			action = new BoardCheckPassAction();
		} else if (command.equals("board_update_form")) {
			action = new BoardUpdateFormAction();
		} else if (command.equals("board_update")) {
			action = new BoardUpdateAction();
		} else if (command.equals("board_delete")) {
			action = new BoardDeleteAction();
		} else if (command.equals("board_reply_form")) { //board_reply_form
			action = new BoardReplyFormAction();
		} else if (command.equals("board_reply")) { //board_reply
			action = new BoardReplyAction();
		} else if (command.equals("member_login")) {
			action = new MemberLogin();
		} else if (command.equals("member_logout")) {
			action = new MemberLogout();
		} else if (command.equals("member_join")) {
			action = new MemberJoin();
		} else if (command.equals("member_update")) {
			action = new MemberUpdate();
		} else if (command.equals("member_id_check")) {
			action = new MemberIdCheck();
		} else if (command.equals("member_pwd_check")) {
			action = new MemberpwdCheck();
		} else if (command.equals("member_join_post")) {
			action = new MemberJoinPost();
		} else if (command.equals("member_login_post")) {
			action = new MemberLoginPost();
		} else if (command.equals("member_update_post")) {
			action = new MemberUpdatePost();
		} else if (command.equals("member_delete")) {
			action = new MemberDelete();
		} else if (command.equals("member_delete_pro")) {
			action = new MemberDeletePro();
		} else if (command.equals("movie_list")) {
			action = new MovieList();
		} else if (command.equals("movie_update")) {
			action = new MovieUpdate();
		} else if (command.equals("movie_update_post")) {
			action = new MovieUpdatePost();
		} else if (command.equals("movie_write")) {
			action = new MovieWrite();
		} else if (command.equals("movie_write_post")) {
			action = new MovieWritePost();
		} else if (command.equals("movie_upload_post")) {
			action = new MovieUpdatePost();
		} else if (command.equals("movie_delete")) {
			action = new MovieDelete();
		} else if (command.equals("movie_delete_post")) {
			action = new MovieDeletePost();
		} else if (command.equals("movie_view")) {
			action = new MovieView();
		} else if (command.equals("movie_viewmore")) {
			action = new MovieViewMore();
		} else if (command.equals("movie_reply")) {
			action = new MovieReply();
		} else if (command.equals("upload_post")) {
			action = new UploadPost();
		} else if (command.equals("tv_list")) {
			action = new TVList();
		} else if (command.equals("tv_update")) {
			action = new TVUpdate();
		} else if (command.equals("tv_update_post")) {
			action = new TVUpdatePost();
		} else if (command.equals("tv_write")) {
			action = new TVWrite();
		} else if (command.equals("tv_write_post")) {
			action = new TVWritePost();
		} else if (command.equals("tv_upload_post")) {
			action = new TVUpdatePost();
		} else if (command.equals("tv_delete")) {
			action = new TVDelete();
		} else if (command.equals("tv_delete_post")) {
			action = new TVDeletePost();
		} else if (command.equals("movie_crawling")) {
			action = new MovieCrawling();
		} else if (command.equals("qnaboard_list")) {
			action = new QNABoardListAction();
		} else if (command.equals("qnaboard_write_form")) {
			action = new QNABoardWriteFormAction();
		} else if (command.equals("qnaboard_write")) {
			action = new QNABoardWriteAction();
		} else if (command.equals("qnaboard_view")) {
			action = new QNABoardViewAction();
		} else if (command.equals("qnaboard_check_pass_form")) {
			action = new QNABoardCheckPassFormAction();
		} else if (command.equals("qnaboard_check_pass")) {
			action = new QNABoardCheckPassAction();
		} else if (command.equals("qnaboard_update_form")) {
			action = new QNABoardUpdateFormAction();
		} else if (command.equals("qnaboard_update")) {
			action = new QNABoardUpdateAction();
		} else if (command.equals("qnaboard_delete")) {
			action = new QNABoardDeleteAction();
		} else if (command.equals("qnaboard_reply_form")) { 
			action = new QNABoardReplyFormAction();
		} else if (command.equals("qnaboard_reply")) { 
			action = new QNABoardReplyAction();
		} else if (command.equals("movie_add_mylist")) { 
			action = new MovieAddMyList();
		} else if (command.equals("mylist_movie")) { 
			action = new MyListMovie();
		} else if (command.equals("header_search")) { 
			action = new HeaderSearch();
		} else if (command.equals("tv_view")) { 
			action = new TVView();
		} else if (command.equals("board_search")) { 
			action = new BoardSearch();
		} else if (command.equals("qnaboard_search")) { 
			action = new QNABoardSearch();
		} else if (command.equals("mylist_tv")) { 
			action = new MyListTV();
		} else if (command.equals("mylist_delete")) { 
			action = new MyListDelete();
		} else if (command.equals("my_page")) { 
			action = new MyPage();
		} else if (command.equals("tv_viewmore")) { 
			action = new TVViewMore();
		} 
		return action;
	}
}

