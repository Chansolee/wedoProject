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
    <!-- Simple bar CSS -->
    <link rel="stylesheet" href="css/simplebar.css">

    <!-- App CSS -->
    <link rel="stylesheet" href="css/css.css" id="lightTheme">
    
    <script src="js/jquery.min.js"></script>
  <script src="js/popper.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/main.js"></script>
 
    
    
    <script type="text/javascript">
    
    <%NoticeVO vo = (NoticeVO)session.getAttribute("vovo");  %>
  $(function(){
	  num = <%=vo.getNotice_no()%>;

	 
	 $('#content').html(cont) ;
	
	$("#modify").on("click",function(){
		
		alert(num + "번글 수정 ");
		
		
		$.ajax({
            url : '/wedo/updateSelect.do',
            data : {"no" : num},
            type : 'post',
            success : function(res){
            	if(res!=null){
					alert("이동합니다~!");

            	location.href='updatenotice.jsp';
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

	$("#delete").on("click",function(){
		alert(num + "번글 삭제 ");
		
		$.ajax({
            url : '/wedo/deleteNotice.do',
            data : {"no" : num},
            type : 'post',
            success : function(res){
            	if(res==1){
					alert("삭제완료!");

            	location.href='notice.jsp';
            	}else{
					alert("오류입니다. 다시 클릭해주세요");
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
  <body class="vertical  light  " style="margin: 0% 5%;">
                  <div class="card shadow mb-4" style="padding-left: 40px; padding-right: 40px; border: 1px solid; border-radius: 10px;">
                    <div class="card-header" style="border: 1px solid gray; margin-bottom: 18px;">
                      <strong class="card-title"><%=vo.getNotice_title()%></strong>
                      
                    </div>
                    <dl class="row align-items-center mb-0" style="margin-top: -8px;">
                        <dt class="col-sm-2 mb-3 text-muted" style="border: 1px solid rgb(18 38 63 / 15%); padding-left: 100px; margin: 0px 2px;">작 성 자</dt>
                        <dd class="col-sm-4 mb-3" style="border: 1px solid rgb(18 38 63 / 15%); padding-left: 220px; margin: 0px 2px;">
                          <strong><%=vo.getManager_id()%></strong>
                        </dd>
                        <dt class="col-sm-2 mb-3 text-muted" style="border: 1px solid rgb(18 38 63 / 15%); padding-left: 100px; margin: 0px 2px;">날 짜</dt>
                        <dd class="col-sm-4 mb-3" style="border: 1px solid rgb(18 38 63 / 15%); padding-left: 220px; ">
                          <strong><%=vo.getNotice_date()%></strong>
                        </dd>
                      </dl>
                      
                    <div id="content" class="card-body" style="border: 1px solid gray; margin-bottom: 20px; border-radius: 10px;">
                    <%=vo.getNotice_content()%><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                    </div> 
                    <p>
                    
                    &nbsp;&nbsp;
                    <button type="button" class="btn mb-2 btn-primary" style="width: 90px; margin-left: 10px; float: left;" onclick="location.href='nobuttonnotice.jsp' ">목록</button>
                    <p></p>
                    <!-- .card-body -->
                  </div> <!-- .card -->
                 
    </main> <!-- main -->
   
  </body>
</html>