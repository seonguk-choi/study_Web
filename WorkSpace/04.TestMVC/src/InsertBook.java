

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.study.BookDAO;
import com.hanul.study.BookDTO;


@WebServlet("/is.do")
public class InsertBook extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//① 클라이언트의 요청
		request.setCharacterEncoding("utf-8");
		BookDTO dto = new BookDTO();
		dto.setTitle(request.getParameter("title"));
		dto.setName(request.getParameter("name"));
		dto.setIsbn(request.getParameter("isbn"));
		dto.setComp(request.getParameter("comp"));
		dto.setCost(Integer.parseInt(request.getParameter("cost")));
		dto.setQty(Integer.parseInt(request.getParameter("qty")));
		dto.setPrice(dto.getCost()*dto.getQty());

		//② 비지니스 로직
		BookDAO dao = new BookDAO();
		int cnt = dao.checkIsbn(dto);
		
		//③ 프리젠테이션 로직
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(cnt>0) {
			out.println("<script>alert('ISBN 중복!!!'); location.href='bookMain.html';</script>");
		} else {	
			int succ = dao.insertBook(dto);
			if(succ > 0) {
				out.println("<link rel='stylesheet' href='style.css' />");
				out.println("<div class='bg'>");
				out.println("<video muted autoplay loop>");
				out.println("<source src='rem.mp4' type='video/mp4'></video>");
				out.println("<div class='text'>");
				out.println("<script>alert('도서목록 입력성공!!!');</script>");
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
				out.println("<script>alert('도서목록 입력실패!!!');</script>");
				out.println("<div class=wrapper><a href='bookMain.html'>도서정보 입력하기</a>");
				out.println("<br/>");
				out.println("<a href='gals.do'>전체도서 목록보기</a></div>");
				out.println("</div>");
				out.println("</div>");
			}
		}		
	}
}
