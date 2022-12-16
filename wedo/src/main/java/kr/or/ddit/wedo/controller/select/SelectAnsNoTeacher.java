package kr.or.ddit.wedo.controller.select;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.wedo.service.IOneToOneAnsService;
import kr.or.ddit.wedo.service.OneToOneAnsServiceImpl;
import kr.or.ddit.wedo.vo.OneToOneAnsVO;


@WebServlet("/selectAnsNoTeacher.do")
public class SelectAnsNoTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		int one_ans_no = Integer.parseInt(request.getParameter("one_ans_no")) ;
		
//		System.out.println("가져온 댓글 글번호 : " + one_ans_no);
		
		IOneToOneAnsService service= OneToOneAnsServiceImpl.getInstance();
		
		OneToOneAnsVO otoaVo = service.selectAns(one_ans_no);
		
		session.setAttribute("otoaVo", otoaVo);
		
		response.sendRedirect(request.getContextPath() + "/mproject/1to1table/updateAnsTeacher.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
