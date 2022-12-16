<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="http://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>



<script>
	(function() {
	    var IMP = window.IMP;
	    var code = "imp27335867";  // FIXME: 가맹점 식별코드(형준)
	//    var code = "imp45186482";  // FIXME: 가맹점 식별코드(유영)
	    IMP.init(code);
	    var rnd = parseInt(Math.random()*1000000 )+1;
	    // 결제요청
	    IMP.request_pay({
	        // name과 amount만 있어도 결제 진행가능 
	        //pg : 'html5_inicis', // pg 사 선택
	        
	        pg : 'kakaopay',
	        pay_method : 'card', //생략 가능 
	        merchant_uid: "WEDO_"+ rnd, // 상점에서 관리하는 주문 번호
	        name : '주문명 : WEDO 강의구매',  // 결제내역에서 확인함
	        amount : sessionStorage.getItem('payment'),   //가격
	        buyer_email : 'iamport@siot.do', 
	        buyer_name : '<%= session.getAttribute("namevalue") %>',
	        buyer_tel : '010-1234-5678',
	        buyer_addr : '대전시 중구 오류동',
	        buyer_postcode : '123-456'
	    }, function(rsp) {  
	        if ( rsp.success ) { 
	        	//결제성공
	        	
	        	cartArr = sessionStorage.getItem('cartNo');
	        	
	            var msg = '결제가 완료되었습니다.';
	            msg += '사용자정보 : ' + rsp.buyer_name + '\n';
	            msg += '고유ID : ' + rsp.imp_uid;
	            msg += '상점 거래ID : ' + rsp.merchant_uid;
	            msg += '결제 금액 : ' + rsp.paid_amount;
	            msg += '카드 승인번호 : ' + rsp.apply_num;
	            
	            location.href= "/wedo/withDrawalCart.do?cartArr="+cartArr;
	            
	            
	        }
	        else {
	        	//결제실패
	            var msg = '결제에 실패하였습니다. \n 에러내용 : ' + rsp.error_msg;
	        }
	        document.getElementById('content').innerText = msg;
	    });
	})();
</script>
</head>
<body>
   <button onclick="requestPay()">결제하기</button>
   <div id="content"></div>
 
 </body>

</html>
    