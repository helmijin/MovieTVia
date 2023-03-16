<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/EditAccountTEXTver.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보수정</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/member.js"></script>
</head>
<body>
	
	<form class="login" action="BoardServlet" method="post" name="frm">
		<input type="hidden" name="command" value="member_update_post">
		<h2>회원 수정</h2>
		
		 <input class="inp" type="text" name="name" value="${mVo.name}" readonly>
		 <input class="inp" type="text" name="userid" value="${mVo.userid}" readonly>
		 <input class="inp" type="password" name="pwd" placeholder="비밀번호">
		 <input class="inp" type="password" name="pwd_check" placeholder="비밀번호확인">
		 <input class="inp" type="text" name="email" placeholder="이메일">
		 <input class="inp" type="text" name="phone" placeholder="전화번호">
		
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 <input id="check" type="submit" value="저장" onclick="return joinCheck()">
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 <input id="check" type="reset" value="다시쓰기">
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 <input id="check" type="reset" value="회원탈퇴"
		  onclick="window.open(href='BoardServlet?command=member_delete')">
	
</form>
</body>
</html>