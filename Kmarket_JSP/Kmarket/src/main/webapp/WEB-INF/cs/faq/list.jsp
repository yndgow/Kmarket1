<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>

    <script>
    // 더보기 구현
      $(() => {
    	  $('.more').click(function (e) {
    	        e.preventDefault();
    	        let status = $(this).prev().css('display') === 'none';
    	      if (status) {
    	        $(this).siblings('li:nth-child(n+4)').css('display','block');
    	        $(this).children('a').text('간단히 보기');
    	      } else{
    	        $(this).siblings('li:nth-child(n+4)').css('display','none');
    	        $(this).children('a').text('더보기');
    	      }
    	    });
      });
    </script>

        <section id="cs">
            <div class="faq">
                <nav>
                    <div>
                        <p>홈<span>></span>자주묻는 질문</p>
                    </div>
                </nav>
               <section class="list">
                    <aside>
                        <h2>자주묻는 질문</h2>
                        <ul>
                            <li class="${cate1 eq 1?'on':'off'}"><a href="/Kmarket/cs/faq/list.do?cate1=1">회원</a></li>
                            <li class="${cate1 eq 2?'on':'off'}"><a href="/Kmarket/cs/faq/list.do?cate1=2">쿠폰/이벤트</a></li>
                            <li class="${cate1 eq 3?'on':'off'}"><a href="/Kmarket/cs/faq/list.do?cate1=3">주문/결제</a></li>
                            <li class="${cate1 eq 4?'on':'off'}"><a href="/Kmarket/cs/faq/list.do?cate1=4">배송</a></li>
                            <li class="${cate1 eq 5?'on':'off'}"><a href="/Kmarket/cs/faq/list.do?cate1=5">취소/반품/교환</a></li>
                            <li class="${cate1 eq 6?'on':'off'}"><a href="/Kmarket/cs/faq/list.do?cate1=6">여행/숙박/항공</a></li>
                            <li class="${cate1 eq 7?'on':'off'}"><a href="/Kmarket/cs/faq/list.do?cate1=7">안전거래</a></li>
                        </ul>
                    </aside>
                    <article>
                        	<nav>
                        		<c:if test="${cate1 eq 1 }">
	                            <h1>회원</h1>
	                            <h2>가장 자주 묻는 질문입니다.</h2>
	                            </c:if>
	                            
	                            <c:if test="${cate1 eq 2 }">
	                            <h1>쿠폰/이벤트</h1>
	                            <h2>가장 자주 묻는 질문입니다.</h2>
	                            </c:if>
	                            
	                             <c:if test="${cate1 eq 3 }">
	                            <h1>주문/결제</h1>
	                            <h2>가장 자주 묻는 질문입니다.</h2>
	                            </c:if>
	                            
	                             <c:if test="${cate1 eq 4 }">
	                            <h1>배송</h1>
	                            <h2>가장 자주 묻는 질문입니다.</h2>
	                            </c:if>
	                            
	                             <c:if test="${cate1 eq 5 }">
	                            <h1>취소/반품/교환</h1>
	                            <h2>가장 자주 묻는 질문입니다.</h2>
	                            </c:if>
	                            
	                             <c:if test="${cate1 eq 6 }">
	                            <h1>여행/숙박/항공</h1>
	                            <h2>가장 자주 묻는 질문입니다.</h2>
	                            </c:if>
	                            
	                             <c:if test="${cate1 eq 7 }">
	                            <h1>안전거래</h1>
	                            <h2>가장 자주 묻는 질문입니다.</h2>
	                            </c:if>
	                            
                       		</nav>
                       		<c:forEach var="cate" items="${cates}">
                        <div>
                            <h3>${cate.c2Name}</h3>
                            <ul>
                            	<c:forEach var="article" items="${articles}">
                            	<c:if test="${cate.c2Name eq article.c2Name }">
                                <li class="item">
                                    <a href="/Kmarket/cs/faq/view.do?faNo=${article.faNo }&cate1=${article.cate1}&cate2=${article.cate2}">
                                        <span>Q.</span>${article.faTitle }
                                    </a>
                                </li>
                                </c:if>
                            	</c:forEach>
                                <li class="more">
                                    <a href="#">더보기</a>
                                </li>
                            </ul>
                            
                        </div>
                        </c:forEach>
                        
                        
                    </article>
                </section>
            </div>
      </section>
      <jsp:include page="../_footer.jsp"/>