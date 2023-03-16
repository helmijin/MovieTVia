<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../member/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
    <section class="section_start">
        <div class="div_body">
        <c:forEach begin="0" end="29" varStatus="status" step="5">
            <section class="section_context">
                <div class="div_bodycontents" >
                    <div class="title">
                    <c:forEach begin="1" end="1" varStatus="loop3">
							<c:if test="${status.first}">
                        <p class="p_para"><strong> 한국 TV 프로그램 인기 순위 </strong></p>
                        </c:if>
							</c:forEach>
                    </div>
                    <div class="div_size">
                        <div class="div_pics">
                                <div class="div_picpart">
                                    <div class="div_picpart2">
                                        <div class="div_picmargin">
                                            <ul class="ul_picposition">
                                            <c:forEach var="tvList" items="${tvList}" begin="${status.current}" end="${status.current+4}">
                                                <li class="li_picsize">
                                                <a href="BoardServlet?command=tv_view&num=${tvList.num}&title=${tvList.title}" >
                                                    <img src="img/${tvList.title}.png" height="300px" class="pic" ></a>
                                                    <div class="movietxtbox"> 
                                                    
                                                        <div class="div_num" style="margin: 0 0 -3px 0;">${tvList.num} </div>
                                                        </div>
                                                        <div class="movietitle" style="padding: 2px;"></div>
                                                        <div class="movie_release "> ${tvList.title}</div>
                                                        <div class="percent"> ${tvList.year}</div>
                                                    
                                                </li>
                                                </c:forEach>
                                               
                                            </ul>
                                        </div>
                                    </div>
                            </div>
                        </div>
                    </div>

                </div>
            </section>
            </c:forEach>
            <%@ include file="../member/footer.jsp"%>
        </div>
    </section>
</body>
</html>