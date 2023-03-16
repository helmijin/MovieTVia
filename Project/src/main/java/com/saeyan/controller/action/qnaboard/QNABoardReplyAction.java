package com.saeyan.controller.action.qnaboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.QNABoardDAO;
import com.saeyan.dto.QNABoardVO;

public class QNABoardReplyAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QNABoardVO bVo = new QNABoardVO(); // 차일드 댓글
		String num = request.getParameter("num"); //num은 누구꺼? 부모꺼
		
		//부모 정보 가져오기
		QNABoardDAO dao = QNABoardDAO.getInstance();
		QNABoardVO pboard = dao.selectOneQNABoardByNum(num);
		
		//아래꺼는 누구꺼? 댓글본인꺼
		
		bVo.setUserid(request.getParameter("userid"));
		bVo.setTitle("A:"+request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));
		
		//공식에 따라서... bgroup는 같고, bsequence, blevel는 +1 시킨다.
		bVo.setBgroup(pboard.getBgroup());
		bVo.setBsequence(pboard.getBsequence()+1);
		bVo.setBlevel(pboard.getBlevel()+1);
		
		//기존 그들이 같은 댓글들 bsequence+1식 증가
		dao.replySeqUpdate(pboard);
		
		dao.insertReplyQNABoard(bVo);
		new QNABoardListAction().execute(request, response);
	}

}
