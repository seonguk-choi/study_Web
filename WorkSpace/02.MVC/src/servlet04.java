import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.study.MemberDAO;
import com.hanul.study.MemberDTO;

@WebServlet("/s04.do")
public class Servlet04 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//① 클라이언트의 요청을 받는다 : 폼에서 입력하여 전달한 매개변수를 가져온다.
		//전달되는 매개변수가 없다.
		
		//② 비지니스 로직 : 전체회원 목록을 검색하는 메소드를 호출
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = dao.memberSearchAll();
		
		//③ 프리젠이션 로직 : 결과를 응답(html)
		response.setContentType("text/html; charset=utf-8");	//MIME Type
		PrintWriter out = response.getWriter();		//출력스트림
		out.println("<body>");
		out.println("<div align='center'>");
		out.println("<h3>[전체회원 목록보기]</h3>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th>이름</th>");
		out.println("<th>아이디</th>");
		out.println("<th>비밀번호</th>");
		out.println("<th>나이</th>");
		out.println("<th>주소</th>");
		out.println("<th>전화번호</th>");		
		out.println("<th>삭제</th>");		
		out.println("<th>삭제</th>");		
		out.println("</tr>");
		
		if(list.size() == 0) {
			out.println("<tr align='center'>");
			out.println("<td colspan='8'>회원목록이 없습니다!</td>");
			out.println("</tr>");
		}else {
			for (MemberDTO dto : list) {
				out.println("<tr align='center'>");
				out.println("<td>" + dto.getName() + "</td>");
				out.println("<td>" + dto.getId() + "</td>");
				out.println("<td>" + dto.getPw() + "</td>");
				out.println("<td>" + dto.getAge() + "</td>");
				out.println("<td>" + dto.getAddr() + "</td>");
				out.println("<td>" + dto.getTel() + "</td>");
				out.println("<td><a href='s05.do?id=" + dto.getId() + "'>삭제</a></td>");
				out.println("<td><input type='button' value='삭제' onclick='location.href=\"s05.do?id=" + dto.getId() + "\"'\"/></td>");
				out.println("</tr>");
			}
		}
		
		out.println("<tr align='center'>");
		out.println("<td colspan='8'>");
		out.println("<a href='memberMain.html'>회원가입화면</a>");
		out.println("&nbsp;&nbsp;&nbsp;");
		out.println("<input type='button' value='회원가입화면' onclick='location.href=\"memberMain.html\"'/>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
	}
}
