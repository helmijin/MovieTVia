<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>My Page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/watcha_mypage.css">
</head>

<body>

   <!--mypage source-->
   <section class="section_body">
      <div class="div_bodypart">
         <div class="div_contpart">
            <div class="div_consec">
               <div class="div_consecround">
                  <section class="sect_cont">
                       <div class="div_upwall" >
                     </div>
                     <div class="div_showcons">
                        <div class="div_condetail">
                           <div class="div_boutprof">
                              <div class="div_wanshowprof"> <img src="${pageContext.request.contextPath}/img/watcha/myphoto.jpg" height="55px" style="cursor:pointer;"></div>
                           </div>
                           <div class="div_profname">
                              <h1 class="h1_name">${loginUser.userid}</h1><img src="${pageContext.request.contextPath}/img/watcha/setting.jpg" height="30px" style="cursor:pointer; margin-right "  
                        onclick="location.href='BoardServlet?command=member_update'">
                           </div>
                           <div class="div_profcon">
                              <div class="div_profcon2">
                                 <div class="div_profcon3"> </div>
                              </div>
                           </div>
                        </div>

                        <div class="div_urtype">
                           <div class="div_urtype2">
                              <div class="div_urtype3">
                                    <ul class="ul_typeul">
                                       <li class="li_typeli"><a class="li_movie" href="BoardServlet?mylist_movie&command=mylist_movie&userid=${loginUser.userid}">
                                       <input type="hidden" name="command" value="mylist_movie">
                                             <ul class="ul_movie1">
                                                <li class="li_movie1"><strong>영화</strong></li>
                                                <br>
                                                <li class="li_movie2"></li>
                                             </ul>
                                       </a></li>
                                       
                                 <li class="li_typeli"><a class="li_movie2_1" href="BoardServlet?mylist_tv&command=mylist_tv&userid=${loginUser.userid}">
                                       <ul class="ul_movie1">
                                          <li class="li_movie1"><strong>TV 프로그램 </strong></li>
                                          <br>
                                          <li class="li_movie2"></li>
                                       </ul>
                                 </a></li>

                                 <div class="div_listlast"></div>
                                 </ul>

                              </div>
                           </div>
                        </div>
                     </div>
                  </section>
               </div>
            </div>
         </div>

      </div>
   </section>