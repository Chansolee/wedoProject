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
<link rel="stylesheet" href="css/found.css">



</head>
<body>


	<div class="container">
		<form action="/wedo/passSearchMember.do" method = "post" class="needs-validation">

			<h1>회원 비밀번호찾기</h1>
			<h4>정확한 정보를 기입해주시기 바랍니다.</h4>
			  <div class="social-icons">
                    <a href = "memberFoundPw.jsp" id= "user"><img src="img/사용자.png" alt="facebook"></a>
                    <a href = "teacherFoundPw.jsp" id= "teacher"><img src="img/강사.png" alt="twitter"></a>
                </div>
			<div class="form-group">
				<span id="idspan">아이디</span> <input type="text" class="form-control"
					id="id" placeholder="Enter ID account" name="id" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>


			<div class="form-group">
				<label for="tel">전화번호</label> <input type="text"
					class="form-control" id="tel" placeholder="Enter phoneNumber"
					name="tel" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<button type="submit" class="btn btn-primary">비밀번호 찾기</button>
			<button type="button" class="btn btn-primary" onclick="location.href='index.jsp' ">돌아가기</button>
		</form>
	</div>




</body>
</html>












