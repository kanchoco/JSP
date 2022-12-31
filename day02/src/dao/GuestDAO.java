package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import VO.GuestVO;

public class GuestDAO {
	public Connection connection;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet;
	
//	전체 회원 조회
	public ArrayList<GuestVO> selectAll(){
		String query = "select guest_number, guest_name, guest_birth from tbl_guest";
		ArrayList<GuestVO> guests = new ArrayList<>();
		
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				GuestVO guestVO = new GuestVO();
				guestVO.setGuestNumber(resultSet.getInt(1));
				guestVO.setGuestName(resultSet.getString(2));
				guestVO.setGuestBirth(resultSet.getString(3));
				
				guests.add(guestVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sellectAll에서 오류");
		}finally {							//무조건 실행, 
	         try {
	//		            연결 객체 모두 닫기
		            if(resultSet != null) {
		               resultSet.close();
		            }
		            if(preparedStatement != null) {
		               preparedStatement.close();
		            }
		            if(connection != null) {
		               connection.close();
		            }
		         } catch (SQLException e) {
		            throw new RuntimeException(e.getMessage());
		         }
		      }
		
		return guests;
	}
	public ArrayList<GuestVO> selectUser(String name){
		String query = "select guest_number, guest_name, guest_birth from tbl_guest where guest_name = ?";
		ArrayList<GuestVO> guests = new ArrayList<>();
		
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				GuestVO guestVO = new GuestVO();
				guestVO.setGuestNumber(resultSet.getInt(1));
				guestVO.setGuestName(resultSet.getString(2));
				guestVO.setGuestBirth(resultSet.getString(3));
				
				guests.add(guestVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sellecUser에서 오류");
		}finally {							//무조건 실행, 
			try {
				//		            연결 객체 모두 닫기
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return guests;
	}
	public ArrayList<GuestVO> desc(){
		String query = "select guest_number, guest_name, guest_birth from tbl_guest order by guest_number desc";
		ArrayList<GuestVO> guests = new ArrayList<>();
		
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				GuestVO guestVO = new GuestVO();
				guestVO.setGuestNumber(resultSet.getInt(1));
				guestVO.setGuestName(resultSet.getString(2));
				guestVO.setGuestBirth(resultSet.getString(3));
				
				guests.add(guestVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sellecUser에서 오류");
		}finally {							//무조건 실행, 
			try {
				//		            연결 객체 모두 닫기
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return guests;
	}
//	출력확인
	public static void main(String[] args) {
		GuestDAO guestDAO = new GuestDAO();
		
		System.out.println(guestDAO.desc());
	}
}
