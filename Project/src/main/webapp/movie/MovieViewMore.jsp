<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../member/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>더보기</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/watcha_movieviewmore.css">
</head>
<body>
<c:forEach var="Movie" items="${Movie}">
    <section class="sectionup">
        <section class="sectionup2">
            <div class="div_up"> 
                <div class="div_headsection">
                    <div>
                        <button class="button_back" 
                        onclick="location.href='BoardServlet?command=movie_view&num=${Movie.num}'">
                        </button>
                    </div>
                </div>
                <br>
                <br>
                <br>
                <div class="css-1d4ojes">
                    <div class="div_infoTitle">기본 정보</div>
                </div>
            </div>
            <div class="div_overviewcon">
                    <ul class="ul_contents">
                        <dl class="dl_title">
                            <dt class="dt_con1">원제</dt>
                            <dd class="dd_con1">${Movie.title }</dd>
                        </dl>
                        <dl class="dl_title">
                            <dt class="dt_con1">제작 연도</dt>
                            <dd class="dd_con1">${Movie.year }</dd>
                        </dl>
                        <dl class="dl_title">
                            <dt class="dt_con1">국가</dt>
                            <dd class="dd_con1">${Movie.country }</dd>
                        </dl>
                        <dl class="dl_title">
                            <dt class="dt_con1">장르</dt>
                            <dd class="dd_con1">${Movie.genre }</dd>
                        </dl>
                        <dl class="dl_title">
                            <dt class="dt_con1">상영시간</dt>
                            <dd class="dd_con1">${Movie.time }</dd>
                        </dl>
                        <dl class="dl_title">
                            <dt class="dt_con1">연령 등급</dt>
                            <dd class="dd_con1">${Movie.age }</dd>
                        </dl>
                        <dl class="dl_title">
                            <dt class="dt_con1">내용</dt>
                            <dd class="dd_con1">${Movie.summary }</dd>
                        </dl>
                    </ul>
            </div>
        </section>
    </section>


</c:forEach>
</body>
</html>