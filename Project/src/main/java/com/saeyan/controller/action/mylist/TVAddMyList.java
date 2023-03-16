package com.saeyan.controller.action.mylist;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.MyListDAO;
import com.saeyan.dto.MyListVO;

/*
---------- - ------------- 
ID           VARCHAR2(10)  
TITLE        VARCHAR2(100) 
RATE         VARCHAR2(10)  
DIB          NUMBER(1)     
REVIEW       VARCHAR2(400) 
PICTUREURL   VARCHAR2(50)
*/
public class TVAddMyList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("12312312312312");
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String img = request.getParameter("img");
		System.out.println("123");
		System.out.println(id);
		System.out.println(title);
		System.out.println("123");
		MyListVO mvo = new MyListVO();
		
		mvo.setId(id);
		mvo.setTitle(title);
		mvo.setCategory(category);
		mvo.setImg(img);
		
		MyListDAO mdao = MyListDAO.getInstance();
		
		mdao.insertMyList(mvo);
		
		response.sendRedirect("BoardServlet?command=movie_list");
		
	}

}
