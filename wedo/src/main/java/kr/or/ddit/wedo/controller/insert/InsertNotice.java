package kr.or.ddit.wedo.controller.insert;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.wedo.service.INoticeService;
import kr.or.ddit.wedo.service.NoticeServiceImpl;
import kr.or.ddit.wedo.vo.NoticeVO;


/**
 * Servlet implementation class IDSearch
 */
@WebServlet("/insertNotice.do")
public class InsertNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		Gson gson = new Gson();

		String title = request.getParameter("notice_title");

		String content = request.getParameter("notice_content");
		
		content = content.replace("\r\n","<br>"); //엔터키를 출력할 수 있게 해줌

		String admin = "admin";

//		System.out.println(title);
//		System.out.println(content);

		INoticeService service = NoticeServiceImpl.getService();

		String jsonData = null;
		

		PrintWriter out = response.getWriter();
		NoticeVO input = null;
		int res = 0;

		input = new NoticeVO();
		input.setNotice_title(title);
		input.setNotice_content(content);
		input.setManager_id(admin);

		res = service.insertNotice(input);

		jsonData = gson.toJson(res);

		out.write(jsonData);
		response.flushBuffer();

	}

}