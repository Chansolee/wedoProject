package kr.or.ddit.wedo.controller.select;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.wedo.service.IOneToOneAnsService;
import kr.or.ddit.wedo.service.IOneToOneQnaService;
import kr.or.ddit.wedo.service.OneToOneAnsServiceImpl;
import kr.or.ddit.wedo.service.OneToOneQnaServiceImpl;
import kr.or.ddit.wedo.vo.OneToOneAnsVO;
import kr.or.ddit.wedo.vo.OneToOneQnaVO;


@WebServlet("/select1to1Teacher.do")
public class Select1to1Teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		//mem_id값
		String userId = (String) session.getAttribute("idvalue");
//		System.out.println("세션 id : " + userId);
		
		IOneToOneQnaService service= OneToOneQnaServiceImpl.getInstance();
		IOneToOneAnsService aservice = OneToOneAnsServiceImpl.getInstance();
		
		List<OneToOneQnaVO> otoqVo = service.selectTeacherQna(userId);
		List<OneToOneAnsVO> otoaVo = aservice.getAllTeacherAns(userId);
		
		session.setAttribute("otoaVo", otoaVo);
		session.setAttribute("otoqVo", otoqVo);
		
		
		
		response.sendRedirect(request.getContextPath() + "/mproject/1to1table/1to1Teacher.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
