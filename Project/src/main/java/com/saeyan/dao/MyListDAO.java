package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.BoardVO;
import com.saeyan.dto.MovieVO;
import com.saeyan.dto.MyListVO;
import com.saeyan.dto.ReplyVO;

import util.DBManager;

/*
---------- - ------------- 
ID           VARCHAR2(10)  
TITLE        VARCHAR2(100) 
RATE         VARCHAR2(10)  
DIB          NUMBER(1)     
REVIEW       VARCHAR2(400) 
PICTUREURL   VARCHAR2(50)
*/

public class MyListDAO {

	private MyListDAO() {
	}

	public static MyListDAO instance = new MyListDAO();

	public static MyListDAO getInstance() {
		return instance;
	}
	
	public List<MyListVO> selectAllMyDibMovieList(String userid) {
	      String sql = "select * from mypage where id=? and category='Movie'";
	      List<MyListVO> list = new ArrayList<MyListVO>();
	      MyListVO vo = new MyListVO();
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;

	      try {
	         conn = DBManager.getConnection();
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, userid);
	         rs = pstmt.executeQuery();

	         while (rs.next()) {
	        	vo = new MyListVO();
	            vo.setTitle(rs.getString("title"));
	            vo.setImg(rs.getString("img"));
	            list.add(vo);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         DBManager.close(conn, pstmt, rs);
	         System.out.println(list);
	         System.out.println(list);
	         System.out.println(list);
	         System.out.println(list);
	      }
	      return list;
	   }
	
	public List<MyListVO> selectAllMyDibTVList	(String userid) {
	      String sql = "select * from mypage where id=? and category='TV'";
	      List<MyListVO> list = new ArrayList<MyListVO>();
	      MyListVO vo = new MyListVO();
	      
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;

	      try {
	         conn = DBManager.getConnection();
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, userid);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	        	vo = new MyListVO();
	            vo.setTitle(rs.getString("title"));	   
	            vo.setImg(rs.getString("img"));
	            list.add(vo);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         DBManager.close(conn, pstmt, rs);
	         System.out.println("99999999");
	         System.out.println(list);
	         System.out.println(list);
	         System.out.println(list);
	         System.out.println(list);
	         System.out.println(rs);
	         System.out.println(rs);
	         System.out.println("99999999");
	      }
	     
	      return list;
	      
	   }
	
	public int selectsearchMyList (MyListVO mvo) {
	      String sql = "select * from mypage where id=? and title=?";
	      int count = 0;
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;

	      try {
	         conn = DBManager.getConnection();
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, mvo.getId());
	         pstmt.setString(2, mvo.getTitle());
	         rs = pstmt.executeQuery();
	         
	         if (rs.next()) {
	        	mvo = new MyListVO();
	        	mvo.setId(rs.getString("id"));
	            mvo.setTitle(rs.getString("title"));	            
	            mvo.setCategory(rs.getString("category"));	            
	            count++;
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         DBManager.close(conn, pstmt, rs);
	      }
	    	  return count;
	   }
	
	public void insertMyList(MyListVO bVo) {
		String sql = "insert into mypage("
				+ "id, title, category, img) "
				+ "values(?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		   // 현재 날짜 구하기
       
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bVo.getId());
			pstmt.setString(2, bVo.getTitle());
			pstmt.setString(3, bVo.getCategory());
			pstmt.setString(4, bVo.getImg());
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
			System.out.println(bVo.getTitle());
	
		}
	}

	public void deleteMyList(MyListVO bVo) {
		String sql = "delete from mypage where id=? and title=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		   // 현재 날짜 구하기
       
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bVo.getId());
			pstmt.setString(2, bVo.getTitle());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	
	
}
