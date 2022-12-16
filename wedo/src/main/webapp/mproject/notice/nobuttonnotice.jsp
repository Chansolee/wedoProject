<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="css/style.css">
	
	<script src="js/jquery.min.js"></script>
  <script src="js/popper.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/main.js"></script>
 <script src="js/nobuttonnotice.js"></script>

<style>
.box{
  margin : 10px;
}
#pagelist{
  margin : 10px;
  margin-left : 20%;
}

 .p1{
    width :75%;
    float: left;
 }
   .p2{
     width : 20%;
     float : right ;
  }
  .p3{
     clear : both ;
  }
  
  input[name=reply]{
    height : 50px;
    vertical-align: top;
  }
  
  .rep-body{
     border : 1px solid gray;
     background : #faf1fd;
     margin : 5px;
  }
  textarea {
	box-sizing: border-box;
	width : calc(80% - 1%);
 }
</style>

<script>
$(function(){
	listPageServer(1);
	
	//이전버튼 이벤트 
	$(document).on('click','.prev', function(){
		// alert( $('.plist a').first().text());
		 
		currentPage = parseInt($('.plist a').first().text().trim() ) -1 ;
		listPageServer(currentPage);
	})
	
	//다음버튼 이벤트 
	$(document).on('click', '.next', function(){
		 //alert($('.plist a').last().text());
		currentPage = parseInt( $('.plist a').last().text().trim() )  + 1;
		listPageServer(currentPage);
	})
	
	//페이지번호 이벤트 
	$(document).on('click','.plist a', function(){
		//alert( $(this).text());
		currentPage  = $(this).text().trim();
		listPageServer(currentPage);
		
	})
	
	//버튼, 제목  에 대한 이벤트 
	$(document).on('click', '.action', function(){
		bname =   $(this).attr('name')
		num =   $(this).attr('idx')
		
		if(bname == "select"){
			
			
			
// 			alert(num + "번글 출력 ");
			
		     
			$.ajax({
		            url : '/wedo/selectNotice.do',
		            data : {"no" : num},
		            type : 'post',
		            success : function(res){
		            	if(res!=null){
// 							alert("이동합니다~!");
 
		            	location.href='nobuttonnoticeview.jsp';
		            	}else{
							alert("오류입니다. 다시 입력해주세요");
						}
		            },
		            error : function(xhr){
		               alert("상태 : " + xhr.status)
		            },
		           
		            dataType : 'json'
		         })
	
			
			
			
		}else if(bname == "insert"){
			alert("레츠고~~ ");
			 location.href = "insertnotice.jsp"
			

 		}
		
		
		
	})
	
	

	
})
</script>

</head>
<body>

<div class="box">
</div>
<div id="pagelist" style="margin-left: 700px; margin-top: -70px;"></div>
 
</body>
</html>





