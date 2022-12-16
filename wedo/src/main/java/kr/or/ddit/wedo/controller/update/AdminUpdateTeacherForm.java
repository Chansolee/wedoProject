package kr.or.ddit.wedo.controller.update;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.wedo.service.ITeacherService;
import kr.or.ddit.wedo.service.TeacherServiceImpl;
import kr.or.ddit.wedo.vo.TeacherVO;

@WebServlet("/adminUpdateTeacherForm.do")
public class AdminUpdateTeacherForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String teacher_id = request.getParameter("teacher_id");
		
		ITeacherService tservice = TeacherServiceImpl.getInstance();
		TeacherVO teaVo = tservice.adminGetTeacher(teacher_id);
		request.setAttribute("teacherVo", teaVo);
		
		RequestDispatcher rd = request.getRequestDispatcher("mproject/classtable/adTeacherUpdate.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
