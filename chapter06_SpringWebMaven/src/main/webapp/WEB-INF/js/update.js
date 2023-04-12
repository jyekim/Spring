$(function(){
	$('#updateDiv').hide();
	
	//아이디 찾기 
	$('#searchIdBtn').click(function(){
		$('#resultDiv').empty();
		$.ajax({
	 		type: 'post',
	 		url: '/chapter06_SpringWebMaven/user/getUser',
	 		data: 'id=' + $('#searchId').val(),//서버로 보내는 데이터 
	 		//dataType:'json' 이걸 빼버리면 스프링이 알아서 인식함 datatype을 생략한다.
	 		//아이디가 있으면 UserDTO가 JSON으로 오지만 아이디가 없으면 JSON으로 오지를 못함 
	 		//그래서 dataType을 생략한다. (dataType을 생략하면 자료에 맞게 자동으로 형식이 지정됨) 
	 		
	 		success: function(data) {
	 			console.log(JSON.stringify(data));
	 			
	 			if(data == ''){
	 				$('#updateDiv').hide(); //수정하려는 없는아이디를 다시 검색하게 될때 기존에 뜬 정보가 사라지게 하는 것 
	 				
	 				$('#resultDiv').text('찾고자 하는 아이디가 없습니다');
	 				$('#resultDiv').css('color', 'red').css('font-weight', 'bold'); 
	 			}else{
	 				$('#updateDiv').show();
	 				
	 				$('#name').val(data.name);
	 				$('#id').val(data.id);
	 				$('#pwd').val(data.pwd);
	 			}
	 		},
	 		error: function(err) {
	 			console.log(err);
	 		}
		});//ajax
	});
});

