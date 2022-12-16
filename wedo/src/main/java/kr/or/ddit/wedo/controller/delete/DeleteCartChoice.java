package kr.or.ddit.wedo.controller.delete;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.ddit.wedo.service.CartServiceImpl;
import kr.or.ddit.wedo.service.ICartService;
import kr.or.ddit.wedo.vo.CartVO;


@WebServlet("/deleteCartChoice.do")
public class DeleteCartChoice extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String[] arr= request.getParameterValues("Arr");
	

//		System.out.println(arr.length);
		
		
		ICartService service = CartServiceImpl.getInstance();
		Gson gson = new Gson();
		String jsonData = null; 

	   int res=0;
		for(int i=0; i<arr.length; i++) {
//		System.out.println("넣기전" );
		 res = service.deleteCartChoice(arr[i]);
//		System.out.println(res);
		
		
		}
	
		jsonData = gson.toJson(res);
        
		out.write(jsonData);
		response.flushBuffer();
		
		
		

	}

}
