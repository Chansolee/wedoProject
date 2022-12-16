package kr.or.ddit.wedo.controller.insert;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.wedo.service.ITeacherService;
import kr.or.ddit.wedo.service.TeacherServiceImpl;
import kr.or.ddit.wedo.vo.TeacherVO;

@WebServlet("/idCheckTeacher.do")
public class IdCheckTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();

		//tId = TeacherId약자
		String tId = request.getParameter("id");
//		System.out.println(tId);
		
		ITeacherService service = TeacherServiceImpl.getInstance();
		Gson gson = new Gson();
		String jsonData = null; 

		TeacherVO res = service.teacherIdSearch(tId);
		
		jsonData = gson.toJson(res);
        
		out.write(jsonData);
		response.flushBuffer();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
