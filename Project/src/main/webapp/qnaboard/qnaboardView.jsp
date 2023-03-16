<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../member/header.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/watcha_board.css">
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<h1>게시글 상세보기</h1>
		<table>
			<tr>
				<th>작성자</th>
				<td>${qnaboard.userid}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${qnaboard.writedate}" /></td>
				<th>조회수</th>
				<td>${qnaboard.readcount}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">${qnaboard.title}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><pre>${qnaboard.content}</pre></td>
			</tr>
		</table>
		<br> <br>
		<c:if test="${loginUser.userid eq qnaboard.userid}">
		<input type="button" value="게시글 수정"
			onclick="open_win('BoardServlet?command=qnaboard_check_pass_form&num=${qnaboard.num}&pwd=${loginUser.pwd}', 'update')">
		<input type="button" value="게시글 삭제"
			onclick="open_win('BoardServlet?command=qnaboard_check_pass_form&num=${qnaboard.num}&pwd=${loginUser.pwd}', 'delete')">
		</c:if>
		<input type="button" value="게시글 리스트"
			onclick="location.href='BoardServlet?command=qnaboard_list'">
			<c:if test="${loginUser.admin eq '관리자'}">
		<input type="button" value="댓글 등록"
			onclick="location.href='BoardServlet?command=qnaboard_reply_form&num=${qnaboard.num}'">
			</c:if>
	</div>
</body>
</html>