<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/watcha_test.css"
	type="text/css">
	<style>
html {
    line-height: normal;        
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
margin : 40px;
display : block;
}

div {
    display: block;
    margin-left: auto;
    margin-right : auto;
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

.section_start {
    padding-top: 0px;

   /* padding-bottom: 56px; */
}

.div_body {
    display: flex;
    /*diaplay : inline; */
    flex-direction: column;
    position: relative;
    margin: auto;
  /* margin-bottom: -175px; */ /*사진 아래 부분 간격 조정*/
    margin-top: 74px;
  
    
}

.section_context {
    min-height: calc(100vh - 450px);
	

}

.div_bodycontents {
    margin-bottom: 20px;

}

.title {
    white-space: nowrap;
    max-width: 1320px;
    margin-left: auto;
    max-height: 60px;
    font-size: 20px;
    line-height: 30px;
    max-height: 58px;
    padding: auto ;
    
}

.div_size {
    max-width: 1320px;
}

.div_pics {
    position: relative;
    transform: translate3d(0px, 0px, 0px);
    margin: 0px -6px;
}

.div_picpart { /*여기서 겹침 해소함*/
    display: inline-block;
    vertical-align: top;
    box-sizing: border-box;
    width: 33.333333333333336%;
    margin: 0 -160px 24px;
}
.div_picmargin
{
    margin-right: 28px;
    margin-left: 20px;
}

.div_picpart2{
        list-style: none;
        padding: 0px;
        white-space: nowrap;
        margin-top: 0px;
        margin-bottom: 0px;
        margin-right: 0px;
        margin-left: 0px;
}
.ul_picposition {
    content: "";
    display: inline-block;
    width: 20px;
    height: 100%;
    
}

.li_picsize {
    display: inline-block;
    vertical-align: top;
    box-sizing: border-box;
    width: 33.333333333333336%;
    padding: 0 100px;
    margin: 0 0 0 20px;
}
.pic {
   /* list-style: none;
    padding: 0px;
    white-space: nowrap;
    margin-top: 0px;
    margin-bottom: 0px;
    margin-right: 0px ;
    margin-left: 0px;*/
    vertical-align: top;
    opacity: 1;
    object-fit:cover;
    white-space: nowrap;
    list-style: none;
}
.movietitle {
    padding: auto;
    max-height: 60px;
    line-height: 30px;
    font-weight: bold;
    line-height: 22px; 
    width: 210px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;     
    
 /* color: #292a32;
    font-size: 15px;
    font-weight: 400;
    letter-spacing: -0.5px;
    font-size: 16px;
    font-weight: 500;
    letter-spacing: -0.3px;
    line-height: 22px;
    white-space: nowrap;
    text-overflow: ellipsis;
    overflow: hidden;
    margin-bottom: 3px;*/
}

.movie_release {
    white-space: nowrap;
    color: #292a32;
    padding-bottom: 1px;
    font-size: 14px;
    font-weight: 400;
    letter-spacing: normal;
    line-height: 21px;
    font-family: Arial, Helvetica, sans-serif;
    display : inline-block;
}

.rate {
    margin: auto;
    white-space: nowrap;
    color: #787878;
    font-size: 13px;
    font-weight: 400;
    letter-spacing: -0.2px;
    line-height: 18px;
    height: 18px;
    text-overflow: ellipsis;
    display: flex;
    font-size: 14px;
    letter-spacing: 0;
    line-height: 14px;
    height: 15px;
    margin-top: 5px;
    
}
.percent {
    color: #74747b;
    white-space: nowrap;
    font-size: 13px;
    font-weight: 400;
    letter-spacing: -0.3px;
    line-height: 18px;
    margin-top: 5px;
}

.movietxtbox{
    /*text-align: left;
    width: calc(100% - 10px);
    display: block;
    text-overflow: ellipsis;*/
margin: 5px 10px 0 0;
  position: relative;
    width: 100%;
    height: 0;
    padding-bottom: 145.37037037037038%;
}
.div_num{
    position: absolute;
    bottom: 280px;
    left: 3px;
    background-color: rgba(198, 24, 24, 0.77);
    color: rgb(255, 255, 255);
    font-weight: 700;
    letter-spacing: normal;
    font-size: 14px;
    line-height: 22px;
    text-align: center;
    width: 24px;
    height: 24px;
    border-radius: 4px;
    opacity: 1;
}
.p_para{
    color: #292a32;
    overflow: hidden;
    text-overflow: ellipsis;
    font-size: 22px;
    font-weight: 700;
    -webkit-letter-spacing: -0.4px;
    -moz-letter-spacing: -0.4px;
    -ms-letter-spacing: -0.4px;
    letter-spacing: -0.4px;
    line-height: 30px;
}
</style>
</head>
<body>
 <header>
        <nav>
            <div class="div_head">
                <ul class="ul_head">
                    <li class="li_logo"><img src="/img/watcha/logo_1.JPG" height="50px" style="cursor:pointer;"></li>
                    <li class="li_head"> <button style="cursor:pointer;"> 영화</button> </li>
                    <li class="li_head"><button style="cursor:pointer;"> TV </button></li>
                    <li class="li_head"> <button style="cursor:pointer;"> Q&A </button></li>

                    <li class="li_search">
                        <div class="div_search">
                            <label class="header_label">
                                <input type="text" autocomplete="off" placeholder="콘텐츠, 인물, 컬렉션, 유저를 검색해보세요."
                                    name="searchKeyword" value="" class="header_searchsp">
                            </label>
                        </div>
                    </li>
                    <li class="li_head" ><button style="cursor:pointer;"> 로그인 </button></li>
                    <li class="li_head"><button style="cursor:pointer;"> 회원가입 </button></li>

                </ul>
            </div>
        </nav>
    </header>

    <section class="section_start"> == $0
        <div class="div_body">
            <section class="section_context" >
                <div class="div_bodycontents" >
                    <div class="title">
                        <p class="p_para"><strong> 박스 오피스 순위 </strong></p>
                    </div>
                    <div class="div_size">
                        <div class="div_pics">
                                <div class="div_picpart">
                                    <div class="div_picpart2">
                                        <div class="div_picmargin">
                                            <ul class="ul_picposition">
                                                <li class="li_picsize">
                                                    <img src="img/watcha/avatar.jpg" height="300px" class="pic" >
                                                    <div class="movietxtbox"> 
                                                        <div class="div_num" style="margin: 0 0 -3px 0;"> 1 </div>
                                                        </div>
                                                        <div class="movietitle" style="padding: 2px;"> 아바타 : 물의 길</div>
                                                        <div class="movie_release "> 2022 · 미국</div>
                                                        <div class="rate"> 평균★3.8</div>
                                                        <div class="percent"> 예매율 77% · 누적 관객 367만명</div>
                                                    
                                                </li>
                                                <li class="li_picsize">
                                                    <img src="img/watcha/hero.jpg" height="300px">
                                                    <div class="movietxtbox">
                                                        <div class="div_num"> 2 </div>
                                                        <div class="movietitle">영웅</div>
                                                        <div class="movie_release "> 2020 · 한국</div>
                                                        <div class="rate"> 평균★2.8</div>
                                                        <div class="percent"> 예매율 12% · 누적 관객 20만명</div>
                                                    </div>
                                                </li>
                                                <li class="li_picsize">
                                                    <img src="img/watcha/tonight.jpg" height="300px">
                                                    <div class="movietxtbox">
                                                        <div class="div_num"> 3 </div>
                                                        <div class="movietitle">오늘 밤, 세계에서 이 사랑이 사라진다 해도</div>
                                                        <div class="movie_release "> 2022 · 일본</div>
                                                        <div class="rate"> 평균★3.0</div>
                                                        <div class="percent"> 예매율 2.2% · 누적 관객 41만명</div>
                                                    </div>
                                                </li>
                                                <li class="li_picsize">
                                                    <img src="img/watcha/mystery.jpg" height="300px">
                                                    <div class="movietxtbox">
                                                        <div class="div_num"> 4 </div>
                                                        <div class="movietitle">신비아파트 극장판 차원도깨비와 7개의 세계</div>
                                                        <div class="movie_release "> 2022 · 한국</div>
                                                        <div class="rate"> 평균★3.1</div>
                                                        <div class="percent"> 예매율 2% · 누적 관객 19만명</div>
                                                    </div>
                                                </li>
                                                <li class="li_picsize">
                                                    <img src="img/watcha/owl.jpg" height="300px">
                                                    <div class="movietxtbox">
                                                        <div class="div_num"> 5 </div>
                                                        <div class="movietitle">올빼미</div>
                                                        <div class="movie_release "> 2022 · 한국</div>
                                                        <div class="rate"> 평균★3.6</div>
                                                        <div class="percent"> 예매율 1.4% · 누적 관객 310만명</div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                            </div>
                        </div>
                    </div>

                </div>
            </section>
        </div>

        <section class="section_start"> 
            <div class="div_body">
                <section class="section_context" >
                    <div class="div_bodycontents" >
                        <div class="title">
                            <p class="p_para"><strong> 박스 오피스 순위 </strong></p>
                        </div>
                        <div class="div_size">
                            <div class="div_pics">
                                    <div class="div_picpart">
                                        <div class="div_picpart2">
                                            <div class="div_picmargin">
                                                <ul class="ul_picposition">
                                                    <li class="li_picsize">
                                                        <img src="img/watcha/avatar.jpg" height="300px" class="pic" >
                                                        <div class="movietxtbox"> 
                                                            <div class="div_num" style="margin: 0 0 -3px 0;"> 1 </div>
                                                            </div>
                                                            <div class="movietitle" style="padding: 2px;"> 아바타 : 물의 길</div>
                                                            <div class="movie_release "> 2022 · 미국</div>
                                                            <div class="rate"> 평균★3.8</div>
                                                            <div class="percent"> 예매율 77% · 누적 관객 367만명</div>
                                                        
                                                    </li>
                                                    <li class="li_picsize">
                                                        <img src="img/watcha/hero.jpg" height="300px">
                                                        <div class="movietxtbox">
                                                            <div class="div_num"> 2 </div>
                                                            <div class="movietitle">영웅</div>
                                                            <div class="movie_release "> 2020 · 한국</div>
                                                            <div class="rate"> 평균★2.8</div>
                                                            <div class="percent"> 예매율 12% · 누적 관객 20만명</div>
                                                        </div>
                                                    </li>
                                                    <li class="li_picsize">
                                                        <img src="img/watcha/tonight.jpg" height="300px">
                                                        <div class="movietxtbox">
                                                            <div class="div_num"> 3 </div>
                                                            <div class="movietitle">오늘 밤, 세계에서 이 사랑이 사라진다 해도</div>
                                                            <div class="movie_release "> 2022 · 일본</div>
                                                            <div class="rate"> 평균★3.0</div>
                                                            <div class="percent"> 예매율 2.2% · 누적 관객 41만명</div>
                                                        </div>
                                                    </li>
                                                    <li class="li_picsize">
                                                        <img src="img/watcha/mystery.jpg" height="300px">
                                                        <div class="movietxtbox">
                                                            <div class="div_num"> 4 </div>
                                                            <div class="movietitle">신비아파트 극장판 차원도깨비와 7개의 세계</div>
                                                            <div class="movie_release "> 2022 · 한국</div>
                                                            <div class="rate"> 평균★3.1</div>
                                                            <div class="percent"> 예매율 2% · 누적 관객 19만명</div>
                                                        </div>
                                                    </li>
                                                    <li class="li_picsize">
                                                        <img src="img/watcha/owl.jpg" height="300px">
                                                        <div class="movietxtbox">
                                                            <div class="div_num"> 5 </div>
                                                            <div class="movietitle">올빼미</div>
                                                            <div class="movie_release "> 2022 · 한국</div>
                                                            <div class="rate"> 평균★3.6</div>
                                                            <div class="percent"> 예매율 1.4% · 누적 관객 310만명</div>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                </div>
                            </div>
                        </div>
    
                    </div>
                </section>
            </div>
</body>
</html>