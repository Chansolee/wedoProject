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
      
      //데이터 유효성체크 (타이핑을 할때마다)
      $('#uid').on('keyup', function(){
    	  
         idvalue = $('#uid').val();
         
         //정규식
         idreg = /^[a-z][a-zA-Z0-9]{3,10}$/
         
         //test() 맞으면 true, 다르면 false 리턴
         if( idreg.test(idvalue)){
            $(this).css('border', '2px solid blue');
         }else{
            $(this).css('border', '2px solid red');
         }
      })
      
       $('#uname').on('keyup', function(){
         namevalue = $(this).val().trim();
         namereg = /^[가-힣]{2,10}$/
         
         if( namereg.test(namevalue)){
            $(this).css('border', '2px solid blue');
         }else{
            $(this).css('border', '2px solid red');
         }
      })
      
       
       $('#upass2').on('keyup', function(){
         pass2value = $(this).val().trim();
         passvalue = $('#upass').val();
         
         if( pass2value==passvalue){
            $(this).css('border', '2px solid blue');
         }else{
            $(this).css('border', '2px solid red');
         }
      })
      
  
      
      
      //전송 - submit  회원가입 버튼
      $('form').on('submit', function(){
        
        passval = $('#upass').val();
		reg1val = $('#ureg1').val();
		reg2val = $('#ureg2').val();
		pass2val = $('#upass2').val();
		
		if(reg1val.length!=6){
			alert("잘못된 생년월일 입니다.");
			return false;
		}
		if(reg2val.length!=7){
			alert("주민번호 뒷자리를 확인해주세요.");
			return false;
		}
		if(passval.length<8){
			alert("비밀번호는 8자리 이상입니다.");
			return false;
		}
		if(passval!=pass2val){
			alert("비밀번호 확인이 다릅니다.");
			return false;
		}
         
         
         
         datas = $('form').serializeArray();   // 배열 데이터 형식
         
         
         console.log(datas);
         
         
         
         $.ajax({
            url : '/wedo/joinMem.do',
            data : datas ,
            type : 'post',
            success : function(res){
            	if(res==1){
					alert("회원가입을 축하합니다!");
            	location.href='index.jsp';
            	}else{
					alert("회원가입 오류 올바른 정보를 다시 입력해주세요");
				}
            },
            error : function(xhr){
               alert("상태 : " + xhr.status)
            },
            dataType : 'json'
            
         })
         
      })
      
    
   
      
      //아이디 중복체크
      $('#checkid').on('click', function(){
         
         idvalue = $('#uid').val().trim();
         
         if(idvalue.length < 1){
            alert("id를 입력하세요.");
            return false;
         }
         
         console.log(idvalue);
         
         $.ajax({
            url : '/wedo/idCheckMem.do',
            type : 'get',
            data : {"id" : idvalue },
            success : function(resData){
        		
				let span;
				
					if(resData==null){
					span = "사용가능한 아이디 입니다!"
						$('#idspan').text(span).css('color', 'blue');
					}else{
						span ="중복된 아이디 입니다!"
							$('#idspan').text(span).css('color', 'red');		  
					}
					
            	

            },
            error : function(xhr){
               alert("상태 : " + xhr.status);
            },
            dataType : 'json'
         })
      })
      
  
      
      
      
   })
   
   
   
//    window.onload = function(){  //클릭해도 주소창 안사라지는 소스
//     document.getElementById("address_kakao").addEventListener("click", function(){ //주소입력칸을 클릭하면
//         //카카오 지도 발생
//         new daum.Postcode({
//             oncomplete: function(data) { //선택시 입력값 세팅
//                 document.getElementById("uaddr1").value = data.address; // 주소 넣기
//                 document.querySelector("input[name=address_detail]").focus(); //상세입력 포커싱
//             }
//         }).open();
//     });
// }
   
   window.onload = function(){ //클릭하면 주소창 자동 사라짐
	    document.getElementById("address_kakao").addEventListener("click", function(){ //주소입력칸을 클릭하면
	        //카카오 지도 발생
	        new daum.Postcode({
	            oncomplete: function(data) { //선택시 입력값 세팅
	                document.getElementById("uaddr1").value = data.address; // 주소 넣기
	               
	                if(data.address!=null){
	        	    	window.close();
	        	    }
	            }
	        }).open();
	    });

   }
</script>
</head>
<body>


	<div class="container">
		<form class="needs-validation" novalidate onsubmit="return false;">

			<h1>회원가입</h1>
			<h4>정확한 정보를 기입해주시기 바랍니다.</h4>

			<div class="form-group">
				<label for="uid">아이디</label> <input type="button" id="checkid"
					value="중복검사" class="btn btn-outline-primary btn-sm">
				<!-- <span class="spinner-border spinner-border-sm"></span> -->
				<span id="idspan"></span> <input type="text" class="form-control"
					id="uid" placeholder="Enter ID account" name="mem_id" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<div class="form-group">
				<label for="uname">이름</label> <input type="text"
					class="form-control" id="uname" placeholder="Enter username"
					name="mem_name" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<div class="form-group">
				<label for="upass">비밀번호</label> <input type="password"
					class="form-control" id="upass" placeholder="Enter password"
					name="mem_pass" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<div class="form-group">
				<label for="upass2">비밀번호확인</label> <input type="password"
					class="form-control" id="upass2" placeholder="Enter password"
					required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<div class="form-group">
				<label for="ureg1">주민등록번호앞자리</label> <input type="text"
					class="form-control" id="ureg1" placeholder="Enter reg"
					name="mem_regno1" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<div class="form-group">
				<label for="ureg2">주민등록번호뒷자리</label> <input type="text"
					class="form-control" id="ureg2" placeholder="Enter reg"
					name="mem_regno2" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<div class="form-group">
				<label for="umail">이메일</label> <input type="email"
					class="form-control" id="umail" placeholder="Enter E-mail"
					name="mem_mail" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<div class="form-group">
				<label for="tel">전화번호</label> <input type="text"
					class="form-control" id="utel" placeholder="Enter phoneNumber"
					name="mem_tel" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>



			<div class="form-group">
				<label for="uaddr1">주소</label> <input type="button" value="주소검색"
					id="address_kakao" class="btn btn-outline-primary btn-sm">
				<input type="text" class="form-control" id="uaddr1"
					placeholder="Enter addr1" name="mem_addr1" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<div class="form-group">
				<label for="uaddr2">주소상세</label> <input type="text"
					class="form-control" id="uaddr2" placeholder="Enter addr2"
					name="mem_addr2" required>
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>

			<button type="submit" class="btn btn-primary">회원가입</button>
			<button type="button" class="btn btn-primary" onclick="location.href='index.jsp' ">돌아가기</button>
			<span id="joinsub"></span>
		</form>
	</div>




</body>
</html>












