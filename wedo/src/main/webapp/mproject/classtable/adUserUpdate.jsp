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

	var btnList = document.getElementById("btnList");

	btnList.onclick = function(){
		location.href = "<%=request.getContextPath()%>/memberList.do";
	}
};

</script>
</head>
<body>
<%
	MemberVO memVo = (MemberVO)request.getAttribute("memberVo");
%>

<div class="container">
	<h2>회원 정보 수정 폼</h2>
		<form  action="<%=request.getContextPath()%>/updateUser.do" method="post" >
			<input type="hidden" id= "mem_id" name="mem_id" value="<%=memVo.getMem_id() %>">
		<table border="1" class="table table-bordered">
			<tbody>
				<tr>
					<td>ID</td>
					<td><%=memVo.getMem_id() %></td>
				</tr>
				
				<tr>
					<td>이름</td>
					<td><%=memVo.getMem_name() %></td>
				</tr>
				
				<tr>
					<td>비밀번호</td>
					<td><input type = "text" name = "mem_pass" value="<%=memVo.getMem_pass()%>" placeholder="변경할 비밀번호를 입력하시오."></td>
				</tr>
				
				<tr>
					<td>전화번호</td>
					<td><input type = "text" name = "mem_tel" value="<%=memVo.getMem_tel()%>" placeholder="변경할 전화번호를 입력하시오."></td>
				</tr>
				
				<tr>
					<td>이메일주소</td>
					<td><input type = "text" name = "mem_mail" value="<%=memVo.getMem_mail()%>" placeholder="변경할 이메일주소를 입력하시오."></td>
				</tr>
				
				<tr>
					<td>주소</td>
					<td><input type = "text" name = "mem_addr1" value="<%=memVo.getMem_addr1()%>" placeholder="변경할 주소를 입력하시오."></td>
				</tr>
				
				<tr>
					<td>상세주소</td>
					<td><input type = "text" name = "mem_addr2" value="<%=memVo.getMem_addr2()%>" placeholder="변경할 상세주소를 입력하시오."></td>
				</tr>
				
				<tr>
					<td colspan="2" style="text-align:center;">
					<input type="submit" value="저장"> 
					<input type="reset" value="취소"> 
					<input type="button" id="btnList" value="회원 목록"></td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>
