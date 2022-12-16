<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Created By CodingNepal -->
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Animated Login Form</title>
      <link rel="stylesheet" href="css/login.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
   </head>
   <body>
      <div class="container">
         <h4>우리두에 오신것을 환영합니다!</h4><br>
         
         <header>LOGIN</header>
          <div class="auth">
            Choose Member
         </div>
        <div class="social-icons">
                    <a href = "index.jsp" id= "user"><img src="img/사용자.png" alt="facebook"></a>
                    <a href = "teacherLogin.jsp" id= "teacher"><img src="img/강사.png" alt="twitter"></a>
                    <a href = "managerLogin.jsp" id= "manager"><img src="img/관리자.png" alt="google"></a>
                </div>
         <form action="<%= request.getContextPath() %>/memLogin.do" method="post">
            <div class="input-field">
               <input type="text" name="mem_id" required>
               <label>아이디</label>
            </div>
            <div class="input-field">
               <input class="pswrd" type="password" name="mem_pass" required>
               <span class="show">SHOW</span>
               <label>비밀번호</label>
            </div>
            <div class="button">
               <div class="inner"></div>
               <button>LOGIN</button>
            </div>
         </form>
                
         <div class="signup">
            아이디를 잊어버렸습니까? <a href="memberFoundId.jsp">ID 찾기</a>
         </div>
         
         <div class="signup">
            비밀번호를 잊어버렸습니까? <a href="memberFoundPw.jsp">비밀번호 찾기</a>
         </div>
         
         <div class="signup">
            회원등록을 하시겠습니까? <a href="memberSignUp.jsp">회원가입</a>
         </div>
         
      </div>
      <script>
         var input = document.querySelector('.pswrd');
         var show = document.querySelector('.show');
         show.addEventListener('click', active);
         function active(){
           if(input.type === "password"){
             input.type = "text";
             show.style.color = "#1DA1F2";
             show.textContent = "HIDE";
           }else{
             input.type = "password";
             show.textContent = "SHOW";
             show.style.color = "#111";
           }
         }
      </script>
   </body>
</html>