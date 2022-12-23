<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>

        <section id="cs">
            <div class="faq">
                <nav>
                    <div>
                        <p>홈<span>></span>자주묻는 질문</p>
                    </div>
                </nav>
                <section class="view">
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
                            <h2 class="title">
                                <span>Q.</span>
                                ${article.faTitle}
                            </h2>
                        </nav>
                        <div class="content">
                            <p>
                                ${article.faContent }
                            </p>
                        </div>
                        <a href="/Kmarket/cs/faq/list.do?cate1=${article.cate1}" class="btnList">목록보기</a>
                    </article>
                </section>
            </div>
      </section>
      <jsp:include page="../_footer.jsp"/>