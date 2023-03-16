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

public class MovieViewMore implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/movie/MovieViewMore.jsp";
		String num = request.getParameter("num");
		
		
		MovieDAO bDao = MovieDAO.getInstance();
		List<MovieVO> pVo = bDao.selectOneMovieByNum(num);
		request.setAttribute("Movie", pVo);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
