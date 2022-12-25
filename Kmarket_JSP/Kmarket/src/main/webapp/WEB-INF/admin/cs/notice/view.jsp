<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
  <section id="admin-notice-list">
    <nav>
      <h3>공지사항 보기</h3>
      <p>HOME > 고객센터 > <strong>공지사항</strong></p>
    </nav>
    <section>
    
      <table class="update adminCsmodify">
        <tr>
          <th>유형</th>
          <td>${article.c1Name}&nbsp;</td>
        </tr>
        <tr>
          <th>제목</th>
          <td>${article.notTitle}</td>
        </tr>
        <tr>
          <th>내용</th>
          <td>${article.notContent}</td>
        </tr>
      
      </table>
      <div class="btnGroup btnQnaGroup">
      <input type="hidden" name="notNo" value="${article.notNo}">
      
      
      <input type="button" class="btnAdminCsDel btnDeleteNot" value="삭제" />
      <input type="button" id="${article.notNo}" class="btnAdminCsDel btnModifyNot" value="수정" />
	  <input type="button" class="btnAdminCsWri btnList" value="목록" />
      </div>
    </section>
  </section>
</main>
<jsp:include page="../_footer.jsp"/>