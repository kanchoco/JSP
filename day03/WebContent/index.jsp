<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userDAO" class="dao.UserDAO"/>
<jsp:useBean id="userVO" class="vo.UserVO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8");%>
<%
	String id =(String)pageContext.getSession().getAttribute("userId");
    %>
	<section>
		~ <%=id %>님 환영합니다 ~
		개인정보 수정하기
		
		<form action="joinOk.jsp" name="joinForm" method="post">
		<label>
			아이디 <input type="text" name="userId" placeholder="5자 이상으로 작성해주세요.">
			<input type="button" value="중복검사" onclick="send()">
		</label>
		<p id="result">
		</p>
		패스워드 <input type="text" name="userPw" placeholder="5자 이상으로 작성해주세요.">
		<br>
		이름 <input type="text" name="userName" placeholder="*필수작성">
		<br>
		나이 <input type="text" name="userAge" placeholder="*필수작성">
		<br>
		전화번호 <input type="text" name="userPhone" placeholder="010-0000-0000">
		<br>
		생일 <input type="text" name="userBirth" placeholder="ex)1999-00-00">
		<br>
		<input type="submit" value="완료">
		 
		
	</section>
</body>
</html>