<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="./_header.jsp"/>
        <!-- section search 시작 -->
        <section class="search">
          <nav>
            <h1>상품검색 결과</h1>
            <p>HOME > 상품검색 > 검색키워드</p>
          </nav>
          <!-- search 검색 구역 시작 -->
          <div class="group">
            <h3>
              <strong>셔츠</strong>검색결과&nbsp;<span>(총 : <em>20</em>건)</span>
            </h3>

            <form action="#">
              <input type="text" name="search" /><button>검색</button>
              <div>
                <input type="checkbox" name="prodName" id="prodName" /><label for="prodName">상품명</label>
                <input type="checkbox" name="descript" id="descript" /><label for="descript">상품설명</label>
                <input type="checkbox" name="price" id="price" /><label for="price">상품가격</label> <input type="text" name="min" />원 ~
                <input type="text" name="max" />원
              </div>
            </form>
            <p>
              상세검색을 선택하지 않거나, 상품가격을 입력하지 않으면 전체에서 검색합니다.<br />
              검색어는 최대 30글자까지, 여러개의 검색어를 공백으로 구분하여 입력 할수 있습니다.
            </p>
          </div>
          <!-- search 검색 구역 끝 -->
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
                  <h1 class="name">FreeMovement BLUEFORCE</h1>
                  <a href="#"><p class="desc">[블루포스] 여름신상 남방/솔리드긴팔남자옷/데님청/체크스판셔츠</p></a>
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
                  <img src="./img/ico_power_dealer.gif" alt="딜러" class="dealer" />
                  <img src="./img/ico_great_seller.gif" alt="고객평가" class="customer_eval" />
                  <br />
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
<jsp:include page="./_footer.jsp"/>