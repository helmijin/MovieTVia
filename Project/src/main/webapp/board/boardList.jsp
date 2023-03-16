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
function login(){
    if(confirm("로그인 후 이용해주세요"")){
        location.href = "BoardServlet?command=board_list";
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
		<h1>게시글 리스트</h1>

		<table class="list">
			<c:if test="${empty loginUser}">
				<tr>
					<td colspan="5" style="border: white; text-align: right"><a
						href="BoardServlet?command=board_list" onclick="login();">게시글
							등록</a></td>
				</tr>
			</c:if>
			<c:if test="${!empty loginUser}">
				<tr>
					<td colspan="5" style="border: white; text-align: right"><a
						href="BoardServlet?command=board_write_form&userid=${loginUser.userid}">게시글
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


			<c:forEach var="board" items="${boardList}">
				<tr class="record">
					<c:if test="${board.blevel == 0}">

						<td>${board.num}</td>
						<td>${board.userid}</td>
						<td><a
							href="BoardServlet?command=board_view&num=${board.num}&userid=${loginUser.userid}">
								${board.title} </a></td>

						<td><fmt:formatDate value="${board.writedate}" /></td>
						<td>${board.readcount}</td>
					</c:if>
					<c:if test="${board.blevel>0}">
						<td>${board.num}</td>
						<td>${board.userid}</td>
						<td><a
							href="BoardServlet?command=board_view&num =${board.num}&userid=${loginUser.userid}">
								<c:forEach begin="1" end="${board.blevel}">
									<span style="padding-left: 10px"> </span>
								</c:forEach> [RE]${board.title}
						</a></td>
						<td><fmt:formatDate value="${board.writedate}" /></td>
						<td>${board.readcount}</td>
					</c:if>
				</tr>
			</c:forEach>
			
		</table>
		<form method="post" action="BoardServlet">
			<input type="hidden" name="command" value="board_search">
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