package kr.or.ddit.wedo.controller.select;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.wedo.service.ILectureService;
import kr.or.ddit.wedo.service.LectureServiceImpl;

@WebServlet("/showVideoTeacher.do")
public class ShowVideoTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String lectureVideo = request.getParameter("lecture_video");
		
		ILectureService service = LectureServiceImpl.getInstance();
		
		String res = service.getVideo(lectureVideo);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("mproject/detailpage/showVideoTeacher.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
