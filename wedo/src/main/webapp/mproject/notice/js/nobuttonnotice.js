/**
 * 
 */
currentPage = 1;




listPageServer = function(cpage){
	
	$.ajax({
		url : '/wedo/noticeList.do',
		type : 'post',
		data  : {"page" : cpage},
		success : function(res){
			code=	'<section class="ftco-section">';
code +=		'<div class="container" style="border: 1px solid; border-radius: 10px; padding-top: 12px;>';
/*code +=			'<div class="row justify-content-center">';
code +=				'<div class="col-md-6 text-center mb-5">';
code +=					'<h2 class="heading-section">공지사항</h2>';
code +=				'</div>';
code +=			'</div>';
*/code +=			'<div class="row">';
code +=				'<div class="col-md-12">';
code +=					'<div class="table-wrap">';
code +=						'<table class="table">';
code +=						  '<thead class="thead-primary">';
code +=						    '<tr>';
code +=						     ' <th>#</th>';
code +=						     ' <th>제목</th>';
code +=						     ' <th>&nbsp;&nbsp;&nbsp;</th>';
code +=						      '<th>작성일자</th>';
code +=						    '</tr>';
code +=						 ' </thead>';


$.each(res.lists, function(i,v){    
code +=						  '<tbody>';
code +=						    '<tr>';
code +=						      '<th scope="row">'+ v.notice_no  + ' </th>';
code +=						     ' <td>'
code += '<a idx="'+ v.notice_no  + '"  name="select"  class="action" href="#">' + v.notice_title + '</a>';
code +=                            '</td>';
code +=						      '<td>&nbsp;&nbsp;&nbsp;</td>';
code +=						      '<td>' + v.notice_date + '</td>';
code +=						    '</tr>';
code +=						  '</tbody>';
})

code +=						'</table>';
code +=					'</div>';
code +=				'</div>';
code +=			'</div>';
code +=		'</div>';
code +=	'</section>';

$('.box').html(code);
	
			//이전 버튼 
			pager = "";
	
			if(res.spage > 1){
            pager += '<ul class="pagination">';
            pager += '<li class="page-item"><a class="page-link prev" href="#">Previous</a></li>';
            pager += '</ul>';
         }else{
            pager += '<ul class="pagination">';
            pager += '<li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>';
            pager += '</ul>';
         }
			//페이지번호
			pager += '<ul class="pagination plist">'; 
			for(i=res.spage ; i<= res.epage; i++){
				
				if(currentPage == i){
					 pager += '<li class="page-item active"><a class="page-link pnum" href="#">' + i + '</a></li>';
				}else {
					 pager += '<li class="page-item"><a class="page-link pnum" href="#">' + i + '</a></li>';
				}
			}
			pager += '</ul>'
			
			//다음버튼 
			if(res.tpage > res.epage ){
				pager += '<ul class="pagination">';
		        pager += ' <li class="page-item"><a class="page-link next" href="#">Next</a></li>'
		        pager += ' </ul>';
			}else{
				pager += '<ul class="pagination">';
		        pager += ' <li class="page-item disabled"><a class="page-link next" href="#">Next</a></li>'
		        pager += ' </ul>';
				
			}
		5
			$('#pagelist').html(pager);
			
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType : 'json'
	})
	
}














