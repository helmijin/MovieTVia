package com.saeyan.controller.action.tv;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.controller.action.Action;
import com.saeyan.dao.TVDAO;
import com.saeyan.dto.TVVO;

public class TVWritePost implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      ServletContext context = request.getSession().getServletContext();
      String path = context.getRealPath("upload");
      String encType = "UTF-8";
      int sizeLimit = 20 * 1024 * 1024;

      MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());

      String title = multi.getParameter("title");
      String ygc = multi.getParameter("ygc");
      String rate = multi.getParameter("rate");
      String genre = multi.getFilesystemName("genre");
      

      TVVO pVo = new TVVO();
      pVo.setTitle(title);
//      pVo.setYgc(ygc);
      pVo.setRate(rate);
      pVo.setGenre(genre);

      TVDAO pDao = TVDAO.getInstance();
      pDao.insertTV(pVo);

      response.sendRedirect("BoardServlet?command=tv_list");
   }

}