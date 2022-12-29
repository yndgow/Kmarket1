<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
        <section id="cs">
            <div class="notice">
                <nav>
                    <div>
                        <p>홈<span>></span>공지사항</p>
                    </div>
                </nav>
                <section class="list">
                    <aside>
                        <h2>공지사항</h2>
                        <ul>
                            <li class="${cate1 eq null?'on':'off'}"><a href="/Kmarket/cs/notice/list.do">전체</a></li>
                            <li class="${cate1 eq 1?'on':'off'}"><a href="/Kmarket/cs/notice/list.do?cate1=1">고객서비스</a></li>
                            <li class="${cate1 eq 2?'on':'off'}"><a href="/Kmarket/cs/notice/list.do?cate1=2">안전거래</a></li>
                            <li class="${cate1 eq 3?'on':'off'}"><a href="/Kmarket/cs/notice/list.do?cate1=3">위해상품</a></li>
                            <li class="${cate1 eq 4?'on':'off'}"><a href="/Kmarket/cs/notice/list.do?cate1=4">이벤트당첨</a></li>
                        </ul>
                    </aside>
                    <article>
                        <nav>
                        	<c:if test="${cate1 eq null }">
                            <h1>전체</h1>
                            <h2>공지사항 전체 내용 입니다.</h2>
                            </c:if>
                            
                            <c:if test="${cate1 eq 1 }">
                            <h1>고객서비스</h1>
                            <h2>공지사항 고객서비스 내용 입니다.</h2>
                            </c:if>
                            
                            <c:if test="${cate1 eq 2 }">
                            <h1>안전거래</h1>
                            <h2>공지사항 안전거래 내용 입니다.</h2>
                            </c:if>
                            
                            <c:if test="${cate1 eq 3 }">
                            <h1>위해상품</h1>
                            <h2>공지사항 위해상품 내용 입니다.</h2>
                            </c:if>
                            
                            <c:if test="${cate1 eq 4 }">
                            <h1>이벤트당첨</h1>
                            <h2>공지사항 이벤트당첨 내용 입니다.</h2>
                            </c:if>
                        </nav>
                        <table>
                        	<c:forEach var="article" items="${articles}">
			                            <tr>
			                                <td><a href="/Kmarket/cs/notice/view.do?notNo=${article.notNo }&cate1=${article.cate1}">${article.notTitle}</a></td>
			                                <td>${article.rdate.substring(2, 10)}</td>
			                            </tr>
                        	</c:forEach>
                        </table>
                      
                          <div class="page">
				        	<c:if test="${pageGroupStart > 1}">
				            <a href="/Kmarket/cs/notice/list.do?pg=${pageGroupStart - 1}" class="prev">이전</a>
				            </c:if>
				            <c:forEach var="num" begin="${pageGroupStart}" end="${pageGroupEnd}">
				            <c:choose>
				            <c:when test="${cate1 eq null }">
				            <a href="/Kmarket/cs/notice/list.do?pg=${num}" class="num ${num == currentPage ? 'on':'off'}">${num}</a>
				             </c:when>
				             <c:otherwise>
				             <a href="/Kmarket/cs/notice/list.do?pg=${num}&cate1=${cate1}" class="num ${num == currentPage ? 'on':'off'}">${num}</a>
				             </c:otherwise>
				             </c:choose>
				            </c:forEach>
				            <c:if test="${pageGroupEnd < lastPageNum}">
				            <a href="/Kmarket/cs/notice/list.do?pg=${pageGroupEnd + 1}" class="next">다음</a>
				            </c:if>
				        </div>
                    </article>
                </section>
            </div>
        </section>
<jsp:include page="../_footer.jsp"/>