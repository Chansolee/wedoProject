package kr.or.ddit.wedo.controller.update;

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
@WebServlet("/updatePassMember.do")
public class UpdatePassMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		HttpSession session = request.getSession();

		// 클라이언트 전송시 전달 데이터 받기

		// String userId = request.getParameter("mem_id");
		String userId = (String) session.getAttribute("idvalue");
//		System.out.println(userId);

		String userPass = request.getParameter("mem_pass");

		IMemberService service = MemberServiceImpl.getInstance();

		String jsonData = null; // JSON형식의 문자열이 저장될 변수 선언

		PrintWriter out = response.getWriter();
		MemberVO input = null;
		int res = 0;

		input = new MemberVO();
		input.setMem_id(userId);

		input.setMem_pass(userPass);

//		System.out.println(input);

		res = service.updatePassMember(input);
//		System.out.println(res);
		if(res==1) {
			session.setAttribute("passvalue", userPass);
		}
		jsonData = gson.toJson(input);

		out.write(jsonData);
		response.flushBuffer();

	}

}