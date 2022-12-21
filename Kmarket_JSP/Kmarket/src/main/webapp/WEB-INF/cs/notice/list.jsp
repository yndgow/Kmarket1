<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>케이마켓 고객센터</title>
    <link rel="stylesheet" href="/Kmarket/css/cs/style.css">
</head>
<body>
    <div id="wrapper">
        <header>
            <div class="top">
                <div>
                    <p>
                        <a href="/Kmarket/member/login.do">로그인</a>
                        <a href="/Kmarket/member/register.do">회원가입</a>
                        <a href="#">마이페이지</a>
                        <a href="#"><i class="fa fa-shopping-cart" aria-hidden="true"></i>장바구니</a>
                    </p>
                </div>
            </div>
            <div class="logo">
                <div>
                    <a href="/Kmarket/cs/index.do">
                        <img src="/Kmarket/img/cs/logo.png" alt="로고">
                        고객센터
                    </a>
                </div>
            </div>
        </header>
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
				            <a href="/Kmarket/cs/notice/list.do?pg=${num}" class="num ${num == currentPage ? 'current':'off'}">${num}</a>
				            </c:forEach>
				            <c:if test="${pageGroupEnd < lastPageNum}">
				            <a href="/Kmarket/cs/notice/list.do?pg=${pageGroupEnd + 1}" class="next">다음</a>
				            </c:if>
				        </div>
                    </article>
                </section>
            </div>
        </section>
        <footer>
            <ul>
              <li><a href="#">회사소개</a></li>
              <li><a href="#">서비스이용약관</a></li>
              <li><a href="#">개인정보처리방침</a></li>
              <li><a href="#">전자금융거래약관</a></li>
            </ul>
            <div>
              <p><img src="/Kmarket/img/cs/footer_logo.png" alt="로고" /></p>
              <p>
                <strong>(주)KMARKET</strong><br />
                부산시 강남구 테헤란로 152 (역삼동 강남파이낸스센터)<br />
                대표이사 : 홍길동<br />
                사업자등록번호 : 220-81-83676 사업자정보확인<br />
                통신판매업신고 : 강남 10630호 Fax : 02-589-8842
              </p>
              <p>
                <strong>고객센터</strong><br />
                Tel : 1234-5678 (평일 09:00~18:00)<br />
                스마일클럽/SVIP 전용 : 1522-5700 (365일 09:00~18:00)<br />
                경기도 부천시 원미구 부일로 223(상동) 투나빌딩 6층<br />
                Fax : 051-123-4567 | Mail : kmarket@kmarket.co.kr<br />
              </p>
            </div>
          </footer>
    </div>
</body>
</html>