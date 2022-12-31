package com.koreait.app.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.koreait.app.product.dao.ProductDAO;

public class PrintOkController implements Execute{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		ProductDAO productDAO = new ProductDAO();
		JSONArray products = new JSONArray();
		PrintWriter out = resp.getWriter();
		
//		org.json.JSONArray는 String 타입의 List만 자동 변환 가능하다
//		만약 String이 아닌 VO와 같은 클래스타입으로 선언된 List일 경우 직접 JSONObject로 변환 후 JSONArray에 put해주어야 한다.
		productDAO.selectAll().forEach(productVO -> {JSONObject product = new JSONObject(productVO); products.put(product);});
		out.print(products.toString());
		out.close();
	}
}
