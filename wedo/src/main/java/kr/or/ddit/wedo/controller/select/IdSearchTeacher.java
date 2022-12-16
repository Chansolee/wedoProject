package kr.or.ddit.wedo.controller.select;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.wedo.service.ITeacherService;
import kr.or.ddit.wedo.service.TeacherServiceImpl;
import kr.or.ddit.wedo.vo.MemberVO;
import kr.or.ddit.wedo.vo.TeacherVO;

/**
 * Servlet implementation class IDSearch
 */
@WebServlet("/idSearchTeacher.do")
public class IdSearchTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		String userName = request.getParameter("name");
		
		String userTel = request.getParameter("tel");
//		System.out.println(userName);
//		System.out.println(userTel);
		
		ITeacherService service= TeacherServiceImpl.getInstance();

	
		
		
		TeacherVO input = new TeacherVO();
		input.setTeacher_name(userName);
		input.setTeacher_tel(userTel);
		TeacherVO res =service.idSearchTeacher(input);
//		System.out.println(res);

		request.setAttribute("getid", res);

		RequestDispatcher disp = 
				request.getRequestDispatcher("mproject/login/teacherFoundIdComplete.jsp");
		
		 disp.forward(request, response);
	}
}