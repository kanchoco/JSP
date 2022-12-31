<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트 태그 예제1</title>
</head>
<body>
	<h2>Scripting Tag</h2>
	<!-- 선언부(메소드) -->
	<%!
		int count = 3;
	
	String makeItBeLower(String data){
		return data.toLowerCase();
	}
	%>
	
	<%
			for(int i = 0; i < count; i++){
				
	%>
		<h3>Java Serve Pages<%= i +1%></h3>
	<%
			}
	%>
	<hr>
	
	<h3>
		<%=makeItBeLower("Hello Word") %>
	</h3>

</body>
</html>