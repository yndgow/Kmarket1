<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>케이마켓 고객센터</title>
    <link rel="stylesheet" href="/Kmarket/css/cs/style.css">
    <link rel="shortcut icon" type="image/x-icon" href="/Kmarket/img/member/favicon.ico" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
    <script>
      $(() => {
    	  $('.more').click(function (e) {
    	        e.preventDefault();
    	        let status = $(this).prev().css('display') === 'none';
    	      if (status) {
    	        $(this).siblings('li:nth-child(n+4)').css('display','block');
    	        $(this).children('a').text('간단히 보기');
    	      } else{
    	        $(this).siblings('li:nth-child(n+4)').css('display','none');
    	        $(this).children('a').text('더 보기');
    	      }
    	    });
      });
    </script>
    
  
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