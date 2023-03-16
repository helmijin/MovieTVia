package com.saeyan.controller.action.movie;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.MovieDAO;
import com.saeyan.dto.MovieVO;

public class MovieList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDAO dao = MovieDAO.getInstance();
		List<MovieVO> MovieList = dao.selectAllMovie();
		request.setAttribute("MovieList", MovieList);
		
		System.out.println(MovieList);
		

		RequestDispatcher dis = request.getRequestDispatcher("movie/MovieList.jsp");
		dis.forward(request, response);
		
	
	}	
}



