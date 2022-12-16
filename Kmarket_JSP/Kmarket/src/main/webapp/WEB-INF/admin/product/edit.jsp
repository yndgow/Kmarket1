<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>edit</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
    $(()=>{
		let prodNo = opener.$('#prodNo').val();//부모창에서 id가 parent인 태그의 val() 
    	$('input[name=prodNo]').val(prodNo); //자식창에서 id가 child인 val에 id를 넣기
    
      	//$("#key", opener.document).val(key);
    });
  		
    </script>
  </head>
  <body>
  	<form action="/Kmarket/admin/product/editImg.do" method="post" enctype="multipart/form-data">
  		<input type="hidden" name="prodNo" value="" id="prodNo">
    	<input type="file" name="fname" id="fname" />
    	<button type="submit">전송</button>
   	</form>
  </body>
</html>
