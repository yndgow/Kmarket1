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
    <input type="hidden" name="writeCate1" value="${faq.cate1}"/>
	<input type="hidden" name="writeCate2" value="${faq.cate2}" />
      <table class="update">
        <tr>
          <th>유형</th>
          <td>
           <select name="cate1">
              <option value="0">1차유형</option>
				<c:forEach var="cate1" items="${cate1List}">
					<option value="${cate1.cate1}" ${cate1.cate1 eq faq.cate1 ? 'selected="selected"' : ''}>${cate1.c1Name}</option>
            	</c:forEach>
            </select>
            <select name="cate2" class="cate3">
				<option value="0">2차유형</option>
				<c:forEach var="cate2" items="${cateList}">
					<c:if test="${cate2.cate2 eq faq.cate2}">
               			<option value="${cate2.cate2}" ${cate2.cate2 eq faq.cate2 ? 'selected="selected"' : ''}>${cate2.c2Name}</option>
               		</c:if>
            	</c:forEach>
           </select>
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
        <input type="button" class="btnAdminCsWri btnSubmitNotice" value="수정하기" />
      </div>
    </section>
  </section>
</main>
<jsp:include page="../_footer.jsp"/>