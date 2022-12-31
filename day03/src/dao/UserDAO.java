package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.koreait.mybatis.config.MyBatisConfig;

import vo.UserVO;

public class UserDAO {
	public Connection connection;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet;
	public SqlSession sqlSession;
	
//	- id중복검사
//	- 회원가입(동일한 핸드폰 번호로 최대 3번 가입 가능)
//		* 일반계정 2개, 탈퇴계정 1개 -> 가입 불가능
//	- 로그인
//	- 아이디 찾기
//	- 회원정보 수정
//	- 회원번호로 회원 전체 정보 검색
//	- 회원탈퇴(어떤 계정을 탈퇴할 지 선택)
//	- 회원탈퇴 복구(어떤 계정을 복구할 지 선택)
	
	public UserDAO() {
		sqlSession = MyBatisConfig.getSqlsessionFactory().openSession(true);
	}
	
	public boolean checkId(String userId) {
		return (Integer)sqlSession.selectOne("User.checkId", userId) == 1;
	}
	
//	public boolean checkId(String userId) {
//		String query = "select count(user_number) from tbl_user where user_id = ?";
//		boolean check = false;
//		try {
//			connection = DBConnecter.getConnection();
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1, userId);
//			resultSet = preparedStatement.executeQuery();
//			
//			resultSet.next();
//			check = resultSet.getInt(1) == 1;
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(resultSet != null) {
//					resultSet.close();
//				}
//				if(preparedStatement != null) {
//					preparedStatement.close();
//				}
//				if(connection != null) {
//					connection.close();
//				}
//			} catch (SQLException e) {
//				throw new RuntimeException(e);
//			}
//		}
//		return check;
//	}
	
//	- 아이디 찾기
	public String findId(String userPhone) {
		return (String)sqlSession.selectOne("User.findId", userPhone);
	}
	
//	회원가입
	public void insert(UserVO userVO) {
		sqlSession.insert("User.insert", userVO);
	}
//	public void insert(UserVO userVO) {
//		String query = "insert into tbl_user (user_id) values (?)";
//		try {
//			connection = DBConnecter.getConnection();
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1, userVO.getUserId());
//			preparedStatement.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(preparedStatement != null) {
//					preparedStatement.close();
//				}
//				if(connection != null) {
//					connection.close();
//				}
//			} catch (SQLException e) {
//				throw new RuntimeException(e);
//			}
//		}
//	}
	
//	로그인
	public UserVO login(UserVO userVO) {
		return sqlSession.selectOne("User.login", userVO);
	}
	
	
	
}










