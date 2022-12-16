package kr.or.ddit.wedo.controller.select;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.wedo.service.IManagerService;
import kr.or.ddit.wedo.service.IMemberService;
import kr.or.ddit.wedo.service.ITeacherService;
import kr.or.ddit.wedo.service.ManagerServiceImpl;
import kr.or.ddit.wedo.service.MemberServiceImpl;
import kr.or.ddit.wedo.service.TeacherServiceImpl;
import kr.or.ddit.wedo.vo.ManagerVO;
import kr.or.ddit.wedo.vo.TeacherVO;

@WebServlet("/managerLogin.do")
public class ManagerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리
		request.setCharacterEncoding("UTF-8");
		
		//계정정보 받기
		String manager_id = request.getParameter("manager_id");
		String manager_pass = request.getParameter("manager_pass");
		
//		System.out.println("가져온 id " + manager_id);
//		System.out.println("가져온 pw " + manager_pass);
		
		ManagerVO paramVO = new ManagerVO();
		
		paramVO.setManager_id(manager_id);
		paramVO.setManager_pass(manager_pass);
		
		IManagerService service= ManagerServiceImpl.getInstance();
		
		ManagerVO managerVO = service.loginManager(paramVO);
		
		//System.out.println(memVO);
		
		HttpSession session = request.getSession();
		
		if(managerVO!=null) {
			session.setAttribute("managervo", managerVO);
			session.setAttribute("idvalue", manager_id);
			session.setAttribute("namevalue", "우리두 관리자");
			session.setAttribute("grade", "3"); //관리자는 등급 : 3
		}else {
			System.out.println("저장실패");
		}
		
		//response.sendRedirect(request.getContextPath() + "/mproject/userpages/index.html");
		//response.sendRedirect(request.getContextPath() + "/mproject/userpages/memMypage.jsp");
		response.sendRedirect(request.getContextPath() + "/mproject/adminmain/mainAdmin.jsp");
	}

}
