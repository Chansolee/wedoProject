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
<link rel="stylesheet" href="css/memberSignup.css">



<script>
   $(function(){
      

	   $('form').on('submit', function(){
         
         
         datas = $('form').serializeArray();   // 배열 데이터 형식
         
         
         console.log(datas);
         
         
         
         $.ajax({
            url : '/wedo/insertNotice.do',
            data : datas ,
            type : 'post',
            success : function(res){
            	if(res==1){
					alert("작성완료!");
            	location.href='../notice/notice.jsp';
            	}else{
					alert("오류입니다. 다시 입력해주세요");
				}
            },
            error : function(xhr){
               alert("상태 : " + xhr.status)
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

			<h1>공지사항 작성페이지</h1>
			<h4>빈칸을 입력해주세요.</h4>

	

			<div class="form-group">
				<label for="uname">제목</label> <input type="text"
					class="form-control" id="uname" placeholder="Enter title"
					name="notice_title" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<div class="form-group">
				<label for="upass">내용</label> 
<!-- 				<input type="text" -->
<!-- 					class="form-control" id="upass" placeholder="Enter content" -->
<!-- 					name="notice_content" required> -->
					 <textarea class="form-control" id="example-textarea" rows="4" name="notice_content"></textarea>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

		

			<button type="submit" class="btn btn-primary">완료</button>
			<button type="button" class="btn btn-primary" onclick="location.href='notice.jsp' ">돌아가기</button>
			<span id="joinsub"></span>
		</form>
	</div>




</body>
</html>












