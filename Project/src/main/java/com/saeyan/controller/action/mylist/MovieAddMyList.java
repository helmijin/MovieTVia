package com.saeyan.controller.action.mylist;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
public class MovieAddMyList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String category = request.getParameter("category");
		String img = request.getParameter("img");
		String num = request.getParameter("num");
		PrintWriter out = response.getWriter();
		System.out.println(id);
		System.out.println(id);
		System.out.println(id);
		System.out.println(id);
		System.out.println(id);
		System.out.println(id);
		System.out.println("99999999999999999999");

		MyListVO mvo = new MyListVO();
		mvo.setId(id);
		mvo.setTitle(title);
		mvo.setCategory(category);
		mvo.setImg(img);

		MyListDAO mdao = MyListDAO.getInstance();
		int count = mdao.selectsearchMyList(mvo); // 영화 중복 조회
		if (count == 0) {
			mdao.insertMyList(mvo);
		}

		if (id.equals("")) {
			response.sendRedirect("BoardServlet?command=member_login");
		} else if (category.equals("TV")) {
			response.sendRedirect("BoardServlet?command=tv_view&num=" + num);
		} else
			response.sendRedirect("BoardServlet?command=movie_view&num=" + num);

	}

}
