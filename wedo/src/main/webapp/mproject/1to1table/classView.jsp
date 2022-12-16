<%@page import="kr.or.ddit.wedo.vo.LectureVO"%>
<%@page import="kr.or.ddit.wedo.vo.TeacherVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.wedo.vo.ClassVO"%>
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
		var btnDelete = document.getElementById("btnDelete");
		
		
		btnUpdate.onclick = function(){
			var form = document.getElementById("classForm");
			form.action = "<%=request.getContextPath()%>/updateClassForm.do";
			form.submit();
		}
		
		btnDelete.onclick = function(){
			var form = document.getElementById("classForm");
			form.action = "<%=request.getContextPath()%>/deleteClass.do";
			form.submit();
		}
		
		btnList.onclick = function(){
			location.href = "<%=request.getContextPath()%>/classList.do";
		}
	};
</script>

</head>
<body>
<% 
ClassVO classVo = (ClassVO)request.getAttribute("classVo");
List<LectureVO> lectureVo = (List<LectureVO>)request.getAttribute("lectureVo");
List<TeacherVO> teacherVo = (List<TeacherVO>)request.getAttribute("teacherVo");
%>
<div class="container">
<h2>강좌 정보 상세보기</h2>
<form name = "classForm" id="classForm" method="post">
 	<input type="hidden" id= "class_no" name="class_no" value="<%=classVo.getClass_no() %>"> 
<table border = "1" class="table table-bordered">
<tbody>

 	<tr> 
		<td colspan="2" style="text-align:center;"><img src="<%=request.getContextPath() %>/imageSrcView.do?class_no=<%=classVo.getClass_no() %>" width="200" height="140"></td> 
 	</tr> 
	
	<tr>
		<td>강좌 번호</td><td><%=classVo.getClass_no() %></td>
	</tr>
	
	<tr>
		<td>강좌 명</td><td><%=classVo.getClass_name() %></td>
	</tr>
	
	<tr>
		<td>강좌 교재</td><td><%=classVo.getClass_book() %></td>
	</tr>
<%
		for(LectureVO lvo : lectureVo){
%>
	<tr>
		<td>강의 계획</td>
		<td><%= lvo.getLecture_no()%> <%= lvo.getLecture_title() %> <%= lvo.getLecture_content() %></td>
	</tr>
<%
		}
%>
	
		
<%
		for(TeacherVO vo : teacherVo){
%>
	<tr>
		<td>강사 명</td>
		<td><%=vo.getTeacher_name() %></td>
	</tr>
<%
		}
%>
	<tr>
		<td>수강료</td><td><%=classVo.getTuition() %></td>
	</tr>
	<tr>
		<td colspan="2" style="text-align:center;">
			<input id="btnUpdate" type="button" value="수정"> 
			<input id="btnDelete" type="button" value="삭제"> 
			<input type="button" id="btnList" value="강좌목록"></td>
	</tr>
</tbody>
</table>
</form>
</div>
</body>
</html>