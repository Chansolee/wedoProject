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

import kr.or.ddit.wedo.service.ITeacherService;
import kr.or.ddit.wedo.service.TeacherServiceImpl;
import kr.or.ddit.wedo.vo.TeacherVO;

/**
 * Servlet implementation class IDSearch
 */
@WebServlet("/updatePassTeacher.do")
public class UpdatePassTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		HttpSession session = request.getSession();

	
		String userId = (String) session.getAttribute("idvalue");
//		System.out.println(userId);

		String userPass = request.getParameter("teacher_pass");

		ITeacherService service = TeacherServiceImpl.getInstance();

		String jsonData = null; // JSON형식의 문자열이 저장될 변수 선언

		PrintWriter out = response.getWriter();
		TeacherVO input = null;
		int res = 0;

		input = new TeacherVO();
		input.setTeacher_id(userId);

		input.setTeacher_pass(userPass);

//		System.out.println(input);

		res = service.updatePassTeacher(input);
//		System.out.println(res);
		if(res==1) {
			session.setAttribute("passvalue", userPass);
		}
		jsonData = gson.toJson(input);

		out.write(jsonData);
		response.flushBuffer();

	}

}