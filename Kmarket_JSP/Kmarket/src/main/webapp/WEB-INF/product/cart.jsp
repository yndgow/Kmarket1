<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./_header.jsp"/>
		<!-- section cart 시작 -->
        <section class="cart">
          <nav>
            <h1>장바구니</h1>
            <p>
              HOME > <strong>장바구니</strong>
            </p>
          </nav>

          <form action="/Kmarket/product/cart.do" method="post" id="cartForm">
          
            <table>
              <thead>
                <tr>
                  <th><input type="checkbox" name="all"></th>
                  <th>상품명</th>
                  <th>총수량</th>
                  <th>판매가</th>
                  <th>할인</th>
                  <th>포인트</th>
                  <th>배송비</th>
                  <th>소계</th>
                </tr>
              </thead>
			<c:choose>
				<c:when test="${empty carts}">
				  <tr class="empty">
				    <td colspan="7">장바구니에 상품이 없습니다.</td>
			  	  </tr>
				</c:when>
              	<c:otherwise>
              	<c:forEach var="cart" items="${carts}">
           		
				 <tr>
				   <td>
				   <input type="checkbox" name="cartProduct" value="${cart.cartNo}" >
				   <%-- <input type="hidden" name="prodNo" value="${cart.prodNo}"/> --%>
				   </td>
				   <td>
				     <article>
				       <a href="/Kmarket/product/view.do?prodNo=${cart.prodNo}">
				         <img src="http://13.125.215.198:8080/file/thumb/${cart.etc3}/${cart.thumb1}" alt="장바구니thumb1">
				       </a>
				       <div>
				         <h2>
				           <a href="/Kmarket/product/view.do?prodNo=${cart.prodNo}">${cart.prodName}</a>
				         </h2>
				         <p>${cart.descript}</p>
				       </div>
				     </article>
				   </td>
				   <td class="count">${cart.count}</td>
				   <td class="price">${cart.price}</td>
				   <td class="discount">${cart.discount}</td>
				   <td class="point">${cart.point}</td>
				   <td class="delivery">${cart.delivery}</td>
				   <td class="total">${cart.total}</td>
				   
				 </tr>
	              </c:forEach>
	            </c:otherwise>
			</c:choose>   
              
              
            </table>
            <c:if test="${!empty carts}">
            <input type="button" name="del" value="선택삭제">
            <div class="total">
              <h2>전체합계</h2>
              <table>
                <tr>
                  <td>상품수<input type="hidden" name="cartCount" value=""></td>
                  <td id="cartCount">0</td>
                </tr>
                <tr>
                  <td>상품금액<input type="hidden" name="cartPrice" value=""></td>
                  <td id="cartPrice">0</td>
                  
                </tr>
                <tr>
                  <td>할인금액<input type="hidden" name="cartDiscount" value=""></td>
                  <td id="cartDiscount">0</td>
                </tr>
                <tr>
                  <td>배송비<input type="hidden" name="cartDelivery" value=""></td>
                  <td id="cartDelivery">0</td>
                </tr>              
                <tr>
                  <td>포인트<input type="hidden" name="cartPoint" value=""></td>
                  <td id="cartPoint">0</td>
                </tr>
                <tr>
                  <td>전체주문금액<input type="hidden" name="cartTotal" value=""></td>
                  <td id="cartTotal">0</td>
                </tr>
              </table>
              <input type="submit" name="cartOrder" value="주문하기">
            </div>
            </c:if>
          </form>
        </section>
      </main>
      <!-- 메인 끝 -->
<jsp:include page="./_footer.jsp"/>