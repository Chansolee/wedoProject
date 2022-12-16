<%@page import="kr.or.ddit.wedo.vo.OneToOneAnsVO"%>
<%@page import="kr.or.ddit.wedo.vo.OneToOneQnaVO"%>
<%@page import="kr.or.ddit.wedo.vo.NoticeVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>Tiny Dashboard - A Bootstrap Dashboard Template</title>
   
    <link href="https://fonts.googleapis.com/css2?family=Overpass:ital,wght@0,100;0,200;0,300;0,400;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <!-- Icons CSS -->
   
    <link rel="stylesheet" href="css/css.css" id="lightTheme">
     
    <script src="js/jquery.min.js"></script>
  </head>
  <% 
  
 	 OneToOneAnsVO otoaVo = (OneToOneAnsVO)session.getAttribute("otoaVo");
  
  String content = (String)session.getAttribute("anscontent");
  
  %>
  
  <script>
   $(function(){

	   $('form').on('submit', function(){
  			
		   one_ans_no = <%= otoaVo.getOne_ans_no() %>;
		   ans_content = document.getElementById("ans_content").value;
		   
		   ans_content = ans_content.replace(/(?:\r\n|\r|\n)/g, '<br/>');
		   
		   
         $.ajax({
            url : '/wedo/updateAns.do',
            data : {
            	"one_ans_no" : one_ans_no,
            	"ans_content" : ans_content
            },
            type : 'post',
            success : function(res){
            	alert("수정 성공");
            	location.href="/wedo/select1to1Mem.do";
            },
            error : function(xhr){
               alert("상태 : " + xhr.status)
            },
            dataType : 'json'
            
         })
      })      
   })
   
   
</script>
  <body class="vertical  light  " style="margin: 5%;">

 	<form novalidate onsubmit="return false;">
 	<div class="card shadow" >
 		<!-- 
                    <div class="card-header ">
                      <strong class="card-title mb-0">
                      		<input id="qna_title" class="form-control form-control-lg" type="text" name="notice_title" >
                      </strong>
                    </div> -->
                    <div class="card-body " role="alert">
                      <textarea id = "ans_content"class="form-control" id="example-textarea" rows="4" name="notice_content"><%=content %></textarea>
                    </div>
                    <p>
                    <button type="submit" class="btn mb-2 btn-primary"style="width: 70px; float: left; margin-left: 85%;">수정</button>
                    &nbsp;&nbsp;
                    <button type="button" class="btn mb-2 btn-primary" type="reset" style="width: 70px; margin-left: 10px; float: left; " onclick="location.href='/wedo/select1to1Mem.do'">취소</button>
                    &nbsp;&nbsp;
                    
                    <p>
                  </div>
                  </form>
  </body>
</html>