

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.study.BookDAO;


@WebServlet("/ds.do")
public class DeleteServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//① 클라이언트의 요청
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
				
		//② 비지니스 로직
			BookDAO dao = new BookDAO();
			int succ = dao.deleteBook(id);
				
		//③ 프리젠테이션 로직
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			if(succ > 0) {
				out.println("<link rel='stylesheet' href='style.css' />");
				out.println("<div class='bg'>");
				out.println("<video muted autoplay loop>");
				out.println("<source src='rem.mp4' type='video/mp4'></video>");
				out.println("<div class='text'>");
				out.println("<script>alert('도서목록 삭제성공!!!');</script>");
				out.println("<div class=wrapper><a href='bookMain.html'>도서정보 입력하기</a>");
				out.println("<br/>");
				out.println("<a href='gals.do'>전체도서 목록보기</a></div>");
				out.println("</div>");
				out.println("</div>");
			}else {
				out.println("<link rel='stylesheet' href='style.css' />");
				out.println("<div class='bg'>");
				out.println("<video muted autoplay loop>");
				out.println("<source src='rem.mp4' type='video/mp4'></video>");
				out.println("<div class='text'>");
				out.println("<script>alert('도서목록 삭제실패!!!');</script>");
				out.println("<div class=wrapper><a href='bookMain.html'>도서정보 입력하기</a>");
				out.println("<br/>");
				out.println("<a href='gals.do'>전체도서 목록보기</a></div>");
				out.println("</div>");
				out.println("</div>");
			}
	}

}
