$(() => {
  for (let i = 2; i <= 10; i++) {
    $(".category > li:nth-child(" + i + ")").on("mouseover", () => {
      $(".category li:nth-child(" + i + ") > ol:nth-of-type(1)").css("visibility", "visible");
    });
  }
  $("#menu > li").on("mouseout", () => {
    $(".category li > ol").css("visibility", "hidden");
  });
  $(".sub_categori").on("mouseover", () => {
    $(this).css("visibility", "visible");
  });
  // 수량증감 버튼
  $(".descBtn").click(() => {
    let num = $("input[name=num]").val();
    num = Number(num);
    if (num > 1) num -= 1;
    $("input[name=num]").val(num);
    let curPrice = $(".cur_price").text();
    //let won = curPrice.length;
    curPrice = curPrice.split("원", "1")[0];
    curPrice = stringNumberToInt(curPrice);
    console.log(curPrice);
	        
    let totalPrice = num * curPrice;
    totalPrice = AddComma(totalPrice);
    console.log(totalPrice);
    
    $(".view_total_price > p > span").text(totalPrice+"원");
    
  });
  $(".incrBtn").click(() => {
    let num = $("input[name=num]").val();
    num = Number(num);
    if (num < 100) num += 1;
    $("input[name=num]").val(num);
    
     let curPrice = $(".cur_price").text();
    //let won = curPrice.length;
    curPrice = curPrice.split("원", "1")[0];
    curPrice = stringNumberToInt(curPrice);
    console.log(curPrice);
	        
    let totalPrice = num * curPrice;
    totalPrice = AddComma(totalPrice);
    $(".view_total_price > p > span").text(totalPrice+"원");
  });
  // 분류 글자 진하게
  sortAddClass();
  
  // 
  $('.btnCart').click(function(){
	if(loginCheck()){
		if(confirm("장바구니에 담겼습니다. 이동하시겠습니까?")){
			location.href = '/Kmarket/product/cart.do'			
		}
	}	
  });
  $('.btnBuy').click(function(){
	if(loginCheck()){
		location.href = '/Kmarket/product/order.do?prodNo='+$('.prodNo').text();			
	}	
  });
  

  
  
});
// 분류 글자 진하게 주기
function sortAddClass(){
	let href = $(location).attr('href');
	let listSort = ["soldDesc", "priceAsc", "priceDesc", "scoreDesc", "reviewDesc", "rdateDesc"];
	for(let i=0; i<listSort.length; i++){
		if(href.match(listSort[i]) != null){
			let n = i + 1;
			$('.sort > li:nth-child('+n+') > a').addClass('on');
		}
	}
}
// 문자열 숫자 콤마 제거
function stringNumberToInt(stringNumber){
    return parseInt(stringNumber.replace(/,/g , ''));
}
// 문자열 숫자 콤마 추가
function AddComma(data_value) {
	return Number(data_value).toLocaleString('en');
}
function loginCheck(){
	let session = $('.sessUser_uid').text();
	if(session == ""){
		if(confirm('로그인하셔야 이용가능합니다. 로그인 페이지로 이동하시겠습니까?')){
			location.href = "/Kmarket/member/login.do?prodNo="+$('.prodNo').text();
		}
		return false;	
	}else{
		return true;	
	}
}

 