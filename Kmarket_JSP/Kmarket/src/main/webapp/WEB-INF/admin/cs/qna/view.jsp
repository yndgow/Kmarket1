<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
<script src="/Kmarket/js/admin/cs/script_kjh.js"></script>

  <section id="admin-product-list">
    <nav>
      <h3>문의하기 답변</h3>
      <p>HOME > 고객센터 > <strong>${csTxt}</strong></p>
    </nav>
    <section>
    
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
          <td><textarea name="answer" id="content">${qna.answer}</textarea></td>
        </tr>
      </table>
      <div class="btnGroup btnQnaGroup">
      <input type="hidden" name="wriCate1" value="${cate1}" />
	  <input type="hidden" name="wriCate2" value="${cate2}" />
      <input type="hidden" name="csType" value="${csType}"/>
      <input type="hidden" name="qnaNo" value="${qna.qnaNo}"/>

   	  <input type="button" class="btnAdminCsDel btnDelQna" value="삭제" />
      <input type="button" class="btnAdminCsWri btnUpdQna" value="답변등록" />
      <input type="button" class="btnAdminCsWri btnList" value="목록" />

      </div>
    </section>
  </section>
</main>
<jsp:include page="../_footer.jsp"/>