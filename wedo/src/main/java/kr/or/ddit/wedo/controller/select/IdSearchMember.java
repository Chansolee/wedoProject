package kr.or.ddit.wedo.controller.select;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.wedo.service.IMemberService;
import kr.or.ddit.wedo.service.MemberServiceImpl;
import kr.or.ddit.wedo.vo.MemberVO;

/**
 * Servlet implementation class IDSearch
 */
@WebServlet("/idSearchMember.do")
public class IdSearchMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		String userName = request.getParameter("name");
		
		String userTel = request.getParameter("tel");
//		System.out.println(userName);
//		System.out.println(userTel);
		
		IMemberService service= MemberServiceImpl.getInstance();

	
		
		
		MemberVO input = new MemberVO();
		input.setMem_name(userName);
		input.setMem_tel(userTel);
		MemberVO res =service.idSearchMember(input);
//		System.out.println(res);

		request.setAttribute("getid", res);

		RequestDispatcher disp = 
				request.getRequestDispatcher("mproject/login/memberFoundIdComplete.jsp");
		
		 disp.forward(request, response);
	}
}