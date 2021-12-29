package com.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.commons.action.Action;
import com.commons.action.ActionForward;
import com.member.study.MemberDAO;

public class MemberSecessionAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		String member_id = request.getParameter("member_id");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(id == null) {	//로그인이 되어 있지 않은 상태
			out.println("<script>alert('로그인 하시기 바랍니다!');");
			out.println("location.href='memberLogin.me';</script>");
		}else if(!id.endsWith(member_id)) {
			out.println("<script>alert('정상적인 접근방식이 아닙니다!');");
			out.println("location.href='boardList.bo';</script>");
		}else {
			MemberDAO dao = new MemberDAO();
			int succ = dao.deleteMember(id);
			
			if(succ > 0) {
				session.removeAttribute("id");
				out.println("<script>alert('탈퇴성공!');");
				out.println("location.href='memberLogin.me';</script>");				
				//return null;
			}else {
				out.println("<script>alert('탈퇴실패!');");
				out.println("location.href='boardList.bo';</script>");
				//return null;
			}
		}
		return null;
	}

}
