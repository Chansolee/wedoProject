package kr.or.ddit.wedo.controller.select;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.wedo.service.IMemberService;
import kr.or.ddit.wedo.service.MemberServiceImpl;
import kr.or.ddit.wedo.vo.MemberVO;


@WebServlet("/memLogin.do")
public class MemLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리
		request.setCharacterEncoding("UTF-8");
		
		//계정정보 받기
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		
//		System.out.println("가져온 id " + mem_id);
//		System.out.println("가져온 pw " + mem_pass);
		
		MemberVO paramVO = new MemberVO();
		
		paramVO.setMem_id(mem_id);
		paramVO.setMem_pass(mem_pass);
		
		IMemberService service= MemberServiceImpl.getInstance();
		
		MemberVO memVO = service.loginMember(paramVO);
		
//		System.out.println(memVO);
		
		HttpSession session = request.getSession();
		
		if(memVO!=null) {
			session.setAttribute("memvo", memVO);
			session.setAttribute("idvalue", mem_id);
			session.setAttribute("passvalue", mem_pass);
			session.setAttribute("namevalue", memVO.getMem_name());
			session.setAttribute("grade", "1");
			session.setAttribute("withdrawal", memVO.getMem_withdrawal());
			
		}else {
			session.setAttribute("memvo", memVO);
			System.out.println("저장실패");
			session.setAttribute("withdrawal", 2);
		} 
		
		//response.sendRedirect(request.getContextPath() + "/mproject/userpages/index.html");
		//response.sendRedirect(request.getContextPath() + "/mproject/userpages/memMypage.jsp");
		response.sendRedirect(request.getContextPath() + "/mproject/usermain/mainUser.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
