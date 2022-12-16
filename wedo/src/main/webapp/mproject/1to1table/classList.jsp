<%@page import="kr.or.ddit.wedo.vo.ClassVO"%>
<%@page import="java.util.List"%>
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
</head>
<body>
	<%
		
		List<ClassVO> classVo = (List<ClassVO>)session.getAttribute("classVo");
	%>
	<div class="container">
	<h2>강좌 목록 보기</h2>	
	<table border="1" class="table table-bordered">
	<thead>
		<tr>
			<td colspan="5" style="text-align:right;"><button type="button" class="btn btn-primary" onclick="location.href='insertClass.jsp' ">강좌 추가</button></td>
		</tr>
		<tr>
			<th>강좌번호</th>
			<th>강좌 명</th>
			<th>강사 명</th>
			<th>수강 료</th>
			<th>강좌 교재</th>
<!-- 			<th>이미지 파일</th> -->
		</tr>
	</thead>
	<tbody>
	<%
		for(int i = 0; i< classVo.size(); i++){
	%>
		<tr>
			<td><a href="<%=request.getContextPath() %>/classView.do?class_no=<%=classVo.get(i).getClass_no()%>"><%=classVo.get(i).getClass_no() %></a></td>
			<td><%=classVo.get(i).getClass_name() %></td>
			<td><%=classVo.get(i).getTeacher_id() %></td>
			<td><%=classVo.get(i).getTuition() %></td>
			<td><%=classVo.get(i).getClass_book() %></td>
<%-- 			<td colspan="2" style="text-align:center;"><img src="<%=request.getContextPath() %>/imageSrcView.do?class_no=<%=classvo.getClass_no() %>" width="200" height="140"></td> --%>
		</tr>
		
	<%
		}
	%>
	</tbody>
	
	</table>
	</div>
</body>
</html>