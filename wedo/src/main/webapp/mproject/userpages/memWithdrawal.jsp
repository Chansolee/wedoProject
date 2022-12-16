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
      
      
      //전송 - submit  회원가입 버튼
      $('form').on('submit', function(){
    	  
    	  sessionpassval = <%=session.getAttribute("passvalue")%> //기존 세션에 있는 비밀번호
        
        passval = $('#upass').val();
      
      
      
      
      		 if(sessionpassval!=passval){
      			 alert("비밀번호가 다릅니다.");
      		 	 return false;
     		 }
   
        
         datas = $('form').serializeArray();   // 배열 데이터 형식
         
         
         console.log(datas);
         
         
         
         $.ajax({
            url : '/wedo/withDrawalMember.do',
            data : datas ,
            type : 'post',
            success : function(res){
				if(res==1){
               alert("회원탈퇴완료!");
               location.href='../main/index.html';
				}else{
					alert("비번오류")
				}
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
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="userindex.jsp">사용자 마이페이지</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
               
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="/wedo/logout.do">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Core</div>
                            <a class="nav-link" href="../usermain/mainUser.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Home
                            </a>
                            <div class="sb-sidenav-menu-heading">Interface</div>
                            <!-- --------------메뉴1-------------------  -->
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                개인정보 관리
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="memCheck.jsp">개인정보 수정</a>
                                </nav>
                            </div>
                             <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="passChange.jsp">비밀번호 변경</a>
                                </nav>
                            </div>
                             <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="memWithdrawal.jsp">회원 탈퇴</a>
                                </nav>
                            </div>
                            <!-- --------------메뉴2-------------------  -->
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                수강 관리
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion">
                                    <a class="nav-link" href="uEnrollList.html"> 내 수강 목록</a>
                                </nav>
                            </div>
                            <!-- --------------메뉴3-------------------  -->
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages2" aria-expanded="false" aria-controls="collapsePages2">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                결제
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                           <div class="collapse" id="collapsePages2" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion">
                                    <a class="nav-link" href="paymentList.html">결제 내역 확인</a>
                                </nav>
                            </div>
                            <!-- --------------메뉴4-------------------  -->
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages3" aria-expanded="false" aria-controls="collapsePages3">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                장바구니
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                           <div class="collapse" id="collapsePages3" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion">
                                    <a class="nav-link" href="cart.html">장바구니 보기</a>
                                </nav>
                            </div>
                            <!-- --------------메뉴5-------------------  -->
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages4" aria-expanded="false" aria-controls="collapsePages4">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                문의 있어요!
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                           <div class="collapse" id="collapsePages4" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion">
                                    <a class="nav-link" href="contact.html">강사에게 1:1 문의하기</a>
                                </nav>
                            </div>
                        </div>
                    </div>
                    
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
               <label for="upass">기존 비밀번호 입력</label>
               <input type="password" class="form-control" id="upass" placeholder="Enter password" name="mem_pass" required>
               <div class="valid-feedback">Valid.</div>
               <div class="invalid-feedback">Please fill out this field.</div>
          </div>
 
            <button type="submit" class="btn btn-danger">회원 탈퇴</button>
            <span id="joinsub"></span>
      </form>
   </div>


                </main>
                <footer class="py-4 bg-light mt-auto">
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
