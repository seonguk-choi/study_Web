package com.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.study.BoardDTO;
import com.commons.action.Action;
import com.commons.action.ActionForward;
import com.oreilly.servlet.MultipartRequest;

public class BoardAddAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//String saveFolder = "boardupload";
		//String realFolder = request.getRealPath(saveFolder);
		//System.out.println(realFolder);
		
		String realFolder = ""; //업로드한 파일이 저장되는 경로(위치)
		realFolder = "D:\\study_Web\\WorkSpace\\10.Member_Board\\WebContent\\boardupload";
		int fileSize = 5 * 1024 * 1024 ; //최대용량 : 5MB
		
		
		
		return null;
	}

}
