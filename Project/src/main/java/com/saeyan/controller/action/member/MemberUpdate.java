package com.saeyan.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.controller.action.Action;
import com.saeyan.dto.MemberVO;

public class MemberUpdate implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO mVo = (MemberVO) session.getAttribute("userid");
		System.out.println(mVo);
//		String userid = request.getParameter("userid");
//		MemberDAO mDao = MemberDAO.getInstance();
//		MemberVO mVo = mDao.getMember(userid);
		request.setAttribute("mVo", mVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/memberUpdate.jsp");
		dispatcher.forward(request, response);

	}

}
