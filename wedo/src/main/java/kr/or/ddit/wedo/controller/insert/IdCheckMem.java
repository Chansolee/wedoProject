package kr.or.ddit.wedo.controller.insert;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.or.ddit.wedo.service.IMemberService;
import kr.or.ddit.wedo.service.MemberServiceImpl;
import kr.or.ddit.wedo.vo.MemberVO;
//AJAX�� ����
/**
 * Servlet implementation class IDSearch
 */
@WebServlet("/idCheckMem.do")
public class IdCheckMem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();

		
		String userId = request.getParameter("id");
//		System.out.println(userId);
		
		IMemberService service = MemberServiceImpl.getInstance();
		Gson gson = new Gson();
		String jsonData = null; 

		MemberVO res = service.idSearch(userId);
		
	
		jsonData = gson.toJson(res);
        
		out.write(jsonData);
		response.flushBuffer();

	}

}
