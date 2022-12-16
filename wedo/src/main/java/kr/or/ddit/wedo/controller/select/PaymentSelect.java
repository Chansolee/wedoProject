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
import kr.or.ddit.wedo.service.IPaymentClassService;
import kr.or.ddit.wedo.service.MemberServiceImpl;
import kr.or.ddit.wedo.service.PaymentClassServiceImpl;
import kr.or.ddit.wedo.vo.PaymentClassVO;


@WebServlet("/paymentSelect.do")
public class PaymentSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		String mem_id = (String) session.getAttribute("idvalue");
		
		IPaymentClassService service = PaymentClassServiceImpl.getInstance();
		
		List<PaymentClassVO> pcVo = service.paymentSelect(mem_id);
		
		session.setAttribute("paymentclassVo", pcVo);
		
		response.sendRedirect(request.getContextPath() + "/mproject/cartnpaytable/payindex.jsp");
		
		// ../cartnpaytable/payindex.jsp 결과값뿌린느곳
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
