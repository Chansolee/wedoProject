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
<script type="text/javascript" src="<%=request.getContextPath()%>/mproject/1to1table/js/jquery.min.js"></script>
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
	<div class="container">
	<h2>강좌 정보 입력 폼</h2>
	<form id="classForm" method="post" enctype="multipart/form-data" action="<%=request.getContextPath() %>/insertClass.do">
		<table border="1" class="table table-bordered">
			<tbody>
				<tr>
					<td>강좌 번호</td>
					<td><input type="text" name="class_no" id="class_no">
					</td>
				</tr>

				<tr>
					<td>강좌 명</td>
					<td><input type="text" name="class_name" id="class_name">
					</td>
				</tr>

				<tr>
					<td>수강료</td>
					<td><input type="text" name="tuition" id="tuition"></td>
				</tr>

				<tr>
					<td>강좌 교재</td>
					<td><input type="text" name="class_book" id="class_book">
					</td>
				</tr>

				<tr>
					<td>강사 아이디</td>
					<td><input type="text" name="teacher_id" id="teacher_id">
					</td>
				</tr>

				<tr>
					<td>관리자 아이디</td>
					<td><input type="text" name="manager_id" id="manager_id">
					</td>
				</tr>

				<tr>
					<td>이미지 사진</td>
					<td><input type="file" name="imagelink" id="imagelink">
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
					<input type="submit" value="저장"> 
					<input type="reset" value="취소">
					<input type="button" id="btnList" value="강좌목록">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	</div>
</body>
</html>