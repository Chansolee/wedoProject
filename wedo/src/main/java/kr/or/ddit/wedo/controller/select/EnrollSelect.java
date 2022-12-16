package kr.or.ddit.wedo.controller.select;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.wedo.service.EnrollClassServiceImpl;
import kr.or.ddit.wedo.service.IEnrollClassService;
import kr.or.ddit.wedo.vo.EnrollClassVO;


@WebServlet("/enrollSelect.do")
public class EnrollSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		//mem_id값
		String userId = (String) session.getAttribute("idvalue");
		
//		System.out.println(userId);
		
		IEnrollClassService service = EnrollClassServiceImpl.getInstance();
		
		List<EnrollClassVO> ecVo = service.enrollSelect(userId);
		
//		System.out.println(ecVo);
		
		session.setAttribute("ecVo", ecVo);
		
		response.sendRedirect(request.getContextPath() + "/mproject/userpages/userEnroll.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
