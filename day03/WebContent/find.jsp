<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기</title>
</head>
<body>
	<form action="findOk.jsp" method="POST">
		회원정보를 입력해주세요
		이름 <input type="text" name="userName" placeholder="*필수작성">
		<br>
		전화번호 <input type="text" name="userPhone" placeholder="010-0000-0000">
		<p id="result"></p>
		<button class="confirm" onclick="send()">확인</button>
	</form>
	
	
</body>
</html>