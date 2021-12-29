

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.study.memberDAO;

@WebServlet("/s05.do")
public class servket05 extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//① 클라이언트의 요청을 받는다 : 매개변수를 가져온다.
		request.setCharacterEncoding("utf-8"); //인코딩설정
		String id = request.getParameter("id");
		
		//② 비즈니스 로직 : 회원정보 삭제
		memberDAO dao = new memberDAO();
		int succ = dao.memberDelete(id);
		
				
		//③ 프리젠테이션 로직 : 결과 응답( html, jsp)
		response.setContentType("text/html; charset=utf-8");  // MIME Type
		PrintWriter out = response.getWriter(); //출력스트림
		if(succ > 0) {
			out.println("<script>alert('회원정보삭제 성공!!!');</script>");
			out.println("<a href='memberMain.html'>회원가입 화면으로 이동</a>");
			out.println("<br/><br/>");
			out.println("<a href='s04.do'>전체회원 목록보기</a>");
		}else {
			out.println("<script>alert('회원정보삭제 실패!!!');</script>");
			out.println("<a href='memberMain.html'>회원가입 화면으로 이동</a>");
			out.println("<br/><br/>");
			out.println("<a href='s04.do'>전체회원 목록보기</a>");
		}
	}
}
