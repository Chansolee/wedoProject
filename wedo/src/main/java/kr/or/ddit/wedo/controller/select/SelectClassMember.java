package kr.or.ddit.wedo.controller.select;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.wedo.service.IMemberService;
import kr.or.ddit.wedo.service.MemberServiceImpl;
import kr.or.ddit.wedo.vo.EnrollClassVO;
import kr.or.ddit.wedo.vo.MemberVO;


@WebServlet("/selectClassMember.do")
public class SelectClassMember extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		//mem_id값
		String teacherid = (String) session.getAttribute("idvalue");
		
//		System.out.println(teacherid);
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		List<MemberVO> vo = service.selectClassMember(teacherid);
		
//		System.out.println(vo);
		
		session.setAttribute("memclassvo", vo);
		
		response.sendRedirect(request.getContextPath() + "/mproject/teacherpages/classuserList.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
