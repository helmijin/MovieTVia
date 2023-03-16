<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../member/header.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>overview</title>
<link rel="stylesheet" href="/css/watchamypage.css">
</head>
<style>
header {
	position: fixed;
	margin: auto;
	display: block;
	top: 0px;
	left: 0;
	background-color: #fff;
	text-align: center;
	width: 100%;
	height: 71px;
	z-index: 1;
	box-shadow: 0 1px 0 0 rgb(0 0 0/ 8%);
}

nav {
	display: block;
}

div {
	display: block;
}

li {
	display: inline;
	list-style-type: none;
}

button {
	border: none;
	background: rgb(255, 255, 255);
	font-size: 15px;
}

ul {
	display: block;
	margin-block-start: 1em;
	margin-block-end: 1em;
	margin-inline-start: 0px;
	margin-inline-end: 0px;
	padding-inline-start: 40px;
	list-style-type: none;
}

hr {
	color: #e9e9f0;
}

.ul_head {
	list-style: none;
	padding: 0;
	margin: 0;
	display: flex;
}

.li_logo {
	margin: 15px 15px 0 0;
}

.li_head {
	display: flex;
	align-items: center;
	height: 62px;
	margin: 5px 0 0 24px;
	flex-shrink: 0;
}

.li_search {
	display: flex;
	align-items: center;
	height: 62px;
	flex-shrink: 1;
	margin: 0 0 0 auto;
}

.div_head {
	margin-right: 150px;
	margin-left: 150px;
}

.div_search {
	position: relative;
	width: 100%;
}

.header_label {
	display: flex;
	align-items: center;
	background: #f5f5f7
		url(data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyMiIgaGVpZ2h0PSIyMiIgdmlld0JveD0iMCAwIDIyIDIyIj4KICAgIDxwYXRoIGZpbGw9IiNCQUJBQzMiIGZpbGwtcnVsZT0iZXZlbm9kZCIgZD0iTTkuODE0IDE1LjczNWMtMy4yMDcgMC01LjgxNy0yLjYzLTUuODE3LTUuODYxIDAtMy4yMzMgMi42MS01Ljg2MiA1LjgxNy01Ljg2MiAzLjIwNyAwIDUuODE4IDIuNjMgNS44MTggNS44NjJzLTIuNjEgNS44Ni01LjgxOCA1Ljg2bTkuODQxIDIuNTRsLTMuNjYtMy43MDRjLjk4LTEuMzEgMS41NzEtMi45MzIgMS41NzEtNC42OTYgMC00LjMwOC0zLjQ3OC03LjgxMi03Ljc1Mi03LjgxMi00LjI3NCAwLTcuNzUyIDMuNTA0LTcuNzUyIDcuODEyIDAgNC4zMDcgMy40NzggNy44MSA3Ljc1MiA3LjgxIDEuODI5IDAgMy41MDctLjY0NCA0LjgzNC0xLjcxNGwzLjYzNyAzLjY4Yy4xODIuMTg2LjQyNi4yODguNjg1LjI4OC4yNTcgMCAuNS0uMS42ODMtLjI4NC4xODItLjE4NC4yODQtLjQzLjI4NS0uNjkgMC0uMjYtLjEtLjUwNS0uMjgzLS42OSIvPgo8L3N2Zz4K)
		no-repeat 9px 8px;
	box-sizing: border-box;
	width: 100%;
	height: 38px;
	padding: 7px 10px 8px 36px;
	border-radius: 2px;
}

.header_searchsp {
	font-size: 14px;
	font-weight: 400;
	letter-spacing: -0.3px;
	line-height: 23px;
	background: transparent;
	width: 100%;
	padding: 0;
	padding-bottom: 1px;
	border: 0;
	overflow: hidden;
	text-overflow: ellipsis;
	caret-color: #353535;
}

.section_body {
	padding-top: 62px;
	padding-bottom: unset;
}

.div_bodypart {
	display: flex;
	flex-direction: column;
	min-height: calc(100vh - 62px);
	/*background: rgb(248, 248, 248);*/
	background: rgb(245, 233, 241);
	overflow: hidden;
}

.div_contpart {
	flex: 1 1 0%;
	margin: 28px 0px 30px;
}

.div_consec {
	max-width: 640px;
	margin: 0px auto;
}

.div_consecround {
	border: 1px solid;
	border-radius: 6px;
	background: rgb(255, 255, 255);
	overflow: hidden;
	border-color: rgb(227, 227, 227) !important;
}

.sect_cont {
	background: rgb(255, 255, 255);
}

.div_upwall {
	position: relative;
	height: 0px;
	padding-top: 32%;
	/*background: #353535;*/
	background-image: url(/img/watcha/good.jpg);
	margin: 0px 0px -20px;
}

.button_setting {
	padding: 0px;
	border: none;
	margin: 0px;
	cursor: pointer;
	position: absolute;
	top: 10px;
	right: 10px;
	background:
		url(data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0Ij4KICAgIDxnIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPHBhdGggZD0iTTAgMGgyNHYyNEgweiIvPgogICAgICAgIDxwYXRoIGZpbGw9IiNGRkYiIGZpbGwtcnVsZT0ibm9uemVybyIgZD0iTTE5LjQzIDEyLjk4Yy4wNC0uMzIuMDctLjY0LjA3LS45OCAwLS4zNC0uMDMtLjY2LS4wNy0uOThsMi4xMS0xLjY1Yy4xOS0uMTUuMjQtLjQyLjEyLS42NGwtMi0zLjQ2Yy0uMTItLjIyLS4zOS0uMy0uNjEtLjIybC0yLjQ5IDFjLS41Mi0uNC0xLjA4LS43My0xLjY5LS45OGwtLjM4LTIuNjVBLjQ4OC40ODggMCAwIDAgMTQgMmgtNGMtLjI1IDAtLjQ2LjE4LS40OS40MmwtLjM4IDIuNjVjLS42MS4yNS0xLjE3LjU5LTEuNjkuOThsLTIuNDktMWMtLjIzLS4wOS0uNDkgMC0uNjEuMjJsLTIgMy40NmMtLjEzLjIyLS4wNy40OS4xMi42NGwyLjExIDEuNjVjLS4wNC4zMi0uMDcuNjUtLjA3Ljk4IDAgLjMzLjAzLjY2LjA3Ljk4bC0yLjExIDEuNjVjLS4xOS4xNS0uMjQuNDItLjEyLjY0bDIgMy40NmMuMTIuMjIuMzkuMy42MS4yMmwyLjQ5LTFjLjUyLjQgMS4wOC43MyAxLjY5Ljk4bC4zOCAyLjY1Yy4wMy4yNC4yNC40Mi40OS40Mmg0Yy4yNSAwIC40Ni0uMTguNDktLjQybC4zOC0yLjY1Yy42MS0uMjUgMS4xNy0uNTkgMS42OS0uOThsMi40OSAxYy4yMy4wOS40OSAwIC42MS0uMjJsMi0zLjQ2Yy4xMi0uMjIuMDctLjQ5LS4xMi0uNjRsLTIuMTEtMS42NXpNMTIgMTUuNWMtMS45MyAwLTMuNS0xLjU3LTMuNS0zLjVzMS41Ny0zLjUgMy41LTMuNSAzLjUgMS41NyAzLjUgMy41LTEuNTcgMy41LTMuNSAzLjV6Ii8+CiAgICA8L2c+Cjwvc3ZnPgo=)
		center center/cover no-repeat;
	width: 24px;
	height: 24px;
}

.div_showcons {
	margin: 0px 20px;
}

.div_condetail {
	position: relative;
	padding-bottom: 26px;
	border-bottom: 1px solid rgb(237, 237, 237);
}

.div_boutprof {
	border: 1px solid rgba(0, 0, 0, 0.08);
	border-radius: 50%;
	display: flex;
	position: relative;
	-webkit-box-pack: center;
	justify-content: center;
	-webkit-box-align: center;
	align-items: center;
	width: 56px;
	height: 56px;
	overflow: hidden;
}

.div_wanshowprof {
	position: relative;
	background: url(/img/watcha/profbasic.jpg) no-repeat center;
	background-size: cover;
	width: 100%;
	height: 100%;
}

.div_profname {
	display: flex;
	-webkit-box-align: center;
	align-items: center;
	margin-top: 4px;
}

.h1_name {
	color: rgb(0, 0, 0);
	font-size: 25px;
	font-weight: 700;
	letter-spacing: -0.9px;
	line-height: 30px;
	width: 100%;
	word-break: break-all;
	margin: 0px;
	margin-block-start: 1em;
	margin-block-end: 1em;
}

.div_profcon {
	color: rgb(74, 74, 74);
	font-size: 15px;
	font-weight: 400;
	letter-spacing: -0.5px;
	line-height: 20px;
	margin-top: 5px;
}

.div_profcon2 {
	color: rgb(74, 74, 74);
	font-size: 15px;
	font-weight: 400;
	letter-spacing: -0.5px;
	line-height: 20px;
	margin-top: 5px;
}

.div_profcon3 {
	word-break: break-all;
	max-height: 40px;
	margin: 0px;
	overflow: hidden;
	color: rgb(74, 74, 74);
	font-size: 15px;
	font-weight: 400;
	letter-spacing: -0.5px;
	line-height: 20px;
	margin-top: 5px;
}

.div_urtype {
	position: relative;
	/* -webkit-transform: translate3d(0,0,0);
    -ms-transform: translate3d(0,0,0);*/
	transform: translate3d(0, 0, 0);
}

.div_urtype2 {
	overflow-x: hidden;
	overflow-y: hidden;
}

.div_urtype3 {
	margin: 0px 20px;
}

.ul_typeul {
	list-style: none;
	padding: 0px;
	white-space: nowrap;
	/* margin-top: 24px;
    margin-bottom: 24px;
    margin-right: -5px !important;
    margin-left: -5px !important;*/
}

.li_typeli {
	list-style: none;
	white-space: nowrap;
	padding: 5px;
}

.li_movie {
	display: inline-block;
	position: relative;
	background: linear-gradient(44.75deg, rgb(217, 87, 104) 43.19%,
		rgb(203, 116, 232) 100%);
	vertical-align: middle;
	width: 270px;
	padding-top: 50%;
	border-radius: 6px;
}

.li_movie2_1 {
	display: inline-block;
	position: relative;
	background: linear-gradient(44.75deg, rgb(224, 238, 133) 43.19%,
		rgb(232, 155, 116) 100%);
	vertical-align: middle;
	width: 270px;
	padding-top: 50%;
	border-radius: 6px;
}

.ul_movie1 {
	list-style: none;
	margin: 0px;
	background-size: contain;
	position: absolute;
	inset: 0px;
	color: rgb(255, 255, 255);
	padding: 6.9px 11px 26.5px;
	overflow: hidden;
}

.li_movie1 {
	overflow: hidden;
	text-overflow: ellipsis;
	font-size: 17px;
	font-weight: 400;
	letter-spacing: -0.7px;
	line-height: 22px;
}

.li_movie2 {
	font-size: 19px;
	font-weight: 700;
	letter-spacing: -0.7px;
	line-height: 28px;
	overflow: hidden;
	text-overflow: ellipsis;
}

.li_movie3 {
	overflow: hidden;
	text-overflow: ellipsis;
	position: absolute;
	bottom: 8.5px;
	font-size: 14px;
	font-weight: 400;
	letter-spacing: -0.2px;
	line-height: 18px;
}

.div_listlast {
	display: inline-block;
	margin: 0;
}
</style>
<body>
	<section class="sectionup">
		<section class="sectionup2">
			<div class="div_up">
				<div class="div_headsection">
					<div>
						<button class="button_back"></button>
					</div>
				</div>
				<div class="css-1d4ojes">
					<div class="div_infoTitle">영화</div>
				</div>
			</div>

			<section class="sec_mymovies">
				<div class="div_mine">
					<div class="div_mineOverflow">
						<h2 class="h2_minelist">찜 목록 &nbsp;</h2>
						<span class="span_howmany">732</span>
						<div class="div_checkmore">
							<a href="">더보기</a>
							<!--더보기 사이트 연결해주세요-->
						</div>
					</div>
				</div>
				<c:forEach begin="0" end="29" varStatus="status" step="3">
				<div class="div_movieshere">
					<div class="div_movieoverf">
						<div class="div_movieoverf2">
							<ul class="ul-mineul">
								<c:forEach var="TV" items="${mylist}" begin="${status.current}" end="${status.current+2}">
									<li class="li_movieli"><a title="${TV.title}"
										href="/ko-KR/contents/mWqJBz2">
											<div class="div_movieset1">
												<div class="div_movieset2">
												<a href="BoardServlet?command=tv_view&&title=${TV.title}" >
													<img src="img/${TV.title}.png" class="img_mymovie"></a>
												</div>
											</div>
											<div class="div_movieset3">
												<div class="div_movieset4">${TV.title}</div>
											</div>
									</a>
										<form action="BoardServlet" method="post" name="fff">
											<input type="hidden" name="command" value="mylist_delete">
											<input type="hidden" name="category" value="tv">
											<input type="hidden" name="title" value="${TV.title}">
											<input type="hidden" name="userid"
												value="${loginUser.userid}"> <input type="submit"
												value="리스트 삭제">
										</form>
										</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
				</c:forEach>
				</div>
			</section>
</body>

</html>