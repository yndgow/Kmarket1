<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./_header.jsp"/>
<script>
	$(function () {
		$('.agree').click(function() {
			
			let isCheck1 = $('input[class=agree1]').is(':checked');
			let isCheck2 = $('input[class=agree2]').is(':checked');
			let isCheck3 = $('input[class=agree3]').is(':checked');
			
			if(isCheck1 && isCheck2 && isCheck3){
				return true;
			}else{
				alert('동의 체크를 하셔야 합니다.');
				return false;
			}
		});
	});
</script>
        <main id="member">
            <div class="signup">
                <nav>
                    <h1>약관동의</h1>
                </nav>
                 <c:if test="${1 eq type}">
                <section>
                    <h3><span class="essential">(필수)</span>이용약관</h3>
                    <textarea name="terms" readonly>${vo.terms }</textarea>
                    <label><input type="checkbox" class="agree1">동의합니다.</label>

                    <h3><span class="essential">(필수)</span>전자금융거래 이용약관</h3>
                    <textarea name="financial" readonly>${vo.finance }</textarea>
                    <label><input type="checkbox" class="agree2">동의합니다.</label>

                    <h3><span class="essential">(필수)</span>개인정보 수집동의</h3>
                    <textarea name="privacy" readonly>${vo.privacy }</textarea>
                    <label><input type="checkbox" class="agree3">동의합니다.</label>
                </section>
                <section>
                    <h3><span class="optional">(선택)</span>위치정보 이용약관</h3>
                    <textarea name="location" readonly>${vo.location }</textarea>
                    <label><input type="checkbox" class="agree4">동의합니다.</label>
                </section>
                <div><a href="/Kmarket/member/register.do"><input type="button" class="agree" value="동의하기"></a></div>
                 </c:if>
                 
                  <c:if test="${2 eq type}">
                <section>
                    <h3><span class="essential">(필수)</span>판매자 이용약관</h3>
                    <textarea name="tax" readonly>${vo.tax }</textarea>
                    <label><input type="checkbox" class="agree1">동의합니다.</label>

                    <h3><span class="essential">(필수)</span>전자금융거래 이용약관</h3>
                    <textarea name="financial" readonly>${vo.finance }</textarea>
                    <label><input type="checkbox" class="agree2">동의합니다.</label>

                    <h3><span class="essential">(필수)</span>개인정보 수집동의</h3>
                    <textarea name="privacy" readonly>${vo.privacy }</textarea>
                    <label><input type="checkbox" class="agree3">동의합니다.</label>
                </section>
               
                <div><a href="/Kmarket/member/registerSeller.do"><input type="button" class="agree" value="동의하기"></a></div>
                 </c:if>
            </div>
        </main>
<jsp:include page="./_footer.jsp"/>