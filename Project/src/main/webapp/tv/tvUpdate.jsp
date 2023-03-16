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
<script type="text/javascript" src="script/product.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<h1>상품 수정 - 관리자 페이지</h1>
		<form action="BoardServlet?command=tv_update_post" method="post" enctype="multipart/form-data" name="frm">
			<input type="hidden" name="code" value="${tv.code}"> <input
				type="hidden" name="nonmakeImg" value="${tv.pictureurl}">
			<table>
				<tr>
					<td><c:choose>
							<c:when test="${empty tv.pictureurl}">
								<img class="imgg" src="upload/noimage.gif">
							</c:when>
							<c:otherwise>
								<img class="imgg" src="upload/${tv.pictureurl}">
							</c:otherwise>
						</c:choose></td>
					<td>
						<table>
							<tr>
								<th style="width: 80px">상품명 <</th>
								<td><input type="text" name="name" value="${tv.name}"
									size="80"></td>
							</tr>
							<tr>
								<th>가 격</th>
								<td><input type="text" name="price"
									value="${tv.price}"> 원</td>
							</tr>
							<tr>
								<th>사 진</th>
								<td><input type="file" name="pictureurl"><br>
									(주의사항 : 이미지를 변경하고자 할때만 선택하시오)</td>
							</tr>
							<tr>
								<th>설 명</th>
								<td><textarea cols="90" rows="10" name="description">${tv.description}</textarea>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br> <input type="submit" value="수정"
				onclick="return productCheck()"> <input type="reset"
				value="다시작성"><input type="button" value="목록"
				onclick="location.href='BoardServlet?command=tv_list'">
		</form>
	</div>
</body>
</html>