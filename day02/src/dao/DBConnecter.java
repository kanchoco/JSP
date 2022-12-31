package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnecter {
	   public static Connection getConnection() {
//		   커넥션 개체 선언
	      Connection connection = null;
	      try {
//	         연결에 필요한 정보
//	    	  SQL 계정명과 비밀번호 그리고 주소를 입력한다.
	         String userName = "root";
	         String password = "1234";
	         String url = "jdbc:mysql://localhost:3306/jsp";
	         
//	         드라이버를 메모리에 할당
//	        외부 장치와 연결 시 드라이버가 필요한 것처럼, 메모리에 드라이버를 할당해야지만 접근이 가능하다.
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         
//	         정보를 전달하여 연결 객체 가져오기
//	         위의 정보를 드라이버매니저의 겟 커넥션을 사용하여 전달, 커넥션 객체에 저장
	         connection = DriverManager.getConnection(url, userName, password);
//	         연결 여부 파악, 
	         System.out.println("연결 성공");
//	         드라이버의 로딩이 실패했다는 오류가 발생
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	         System.out.println("드라이버 로딩 실패");
//	         sql 연결의 오류가 발생 시 
	      } catch (SQLException e) {
	         e.printStackTrace();
	         System.out.println("연결 실패");
//	         그 외의 오류 발생 시
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.out.println("알 수 없는 오류");
	      }
//	      앞으로 연결의 기본이 되는 문장들이다. 생각없이 사용하지 말고 반드시 숙지할것.
//	      가져온 정보를 담은 객체를 반환한다.(DB반환)
	      return connection;
	   }
}
