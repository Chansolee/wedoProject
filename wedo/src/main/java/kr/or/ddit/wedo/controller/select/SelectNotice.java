package kr.or.ddit.wedo.controller.select;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.ddit.wedo.service.INoticeService;
import kr.or.ddit.wedo.service.NoticeServiceImpl;
import kr.or.ddit.wedo.vo.NoticeVO;
//AJAX�� ����
/**
 * Servlet implementation class IDSearch
 */
@WebServlet("/selectNotice.do")
public class SelectNotice extends HttpServlet {
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
		HttpSession session = request.getSession();

		
		int noticeno = Integer.parseInt(request.getParameter("no"));
//		System.out.println(noticeno);
		
		INoticeService service = NoticeServiceImpl.getService();
		Gson gson = new Gson();
		String jsonData = null; 

		NoticeVO res = service.noSearch(noticeno);
//		System.out.println(res);
		request.setAttribute("vovo", res);
		session.setAttribute("vovo", res);
		session.setAttribute("noticeno", noticeno);
		
		jsonData = gson.toJson(res);
        
		out.write(jsonData);
		response.flushBuffer();
		
		
		

	}

}
