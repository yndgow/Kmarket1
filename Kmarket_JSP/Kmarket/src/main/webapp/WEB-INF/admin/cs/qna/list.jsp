<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
<script src="/Kmarket/js/admin/cs/script_kjh.js"></script>
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
  <input type="hidden" name="csType" value="${csType}">
    <nav>
      <h3>${csTxt} 목록</h3>
      <p>HOME > 고객센터 > <strong>${csTxt}</strong></p>
    </nav>
     <section>
       <div class="csSelectDiv">
             <select name="cate1">
               <option value="0">1차유형</option>
			<c:forEach var="cate1" items="${cate1List}">
               <option value="${cate1.cate1}">${cate1.c1Name}</option>
            </c:forEach>
           </select>
           <select name="cate2" class="cate2">
               <option value="0">2차유형</option>
           </select>
       </div>
       <table class="cs">
           <tr>
               <th><input type="checkbox" name="all"></th>
               <th>번호</th>
               <th>1차유형</th>
               <th>2차유형</th>
               <th>제목</th>
               <th>작성자</th>
               <th>작성일</th>
               <th>상태</th>
           </tr>
           <c:forEach var="qna" items="${qnaList}">
           <tr>
               <td><input type="checkbox" name="faqCheck" value="${qna.qnaNo}"></td>
               <td>${pageStartNum = pageStartNum-1}</td>
               <td class="c1NameTd">${qna.c1Name}</td>
               <td class="c2NameTd">${qna.c2Name}</td>
               <td><a href="/Kmarket/admin/cs/qna/view.do?no=${qna.qnaNo}&csType=${csType}&cate1=${qna.cate1}&cate2=${qna.cate2}">${qna.qnaTitle}</a></td>
               <td>${qna.uid}</td>
               <td>${qna.rdate}</td>
               <td>${qna.qnaCond}</td>
           </tr>
           </c:forEach>

       </table>

       <input type="button" class="btnAdminCsDel btnDeleteSelected" value="선택삭제">
       <!-- <input type="button" class="btnAdminCsWri btnWriteNotice" value="작성하기"> -->
       
        <div class="paging">
        	<c:if test="${pageGroupStart > 1}">
           <span class="prev">
               <a href="/Kmarket/admin/cs/qna/list.do?csType=${csType}&cate1=${cate1}&cate2=${cate2}&pg=${pageGroupStart-1}">&nbsp;이전</a>
           </span>
           </c:if>
           <c:forEach var="num" begin="${pageGroupStart}" end="${pageGroupEnd}">
           <span class="num ${num == currentPage ? 'current' : 'off'}">
               <a href="/Kmarket/admin/cs/qna/list.do?csType=${csType}&cate1=${cate1}&cate2=${cate2}&pg=${num}">${num}</a>
           </span>
           </c:forEach>
           <c:if test="${pageGroupEnd < lastPageNum}">
           <span class="next">
               <a href="/Kmarket/admin/cs/qna/list.do?csType=${csType}&cate1=${cate1}&cate2=${cate2}&pg=${pageGroupEnd+1}">다음&nbsp;</a>
           </span>
           </c:if>
       </div>
   </section>
  </section>
</main>
<jsp:include page="../_footer.jsp"/>