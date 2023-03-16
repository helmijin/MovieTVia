package com.saeyan.controller.action.qnaboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.QNABoardDAO;
import com.saeyan.dto.QNABoardVO;

public class QNABoardUpdateFormAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/qnaboard/qnaboardUpdate.jsp";
		String num = request.getParameter("num");
		QNABoardDAO bDao = QNABoardDAO.getInstance();
		bDao.updateReadCount(num);
		QNABoardVO bVo = bDao.selectOneQNABoardByNum(num);
		request.setAttribute("qnaboard", bVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
