<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userDAO" class="dao.UserDAO"/>
<jsp:useBean id="userVO" class="vo.UserVO"/>
    <!-- 전달받은 데이터를 DB에 INSERT하기 -->
<%
	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	String userName = request.getParameter("userName");
	int userAge = Integer.parseInt(request.getParameter("userAge"));
	String userPhone = request.getParameter("userPhone");
	String userBirth = request.getParameter("userBirth");
	
	userVO.setUserId(userId);
	userVO.setUserPassword(userPw);
	userVO.setUserName(userName);
	userVO.setUserAge(userAge);
	userVO.setUserPhonenumber(userPhone);
	userVO.setUserBirth(userBirth);
	
	userDAO.insert(userVO);
	
	response.sendRedirect("login.jsp");
%>
