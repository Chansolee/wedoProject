<%@page import="kr.or.ddit.wedo.vo.PaymentClassVO"%>
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
	
	<link rel="stylesheet" href="css/style.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>

<%
	List<PaymentClassVO> pcVo = (List<PaymentClassVO>)session.getAttribute("paymentclassVo");
%>

<script> 
	$(function(){
		$('.all').on('change', function(){
			a = $(this).prop('checked');
			
			//class="check"의 checked 속성값을 a값으로 설정
			$('.checkmark').prop('checked', a);
		})
	
	})

</script>
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
						    	<!-- <td>
						    		<label class="all-wrap all-primary" >
										  <input type="checkbox" class="all">
										  <span class="all"></span>
										</label>
						    	</td> -->
						    	
						    	<th>강좌명</th>
						      <th>수강료</th>
						      <th>&nbsp;</th>
						      
						      <th>결제일자</th>
						      <th>&nbsp;</th>
						    </tr>
						  </thead>
						  <tbody>
						  
						  
 <% 
						  for(int i = 0 ; i < pcVo.size() ; i++) {						  
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
						      		<span><%= pcVo.get(i).getClass_name()%></span>
						      		<span> </span>
						      	</div>
						      </td>
						      <td><%= pcVo.get(i).getTuition()%></td>
						      <td class="quantity">

				          <td class="border-bottom-0"><%= pcVo.get(i).getPay_date() %></td>
						      <td class="border-bottom-0">
						      	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				            	<span>&nbsp;</span>
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

