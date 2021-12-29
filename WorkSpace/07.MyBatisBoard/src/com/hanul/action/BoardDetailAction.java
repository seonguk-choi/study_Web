package com.hanul.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.dao.BoardDAO;
import com.hanul.dto.BoardDTO;

public class BoardDetailAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//클라이언트의 요청
		request.setCharacterEncoding("utf-8");	//인코딩설정
		int b_num = Integer.parseInt(request.getParameter("b_num"));	//매개변수를 받는다
		
		//비지니스 로직
		BoardDAO dao = new BoardDAO();	
		dao.boardReadCountUpdate(b_num);
		BoardDTO dto = dao.boardDetail(b_num);	
		request.setAttribute("dto", dto);	
		
		//프리젠테이션 로직
		ActionForward forward = new ActionForward();
		forward.setPath("board/boardDetail.jsp");	
		forward.setRedirect(false);	
		return forward;	
	}
}
