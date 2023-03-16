package com.saeyan.controller.header;

import java.io.IOException;
import java.sql.SQLException;
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

public class HeaderSearch implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchKeyword = request.getParameter("searchKeyword");
		System.out.println(searchKeyword);
		System.out.println(searchKeyword);
		System.out.println(searchKeyword);
		MovieDAO bDao = MovieDAO.getInstance();
		TVDAO tDao = TVDAO.getInstance();
		List<MovieVO> pVo = null;
		List<TVVO> tVo = null;
		try {
			pVo = bDao.SearchMovie(searchKeyword);
			tVo = tDao.SearchTV(searchKeyword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		request.setAttribute("MovieList", pVo);
		request.setAttribute("tvList", tVo);
		System.out.println(pVo);
		System.out.println(pVo);
		System.out.println(pVo);
		System.out.println(tVo);
		System.out.println(tVo);
		System.out.println(tVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("header/headerSearch.jsp");
		dispatcher.forward(request, response);
	}

}
