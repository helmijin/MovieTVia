<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/board_fix.css">
</head>
<body>
 <h1> 게시글 수정</h1>
    <table>
        <tr>
            <th> 작성자</th>
            <td> <input type="text" style="width: 150px; height: 15px; border-color: transparent"></td>
            <th> 작성일 </th>
            <td> sysdate</td>
        </tr>

        <tr>
            <th colspan=""> 제목
            <td colspan="3"> <input type="text" style="width: 350px; height: 20px; border-color: transparent"></td>
            </th>
        </tr>
        <tr>
            <th> 내용 </th>
            <td colspan="3">
                <input type="text" style="width: 350px; height: 350px; border-color: transparent">
            </td>
        </tr>
    </table>
    <div  class = "button_buttons">
        <button class="button_okay"> 수정</button>
        <button class="button_okay"> 삭제</button>
        <button class="button_okay"> 이전</button>
        <input type="submit" value="등록" class="button_okay">
    </div>
</body>
</html>