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

	var btnList = document.getElementById("btnList");

	btnList.onclick = function(){
		location.href = "<%=request.getContextPath()%>/classList.do";
	}
};

</script>
</head>
<body>

<%
	ClassVO claVo = (ClassVO)request.getAttribute("classVo");
%>
<div class="container">
<h2>강좌 정보 수정 폼</h2>
<form action="<%=request.getContextPath()%>/updateClass.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="class_no" value="<%=claVo.getClass_no()%>">
	<input type="hidden" name="old_photo" value="<%=claVo.getImagelink() %>">
<table border="1" class="table table-bordered">
<tbody>
	<tr> 
		<td colspan="2" style="text-align:center;"><img src="<%=request.getContextPath() %>/imageSrcView.do?class_no=<%=claVo.getClass_no() %>" width="200" height="140"></td> 
 	</tr>
 	<tr>
 		<td>강좌 번호</td>
 		<td><%=claVo.getClass_no() %></td>
 	</tr>
 	<tr>
 		<td>강좌 명</td>
 		<td><input type = "text" name = "class_name" value="<%=claVo.getClass_name()%>"></td>
 	</tr>
 	<tr>
 		<td>강사 아이디</td>
 		<td><input type = "text" name = "teacher_id" value="<%=claVo.getTeacher_id()%>"></td>
 	</tr>
 	<tr>
 		<td>강좌 교재</td>
 		<td><input type = "text" name = "class_book" value="<%=claVo.getClass_book()%>"></td>
 	</tr>
 	<tr>
 		<td>수강료</td>
 		<td><input type = "text" name = "tuition" value="<%=claVo.getTuition()%>"></td>
 	</tr>
 	<tr>
		<td>이미지 사진</td>
		<td><input type="file" name="imagelink"></td>
	</tr>	
 	<tr>
		<td colspan="2" style="text-align:center;">
		<input type="submit" value="저장"> 
		<input type="reset" value="취소"> 
		<input type="button" id="btnList" value="강좌 목록"></td>
	</tr>
</tbody>
</table>
</form>
</div>
</body>
</html>