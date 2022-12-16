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
	<h1>강의 보기 페이지</h1>
		<form name = "classForm" id="classForm" method="post">
  			<input type="hidden" id= "class_no" name="class_no" value="<%=classVo.getClass_no() %>"> 
 		<table border = "1" class="table table-bordered">
			<tbody>
					<tr> 
						<td>강좌 명</td><td><%= classVo.getClass_name() %></td>
					</tr>
				
<% 

					for(int i = 0; i< lectureVo.size(); i++){
						
%>					
					<tr>
						<td><%= lectureVo.get(i).getLecture_no()%></td>
						<td> <%= lectureVo.get(i).getLecture_title() %> <%= lectureVo.get(i).getLecture_content() %></td>
						<td><a href="<%=request.getContextPath() %>/showVideoUser.do?lecture_video=<%=lectureVo.get(i).getLecture_video() %>"> 강의보기 </a></td>
						
					</tr>
					
					
<%						
					}						
%>						
					
				
				<%-- <tr>
					<td colspan="2" style="text-align:center;">
				<button type="button" class="btn btn-primary" onclick="location.href='<%= request.getContextPath()%>/mproject/usermain/mainUser.jsp' ">메인페이지로 돌아가기</button>
				</td>
				</tr> --%>
		</tbody>
</table>
	<div style="padding:0px 50%"><button type="button" class="btn btn-primary" onclick="history.back()">뒤로가기</button> </div>
</form>
</div>	
</body>
</html>
