package com.saeyan.controller.action.movie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.ReplyDAO;
import com.saeyan.dto.ReplyVO;

public class MovieReply implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReplyDAO rDao = ReplyDAO.getInstance();
		ReplyVO rVo = new ReplyVO();
		int rno = 0;
		
		String num = request.getParameter("num");
		String title = request.getParameter("title");
		String userid = request.getParameter("userid");
		String content = request.getParameter("content");
		
		if(title.equals("null")) {
		rno = Integer.parseInt(request.getParameter("rno"));
		}
		
		rVo.setRno(rno);
		rVo.setTitle(title);
		rVo.setUserid(userid);
		rVo.setContents(content);
		rDao.insertReply(rVo);
		
		
		response.sendRedirect("BoardServlet?command=movie_view&num="+num);
	}

}