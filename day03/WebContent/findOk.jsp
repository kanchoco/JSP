<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userDAO" class="dao.UserDAO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기</title>
</head>
<body>
	<%
		String phone = request.getParameter("userPhone");
		String id = userDAO.findId(phone);
		if(id == null){
		%>
			<form action="join_ajax.jsp">
				<h1>일치하는 회원이 없습니다. 회원가입해주세요</h1>
				<button>회원가입</button>
			</form>
		<%	
		}else{
		%>
			<form action="login.jsp">
				<h1>고객님의 아이디는<%= id%>입니다.></h1>
				<button>로그인</button>
			</form>
		<%	
		}
	%>
	
</body>
</html>