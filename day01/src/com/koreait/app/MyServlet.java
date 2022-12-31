package com.koreait.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
//@WebServlet("/Hello")		//이 주소를 만나면
public class MyServlet extends HttpServlet {
//	이 클래스가 메모리에 할당
	private static final long serialVersionUID = 1L; 	//직렬하
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//    							요청 객체				,		응답 객체
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		그리고 doGet메소드가 실행된다.
//																root경로 까지(-> tomcat에서 확인)
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		리스폰스 객체의 값은 복수,--> 받아온 값은 리스트가 된다. --> DB로 옮길때는 키와 값으로 갈 수 있도록 HashMap사용
//		이걸 수정할때마다 메모리에 다시 할당, 즉 서버 재시작이 된다.   - -> 불필요한 작업을 막기위해 서버 끄고 작성한다.
		
//		System.out.println(request.getParameter("userName"));
		String name = request.getParameter("userName");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
//		html에 body태그에 작성해주는 메소드		
//		head에 쓰기 위해서는 <html></html>부터 작성해서 설정해야한다. 설정하지 않을 경우 body로 작성
		out.print("<div style='text-align:right;'>" + name + " 님 환영합니다.</div>");
		out.print("<h1>서블릿으로 만든 페이지</h1>");
		out.print("<a href='index.jsp'>JSP로 이동!</a>");
		out.close();	
		
	}

}
