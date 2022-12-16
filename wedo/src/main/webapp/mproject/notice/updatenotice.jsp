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
  <script>
   $(function(){
      

	   $('form').on('submit', function(){
         
         
         datas = $('form').serializeArray();   // 배열 데이터 형식
         
         
         console.log(datas);
         
         
         
         $.ajax({
            url : '/wedo/updateNotice.do',
            data : datas ,
            type : 'post',
            success : function(res){
            	if(res==1){
					alert("수정완료!");
            	location.href='notice.jsp';
            	}else{
					alert("오류입니다. 다시 입력해주세요");
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
  <body class="vertical  light  " style="margin: 5%;">
  <%NoticeVO vo = (NoticeVO)session.getAttribute("vovo");%>
  <%String content = (String)session.getAttribute("noticecontent");%>
 <form novalidate onsubmit="return false;">
 <div class="card shadow" >
                    <div class="card-header ">
                      <strong class="card-title mb-0"><input class="form-control form-control-lg" type="text" name="notice_title" value="<%=vo.getNotice_title()%>"></strong>
                    </div>
                    <div class="card-body " role="alert">
                      <textarea class="form-control" id="example-textarea" rows="4" name="notice_content"><%=content%></textarea>
                    </div>
                    <p>
                    <button type="submit" class="btn mb-2 btn-primary"style="width: 70px; float: left; margin-left: 1300px;">수정</button>
                    &nbsp;&nbsp;
                    <button type="button" class="btn mb-2 btn-primary" type="reset" style="width: 70px; margin-left: 10px; float: left; " onclick="location.href='notice.jsp' ">취소</button>
                    &nbsp;&nbsp;
                    
                    <p>
                  </div>
                  </form>
  </body>
</html>