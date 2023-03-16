package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.ReplyVO;

import util.DBManager;

public class ReplyDAO {
	private ReplyDAO() {}
	   
	   public static ReplyDAO instance = new ReplyDAO();

	   public static ReplyDAO getInstance() {
	      return instance;
	   }
	   
	   public void insertReply(ReplyVO rVo) {
			String sql = "insert into reply(rno,code,writer,contents,title) values(?, reply_seq.nextval, ?, ?, ?)";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, rVo.getRno());
				pstmt.setString(2, rVo.getUserid());
				pstmt.setString(3, rVo.getContents());
				pstmt.setString(4, rVo.getTitle());
				
				pstmt.executeUpdate(); // 실행
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(rVo);
				System.out.println(rVo);
				System.out.println(rVo);
				System.out.println(rVo);
				System.out.println(rVo);
				System.out.println(rVo);
			}finally {
				DBManager.close(conn, pstmt);
			}
		}
	   
	   public List<ReplyVO> selectReplyByCode(String title) {
			String sql = "select * from reply where title=?";
			ReplyVO pVo = null;
			List<ReplyVO> list = new ArrayList<ReplyVO>();
			try {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, title);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						pVo = new ReplyVO();
						pVo.setCode(rs.getInt("code"));
						pVo.setRno(rs.getInt("rno"));
						pVo.setContents(rs.getString("contents"));
						pVo.setUserid(rs.getString("writer"));
						pVo.setRsequence(rs.getInt("rsequence"));
						pVo.setTitle(rs.getString("title"));
						list.add(pVo);
					}
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					DBManager.close(conn, pstmt, rs);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	   
	   public List<ReplyVO> selectReplyByRno(String rno) {
			String sql = "select * from reply where rno=?";
			ReplyVO pVo = null;
			List<ReplyVO> list = new ArrayList<ReplyVO>();
			try {
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, rno);
					rs = pstmt.executeQuery();
					while(rs.next()) {
						pVo = new ReplyVO();
						pVo.setCode(rs.getInt("code"));
						pVo.setRno(rs.getInt("rno"));
						pVo.setContents(rs.getString("contents"));
						pVo.setUserid(rs.getString("writer"));
						pVo.setRsequence(rs.getInt("rsequence"));
						pVo.setTitle(rs.getString("title"));
						list.add(pVo);
					}
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					DBManager.close(conn, pstmt, rs);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		}
}
