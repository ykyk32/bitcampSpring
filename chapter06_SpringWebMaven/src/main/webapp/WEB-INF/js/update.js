$(function(){
	$('#updateDiv').hide();
	
	//아이디 찾기
	$('#searchIdBtn').click(function(){
		$('#resultDiv').empty();
		
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringWebMaven/user/getUser',
			data: 'id=' + $('#searchId').val(),
			//dataType: 'json',
			//서버에서 받아오는 데이터 타입은 'text', 'html', 'xml', 'json' 형식을 지정할 수 있다
			//getUser에서 id를 찾으면 제대로 JSON으로 오지만 
			//           id가 없으면 JSON으로 오지를 못한다.
			//그래서 dataType를 생략해야 한다. (dataType를 생략하면 자료에 맞게 자동으로 형식이 지정된다.)
			
			success: function(data){
				//alert(JSON.stringify(data));
				
				if(data == ''){
					$('#updateDiv').hide();
					
					$('#resultDiv').text('찾고자 하는 아이디가 없습니다');
					$('#resultDiv').css('color', 'red');
					$('#resultDiv').css('font-weight', 'red');
				}else{
					$('#updateDiv').show();
					
					$('#name').val(data.name);
					$('#id').val(data.id);
					//$('#pwd').val(data.pwd);
				}
			},
			error: function(err){
				console.log(err);
			}
		});//$.ajax
	});
});

//취소 버튼
$('#resetBtn').click(function(){
	$('#searchIdBtn').trigger('click'); //강제 이벤트 발생
});















