package com.saeyan.controller.action.qnaboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.saeyan.controller.action.Action;
import com.saeyan.dao.QNABoardDAO;
import com.saeyan.dto.QNABoardVO;


public class QNABoardWriteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		QNABoardVO bVo = new QNABoardVO();
		bVo.setTitle("Q:"+request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));
		bVo.setUserid(request.getParameter("userid"));
		QNABoardDAO bDao = QNABoardDAO.getInstance();
		bDao.insertQNABoard(bVo);
		

		response.sendRedirect("BoardServlet?command=qnaboard_list");
	}
}
