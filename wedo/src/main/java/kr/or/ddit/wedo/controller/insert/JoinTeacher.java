package kr.or.ddit.wedo.controller.insert;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.wedo.service.ITeacherService;

import kr.or.ddit.wedo.service.TeacherServiceImpl;

import kr.or.ddit.wedo.vo.TeacherVO;

/**
 * Servlet implementation class IDSearch
 */
@WebServlet("/joinTeacher.do")
public class JoinTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();

		String userId = request.getParameter("teacher_id");

		String userPass = request.getParameter("teacher_pass");

		String userName = request.getParameter("teacher_name");
		String userMail = request.getParameter("teacher_mail");
		String userTel = request.getParameter("teacher_tel");
		int userwithdrawal = 0;

		

		ITeacherService service = TeacherServiceImpl.getInstance();

		String jsonData = null;
		

		PrintWriter out = response.getWriter();
		TeacherVO input = null;
		int res = 0;

		input = new TeacherVO();
		input.setTeacher_id(userId);
		input.setTeacher_pass(userPass);
		input.setTeacher_name(userName);
		input.setTeacher_mail(userMail);
		input.setTeacher_tel(userTel);
		input.setTeacher_withdrawal(userwithdrawal);

		

		res = service.join(input);

		
		jsonData = gson.toJson(res);

		out.write(jsonData);
		response.flushBuffer();

	}

}