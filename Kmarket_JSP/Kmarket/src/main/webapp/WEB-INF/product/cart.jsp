<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./_header.jsp"/>
		<!-- section cart 시작 -->
        <section class="cart">
          <nav>
            <h1>장바구니</h1>
            <p>
              HOME > <span>패션·의류·뷰티</span> > <strong>장바구니</strong>
            </p>
          </nav>

          <form action="#">
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
	                <td><input type="checkbox"></td>
	                <td>
	                  <article>
	                    <a href="/Kmarket/product/view.do?prodNo=${cart.prodNo}">
	                      <img src="http://13.125.215.198:8080/file/${cart.thumb1}" alt="장바구니thumb1">
	                    </a>
	                    <div>
	                      <h2>
	                        <a href="/Kmarket/product/view.do?prodNo=${cart.prodNo}">${cart.prodName}</a>
	                      </h2>
	                      <p>${cart.prodNo}상품설명 join</p>
	                    </div>
	                  </article>
	                </td>
	                <td>${cart.count}</td>
	                <td>${cart.price}</td>
	                <td>${cart.discount}</td>
	                <td>${cart.point}</td>
	                <td>${cart.delivery}</td>
	                <td>${cart.total}</td>
	              </tr>
	              </c:forEach>
	            </c:otherwise>
			</c:choose>   
              
              
            </table>
            <input type="button" name="del" value="선택삭제">
            <div class="total">
              <h2>전체합계</h2>
              <table border="0">
                <tr>
                  <td>상품수</td>
                  <td>1</td>
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
                  <td>포인트</td>
                  <td>260</td>
                </tr>
                <tr>
                  <td>전체주문금액</td>
                  <td>26,000</td>
                </tr>
              </table>
              <input type="submit" name="" value="주문하기">
            </div>
          </form>
        </section>
      </main>
      <!-- 메인 끝 -->
<jsp:include page="./_footer.jsp"/>