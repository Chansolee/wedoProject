<%@page import="kr.or.ddit.wedo.vo.MemberVO"%>
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

	MemberVO vo = (MemberVO) request.getAttribute("getid");
	if (vo != null) {
	%>
	<div class="container">
		<form class="needs-validation">
			<h1>아이디 찾기 결과</h1>
			<div class="form-group">
				<label for="uid">아이디</label><br>
					<table>
					<tr>
						<td><%=vo.getMem_id()%></td>
					</tr>
				</table><br>
				<button type="button" class="btn btn-primary" onclick="location.href='mproject/login/index.jsp' ">로그인화면으로 돌아가기	</button>
			</div>
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
