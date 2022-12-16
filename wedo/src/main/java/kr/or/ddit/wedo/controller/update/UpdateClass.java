package kr.or.ddit.wedo.controller.update;

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

@WebServlet("/updateClass.do")
@MultipartConfig
public class UpdateClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//	사용자가 업로드한 파일이 저장될 서버쪽의 폴더 경로 설정
		String uploadPath = "D:\\A_TeachingMaterial\\4.MiddleProject\\workspace\\wedo\\src\\main\\webapp\\mproject\\1to1table\\img";
		
		//	저장될 폴더가 없으면 생성한다.
		File fileUploadDir = new File(uploadPath);
		if(!fileUploadDir.exists()) {
			fileUploadDir.mkdirs();
		}
		
		request.setCharacterEncoding("UTF-8");
		String classNo = request.getParameter("class_no");
		String tuition = request.getParameter("tuition");
		String classBook = request.getParameter("class_book");
		String teacherId = request.getParameter("teacher_id");
		String className = request.getParameter("class_name");
		String old_image = request.getParameter("old_image");
		
		ClassVO claVo = new ClassVO();
		claVo.setClass_no(classNo);
		claVo.setTuition(tuition);
		claVo.setClass_book(classBook);
		claVo.setTeacher_id(teacherId);
		claVo.setClass_name(className);
		claVo.setImagelink(old_image);	//	일단 이전 이미지사진으로 셋팅한다.
		
		//	form의 file입력 요소의 name값을 이용하여 Part객체 구하기
		Part part = request.getPart("imagelink");
		
		if(part != null) {
			String image = extractFileName(part);
			if(!"".equals(image)) {
				try {
					String saveImage = UUID.randomUUID().toString();
					part.write(uploadPath + File.separator + saveImage);
					claVo.setImagelink(saveImage); // 수정파일이 있으면 새로운 파일명으로 셋팅
				} catch (IOException e) {

				}
			}
		}
		IClassService service = ClassServiceImpl.getInstance();
		
		int cnt = service.updateClass(claVo);
		
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
