package kr.or.ddit.wedo.controller.update;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.wedo.service.ITeacherService;
import kr.or.ddit.wedo.service.TeacherServiceImpl;
import kr.or.ddit.wedo.vo.TeacherVO;

@WebServlet("/adminUpdateTeacher.do")
public class AdminUpdateTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String teacher_id = request.getParameter("teacher_id");
		
		String teacher_pass = request.getParameter("teacher_pass");
		String teacher_tel = request.getParameter("teacher_tel");
		String teacher_mail = request.getParameter("teacher_mail");
		
		TeacherVO teaVo = new TeacherVO();
		teaVo.setTeacher_id(teacher_id);
		teaVo.setTeacher_pass(teacher_pass);
		teaVo.setTeacher_tel(teacher_tel);
		teaVo.setTeacher_mail(teacher_mail);
		
		ITeacherService service = TeacherServiceImpl.getInstance();
		
		int res = service.updateTeacher(teaVo);
		
		response.sendRedirect(request.getContextPath() + "/teacherList.do");
	}

}
