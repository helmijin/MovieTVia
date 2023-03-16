package com.saeyan.controller.action.movie;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.MovieDAO;
import com.saeyan.dto.MovieVO;

public class MovieUpdate implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");

		MovieDAO pDao = MovieDAO.getInstance();
		List<MovieVO> pVo = pDao.selectOneMovieByNum(code);

		request.setAttribute("Movie", pVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("movie/MovieUpdate.jsp");
		dispatcher.forward(request, response);	
	}

}
