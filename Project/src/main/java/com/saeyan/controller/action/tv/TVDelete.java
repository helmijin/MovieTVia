package com.saeyan.controller.action.tv;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.TVDAO;
import com.saeyan.dto.TVVO;

public class TVDelete implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");

		TVDAO pDao = TVDAO.getInstance();
		List<TVVO> pVo = pDao.selectTVByTitle(title);

		request.setAttribute("tv", pVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("tv/tvDelete.jsp");
		dispatcher.forward(request, response);
	}

}
