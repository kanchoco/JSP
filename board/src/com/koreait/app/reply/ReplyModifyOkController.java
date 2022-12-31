package com.koreait.app.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.app.Execute;
import com.koreait.app.Result;
import com.koreait.app.reply.dao.ReplyDAO;
import com.koreait.app.reply.vo.ReplyVO;

public class ReplyModifyOkController implements Execute{
@Override
public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String replyContent = req.getParameter("replyContent");
	int replyNumber = Integer.parseInt(req.getParameter("replyNumber"));
	ReplyDAO replyDAO = new ReplyDAO();
	ReplyVO replyVO = new ReplyVO();
	
	replyVO.setReplyContent(replyContent);
	replyVO.setReplyNumber(replyNumber);
	
	replyDAO.update(replyVO);
	
	return null;
	
	}	
}
