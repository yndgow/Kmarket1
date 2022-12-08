<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>KMarket::view</title>
    <script src="https://kit.fontawesome.com/e8f010a863.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./css/style.css" />
    <script src="./js/script.js"></script>
  </head>
  <style></style>
  <body>
    <div class="wrapper">
      <!-- 헤더시작 -->
      <header>
        <div class="top">
          <div>
            <a href="">로그인</a>
            <a href="">회원가입</a>
            <a href="">마이페이지</a>
            <a href=""><i class="fa-solid fa-cart-shopping"></i>&nbsp;장바구니</a>
          </div>
        </div>
        <div class="logo">
          <div>
            <a href="">
              <img src="../img/header_logo.png" alt="헤더로고" />
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
              <li><a href="">히트상품</a></li>
              <li><a href="">추천상품</a></li>
              <li><a href="">최신상품</a></li>
              <li><a href="">인기상품</a></li>
              <li><a href="">할인상품</a></li>
            </ul>
            <ul>
              <li><a href="">쿠폰존</a></li>
              <li><a href="">사용후기</a></li>
              <li><a href="">개인결제</a></li>
              <li><a href="">고객센터</a></li>
              <li><a href="">FAQ</a></li>
            </ul>
          </div>
        </div>
        <!-- member, cs 는 필요 없는 부분 끝 -->
      </header>
      <!-- 헤더 끝 -->
      <!-- 메인시작 -->
      <main id="product">
        <!-- aside 시작 -->
        <aside>
          <ul class="category" id="menu">
            <li><i class="fa-solid fa-bars"></i>카테고리</li>
            <li>
              <a href="#">
                <i class="fa-sharp fa-solid fa-shirt"></i>
                패션·의류·뷰티
                <i class="fa-solid fa-chevron-right"></i>
              </a>
              <ol class="sub_category">
                <li><a href="#">남성의류</a></li>
                <li><a href="#">여성의류</a></li>
                <li><a href="#">잡화</a></li>
                <li><a href="#">뷰티</a></li>
              </ol>
            </li>
            <li>
              <a href="#">
                <i class="fa-solid fa-laptop"></i>
                가전·디지털
                <i class="fa-solid fa-chevron-right"></i
              ></a>
              <ol class="sub_category">
                <li><a href="#">노트북/PC</a></li>
                <li><a href="#">가전</a></li>
                <li><a href="#">휴대폰</a></li>
                <li><a href="#">기타</a></li>
              </ol>
            </li>
            <li>
              <a href="#"><i class="fa-solid fa-utensils"></i>식품·생필품<i class="fa-solid fa-chevron-right"></i></a>
              <ol class="sub_category">
                <li><a href="#">신선식품</a></li>
                <li><a href="#">가공식품</a></li>
                <li><a href="#">건강식품</a></li>
                <li><a href="#">생필품</a></li>
              </ol>
            </li>
            <li>
              <a href="#"><i class="fa-solid fa-house"></i>홈·문구·취미<i class="fa-solid fa-chevron-right"></i></a>
              <ol class="sub_category">
                <li><a href="#">가구/DIY</a></li>
                <li><a href="#">침구·커튼</a></li>
                <li><a href="#">생활용품</a></li>
                <li><a href="#">사무용품</a></li>
              </ol>
            </li>
          </ul>
        </aside>
        <!-- asdie 끝 -->
        <!-- section view 시작 -->
        <section class="view">
          <!-- 공통 nav 시작-->
          <nav>
            <h1>상품보기</h1>
            <p>HOME > 패션·의류·뷰티 > 남성의류</p>
          </nav>
          <!-- 공통 nav 끝 -->
          <!-- 개별 파트 시작 -->
          <article class="info">
            <div class="image">
              <img src="./img/apple.jpg" alt="상품사진" />
            </div>
            <div class="summary">
              <div class="view_seller">
                <h1>(주)판매자명</h1>
                <h2>상품번호 : 10010118412</h2>
              </div>
              <div class="view_content">
                <p>상품명<br /></p>
                <p>상품설명 출력</p>
                <br />
                <div class="view_star star2-4"></div>
                <a href="#">상품평보기</a><br />
              </div>
              <div class="view_price">
                <del class="ori_price">30,000원</del>
                <span class="discount">10%↓</span><br />
                <ins class="cur_price">27,000원</ins><br />
              </div>
              <div class="view_delivery">
                <p><span class="free">무료배송</span> 모레(금) 7/8 도착예정<br /></p>
                <p>
                  <span>본 상품은 국내배송만 가능합니다.</span>
                </p>
              </div>
              <div class="view_benefits">
                <p>무이자할부</p>
                <p>카드추가혜택</p>
              </div>
              <div class="view_made">
                <p>원산지-상세설명 참조</p>
              </div>
              <div class="view_smile">
                <img src="../img/vip_plcc_banner.png" alt="스마일카드" />
              </div>
              <div class="view_quantity">
                <button class="descBtn">-</button>
                <input type="text" value="1" name="num" readonly />
                <button class="incrBtn">+</button>
              </div>
              <div class="view_total_price">
                <p>총 상품금액 <span>35,000원</span></p>
              </div>
              <div class="view_button">
                <button class="btnCart">장바구니</button>
                <button class="btnBuy">구매하기</button>
              </div>
            </div>
          </article>
          <article class="detail">
            <nav>
              <h1>상품정보</h1>
            </nav>
            <img src="./img/apple.jpg" alt="상품사진1" />
            <img src="./img/apple.jpg" alt="상품사진2" />
            <img src="./img/apple.jpg" alt="상품사진3" />
          </article>
          <article class="notice">
            <nav>
              <h1>상품 정보 제공 고시<span>[전자상거래에 관한 상품정보 제공에 관한 고시] 항목에 의거 등록된 정보입니다.]</span></h1>
            </nav>
            <table>
              <tr>
                <td>상품번호</td>
                <td>10110125435</td>
              </tr>
              <tr>
                <td>상품상태</td>
                <td>새상품</td>
              </tr>
              <tr>
                <td>부가세 면세여부</td>
                <td>과세상품</td>
              </tr>
              <tr>
                <td>영수증발행</td>
                <td>발행가능 - 신용카드 전표, 온라인 현금영수증</td>
              </tr>
              <tr>
                <td>사업자구분</td>
                <td>사업자 판매자</td>
              </tr>
              <tr>
                <td>브랜드</td>
                <td>블루포스</td>
              </tr>
              <tr class="tr_line">
                <td>원산지</td>
                <td>국내생산</td>
              </tr>
              <tr>
                <td>제품소재</td>
                <td>상세정보 직접입력</td>
              </tr>
              <tr>
                <td>색상</td>
                <td>상세정보 직접입력</td>
              </tr>
              <tr>
                <td>치수</td>
                <td>상세정보 직접입력</td>
              </tr>
              <tr>
                <td>제조자/수입국</td>
                <td>상세정보 직접입력</td>
              </tr>
              <tr>
                <td>제조국</td>
                <td>상세정보 직접입력</td>
              </tr>
              <tr>
                <td>취급시 주의사항</td>
                <td>상세정보 직접입력</td>
              </tr>
              <tr>
                <td>제조연월</td>
                <td>상세정보 직접입력</td>
              </tr>
              <tr>
                <td>품질보증기준</td>
                <td>상세정보 직접입력</td>
              </tr>
              <tr>
                <td>A/S 책임자와 전화번호</td>
                <td>상세정보 직접입력</td>
              </tr>
              <tr>
                <td>주문후 예상 배송기간</td>
                <td>상세정보 직접입력</td>
              </tr>
              <tr>
                <td colspan="2">구매, 교환, 반품, 배송, 설치 등과 관련하여 추가비용, 제한조건 등의 특이사항이 있는 경우</td>
              </tr>
            </table>
            <p class="noticeWriting">
              소비자가 전자상거래등에서 소비자 보호에 관한 법률 제 17조 제1항 또는 제3항에 따라 청약철회를 하고 동법 제 18조 제1항 에 따라 청약철회한 물품을
              판매자에게 반환하였음에도 불구 하고 결제 대금의 환급이 3영업일을 넘게 지연된 경우, 소비자 는 전자상거래등에서 소비자보호에 관한 법률 제18조 제2항
              및 동법 시행령 제21조 2에 따라 지연일수에 대하여 전상법 시행령으로 정하는 이율을 곱하여 산정한 지연이자(“지연배상금”)를 신청할 수 있습니다.
              아울러, 교환∙반품∙보증 및 결제대금의 환급신청은 [나의쇼핑정보]에서 하실 수 있으며, 자세한 문의는 개별 판매자에게 연락하여 주시기 바랍니다.
            </p>
          </article>
          <article class="review">
            <nav>
              <h1>상품리뷰</h1>
            </nav>
            <ul>
              <li>
                <div>
                  <h5 class="star2-4"></h5>
                  <p class="ordUid">seo******<span class="ordDate">2018-07-10</span></p>
                </div>
              </li>
              <li><h3>상품명1/BLUE/L</h3></li>
              <li>
                가격대비 정말 괜찮은 옷이라 생각되네요 핏은 음...제가 입기엔 어깨선이 맞고 루즈핏이라 하기도 좀 힘드네요. 아주 약간 루즈한정도...?그래도 이만한
                옷은 없다고 봅니다 깨끗하고 포장도 괜찮고 다음에도 여기서 판매하는 제품들을 구매하고 싶네요 정말 만족하고 후기 남깁니다 많이 파시길 바래요 ~ ~ ~
              </li>
            </ul>
            <ul>
              <li>
                <div>
                  <h5 class="star2-4"></h5>
                  <p class="ordUid">seo******<span class="ordDate">2018-07-10</span></p>
                </div>
              </li>
              <li><h3>상품명1/BLUE/L</h3></li>
              <li>
                가격대비 정말 괜찮은 옷이라 생각되네요 핏은 음...제가 입기엔 어깨선이 맞고 루즈핏이라 하기도 좀 힘드네요. 아주 약간 루즈한정도...?그래도 이만한
                옷은 없다고 봅니다 깨끗하고 포장도 괜찮고 다음에도 여기서 판매하는 제품들을 구매하고 싶네요 정말 만족하고 후기 남깁니다 많이 파시길 바래요 ~ ~ ~
              </li>
            </ul>
            <ul>
              <li>
                <div>
                  <h5 class="star2-4"></h5>
                  <p class="ordUid">seo******<span class="ordDate">2018-07-10</span></p>
                </div>
              </li>
              <li><h3>상품명1/BLUE/L</h3></li>
              <li>
                가격대비 정말 괜찮은 옷이라 생각되네요 핏은 음...제가 입기엔 어깨선이 맞고 루즈핏이라 하기도 좀 힘드네요. 아주 약간 루즈한정도...?그래도 이만한
                옷은 없다고 봅니다 깨끗하고 포장도 괜찮고 다음에도 여기서 판매하는 제품들을 구매하고 싶네요 정말 만족하고 후기 남깁니다 많이 파시길 바래요 ~ ~ ~
              </li>
            </ul>
            <ul>
              <li>
                <div>
                  <h5 class="star2-4"></h5>
                  <p class="ordUid">seo******<span class="ordDate">2018-07-10</span></p>
                </div>
              </li>
              <li><h3>상품명1/BLUE/L</h3></li>
              <li>
                가격대비 정말 괜찮은 옷이라 생각되네요 핏은 음...제가 입기엔 어깨선이 맞고 루즈핏이라 하기도 좀 힘드네요. 아주 약간 루즈한정도...?그래도 이만한
                옷은 없다고 봅니다 깨끗하고 포장도 괜찮고 다음에도 여기서 판매하는 제품들을 구매하고 싶네요 정말 만족하고 후기 남깁니다 많이 파시길 바래요 ~ ~ ~
              </li>
            </ul>
            <ul>
              <li>
                <div>
                  <h5 class="star2-4"></h5>
                  <p class="ordUid">seo******<span class="ordDate">2018-07-10</span></p>
                </div>
              </li>
              <li><h3>상품명1/BLUE/L</h3></li>
              <li>
                가격대비 정말 괜찮은 옷이라 생각되네요 핏은 음...제가 입기엔 어깨선이 맞고 루즈핏이라 하기도 좀 힘드네요. 아주 약간 루즈한정도...?그래도 이만한
                옷은 없다고 봅니다 깨끗하고 포장도 괜찮고 다음에도 여기서 판매하는 제품들을 구매하고 싶네요 정말 만족하고 후기 남깁니다 많이 파시길 바래요 ~ ~ ~
              </li>
            </ul>
          </article>

          <div class="paging">
            <span class="prev">
              <a href="#"><i class="fa-light fa-less-than"></i>이전</a>
            </span>
            <span class="num">
              <a href="#" class="on">1</a>
              <a href="#">2</a>
              <a href="#">3</a>
              <a href="#">4</a>
              <a href="#">5</a>
              <a href="#">6</a>
              <a href="#">7</a>
            </span>
            <span class="next">
              <a href="#">다음<i class="fa-light fa-greater-than"></i></a>
            </span>
          </div>
        </section>
        <!-- section list 끝 -->
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
          <p><img src="../img/footer_logo.png" alt="로고" /></p>
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
        <img src="../img/top.png" alt="탑으로" />
      </div>
      <!-- 푸터끝 -->
    </div>
  </body>
</html>
