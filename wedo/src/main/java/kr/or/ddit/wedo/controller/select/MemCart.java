package kr.or.ddit.wedo.controller.select;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.wedo.service.CartClassServiceImpl;
import kr.or.ddit.wedo.service.CartServiceImpl;
import kr.or.ddit.wedo.service.ClassServiceImpl;
import kr.or.ddit.wedo.service.ICartClassService;
import kr.or.ddit.wedo.service.ICartService;
import kr.or.ddit.wedo.service.IClassService;
import kr.or.ddit.wedo.service.IMemberService;
import kr.or.ddit.wedo.service.MemberServiceImpl;
import kr.or.ddit.wedo.vo.CartClassVO;
import kr.or.ddit.wedo.vo.CartVO;
import kr.or.ddit.wedo.vo.ClassVO;


@WebServlet("/memCart.do")
public class MemCart extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String mem_id = (String) session.getAttribute("idvalue");
		
//		System.out.println("세션으로 로그인후 id : " + mem_id);
		
		//IClassService service= ClassServiceImpl.getInstance();
		ICartClassService service= CartClassServiceImpl.getInstance();
		
		List<CartClassVO> ccVo = service.getCartClass(mem_id);
		
		
		/*
		request.setAttribute("cartVo", cVo);
		
		request.getRequestDispatcher("mproject/cartnpaytable/cartindex.jsp").forward(request, response);
		*/
		
		session.setAttribute("cartclassVo", ccVo);
		
		response.sendRedirect(request.getContextPath() + "/mproject/cartnpaytable/cartcomplete.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
