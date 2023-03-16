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

import util.DBManager;
/*---------- - ------------- 
ID           VARCHAR2(10)  
TITLE        VARCHAR2(100) 
RATE         VARCHAR2(10)  
DIB          NUMBER(1)     
REVIEW       VARCHAR2(400) 
PICTUREURL   VARCHAR2(50)
*/
public class MovieDAO {

   private MovieDAO() {
   }

   public static MovieDAO instance = new MovieDAO();

   public static MovieDAO getInstance() {
      return instance;
   }

   public List<MovieVO> selectAllMovie() {
      String sql = "select * from movie order by code asc";

      List<MovieVO> list = new ArrayList<MovieVO>();

      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();

         while (rs.next()) {
            MovieVO vo = new MovieVO();
            vo.setNum(rs.getInt("code"));
            vo.setTitle(rs.getString("title"));
            vo.setYear(rs.getString("year"));
            vo.setGenre(rs.getString("genre"));
            vo.setTime(rs.getString("time"));
            vo.setCountry(rs.getString("country"));
            vo.setAge(rs.getString("age"));
            vo.setRate(rs.getString("rate"));
            vo.setSummary(rs.getString("summary"));
            vo.setRank(rs.getString("rank"));
            vo.setAud(rs.getString("aud"));
            vo.setImg(rs.getString("img"));
            vo.setBimg(rs.getString("bimg"));
            

            list.add(vo);
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         DBManager.close(conn, pstmt, rs);
      }
      return list;
   }

   // Create r u d
   public void insertMovie(MovieVO pVo) {
      String sql = "insert into movie values(movie_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
      Connection conn = null;
      PreparedStatement pstmt = null;
      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(sql);
//         pstmt.setString(1, pVo.getTitle());
//         pstmt.setString(2, pVo.getYgc());
//         pstmt.setString(3, pVo.getBook());
//         pstmt.setString(4, pVo.getAudience());
//         pstmt.setString(5, pVo.getRate());
//         pstmt.setString(6, pVo.getReview());
//         pstmt.setString(6, pVo.getPictureurl());

         pstmt.executeUpdate(); // 실행
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         DBManager.close(conn, pstmt);
      }
   }

   // c Read u d
   public List<MovieVO> selectOneMovieByNum(String num) {
      String sql = "select * from movie where code=?";
      List<MovieVO> vVo = new ArrayList<>();
      try {
         Connection conn = null;
         PreparedStatement pstmt = null;
         ResultSet rs = null;
         try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, num);
            rs = pstmt.executeQuery();
            if (rs.next()) {
               MovieVO pVo = new MovieVO();
               
               	pVo.setNum(rs.getInt("code"));
               	pVo.setTitle(rs.getString("title"));
               	pVo.setYear(rs.getString("year"));
               	pVo.setGenre(rs.getString("genre"));
               	pVo.setTime(rs.getString("time"));
               	pVo.setCountry(rs.getString("country"));
               	pVo.setAge(rs.getString("age"));
               	pVo.setRate(rs.getString("rate"));
               	pVo.setSummary(rs.getString("summary"));
               	pVo.setRank(rs.getString("rank"));
               	pVo.setAud(rs.getString("aud"));
               	pVo.setReview(rs.getString("review"));
               	pVo.setImg(rs.getString("img"));
               	pVo.setBimg(rs.getString("bimg"));
               	
               	
               	vVo.add(pVo);
               	

            }
         } catch (Exception e) {
            e.printStackTrace();
         } finally {
        	 System.out.println(vVo);
            DBManager.close(conn, pstmt, rs);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return vVo;
   }
   
   public List<MovieVO> selectOneMovieByTitle(String title) {
	      String sql = "select * from movie where title=?";
	      List<MovieVO> vVo = new ArrayList<>();
	      try {
	         Connection conn = null;
	         PreparedStatement pstmt = null;
	         ResultSet rs = null;
	         try {
	            conn = DBManager.getConnection();
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, title);
	            rs = pstmt.executeQuery();
	            if (rs.next()) {
	               MovieVO pVo = new MovieVO();
	               
	               	pVo.setNum(rs.getInt("code"));
	               	pVo.setTitle(rs.getString("title"));
	               	pVo.setYear(rs.getString("year"));
	               	pVo.setGenre(rs.getString("genre"));
	               	pVo.setTime(rs.getString("time"));
	               	pVo.setCountry(rs.getString("country"));
	               	pVo.setAge(rs.getString("age"));
	               	pVo.setRate(rs.getString("rate"));
	               	pVo.setSummary(rs.getString("summary"));
	               	pVo.setRank(rs.getString("rank"));
	               	pVo.setAud(rs.getString("aud"));
	               	pVo.setReview(rs.getString("review"));
	               	pVo.setImg(rs.getString("img"));
	               	pVo.setBimg(rs.getString("bimg"));
	               	
	               	
	               	vVo.add(pVo);
	               	

	            }
	         } catch (Exception e) {
	            e.printStackTrace();
	         } finally {
	        	 System.out.println(vVo);
	            DBManager.close(conn, pstmt, rs);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return vVo;
	   }

   // c r Update d
   public void updateMovie(MovieVO pVo) {
      String sql = "update movie set title=?, ygc=?, book=?, audience=?, rate=?, genre=?, pictureurl=?, where code=?";
      Connection conn = null;
      PreparedStatement pstmt = null;
      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(sql);
//         pstmt.setString(1, pVo.getTitle());
//         pstmt.setString(2, pVo.getYgc());
//         pstmt.setString(3, pVo.getBook());
//         pstmt.setString(4, pVo.getAudience());
//         pstmt.setString(5, pVo.getRate());
//         pstmt.setString(6, pVo.getGenre());
//         pstmt.setString(7, pVo.getPictureurl());
//         pstmt.setInt(7, pVo.getCode());

         pstmt.executeUpdate();// 쿼리문 실행한다.
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         DBManager.close(conn, pstmt);
      }
   }

   // c r u Delete
   public void deleteMovie(String code) {
      String sql = "delete moive where code=?";
      Connection conn = null;
      PreparedStatement pstmt = null;
      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, code);
         pstmt.executeUpdate();// 쿼리문 실행한다.
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         DBManager.close(conn, pstmt);
      }
   }

   public List<MovieVO> MovieCrawling() throws SQLException {
      String sql = "insert into movie values(movie_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0)";
      int k = 1;
      Connection conn = null;
      PreparedStatement pstmt = null;
      List<MovieVO> list = new ArrayList<>();
      MovieVO mvo = null;
      String imgURL2 = null;
      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(sql);

         for (int i = 0; i <= 19; i++) {

            Document doc = Jsoup.connect("https://pedia.watcha.com/ko-KR/?domain=movie").get();

            Elements link = doc.select("li.css-8y23cj a");

            Document doc2 = Jsoup.connect("https://pedia.watcha.com" + link.get(i).attr("href")).get();
            Document doc3 = Jsoup.connect("https://pedia.watcha.com" + link.get(i).attr("href") + "/overview")
                  .get();

            Elements title1 = doc2.select("h1.css-171k8ad-Title");
//          Element title2 = title1.get(0);

            Elements year1 = doc3.select("ul.css-f4q6l4-VisualUl-DescriptionUl dl:eq(2) dd");
//          Element rate2 = rate1.get(0);

            Elements genre1 = doc3.select("ul.css-f4q6l4-VisualUl-DescriptionUl dl:eq(4) dd");
//          Element genre2 = genre1.get(0);

            Elements time1 = doc3.select("ul.css-f4q6l4-VisualUl-DescriptionUl dl:eq(5) dd");
//          Element dir2 = dir1.get(0);

            Elements country1 = doc3.select("ul.css-f4q6l4-VisualUl-DescriptionUl dl:eq(3) dd");

            Elements age1 = doc3.select("ul.css-f4q6l4-VisualUl-DescriptionUl dl:eq(6) dd");

            Elements rate1 = doc2.select("div.css-og1gu8-ContentRatings");
//          Element act2 = act1.get(0);
//          String act3 = act2.text();

            Elements summary1 = doc2.select("div.css-kywn6v-StyledText");
//          Element time2 = time1.get(0);

            Elements rank1 = doc2.select("ul.css-1v9zk7c-RankingInfoList li:eq(0)");
//          Elements date1 = doc2.select("span.css-wzn7fp");

            Elements aud1 = doc2.select("ul.css-1v9zk7c-RankingInfoList li:eq(2)");
            String title2 = title1.text();
            
            
            if(title2.contains(":")) {
            	title2 = title2.replace(":",";");
            }
            
            Elements img1 = doc.select("li.css-8y23cj img");
	        Element img2 = img1.get(i);
	        String imgURL = img2.attr("src");
	        imgURL2 = imgURL.substring(180);
	        
	        
	        URL imgU = new URL(imgURL);

	        BufferedImage jpg = ImageIO.read(imgU);
            
            File file = new File("C:Users\\pc\\Work\\Project\\src\\main\\webapp\\img\\"+imgURL2+".png");
            ImageIO.write(jpg, "png", file);

	        Elements bimg1 = doc2.select("meta[property=og:image]");
			String bimg2 = bimg1.attr("content");
			String bimg3 = bimg2.substring(180);

			URL imgU2 = new URL(bimg2);

		    BufferedImage jpg2 = ImageIO.read(imgU2);
	            
	        File file2 = new File("C:Users\\pc\\Work\\Project\\src\\main\\webapp\\img\\"+bimg3+"_B.png");
	        ImageIO.write(jpg2, "png", file2);
			System.out.println();

			mvo = new MovieVO();
			
			mvo.setNum(k); // 번호
			mvo.setTitle(title1.text()); // 영화 제목
			mvo.setYear(year1.text()); // 네티즌 평점
			mvo.setGenre(genre1.text()); // 개요
			mvo.setTime(time1.text()); // 감독
			mvo.setCountry(country1.text()); // 감독
			mvo.setAge(age1.text()); // 감독
			mvo.setRate(rate1.text()); // 감독
			mvo.setSummary(summary1.text()); // 감독
			mvo.setRank(rank1.text()); // 감독
			mvo.setAud(aud1.text()); // 감독
			mvo.setImg(imgURL2); // 감독
			mvo.setBimg(bimg3); // 감독
			
			
			 
//		 if(!act3.contains(act4))
//		 mvo.setact(act1.text()); //출연

//		 mvo.settimes(time1.text()); // 영화 시간
//		 mvo.setdates(date1.text()); // 영화 개봉일

			list.add(mvo);

			pstmt.setString(1, title1.text());
			pstmt.setString(2, year1.text());
			pstmt.setString(3, genre1.text());
			pstmt.setString(4, time1.text());
			pstmt.setString(5, country1.text());
			pstmt.setString(6, age1.text());
			pstmt.setString(7, rate1.text());
			pstmt.setString(8, summary1.text());
			pstmt.setString(9, rank1.text());
			pstmt.setString(10, aud1.text());
			pstmt.setString(11, imgURL2);
			pstmt.setString(12, bimg3);

            k++;
            pstmt.executeUpdate();
         }
         
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         DBManager.close(conn, pstmt);
      }
      System.out.println("123123123123123123");
      System.out.println(imgURL2);
      System.out.println(imgURL2);
      System.out.println(imgURL2);
      System.out.println(imgURL2);
      System.out.println(imgURL2);
      System.out.println("123123123123123123");
      return list;
   }
   
   public List<MovieVO> MovieUpdate() throws SQLException {
      String sql = "UPDATE movie"
            + "   SET code = ?"
            + "     , title = ? "
            + "     , year =  ?"
            + "     , genre= ?"
            + "     , time= ?"
            + "     ,  country=? "
            + "     ,  age=? "
            + "     ,  rate=? "
            + "     ,  summary=? "
            + "     ,  rank=? "
            + "     ,  aud=? "
            + "     ,  review=0 "
            + " WHERE code = ?";
      int k = 1;
      Connection conn = null;
      PreparedStatement pstmt = null;
      List<MovieVO> list = new ArrayList<>();
      MovieVO mvo = null;
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
//          Element title2 = title1.get(0);

            Elements year1 = doc3.select("ul.css-f4q6l4-VisualUl-DescriptionUl dl:eq(2) dd");
//          Element rate2 = rate1.get(0);

            Elements genre1 = doc3.select("ul.css-f4q6l4-VisualUl-DescriptionUl dl:eq(4) dd");
//          Element genre2 = genre1.get(0);

            Elements time1 = doc3.select("ul.css-f4q6l4-VisualUl-DescriptionUl dl:eq(5) dd");
//          Element dir2 = dir1.get(0);

            Elements country1 = doc3.select("ul.css-f4q6l4-VisualUl-DescriptionUl dl:eq(3) dd");

            Elements age1 = doc3.select("ul.css-f4q6l4-VisualUl-DescriptionUl dl:eq(6) dd");

            Elements rate1 = doc2.select("div.css-og1gu8-ContentRatings");
//          Element act2 = act1.get(0);
//          String act3 = act2.text();

            Elements summary1 = doc2.select("div.css-kywn6v-StyledText");
//          Element time2 = time1.get(0);

            Elements rank1 = doc2.select("ul.css-1v9zk7c-RankingInfoList li:eq(0)");
//          Elements date1 = doc2.select("span.css-wzn7fp");

            Elements aud1 = doc2.select("ul.css-1v9zk7c-RankingInfoList li:eq(2)");

            System.out.println();

            mvo = new MovieVO();
            
            mvo.setNum(k); // 번호
            mvo.setTitle(title1.text()); // 영화 제목
            mvo.setYear(year1.text()); // 네티즌 평점
            mvo.setGenre(genre1.text()); // 개요
            mvo.setTime(time1.text()); // 감독
            mvo.setCountry(country1.text()); // 감독
            mvo.setAge(age1.text()); // 감독
            mvo.setRate(rate1.text()); // 감독
            mvo.setSummary(summary1.text()); // 감독
            mvo.setRank(rank1.text()); // 감독
            mvo.setAud(aud1.text()); // 감독
//          if(!act3.contains(act4))
//          mvo.setact(act1.text()); //출연

//          mvo.settimes(time1.text()); // 영화 시간
//          mvo.setdates(date1.text()); // 영화 개봉일

            list.add(mvo);
            
            pstmt.setInt(1, i+1);
            pstmt.setString(2, title1.text());
            pstmt.setString(3, year1.text());
            pstmt.setString(4, genre1.text());
            pstmt.setString(5, time1.text());
            pstmt.setString(6, country1.text());
            pstmt.setString(7, age1.text());
            pstmt.setString(8, rate1.text());
            pstmt.setString(9, summary1.text());
            pstmt.setString(10, rank1.text());
            pstmt.setString(11, aud1.text());
            pstmt.setInt(12, i+1);
            
            System.out.println(title1.text());
            System.out.println(year1.text());
            System.out.println(genre1.text());
            System.out.println(time1.text());
            System.out.println(country1.text());
            System.out.println(age1.text());
            System.out.println(rate1.text());
            System.out.println(summary1.text());
            System.out.println(rank1.text());
            System.out.println(aud1.text());

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
   
   public List<MovieVO> MovieDelete() throws SQLException, IOException {
      String sql = "delete from movie";
      int k = 1;
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      List<MovieVO> list = null;
      MovieVO mvo = null;
      try {
         conn = DBManager.getConnection();
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
      } finally {
         DBManager.close(conn, pstmt);
      }
      return list;
   }
   
   public List<MovieVO> SearchMovie(String SK) throws SQLException, IOException {
		SK = '%'+SK+'%';
		String sql = "select * from movie where title like ?";
		int k = 1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MovieVO> list = new ArrayList<>();
		MovieVO mvo = null;
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
				mvo = new MovieVO();
				mvo.setNum(rs.getInt("code")); // 번호
				mvo.setTitle(rs.getString("title")); // 영화 제목 
				mvo.setYear(rs.getString("year")); // 네티즌 평점
				mvo.setGenre(rs.getString("genre")); // 개요
				mvo.setTime(rs.getString("time")); // 감독
				mvo.setCountry(rs.getString("country")); // 감독
				mvo.setAge(rs.getString("age")); // 감독
				mvo.setRate(rs.getString("rate")); // 감독
				mvo.setSummary(rs.getString("summary")); // 감독
				mvo.setRank(rs.getString("rank")); // 감독
				mvo.setAud(rs.getString("aud")); // 감독
				mvo.setReview(rs.getString("review"));
				mvo.setImg(rs.getString("img"));
				mvo.setBimg(rs.getString("bimg"));
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