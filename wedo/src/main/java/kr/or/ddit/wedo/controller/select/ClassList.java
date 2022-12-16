package kr.or.ddit.wedo.controller.select;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.wedo.service.ClassServiceImpl;
import kr.or.ddit.wedo.service.IClassService;
import kr.or.ddit.wedo.vo.ClassVO;
import kr.or.ddit.wedo.vo.TeacherVO;

@WebServlet("/classList.do")
public class ClassList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String teacher_id = (String) session.getAttribute("idvalue");
		
//		System.out.println("세션으로 로그인후 id : " + teacher_id);
		
		IClassService service = ClassServiceImpl.getInstance();
		
		List<ClassVO> claVo = service.getTeacherClassList(teacher_id);
		
		session.setAttribute("classVo", claVo);
		
		response.sendRedirect(request.getContextPath() + "/mproject/1to1table/classList.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
