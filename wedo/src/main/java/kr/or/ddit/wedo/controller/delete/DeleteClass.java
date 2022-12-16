package kr.or.ddit.wedo.controller.delete;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.wedo.service.ClassServiceImpl;
import kr.or.ddit.wedo.service.IClassService;

@WebServlet("/deleteClass.do")
public class DeleteClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String classNo = request.getParameter("class_no");
		IClassService service = ClassServiceImpl.getInstance();
		
		int cnt = service.deleteClass(classNo);
		
		response.sendRedirect(request.getContextPath() + "/classList.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
