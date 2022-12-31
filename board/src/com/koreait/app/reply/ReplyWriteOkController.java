package com.koreait.app.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.app.Execute;
import com.koreait.app.Result;
import com.koreait.app.reply.dao.ReplyDAO;
import com.koreait.app.reply.vo.ReplyVO;

public class ReplyWriteOkController implements Execute{
 @Override
public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 ReplyVO replyVO = new ReplyVO();
	 ReplyDAO replyDAO = new ReplyDAO();
	 
	 String replyContent = req.getParameter("replyContent");
	 int boardNumber = Integer.valueOf(req.getParameter("boardNumber"));
	 int memberNumber = Integer.valueOf(req.getParameter("memberNumber"));
	 
	 replyVO.setBoardNumber(boardNumber);
	 replyVO.setMemberNumber(memberNumber);
	 replyVO.setReplyContent(replyContent);
	 
	 replyDAO.insert(replyVO);
	 
	return null;
}
}
