package kr.or.ddit.wedo.controller.delete;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.wedo.service.CartServiceImpl;
import kr.or.ddit.wedo.service.ClassServiceImpl;
import kr.or.ddit.wedo.service.EnrollServiceImpl;
import kr.or.ddit.wedo.service.ICartService;
import kr.or.ddit.wedo.service.IClassService;
import kr.or.ddit.wedo.service.IEnrollService;
import kr.or.ddit.wedo.service.IPaymentService;
import kr.or.ddit.wedo.service.PaymentServiceImpl;
import kr.or.ddit.wedo.vo.CartVO;
import kr.or.ddit.wedo.vo.EnrollVO;
import kr.or.ddit.wedo.vo.PaymentVO;


@WebServlet("/withDrawalCart.do")
public class WithDrawalCart extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		//장바구니에 담겨진 cart_no 정보들
		String cartArr = request.getParameter("cartArr");
		HttpSession session = request.getSession();
		
		//mem_id값
		String userId = (String) session.getAttribute("idvalue");
		
		int start = 0;
		int end = 0;

		List<String> arr = new ArrayList<String>();
		int i = 0;

		while (true) {

			end = cartArr.indexOf(",", start + 1);
//			System.out.println("start : " + start);
//			System.out.println("end : " + end);

			if (end < 0) {
				end = cartArr.length();
				arr.add(cartArr.substring(start, end));
				break;
			}

			arr.add(cartArr.substring(start, end));

			i++;
			start = end + 1;

		}
		
		/*
		for (int j = 0; j < arr.size(); j++) {
			System.out.println(arr.get(j));
		}
		*/
		
		ICartService service = CartServiceImpl.getInstance();
		
		IPaymentService pservice = PaymentServiceImpl.getInstance();
		
		IEnrollService eservice = EnrollServiceImpl.getInstance();
		
		
		CartVO cVo = new CartVO();
		PaymentVO pVo = new PaymentVO();
		EnrollVO eVo = new EnrollVO();
		
		cVo.setMem_id(userId);
		pVo.setMem_id(userId);
		
		for(int j = 0 ; j < arr.size(); j++) {
			
			
			cVo.setCart_no(arr.get(j));
			
			pVo.setCart_no(arr.get(j));
			
			
			//장바구니에 담긴 데이터변경
			service.updateCart(cVo);
			
			//구매목록 추가
			pservice.insertPayment(pVo);
			
			//수강목록 추가
			eservice.insertEnroll(arr.get(j));
		}
		
		
		
		
		
		
//		System.out.println("결제완료.");
		
		//결제완료후 다시 내용을 검색해서 장바구니 내역에서 보여줌.
		response.sendRedirect(request.getContextPath() + "/memCart2.do");
		//----------------------------------------------------------------------

	}

}

