package kr.or.ddit.wedo.controller.update;

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


/**
 * Servlet implementation class IDSearch
 */
@WebServlet("/updateNotice.do")
public class UpdateNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		Gson gson = new Gson();
		HttpSession session = request.getSession();

		// 클라이언트 전송시 전달 데이터 받기

		int no = (Integer) session.getAttribute("noticeno");
//		System.out.println(no);

		String title = request.getParameter("notice_title");

		String content = request.getParameter("notice_content");
		
		content = content.replace("\r\n","<br>"); //

		INoticeService service = NoticeServiceImpl.getService();

		String jsonData = null; // JSON형식의 문자열이 저장될 변수 선언

		PrintWriter out = response.getWriter();
		NoticeVO input = null;
		int res = 0;

		input = new NoticeVO();
		input.setNotice_title(title);

		input.setNotice_content(content);
		input.setNotice_no(no);

//		System.out.println(input);

		res = service.updateNotice(input);

		jsonData = gson.toJson(res);

		out.write(jsonData);
		response.flushBuffer();

	}

}