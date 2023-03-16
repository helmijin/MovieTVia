<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../member/header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="script/member.js"></script>
<title>게시판</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/watcha_board.css">
<script type="text/javascript">
function login(var userid){
    if(userid.equal(null)){
    	confirm("로그인 후 이용해주세요");
        return true;
    } else {
        return false;
    }
}
</script>

</head>
<body>
	<div id="wrap" align="center">
		<h2>
			<img src="${pageContext.request.contextPath}/img/watcha/Logoimg.jpg"
				alt="My Logo" width="430" height="100">
		</h2>
		<h1>Q&A</h1>

		<table class="list">
			<c:if test="${empty loginUser}">
				<tr>
					<td colspan="5" style="border: white; text-align: right"><a
						href="BoardServlet?command=qnaboard_list" onclick="login(${loginUser.userid})">게시글
							등록</a></td>
				</tr>
			</c:if>
			<c:if test="${!empty loginUser}">
				<tr>
					<td colspan="5" style="border: white; text-align: right"><a
						href="BoardServlet?command=qnaboard_write_form&userid=${loginUser.userid}">게시글
							등록</a></td>
				</tr>
			</c:if>
			<tr>
				<th scope="col">
					<div class="tb-center">번호</div>
				</th>
				<th scope="col">
					<div class="tb-center">닉네임</div>
				</th>
				<th scope="col">
					<div class="tb-center">제목</div>
				</th>
				<th scope="col">
					<div class="tb-center">작성일</div>
				</th>
				<th scope="col">
					<div class="tb-center">조회수</div>
				</th>
			</tr>
			<c:forEach var="qnaboard" items="${qnaboardList}">
				<tr class="record">
					<c:if test="${qnaboard.blevel == 0}">

						<td>${qnaboard.num}</td>
						<td>${qnaboard.userid}</td>
						<td><a
							href="BoardServlet?command=qnaboard_view&num=${qnaboard.num}&userid=${loginUser.userid}">
								${qnaboard.title} </a></td>

						<td><fmt:formatDate value="${qnaboard.writedate}" /></td>
						<td>${qnaboard.readcount}</td>
					</c:if>
					<c:if test="${qnaboard.blevel>0}">
						<td>${qnaboard.num}</td>
						<td>${qnaboard.userid}</td>
						<td><a
							href="BoardServlet?command=qnaboard_view&num =${qnaboard.num}&userid=${loginUser.userid}">
								<c:forEach begin="1" end="${qnaboard.blevel}">
									<span style="padding-left: 10px"> </span>
								</c:forEach> [RE]${qnaboard.title}
						</a></td>
						<td><fmt:formatDate value="${qnaboard.writedate}" /></td>
						<td>${qnaboard.readcount}</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>


		<form method="post" action="BoardServlet">
			<input type="hidden" name="command" value="qnaboard_search">
			<div class="div_search2">
				<label class="header_label2"> <input type="text"
					autocomplete="on" placeholder="검색어를 입력해주세요 (ex)번호, 닉네임, 제목)"
					name="searchKeyword" class="header_searchsp2"><input
					type="submit" value="검색">
				</label>
			</div>
		</form>
	</div>
</body>
</html>