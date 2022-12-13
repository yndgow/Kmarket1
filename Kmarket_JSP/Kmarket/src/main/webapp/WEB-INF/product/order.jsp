<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="./_header.jsp"/>
      <!-- section order 시작 -->
      <section class="order">
        <nav>
          <h1>주문결제</h1>
          <p>HOME > 장바구니 > 주문결제</p>
        </nav>
        <table>
          <thead>
            <tr>
              <th>상품명</th>
              <th>총수량</th>
              <th>판매가</th>
              <th>배송비</th>
              <th>소계</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>
                <img src="./img/apple.jpg" alt="상품이미지20_20" />
                <div>
                  <p>상품명</p>
                  <br />
                  <p>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Iure, rem minima aperiam cupiditate error
                    tempora suscipit nobis voluptas
                    consequatur dolore sunt dicta officiis, culpa voluptatum sapiente ad ut pariatur hic!
                  </p>
                </div>
              </td>
              <td>1</td>
              <td>27,000</td>
              <td>무료배송</td>
              <td>27,000</td>
            </tr>
            <tr>
              <td>
                <img src="./img/apple.jpg" alt="상품이미지20_20" />
                <div>
                  <p>상품명</p>
                  <br />
                  <p>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Iure, rem minima aperiam cupiditate error
                    tempora suscipit nobis voluptas
                    consequatur dolore sunt dicta officiis, culpa voluptatum sapiente ad ut pariatur hic!
                  </p>
                </div>
              </td>
              <td>1</td>
              <td>27,000</td>
              <td>무료배송</td>
              <td>27,000</td>
            </tr>
            <tr>
              <td>
                <img src="./img/apple.jpg" alt="상품이미지20_20" />
                <div>
                  <p>상품명</p>
                  <br />
                  <p>
                    Lorem ipsum dolor sit amet consectetur adipisicing elit. Iure, rem minima aperiam cupiditate error
                    tempora suscipit nobis voluptas
                    consequatur dolore sunt dicta officiis, culpa voluptatum sapiente ad ut pariatur hic!
                  </p>
                </div>
              </td>
              <td>1</td>
              <td>27,000</td>
              <td>무료배송</td>
              <td>27,000</td>
            </tr>
          </tbody>
        </table>
        <form action="#" class="order_info" method="post">
          <div>
            <article class="delivery_info">
              <nav>
                <h1>배송정보</h1>
              </nav>
              <table>
                <tbody>
                  <tr>
                    <td>주문자</td>
                    <td><input type="text" name="name" id="name" /></td>
                  </tr>
                  <tr>
                    <td>휴대폰</td>
                    <td><input type="text" name="hp" id="hp" /> - 포함</td>
                  </tr>
                  <tr>
                    <td>우편번호</td>
                    <td><input type="text" name="zip" id="zip" /> <button type="button" class="btnZip">검색</button></td>
                  </tr>
                  <tr>
                    <td>기본주소</td>
                    <td><input type="text" name="addr1" id="addr1" /></td>
                  </tr>
                  <tr>
                    <td>상세주소</td>
                    <td><input type="text" name="addr2" id="addr2" /></td>
                  </tr>
                </tbody>
              </table>
            </article>
            <article class="discount_info">
              <nav>
                <h1>할인정보</h1>
              </nav>
              <div>
                <p>현재 포인트 : 7200점</p>
                <p>포인트 5,000점 이상이면 현금처럼 사용 가능합니다.</p>
              </div>
              <div>
                <input type="text" /><span>점</span>
                <button type="button" class="pointApplyBtn">적용</button>
              </div>
            </article>
            <article class="payment_method">
              <nav>
                <h1>결제방법</h1>
              </nav>
              <table>
                <tr>
                  <td colspan="2"> <label for="">신용카드</label></td>
                </tr>
                <tr>
                  <td><input type="radio" name="card" id="credit_card" /><span>신용카드 결제</span></td>
                  <td><input type="radio" name="card" id="check_card" /><span>체크카드결제</span></td>
                </tr>

                <tr>
                  <td colspan="2"> <label for="">계좌이체</label></td>
                </tr>
                <tr>
                  <td><input type="radio" name="account" id="transfer" /><span>실시간 계좌이체</span></td>
                  <td> <input type="radio" name="account" id="deposit" /><span>무통장입금</span></td>
                </tr>
                <tr>
                  <td colspan="2"> <label for="">기타</label></td>
                </tr>
                <tr>
                  <td><input type="radio" name="etc" id="hppay" /><span>휴대폰결제</span></td>
                  <td><input type="radio" name="etc" id="kakaopay" /><span>카카오페이</span><img src="./img/ico_kakaopay.gif"
                      alt=""></td>
                </tr>
              </table>
            </article>
            <article class="warning_notice">
              <ul>
                <li>케이마켓의 모든 판매자는 안전거래를 위해 구매금액, 결제수단에 상관없이 모든거래에 대하여 케이마켓 유한책임회사의 구매안전서비스(에스크로)를 제공하고 있습니다.</li>
                <li>케이마켓 유한책임회사의 전자금융거래법에 의해 결제대금예치업 등록번호는 02-006-00008 입니다.</li>
                <li>등록여부는 금융감독원 홈페이지(www.fss.or.kr)의 업무자료>인허가업무안내>전자금융업등록현황에서 확인하실수 있습니다.</li>
              </ul>
            </article>
          </div>
          <article class="final_payment_info">
            <nav>
              <h1>최종결제 정보</h1>
            </nav>
            <table>
              <tbody>
                <tr>
                  <td>총</td>
                  <td>2 건</td>
                </tr>
                <tr>
                  <td>상품금액</td>
                  <td>27,000</td>
                </tr>
                <tr>
                  <td>할인금액</td>
                  <td>-1,000</td>
                </tr>
                <tr>
                  <td>배송비</td>
                  <td>0</td>
                </tr>
                <tr>
                  <td>포인트 할인</td>
                  <td>-1000</td>
                </tr>
                <tr>
                  <td>전체주문금액</td>
                  <td>25,000</td>
                </tr>
              </tbody>
            </table>
            <button type="submit">결제하기</button>
          </article>
        </form>
      </section>
      <!-- section order 끝 -->
    </main>
    <!-- 메인 끝 -->
<jsp:include page="./_footer.jsp"/>