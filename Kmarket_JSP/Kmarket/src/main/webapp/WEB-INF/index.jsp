<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>KMarket::index</title>
    <script src="https://kit.fontawesome.com/e8f010a863.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="crossorigin="anonymous"></script>
    <link rel="icon" href="data:;base64,iVBORw0KGgo=">
    <link rel="stylesheet" href="./css/style.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <!-- bxSlider css,js file -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css"/>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
    <script src="/Kmarket/js/index/js.js"></script>
  </head>
  <body>
    <div class="wrapper">
      <!-- 헤더시작 -->
      <header>
        <div class="top">
          <div>
          	<c:choose>
				<c:when test="${empty sessUser}">
					<a href="/Kmarket/member/login.do">로그인</a>
					<a href="/Kmarket/member/join.do">회원가입</a>
				</c:when>
				<c:otherwise>
					<!-- 삭제 예정 시작-->
					<a href="" class="sessUser_uid">${sessUser.uid}</a>
					<!-- 삭제 예정 끝-->
					<input type="hidden" class="uid" value="${sessUser.uid}"/>
					<c:set var="uid" value="${sessUser.uid}"/>
					<c:choose>
						<c:when test="${sessUser.level eq 7}">
							<a href="/Kmarket/admin/index.do?uid=${uid}">관리자</a>
						</c:when>
						<c:when test="${sessUser.level eq 5}">
							<a href="/Kmarket/admin/index.do?uid=${uid}">사업자</a>
						</c:when>
					</c:choose>
					<a href="/Kmarket/member/logout.do">로그아웃</a>
					<a href="">마이페이지</a>
				</c:otherwise>
            </c:choose>
           
            <a href="/Kmarket/product/cart.do?uid=${sessUser.uid}"><i class="fa-solid fa-cart-shopping" aria-hidden="true"></i>&nbsp;장바구니</a>
          </div>
        </div>
        <div class="logo">
          <div>
            <a href="/Kmarket/">
              <img src="./img/header_logo.png" alt="헤더로고" />
            </a>
            <form action="" class="search">
              <input type="text" name="search" />
              <button id="search">
                <i class="fa-solid fa-magnifying-glass"></i>
              </button>
            </form>
          </div>
        </div>
        <!-- member, cs 는 필요 없는 부분 시작 -->
        <div class="menu">
          <div>
            <ul>
              <li><a href="#" class="scrollBtnHit">히트상품</a></li>
              <li><a href="#" class="scrollBtnScore">추천상품</a></li>
              <li><a href="#" class="scrollBtnNew">최신상품</a></li>
              <li><a href="#" class="scrollBtnDis">할인상품</a></li>
            </ul>
		 	<ul>
	          <li><a href="/Kmarket/cs/notice/list.do">공지사항</a></li>
	          <li><a href="/Kmarket/cs/faq/list.do?cate1=1">자주묻는질문</a></li>
	          <li><a href="/Kmarket/cs/qna/list.do?cate1=1">문의하기</a></li>
	          <li><a href="/Kmarket/cs/index.do">고객센터</a></li>
           	</ul>
          </div>
        </div>
        <!-- member, cs 는 필요 없는 부분 끝 -->
      </header>
      <!-- 헤더 끝 -->

      <!-- 메인시작 -->

      <main>
        <!-- 카테고리/베스트 상품 영역 -->
         <aside>
          <ul class="category" id="menu">
            <li><i class="fa-solid fa-bars"></i>카테고리</li>
            
            <c:forEach var="cates1" items="${categories1}" varStatus="status">
            <li>
              <a href="/Kmarket/product/list.do?cate1=${cates1.cate1}">
              	<c:choose>
              		<c:when test="${status.index eq 0}">
              			<i class="fa-sharp fa-solid fa-shirt"></i>
              		</c:when> 
              		<c:when test="${status.index eq 1}">
              			<i class="fa-solid fa-bag-shopping"></i>
              		</c:when> 
              		<c:when test="${status.index eq 2}">
              			<i class="fa-solid fa-baby-carriage"></i>
              		</c:when> 
              		<c:when test="${status.index eq 3}">
              			<i class="fa-solid fa-utensils"></i>
              		</c:when> 
              		<c:when test="${status.index eq 4}">
              		 	<i class="fa-solid fa-house"></i>
              		</c:when> 
              		<c:when test="${status.index eq 5}">
              		 	<i class="fa-solid fa-laptop"></i>
              		</c:when> 
              		<c:when test="${status.index eq 6}">
              			<i class="fa-solid fa-futbol"></i>
              		</c:when> 
              		<c:when test="${status.index eq 7}">
              			<i class="fa-solid fa-wrench"></i>
              		</c:when>
              		<c:when test="${status.index eq 8}">
              			<i class="fa-solid fa-book"></i>
              		</c:when> 
                </c:choose>
                ${cates1.c1Name}
                <!-- <i class="fas fa-angle-right"></i> -->
                <i class="fa-solid fa-chevron-right"></i>
              </a>
              <ol class="sub_category">
              	<c:forEach var="cates2" items="${categories2}">
              	<c:if test="${cates1.cate1 eq cates2.cate1}">
                <li><a href="/Kmarket/product/list.do?cate1=${cates1.cate1}&cate2=${cates2.cate2}&listSort=${listSort}">${cates2.c2Name}</a></li>
                </c:if>
                
                </c:forEach>
              </ol>
            </li>
            </c:forEach>
            
          </ul>

          <!-- 베스트상품 배너 -->
          <article class="best">
            <h1><i class="fas fa-crown"></i>베스트상품</h1>
            <ol>
            <c:forEach var="prod"  items="${products}" varStatus="status">
              <li>
                <a href="/Kmarket/product/view.do?prodNo=${prod.prodNo}">
                  <div class="thumb">
                    <i>${status.count}</i>
                    <img src="http://13.125.215.198:8080/file/thumb/${prod.etc3}/${prod.thumb1}" alt="item1">
                  </div>
                  <h2>${prod.prodName}</h2>
                  <div class="org_price">
                    <del>${prod.price}</del>
                    <span>${prod.discount}%</span>
                  </div>
                  <div class="dis_price">
                    <ins>${prod.discountPrice}</ins>
                  </div>
                </a>
              </li>
            </c:forEach>
            </ol>
          </article>
        </aside>
        <section>
          <!-- 슬라이더 영역 -->
          <section class="slider">
            <ul>
              <li>
                <a href="#"><img src="/Kmarket/img/20221212085632719334_0_0.jpg" alt="item1"/></a>
              </li>
              <li>
                <a href="#"><img src="/Kmarket/img/5400946.jpg" alt="item2"/></a>
              </li>
              <li>
                <a href="#"><img src="/Kmarket/img/bd86a861d99c401a.jfif" alt="item3"/></a>
              </li>
              <li>
                <a href="#"><img src="/Kmarket/img/0c75c78218964250.jfif" alt="item4"/></a>
              </li>
              <li>
                <a href="#"><img src="https://via.placeholder.com/985x447" alt="item5"/></a>
              </li>
            </ul>
          </section>
          <!-- 히트상품 영역 -->
          <section class="hit">
            <h3 id="hit"><span>히트상품</span></h3>
            <c:forEach var="hit" items="${hitProducts}">
            <article>
              <a href="/Kmarket/product/view.do?prodNo=${hit.prodNo}">
                <div class="thumb">
                  <img src="http://13.125.215.198:8080/file/thumb/${hit.etc3}/${hit.thumb2}" alt="t1" />
                </div>
                <h2>${hit.prodName}</h2>
                <p>${hit.descript}</p>
                <div class="org_price">
                  <del>${hit.price}</del>
                  <span>${hit.discount}%</span>
                </div>
                <div class="dis_price">
                  <ins>${hit.discountPrice}</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            </c:forEach>
          </section>
          <!-- 추천상품 영역 -->
          <section class="recommend">
            <h3 id="score"><span>추천상품</span></h3>
            <c:forEach var="score" items="${scoreProducts}">
            <article>
              <a href="/Kmarket/product/view.do?prodNo=${score.prodNo}">
                <div class="thumb">
                  <img src="http://13.125.215.198:8080/file/thumb/${score.etc3}/${score.thumb1}" alt="t1" />
                </div>
                <h2>${score.prodName}</h2>
                <p>${score.descript}</p>
                <div class="org_price">
                  <del>${score.price}</del>
                  <span>${score.discount}%</span>
                </div>
                <div class="dis_price">
                  <ins>${score.discountPrice}</ins>
                  <span>배송비 ${score.delivery}</span>
                </div>
              </a>
            </article>
            </c:forEach>
          </section>
          <!-- 최신상품 영역 -->
          <section class="new">
            <h3 id="new"><span>최신상품</span></h3>
            <c:forEach var="newProd" items="${newProducts}">
            <article>
              <a href="/Kmarket/product/view.do?prodNo=${newProd.prodNo}">
                <div class="thumb">
                  <img src="http://13.125.215.198:8080/file/thumb/${newProd.etc3}/${newProd.thumb1}" alt="t1" />
                </div>
                <h2>${newProd.prodName}</h2>
                <p>${newProd.descript}</p>
                <div class="org_price">
                  <del>${newProd.price}</del>
                  <span>${newProd.discount}%</span>
                </div>
                <div class="dis_price">
                  <ins>${newProd.discountPrice}</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            </c:forEach>
          </section>
          <!-- 할인상품 영역 -->
          <section class="discount">
            <h3 id="dis"><span>할인상품</span></h3>
            <c:forEach var="dis" items="${disProducts}">
            <article>
              <a href="/Kmarket/product/view.do?prodNo=${dis.prodNo}">
                <div class="thumb">
                  <img src="http://13.125.215.198:8080/file/thumb/${dis.etc3}/${dis.thumb2}" alt="t1" />
                </div>
                <h2>${dis.prodName}</h2>
                <p>${dis.descript}</p>
                <div class="org_price">
                  <del>${dis.price}</del>
                  <span>${dis.discount}%</span>
                </div>
                <div class="dis_price">
                  <ins>${dis.discountPrice}</ins>
                  <span class="free">무료배송</span>
                </div>
              </a>
            </article>
            </c:forEach>
          </section>
        </section>
      </main>
      <!-- 메인 끝 -->

      <!-- 푸터시작 -->
      <footer>
        <ul>
          <li><a href="#">회사소개</a></li>
          <li><a href="#">서비스이용약관</a></li>
          <li><a href="#">개인정보처리방침</a></li>
          <li><a href="#">전자금융거래약관</a></li>
        </ul>
        <div>
          <p><img src="./img/footer_logo.png" alt="로고" /></p>
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
      <div class="topBtn" onclick="window.scrollTo(0,0);">
        <img src="./img/top.png" alt="탑으로" />
      </div>
      <!-- 푸터끝 -->
    </div>
  </body>
</html>
