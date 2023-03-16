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

public class TVList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TVDAO dao = TVDAO.getInstance();
		List<TVVO> tvList = dao.selectAllTVs();
		request.setAttribute("tvList", tvList);
		
		RequestDispatcher dis = request.getRequestDispatcher("tv/tvList.jsp");
		dis.forward(request, response);
		}
	}


