<%@page import="kr.or.ddit.wedo.vo.TeacherVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>

<script type="text/javascript">
	window.onload = function(){
		var btnUpdate = document.getElementById("btnUpdate");
		var btnList = document.getElementById("btnList");
		
		
		btnUpdate.onclick = function(){
			var form = document.getElementById("teacherForm");
			form.action = "<%=request.getContextPath()%>/adminUpdateTeacherForm.do";
			form.submit();
		}
		
		btnList.onclick = function(){
			location.href = "<%=request.getContextPath()%>/teacherList.do";
		}
	};
</script>
</head>
<body>
<%
	TeacherVO teacherVo = (TeacherVO)request.getAttribute("teacherVo");
%>
<div class="container">
	<h2>강사 정보 상세보기</h2>
	<form name = "teacherForm" id="teacherForm" method="post">
		<input type = "hidden" id= "teacher_id" name= "teacher_id" value="<%=teacherVo.getTeacher_id() %>">
	<table border = "1" class ="table table-bordered">
		<tbody>
			
			<tr>
				<td>ID</td><td><%=teacherVo.getTeacher_id() %></td>
			</tr>
			
			<tr>
				<td>이름</td><td><%=teacherVo.getTeacher_name() %></td>
			</tr>
			
			<tr>
				<td>비밀번호</td><td><%=teacherVo.getTeacher_pass() %></td>
			</tr>
			
			<tr>
				<td>전화번호</td><td><%=teacherVo.getTeacher_tel() %></td>
			</tr>
			
			<tr>
				<td>이메일 주소</td><td><%=teacherVo.getTeacher_mail() %></td>
			</tr>
			
			<tr>
				<td colspan="2" style="text-align:center;">
					<input id="btnUpdate" type="button" value="수정"> 
					<input type="button" id="btnList" value="강사목록">
				</td>
			</tr>
		</tbody>
	</table>
	</form>
</div>
</body>
</html>