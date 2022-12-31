<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userDAO" class="dao.UserDAO"/>
<jsp:useBean id="userVO" class="vo.UserVO"/>
<%
	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	
	userVO.setUserId(userId);
	userVO.setUserPassword(userPw);
	
	pageContext.getSession().setAttribute("userId", userId);
		
	response.sendRedirect(userDAO.login(userVO) != null ? "index.jsp" : "login.jsp?check=false");
%>
