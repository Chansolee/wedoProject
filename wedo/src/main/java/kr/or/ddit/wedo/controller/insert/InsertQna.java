package kr.or.ddit.wedo.controller.insert;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.ddit.wedo.service.IOneToOneAnsService;
import kr.or.ddit.wedo.service.IOneToOneQnaService;
import kr.or.ddit.wedo.service.OneToOneAnsServiceImpl;
import kr.or.ddit.wedo.service.OneToOneQnaServiceImpl;
import kr.or.ddit.wedo.vo.OneToOneQnaVO;


@WebServlet("/insertQna.do")
public class InsertQna extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Gson gson = new Gson();
		//System.out.println("인서트 Qna 시도");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String teacherid = request.getParameter("teacherid");
		String memId = (String) session.getAttribute("idvalue");
		
//		System.out.println("<br>전 content : " + content);
		
		content = content.replace("\r\n","<br>"); //엔터키를 출력할 수 있게 해줌
		
//		System.out.println("<br>후 content : " + content);
		
		OneToOneQnaVO otoqVo = new OneToOneQnaVO();
		
		otoqVo.setMem_id(memId);
		otoqVo.setOne_qna_content(content);
		otoqVo.setOne_qna_title(title);
		otoqVo.setTeacher_id(teacherid);
		
		IOneToOneQnaService service= OneToOneQnaServiceImpl.getInstance();
		
		service.insertQna(otoqVo);
		
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
