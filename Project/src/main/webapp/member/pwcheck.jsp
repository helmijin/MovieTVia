<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
table{
margin-left:auto;
margin-right:auto;
}
h2{
text-align:center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
	<h2>아이디 중복확인</h2>
	<form action="BoardServlet?command=member_pw_check" method="post" name="frm">
		아이디 <input type="text" name="userpw" value="${userpw}"> <input type=submit
			value="중복 체크"> <br>
		<c:if test="${result != -1}">
			<script type="text/javascript">
				opener.document.frm.userid.value = "";
			</script>
			비밀번호를 다시 입력해주세요
		</c:if>
		<c:if test="${result==-1}">
		정말 회원 탈퇴 하시겠습니까?
		<input type="button" value="탈퇴" class="cancel" onclick="idok('${userpw}')">
		</c:if>
	</form>
</body>
</html>