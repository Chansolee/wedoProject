<%@page import="kr.or.ddit.wedo.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
  	<title>Table 02</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	
	<link rel="stylesheet" href="css/style.css">

	</head>
	<body>
	<%
		List<MemberVO> memVo = (List<MemberVO>)request.getAttribute("memberVo");
	%>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">회원 목록</h2>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-12">
				
				
				
					<div class="table-wrap">
						<table class="table">
						  <thead class="thead-dark">
						    <tr>
						      <th>ID</th>
						      <th>이름</th>
<!-- 						      <th>Last Name</th> -->
						      <th>Email</th>
 						      <th>&nbsp;</th> 
						    </tr>
						  </thead>
						  <tbody>
						  <%
						  	for(int i = 0; i< memVo.size(); i++){
						  %>
						  <tr>
						  	  <td><a href="<%=request.getContextPath() %>/memberView.do?mem_id=<%=memVo.get(i).getMem_id()%>"><%=memVo.get(i).getMem_id()%></a></td>
						      <td><%=memVo.get(i).getMem_name() %></td>
						      <!-- <td>Otto</td> -->
						      <td><%=memVo.get(i).getMem_mail() %></td>
				        	
				        </tr>
						    <%
						    }
						    %>
						      
						  </tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="js/jquery.min.js"></script>
  <script src="js/popper.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/main.js"></script>

	</body>
</html>

