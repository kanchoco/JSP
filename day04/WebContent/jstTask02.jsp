<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 두번째 실습</title>
</head>
<body>
	<!-- 
   1단부터 100단가지 중 사용자에게 입력받은 단수로 구구단 출력하기
   입력받은 값이 정수인지 아닌지 판단, 값을 입력했는지 안했는지 판단.
   다른 페이지 이동 없이 현재 페이지에서만 기능 구현
   자바스크립트 사용가능
   구구단 출력은 JSTL로 구현
   입력은 form태그로 입력받는다.
 -->
     <c:choose>
        <c:when test="${empty param.input}">
	  		<form>
	             <label>
	                단 <input type="text" name="input">
	             </label>
	             <input type="submit" value="전송" onclick="send()">
	          </form>
		</c:when>
		<c:otherwise>
				<c:forEach var="i" begin="1" end="9">
					<c:out value="${param.input} * ${i} = ${pram.input*i}"/>
					<br>		
				</c:forEach>
		</c:otherwise>
	</c:choose>
</body>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>

function send() {
	var $input = $("input[type='text']").val();
	console.log($input);
	console.log($input < 1);
	if( $input < 1 || $input > 100){
		alert("아이디를 확인해주세요.");
		return;
	}
	
}
</script>
</html>