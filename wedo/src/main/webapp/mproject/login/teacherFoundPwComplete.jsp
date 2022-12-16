<%@page import="kr.or.ddit.wedo.vo.TeacherVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
   href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
   src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script
   src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script
   src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="mproject/login/css/found.css">
</head>

<body>
   <%
   //서블릿에서 저장된 데이터 꺼내기

   TeacherVO vo = (TeacherVO) request.getAttribute("getpass");
   if (vo != null) {
   %>
   <div class="container">
      <form class="needs-validation">
            <h1>비밀번호 찾기 결과</h1>
            <h4>귀하의 가입 시 이메일로 임시비밀번호를 발송하였습니다.</h4>
            <h4>확인하시고 로그인 하시길 바랍니다.</h4>
            <button type="button" class="btn btn-primary" onclick="location.href='mproject/login/index.jsp' ">로그인화면으로 돌아가기   </button>
      </form>
   </div>
         <%
         } else {
         %>
   <script>
      alert("등록된 정보가 없습니다!");
      history.back();//이전화면돌아가기
   </script>
   <%
   }
   %>
   
   
</body>
</html>