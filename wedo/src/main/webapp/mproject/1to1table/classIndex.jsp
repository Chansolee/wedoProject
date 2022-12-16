<%@page import="kr.or.ddit.wedo.vo.TeacherVO"%>
<%@page import="kr.or.ddit.wedo.vo.ClassVO"%>
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
	
	<link rel="stylesheet" href="mproject/1to1table/css/style.css">

	</head>
	<body>
	<%
		List<ClassVO> classList = (List<ClassVO>)request.getAttribute("classList");
	%>
	
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-4">
					<h2 class="heading-section">강좌 관리</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h3 class="h5 mb-4 text-center">강좌 목록</h3>
					<div class="table-wrap">
						<table class="table myaccordion table-hover" id="accordion">
						  <thead>
						    <tr>
						      <th>순번</th>
						      <th>강좌 제목</th>
						   <!--    <th>&nbsp;</th> -->
						      <th>작성자</th>
						      <th>작성일</th>
						      <th>&nbsp;</th>
						    </tr>
						  </thead>
						  <tbody>
						  
						    <tr data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne" ><!-- class="collapsed" -->
						      <th scope="row">1강</th>
						      <td>안톤의 오리엔테이션</td>
				<!-- 		      <td>&nbsp;</td> -->
						      <td>이찬솔</td>
						      <td>2022.08.10</td>
						      <td>
						      	<i class="fa" aria-hidden="true"></i>
				        	</td>
						    </tr>
						    <tr>
						    	<td colspan="6" id="collapseOne" class="collapse show acc" data-parent="#accordion">
						    		<p>강좌 설명</p>
<!-- 						    		<iframe style="width:70%; height:450px; margin-left: 15%;" src="https://www.youtube.com/embed/b1F2AVsJ05c" title="YouTube video player" onclick="playShow()"></iframe> -->
									<button class="btn btn-primary" style="margin-left: 875px; margin-bottom: -27px; padding: 4px 10px;">수정</button>
									&nbsp;
									<button class="btn btn-info"  style="margin-bottom: -27px; padding: 4px 10px;">삭제</button>
								</td>
						    </tr>
 						      <% 
						    	  for(ClassVO classvo : classList){ 
						      %> 
						    <tr data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo" class="collapsed">
						      <th scope="row">2강</th>
 						      <td><%=classvo.getTeacher_id()%></td> 
						      <td><%=classvo.getTeacher_id() %></td> 
  						      <td><%=classvo.getTuition() %></td> 
<%-- 						      <td colspan="2" style="text-align:center;"><img src="<%=request.getContextPath() %>/imageSrcView.do?class_no=<%=classvo.getClass_no() %>" width="200" height="140"></td> --%>
						      <td>
						      	<i class="fa" aria-hidden="false"></i>
				        	</td>
						    </tr>
						    <tr>
						    	<td colspan="6" id="collapseTwo" class="collapse acc" data-parent="#accordion">
						    		<p>강좌 설명</p>
									<button id="btnUpdate" class="btn btn-primary" style="margin-left: 875px; margin-bottom: -27px; padding: 4px 10px;">수정</button>
									&nbsp;
									<button id="btnDelete" class="btn btn-info"  style="margin-bottom: -27px; padding: 4px 10px;">삭제</button>
								</td>
						    </tr>
						    
  						    <%  
  						      } 
  						    %>  
						   
						  </tbody>
						</table>
					</div>
				</div>
			</div>
		<input type="button" onclick="location.href= 'mproject/1to1table/insertClass.jsp' " value="강좌 등록" name="reply1" class="action" style="margin-left: 1000px;">
		</div>
	</section>

	</body>
</html>

