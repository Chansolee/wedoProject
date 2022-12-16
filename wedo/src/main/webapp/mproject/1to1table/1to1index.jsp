<%@page import="kr.or.ddit.wedo.vo.OneToOneAnsVO"%>
<%@page import="kr.or.ddit.wedo.vo.OneToOneQnaVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
  	<title>Table 08</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		
	<link rel="stylesheet" href="css/style.css">

	<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
<script >

	$(function(){

		//버튼, 글제목에 대한 이벤트
		$(document).on('click','.action', function(){
			bname = $(this).attr('name') //버튼이름
			num = $(this).attr('idx') //인덱스번호
			
			//게시물등록(문의게시물등록)
			
			
			//댓글삭제
			if(bname == "delete"){
// 				alert(num + "번 댓글 삭제");
				
				$.ajax({
					url : '/wedo/replyDelete.do',
					type : 'post',
					data :  {   
							  "one_ans_no" : num
							}  ,
					success : function(res){
						alert("댓글삭제성공");
						location.href="/wedo/select1to1Mem.do";
						
					}, 
					error : function(xhr){
						
					},
					dataType : 'json'
				})
			
				//댓글수정
			}else if(bname == "modify"){
// 				alert(num + "번 댓글 수정");
				
				location.href="/wedo/selectAnsNo.do?one_ans_no="+num;
				
				//댓글등록
			}else if(bname == "reply"){
// 				alert(num + "번 댓글등록");
			
				
				nameval = '<%= session.getAttribute("idvalue") %>';
				console.log("댓글입력아이디 : " + nameval);
				
				//입력한 댓글내용 가져오기 //엔터값 br로 바꾸기
				cont = $(this).prev().val().replace(/(?:\r\n|\r|\n)/g, '<br/>');; 
// 				console.log( "댓글내용 : "+ cont);
				
// 				console.log("댓글달 번호 : " + num);
				
				
				//textarea에 있던 댓글내용 클리어
				content = $(this).prev().val("");
				
				$.ajax({
					url : '/wedo/insertReply.do',
					type : 'post',
					data :  {   
							  "one_qna_no" : num ,
							  "one_ans_id" : nameval,
							  "one_ans_content" : cont
							}  ,
					success : function(res){
						
						alert("댓글 등록 성공");
						location.href="/wedo/select1to1Mem.do";
						
					}, 
					error : function(xhr){
						
					},
					dataType : 'json'
				})
			//1:1문의 등록
			}else if(bname == "insertQna"){
// 				alert("게시물등록");
				
				location.href="/wedo/teacherSelectAll.do";
				
				
				//1:1문의 삭제
			}else if(bname == "qnaDelete"){
				num = $(this).attr('idx') //인덱스번호
				alert("삭제성공");
				
				location.href="/wedo/qnaDelete.do?one_qna_no="+num;
				
				
				
				//1:1문의 수정
			}else if(bname == "qnaModify"){
				num = $(this).attr('idx') //인덱스번호
// 				alert("1:1 게시물수정 - 인덱스번호 : " + num);
				
				location.href="/wedo/selectQnaNo.do?one_qna_no="+num;
			}
			
			
		})
		
		 
		
	}) 
 
</script> 
</head>
<body>
<%
	List<OneToOneQnaVO> otoqVo = (List<OneToOneQnaVO>)session.getAttribute("otoqVo");

	List<OneToOneAnsVO> otoaVo = (List<OneToOneAnsVO>)session.getAttribute("otoaVo");
	
%>
	
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-4">
					<h2 class="heading-section">강사에게 1:1 문의하기</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h3 class="h5 mb-4 text-center">문의 내역</h3>
					<div class="table-wrap">
						<table class="table myaccordion table-hover" id="accordion">
						  <thead>
						    <tr>
						      <th>순번</th>
						      <th>게시물 제목</th>
						   <!--    <th>&nbsp;</th> -->
						      <th>작성자 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;To쌤</th>
						      <th>작성일</th>
						      <th>&nbsp;</th>
						    </tr>
						  </thead>
						  <tbody>
						  
<%
						  	for(int i = 0 ; i < otoqVo.size(); i++){
%>
				<!-- 작성글 시작 -->		  
						    
						    <tr data-toggle="collapse" data-target="#collapse<%= i %>" aria-expanded="false" 
						  			aria-controls="collapse<%= i %>" class="collapsed" >
						      <th scope="row"><%= i+1 %></th>
						      <td> <%= otoqVo.get(i).getOne_qna_title() %>  </td>
				<!-- 		      <td>&nbsp;</td> -->
					<!-- 	      <td><%= otoqVo.get(i).getMem_id() %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <%=otoqVo.get(i).getTeacher_id() %></td>  -->
						      <td><%= otoqVo.get(i).getMem_name() %> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <%=otoqVo.get(i).getTeacher_name() %></td>
						      <td><%= otoqVo.get(i).getOne_qna_date() %></td>
						      <td>
						      	<i class="fa" aria-hidden="false"></i>
				        	</td>
						    </tr>
						    <tr>
						    <!-- <td colspan="6" id="collapseOne" class="collapse show acc" data-parent="#accordion">  -->
						    	<td colspan="6" id="collapse<%= i %>" class="collapse acc" data-parent="#accordion">
						    	<button idx="<%=otoqVo.get(i).getOne_qna_no() %>" class="btn btn-primary action" style="margin-left: 800px; margin-bottom: -27px; padding: 4px 10px;" name="qnaModify">게시글 수정</button>
									&nbsp;
									<button idx="<%=otoqVo.get(i).getOne_qna_no() %>"  class="btn btn-info action"  style="margin-bottom: -27px; padding: 4px 10px;" name="qnaDelete">게시글 삭제</button>
						    		<p><%= otoqVo.get(i).getOne_qna_content() %></p>
									
						    </tr>
						  				<!-- 작성글 끝 -->  
						  				
						  				<!-- 댓글목록 -->
						  	 <tr>
						    	<td colspan="6" id="collapse<%= i %>" class="collapse acc" data-parent="#accordion">
						    	
							<%
						  		for(int j = 0 ; j < otoaVo.size(); j++){
						  			if(otoqVo.get(i).getOne_qna_no()==otoaVo.get(j).getOne_qna_no()){
							%> 
								<div style=" margin-bottom: 35px; margin-top: 20px; ">
									<div style=" margin-right: 21%;">
<%
										if(otoqVo.get(i).getMem_id().equals(otoaVo.get(j).getOne_ans_id())){
									%>
										<p style="background: lightgray; margin-top: 5px;"> 댓글 작성자 :  <%= otoqVo.get(i).getMem_name() %> </p>									
									<%
										}else if(otoqVo.get(i).getTeacher_id().equals(otoaVo.get(j).getOne_ans_id())){
									%>
										<p style="background: lightgray; margin-top: 5px;"> 댓글 작성자 :  <%= otoqVo.get(i).getTeacher_name() %> </p>
									
									<%
						    			}
									 %>
						    			<p style="background: lightgray;"> 작성일자 : <%= otoaVo.get(j).getOne_ans_date() %> </p>
						    			<p style="border: 2px solid lightgray; background: lightgray;"> <%= otoaVo.get(j).getOne_ans_content() %></p>
						    		</div>
						    		<% 
						    			if(otoaVo.get(j).getOne_ans_id().equals(session.getAttribute("idvalue")) ){
						    		%>
						    		<div style="margin-left: 20%; margin-top: -5%;">
						    			<button idx="<%= otoaVo.get(j).getOne_ans_no() %>" class="btn btn-primary action" style="margin-left: 75%; margin-bottom: 10px; padding: 4px 10px;" name="modify">댓글 수정</button>
											&nbsp;
										<button idx="<%= otoaVo.get(j).getOne_ans_no() %>" class="btn btn-info action"  style="margin-bottom: 10px; padding: 4px 10px;" name="delete">댓글 삭제</button>
									</div>
									<%
						    			}
									%>
								</div>
<%									
						  			}
						  		}
%>							 
								
									<p class="p4">
             							<textarea rows="3" cols="135" style="width:79%"></textarea>
           								<input idx="<%=otoqVo.get(i).getOne_qna_no() %>" type="button" value="등록" name="reply" class="action">
           							</p> 
						    	</td> 
						    </tr>
						    <!-- 댓글끝 -->		
<%								 
						 	}
%>
						  </tbody>
						</table>
					</div>
				</div>
			</div>
		<input type="button" value="게시글 등록" name="insertQna" class="action" style="margin-left: 1000px;">
		</div>
	</section>

	<script src="js/jquery.min.js"></script>
  <script src="js/popper.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/main.js"></script>

	</body>
</html>

