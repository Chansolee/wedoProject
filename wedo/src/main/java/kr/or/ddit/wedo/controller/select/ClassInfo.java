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


@WebServlet("/classInfo.do")
public class ClassInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String classNo = request.getParameter("classNo");
		
		//String classNo = request.getParameter("classNo");
		
//		System.out.println("classNo : " + classNo);
		
		IClassService service = ClassServiceImpl.getInstance();
		
		ILectureService lservice = LectureServiceImpl.getInstance();
		
		ITeacherService tservice = TeacherServiceImpl.getInstance();
		
		ClassVO classVo = service.getClass(classNo);
		request.setAttribute("classVo", classVo);
		
		
		List<LectureVO> lectureVo = lservice.getLecture(classNo);
		request.setAttribute("lectureVo", lectureVo);
		
		List<TeacherVO> teacherVo = tservice.getTeacher(classNo);
		request.setAttribute("teacherVo", teacherVo);
		
		RequestDispatcher disp = 
				request.getRequestDispatcher("mproject/detailpage/classDetail.jsp");
		
		disp.forward(request, response);
	}

}
