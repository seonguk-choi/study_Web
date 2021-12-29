package com.hanul.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {
	private Connection conn;		//연결객체
	private PreparedStatement ps;	//전송객체
	private ResultSet rs;			//결과객체
		
	public Connection getConn() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hanul";
		String password = "0000";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getConn() Exception!!!");
		}
		return conn;
	}//getConn()
		
	//DB접속 해제
	public void dbClose() {
		try {
			if(rs !=null) rs.close();
			if(ps !=null) ps.close();
			if(conn !=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();			
			System.out.println("dbClose() Exception!!!");
		}
	}//dbClose()	
		
	//도서정보 등록
	public int insertBook(BookDTO dto) {
		conn = getConn();
		String sql = "insert into tblbook values(?,?,?,?,?,?,?)";
		int succ = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getIsbn());
			ps.setString(4, dto.getComp());
			ps.setInt(5, dto.getCost());
			ps.setInt(6, dto.getQty());
			ps.setInt(7, dto.getPrice());
			succ = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();			
			System.out.println("insertMember() Exception!!!");
		} finally {
			dbClose();
		}
		return succ;
	}//insertBook()
	
	//도서정보 삭제
	public int deleteBook(String isbn) {
		conn = getConn();
		String sql = "delete from tblbook where isbn = ?";
		int succ = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, isbn);			
			succ = ps.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("memberDelete() Exception!!!");
		} finally {
			dbClose();
		}
		return succ;
	}//deleteBook()
	
	//도서목록보기
	public ArrayList<BookDTO> searchAllBook() {
		conn = getConn();
		String sql = "select * from tblbook";
		ArrayList<BookDTO> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();	
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setTitle(rs.getString("title"));
				dto.setName(rs.getString("name"));
				dto.setIsbn(rs.getString("isbn"));
				dto.setComp(rs.getString("comp"));
				dto.setCost(rs.getInt("cost"));
				dto.setQty(rs.getInt("qty"));
				dto.setPrice(rs.getInt("price"));				
				
				list.add(dto);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("searchAllBook() Exception!!!");
		} finally {
			dbClose();
		}
		return list;
	}//searchAllBook()
	
	//ISBN 중복검사
	public int checkIsbn(BookDTO dto) {
		conn = getConn();
		int cnt = 0;
		String sql = "SELECT COUNT(*) cnt FROM tblbook WHERE isbn = ?";
		try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, dto.getIsbn());
				rs = ps.executeQuery();
				while(rs.next()) {
					cnt = rs.getInt("cnt");
				}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("checkIsbn() Exception!!!");
		} finally {
			dbClose();
		}
		return cnt;
	}//checkIsbn()	
	
}
