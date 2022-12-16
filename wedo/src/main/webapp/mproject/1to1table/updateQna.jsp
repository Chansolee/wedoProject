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
  
 	 OneToOneQnaVO otoqVo = (OneToOneQnaVO)session.getAttribute("otoqVo");
  String content = (String)session.getAttribute("content");
  
  %>
  
  <script>
   $(function(){

	   $('form').on('submit', function(){
  			
		   one_qna_no = <%= otoqVo.getOne_qna_no() %>;
		   qna_title = document.getElementById("qna_title").value;
		   qna_content = document.getElementById("qna_content").value;
		   
		   qna_content = qna_content.replace(/(?:\r\n|\r|\n)/g, '<br/>');
		   
		   
         $.ajax({
            url : '/wedo/updateQna.do',
            data : {
            	"one_qna_no" : one_qna_no,
            	"qna_title" : qna_title,
            	"qna_content" : qna_content
            },
            type : 'post',
            success : function(res){
            	alert("게시글 수정 성공");
            	location.href="/wedo/select1to1Mem.do";
            },
            error : function(xhr){
               alert("상태 : " + xhr.status)
            },
            dataType : 'json'
            //gg
         })
      })      
   })
   
   
</script>
  <body class="vertical  light  " style="margin: 5%;">

 	<form novalidate onsubmit="return false;">
 	<div class="card shadow" >
                    <div class="card-header ">
                      <strong class="card-title mb-0">
                      		<input id="qna_title" class="form-control form-control-lg" type="text" name="notice_title" value="<%= otoqVo.getOne_qna_title()%>">
                      	<!-- 	<a>To <%=otoqVo.getTeacher_id() %>강사님</a>  -->
                      </strong>
                    </div>
                    <div class="card-body " role="alert">
                      <textarea id = "qna_content"class="form-control" id="example-textarea" rows="4" name="notice_content"><%=content%></textarea>
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