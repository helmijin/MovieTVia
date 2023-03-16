<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CheckPassword</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/password.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/script/member.js"></script>

</head>
<body>
	<div class="div_pwcheck">
		<h1 style="color: crimson;">비밀번호 확인</h1>
		
		<form method="post" action="BoardServlet" name="frm">
			<table>
				
				<tr>
					<td><input type="hidden" name="command" value="member_pwd_check"> 
						<input type="password"
						name="deletepwd" placeholder="비밀번호를 입력해주세요."
						style="width: 300px; height: 25px;">
						<input type="hidden" name="pwdvalue" value="${loginUser.pwd}"> 
						<input type="submit" value="중복 체크" class="button_okay"></td>
				</tr>
				
			</table>
			</form>
			<form method="post" action="BoardServlet" name="result">
			<table>
			 <tr>
			   <td><c:if test="${result==-1}">
						 비밀번호가 틀렸습니다.
					</c:if>
					<c:if test="${result == 1}">
						정말 삭제하시겠습니까?
							<input type="hidden" name="command" value="member_delete_pro">
							<input type="hidden" name="userid" value="${loginUser.userid}">
							<input type="submit" value="삭제확인" class="button_okay" >
					</c:if></td>
			</tr>
			</table>
			</form>
	</div>
</body>
</html>