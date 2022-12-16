package kr.or.ddit.wedo.controller.select;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.wedo.service.IOneToOneAnsService;
import kr.or.ddit.wedo.service.OneToOneAnsServiceImpl;
import kr.or.ddit.wedo.vo.OneToOneAnsVO;


@WebServlet("/selectAns.do")
public class SelectAns extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		int qnaNo = Integer.parseInt(request.getParameter("qna_no"));
		
//		System.out.println("가져온 글번호 : " + qnaNo);
		
		IOneToOneAnsService service= OneToOneAnsServiceImpl.getInstance();
		
		List<OneToOneAnsVO>  otoaVo = service.getAns(qnaNo);
		
		session.setAttribute("otoaVo", otoaVo);
		
		response.sendRedirect(request.getContextPath() + "/mproject/1to1table/1to1index.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
