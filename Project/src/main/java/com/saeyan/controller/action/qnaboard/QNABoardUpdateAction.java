package com.saeyan.controller.action.qnaboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.QNABoardDAO;
import com.saeyan.dto.QNABoardVO;

public class QNABoardUpdateAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		QNABoardVO bVo = new QNABoardVO();
		bVo.setNum(Integer.parseInt(request.getParameter("num")));
		bVo.setTitle(request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));
		QNABoardDAO bDao = QNABoardDAO.getInstance();
		bDao.updateQNABoard(bVo);
		new QNABoardListAction().execute(request, response);
	}
}
