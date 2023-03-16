package com.saeyan.controller.action.movie;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.controller.action.Action;
import com.saeyan.dao.MovieDAO;
import com.saeyan.dto.MovieVO;

public class MovieWritePost implements Action {

	   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      ServletContext context = request.getSession().getServletContext();
		      String path = context.getRealPath("upload");
		      String encType = "UTF-8";
		      int sizeLimit = 20 * 1024 * 1024;

		      MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());    //new DefaultFileRenamePolicy() 중복을 방지하는것                              

		      String title = multi.getParameter("title");
		      String year = multi.getParameter("year");
		      String genre = multi.getParameter("genre");
		      String time = multi.getParameter("time");
		      String country = multi.getParameter("country");
		      String age = multi.getParameter("age");
		      String rate = multi.getParameter("rate");
		      String summary = multi.getParameter("summary");
		      String rank = multi.getParameter("rank");
		      String aud = multi.getParameter("aud");
		      String review = multi.getParameter("review");
//		      String pictureURL = multi.getParameter("pictureURL");

		      

		      MovieVO pVo = new MovieVO();
		      pVo.setTitle(title);
		      pVo.setTitle(title);
		      pVo.setTitle(title);
		      pVo.setTitle(title);
		      pVo.setTitle(title);
		      pVo.setTitle(title);
		      pVo.setTitle(title);
		      pVo.setTitle(title);
		      pVo.setTitle(title);
		      pVo.setRate(rate);
		      pVo.setGenre(genre);
		      

		      MovieDAO pDao = MovieDAO.getInstance();
		      pDao.insertMovie(pVo);

		      response.sendRedirect("BoardServlet?command=movie_list");
		   }
}