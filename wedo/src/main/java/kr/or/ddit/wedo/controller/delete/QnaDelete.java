package kr.or.ddit.wedo.controller.delete;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.wedo.service.IOneToOneAnsService;
import kr.or.ddit.wedo.service.IOneToOneQnaService;
import kr.or.ddit.wedo.service.OneToOneAnsServiceImpl;
import kr.or.ddit.wedo.service.OneToOneQnaServiceImpl;


@WebServlet("/qnaDelete.do")
public class QnaDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int one_qna_no = Integer.parseInt(request.getParameter("one_qna_no")) ;	
		
//		System.out.println(one_qna_no);
		
		IOneToOneAnsService aservice= OneToOneAnsServiceImpl.getInstance();
		IOneToOneQnaService qservice= OneToOneQnaServiceImpl.getInstance();
		
		//1) 1:1게시물에 달려있는 댓글을 먼저 다 지우고
		aservice.replyAllDelete(one_qna_no);
		
		//2) 이후 게시물을 지운다.
		qservice.deleteQna(one_qna_no);

		response.sendRedirect("/wedo/select1to1Mem.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
