package kr.or.ddit.wedo.controller.select;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.wedo.service.IMemberService;
import kr.or.ddit.wedo.service.MemberServiceImpl;
import kr.or.ddit.wedo.vo.MemberVO;


@WebServlet("/passCheckMember.do")
public class PassCheckMember extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		//계정정보 받기
		String mem_id = (String) session.getAttribute("idvalue");
		String mem_pass = request.getParameter("mem_pass");
		
//		System.out.println("가져온 id " + mem_id);
//		System.out.println("가져온 pw " + mem_pass);
		
		MemberVO paramVO = new MemberVO();
		
		paramVO.setMem_id(mem_id);
		paramVO.setMem_pass(mem_pass);
		
		IMemberService service= MemberServiceImpl.getInstance();
		
		MemberVO memVO = service.loginMember(paramVO);
		
		//System.out.println(memVO);
		request.setAttribute("getid", memVO);
		

		
		RequestDispatcher disp = 
				request.getRequestDispatcher("mproject/userpages/memUpdate.jsp");
		
		 disp.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
