package com.saeyan.dao;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.saeyan.dto.MovieVO;
import com.saeyan.dto.TVVO;

import util.DBManager;

public class TVDAO {

	   private TVDAO() {}
	   
	   public static TVDAO instance = new TVDAO();

	   public static TVDAO getInstance() {
	      return instance;
	   }
	   
	   public List<TVVO> selectAllTVs(){
	      String sql = "select * from tv order by code asc";
	      
	      List<TVVO> list = new ArrayList<TVVO>();
	      
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      try {
	         conn = DBManager.getConnection();
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	            TVVO vo = new TVVO();
	            vo.setNum(rs.getInt("code"));
	            vo.setTitle(rs.getString("title"));
	            vo.setYear(rs.getString("year"));
	            vo.setGenre(rs.getString("genre"));
	            vo.setChannel(rs.getString("channel"));
	            vo.setCountry(rs.getString("country"));
	            vo.setAge(rs.getString("age"));
	            vo.setRate(rs.getString("rate"));
	            vo.setSummary(rs.getString("summary"));
	            vo.setReview(rs.getString("review"));
	            vo.setImg(rs.getString("img"));
	            vo.setBimg(rs.getString("bimg"));
	            
	            
	            list.add(vo);
	         }
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	         DBManager.close(conn,pstmt,rs);
	      }
	      return list;
	   }
	   // Create r u d
	   public void insertTV(TVVO pVo) {
	      String sql = "insert into tv values(tv_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      try {
	         conn = DBManager.getConnection();
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, pVo.getTitle());
	         pstmt.setString(2, pVo.getYear());
	         pstmt.setString(3, pVo.getGenre());
	         pstmt.setString(4, pVo.getChannel());
	         pstmt.setString(5, pVo.getCountry());
	         pstmt.setString(6, pVo.getAge());
	         pstmt.setString(7, pVo.getRate());
	         pstmt.setString(8, pVo.getSummary());
	         pstmt.setString(9, pVo.getReview());
	         pstmt.executeUpdate(); // 실행
	      } catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         DBManager.close(conn, pstmt);
	      }
	   }
	   // c Read u d
	   public List<TVVO> selectTVByNum(String num) {
	      String sql = "select * from tv where code=?";
	      List<TVVO> list = new ArrayList<TVVO>();
	      TVVO pVo = null;
	      try {
	         Connection conn = null;
	         PreparedStatement pstmt = null;
	         ResultSet rs = null;
	         try {
	            conn = DBManager.getConnection();
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, num);
	            rs = pstmt.executeQuery();
	            if(rs.next()) {
	               TVVO vo = new TVVO();
	               vo.setNum(rs.getInt("code"));
	               vo.setTitle(rs.getString("title"));
	               vo.setYear(rs.getString("year"));
	               vo.setGenre(rs.getString("genre"));
	               vo.setChannel(rs.getString("channel"));
	               vo.setCountry(rs.getString("country"));
	               vo.setAge(rs.getString("age"));
	               vo.setRate(rs.getString("rate"));
	               vo.setSummary(rs.getString("summary"));
	               vo.setReview(rs.getString("review"));
	               vo.setImg(rs.getString("img"));
	               vo.setBimg(rs.getString("bimg"));
	               
	               list.add(vo);
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
	   
	   public List<TVVO> selectTVByTitle(String title) {
		      String sql = "select * from tv where title=?";
		      List<TVVO> list = new ArrayList<TVVO>();
		      TVVO pVo = null;
		      try {
		         Connection conn = null;
		         PreparedStatement pstmt = null;
		         ResultSet rs = null;
		         try {
		            conn = DBManager.getConnection();
		            pstmt = conn.prepareStatement(sql);
		            pstmt.setString(1, title);
		            rs = pstmt.executeQuery();
		            if(rs.next()) {
		               TVVO vo = new TVVO();
		               vo.setNum(rs.getInt("code"));
		               vo.setTitle(rs.getString("title"));
		               vo.setYear(rs.getString("year"));
		               vo.setGenre(rs.getString("genre"));
		               vo.setChannel(rs.getString("channel"));
		               vo.setCountry(rs.getString("country"));
		               vo.setAge(rs.getString("age"));
		               vo.setRate(rs.getString("rate"));
		               vo.setSummary(rs.getString("summary"));
		               vo.setReview(rs.getString("review"));
		               vo.setImg(rs.getString("img"));
		               vo.setBimg(rs.getString("bimg"));
		               
		               list.add(vo);
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
	   
	   // c r Update d
	   public void updateTVList(TVVO pVo) {
	      String sql = "update tv set title=?, ygc=?, rate=?, genre=? pictureurl=?,  where code=?";
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      try {
	         conn = DBManager.getConnection();
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, pVo.getTitle());
	         pstmt.setString(2, pVo.getYear());
	         pstmt.setString(3, pVo.getGenre());
	         pstmt.setString(4, pVo.getChannel());
	         pstmt.setString(5, pVo.getCountry());
	         pstmt.setString(6, pVo.getAge());
	         pstmt.setString(7, pVo.getRate());
	         pstmt.setString(8, pVo.getSummary());
	         pstmt.setString(9, pVo.getReview());
	         pstmt.executeUpdate();//쿼리문 실행한다.
	      }catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         DBManager.close(conn, pstmt);
	      }
	   }
	      // c r u Delete
	      public void deleteTV(String code) {
	         String sql = "delete tv where code=?";
	         Connection conn = null;
	         PreparedStatement pstmt = null;
	         try {
	            conn = DBManager.getConnection();
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, code);
	            pstmt.executeUpdate();//쿼리문 실행한다.
	         }catch (Exception e) {
	            e.printStackTrace();
	         }finally {
	            DBManager.close(conn, pstmt);
	         }
	   }
	      
	      public List<TVVO> TVCrawling() throws SQLException {
		         String sql = "insert into tv values(tv_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0)";
		         int k = 1;
		         Connection conn = null;
		         PreparedStatement pstmt = null;
		         List<TVVO> list = new ArrayList<>();
		         TVVO mvo = null;
		         try {
		            conn = DBManager.getConnection();
		            pstmt = conn.prepareStatement(sql);
		         
		         for(int i=0;i<=19;i++) {
		            
		             Document doc = Jsoup.connect("https://pedia.watcha.com/ko-KR/?domain=tv").get();
		            
		             Elements link=doc.select("li.css-8y23cj a");
		          
		             Document doc2=Jsoup.connect("https://pedia.watcha.com"+link.get(i).attr("href")).get();
		             Document doc3=Jsoup.connect("https://pedia.watcha.com"+link.get(i).attr("href")+"/overview").get();
		                
		             Elements title1 = doc3.select("ul.css-f4q6l4-VisualUl-DescriptionUl dl:eq(1) dd");
//		             Element title2 = title1.get(0);
		             
		             Elements year1 = doc3.select("ul.css-f4q6l4-VisualUl-DescriptionUl dl:eq(2) dd");
//		             Element rate2 = rate1.get(0);
		             
		             Elements genre1 = doc3.select("ul.css-f4q6l4-VisualUl-DescriptionUl dl:eq(4) dd");
//		             Element genre2 = genre1.get(0);
		            
		             
		             Elements channel1    = doc3.select("ul.css-f4q6l4-VisualUl-DescriptionUl dl:eq(3) dd");
//		             Element dir2 = dir1.get(0);
		             
		             Elements country1    = doc3.select("ul.css-f4q6l4-VisualUl-DescriptionUl dl:eq(5) dd");

		             Elements age1    = doc3.select("ul.css-f4q6l4-VisualUl-DescriptionUl dl:eq(6) dd");
		             
		             Elements rate1 = doc2.select("div.css-og1gu8-ContentRatings");
//		             Element act2 = act1.get(0);
//		             String act3 = act2.text();
		            
		             
		             Elements summary1 = doc2.select("div.css-kywn6v-StyledText");
//		             Element time2 = time1.get(0);
		             
//		             Elements date1 = doc2.select("span.css-wzn7fp");
		             
		             Elements img1 = doc.select("li.css-8y23cj img");
		 	         Element img2 = img1.get(i);
		 	         String imgURL = img2.attr("src");
		 	        
		 	        
		 	        
		 	         URL imgU = new URL(imgURL);

		 	         BufferedImage jpg = ImageIO.read(imgU);
		             
		             File file = new File("C:Users\\pc\\Work\\Project\\src\\main\\webapp\\img\\"+title1.text()+".png");
		             ImageIO.write(jpg, "png", file);

		 	        
		 	         Elements bimg1 = doc2.select("meta[property=og:image]");
		 			 String bimg2 = bimg1.attr("content");
		 			String bimg3 = bimg2.substring(180);
		 			
		 			  URL imgU2 = new URL(bimg2);

		 		        BufferedImage jpg2 = ImageIO.read(imgU2);
		 	            
		 	            File file2 = new File("C:Users\\pc\\Work\\Project\\src\\main\\webapp\\img\\"+bimg3+"_B.png");
		 	            ImageIO.write(jpg2, "png", file2);
		             
		             mvo = new TVVO();
		             
		             mvo.setNum(k); //번호
		             mvo.setTitle(title1.text()); // 영화 제목
		             mvo.setYear(year1.text()); // 네티즌 평점
		             mvo.setGenre(genre1.text());  // 개요 
		             mvo.setChannel(channel1.text()); // 감독
		             mvo.setCountry(country1.text()); // 감독
		             mvo.setAge(age1.text()); // 감독
		             mvo.setRate(rate1.text()); // 감독
		             mvo.setSummary(summary1.text()); // 감독
		             mvo.setImg(title1.text()); // 감독
		             mvo.setBimg(bimg3); // 감독
		             
		             list.add(mvo);

		            pstmt.setString(1, title1.text());
		            pstmt.setString(2, year1.text());
		            pstmt.setString(3, genre1.text());
		            pstmt.setString(4, channel1.text());
		            pstmt.setString(5, country1.text());
		            pstmt.setString(6, age1.text());
		            pstmt.setString(7, rate1.text());
		            pstmt.setString(8, summary1.text());
		            pstmt.setString(9, title1.text());
		            pstmt.setString(10, bimg3);
		            
		            System.out.println(title1.text());
		            System.out.println(year1.text());
		            System.out.println(genre1.text());
		            System.out.println(channel1.text());
		            System.out.println(country1.text());
		            System.out.println(age1.text());
		            System.out.println(rate1.text());
		            System.out.println(summary1.text());
		            System.out.println(title1.text());
		            System.out.println(bimg3);
		            
		             
		             k++;
		             pstmt.executeUpdate();
		             
		            } 
		         }catch (IOException e) {
		            e.printStackTrace();
		         }finally {
		            DBManager.close(conn, pstmt);
		      }
		         return list;
		      }
	      
	      public List<TVVO> TVUpdate() throws SQLException {
	         String sql = "UPDATE tv"
	               + "   SET code = ?"
	               + "     , title = ? "
	               + "     , year =  ?"
	               + "     , genre= ?"
	               + "     , channel= ?"
	               + "     ,  country=? "
	               + "     ,  age=? "
	               + "     ,  rate=? "
	               + "     ,  summary=? "
	               + "     ,  review=0 "
	               + " WHERE code = ?";
	         int k = 1;
	         Connection conn = null;
	         PreparedStatement pstmt = null;
	         List<TVVO> list = new ArrayList<>();
	         TVVO mvo = null;
	         try {
	            conn = DBManager.getConnection();
	            pstmt = conn.prepareStatement(sql);

	            for (int i = 0; i <= 5; i++) {

	               Document doc = Jsoup.connect("https://pedia.watcha.com/ko-KR/?domain=movie").get();

	               Elements link = doc.select("li.css-8y23cj a");

	               Document doc2 = Jsoup.connect("https://pedia.watcha.com" + link.get(i).attr("href")).get();
	               Document doc3 = Jsoup.connect("https://pedia.watcha.com" + link.get(i).attr("href") + "/overview")
	                     .get();

	               Elements title1 = doc2.select("h1.css-171k8ad-Title");
//	             Element title2 = title1.get(0);

	               Elements year1 = doc3.select("ul.css-f4q6l4-VisualUl-DescriptionUl dl:eq(2) dd");
//	             Element rate2 = rate1.get(0);

	               Elements genre1 = doc3.select("ul.css-f4q6l4-VisualUl-DescriptionUl dl:eq(4) dd");
//	             Element genre2 = genre1.get(0);

	               Elements channel1 = doc3.select("ul.css-f4q6l4-VisualUl-DescriptionUl dl:eq(5) dd");
//	             Element dir2 = dir1.get(0);

	               Elements country1 = doc3.select("ul.css-f4q6l4-VisualUl-DescriptionUl dl:eq(3) dd");

	               Elements age1 = doc3.select("ul.css-f4q6l4-VisualUl-DescriptionUl dl:eq(6) dd");

	               Elements rate1 = doc2.select("div.css-og1gu8-ContentRatings");
//	             Element act2 = act1.get(0);
//	             String act3 = act2.text();

	               Elements summary1 = doc2.select("div.css-kywn6v-StyledText");
//	             Element time2 = time1.get(0);

	               Elements rank1 = doc2.select("ul.css-1v9zk7c-RankingInfoList li:eq(0)");
//	             Elements date1 = doc2.select("span.css-wzn7fp");

	               Elements aud1 = doc2.select("ul.css-1v9zk7c-RankingInfoList li:eq(2)");

	               System.out.println();

	               mvo = new TVVO();
	               
	               mvo.setNum(k); // 번호
	               mvo.setTitle(title1.text()); // 영화 제목
	               mvo.setYear(year1.text()); // 네티즌 평점
	               mvo.setGenre(genre1.text()); // 개요
	               mvo.setChannel(channel1.text()); // 감독
	               mvo.setCountry(country1.text()); // 감독
	               mvo.setAge(age1.text()); // 감독
	               mvo.setRate(rate1.text()); // 감독
	               mvo.setSummary(summary1.text()); // 감독
//	             if(!act3.contains(act4))
//	             mvo.setact(act1.text()); //출연

//	             mvo.settimes(time1.text()); // 영화 시간
//	             mvo.setdates(date1.text()); // 영화 개봉일

	               list.add(mvo);
	               
	               pstmt.setInt(1, i+1);
	               pstmt.setString(2, title1.text());
	               pstmt.setString(3, year1.text());
	               pstmt.setString(4, genre1.text());
	               pstmt.setString(5, channel1.text());
	               pstmt.setString(6, country1.text());
	               pstmt.setString(7, age1.text());
	               pstmt.setString(8, rate1.text());
	               pstmt.setString(9, summary1.text());
	               pstmt.setInt(12, i+1);
	               
	               System.out.println(title1.text());
	               System.out.println(year1.text());
	               System.out.println(genre1.text());
	               System.out.println(channel1.text());
	               System.out.println(country1.text());
	               System.out.println(age1.text());
	               System.out.println(rate1.text());
	               System.out.println(summary1.text());

	               k++;
	               pstmt.executeUpdate();
	               System.out.println("yesyesaaaa");
	            }

	            
	         } catch (IOException e) {
	            e.printStackTrace();
	         } finally {
	            DBManager.close(conn, pstmt);
	         }
	         return list;
	      }
	      
	      public List<TVVO> TVDelete() throws SQLException, IOException {
	         String sql = "delete from tv";
	         int k = 1;
	         Connection conn = null;
	         PreparedStatement pstmt = null;
	         ResultSet rs = null;
	         List<TVVO> list = null;
	         TVVO mvo = null;
	         try {
	            conn = DBManager.getConnection();
	            pstmt = conn.prepareStatement(sql);
	            rs = pstmt.executeQuery();
	         } finally {
	            DBManager.close(conn, pstmt);
	         }
	         return list;
	      }
	      
	      public List<TVVO> SearchTV(String SK) throws SQLException, IOException {
	  		SK = '%'+SK+'%';
	  		String sql = "select * from tv where title like ?";
	  		int k = 1;
	  		Connection conn = null;
	  		PreparedStatement pstmt = null;
	  		ResultSet rs = null;
	  		List<TVVO> list = new ArrayList<>();
	  		TVVO vo = null;
	  		System.out.println(SK+"13");
	  		System.out.println(SK+"13");
	  		System.out.println(SK+"13");
	  		System.out.println(SK+"13");
	  		try {
	  			conn = DBManager.getConnection();
	  			pstmt = conn.prepareStatement(sql);
	  			pstmt.setString(1, SK);
	  			rs = pstmt.executeQuery();
	  			while (rs.next()) {
	  				vo = new TVVO();
		            vo.setNum(rs.getInt("code"));
		            vo.setTitle(rs.getString("title"));
		            vo.setYear(rs.getString("year"));
		            vo.setGenre(rs.getString("genre"));
		            vo.setChannel(rs.getString("channel"));
		            vo.setCountry(rs.getString("country"));
		            vo.setAge(rs.getString("age"));
		            vo.setRate(rs.getString("rate"));
		            vo.setSummary(rs.getString("summary"));
		            vo.setReview(rs.getString("review"));
		            vo.setImg(rs.getString("img"));
		            vo.setBimg(rs.getString("bimg"));
	  				list.add(vo);
	  			}
	  			
	  		} finally {
	  			System.out.println(list+"14");
	  			System.out.println(list+"14");
	  			System.out.println(list+"14");
	  			System.out.println(list+"14");
	  			DBManager.close(conn, pstmt, rs);
	  		}
	  		return list;
	  	}
	}