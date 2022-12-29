<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
<script src="/Kmarket/js/admin/cs/script_kjh.js"></script>
<input type="hidden" name="writeCate1" value="${cate1}" />
<input type="hidden" name="writeCate2" value="${cate2}" />
  <section id="admin-product-list">
    <nav>
      <h3>${csTxt} 작성</h3>
      <p>HOME > 고객센터 > <strong>공지사항</strong></p>
    </nav>
    <section>
    
    <form action="/Kmarket/admin/cs/write.do" id="faqForm" method="post">
    <input type="hidden" name="csType" value="${csType}"/>
      <table class="update">
        <tr>
          <th>유형</th>
          <td>
            <select name="cate1">
              <option value="0">1차유형</option>
			<c:forEach var="cate1" items="${cate1List}">
               <option value="${cate1.cate1}">${cate1.c1Name}</option>
            </c:forEach>
            </select>
           <select name="cate2" class="cate3">
               <option value="0">2차유형</option>
           </select>
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td><input type="text" name="title" id="title" required="required"/></td>
        </tr>
        <tr>
          <th>내용</th>
          <td><textarea name="content" id="content" required="required"></textarea></td>
        </tr>
      </table>
      </form>
      <div class="btnGroup">
        <input type="button" class="btnAdminCsDel btnCancle" value="취소" />
        <input type="button" class="btnAdminCsWri btnWriteFaq" value="등록하기" />
      </div>
    </section>
  </section>
</main>
<jsp:include page="../_footer.jsp"/>