package kr.or.ddit.wedo.controller.select;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.wedo.service.ClassServiceImpl;
import kr.or.ddit.wedo.service.IClassService;
import kr.or.ddit.wedo.service.ILectureService;
import kr.or.ddit.wedo.service.ITeacherService;
import kr.or.ddit.wedo.service.LectureServiceImpl;
import kr.or.ddit.wedo.service.TeacherServiceImpl;
import kr.or.ddit.wedo.vo.ClassVO;
import kr.or.ddit.wedo.vo.LectureVO;
import kr.or.ddit.wedo.vo.TeacherVO;

@WebServlet("/classView.do")
public class ClassView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String class_no = request.getParameter("class_no");
		
		IClassService service = ClassServiceImpl.getInstance();
		ILectureService lservice = LectureServiceImpl.getInstance();
		ITeacherService tservice = TeacherServiceImpl.getInstance();
		
		ClassVO claVo = service.getClass(class_no);
		request.setAttribute("classVo", claVo);
		
		List<LectureVO> lectVo = lservice.getLecture(class_no);
		request.setAttribute("lectureVo", lectVo);
		
		List<TeacherVO> teacVo = tservice.getTeacher(class_no);
		request.setAttribute("teacherVo", teacVo);
		
		RequestDispatcher rd = request.getRequestDispatcher("mproject/1to1table/classView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
