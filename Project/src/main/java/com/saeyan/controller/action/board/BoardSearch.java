package com.saeyan.controller.action.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.BoardDAO;
import com.saeyan.dao.MovieDAO;
import com.saeyan.dto.BoardVO;
import com.saeyan.dto.MovieVO;

public class BoardSearch implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchKeyword = request.getParameter("searchKeyword");
		System.out.println(searchKeyword);
		System.out.println(searchKeyword);
		System.out.println(searchKeyword);
		BoardDAO bDao = BoardDAO.getInstance();
		List<BoardVO> pVo = null;
		try {
			pVo = bDao.SearchBoard(searchKeyword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		request.setAttribute("boardList", pVo);
		System.out.println(pVo);
		System.out.println(pVo);
		System.out.println(pVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("board/boardList.jsp");
		dispatcher.forward(request, response);
	}

}
