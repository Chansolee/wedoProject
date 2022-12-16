package kr.or.ddit.wedo.controller.select;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.wedo.service.IMemberService;
import kr.or.ddit.wedo.service.ITeacherService;
import kr.or.ddit.wedo.service.MemberServiceImpl;
import kr.or.ddit.wedo.service.TeacherServiceImpl;
import kr.or.ddit.wedo.vo.MemberVO;
import kr.or.ddit.wedo.vo.TeacherVO;


@WebServlet("/teacherLogin.do")
public class TeacherLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//한글처리
				request.setCharacterEncoding("UTF-8");
				
				//계정정보 받기
				String teacher_id = request.getParameter("teacher_id");
				String teacher_pass = request.getParameter("teacher_pass");
				
//				System.out.println("가져온 id " + teacher_id);
//				System.out.println("가져온 pw " + teacher_pass);
				
				TeacherVO paramVO = new TeacherVO();
				
				paramVO.setTeacher_id(teacher_id);
				paramVO.setTeacher_pass(teacher_pass);
				
				ITeacherService service= TeacherServiceImpl.getInstance();
				
				TeacherVO teaVO = service.loginTeacher(paramVO);
				
				//System.out.println(memVO);
				
				HttpSession session = request.getSession();
				
				if(teaVO!=null) {
					session.setAttribute("teavo", teaVO);
					session.setAttribute("idvalue", teacher_id);
					session.setAttribute("passvalue", teacher_pass);
					session.setAttribute("namevalue", teaVO.getTeacher_name());
					session.setAttribute("grade", "2"); //강사는 등급2
					session.setAttribute("withdrawal", teaVO.getTeacher_withdrawal());
				}else {
					session.setAttribute("teavo", teaVO);
//					System.out.println("저장실패");
					session.setAttribute("withdrawal", 2);
				} 
				
				
				response.sendRedirect(request.getContextPath() + "/mproject/teachermain/mainTeacher.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
