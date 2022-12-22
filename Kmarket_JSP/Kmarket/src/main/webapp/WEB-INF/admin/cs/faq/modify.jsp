<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
<script src="/Kmarket/js/admin/cs/script_kjh.js"></script>

  <section id="admin-product-list">
    <nav>
      <h3>자주묻는질문 수정</h3>
      <p>HOME > 고객센터 > <strong>자주묻는질문</strong></p>
    </nav>
    <section>
    
    <form action="/Kmarket/admin/cs/faq/modify.do" id="faqForm" method="post">
    <input type="hidden" name="faNo" value="${faq.faNo}"/>
    <input type="hidden" name="csType" value="${csType}"/>
    <input type="hidden" name="writeCate1" value="${cate1}"/>
	<input type="hidden" name="writeCate2" value="${cate2}" />
      <table class="update">
        <tr>
          <th>유형</th>
          <td>
            ${faq.c1Name}&nbsp;${faq.c2Name}
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td><input type="text" name="title" id="title" value="${faq.faTitle}"/></td>
        </tr>
        <tr>
          <th>내용</th>
          <td><textarea name="content" id="content">${faq.faContent}</textarea></td>
        </tr>
      </table>
      </form>
      <div class="btnGroup">
        <input type="button" class="btnAdminCsDel btnCancle" value="취소" />
        <input type="button" class="btnAdminCsWri btnSubmit" value="등록하기" />
      </div>
    </section>
  </section>
</main>
<jsp:include page="../_footer.jsp"/>