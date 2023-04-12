$(function(){
	$.ajax({
		type: 'post',
		url: '/chapter06_SpringWebMaven/user/getUserList',
		dataType: 'json',
		success: function(data){
			console.log(JSON.stringify(data));
			console.log(data[0].name);
			
			$.each(data, function(index, items){
				$('<tr/>').append($('<td/>', {
					align: 'center',
					text: items.name
				})).append($('<td/>', {
					align: 'center',
					text: items.id
				})).append($('<td/>', {
					align: 'center',
					text: items.pwd
				})).appendTo($('#userListTable'));
			});////////each 
		},
		error: function(err){
			console.log(err);
		}
	});
});