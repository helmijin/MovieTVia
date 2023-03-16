package com.saeyan.controller.action.qnaboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.swing.JOptionPane;

import com.saeyan.controller.action.Action;


public class QNABoardWriteFormAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		System.out.println(userid);
		System.out.println(userid);
		System.out.println(userid);
		if(userid!="") {
		String url = "/qnaboard/qnaboardWrite.jsp";
		System.out.println(userid);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		}
		else if(userid=="") {
		JOptionPane aa=new JOptionPane();
		aa.showMessageDialog(null, "로그인 후 이용해주세요");
			response.sendRedirect("BoardServlet?command=qnaboard_list");
		}
	}
}
