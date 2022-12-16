package kr.or.ddit.wedo.controller.update;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.wedo.service.ClassServiceImpl;
import kr.or.ddit.wedo.service.IClassService;
import kr.or.ddit.wedo.vo.ClassVO;
@WebServlet("/updateClassForm.do")
public class UpdateClassForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String class_no = request.getParameter("class_no");
		
		IClassService service = ClassServiceImpl.getInstance();
		ClassVO claVo = service.getClass(class_no);
		request.setAttribute("classVo", claVo);
		
		RequestDispatcher rd = request.getRequestDispatcher("mproject/1to1table/updateClass.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
