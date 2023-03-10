package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GuestDAO;

/**
 * Servlet implementation class Result
 */
@WebServlet("/Result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Result() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		PrintWriter out = response.getWriter();
		
		GuestDAO guestDAO = new GuestDAO();
//		출력확인
//		System.out.println(name);
//		System.out.println(guestDAO.selectUser("배다빈"));
//		System.out.println(guestDAO.selectUser(name));
		
		
		try {
			if(guestDAO.selectUser(name).get(0) != null) {
				out.print(guestDAO.selectUser(name));
				}
		} catch (IndexOutOfBoundsException e) {
			out.print("검색 결과 없음");
		}
		
		out.close();
	}

}
