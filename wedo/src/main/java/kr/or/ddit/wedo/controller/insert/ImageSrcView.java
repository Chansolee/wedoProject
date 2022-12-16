package kr.or.ddit.wedo.controller.insert;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.wedo.service.ClassServiceImpl;
import kr.or.ddit.wedo.service.IClassService;
import kr.or.ddit.wedo.vo.ClassVO;

/**
 * Servlet implementation class ImageSrcView
 */
@WebServlet("/imageSrcView.do")
public class ImageSrcView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String classNo = request.getParameter("class_no");

		IClassService service = ClassServiceImpl.getInstance();

		ClassVO classVo = service.getClass(classNo);

		String fileName = classVo.getImagelink();
		if (fileName == null) {
			fileName = "noImage.png";
		}

		String downloadPath = "D:\\A_TeachingMaterial\\4.MiddleProject\\workspace\\wedo\\src\\main\\webapp\\mproject\\1to1table\\img";

		String filePath = downloadPath + File.separator + fileName;

		File file = new File(filePath);
		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;

		if (file.exists()) {
			try {
				// 출력용 스트림 객체 생성 ==> response객체 이용
				bos = new BufferedOutputStream(response.getOutputStream());

				// 파일 입력용 스트림 객체 생성
				bis = new BufferedInputStream(new FileInputStream(file));

				byte[] buffer = new byte[1024];
				int len = -1;

				// byte배열을 이용해서 파일 내용을 읽어와 출력용 스트림 객체로 출력한다.
				while ((len = bis.read(buffer)) > 0) {
					bos.write(buffer, 0, len);
				}
			} catch (IOException e) {
				System.out.println("입출력 오류 : " + e.getMessage());
			} finally {
				if (bis != null) {
					bis.close();
				}
				if (bos != null) {
					bos.flush();
					bos.close();
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
