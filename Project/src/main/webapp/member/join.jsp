<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/css/SignUpFormFinal.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/member.js"></script>

  <link rel="stylesheet" href="SignUpFormFinal.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@700&display=swap" rel="stylesheet">
    <style> @import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@700&display=swap'); </style>
    
</head>
<body>
<br><br><br><br><br>
  <p class="tip">MOVIETIVA에 가입하고 다양한 리뷰들을 확인하세요!</p>
  <div class="container" id="container">
      <form action="BoardServlet" method="post" name="frm">
      <input type="hidden" name="command" value="member_join_post">
      <div class="form signup">
          <div class="form-header">
            <div class="show-signup"><b>회원가입하기</b></div>
        </div>
        <div class="arrow"></div>
         <div class="form-elements">
          <div class="form-element">
               <input type="text" name="name" placeholder="이름">
          </div>
           <div class="form-element">
                <input type="text" name="userid" id="userid" placeholder="아이디">
            </div>
          <div class="formhehe">
                <input type="hidden" name="reid" >
                <input id="submit-check" type="button" value="중복 체크" onclick="idCheck()">
            </div>
        <div class="form-element">
               <input type="password" name="pwd" placeholder="비밀번호">
            </div>
            <div class="form-element">
               <input type="password" name="pwd_check" placeholder="비밀번호확인">
            </div>
        <div class="form-element">
                <input type="text" name="email" placeholder="이메일" >
            </div>
         <div class="form-element">
                <input type="text" name="phone" placeholder="핸드폰번호" >
            </div>
       <div class="form-element">
                <input type="text" name="admin" placeholder="코드 입력">
            </div>
            <div class="form-element">
                 <input id="submit-btn"type="submit" value="회원가입" onclick="return joinCheck()">
            </div>
       
      </div>
   </div>
    </form>
    </div>
    
</body>
</html>