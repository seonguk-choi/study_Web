

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.study.BookDAO;
import com.hanul.study.BookDTO;



@WebServlet("/gals.do")
public class GetAllListServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//① 클라이언트의 요청
		
		//② 비지니스 로직
		BookDAO dao = new BookDAO();
		ArrayList<BookDTO> list = dao.searchAllBook();
		
		//③ 프리젠이션 로직
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("<body>");
		out.println("<div class='bg'>");
		out.println("<video muted autoplay loop>");
		out.println("<source src='rem.mp4' type='video/mp4'></video>");
		out.println("<div class='text'>");
		out.println("<div align='center'>");
		out.println("<h3>전체회원 목록보기</h3>");
		out.println("<table class='tbl'>");
		out.println("<tr>");
		out.println("<th>도서명</th>");
		out.println("<th>저자</th>");
		out.println("<th>ISBN</th>");
		out.println("<th>출판사</th>");
		out.println("<th>단가</th>");
		out.println("<th>수량</th>");		
		out.println("<th>가격</th>");		
		out.println("<th>삭제</th>");		
		out.println("</tr>");
		out.println("</tr>");
		out.println("<td colspan='8'class='tbl-td'></td>");
		out.println("</tr>");
		
		if(list.size() == 0) {
			out.println("<tr align='center'>");
			out.println("<td colspan='8'>회원목록이 없습니다!</td>");
			out.println("</tr>");
			out.println("</tr>");
			out.println("<td colspan='8'class='tbl-td'></td>");
			out.println("</tr>");
		}else {
			for (BookDTO dtos : list) {
				out.println("<tr align='center'>");
				out.println("<td>" + dtos.getTitle() + "</td>");
				out.println("<td>" + dtos.getName() + "</td>");
				out.println("<td>" + dtos.getIsbn() + "</td>");
				out.println("<td>" + dtos.getComp() + "</td>");
				out.println("<td>" + dtos.getCost() + "</td>");
				out.println("<td>" + dtos.getQty() + "</td>");
				out.println("<td>" + dtos.getPrice() + "</td>");
				out.println("<td><input type='button' value='삭제' onclick='location.href=\"ds.do?id=" + dtos.getIsbn() + "\"'\" class='btn'/></td>");
				out.println("</tr>");
				out.println("</tr>");
				out.println("<td colspan='8'class='tbl-td'></td>");
				out.println("</tr>");
			}
		}
		
		out.println("<tr align='center'>");
		out.println("<td colspan='8'>");
		out.println("<input type='button' value='도서정보 입력하기' onclick='location.href=\"bookMain.html\"' class='btn'/>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
	}
}
