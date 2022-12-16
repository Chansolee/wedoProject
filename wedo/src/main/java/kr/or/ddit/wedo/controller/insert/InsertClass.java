package kr.or.ddit.wedo.controller.insert;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.wedo.service.ClassServiceImpl;
import kr.or.ddit.wedo.service.IClassService;
import kr.or.ddit.wedo.vo.ClassVO;

@WebServlet("/insertClass.do")
@MultipartConfig
public class InsertClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자가 업로드한 파일이 저장될 서버쪽의 폴더 경로 설정
		String uploadPath = "D:\\A_TeachingMaterial\\4.MiddleProject\\workspace\\wedo\\src\\main\\webapp\\mproject\\1to1table\\img";
		
		// 저장될 폴더가 없으면 생성한다.
		File fileUploadDir = new File(uploadPath);
		if(!fileUploadDir.exists()) {
			fileUploadDir.mkdirs();
		}
		
		request.setCharacterEncoding("utf-8");
		
		String classNo = request.getParameter("class_no");
		String tution = request.getParameter("tuition");
		String classBook = request.getParameter("class_book");
		String managerId = request.getParameter("manager_id");
		String teacherId = request.getParameter("teacher_id");
		String className = request.getParameter("class_name");
		
		
		ClassVO classVo = new ClassVO();
		classVo.setClass_no(classNo);
		classVo.setTuition(tution);
		classVo.setClass_book(classBook);
		classVo.setManager_id(managerId);
		classVo.setTeacher_id(teacherId);
		classVo.setClass_name(className);
		
		
		// form의 file입력 요소의 name값을 이용하여 Part객체 구하기
		Part part = request.getPart("imagelink");
		
		
		if(part != null) {
			String image = extractFileName(part);
			if(!"".equals(image)) {
				try {
					String saveImage = UUID.randomUUID().toString();
					part.write(uploadPath + File.separator + saveImage);
					classVo.setImagelink(saveImage);
				} catch (IOException e) {
					classVo.setImagelink(null);
				}
			}
		}
		
		IClassService service = ClassServiceImpl.getInstance();
		
		int cnt = service.insertClass(classVo);
		response.sendRedirect(request.getContextPath() + "/classList.do");
		
	}



	private String extractFileName(Part part) {
		String fileName = "";
		String contentDisposition = part.getHeader("Content-Disposition");
		String[] items = contentDisposition.split(";");
		for(String item : items) {
			if(item.trim().startsWith("filename")) {
				fileName = item.substring(item.indexOf("=") + 2, item.length() - 1);
			}
		}
		return fileName;
	}

}
