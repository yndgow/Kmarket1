<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>케이마켓 고객센터</title>
    <link rel="stylesheet" href="/Kmarket/css/cs/style.css">
    <link rel="icon" href="data:;base64,iVBORw0KGgo=">
</head>
<body>
    <div id="wrapper">
        <header>
            <div class="top">
                <div>
                    <p>
                        <a href="#">로그인</a>
                        <a href="#">회원가입</a>
                        <a href="#">마이페이지</a>
                        <a href="#"><i class="fa fa-shopping-cart" aria-hidden="true"></i>장바구니</a>
                    </p>
                </div>
            </div>
            <div class="logo">
                <div>
                    <a href="/cs/index.do">
                        <img src="/Kmarket/img/cs/logo.png" alt="로고">
                        고객센터
                    </a>
                </div>
            </div>
        </header>
        <section id="cs">
            <div class="main">
                <h1 class="title"><strong>케이마켓</strong>이 도와드릴게요!</h1>
                <section class="notice">
                    <h1>공지사항<a href="./notice/list.do">전체보기</a></h1>
                    <ul>
                        <li>
                            <a href="#" class="title">[안내] 해외결제 사칭 문자 주의</a>
                            <span class="date">22.10.31</span>
                        </li>
                        <li>
                            <a href="#" class="title">[안내] 해외결제 사칭 문자 주의</a>
                            <span class="date">22.10.31</span>
                        </li>
                        <li>
                            <a href="#" class="title">[안내] 해외결제 사칭 문자 주의</a>
                            <span class="date">22.10.31</span>
                        </li>
                        <li>
                            <a href="#" class="title">[안내] 해외결제 사칭 문자 주의</a>
                            <span class="date">22.10.31</span>
                        </li>
                        <li>
                            <a href="#" class="title">[안내] 해외결제 사칭 문자 주의</a>
                            <span class="date">22.10.31</span>
                        </li>
                    </ul>
                </section>
                <section class="faq">
                    <h1>자주 묻는 질문<a href="/Kmarket/cs/faq/list.do?cate1=1">전체보기</a></h1>
                    <ol>
                        <li>
                            <a href="#"><span>회원</span></a>
                        </li>
                        <li>
                            <a href="#"><span>쿠폰/이벤트</span></a>
                        </li>
                        <li>
                            <a href="#"><span>주문/결제</span></a>
                        </li>
                        <li>
                            <a href="#"><span>배송</span></a>
                        </li>
                        <li>
                            <a href="#"><span>취소/반품/교환</span></a>
                        </li>
                        <li>
                            <a href="#"><span>여행/숙박/항공</span></a>
                        </li>
                        <li>
                            <a href="#"><span>안전거래</span></a>
                        </li>
                    </ol>
                </section>
                <section class="qna">
                    <h1>문의하기<a href="./qna/list.do?cate1=1">전체보기</a></h1>
                    <ul>
                    	<c:forEach var="article" items="${articles}">
                        <li>
                            <a href="./qna/view.do?qnaNo=${article.qnaNo}" class="title">[${article.c2Name}]${article.qnaTitle}</a>
                            <p>
                                <span class="uid">${article.uid}</span>
                                <span class="date">${article.rdate.substring(2, 10)}</span>
                            </p>
                        </li>
                        </c:forEach>
                    </ul>
                    <a href="./qna/write.do" class="ask">문의글 작성 ></a>
                </section>
                <section class="tel">
                    <h1>1:1 상담이 필요하신가요?</h1>
                    <article>
                        <div>
                            <h3>고객센터 이용안내</h3>
                            <p>
                                <span>일반회원/비회원</span>
                                <br>
                                <strong>1566-0001</strong>
                                <span>(평일 09:00 ~ 18:00)</span>
                            </p>
                            <p>
                                <span>스마일클럽 전용</span>
                                <br>
                                <strong>1566-0002</strong>
                                <span>(365일 09:00 ~ 18:00)</span>
                            </p>
                        </div>
                    </article>
                    <article>
                        <div>
                            <h3>판매상담 이용안내</h3>
                            <p>
                                <span>판매고객</span>
                                <br>
                                <strong>1566-5700</strong>
                                <span>(평일 09:00 ~ 18:00)</span>
                            </p>
                            <p>
                                <a href="#">판매자 가입 및 서류 접수 안내 〉</a>
                            </p>
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