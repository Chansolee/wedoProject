package kr.or.ddit.wedo.controller.select;

import java.io.IOException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.wedo.service.ITeacherService;
import kr.or.ddit.wedo.service.TeacherServiceImpl;

import kr.or.ddit.wedo.vo.TeacherVO;


/**
 * Servlet implementation class IDSearch
 */
@WebServlet("/passSearchTeacher.do")
public class PassSearchTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글처리
		request.setCharacterEncoding("UTF-8");

		// 클라이언트 전송시 전달 데이터 받기
		String userId = request.getParameter("id");

		String userTel = request.getParameter("tel");

//		System.out.println(userId);
//		System.out.println(userTel);
		// service객체 얻기
		ITeacherService service = TeacherServiceImpl.getInstance();

		// service메소드 호풀 결과값 받기

		TeacherVO input = new TeacherVO();
		input.setTeacher_id(userId);
		input.setTeacher_tel(userTel);
		TeacherVO res = service.passSearchTeacher(input);
//		System.out.println(res);
//		request에 결과값을 저장 만약 아이디 비번이 없으면 널값이 들어감 
     if(res!=null) {
		request.setAttribute("getpass", res);

		
		
		String mail = res.getTeacher_mail(); //membervo타입에서 메일만 빼옴
		String pass = res.getTeacher_pass();
		
		
		String host = "smtp.naver.com"; // SMTP 서비스를 해주는 메일 사이트
		final String user = "chansol128@naver.com"; // SMTP 서비스로 사용할 메일
		final String password = "cksthfl!128"; // 메일 비밀번호

		String to = mail; // 송신 메일 수신할 이메일

		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", host); // 이메일 발송을 처리해줄 SMTP 서버
		props.put("mail.smtp.auth", "true"); // 설정한 이메일 SMTP서버에 접속할 수 있는 권한 취득

		// 세션 : 클라이언트 별로 서버에 저장되는 정보 (
		// 사용자 컴퓨터에 저장되던 쿠키와 다르게 서버에 저장되므로, 비교적 보안이 필요한 데이터는 쿠키보다 세션에 저장한다.
		// 서버가 종료되거나 유효기간이 지나면 사라진다.
		Session session1 = Session.getDefaultInstance(props, new javax.mail.Authenticator() { // 설정값을 저장하여 세션 생성
			public javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(user, password); // PASSWORD 인증
			}
		});

		// Compose the message
		try {
			// 위에 설정한 내용을 가지고 mimeMessage클래스 생성
			// 실질적인 메일 작성 클래스 ( 메일 제목, 내용 등등)
			
			MimeMessage message = new MimeMessage(session1);
			
			// 발신자 셋팅
			message.setFrom(new InternetAddress(user)); // SMTP 발신자 이메일 주소

			// 수신자 셋팅
			// RecipientType = 받는사람 유형 (그룹, 사용자, 사서함, 폴더 등등)
			// InternetAddress(받는사람 메일)
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Subject
			// 메일 제목
			message.setSubject("[Pass Word]");

			// Text
			// 메일 내용
			message.setText("hi, your password [" + pass+"]"); // 텍스트 보내기
			// message.setContent("<h1>html123123 콘텐츠입니다</h1>","text/html"); // html 형식으로
			// 보내기
			// message.setContent("안녕하세요. 당신의 비밀번호는 12341234","text/html"); // html 형식으로 보내기
			// send the message
			// 메일 전송
			Transport.send(message);

			// 전송완료 출력 메세지
//			System.out.println("메일 송신 완료");

		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		// view페이지 이동
		RequestDispatcher disp = request.getRequestDispatcher("mproject/login/teacherFoundPwComplete.jsp");

		disp.forward(request, response);
		
     }else {
    	 RequestDispatcher disp = request.getRequestDispatcher("mproject/login/teacherFoundPwComplete.jsp");

 		disp.forward(request, response);
     }
	}
}