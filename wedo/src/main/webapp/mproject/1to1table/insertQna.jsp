<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.wedo.vo.TeacherVO"%>
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
         
		  title = document.getElementById("qna_title").value;
		  content = document.getElementById("qna_content").value;;
		  teacherid= document.getElementById("teacher_id").options[teacher_id.selectedIndex].value;  
        
		  content = content.replace(/(?:\r\n|\r|\n)/g, '<br/>');
         $.ajax({
            url : '/wedo/insertQna.do',
            data : {
            		"title" : title ,
            		"content" : content,
            		"teacherid" : teacherid
            		} ,
            type : 'post',
            success : function(res){
					alert(" qna 게시글 작성완료!");
            	location.href='/wedo/select1to1Mem.do';
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
<%
		List<TeacherVO> teaVo = (List<TeacherVO>)request.getAttribute("teacherVo");
%>

	<div class="container">
		<form class="needs-validation" novalidate onsubmit="return false;">

			<h1>강사님께 1:1 문의하기</h1>
			<h4>빈칸을 입력해주세요.</h4>
			<label for="uname">제목</label> 
			<div class="form-group">
				<input type="text"
					class="form-control" id="qna_title" placeholder="Enter title"
					name="title1" required style="width: 70%; float: left; margin-right: 30px;">
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
				
				<div>
				<label for="teacher_name">To.</label>
					<select id="teacher_id">
					<%
						for(int i = 0 ; i < teaVo.size(); i++){
					%>
						<option value="<%= teaVo.get(i).getTeacher_id() %>"><%= teaVo.get(i).getTeacher_name() %></option>
					<%
						}
					%>
					</select>
					<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			</div>
			
			<div class="form-group">
				<label for="upass">내용</label> 
<!-- 				<input type="text" -->
<!-- 					class="form-control" id="upass" placeholder="Enter content" -->
<!-- 					name="notice_content" required> -->
					 <textarea class="form-control" id="qna_content" rows="4" name="content1"></textarea>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

		

			<button type="submit" class="btn btn-primary">완료</button>
			<button type="button" class="btn btn-primary" onclick="location.href='/wedo/select1to1Mem.do' ">돌아가기</button>
			<span id="joinsub"></span>
		</form>
	</div>




</body>
</html>





