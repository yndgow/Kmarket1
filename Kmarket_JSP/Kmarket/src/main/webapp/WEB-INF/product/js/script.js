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
  });
  $(".incrBtn").click(() => {
    let num = $("input[name=num]").val();
    num = Number(num);
    if (num < 100) num += 1;
    $("input[name=num]").val(num);
  });
  // 분류 글자 진하게 주기
  sortAddClass();
  
});
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
	
