<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 페이지</title>
</head>
<body>
	<h1>JSP으로 만든 페이지</h1>
	<!--get은 생략가능  -->
	<form action="Hello">
														<!-- name속성 값이 키값이다. -->
		이름	<input type='text' name='userName'>
		<p>서블릿으로 이동</p>
		<!-- 버튼의 기본타입은 submit이다 , 일반버튼일 시 type 지정-->
		<button>이동</button>
	</form>
</body>
</html>