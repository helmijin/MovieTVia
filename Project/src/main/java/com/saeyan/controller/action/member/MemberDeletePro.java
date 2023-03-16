package com.saeyan.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.MemberDAO;

public class MemberDeletePro implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id = request.getParameter("userid");
		  System.out.println(id);
	        MemberDAO dao = MemberDAO.getInstance();
	        dao.deleteMember(id);
	        
	       session.invalidate(); 
	       
	       response.sendRedirect("BoardServlet?command=movie_list");
		
	}

}
