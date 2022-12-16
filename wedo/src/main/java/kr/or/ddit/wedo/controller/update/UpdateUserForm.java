package kr.or.ddit.wedo.controller.update;

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

@WebServlet("/updateUserForm.do")
public class UpdateUserForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mem_id = request.getParameter("mem_id");
		
		IMemberService mservice = MemberServiceImpl.getInstance();
		MemberVO memVo = mservice.getMember(mem_id);
		request.setAttribute("memberVo", memVo);
		
		RequestDispatcher rd = request.getRequestDispatcher("mproject/classtable/adUserUpdate.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
