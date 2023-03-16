package com.saeyan.controller.action.qnaboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.QNABoardDAO;

public class QNABoardDeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num=request.getParameter("num");
		QNABoardDAO bDao=QNABoardDAO.getInstance();
		bDao.deleteQNABoard(num);
		new QNABoardListAction().execute(request, response);
	}
}
