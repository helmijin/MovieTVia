<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../member/header.jsp"%>

<style>
.section_start{
height : 100%;
}

</style>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section class="section_start">
		<div class="div_body">
		<c:forEach begin="0" end="29" varStatus="status" step="5">
				<section class="section_context">
					<div class="div_bodycontents">
						<div class="title">
							<c:forEach begin="1" end="1" varStatus="loop3">
							<c:if test="${status.first}">
								<p class="p_para">
									<strong> 박스 오피스 순위 </strong>
								</p>
								</c:if>
							</c:forEach>
						</div>
						<div class="div_size">
							<div class="div_pics">
								<div class="div_picpart">
									<div class="div_picpart2">
										<div class="div_picmargin">
											<ul class="ul_picposition">
												<c:forEach var="MovieList" items="${MovieList}" begin="${status.current}" end="${status.current+4}">
														<li class="li_picsize"><a
															href="BoardServlet?command=movie_view&num=${MovieList.num}">
																<img src="img/${MovieList.img}.png" height="300px"
																class="pic">
														</a>
															<div class="movietxtbox">

																<div class="div_num" style="margin: 0 0 -3px 0;">
																	${MovieList.num}</div>
															</div>
															<div class="movietitle" style="padding: 2px;">
																${MovieList.title }</div>
															<div class="movie_release ">${MovieList.year }</div>
															<div class="rate">${MovieList.rate }</div>
															<div class="percent">${MovieList.rank }</div></li>
													
												</c:forEach>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>

					</div>
				</section>
			</c:forEach>
			<%@ include file="../member/footer.jsp"%>
		</div>
	</section>
	 
</body>
</html>