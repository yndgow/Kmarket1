<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
<script src="/Kmarket/js/admin/cs/script_kjh.js"></script>
<input type="hidden" name="writeCate1" value="${cate1}" />
<input type="hidden" name="writeCate2" value="${cate2}" />
  <section id="admin-product-list">
	<c:choose>
		<c:when test="${csType eq 'faq'}">
			<c:set var="csTxt" value="자주묻는질문"/>
		</c:when>
		<c:when test="${csType eq 'qna'}">
			<c:set var="csTxt" value="문의하기"/>
			<c:set var="csTxt2" value="답변"/>
		</c:when>
		<c:when test="${csType eq 'notice'}">
			<c:set var="csTxt" value="공지사항"/>
		</c:when>
	</c:choose>
    <nav>
      <h3>${csTxt} ${csTxt2}</h3>
      <p>HOME > 고객센터 > <strong>${csTxt}</strong></p>
    </nav>
    <section>
    <input type="hidden" name="csType" value="${csType}"/>
      <table class="update adminCsmodify">
        <tr>
          <th>유형</th>
          <td>${qna.c1Name}&nbsp;-&nbsp;${qna.c2Name}</td>
        </tr>
        <tr>
          <th>제목</th>
          <td>${qna.qnaTitle}</td>
        </tr>
        <tr>
          <th>내용</th>
          <td>${qna.qnaContent}</td>
        </tr>
        <tr>
          <th>답변</th>
          <td><textarea name="reply" id="content"></textarea></td>
        </tr>
      </table>
      <div class="btnGroup btnQnaGroup">
      <c:choose>
      <c:when test="${empty qna}">
      	<input type="button" class="btnAdminCsDel btnDel" value="삭제" />
        <input type="button" class="btnAdminCsDel btnMod" value="수정" />
        <input type="button" class="btnAdminCsWri btnList" value="등록하기" />
      </c:when>
      <c:otherwise>
      	<input type="button" class="btnAdminCsDel btnDel" value="삭제" />
        <input type="button" class="btnAdminCsWri btnWri" value="답변등록" />
        <input type="button" class="btnAdminCsWri btnList" value="목록" />
      </c:otherwise>
      </c:choose>
      </div>
    </section>
  </section>
</main>
<jsp:include page="../_footer.jsp"/>