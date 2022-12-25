<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
<script>

</script>
  <section id="admin-product-list">
    <nav>
      <h3>공지사항 수정</h3>
      <p>HOME > 고객센터 > <strong>공지사항</strong></p>
    </nav>
    <section>
    <form action="/Kmarket/admin/cs/notice/modify.do" method="post" id="noticeModifyForm">
      <table class="update">
        <tr>
          <th>유형</th>
          <td>
            <select name="cate1">
            <option value="0">1차유형</option>
            <c:choose>
	            <c:when test="${notice.cate1 eq 1}">
	            	<option value="1" selected>고객서비스</option>
	            	<option value="2">안전거래</option>
	            	<option value="3">위해상품</option>
	            	<option value="4">이벤트 당첨</option>
            	</c:when>
	            <c:when test="${notice.cate1 eq 2}">
	            	<option value="1">고객서비스</option>
	            	<option value="2" selected>안전거래</option>
	            	<option value="3">위해상품</option>
	            	<option value="4">이벤트 당첨</option>
            	</c:when>
	            <c:when test="${notice.cate1 eq 3}">
	            	<option value="1">고객서비스</option>
	            	<option value="2">안전거래</option>
	            	<option value="3" selected>위해상품</option>
	            	<option value="4">이벤트 당첨</option>
            	</c:when>
	            <c:when test="${notice.cate1 eq 4}">
	            	<option value="1">고객서비스</option>
	            	<option value="2">안전거래</option>
	            	<option value="3">위해상품</option>
	            	<option value="4" selected>이벤트 당첨</option>
            	</c:when>
            </c:choose>
            </select>
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td><input type="text" name="title" id="title" value="${notice.notTitle}"/></td>
        </tr>
        <tr>
          <th>내용</th>
          <td><textarea name="content" id="content">${notice.notContent}</textarea></td>
        </tr>
      </table>
      <input type="hidden" name="notNo" value="${notice.notNo}">
    </form>
      <div class="btnGroup">
        <input type="button" class="btnAdminCsDel btnCancle" value="취소" />
        <input type="button" class="btnAdminCsWri btnModNotice" value="수정하기" />
      </div>
    </section>
  </section>
</main>
<jsp:include page="../_footer.jsp"/>