/**
 * 
 */
 $(document).ready(function(){
	
	// 카테고리 김지홍
    // 카테고리 1번 리스트 출력 함수 김지홍
	cate1List();
    // 카테고리 2번 김지홍
    $('select[name=qc1Name]').on('change', function(){
		let cate2Val =$(this).val();
		cate2List(cate2Val);
	});
	
});
// 카테고리 1 호출
function cate1List(){
	$.ajax({
	    url:'/Kmarket/cs/qna/cate.do?cate1=1',
	    dataType:'json',
	    success:(data)=>{
	        let cate1 = $('select[name=qc1Name]');
	        cate1.children().remove();
	        let tag = `<option value="0">문의유형</option>`;
	        data.forEach(e => {
	            tag += `<option value="${e.qnaCate1}">${e.qc1Name}</option>`;
	        });
	        cate1.append(tag);
	    }
	});
}
// 카테고리 2 호출    
function cate2List(cate2Val){
	$.ajax({
		url:'/Kmarket/cs/qna/cate.do?cate1=2&cate2='+cate2Val,
		dataType:'json',
		success:(data)=>{
	    	let cate2 = $('select[name=qc2Name]');
	    	cate2.children().remove();
	    	let tag = `<option value="0">상세유형</option>`;
	    	data.forEach(e => {
	        	tag += `<option value="${e.qc2Name}">${e.qc2Name}</option>`;
	    	});
	    cate2.append(tag);
		}
	});
}