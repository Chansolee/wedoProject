package kr.or.ddit.wedo.controller.select;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import kr.or.ddit.wedo.service.INoticeService;
import kr.or.ddit.wedo.service.NoticeServiceImpl;
import kr.or.ddit.wedo.vo.NoticeVO;
import kr.or.ddit.wedo.vo.PageVO;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/noticeList.do")
public class NoticeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//한글 처리 
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		//클라이언트 전송시 전달 데이타 받기  - page, stype, sword
		int cpage = Integer.parseInt(request.getParameter("page"));
		
		//처음 실행시 깂이 존재 하지 않는다
		String stype = request.getParameter("stype");
		String sword = request.getParameter("sword");
		
		
		//service객체 얻기 
		 INoticeService  service =	NoticeServiceImpl.getService();
		 
		
		//서비스메소드 호출 -
		//param :page, stype, sword
		//결과값 : PageVO  - start, end , startPage, endPage , totalPage
		PageVO  vo = service.pageInfo(cpage, stype, sword);
		
		
		// map객체 설정- stype, sword, start, end) 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stype", stype);
		map.put("sword", sword);
		map.put("start", vo.getStart());
		map.put("end", vo.getEnd());
		
		//service메소드 호출-map파라미터  - 결과값 받기 
		//List가져오기 
		List<NoticeVO>  list = service.selectByPage(map);
		
//		System.out.println(list);
		
		//request에 결과값 저장 
		request.setAttribute("list", list);
		request.setAttribute("pvo", vo);

		
	
		  JsonObject obj = new JsonObject(); //pagevo도 제이슨형태로 보내주려고 obj선언
		  obj.addProperty("tpage", vo.getTotalPage()); //addProperty로 개별로 넣어줌 
		  obj.addProperty("spage", vo.getStartPage());
		  obj.addProperty("epage", vo.getEndPage());
		  
		  
		  Gson  gson = new Gson();
		  
		  
		  JsonElement  slist = gson.toJsonTree(list);   //서블릿에서 같음
		  obj.add("lists", slist); //obj에 리스트도 넣어줌
		 
		  PrintWriter out = response.getWriter();
		  
		  out.print(obj);
		  out.flush();
		  
		
		
		
	}
	
	
	

}






















