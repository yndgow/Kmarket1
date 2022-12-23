<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../_header.jsp"/>
        <section id="cs">
            <div class="notice">
                <nav>
                    <div>
                        <p>홈<span>></span>공지사항</p>
                    </div>
                </nav>
                <section class="view">
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
                            <h4 class="title">${article.notTitle }</h4>
                            <span class="date">${article.rdate.substring(0, 10)}</span>
                        </nav>
                        <div class="content">
                            <p>
                               ${article.notContent }
                            </p>
                        </div>
                        <a href="/Kmarket/cs/notice/list.do?cate1=${article.cate1}" class="btnList">목록</a>
                   </article>
                </section>
            </div>
        </section>
<jsp:include page="../_footer.jsp"/>