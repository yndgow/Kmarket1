<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
<section id="admin-notice-list">
    <nav>
      <h3>공지사항 목록</h3>
      <p>HOME > 고객센터 > <strong>공지사항</strong></p>
    </nav>
     <section>
       <div class="csSelectDiv">
       		
           <select name="cate1" id="selNot">
           		<option value="0">1차유형</option>
           <c:choose>
       			<c:when test="${cate1 eq 1}">
	            	<option value="1" selected>고객서비스</option>
	            	<option value="2">안전거래</option>
	            	<option value="3">위해상품</option>
	            	<option value="4">이벤트 당첨</option>
            	</c:when>
	            <c:when test="${cate1 eq 2}">
	            	<option value="1">고객서비스</option>
	            	<option value="2" selected>안전거래</option>
	            	<option value="3">위해상품</option>
	            	<option value="4">이벤트 당첨</option>
            	</c:when>
	            <c:when test="${cate1 eq 3}">
	            	<option value="1">고객서비스</option>
	            	<option value="2">안전거래</option>
	            	<option value="3" selected>위해상품</option>
	            	<option value="4">이벤트 당첨</option>
            	</c:when>
	            <c:when test="${cate1 eq 4}">
	            	<option value="1">고객서비스</option>
	            	<option value="2">안전거래</option>
	            	<option value="3">위해상품</option>
	            	<option value="4" selected>이벤트 당첨</option>
            	</c:when>
            	<c:otherwise>
		           	<option value="1">고객서비스</option>
		     	   	<option value="2">안전거래</option>
		    	   	<option value="3">위해상품</option>
		    	   	<option value="4">이벤트당첨</option>
       			</c:otherwise>
       		</c:choose>
               
           </select>
       </div>
       <table class="cs">
           <tr>
               <th><input type="checkbox" name="all"></th>
               <th>번호</th>
               <th>유형</th>
               <th>제목</th>
               <th>조회</th>
               <th>날짜</th>
               <th>관리</th>
           </tr>
           <c:forEach var="article" items="${articles}">
                <tr>
                	<td><input type="checkbox" name="noticeCheck" value="${article.notNo}"></td>
                	<td>${article.notNo}</td>
                	<td>${article.c1Name}</td>
                    <td><a href="./view.do?cate1=${cate1}&notNo=${article.notNo}">${article.notTitle}</a></td>
                    <td>${article.hit}</td>
                    <td>${article.rdate.substring(2, 10)}</td>
                    <td>
	                   <a href="#" id="${article.notNo}" class="btnDeleteNot">[삭제]</a>
	                   <a href="#" id="${article.notNo}" class="btnModifyNot">[수정]</a>
	               </td>
                </tr>
            </c:forEach>
       </table>

       <input type="button" class="btnAdminCsDel btnDeleteSelectedNot" value="선택삭제">
       <input type="button" class="btnAdminCsWri btnWriteNotice" value="작성하기">
       
        <div class="paging">
       	   <c:if test="${pageGroupStart > 1}">	
           <span class="prev">
               <a href="/Kmarket/admin/cs/notice/list.do?pg=${pageGroupStart-1}">&nbsp;이전</a>
           </span>
           </c:if>
           <c:forEach var="num" begin="${pageGroupStart}" end="${pageGroupEnd}">
           <span class="num ${num == currentPage ? 'current' : 'off'}">
               <a href="/Kmarket/admin/cs/notice/list.do?cate1=${cate1}&pg=${num}">${num}</a>
           </span>
           </c:forEach>
           <c:if test="${pageGroupEnd < lastPageNum}">
           <span class="next">
               <a href="/Kmarket/admin/cs/notice/list.do?pg=${pageGroupEnd+1}">다음&nbsp;</a>
           </span>
           </c:if>
       </div>
   </section>
  </section>
</main>
<jsp:include page="../_footer.jsp"/>