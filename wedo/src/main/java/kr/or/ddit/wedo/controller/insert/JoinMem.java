package kr.or.ddit.wedo.controller.insert;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.wedo.service.IMemberService;
import kr.or.ddit.wedo.service.MemberServiceImpl;
import kr.or.ddit.wedo.vo.MemberVO;

/**
 * Servlet implementation class IDSearch
 */
@WebServlet("/joinMem.do")
public class JoinMem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		
	
		String userId = request.getParameter("mem_id");
		
		String userPass = request.getParameter("mem_pass");
		
		String userName = request.getParameter("mem_name");
		String userMail = request.getParameter("mem_mail");
		String userTel = request.getParameter("mem_tel");
		String userAdd1 = request.getParameter("mem_addr1");
		String userAdd2 = request.getParameter("mem_addr2");
		String userReg1 = request.getParameter("mem_regno1");
		String userReg2 = request.getParameter("mem_regno2");
		int userwithdrawal = 0;
		
//		System.out.println(userId);
//		System.out.println(userName);
		
	
		IMemberService service= MemberServiceImpl.getInstance();
		
		
		String jsonData = null; 
		
		

		
		

		
		PrintWriter out = response.getWriter();
		MemberVO input = null;
		int res = 0;

			input = new MemberVO();
			input.setMem_id(userId);
			input.setMem_pass(userPass);
			input.setMem_name(userName);
			input.setMem_mail(userMail);	
			input.setMem_tel(userTel);
			input.setMem_addr1(userAdd1);
			input.setMem_addr2(userAdd2);
			input.setMem_regno1(userReg1);
			input.setMem_regno2(userReg2);
			input.setMem_withdrawal(userwithdrawal);
			
			
			
			res =service.join(input);
			

		
		jsonData = gson.toJson(res);
        
		out.write(jsonData);
		response.flushBuffer();

		
	
	}

}