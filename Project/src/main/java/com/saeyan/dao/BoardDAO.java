package com.saeyan.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

import com.saeyan.dto.BoardVO;
import com.saeyan.dto.MovieVO;

public class BoardDAO {
	private BoardDAO() {
	}

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	public List<BoardVO> selectAllBoards() {
		String sql = "select * from board order by bgroup desc, bsequence asc";
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				BoardVO bVo = new BoardVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getDate("writedate"));
				bVo.setBgroup(rs.getInt("bgroup"));
				bVo.setBsequence(rs.getInt("bsequence"));
				bVo.setBlevel(rs.getInt("blevel"));
				bVo.setUserid(rs.getString("userid"));
				list.add(bVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	public void insertBoard(BoardVO bVo) {
		String sql = "insert into board("
				+ "num, title, content, readcount, writedate, bgroup, bsequence, blevel, userid) "
				+ "values(board_seq.nextval, ?, ?, ?, ?, (select nvl((max(bgroup)+1),0) from board), 0, 0, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		   // 현재 날짜 구하기
        LocalDate now = LocalDate.now();
 
        // 포맷 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
 
        // 포맷 적용
        String formatedNow = now.format(formatter);
 
        // 결과 출력
        System.out.println(formatedNow);  // 2021/06/17
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bVo.getTitle());
			pstmt.setString(2, bVo.getContent());
			pstmt.setInt(3, bVo.getReadcount());
			pstmt.setString(4, formatedNow);
			pstmt.setString(5, bVo.getUserid());
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
			System.out.println(bVo.getTitle());
			System.out.println(bVo.getContent());
			System.out.println(bVo.getReadcount());
			System.out.println(bVo.getBgroup());
			System.out.println(bVo.getBsequence());
			System.out.println(bVo.getBlevel());
			System.out.println(bVo.getUserid());
		}
	}

	public void insertReplyBoard(BoardVO bVo) {
		String sql = "insert into board("
				+ "num, title, content, bgroup, bsequence, blevel, userid) "
				+ "values(board_seq.nextval, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getTitle());
			pstmt.setString(2, bVo.getContent());
			pstmt.setInt(3, bVo.getBgroup());
			pstmt.setInt(4, bVo.getBsequence());
			pstmt.setInt(5, bVo.getBlevel());
			pstmt.setString(6, bVo.getUserid());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void updateReadCount(String num) {
		String sql = "update board set readcount=readcount+1 where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void replySeqUpdate(BoardVO vo) {
		String sql = "update board set bsequence=bsequence+1 where bgroup=? and bsequence>?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBgroup());
			pstmt.setInt(2, vo.getBsequence());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 게시판 글 상세 내용 보기 :글번호로 찾아온다. : 실패 null,
	public BoardVO selectOneBoardByNum(String num) {
		String sql = "select * from board where num = ?";
		BoardVO bVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bVo = new BoardVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setWritedate(rs.getDate("writedate"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setBgroup(rs.getInt("bgroup"));
				bVo.setBsequence(rs.getInt("bsequence"));
				bVo.setBlevel(rs.getInt("blevel"));
				bVo.setUserid(rs.getString("userid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bVo;
	}

	public void updateBoard(BoardVO bVo) {
		String sql = "update board set "
				+ "title=?, content=? where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getTitle());
			pstmt.setString(2, bVo.getContent());
			pstmt.setInt(3, bVo.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public BoardVO checkPassWord(String pass, String num) {
		String sql = "select * from board where and num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO bVo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bVo = new BoardVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getTimestamp("writedate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bVo;
	}

	public void deleteBoard(String num) {
		String sql = "delete board where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<BoardVO> SearchBoard(String SK) throws SQLException, IOException {
		SK = '%'+SK+'%';
		String sql = "select * from board where title like ?";
		int k = 1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> list = new ArrayList<>();
		BoardVO mvo = null;
		System.out.println(SK+"11");
		System.out.println(SK+"11");
		System.out.println(SK+"11");
		System.out.println(SK+"11");
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, SK);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				mvo = new BoardVO();
				mvo.setNum(rs.getInt("num")); // 번호
				mvo.setUserid(rs.getString("userid")); // 네티즌 평점
				mvo.setTitle(rs.getString("title")); // 영화 제목 
				mvo.setContent(rs.getString("content")); // 개요
				mvo.setWritedate(rs.getDate("writedate")); // 감독
				mvo.setReadcount(rs.getInt("readcount")); // 감독
				mvo.setBgroup(rs.getInt("bgroup")); // 감독
				mvo.setBsequence(rs.getInt("bsequence")); // 감독
				mvo.setBlevel(rs.getInt("blevel")); // 감독
				list.add(mvo);
			}
			
		} finally {
			System.out.println(mvo+"12");
			System.out.println(mvo+"12");
			System.out.println(mvo+"12");
			System.out.println(mvo+"12");
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
}