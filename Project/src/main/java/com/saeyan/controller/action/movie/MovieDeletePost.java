package com.saeyan.controller.action.movie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.MovieDAO;

public class MovieDeletePost implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");

		MovieDAO pDao = MovieDAO.getInstance();
		pDao.deleteMovie(code);

		response.sendRedirect("BoardServlet?command=movie_list");		
	}

}
