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
      	<h4>관리자님 환영합니다!</h4><br>
      	
         <header>LOGIN</header>
          <div class="auth">
            Choose Member
         </div>
        <div class="social-icons">
                    <a href = "index.jsp" id= "user"><img src="img/사용자.png" alt="facebook"></a>
                    <a href = "teacherLogin.jsp" id= "teacher"><img src="img/강사.png" alt="twitter"></a>
                    <a href = "managerLogin.jsp" id= "manager"><img src="img/관리자.png" alt="google"></a>
                </div>
         <form action="<%= request.getContextPath() %>/managerLogin.do" method="post">
            <div class="input-field">
               <input type="text" name="manager_id" required>
               <label>아이디</label>
            </div>
            <div class="input-field">
               <input class="pswrd" type="password" name="manager_pass" required>
               <span class="show">SHOW</span>
               <label>비밀번호</label>
            </div>
            <div class="button">
               <div class="inner"></div>
               <button>LOGIN</button>
            </div>
         </form>
        
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