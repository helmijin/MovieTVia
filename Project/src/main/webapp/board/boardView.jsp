<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../member/header.jsp" %>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/shopping.css">
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
				<td>${board.userid}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${board.writedate}" /></td>
				<th>조회수</th>
				<td>${board.readcount}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3" name="title">${board.title}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3" name="content"><pre>${board.content}</pre></td>
			</tr>
		</table>
		
		<br> <br>
		<c:if test="${loginUser.userid eq board.userid}">
		<input type="button" value="게시글 수정"
			onclick="open_win('BoardServlet?command=board_check_pass_form&num=${board.num}&pwd=${loginUser.pwd}', 'update')">
		<input type="button" value="게시글 삭제"
			onclick="open_win('BoardServlet?command=board_check_pass_form&num=${board.num}&pwd=${loginUser.pwd}', 'delete')">
		</c:if>
		<input type="button" value="게시글 리스트"
			onclick="location.href='BoardServlet?command=board_list'"> 
		<input type="button" value="댓글 등록"
			onclick="location.href='BoardServlet?command=board_reply_form&num=${board.num}'">
						<div class="div_partcontents">
				<div class="div_contents2">
					<section class="section_cont2" data-rowindex="7">
						<div>
							<div class="div_conmarg">
								<div class="basicinfocon">
									<h2 class="basicinfo">코멘트</h2>
									<div class="div_Seemore">
										<div class="div_Seemore2">
											<label class="switch"> <a href="">더보기</a>
										</div>
									</div>
								</div>
								<div class="div_repcontentsbox">
								<table>
									<c:if test="${!empty loginUser.userid}">
										<a class="rep_contents">
											<form name="frm" method="post" action="BoardServlet">
												<input type="hidden" name="command" value="movie_reply">
												<input type="hidden" name="num" value="${board.num}">
												<input type="hidden" name="userid"
													value="${loginUser.userid}">

												<div class="comm_one">
													<div class="div_commnick">
														<a title="userid" class="title_nick">
															<div class="profilebox">
																<div class="profile"></div>
															</div>
															<tr>
															<td>아이디</td>
															
															<td><div class="nickname" name="userid" >${loginUser.userid}</div></td>
														</tr>
														</a>
													</div>
													<textarea cols="70" rows="5" name="content"
														style="margin: auto;">
											</textarea>
													<input type="submit" value="등록">
												</div>

											</form>
										</a>
										
										<c:forEach var="reply" items="${replyList}">
											<div class="div_contents">
												<div class="commbox">
													<ul class="ul_comm">
														<div class="comm_one">
															<div class="div_commnick">
																<a title="영화에 진심인 망고" class="title_nick" href="">
																	<div class="profilebox">
																		<div class="profile"></div>
																	</div>
																	<div class="nickname">${reply.userid}</div>
																</a>
															</div>

															<div class="div_repcontentsbox">
																<a class="rep_contents">
																	<div class="div_rep">${reply.contents}</div>
																</a>
															</div>
														</div>
													</ul>
												</div>
											</div>
										</c:forEach>
									</c:if>
									

									<c:if test="${empty loginUser.userid}">
										<c:forEach var="reply" items="${replyList}">
											<div class="div_contents">
												<div class="commbox">
													<ul class="ul_comm">
														<div class="comm_one">
															<div class="div_commnick">
																<a title="reply" class="title_nick">
																	<div class="profilebox">
																		<div class="profile"></div>
																	</div>
																	<div class="nickname">${reply.userid}</div>
																</a>
															</div>

															<div class="div_repcontentsbox">
																<a class="rep_contents">
																	<div class="div_rep">${reply.contents}</div>
																</a>
															</div>
														</div>
													</ul>
												</div>
											</div>
										</c:forEach>
									</c:if>
									</table>
									<!-- <c:forEach var="reply" items="${reply}"> -->


									<!--</c:forEach><-->
								</div>
							</div>
						</div>
					</section>
				</div>


			</div>
	</div>
</body>
</html>