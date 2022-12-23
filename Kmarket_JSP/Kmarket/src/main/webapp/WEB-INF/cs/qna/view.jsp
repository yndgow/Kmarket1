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
			<section class="view">
              <article>
                  <nav>
                      <h2 class="title">[${article.c2Name}] ${article.qnaTitle}</h2>
                      <p>
                          <span class="uid">${article.uid}</span>
                          <span>${article.rdate.substring(2, 10)}</span>
                      </p>
                  </nav>
                  <div class="content">
                      <p>${article.qnaContent}</p>
                  </div>
                  <c:choose>
                  	<c:when test="${not empty article.answer}">
	   				  <div class="answer">
	                      <h2 class="title">☞ [답변] ${article.qnaTitle}</h2>
	                      <p class="content">${article.answer}</p>
					  </div>
                  	</c:when>
                  </c:choose>
                  <a href="./list.do?cate1=${cate1}" class="btnList">목록보기</a>
              </article>
          </section>
      </div>
</section>
<jsp:include page="../_footer.jsp"/>