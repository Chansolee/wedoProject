package kr.or.ddit.wedo.controller.delete;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.wedo.service.IOneToOneAnsService;
import kr.or.ddit.wedo.service.OneToOneAnsServiceImpl;
import kr.or.ddit.wedo.vo.OneToOneAnsVO;


@WebServlet("/replyDelete.do")
public class ReplyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		int one_ans_no = Integer.parseInt(request.getParameter("one_ans_no")) ;	
		
		 										
		IOneToOneAnsService service= OneToOneAnsServiceImpl.getInstance();		
		
		service.replyDelete(one_ans_no);
		
//		System.out.println("댓글삭제성공");
		
		String jsonData = null; 
		jsonData = gson.toJson("1");
		PrintWriter out = response.getWriter();
		out.write(jsonData);
		response.flushBuffer();
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
