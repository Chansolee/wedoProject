package kr.or.ddit.wedo.controller.insert;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.wedo.service.CartServiceImpl;
import kr.or.ddit.wedo.service.ICartService;
import kr.or.ddit.wedo.vo.CartVO;

@WebServlet("/insertCart.do")
public class InsertCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String mem_id = (String) session.getAttribute("idvalue");
		String class_no = request.getParameter("classNo");
		
//		System.out.println("세션으로 로그인 후 id : " + mem_id);
		
		CartVO cVo = new CartVO();
		
//		System.out.println("mem_id" + mem_id);
//		System.out.println("class_no" + class_no);
		
		cVo.setMem_id(mem_id);
		cVo.setClass_no(class_no);
		
		
		
		ICartService service = CartServiceImpl.getInstance();
		
		CartVO vo = service.searchCart(cVo);
//		System.out.println("중복체크"  +vo);
		if(vo!=null) {
			response.sendRedirect(request.getContextPath() + "/mproject/cartnpaytable/cartSearch.jsp");
		}else {
			service.insertCart(cVo);
			response.sendRedirect(request.getContextPath() + "/memCart.do");
		}
		
//		service.insertCart(cVo);
//		response.sendRedirect(request.getContextPath() + "/memCart.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
