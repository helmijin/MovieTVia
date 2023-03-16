package com.saeyan.controller.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.saeyan.controller.action.Action;
import com.saeyan.dao.BoardDAO;

import com.saeyan.dto.BoardVO;


public class BoardWriteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		BoardVO bVo = new BoardVO();
		bVo.setTitle(request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));
		bVo.setUserid(request.getParameter("userid"));
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.insertBoard(bVo);
		

		response.sendRedirect("BoardServlet?command=board_list");
	}
}
