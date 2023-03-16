package com.saeyan.controller.action.movie;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.MovieDAO;
import com.saeyan.dao.TVDAO;
import com.saeyan.dto.MovieVO;
import com.saeyan.dto.TVVO;

public class MovieCrawling implements Action {


	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "movie/MovieList.jsp";
	      MovieDAO bDao = MovieDAO.getInstance();
	      TVDAO tDao = TVDAO.getInstance();
	      List<MovieVO> movieList = new ArrayList<>();
	      List<TVVO> tvList = new ArrayList<>();
	      System.out.println(movieList);
	      try {
	    	  movieList = bDao.MovieCrawling();
	    	  tvList = tDao.TVCrawling();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      
	      response.sendRedirect("BoardServlet?command=movie_list");
	}

	
}
