package kr.or.ddit.wedo.controller.insert;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.wedo.service.IMemberService;
import kr.or.ddit.wedo.service.IOneToOneAnsService;
import kr.or.ddit.wedo.service.MemberServiceImpl;
import kr.or.ddit.wedo.service.OneToOneAnsServiceImpl;
import kr.or.ddit.wedo.vo.OneToOneAnsVO;


@WebServlet("/insertReply.do")
public class InsertReply extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int one_qna_no = Integer.parseInt(request.getParameter("one_qna_no")) ;	
		String one_ans_id = request.getParameter("one_ans_id");
		String one_ans_content = request.getParameter("one_ans_content");
		
//		one_ans_content = one_ans_content.replace("\r\n","<br>"); //엔터키를 출력할 수 있게 해줌					
		
		IOneToOneAnsService service= OneToOneAnsServiceImpl.getInstance();		
		
		OneToOneAnsVO otoaVo = new OneToOneAnsVO();
		
		otoaVo.setOne_qna_no(one_qna_no);
		otoaVo.setOne_ans_id(one_ans_id);
		otoaVo.setOne_ans_content(one_ans_content);
		
		
		
		service.replyAns(otoaVo);
		
//		System.out.println("댓글삽입성공");
		
		Gson gson = new Gson();
		String jsonData = null; 
		jsonData = gson.toJson("1");
		PrintWriter out = response.getWriter();
		out.write(jsonData);
		response.flushBuffer();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
