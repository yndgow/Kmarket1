// 데이터 검증에 사용할 정규표현식
let regUid   = /^[a-z]+[a-z0-9]{3,12}$/g;
let regPass  = /^.*(?=^.{7,12}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
let regCompany = /^[가-힣0-9a-z]{1,20}/;
let regCeo  = /^[가-힣]{2,4}$/; //대표자명
let regBiz	 = /^\d{3}-\d{2}-\d{5}$/; //사업자 등록번호
let regCom = /^\[가-힣0-9]{0,4}-\[가-힣0-9]{1,5}$/; //통신판매업신고번호
let regTel = /^(070|02|031|032|033|041|042|043|051|052|053|054|055|061|062|063|064)-\d{3,4}-\d{4}$/u; //집전화
let regFax = /^\d{3,4}-\d{3}-\d{4}$/;

// 폼 데이터 검증 결과 상태변수
let isUidOk   = false;
let isPassOk  = false;
let isPassMatch = false;
let isCompanyOk = false;
let isCeoOk = false;
let isBizOk = false;
let isComOk = false;
let isTelOk    = false;
let isFaxOk  = false;
let isAddrOk = false;
let receivedCode = 0;




$(function(){
	
	// 아이디 유효성 검증 & 중복체크
	$('input[name=uid]').keydown(function(){
		isUidOk = false;
	});
	
	$('#uid').focusout(function(){
		
		let uid = $('input[name=uid]').val();
		
		if(isUidOk){
			return;
		}
		
		if(!uid.match(regUid)){
			isUidOk = false;
			$('.resultUid').css('color', 'red').text('영문, 숫자로 4~12자까지 설정해 주세요.');
			return;
		}
		
		let jsonData = {"uid":uid};
		
		$('.resultUid').css('color', 'black').text('...');
		
		setTimeout(()=>{
			
			$.ajax({
				url: '/Kmarket/member/checkUid.do',
				method: 'GET',
				data: jsonData,
				dataType: 'json',
				success:function(data){
					if(data.result == 0){
						isUidOk = true;
						$('.resultUid').css('color', 'green').text('사용 가능한 아이디 입니다.');
					}else{
						isUidOk = false;
						$('.resultUid').css('color', 'red').text('이미 사용중인 아이디 입니다.');
					}
				}
			});
			
		}, 500);
	});		
	
	// 비밀번호 일치여부 확인
	$('input[name=pass2]').focusout(function(){			
		let pass1 = $('input[name=pass1]').val();
		let pass2 = $(this).val();
		
		if(pass1 == pass2){
							
			if(pass2.match(regPass)){
				isPassOk = true;
				$('.resultPass').css('color', 'green').text('비밀번호가 일치합니다.');	
			}else{
				isPassOk = false;
				$('.resultPass').css('color', 'red').text('영문, 숫자, 특수문자를 조합하여 8~12자까지 설정해 주세요.');
			}				
			
		}else{
			isPassOk = false;
			isPassMatch = true;
			$('.resultPass').css('color', 'red').text('비밀번호가 일치하지 않습니다.');
		}			
	});
	
	
	// 회사명 유효성 검증
	$('input[name=company]').focusout(function(){
		
		let company = $(this).val();
		
		if(!company.match(regCompany)){
			isCompanyOk = false;
			$('.resultCompany').css('color', 'red').text('회사명은 필수입니다.');
		}else{
			isCompanyOk = true;
			$('.resultCompany').text('');
		}
	});
	
	
	// 대표자이름 유효성 검증
	$('input[name=ceo]').focusout(function(){
		
		let ceo = $(this).val();
		
		if(!ceo.match(regCeo)){
			isCeoOk = false;
			$('.resultCeo').css('color', 'red').text('이름은 한글 2자 이상 이어야 합니다.');
		}else{
			isCeoOk = true;
			$('.resultCeo').text('');
		}
	});
	
	//사업자 등록번호 유효성 검증
	$('input[name=bizRegNum]').focusout(function(){
		
		let biz = $(this).val();
		
		if(!biz.match(regBiz)){
			isBizOk = false;
			$('.resultBiz').css('color', 'red').text('-표시 포함 12자리를 입력하세요.');
		}else{
			isBizOk = true;
			$('.resultBiz').css('color', 'green').text('');
		}
	});
	
	
	//통신판매업 신고번호 유효성 검증
	$('input[name=comRegNum]').focusout(function(){
		
		let com = $(this).val();
		
		if(!com.match(regCom)){
			isComOk = false;
			$('.resultCom').css('color', 'red').text('형식이 맞지않습니다.');
		}else{
			isComOk = true;
			$('.resultCom').css('color', 'green').text('');
		}
	});
	
	
	
	// 전화번호 유효성 검사
	$('input[name=tel]').focusout(function(){
		let tel = $(this).val();
		
		if(!tel.match(regTel)){
			isTelOk = false;
			$('.resultTel').css('color', 'red').text('- 포함, 지역번호를 포함하여 입력하세요.');
		}else{
			isTelOk = true;
			$('.resultTel').text('');
		}
	});
	
	// 팩스 유효성 검사
	$('input[name=fax]').focusout(function(){
		let fax = $(this).val();
		
		if(!fax.match(regFax)){
			isFaxOk = false;
			$('.resultFax').css('color', 'red').text('팩스번호가 유효하지 않습니다.');
		}else{
			isFaxOk = true;
			$('.resultFax').text('');
		}			
	});
	
	//주소 유효성 검사
	$('input[name=addr2]').focus(function(){
		let zip = $('input[name=zip]').val();
		let addr2 = $(this).val();
		
		if(zip === null){
			isAddrOk = false;
			$('.resultZip').css('color', 'red').text('우편번호를 입력해 주세요.');
		}else if(addr2 === null){
			isAddrOk = false;
			$('.resultAddr').css('color', 'red').text('상세주소를 입력해 주세요.');
		}else{
			isAddrOk = true;
			$('.resultAddr').css('color', 'green').text('확인되었습니다.');
		}
	});
	
	// 폼 전송이 시작될 때 실행되는 폼 이벤트(폼 전송 버튼을 클릭했을 때) 
	$('.register > form').submit(function(){
					
		////////////////////////////////////
		// 폼 데이터 유효성 검증(Validation)
		////////////////////////////////////
		// 아이디 검증
		if(!isUidOk){
			alert('아이디를 확인 하십시요.');
			return false;
		}
		// 비밀번호 검증
		if(!isPassOk){
			alert('비밀번호를 확인 하십시요.');
			return false;
		}
		// 회사명 검증
		if(!isCompanyOk){
			alert('회사명을 확인 하십시요.');
			return false;
		}
		// 대표자 검증
		if(!isCeoOk){
			alert('대표자명을 확인 하십시요.');
			return false;
		}
		// 사업자등록번호 검증
		if(!isBizOk){
			alert('사업자 등록번호를 확인 하십시요.');
			return false;
		}
		// 통신판매업신고 번호 검증
		if(!isComOk){
			alert('통신판매업 신고번호를 확인 하십시요.');
			return false;
		}
		
		// 전화번호 검증
		if(!isTelOk){
			alert('전화번호를 확인 하십시요.');
			return false;
		}
		
		//주소 검증
		if(!isAddrOk){
			alert('주소를 입력 하십시오.');
			return false;
		}
		
		
		
		
		
		
		// 최종 전송
		return true;
	});
});