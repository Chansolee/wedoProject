<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
	h1{
		text-align: center;
	}
</style>
</head>
<body>
	<%
	String lectureVideo = request.getParameter("lecture_video");
	%>
	<div class="container">
		<h1>강의 보기 페이지</h1>
		<form name="classForm" id="classForm" method="post">
			<table border="1" class="table table-bordered">
				<tbody>
					<tr>

						<td><iframe id="ifr" width="1000" height="500"
								src="<%=lectureVideo%>" title="YouTube video player" style="margin-left: 65px;"></iframe>
						</td>
						
					</tr>
					
				</tbody>
			</table>
			<div style="padding:0px 50%"><button type="button" class="btn btn-primary" onclick="history.back()">뒤로가기</button> </div>
		</form>
	</div>
</body>
</html>