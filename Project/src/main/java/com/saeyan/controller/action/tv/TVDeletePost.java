package com.saeyan.controller.action.tv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.TVDAO;

public class TVDeletePost implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");

		TVDAO pDao = TVDAO.getInstance();
		pDao.deleteTV(code);

		response.sendRedirect("BoardServlet?command=tv_list");		
	}

}
