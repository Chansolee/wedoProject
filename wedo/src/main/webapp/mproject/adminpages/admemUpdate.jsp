<%@page import="kr.or.ddit.wedo.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Static Navigation - SB Admin</title>
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
 <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
        
        
<script>
   $(function(){
      
  //전송 - submit  업데이트 버튼
      $('form').on('submit', function(){
        
       
     
         datas = $('form').serializeArray();   // 배열 데이터 형식
         
         
         console.log(datas);
         
         
         
         $.ajax({
            url : '/wedo/updateMember.do',
            data : datas ,
            type : 'post',
            success : function(res){

               alert("업데이트 성공!");
               location.href='/wedo/memberList.do';
            },
            error : function(xhr){
               alert("상태 : " + xhr.status)
            },
            dataType : 'json'
            
         })
         
      })
      
      
      
   })
   
   
   
   window.onload = function(){
    document.getElementById("address_kakao").addEventListener("click", function(){ //주소입력칸을 클릭하면
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementById("uaddr1").value = data.address; // 주소 넣기
                document.querySelector("input[name=address_detail]").focus(); //상세입력 포커싱
             
            }
        }).open();
    });
}


</script>
        
    </head>
    <body>
    
    


                    <div class="sb-sidenav-footer">
  
                </nav>
            </div>
            
            
            <!--  -->
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">회원 정보</h1>
                      
                        <div class="card mb-4">
                            <div class="card-body">
                                <p class="mb-0">
                                
  
<div class="container-fluid text-center">    
  <div class="row content2">
    <div class="col-sm-8 text-left"> 
   <div class="container">
      <form  class="needs-validation" novalidate onsubmit="return false;">
         


     
          <div class="form-group">
             <label for="umail">이메일</label>
             <input type="email" class="form-control" id="umail" placeholder="Enter E-mail" name="mem_mail" required>
             <div class="valid-feedback">Valid.</div>
             <div class="invalid-feedback">Please fill out this field.</div>
          </div>
          
          <div class="form-group">
             <label for="tel">전화번호</label>
             <input type="text" class="form-control" id="utel" placeholder="Enter phoneNumber" name="mem_tel" required>
             <div class="valid-feedback">Valid.</div>
             <div class="invalid-feedback">Please fill out this field.</div>
          </div>
          
        
          
          <div class="form-group">
             <label for="uaddr1">주소</label>
              <input type="button" value="주소검색" id="address_kakao" class="btn btn-outline-primary btn-sm" >
             <input type="text" class="form-control" id="uaddr1" placeholder="Enter addr1" name="mem_addr1" required>
             <div class="valid-feedback">Valid.</div>
             <div class="invalid-feedback">Please fill out this field.</div>
          </div>
          
          <div class="form-group">
             <label for="uaddr2">주소상세</label>
             <input type="text" class="form-control" id="uaddr2" placeholder="Enter addr2" name="mem_addr2" required>
             <div class="valid-feedback">Valid.</div>
             <div class="invalid-feedback">Please fill out this field.</div>
          </div>
          
            <button type="submit" class="btn btn-primary">수정하기</button>
            <span id="joinsub"></span>
      </form>
   </div>


                </main>
      
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        
    
        
        
    </body>
</html>
