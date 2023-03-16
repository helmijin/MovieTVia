package com.saeyan.controller.action.tv;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.MovieDAO;
import com.saeyan.dao.ReplyDAO;
import com.saeyan.dao.TVDAO;
import com.saeyan.dto.MovieVO;
import com.saeyan.dto.ReplyVO;
import com.saeyan.dto.TVVO;

public class TVViewMore implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/tv/tvViewMore.jsp";
		String num = request.getParameter("num");
		
		
		TVDAO bDao = TVDAO.getInstance();
		List<TVVO> pVo = bDao.selectTVByNum(num);
		request.setAttribute("Movie", pVo);
		System.out.println("123123");
		System.out.println(pVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
