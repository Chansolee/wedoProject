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
<link rel="stylesheet" href="css/teacherSignup.css">



<script>
	$(function() {

		//데이터 유효성체크 (타이핑을 할때마다)
		$('#uid').on('keyup', function() {
			idvalue = $('#uid').val();

			//정규식
			idreg = /^[T][a-zA-Z0-9]{3,10}$/

			//test() 맞으면 true, 다르면 false 리턴
			if (idreg.test(idvalue)) {
				$(this).css('border', '2px solid blue');
			} else {
				$(this).css('border', '2px solid red');
			}
		})

		$('#uname').on('keyup', function() {
			namevalue = $(this).val().trim();
			namereg = /^[가-힣]{2,10}$/

			if (namereg.test(namevalue)) {
				$(this).css('border', '2px solid blue');
			} else {
				$(this).css('border', '2px solid red');
			}
		})

		$('#upass2').on('keyup', function() {
			pass2value = $(this).val().trim();
			passvalue = $('#upass').val();

			if (pass2value == passvalue) {
				$(this).css('border', '2px solid blue');
			} else {
				$(this).css('border', '2px solid red');
			}
		})

		//전송 - submit  회원가입 버튼
		$('form').on('submit', function() {

			passval = $('#upass').val();
			pass2val = $('#upass2').val();
			idval = $('#uid').val();
			
			if(idval.substr(0,1)!=("T")){
				alert("아이디의 첫글자는 T이어야합니다.");
				return false;
			}
			if (passval.length < 8) {
				alert("비밀번호는 8자리 이상입니다.");
				return false;
			}
			if (passval != pass2val) {
				alert("비밀번호 확인이 다릅니다.");
				return false;
			}

			datas = $('form').serializeArray(); // 배열 데이터 형식

			console.log(datas);

			$.ajax({
				url : '/wedo/joinTeacher.do',
				data : datas,
				type : 'post',
				success : function(res) {
					if(res==1){
					alert("회원가입을 축하합니다!");
					location.href = 'teacherLogin.jsp';
					}else{
						alert("회원가입 오류 올바른 정보를 다시 입력해주세요");
					}
				},
				error : function(xhr) {
					alert("상태 : " + xhr.status)
				},
				dataType : 'json'

			})

		})

		//아이디 중복체크
		$('#checkid').on('click', function() {

			idvalue = $('#uid').val().trim();

			if(idvalue.substr(0,1)!=("T")){
				alert("아이디의 첫글자는 T이어야합니다.");
				return false;
			}
			if (idvalue.length < 1) {
				alert("id를 입력하세요.");
				return false;
			}

			console.log(idvalue);

			$.ajax({
				url : '/wedo/idCheckTeacher.do',
				type : 'get',
				data : {
					"id" : idvalue
				},
				success : function(resData) {

					let span;

					if (resData == null) {
						span = "사용가능한 아이디 입니다!"
						$('#idspan').text(span).css('color', 'blue');
					} else {
						span = "중복된 아이디 입니다!"
						$('#idspan').text(span).css('color', 'red');
					}

				},
				error : function(xhr) {
					alert("상태 : " + xhr.status);
				},
				dataType : 'json'
			})
		})

	})
</script>
</head>
<body>


	<div class="container">
		<form class="needs-validation" novalidate onsubmit="return false;">

			<h1>회원가입</h1>
			<h4>정확한 정보를 기입해주시기 바랍니다.</h4>

			<div class="form-group">
				<label for="uid">아이디</label> <input type="button" id="checkid"
					value="중복검사" class="btn btn-outline-primary btn-sm">
				<!-- <span class="spinner-border spinner-border-sm"></span> -->
				<span id="idspan"></span> <input type="text" class="form-control"
					id="uid" placeholder="Enter ID(강사 아이디는 대문자T로 시작하셔야 합니다.)" name="teacher_id" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<div class="form-group">
				<label for="uname">이름</label> <input type="text"
					class="form-control" id="uname" placeholder="Enter username"
					name="teacher_name" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<div class="form-group">
				<label for="upass">비밀번호</label> <input type="password"
					class="form-control" id="upass" placeholder="Enter password"
					name="teacher_pass" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<div class="form-group">
				<label for="upass2">비밀번호확인</label> <input type="password"
					class="form-control" id="upass2" placeholder="Enter password"
					required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<div class="form-group">
				<label for="umail">이메일</label> <input type="email"
					class="form-control" id="umail" placeholder="Enter E-mail"
					name="teacher_mail" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<div class="form-group">
				<label for="tel">전화번호</label> <input type="text"
					class="form-control" id="utel" placeholder="Enter phoneNumber"
					name="teacher_tel" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<button type="submit" class="btn btn-primary">회원가입</button>
			<button type="button" class="btn btn-primary" onclick="location.href='teacherLogin.jsp' ">돌아가기</button>
			<span id="joinsub"></span>
		</form>
	</div>




</body>
</html>












