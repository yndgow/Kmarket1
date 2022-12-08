<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>KMarket::list</title>
    <script src="https://kit.fontawesome.com/e8f010a863.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./css/style.css" />
    <script src="./js/script.js"></script>
  </head>
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
        <!-- section list 시작 -->
        <section class="list">
          <nav>
            <h1>상품목록</h1>
            <p>HOME > 패션·의류·뷰티 > 남성의류</p>
          </nav>
          <ul class="sort">
            <li><a href="#" class="on">판매많은순</a></li>
            <li><a href="#">낮은가격순</a></li>
            <li><a href="#">높은가격순</a></li>
            <li><a href="#">평점높은순</a></li>
            <li><a href="#">후기많은순</a></li>
            <li><a href="#">최근등록순</a></li>
          </ul>
          <table>
            <tbody>
              <tr>
                <td>
                  <a href="#">
                    <img src="./img/apple.jpg" alt="" />
                  </a>
                </td>
                <td>
                  <h1 class="name">상품명</h1>
                  <a href="#"><p class="desc">상품설명</p></a>
                </td>
                <td>
                  <ins class="cur_price">27,000원</ins><br />
                  <del class="ori_price">30,000원</del><span class="discount">10%↓</span><br />
                  <img src="./img/ico_free_delivery.gif" alt="무료배송" class="freede" />
                </td>
                <td class="sellerTd">
                  <a href="#">
                    <i class="fa-solid fa-house-chimney"></i>
                    판매자 </a
                  ><br />
                  <img src="./img/ico_power_dealer.gif" alt="딜러" class="dealer" /><br />
                  <h6 class="rating star1">상품평</h6>
                </td>
              </tr>
              <tr>
                <td>
                  <a href="#">
                    <img src="./img/apple.jpg" alt="" />
                  </a>
                </td>
                <td>
                  <h1 class="name">상품명</h1>
                  <a href="#"><p class="desc">상품설명</p></a>
                </td>
                <td>
                  <ins class="cur_price">27,000원</ins><br />
                  <del class="ori_price">30,000원</del><span class="discount">10%↓</span><br />
                  <img src="./img/ico_free_delivery.gif" alt="무료배송" class="freede" />
                </td>
                <td class="sellerTd">
                  <a href="#">
                    <i class="fa-solid fa-house-chimney"></i>
                    판매자 </a
                  ><br />
                  <img src="./img/ico_power_dealer.gif" alt="딜러" class="dealer" /><br />
                  <h6 class="rating star2">상품평</h6>
                </td>
              </tr>
              <tr>
                <td>
                  <a href="#">
                    <img src="./img/apple.jpg" alt="" />
                  </a>
                </td>
                <td>
                  <h1 class="name">상품명</h1>
                  <a href="#"><p class="desc">상품설명</p></a>
                </td>
                <td>
                  <ins class="cur_price">27,000원</ins><br />
                  <del class="ori_price">30,000원</del><span class="discount">10%↓</span><br />
                  <img src="./img/ico_free_delivery.gif" alt="무료배송" class="freede" />
                </td>
                <td class="sellerTd">
                  <a href="#">
                    <i class="fa-solid fa-house-chimney"></i>
                    판매자 </a
                  ><br />
                  <img src="./img/ico_power_dealer.gif" alt="딜러" class="dealer" /><br />
                  <h6 class="rating star3">상품평</h6>
                </td>
              </tr>
              <tr>
                <td>
                  <a href="#">
                    <img src="./img/apple.jpg" alt="" />
                  </a>
                </td>
                <td>
                  <h1 class="name">상품명</h1>
                  <a href="#"><p class="desc">상품설명</p></a>
                </td>
                <td>
                  <ins class="cur_price">27,000원</ins><br />
                  <del class="ori_price">30,000원</del><span class="discount">10%↓</span><br />
                  <img src="./img/ico_free_delivery.gif" alt="무료배송" class="freede" />
                </td>
                <td class="sellerTd">
                  <a href="#">
                    <i class="fa-solid fa-house-chimney"></i>
                    판매자 </a
                  ><br />
                  <img src="./img/ico_power_dealer.gif" alt="딜러" class="dealer" /><br />
                  <h6 class="rating star4">상품평</h6>
                </td>
              </tr>
              <tr>
                <td>
                  <a href="#">
                    <img src="./img/apple.jpg" alt="" />
                  </a>
                </td>
                <td>
                  <h1 class="name">상품명</h1>
                  <a href="#"><p class="desc">상품설명</p></a>
                </td>
                <td>
                  <ins class="cur_price">27,000원</ins><br />
                  <del class="ori_price">30,000원</del>
                  <span class="discount">10%↓</span><br />
                  <span>배송비 2500</span>
                </td>
                <td class="sellerTd">
                  <a href="#">
                    <i class="fa-solid fa-house-chimney"></i>
                    판매자 </a
                  ><br />
                  <img src="./img/ico_power_dealer.gif" alt="딜러" class="dealer" /><br />
                  <h6 class="rating star5">상품평</h6>
                </td>
              </tr>
            </tbody>
          </table>
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
