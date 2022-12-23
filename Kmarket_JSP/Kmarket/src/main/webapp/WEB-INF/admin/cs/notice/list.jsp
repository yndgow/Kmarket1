<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
<<script>
	$(function(){
		$('.btnWriteNotice').click(function(){
			location.href = '/Kmarket/admin/cs/notice/write.do';
		});
	});
</script>

<section id="admin-notice-list">
    <nav>
      <h3>공지사항 목록</h3>
      <p>HOME > 고객센터 > <strong>공지사항</strong></p>
    </nav>
     <section>
       <div class="csSelectDiv">
           <select name="cate1">
               <option value="0">유형선택</option>
               <option value="all">전체</option>
	           <option value="service">고객서비스</option>
	     	   <option value="deal">안전거래</option>
	    	   <option value="danger">위해상품</option>
	    	   <option value="lucky">이벤트당첨</option>
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
           <c:forEach var="article" items="${allArticles}">
                <tr>
                	<td><input type="checkbox" name="noticeCheck"></td>
                	<td>${article.notNo}</td>
                	<td>${article.c1Name}</td>
                    <td><a href="./view.do?notNo=${article.notNo}">${article.notTitle}</a></td>
                    <td>${article.hit}</td>
                    <td>${article.rdate.substring(2, 10)}</td>
                    <td>
	                   <a href="#" class="btnDeleteNotice">[삭제]</a>
	                   <a href="#" class="btnModifyNotice">[수정]</a>
	               </td>
                </tr>
            </c:forEach>
       </table>

       <input type="button" class="btnAdminCsDel btnDeleteSelected" value="선택삭제">
       <input type="button" class="btnAdminCsWri btnWriteNotice" value="작성하기">
       
        <div class="paging">
       	   <c:if test="${pageGroupStart > 1}">	
           <span class="prev">
               <a href="/Kmarket/admin/cs/notice/list.do?pg=${pageGroupStart-1}">&nbsp;이전</a>
           </span>
           </c:if>
           <c:forEach var="num" begin="${pageGroupStart}" end="${pageGroupEnd}">
           <span class="num ${num == currentPage ? 'current' : 'off'}">
               <a href="/Kmarket/admin/cs/notice/list.do?pg=${num}">${num}</a>
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