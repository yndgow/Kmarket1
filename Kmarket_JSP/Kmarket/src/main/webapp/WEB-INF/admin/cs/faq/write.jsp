<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
  <section id="admin-product-list">
	<c:choose>
		<c:when test="${csType eq 'faq'}">
			<c:set var="csTxt" value="자주묻는질문"/>
		</c:when>
		<c:when test="${csType eq 'qna'}">
			<c:set var="csTxt" value="문의하기"/>
		</c:when>
		<c:when test="${csType eq 'notice'}">
			<c:set var="csTxt" value="공지사항"/>
		</c:when>
	</c:choose>
    <nav>
      <h3>${csTxt} 목록</h3>
      <p>HOME > 고객센터 > <strong>${csTxt}</strong></p>
    </nav>
    <section>
      <table class="update">
        <tr>
          <th>유형</th>
          <td>
            <select name="sel1">
              <option value="default">1차선택</option>
              <option value="csService">고객서비스</option>
              <option value="safeTrans">안전거래</option>
              <option value="dangerProd">위해상품</option>
              <option value="event">이벤트 당첨</option>
            </select>
            <select name="sel2">
              <option value="default">2차선택</option>
              <option value="csService">고객서비스</option>
              <option value="safeTrans">안전거래</option>
              <option value="dangerProd">위해상품</option>
              <option value="event">이벤트 당첨</option>
            </select>
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td><input type="text" name="title" id="title" /></td>
        </tr>
        <tr>
          <th>내용</th>
          <td><textarea name="content" id="content"></textarea></td>
        </tr>
      </table>
      <div class="btnGroup">
        <input type="button" class="btnAdminCsDel btnCancle" value="취소" />
        <input type="button" class="btnAdminCsWri btnWrite" value="등록하기" />
      </div>
    </section>
  </section>
</main>
<jsp:include page="../_footer.jsp"/>