
 $(document).ready(function(){
	 
/*	let status = false;
	$('.more').click(function () {
		if(!status){
			$(this).siblings('.item').show();
			$(this).children('a').text('간단히 보기');
			status = true;	
		}else{
			$(this).siblings('.item').hide();
			$(this).children('a').text('더보기');
			status = false;	
		}
	});*/
	
	$('.more > a').click(function (e) { 
		e.prevenDefault();
		alert();
		$('.item').show();
		
	});
	
});



















