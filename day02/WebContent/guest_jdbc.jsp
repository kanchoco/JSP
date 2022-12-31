<%@page import="java.io.PrintWriter"%>
<%@page import="VO.GuestVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.GuestDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 전체 목록</title>
</head>
<body>
	<h3>이름 입력 </h3>
	<form action="result" method="post">
		<input type="text" name="name" placeholder="이름 입력">
		<button>검색</button>
	</form>
	<form action="asc" >
		<button>초기화</button>
	</form>
	
	<!-- jsp가 servlet이기 때문에, servlet파일을 생성하지 않고도 request객체가 존재한다.(= 내장객체) -->
	
	<%
		GuestDAO guestDAO = new GuestDAO();
		ArrayList<GuestVO> guests = guestDAO.selectAll();
		String sort = null;
			sort = request.getParameter("sort");
			%>
				<table class="datas" border = "1">
					<%for(int i =0; i<guests.size(); i++){ %>
					<tr>
						<td><%= guests.get(i).getGuestNumber() %></td>
						<td><%= guests.get(i).getGuestName()%></td>
						<td><%= guests.get(i).getGuestBirth() %></td>
					</tr>
					<% } %>
				</table>


	
</body>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
	function sort(){
		if($("p").text() == "오름차순"){
			$("p").text("내림차순");
		}else{
			$("p").text("오름차순");
		}
	}
</script>

</html>