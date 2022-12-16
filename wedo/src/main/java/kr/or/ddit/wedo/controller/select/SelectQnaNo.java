package kr.or.ddit.wedo.controller.select;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.wedo.service.IOneToOneAnsService;
import kr.or.ddit.wedo.service.IOneToOneQnaService;
import kr.or.ddit.wedo.service.OneToOneAnsServiceImpl;
import kr.or.ddit.wedo.service.OneToOneQnaServiceImpl;
import kr.or.ddit.wedo.vo.OneToOneQnaVO;


@WebServlet("/selectQnaNo.do")
public class SelectQnaNo extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		int one_qna_no = Integer.parseInt(request.getParameter("one_qna_no"));
		
//		System.out.println("게시물수정 글번호 : "+one_qna_no);
		
		IOneToOneQnaService service= OneToOneQnaServiceImpl.getInstance();
		
		OneToOneQnaVO otoqVo = service.selectQnaNo(one_qna_no);
		
//		System.out.println("서비스 이후 Vo값 : "+ otoqVo);
		
		String content = otoqVo.getOne_qna_content();// 테스트
		content = content.replace("<br/>","\r\n");// <br>로 되어있는거를 다시 바꿔줌 
		
		
		session.setAttribute("otoqVo", otoqVo);
		session.setAttribute("content", content);
		
		response.sendRedirect(request.getContextPath() + "/mproject/1to1table/updateQna.jsp");
	} 


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
