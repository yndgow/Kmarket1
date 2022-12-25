<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
              <th>할인</th>
              <th>포인트</th>
              <th>배송비</th>
              <th>소계</th>
            </tr>
          </thead>
          <tbody>
          <c:choose>
          	<c:when test="${empty carts}">
       		<tr>
              <td>
                <img src="http://13.125.215.198:8080/file/thumb/${cart.etc3}/${cart.thumb1}" alt="상품이미지20_20" />
                <div id="orderDescrpit">
                  <p>${cart.prodName}</p>
                  <br />
                  <p>
                    ${cart.descript}
                </div>
              </td>
              <td>${cart.count}</td>
              <td>${cart.price}</td>
              <td>${cart.discount}%</td>
              <td>${cart.point}</td>
              <td><c:choose>
	                  <c:when test="${cart.delivery eq 0}">무료배송</c:when>
    	              <c:otherwise>${cart.delivery}</c:otherwise>
                  </c:choose></td>
              <td>${order.ordTotPrice}</td>
            </tr>
          	</c:when>
          	<c:otherwise>
	       		<c:forEach var="cart" items="${carts}">
	            <tr>
	              <td>
	                <img src="http://13.125.215.198:8080/file/thumb/${cart.etc3}/${cart.thumb1}" alt="상품이미지20_20" />
	                <div id="orderDescrpit">
	                  <p>${cart.prodName}</p>
	                  <br />
	                  <p>
	                    ${cart.descript}
	                </div>
	              </td>
	              <td>${cart.count}</td>
	              <td>${cart.price}</td>
	              <td>${cart.discount}%</td>
	              <td>${cart.point}</td>
	              <td><c:choose>
		                  <c:when test="${cart.delivery eq 0}">무료배송</c:when>
	    	              <c:otherwise>${cart.delivery}</c:otherwise>
	                  </c:choose></td>
	              <td>${cart.total}</td>
	            </tr>
	           	</c:forEach>
          	</c:otherwise>
          </c:choose>
          	
            
          </tbody>
        </table>
        <form action="/Kmarket/product/order.do" class="order_info" method="post">
        	<input type="hidden" name="uid" value="${sessUser.uid}" />
        	<c:forEach var="cart" items="${carts}">
              	<input type="hidden" name="cartNo" value="${cart.cartNo}" readonly/>
              	<input type="hidden" name="cartPoints" value="${cart.point}" readonly/>
        	</c:forEach>
          <div>
            <article class="delivery_info">
              <nav>
                <h1>배송정보</h1>
              </nav>
              <table>
                <tbody>
                  <tr>
                    <td>주문자</td>
                    <td><input type="text" name="name" id="name" value="${sessUser.name}"/></td>
                  </tr>
                  <tr>
                    <td>전화번호</td>
                    <td><input type="text" name="hp" id="hp" value="${sessUser.hp}"/> - 포함</td>
                  </tr>
                  <tr>
                    <td>우편번호</td>
                    <td><input type="text" name="zip" id="zip" value="${sessUser.zip}" readonly/> <button type="button" class="btnZip">검색</button></td>
                  </tr>
                  <tr>
                    <td>기본주소</td>
                    <td><input type="text" name="addr1" id="addr1" value="${sessUser.addr1}" readonly/></td>
                  </tr>
                  <tr>
                    <td>상세주소</td>
                    <td><input type="text" name="addr2" id="addr2" value="${sessUser.addr2}"/></td>
                  </tr>
                </tbody>
              </table>
            </article>
            <article class="discount_info">
              <nav>
                <h1>할인정보</h1>
              </nav>
              <div>
              <input type="hidden" name="point" value="${sessUser.point}" readonly>
                <p id="cur_point">현재 포인트 : ${sessUser.point}점</p>
                <p>포인트 5,000점 이상이면 현금처럼 사용 가능합니다.</p>
              </div>
              <div>
                
                <input type="text" name="usedPoint" value="0"/><span>점</span>
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
                  <td><input type="radio" name="payments" id="credit_card" value="1" checked/><span>신용카드 결제</span></td>
                  <td><input type="radio" name="payments" id="check_card" value="2"/><span>체크카드결제</span></td>
                </tr>

                <tr>
                  <td colspan="2"> <label for="">계좌이체</label></td>
                </tr>
                <tr>
                  <td><input type="radio" name="payments" id="transfer" value="3"/><span>실시간 계좌이체</span></td>
                  <td> <input type="radio" name="payments" id="deposit" value="4"/><span>무통장입금</span></td>
                </tr>
                <tr>
                  <td colspan="2"> <label for="">기타</label></td>
                </tr>
                <tr>
                  <td><input type="radio" name="payments" id="hppay" value="5"/><span>휴대폰결제</span></td>
                  <td><input type="radio" name="payments" id="kakaopay" value="6"/><span>카카오페이</span><img src="/Kmarket/img/product/ico_kakaopay.gif" alt="카카오페이"></td>
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
                  <td>${order.ordCount} 건</td>
                </tr>
                <tr>
                  <td>상품금액</td>
                  <td>${order.ordPrice}</td>
                </tr>
                <tr>
                  <td>할인금액</td>
                  <td>${order.ordDiscount}</td>
                </tr>
                <tr>
                  <td>배송비</td>
                  <td>
                  <c:choose>
	                  <c:when test="${order.ordDelivery eq 0}">무료배송</c:when>
    	              <c:otherwise>${order.ordDelivery}</c:otherwise>
                  </c:choose>
                  </td>
                </tr>
                <tr>
                  <td>
                  	포인트 할인
                  	<input type="hidden" name="usedPoint" value="${order.usedPoint}"/>
                  </td>
                  <td id="aUsedPoint">${order.usedPoint}</td>
                </tr>
                <tr>
                  <td>
                  	전체주문금액
                  	<input type="hidden" name="ordTotPrice" value="${order.ordTotPrice}"/>
                  </td>
                  <td id="aTotalPrice">${order.ordTotPrice}</td>
                </tr>
              </tbody>
            </table>
            <button type="submit" id="btnPayment">결제하기</button>
          </article>
          <input type="hidden" name="ordNo" value="${order.ordNo}"/>
          <input type="hidden" name="prodNo" value="${cart.prodNo}"/>
          <input type="hidden" name="count" value="${cart.count}"/>
          <input type="hidden" name="price" value="${cart.price}"/>
          <input type="hidden" name="discount" value="${cart.discount}"/>
          <input type="hidden" name="cartPoint" value="${cart.point}"/>
          <input type="hidden" name="delivery" value="${cart.delivery}"/>
          <input type="hidden" name="total" value="${order.ordTotPrice}"/>
        </form>
      </section>
      <!-- section order 끝 -->
    </main>
    <!-- 메인 끝 -->
<jsp:include page="./_footer.jsp"/>