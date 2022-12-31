package com.koreait.app.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.app.product.vo.ProductVO;
import com.koreait.mybatis.config.MyBatisConfig;

public class ProductDAO {
	SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlsessionFactory();
	SqlSession sqlSession;

	public ProductDAO() {
		sqlSession = sqlSessionFactory.openSession(true);
	}
	
	public void insert(ProductVO productVO) {
		sqlSession.insert("product.insert", productVO);
	}
	
	public List<ProductVO> selectAll(){
		return sqlSession.selectList("product.selectAll");
	}
}
