<%@page import="kr.or.ddit.wedo.vo.CartClassVO"%>
<%@page import="kr.or.ddit.wedo.vo.ClassVO"%>
<%@page import="kr.or.ddit.wedo.vo.CartVO"%>
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
	List<CartClassVO> ccVo = (List<CartClassVO>)session.getAttribute("cartclassVo");
%>

<script> 

	$(function(){
		$('.all').on('change', function(){
			a = $(this).prop('checked');
			
			//class="check"의 checked 속성값을 a값으로 설정
			$('.checkmark').prop('checked', a);
		})
		
		$('#payment').on('click', function(){
			

			cartNums = document.getElementsByClassName("classNo");
			arr = []; //결제시도할 장바구니 번호를 넣은 배열
			sum =0; //결제시도할 수강목록의 수강료 합계
			
			$('.checkmark:checked').each(function(i,v){
				sum += Number($(this).val());
				
				arr.push($(cartNums[i]).val());
			})
			
// 			alert("장바구니의 번호 : " + arr); 
// 			alert("구매요청한 강의수 : " + arr.length);
			
			sessionStorage.setItem("cartNo",arr);  //장바구니번호를 배열로 만들어 보낸다. (여러개 구매가능)
			
			alert("결제금액 : " + sum);
			sessionStorage.setItem("payment",sum); //장바구니에 담긴 여러개의 수강료를 더해서 보낸다.
			
			//테스트용, 결제를 거치지 않고 바로 장바구니목록에서 데이터없애주고, 결제테이블에 데이터 삽입
			//location.href = "/wedo/withDrawalCart.do?cartArr="+arr;

			
			location.href="kakao.jsp";
		})
		
		
		$('#choice').on('click', function(){ //장바구니선택목록삭제
			
			
			cartNums = document.getElementsByClassName("classNo");
			arr = []; //결제시도할 장바구니 번호를 넣은 배열
		
		
			$('.checkmark:checked').each(function(i,v){
			
				
				arr.push($(cartNums[i]).val());
				
			})
			
		
			


			  $.ajax({
           	 url : '/wedo/deleteCartChoice.do',
             data : {"Arr" : arr},
             traditional : true,
             type : 'post',
           	 success : function(res){
  
               alert("삭제 완료!");
               if(res!=null){
            	   location.href='/wedo/memCart2.do';
// 				history.go(0);
               }
            },
            error : function(xhr){
               alert("상태 : " + xhr.status)
            },
            dataType : 'json'
            
         })

			
		})
		
		
		
		
		   $('#delete').on('click', function(){ //장바구니전체삭제 
        
			
     
         
         $.ajax({
            url : '/wedo/deleteCart.do',
           
            type : 'post',
            success : function(res){

               alert("삭제 완료!");
               location.href='/wedo/memCart2.do';
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
										  <input type="checkbox" class="all">
										  <span class="all"></span>
										</label>
						    	</td>
						    	<th>강좌명</th>
						      <th>수강료</th>
						      <th>&nbsp;</th>
						      
						      <th>&nbsp;</th>
						      <th>&nbsp;</th>
						    </tr>
						  </thead>
						  <tbody>
 <% 
						  for(int i = 0 ; i < ccVo.size() ; i++) {						  
 %>
						    <tr class="alert" role="alert">
						    	<td>
						    		<label class="checkbox-wrap checkbox-primary">
										  <input type="checkbox" class="checkmark" value="<%= ccVo.get(i).getTuition() %>">
										  <span class="checkmark"></span>
										  
										</label>
						    	</td>
						      	<td>
						      		<div class="email">
						      			<span><%= ccVo.get(i).getClass_name() %></span>
						      			<input class="classNo" type="hidden"  value ="<%= ccVo.get(i).getCart_no() %>">
						      		</div>
						      	</td>
						      	<td class="tuition"><%= ccVo.get(i).getTuition() %> 
						      	</td>
						      	<td class="quantity">
				          		</td>
				          <td>&nbsp;</td>
						      <td>
						      	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				            	<span aria-hidden="true"></span>
				          	</button>
				        	</td>
						    </tr>
<%
						}
%>
						  </tbody>
						</table>
					</div>
				<div style="text-align:center">
					 <button type="button" class="btn btn-outline-success" style="display: inline-block" id="payment">구매신청</button>
					 <button type="button" class="btn btn-outline-success" style="display: inline-block" id="delete">전체 삭제</button>
					 <button type="button" class="btn btn-outline-success" style="display: inline-block" id="choice">선택 삭제</button>
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