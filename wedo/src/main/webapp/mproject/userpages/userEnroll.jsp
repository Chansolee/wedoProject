<%@page import="kr.or.ddit.wedo.vo.EnrollClassVO"%>
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
	List<EnrollClassVO> ecVo = (List<EnrollClassVO>)session.getAttribute("ecVo");
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
					
						    	
						    	<th>수강신청일자</th>
						      <th>수강명</th>
						      <th>&nbsp;</th>
						      
						      <th>남은기간</th>
						      <th>&nbsp;</th>
						    </tr>
						  </thead>
						  <tbody>
						  
						  
 <% 
						  for(int i = 0 ; i < ecVo.size() ; i++) {						  
%>  
						  <!-- 시작 -->
						    <tr class="alert" role="alert">
						    	<!-- <td>
						    		<label class="checkbox-wrap checkbox-primary">
										  <input type="checkbox" class="checkmark" >
										  <span class="checkmark"></span>
										</label>
						    	</td> -->
						    
						      <td>
						      	<div class="email">
						      		<span><%= ecVo.get(i).getEnr_period()%></span>
						      		<span> </span>
						      	</div>
						      </td>
						      <td><%= ecVo.get(i).getClass_name()%></td>
						      <td class="quantity">

				          <td class="border-bottom-0"><%= ecVo.get(i).getDday() %></td>
						      <td class="border-bottom-0">
						      	<!-- <button type="button" class="close" data-dismiss="alert" aria-label="Close" >  -->
						      	<a href="/wedo/enrollInfo.do?classNo=<%=ecVo.get(i).getClass_no() %>">강의보기</a>
				            	
				          	</button>
				        	</td>
						    </tr>
						    <%
						  }
						    %>
						    <!-- 끝 -->
						  </tbody>
						</table>
						
					</div>
				<!-- <div style="text-align:center">
					  <button type="button" class="btn btn-outline-success" style="display: inline-block">환불 신청</button>
				</div> -->
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
    