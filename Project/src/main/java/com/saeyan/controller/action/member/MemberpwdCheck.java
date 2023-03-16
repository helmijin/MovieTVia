package com.saeyan.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;

public class MemberpwdCheck implements Action { 

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd = request.getParameter("deletepwd");
		String pwdvalue = request.getParameter("pwdvalue");
		int result = -1;

		System.out.println(pwd);
		System.out.println(pwdvalue);
		
		if(pwd.equals(pwdvalue)) {
			result =1;
		} else {
			result =-1;
		}
		
		
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("member/memberDelete.jsp");
		dispatcher.forward(request, response);
	}

}
