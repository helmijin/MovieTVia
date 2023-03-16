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
html {
    line-height: normal;
    margin-top: auto;
    font-family: RobotoInCjk, "Noto Sans KR", "Apple SD Gothic Neo", "Nanum Gothic", "Malgun Gothic", sans-serif;
}

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
    box-shadow: 0 1px 0 0 rgb(0 0 0 / 8%);
    z-index: 1;
}

nav {
    display: block;
}

body {
    /*margin : 40px;*/
    margin: 100px;
    position: relative;    
}

div {
    display: block;
    margin-left: auto;
    margin-right: auto;
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
    /*
    display: block;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    padding-inline-start: 40px;
    list-style-type: none;*/
    display: block;
    list-style-type: disc;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    padding-inline-start: 40px;
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
    background: #f5f5f7 url(data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyMiIgaGVpZ2h0PSIyMiIgdmlld0JveD0iMCAwIDIyIDIyIj4KICAgIDxwYXRoIGZpbGw9IiNCQUJBQzMiIGZpbGwtcnVsZT0iZXZlbm9kZCIgZD0iTTkuODE0IDE1LjczNWMtMy4yMDcgMC01LjgxNy0yLjYzLTUuODE3LTUuODYxIDAtMy4yMzMgMi42MS01Ljg2MiA1LjgxNy01Ljg2MiAzLjIwNyAwIDUuODE4IDIuNjMgNS44MTggNS44NjJzLTIuNjEgNS44Ni01LjgxOCA1Ljg2bTkuODQxIDIuNTRsLTMuNjYtMy43MDRjLjk4LTEuMzEgMS41NzEtMi45MzIgMS41NzEtNC42OTYgMC00LjMwOC0zLjQ3OC03LjgxMi03Ljc1Mi03LjgxMi00LjI3NCAwLTcuNzUyIDMuNTA0LTcuNzUyIDcuODEyIDAgNC4zMDcgMy40NzggNy44MSA3Ljc1MiA3LjgxIDEuODI5IDAgMy41MDctLjY0NCA0LjgzNC0xLjcxNGwzLjYzNyAzLjY4Yy4xODIuMTg2LjQyNi4yODguNjg1LjI4OC4yNTcgMCAuNS0uMS42ODMtLjI4NC4xODItLjE4NC4yODQtLjQzLjI4NS0uNjkgMC0uMjYtLjEtLjUwNS0uMjgzLS42OSIvPgo8L3N2Zz4K) no-repeat 9px 8px;
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
.div_up{
    /*position: fixed;*/
    left: 0px;
    z-index: 50;
    background: rgb(255, 255, 255);
    box-sizing: border-box;
    font-size: 17px;
    font-weight: 700;
    letter-spacing: -0.5px;
    line-height: 22px;
    width: 100%;
    padding: 0px 16px;
    border-bottom: 1px solid rgb(227, 227, 227);
    top: 62px;
    text-align: left;
    height: auto;
}
.sectionup{
    padding-bottom: unset;
    display: relative;
}
.sectionup2 {
    padding: 10px 0px 0px;    
}
.div_headsection{
    -webkit-box-pack: justify;
    justify-content: space-between;
    margin-left: -15px;
}
.button_back{
    background-position: initial;
    background-size: initial;
    background-repeat: initial;
    background-attachment: initial;
    background-origin: initial;
    background-clip: initial;
    background-color: initial;
    padding: 0px;
    border: none;
    cursor: pointer;
    width: 24px;
    height: 24px;
    margin: 10px 0px;
    background-image: url(data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIyNCIgaGVpZ2h0PSIyNCIgdmlld0JveD0iMCAwIDI0IDI0Ij4KICAgIDxnIGZpbGw9IiNGRjJGNkUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPHBhdGggZD0iTTYuNzU1IDExLjk4OGw0Ljk1OCA0Ljk1OGEuOTguOTggMCAxIDEtMS4zODcgMS4zODdMNCAxMi4wMDdsLjAwNS0uMDA1TDQgMTEuOTk3bDYuMzQzLTYuMzQzYS45Ny45NyAwIDEgMSAxLjM3MyAxLjM3M2wtNC45NjEgNC45NnoiLz4KICAgICAgICA8cGF0aCBkPSJNNiAxMWgxM2ExIDEgMCAwIDEgMCAySDZ2LTJ6Ii8+CiAgICA8L2c+Cjwvc3ZnPgo=) !important;
}
.div_infoTitle{
    display: inline-block;
    font-weight: 700;
    letter-spacing: -1.2px;
    font-size: 22px;
    line-height: 29px;
    white-space: nowrap;
    width: 100%;
    overflow: hidden;
    text-overflow: ellipsis;
    padding-bottom: 10px;
}
section {
    display: block;
}
.sec_mymovies{
    padding: 16px 0px 0px;
    
}
.div_mine{
    margin: 0 20px;
    
}
.div_mineOverflow{
    overflow: hidden;
    
}
.h2_minelist{
    float: left;
    color: rgb(0, 0, 0);
    font-size: 19px;
    font-weight: 700;
    letter-spacing: -0.7px;
    line-height: 28px;
    margin: 8px 0px;
    
}
h2 {
    display: block;
    font-size: 1.5em;
    margin-block-start: 0.83em;
    margin-block-end: 0.83em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    font-weight: bold;
}
.span_howmany{
    float: left;
    color: rgb(170, 165, 165);
    font-size: 19px;
    letter-spacing: -0.7px;
    line-height: 28px;
    margin: 8px 0px;
}
.div_checkmore{
    float: right;
    margin: 12px 0px;
}
.div_movieshere{
    position: relative;
   /* -webkit-transform: translate3d(0,0,0);
    -ms-transform: translate3d(0,0,0);
    transform: translate3d(0,0,0);*/
}
.div_movieoverf{
    overflow-x: hidden;
    overflow-y: hidden;
}
.div_movieoverf2{
    margin: 0 20px;
}
.ul-mineul{
    list-style: none;
    padding: 0px;
    white-space: nowrap;
    margin-top: 14px;
    margin-bottom: 0px;
    margin-right: -5px !important;
    margin-left: -5px !important;
}
.li_movieli{
    display: inline-block;
    vertical-align: top;
    box-sizing: border-box;
    width: 33.3333%;
    padding: 0px 5px;
    margin: 0px 0px 24px;
}
.div_movieset1{
    position: relative;
    width: 100%;
    height: 0px;
    padding-bottom: 145.37%;
}
.div_movieset2{
    overflow: hidden;
    position: absolute;
    top: 0px;
    left: 0px;
    box-sizing: border-box;
    width: 100%;
    height: 100%;
    border: 1px solid rgb(234, 233, 232);
    border-radius: 5px;
    background: rgb(248, 248, 248);
}
.img_mymovie{
    vertical-align: top;
    width: 100%;
    height: 100%;
    opacity: 1;
    object-fit: cover;
}
.div_movieset3{
    text-align: left;
    width: calc(100% - 10px);
    margin: 5px 10px 0px 0px;
}
.div_movieset4{
    color: rgb(41, 42, 50);
    font-size: 16px;
    font-weight: 500;
    letter-spacing: -0.3px;
    line-height: 22px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    font-weight: 700px;
    text-align: center;
}
a:visited { 
    color: #eb6f6f; 
    text-decoration: none;
}   
a:hover 
{ color: #8f1515; 
    text-decoration: none; }
a {
    text-decoration-line: none;
}
</style>
<body>
	<section class="sectionup">
		<section class="sectionup2">
			<div class="div_up">
				<div class="div_headsection">
					<div>
						<button class="button_back" onclick = "location.href='BoardServlet?command=my_page'"></button>
					</div>
				</div>
				<div class="css-1d4ojes">
					<div class="div_infoTitle">TV</div>
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
								<c:forEach var="Movie" items="${mylist}" begin="${status.current}" end="${status.current+2}">
									<li class="li_movieli"><a title="${Movie.title}"
										href="/ko-KR/contents/mWqJBz2">
											<div class="div_movieset1">
												<div class="div_movieset2">
												<a href="BoardServlet?command=tv_view&num"+${Movie.num} >
													<img src="img/${Movie.title}.png" class="img_mymovie"></a>
												</div>
											</div>
											<div class="div_movieset3">
												<div class="div_movieset4">${Movie.title}</div>
											</div>
									</a>
										<form action="BoardServlet" method="post" name="fff">
											<input type="hidden" name="command" value="mylist_delete">
											<input type="hidden" name="category" value="tv">
											<input type="hidden" name="title" value="${Movie.title}">
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