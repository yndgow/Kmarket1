<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./_header.jsp"/>
<section class="view">
              <aside>
                  <h2>문의하기</h2>
                  <ul>
                      <li class="on"><a href="#">회원</a></li>
                      <li><a href="#">쿠폰/이벤트</a></li>
                      <li><a href="#">주문/결제</a></li>
                      <li><a href="#">배송</a></li>
                      <li><a href="#">취소/반품/교환</a></li>
                      <li><a href="#">여행/숙박/항공</a></li>
                      <li><a href="#">안전거래</a></li>
                  </ul>
              </aside>
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
                  <a href="./list.do" class="btnList">목록보기</a>
              </article>
          </section>
      </div>
</section>
<jsp:include page="./_footer.jsp"/>