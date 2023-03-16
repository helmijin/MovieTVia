<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../member/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/watcha_movie_test.css">

</head>

<body>
	<c:forEach var="Movie" items="${Movie}">
		<div class="div_page">
			<section class="section_start">
				<div class="div_all">
					<section data-rowindex="0" class="section_upper">
						<div class="div_upposter">
							<div class="div_uppart">
								<div color="#6D4E43" class="div_upposterleft"></div>
								<div class="div_uppicpart"><img alt="movie" src="img/${Movie.bimg}_B.png" style="width:825px; height:331px; ">
									<div color="#8F8583" class="div_upposterright"></div>
								</div>
								<div class="div_uppiclayer">
									<div color="#6D4E43" class="div_leftgradient"></div>
									<div color="#8F8583" class="div_rightgradient"></div>
								</div>
								<div color="#8F8583" class="div_rightbg"></div>
								<div class="div_uppiclayer2"></div>
							</div>

							<div class="div_upnavmar">
								<div class="div_upnav">
									<div class="div_posterpic">
										<img alt="movieimg" src="img/${Movie.img}.png" class="poster_size">
									</div>

									<ul class="ul_ranking_info">
										<li class="li_ranking_info_item"><b><em>${Movie.rank }</em></b>
										</li>

										<li class="li_ranking_info_item"><b> <em>${Movie.aud }</em>
										</b></li>
									</ul>

								</div>
							</div>
						</div>
					</section>
					<div class="div_moviesumpart">
						<div class="div_summargin">
							<div class="div_sumbox">
								<div class="div_sumbox_margin">
									<h1 class="h1_title2">${Movie.title }</h1>
									<div class="div_movieinfo2">${Movie.year }·${Movie.genre }
										· ${Movie.country }</div>
									<div class="div_rate">${Movie.rate }</div>
									<div class="div_ratebox">
										<div class="div_RateBox">
											<div class="div_letmeRate"></div>
										</div>
										<form name="form" action="BoardServlet" method="post">
										<input type="hidden" name="command" value="movie_add_mylist">
											<input type="hidden" name="category" value="Movie"> <input
												type="hidden" name="title" value="${Movie.title}"> <input
												type="hidden" name="id" value="${loginUser.userid}">
												<input type="hidden" name="img" value="${Movie.img}">
												<input type="hidden" name="num" value="${Movie.num}">
											<button class="button_wannasee" onclick="goSubmit()"
												type="submit">

												<div class="div_wannasee">
													<div>
														<svg xmlns="http://www.w3.org/2000/svg" width="24"
															height="24" viewBox="0 0 24 24" fill="none"
															class="injected-svg"
															data-src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMjQiIGhlaWdodD0iMjQiIHZpZXdCb3g9IjAgMCAyNCAyNCIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPHBhdGggZD0iTTIwLjUgMTMuMDkyOUgxMy4xNDI4VjIwLjVIMTAuODU3MVYxMy4wOTI5SDMuNVYxMC44MDcxSDEwLjg1NzFWMy41SDEzLjE0MjhWMTAuODA3MUgyMC41VjEzLjA5MjlaIiBmaWxsPSJjdXJyZW50Q29sb3IiLz4KPC9zdmc+Cg=="
															xmlns:xlink="http://www.w3.org/1999/xlink">
                                                        <path
																d="M20.5 13.0929H13.1428V20.5H10.8571V13.0929H3.5V10.8071H10.8571V3.5H13.1428V10.8071H20.5V13.0929Z"
																fill="currentColor"></path>
                                                    </svg>
													</div>
												</div>
												<!--  아래 추가 내용 나중에 문제 생길 시 on까지 삭제 -->
												<span class="slider round"></span> </label> 보고싶어요
											</button>
										</form>


										<button class="button_aboutcomment">
											<div class="div_aboutcommentIcon">
												<div>
													<svg xmlns="http://www.w3.org/2000/svg" width="24"
														height="24" viewBox="0 0 24 24" fill="none"
														class="injected-svg"
														xmlns:xlink="http://www.w3.org/1999/xlink">
                                                        <path
															d="M3 17.2525V21.0025H6.75L17.81 9.9425L14.06 6.1925L3 17.2525ZM20.71 7.0425C21.1 6.6525 21.1 6.0225 20.71 5.6325L18.37 3.2925C17.98 2.9025 17.35 2.9025 16.96 3.2925L15.13 5.1225L18.88 8.8725L20.71 7.0425Z"
															fill="currentColor"></path>
                                                    </svg>
												</div>
											</div>
											코멘트
										</button>

										<button class="button_aboutcomment">
											<div class="div_aboutcommentIcon">
												<div>
													<svg xmlns="http://www.w3.org/2000/svg" width="24"
														height="24" viewBox="0 0 24 24" fill="none"
														class="injected-svg"
														xmlns:xlink="http://www.w3.org/1999/xlink">
                                                        <path
															d="M3 17.2525V21.0025H6.75L17.81 9.9425L14.06 6.1925L3 17.2525ZM20.71 7.0425C21.1 6.6525 21.1 6.0225 20.71 5.6325L18.37 3.2925C17.98 2.9025 17.35 2.9025 16.96 3.2925L15.13 5.1225L18.88 8.8725L20.71 7.0425Z"
															fill="currentColor"></path>
                                                    </svg>
												</div>
											</div>
											코멘트 수정
										</button>

										<button class="button_aboutcomment">
											<div class="div_aboutcommentIcon">
												<div>
													<svg xmlns="http://www.w3.org/2000/svg" width="24"
														height="24" viewBox="0 0 24 24" fill="none"
														class="injected-svg"
														xmlns:xlink="http://www.w3.org/1999/xlink">
                                                        <path
															d="M6 19.75C6 20.85 6.9 21.75 8 21.75H16C17.1 21.75 18 20.85 18 19.75V7.75H6V19.75Z"
															fill="currentColor"></path>
                                                        <path
															fill-rule="evenodd" clip-rule="evenodd"
															d="M15.0012 5.746C14.5882 5.746 14.2532 5.411 14.2532 4.998V3.746H9.74917V4.998C9.74917 5.411 9.41417 5.746 9.00117 5.746C8.58817 5.746 8.25317 5.411 8.25317 4.998V2.998C8.25317 2.585 8.58817 2.25 9.00117 2.25H15.0012C15.4142 2.25 15.7492 2.585 15.7492 2.998V4.998C15.7492 5.411 15.4142 5.746 15.0012 5.746Z"
															fill="currentColor"></path>
                                                        <rect x="5"
															y="4.75" width="14" height="2" fill="currentColor">
                                                        </rect>
                                                    </svg>
												</div>
											</div>
											코멘트 삭제
										</button>
									</div>
								</div>
							</div>

						</div>
					</div>
				</div>
			</section>

			<div class="div_contentStart">
				<div class="div_partcontents">
					<div class="div_contents">
						<div class="div_contents2">
							<section class="section_cont" data-rowindex="7">
								<div class="div_conmarg">
									<div class="basicinfocon">
										<h2 class="basicinfo">기본 정보</h2>
										<div class="div_Seemore">
											<div class="div_Seemore2">
												<a href="BoardServlet?command=movie_viewmore&num=${Movie.num}">더보기</a>
											</div>
										</div>
									</div>
								</div>
							</section>
							<div class="div_moviesummar">
								<div>
									<article class="article_con">
										<div class="div_articletitle">${Movie.title }<br> <span
												class="div_yrcon">${Movie.year }· ${Movie.country } ·
												${Movie.genre }</span><br> <span class="span_runtime">${Movie.time }
												· ${Movie.age }</span>
										</div>
										<div class="div_summpart">${Movie.summary }</div>
									</article>
								</div>

								<hr class="blank">
							</div>
						</div>
					</div>
				</div>
			</div>


			<!-- 코멘트 창-->
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
									<c:if test="${!empty loginUser.userid}">
										<a class="rep_contents">
											<form name="frm" method="post" action="BoardServlet">
												<input type="hidden" name="command" value="movie_reply">
												<input type="hidden" name="title" value="${Movie.title}">
												<input type="hidden" name="count" value="${count}">
												<input type="hidden" name="num" value="${Movie.num }">
												<input type="hidden" name="userid"
													value="${loginUser.userid}">

												<div class="comm_one">
													<div class="div_commnick">
														<a title="userid" class="title_nick">
															<div class="profilebox">
																<div class="profile"></div>
															</div>
															<div class="nickname" name="userid">${loginUser.userid}</div>
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
									<!-- <c:forEach var="reply" items="${reply}"> -->


									<!--</c:forEach><-->
								</div>
							</div>
						</div>
					</section>
				</div>


			</div>
		</div>

	</c:forEach>
</body>
</html>