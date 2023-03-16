package com.saeyan.controller.action.qnaboard;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.QNABoardDAO;
import com.saeyan.dto.QNABoardVO;

public class QNABoardListAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/qnaboard/qnaboardList.jsp";
		QNABoardDAO bDao = QNABoardDAO.getInstance();
		List<QNABoardVO> qnaboardList = bDao.selectAllQNABoards();
		request.setAttribute("qnaboardList", qnaboardList);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
