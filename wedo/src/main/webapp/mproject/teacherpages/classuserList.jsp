<%@page import="kr.or.ddit.wedo.vo.MemberVO"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
  	<title>Table 06</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="../cartnpaytable/css/style.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>

<%
	List<MemberVO> vo = (List<MemberVO>)session.getAttribute("memclassvo");
%>


	</head>
	<body>
	<section class="ftco-section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">

					<div class="table-wrap">
						<table class="table">
						  <thead class="thead-primary">
						    <tr>
						    	<td>
						    		<label class="all-wrap all-primary" >
										  
										  
										</label>
						    	</td>
						    	
						    	<th>수강생아이디</th>
						      <th>이름</th>
						      <th>&nbsp;</th>
						      
						      <th>이메일</th>
						      <th>&nbsp;</th>
						    </tr>
						  </thead>
						  <tbody>
						  
						  
 <% 
						  for(int i = 0 ; i < vo.size() ; i++) {						  
%>  
						  <!-- 시작 -->
						    <tr class="alert" role="alert">
						    	<td>
						    		
										  
										  
										</label>
						    	</td>
						    
						      <td>
						      	<div class="email">
						      		<span><%= vo.get(i).getMem_id()%></span>
						      		<span> </span>
						      	</div>
						      </td>
						      <td><%= vo.get(i).getMem_name()%></td>
						      <td class="quantity">

				          <td class="border-bottom-0"><%= vo.get(i).getMem_mail() %></td>
						      <td class="border-bottom-0">
		
				         
				        	</td>
						    </tr>
						    <%
						  }
						    %>
						    <!-- 끝 -->
						  </tbody>
						</table>
					</div>
				<div style="text-align:center">
					 
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
    