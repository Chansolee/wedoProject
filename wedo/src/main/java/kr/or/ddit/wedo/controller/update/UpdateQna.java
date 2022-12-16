package kr.or.ddit.wedo.controller.update;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.wedo.service.IOneToOneQnaService;
import kr.or.ddit.wedo.service.OneToOneQnaServiceImpl;
import kr.or.ddit.wedo.vo.OneToOneQnaVO;


@WebServlet("/updateQna.do")
public class UpdateQna extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int one_qna_no = Integer.parseInt(request.getParameter("one_qna_no"));
		String qna_title = request.getParameter("qna_title");
		String qna_content = request.getParameter("qna_content");
		
//		qna_content = qna_content.replace("\r\n","<br>"); //
		
		OneToOneQnaVO otoqVo = new OneToOneQnaVO();
		
		otoqVo.setOne_qna_no(one_qna_no);
		otoqVo.setOne_qna_title(qna_title);
		otoqVo.setOne_qna_content(qna_content);
		
		
		
		IOneToOneQnaService service= OneToOneQnaServiceImpl.getInstance();
		
		service.updateQna(otoqVo);

		
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
