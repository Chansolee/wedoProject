package kr.or.ddit.wedo.controller.select;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.wedo.service.ITeacherService;
import kr.or.ddit.wedo.service.TeacherServiceImpl;
import kr.or.ddit.wedo.vo.TeacherVO;


@WebServlet("/teacherSelectAll.do")
public class TeacherSelectAll extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ITeacherService service = TeacherServiceImpl.getInstance();
		
		List<TeacherVO> tVo =service.getAllTeacher();
		
		request.setAttribute("teacherVo", tVo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/mproject/1to1table/insertQna.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
