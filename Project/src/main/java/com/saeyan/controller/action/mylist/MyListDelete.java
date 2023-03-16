package com.saeyan.controller.action.mylist;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.MyListDAO;
import com.saeyan.dto.MyListVO;

public class MyListDelete implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		String title = request.getParameter("title");
		String category = request.getParameter("category");

		MyListVO mvo = new MyListVO();
		mvo.setId(userid);
		mvo.setTitle(title);
		
		MyListDAO mdao = MyListDAO.getInstance();
		mdao.deleteMyList(mvo);

		response.sendRedirect("BoardServlet?command=mylist_"+category+"&userid="+userid);
	}

}
