<%@page import="kr.or.ddit.wedo.vo.TeacherVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.wedo.vo.LectureVO"%>
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
<style>
	h1{
		text-align: center;
	}
</style>
</head>

<body>
<%
	ClassVO classVo = (ClassVO)request.getAttribute("classVo");
	
	List<LectureVO> lectureVo = (List<LectureVO>)request.getAttribute("lectureVo");

	List<TeacherVO> teacherVo = (List<TeacherVO>)request.getAttribute("teacherVo");
%>

	<div class="container">
	<h1>강좌 상세 페이지</h1>
		<form name = "classForm" id="classForm" method="post">
  			<input type="hidden" id= "class_no" name="class_no" value="<%=classVo.getClass_no() %>"> 
 		<table border = "1" class="table table-bordered">
			<tbody>
					<tr>
						<td>강좌 번호</td><td><%=classVo.getClass_no() %></td>
					</tr>
					
					<tr> 
						<td>강좌 명</td><td><%= classVo.getClass_name() %></td>
					</tr>
				
					<tr>
						<td>강좌 교재</td><td><%= classVo.getClass_book() %></td> 
					</tr>
					<tr>
						<td>강의 계획</td>
						<td><%= lectureVo.get(0).getLecture_no()%> <%= lectureVo.get(0).getLecture_title() %> <%= lectureVo.get(0).getLecture_content() %></td>
						<td><a href="<%=request.getContextPath() %>/showVideoTeacher.do?lecture_video=<%=lectureVo.get(0).getLecture_video() %>"> 강의보기 </a></td>
						
					</tr>				
					
<% 

					for(int i = 1; i< lectureVo.size(); i++){
						
%>					
					<tr>
						<td>강의 계획</td>
						<td><%= lectureVo.get(i).getLecture_no()%> <%= lectureVo.get(i).getLecture_title() %> <%= lectureVo.get(i).getLecture_content() %></td>
						<td> 강의보기 </td>
						
					</tr>
					
					
<%						
					}						
%>						
					
				
<%
					for(TeacherVO tvo : teacherVo){
%>
					<tr>
						<td>강사 정보</td>
						<td><%=tvo.getTeacher_name() %> <%=tvo.getTeacher_mail() %></td>
					</tr>
<%
					}
%>
				
					<tr>
						<td>수강료</td>
						<td><%= classVo.getTuition() %></td>
					</tr>
				<tr>
					<td colspan="2" style="text-align:center;">
				<button type="button" class="btn btn-primary" onclick="javascript:window.close()">창닫기</button>
				</td>
				</tr>
		</tbody>
</table>
</form>
</div>	
</body>
</html>
