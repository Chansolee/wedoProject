package kr.or.ddit.wedo.controller.update;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.wedo.service.IMemberService;
import kr.or.ddit.wedo.service.MemberServiceImpl;
import kr.or.ddit.wedo.vo.MemberVO;

@WebServlet("/updateUser.do")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mem_id = request.getParameter("mem_id");
		
		String mem_pass = request.getParameter("mem_pass");
		String mem_tel = request.getParameter("mem_tel");
		String mem_mail = request.getParameter("mem_mail");
		String mem_addr1 = request.getParameter("mem_addr1");
		String mem_addr2 = request.getParameter("mem_addr2");
		
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(mem_id);
		memVo.setMem_pass(mem_pass);
		memVo.setMem_tel(mem_tel);
		memVo.setMem_mail(mem_mail);
		memVo.setMem_addr1(mem_addr1);
		memVo.setMem_addr2(mem_addr2);
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		int res = service.updateMember(memVo);
		
		response.sendRedirect(request.getContextPath() + "/memberList.do");
		
	}

}
