<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax 테스트 - GET</title>
</head>
<body>
	<h1 id="result"></h1>
	<button onclick="send()">데이터 가져오기</button>
</body>
<script>
	function send(){
		var xhr = new XMLHttpRequest();
		//xhr.open("GET", "data.jsp");
		xhr.open("POST", "data.jsp");
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send("msg1=반갑습니다&msg2=어서오세요");
		
		xhr.onreadystatechange = function(){
			if(xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200){
				document.getElementById("result").innerHTML = xhr.responseText;
			}
		}
	}
</script>
</html>
















