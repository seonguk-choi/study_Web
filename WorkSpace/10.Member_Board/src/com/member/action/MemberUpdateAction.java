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
import com.member.study.MemberDTO;

public class MemberUpdateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		MemberDTO dto = new MemberDTO();
		dto.setMember_id(request.getParameter("member_id"));
		dto.setMember_pw(request.getParameter("member_pw"));
		dto.setMember_name(request.getParameter("member_name"));
		dto.setMember_age(Integer.parseInt(request.getParameter("member_age")));
		dto.setMember_gender(request.getParameter("member_gender"));
		dto.setMember_email(request.getParameter("member_email"));
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(id == null) {	//로그인이 되어 있지 않은 상태
			out.println("<script>alert('로그인 하시기 바랍니다!');");
			out.println("location.href='memberLogin.me';</script>");
			//return null;
		}else {
			String member_id = request.getParameter("member_id");
			
			MemberDAO dao = new MemberDAO();
			int succ = dao.updateMember(dto);
			
			if(succ > 0) {
				out.println("<script>alert('수정성공!');");
				out.println("location.href='memberDetailAction.me?member_id="+dto.getMember_id()+"';</script>");
				//return null;
			}else {
				out.println("<script>alert('수정실패!');");
				out.println("location.href='boardList.bo';</script>");
				//return null;
			}
		}
		return null;
	}

}
