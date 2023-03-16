package com.saeyan.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import util.DBManager;

import com.saeyan.dto.BoardVO;
import com.saeyan.dto.QNABoardVO;

public class QNABoardDAO {
	private QNABoardDAO() {
	}

	private static QNABoardDAO instance = new QNABoardDAO();

	public static QNABoardDAO getInstance() {
		return instance;
	}

	public List<QNABoardVO> selectAllQNABoards() {
		String sql = "select * from qnaboard order by bgroup desc, bsequence asc";
		List<QNABoardVO> list = new ArrayList<QNABoardVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				QNABoardVO bVo = new QNABoardVO();
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

	public void insertQNABoard(QNABoardVO bVo) {
		String sql = "insert into qnaboard(" + "num, title, content, writedate, bgroup, bsequence, blevel, userid) "
				+ "values(qboard_seq.nextval, ?, ?, ?, (select nvl((max(bgroup)+1),0) from board), 0, 0, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		// 현재 날짜 구하기
		LocalDate now = LocalDate.now();

		// 포맷 정의
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

		// 포맷 적용
		String formatedNow = now.format(formatter);
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getTitle());
			pstmt.setString(2, bVo.getContent());
			pstmt.setString(3, formatedNow);
			pstmt.setString(4, bVo.getUserid());
			

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void insertReplyQNABoard(QNABoardVO bVo) {
		String sql = "insert into qnaboard(" + "num, title, content, writedate, bgroup, bsequence, blevel, userid) "
				+ "values(qboard_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		LocalDate now = LocalDate.now();

		// 포맷 정의
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

		// 포맷 적용
		String formatedNow = now.format(formatter);
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVo.getTitle());
			pstmt.setString(2, bVo.getContent());
			pstmt.setString(3, formatedNow);
			pstmt.setInt(4, bVo.getBgroup());
			pstmt.setInt(5, bVo.getBsequence());
			pstmt.setInt(6, bVo.getBlevel());
			pstmt.setString(7, bVo.getUserid());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void updateReadCount(String num) {
		String sql = "update qnaboard set readcount=readcount+1 where num=?";
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

	public void replySeqUpdate(QNABoardVO vo) {
		String sql = "update qnaboard set bsequence=bsequence+1 where bgroup=? and bsequence>?";
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
	public QNABoardVO selectOneQNABoardByNum(String num) {
		String sql = "select * from qnaboard where num = ?";
		QNABoardVO qVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				qVo = new QNABoardVO();
				qVo.setNum(rs.getInt("num"));
				qVo.setTitle(rs.getString("title"));
				qVo.setContent(rs.getString("content"));
				qVo.setWritedate(rs.getDate("writedate"));
				qVo.setReadcount(rs.getInt("readcount"));
				qVo.setBgroup(rs.getInt("bgroup"));
				qVo.setBsequence(rs.getInt("bsequence"));
				qVo.setBlevel(rs.getInt("blevel"));
				qVo.setUserid(rs.getString("userid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return qVo;
	}

	public void updateQNABoard(QNABoardVO bVo) {
		String sql = "update qnaboard set " + "title=?, content=? where num=?";
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

	public QNABoardVO checkPassWord(String pass, String num) {
		String sql = "select * from qnaboard where and num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QNABoardVO bVo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bVo = new QNABoardVO();
				bVo.setNum(rs.getInt("num"));
				bVo.setTitle(rs.getString("title"));
				bVo.setContent(rs.getString("content"));
				bVo.setReadcount(rs.getInt("readcount"));
				bVo.setWritedate(rs.getDate("writedate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bVo;
	}

	public void deleteQNABoard(String num) {
		String sql = "delete qnaboard where num=?";
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

	public List<QNABoardVO> SearchQNABoard(String SK) throws SQLException, IOException {
		SK = '%' + SK + '%';
		String sql = "select * from qnaboard where title like ?";
		int k = 1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QNABoardVO> list = new ArrayList<>();
		QNABoardVO mvo = null;
		System.out.println(SK + "11");
		System.out.println(SK + "11");
		System.out.println(SK + "11");
		System.out.println(SK + "11");
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, SK);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				mvo = new QNABoardVO();
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
			System.out.println(mvo + "12");
			System.out.println(mvo + "12");
			System.out.println(mvo + "12");
			System.out.println(mvo + "12");
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
}