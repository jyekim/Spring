$(function(){
	
	//아이디 찾기 update.js에서 퍼옴
	$('#searchIdBtn').click(function(){
		$('#resultDiv').empty();
		$.ajax({
	 		type: 'post',
	 		url: '/chapter06_SpringWebMaven/user/getUser',
	 		data: 'id=' + $('#searchId').val(), 
	 		
	 		success: function(data) {
	 			console.log(JSON.stringify(data));
	 			
	 			if(data == ''){
	 				$('#updateDiv').hide(); 
	 				
	 				$('#resultDiv').text('찾고자 하는 아이디가 없습니다');
	 				$('#resultDiv').css('color', 'red').css('font-weight', 'bold'); 
	 			}else{
	 				// 아이디가 있으면 삭제
	 				if(confirm('삭제하시겠습니까?')){
	 				$.ajax({
	 					type: 'post',
				 		url: '/chapter06_SpringWebMaven/user/delete',
				 		data: 'id=' + $('#searchId').val(),
				 		success: function(){
						 		alert("회원정보를 삭제하였습니다.");
								location.href='/chapter06_SpringWebMaven/user/list';	
				 		},
				 		error: function(err) {
				 			console.log(err);
				 		}
	 				});
				}//if
	 			}
	 		},
	 		error: function(err) {
	 			console.log(err);
	 		}
		});//ajax
	});
});