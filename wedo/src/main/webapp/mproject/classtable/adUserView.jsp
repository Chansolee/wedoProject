<%@page import="kr.or.ddit.wedo.vo.MemberVO"%>
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
			var form = document.getElementById("memberForm");
			form.action = "<%=request.getContextPath()%>/updateUserForm.do";
			form.submit();
		}
		
		btnList.onclick = function(){
			location.href = "<%=request.getContextPath()%>/memberList.do";
		}
	};
</script>
</head>
<body>
<%
	MemberVO memberVo = (MemberVO)request.getAttribute("memberVo");
%>
<div class="container">
<h2>회원 정보 상세보기</h2>
<form name = "memberForm" id="memberForm" method="post">
 	<input type="hidden" id= "mem_id" name="mem_id" value="<%=memberVo.getMem_id() %>"> 
<table border = "1" class="table table-bordered">
<tbody>
	
	<tr>
		<td>ID</td><td><%=memberVo.getMem_id() %></td>
	</tr>
	
	<tr>
		<td>이름</td><td><%=memberVo.getMem_name() %></td>
	</tr>
	
	<tr>
		<td>비밀번호</td><td><%=memberVo.getMem_pass() %></td>
	</tr>
	
	<tr>
		<td>주민등록번호 앞자리</td><td><%=memberVo.getMem_regno1() %></td>
	</tr>
	
	<tr>
		<td>주민등록번호 뒷자리</td><td><%=memberVo.getMem_regno2()%></td>
	</tr>
	
	<tr>
		<td>전화번호</td><td><%=memberVo.getMem_tel() %></td>
	</tr>
	
	<tr>
		<td>이메일주소</td><td><%=memberVo.getMem_mail() %></td>
	</tr>
	
	<tr>
		<td>주소</td><td><%=memberVo.getMem_addr1() %></td>
	</tr>
	
	<tr>
		<td>상세주소</td><td><%=memberVo.getMem_addr2() %></td>
	</tr>
	<tr>
		<td colspan="2" style="text-align:center;">
			<input id="btnUpdate" type="button" value="수정"> 
			<input type="button" id="btnList" value="회원목록"></td>
	</tr>
</tbody>
</table>
</form>
</div>
</body>
</html>