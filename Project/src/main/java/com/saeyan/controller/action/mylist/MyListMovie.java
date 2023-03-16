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

public class MyListMovie implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid");
		
		MyListDAO mdao = MyListDAO.getInstance();
		List<MyListVO> mvo = mdao.selectAllMyDibMovieList(userid);
		
		request.setAttribute("mylist", mvo);
		RequestDispatcher dis = request.getRequestDispatcher("mylist/MyListMovie.jsp");
		dis.forward(request, response);
	}

}
