package com.saeyan.controller.action.movie;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.MovieDAO;
import com.saeyan.dao.ReplyDAO;
import com.saeyan.dto.MovieVO;
import com.saeyan.dto.ReplyVO;

public class MovieView implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/movie/MovieView.jsp";
		String title = request.getParameter("title");
		String num = request.getParameter("num");
		
		
		MovieDAO bDao = MovieDAO.getInstance();
		List<MovieVO> pVo = bDao.selectOneMovieByNum(num);
		request.setAttribute("Movie", pVo);
		
		System.out.println(pVo);
		System.out.println(pVo);
		System.out.println(pVo);
		
		ReplyDAO rDao = ReplyDAO.getInstance();
		List<ReplyVO> replyList = rDao.selectReplyByCode(title);
		int count = 0;
		for(ReplyVO list : replyList) {
			count++; 
		}
		
		request.setAttribute("title", title);
		request.setAttribute("count", count);
		request.setAttribute("replyList", replyList);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
