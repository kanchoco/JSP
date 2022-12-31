package com.koreait.app.reply;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.app.Result;
import com.koreait.app.board.ListOkController;

public class ReplyFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req,resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String request = requestURI.substring(contextPath.length());
		Result result = null;
		
		if(request.equals("/reply/listOk.re")) {
			result = new ReplyOkController().execute(req,resp);
		}else if(request.equals("/reply/writeOk.re")) {
			result = new ReplyWriteOkController().execute(req, resp);
		}else if(request.equals("/reply/deleteOk.re")) {
			result = new ReplyDeleteOkController().execute(req, resp);
		}else if(request.equals("/reply/modifyOk.re")) {
			result = new ReplyModifyOkController().execute(req, resp);
		}
		
		if(result != null) {
			if(result.isRedirect()) {
				resp.sendRedirect(result.getPath());
			}else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(result.getPath());
				dispatcher.forward(req, resp);
			}
		}
	}
	
	
}
