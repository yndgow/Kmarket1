<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
<section id="cs">
            <div class="qna">
                <nav>
                    <div>
                        <p>홈<span>></span>문의하기</p>
                    </div>
                </nav>
                <jsp:include page="./cate/_cate${cate1}.jsp"/>
				 <table>
                  <c:forEach var="article" items="${articles}">
                      <tr>
                          <td><a href="./view.do?qnaNo=${article.qnaNo}&cate1=${cate1}">[${article.c2Name}] ${article.qnaTitle}</a></td>
                          <td class="uid">${article.uid}</td>
                          <td>${article.qnaCond}</td>
                          <td>${article.rdate.substring(2, 10)}</td>
                      </tr>
                  </c:forEach>
                  </table>
                  <div class="page">
                  	  <c:if test="${pageGroupStart > 1}">
                      <a href="/Kmarket/cs/qna/list.do?pg=${pageGroupStart - 1}" class="prev">이전</a>
                  	  </c:if>
                  	  <c:forEach var="num" begin="${pageGroupStart}" end="${pageGroupEnd}">
                      <a href="/Kmarket/cs/qna/list.do?pg=${num}&cate1=${cate1}" class="num ${num == currentPage ? 'on':'off'}">${num}</a>
                  	  </c:forEach>
                  	  <c:if test="${pageGroupEnd < lastPageNum}">
                      <a href="/Kmarket/cs/qna/list.do?pg=${pageGroupEnd + 1}" class="next">다음</a>
                  	  </c:if>
                  </div>
                  <a href="./write.do?cate1=${cate1}" class="btnWrite">문의하기</a>
              </article>
          </section>
      </div>
</section>
<jsp:include page="../_footer.jsp"/>
