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

	var btnList = document.getElementById("btnList");

	btnList.onclick = function(){
		location.href = "<%=request.getContextPath()%>/teacherList.do";
	}
};

</script>
</head>
<body>
<%
	TeacherVO teaVo = (TeacherVO)request.getAttribute("teacherVo");
%>

<div class="container">
	<h2>강사 정보 수정 폼</h2>
		<form action="<%=request.getContextPath() %>/adminUpdateTeacher.do" method="post">
			<input type="hidden" id="teacher_id" name="teacher_id" value="<%=teaVo.getTeacher_id() %>">
		<table border="1" class="table table-bordered">
			<tbody>
				<tr>
					<td>ID</td>
					<td><%=teaVo.getTeacher_id() %></td>
				</tr>
				
				<tr>
					<td>이름</td>
					<td><%=teaVo.getTeacher_name() %></td>
				</tr>
				
				<tr>
					<td>비밀번호</td>
					<td><input type = "text" name = "teacher_pass" value="<%=teaVo.getTeacher_pass()%>" placeholder="변경할 비밀번호를 입력하시오."></td>
				</tr>
				
				<tr>
					<td>전화번호</td>
					<td><input type = "text" name = "teacher_tel" value="<%=teaVo.getTeacher_tel()%>" placeholder="변경할 전화번호를 입력하시오."></td>
				</tr>
				
				<tr>
					<td>이메일 주소</td>
					<td><input type = "text" name = "teacher_mail" value="<%=teaVo.getTeacher_mail()%>" placeholder="변경할 이메일 주소를 입력하시오."></td>
				</tr>
				
				<tr>
					<td colspan="2" style="text-align:center;">
					<input type="submit" value="저장"> 
					<input type="reset" value="취소"> 
					<input type="button" id="btnList" value="강사 목록"></td>
				</tr>
			</tbody>
		</table>
		</form>
</div>
</body>
</html>