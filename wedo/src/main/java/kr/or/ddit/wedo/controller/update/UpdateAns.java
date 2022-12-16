package kr.or.ddit.wedo.controller.update;

import java.io.IOException;
import java.io.PrintWriter;

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
import kr.or.ddit.wedo.vo.OneToOneAnsVO;
import kr.or.ddit.wedo.vo.OneToOneQnaVO;


@WebServlet("/updateAns.do")
public class UpdateAns extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		
		int one_ans_no = Integer.parseInt(request.getParameter("one_ans_no"));
		String ans_content = request.getParameter("ans_content");
		
		OneToOneAnsVO otoqVo = new OneToOneAnsVO();
		
		otoqVo.setOne_ans_no(one_ans_no);
		otoqVo.setOne_ans_content(ans_content);
		
		IOneToOneAnsService service= OneToOneAnsServiceImpl.getInstance();
		
		service.updateAns(otoqVo);

		
		Gson gson = new Gson();
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
