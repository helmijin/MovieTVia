<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../member/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 관리</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
	<div id="wrap" align="center">
		<h1>상품 삭제 - 관리자 페이지</h1>
		<form action="BoardServlet" method="post">
		<input type="hidden" name="command" value="movie_delete_post"> 
			<table>
				<tr>
					<td><c:choose>
							<c:when test="${empty movie.pictureurl}">
								<img class="imgg" src="upload/noimage.gif">
							</c:when>
							<c:otherwise>
								<img class="imgg" src="upload/${movie.pictureurl}">
							</c:otherwise>
						</c:choose></td>
					<td>
						<table>
							<tr>
								<th style="width: 80px">상 품 명</th>
								<td>${movie.name}</td>
							</tr>
							
						</table>
					</td>
				</tr>
			</table>
			<br> <input type="hidden" name="code" value="${product.code}">
			<input type="submit" value="삭제"> 
			<input type="bttoun"
				value="목록" onclick="location.href='BoardServlet?command=movie_list'">
		</form>
	</div>
</body>
</html>