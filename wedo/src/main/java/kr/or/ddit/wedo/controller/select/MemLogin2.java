package kr.or.ddit.wedo.controller.select;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.ddit.wedo.service.IMemberService;
import kr.or.ddit.wedo.service.MemberServiceImpl;
import kr.or.ddit.wedo.vo.MemberVO;

/**
 * Servlet implementation class IDSearch
 */
@WebServlet("/memlogin2.do")
public class MemLogin2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		HttpSession session = request.getSession();

		// 클라이언트 전송시 전달 데이터 받기

		String userId = request.getParameter("mem_id");
		
		String userPass = request.getParameter("mem_pass");
	//	System.out.println(userId);
	//	System.out.println(userPass);

		IMemberService service = MemberServiceImpl.getInstance();

		String jsonData = null; // JSON형식의 문자열이 저장될 변수 선언

		PrintWriter out = response.getWriter();
		MemberVO input = new MemberVO();
		MemberVO vo =  new MemberVO();

		input.setMem_id(userId);

		input.setMem_pass(userPass);

//		System.out.println(input.getMem_id());
//		System.out.println(input.getMem_pass());

		vo = service.loginMember(input);
//		System.out.println(vo.getMem_id());
//		System.out.println(vo.getMem_pass());
//		System.out.println(vo);
		if(vo!=null) {
			request.setAttribute("memvo", vo);
			session.setAttribute("idvalue", userId);
			session.setAttribute("passvalue", userPass);
			session.setAttribute("namevalue", vo.getMem_name());
			session.setAttribute("grade", "1");
		}else {
			System.out.println("저장실패");
		} 
		jsonData = gson.toJson(vo);

		out.write(jsonData);
		response.flushBuffer();

	}

}