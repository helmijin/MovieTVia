package com.saeyan.controller.action.qnaboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.MemberDAO;
import com.saeyan.dao.QNABoardDAO;
import com.saeyan.dto.QNABoardVO;

public class QNABoardCheckPassAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;
		String num = request.getParameter("num");
		String pwd = request.getParameter("pwd");
		String userpwd =  request.getParameter("userpwd");
		QNABoardDAO bDao = QNABoardDAO.getInstance();
		QNABoardVO bVo = bDao.selectOneQNABoardByNum(num);
		MemberDAO mDao = MemberDAO.getInstance(); 
		if (userpwd.equals(pwd)) { // 성공
			url = "/qnaboard/qnacheckSuccess.jsp";
		} else {// 실패
			url = "/qnaboard/qnaboardCheckPass.jsp";
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}