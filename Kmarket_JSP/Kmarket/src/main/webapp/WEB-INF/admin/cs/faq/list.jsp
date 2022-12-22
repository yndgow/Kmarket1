<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
<script src="/Kmarket/js/admin/cs/script_kjh.js"></script>
  <section id="admin-product-list">
  <input type="hidden" name="csType" value="${csType}">
  <input type="hidden" name="wriCate1" value="${cate1}">
  <input type="hidden" name="wriCate2" value="${cate2}">
    <nav>
      <h3>자주묻는질문 목록</h3>
      <p>HOME > 고객센터 > <strong>자주묻는질문</strong></p>
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
               <th>조회</th>
               <th>날짜</th>
               <th>관리</th>
           </tr>
           <c:forEach var="faq" items="${faqList}">
           <tr>
               <td><input type="checkbox" name="faqCheck" value="${faq.faNo}"></td>
               <td>${faq.faNo}</td>
               <td class="c1NameTd">${faq.c1Name}</td>
               <td class="c2NameTd">${faq.c2Name}</td>
               <td><a href="/Kmarket/admin/cs/faq/view.do?no=${faq.faNo}&csType=${csType}&cate1=${faq.cate1}&cate2=${faq.cate2}">${faq.faTitle}</a></td>
               <td>${faq.hit}</td>
               <td>${faq.rdate}</td>
               <td>
                   <a href="/Kmarket/admin/cs/delete.do?faNo=${faq.faNo}" class="btnDeleteFaq">[삭제]</a>
                   <a href="/Kmarket/admin/cs/faq/modify.do?faNo=${faq.faNo}&csType=${csType}&cate1=${faq.cate1}&cate2=${faq.cate2}">[수정]</a>
               </td>
           </tr>
           </c:forEach>

       </table>
	   
       <input type="button" class="btnAdminCsDel btnDeleteSelected" value="선택삭제">
       <input type="button" class="btnAdminCsWri btnWriteCs" value="작성하기">
      
       
   </section>
  </section>
</main>
<jsp:include page="../_footer.jsp"/>