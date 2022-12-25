<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./_header.jsp"/>
<!-- 공통 nav 시작-->
        <section>
        	<nav>
          		<h1>상품목록</h1>
		          <c:forEach var="cates1" items="${categories1}">
		          	<c:if test="${cate1 eq cates1.cate1}">
		          		<c:set value="${cates1.c1Name}" var="c1"/>
		          		<c:forEach var="cates2" items="${categories2}">
		          			<c:if test="${cates1.cate1 eq cates2.cate1 && cate2 eq cates2.cate2}">
		          				<c:set value="${cates2.c2Name}" var="c2"/>
		          			</c:if>
		          		</c:forEach>
		          	</c:if>	
		          </c:forEach>
				<p>HOME > ${c1} > ${c2} </p>
	        </nav>
        </section>	          	
<!-- 공통 nav 끝 -->
        <!-- section list 시작 -->
        <section class="list">
          <ul class="sort">
            <li><a href="/Kmarket/product/list.do?cate1=${cate1}&cate2=${cate2}&listSort=soldDesc">판매많은순</a></li>
            <li><a href="/Kmarket/product/list.do?cate1=${cate1}&cate2=${cate2}&listSort=priceAsc">낮은가격순</a></li>
            <li><a href="/Kmarket/product/list.do?cate1=${cate1}&cate2=${cate2}&listSort=priceDesc">높은가격순</a></li>
            <li><a href="/Kmarket/product/list.do?cate1=${cate1}&cate2=${cate2}&listSort=scoreDesc">평점높은순</a></li>
            <li><a href="/Kmarket/product/list.do?cate1=${cate1}&cate2=${cate2}&listSort=reviewDesc">후기많은순</a></li>
            <li><a href="/Kmarket/product/list.do?cate1=${cate1}&cate2=${cate2}&listSort=rdateDesc">최근등록순</a></li>
          </ul>
          <table>
            <tbody>
            
            <c:forEach var="vo" items="${products}">
              <tr>
                <td>
                  <a href="/Kmarket/product/view.do?prodNo=${vo.prodNo}">
                    <img src="http://13.125.215.198:8080/file/thumb/${vo.etc3}/${vo.thumb1}" alt="상품이미지" />
                  </a>
                </td>
                <td>
                  <h1 class="name">${vo.prodName}</h1>
                  <a href="/Kmarket/product/view.do?cate1=${cate1}&cate2=${cate2}&listSort=${listSort}&pg=${pg}&prodNo=${vo.prodNo}"><p class="desc">${vo.descript}</p></a>
                </td>
                <td>
                  <c:choose>
                  <c:when test="${vo.discount ne 0}">
                  	<ins class="cur_price"><fmt:formatNumber value="${vo.price * (100-vo.discount)/100}" pattern="#,###"/>원</ins><br />
                  </c:when>
                  <c:otherwise>
                  	<ins class="cur_price">
                  		<fmt:formatNumber value="${vo.price}"  pattern="#,###"/>원
                  	</ins><br />
                  </c:otherwise>
                  </c:choose>
                  <c:if test="${vo.discount ne 0}">
                  	<del class="ori_price"><fmt:formatNumber value="${vo.price}" pattern="#,###"/> </del><span class="discount">${vo.discount}%↓</span><br />
                  </c:if>
                  <c:choose>
                  	<c:when test="${vo.delivery eq 0}">
                  		<img src="/Kmarket/img/product/ico_free_delivery.gif" alt="무료배송" class="freede" />
                 	</c:when>
                 	<c:otherwise>
                 		<p>배송비: ${vo.delivery}</p>
                 	</c:otherwise>
                 	
                  </c:choose>
                </td>
                <td class="sellerTd">
                  <a href="#">
                    <i class="fa-solid fa-house-chimney"></i>
                    ${vo.seller}
                  </a><br />
                  <c:choose>
                  	<c:when test="${vo.score lt 3}">
                  		<img src="/Kmarket/img/product/ico_power_dealer.gif" alt="딜러" class="dealer" /><br />
                  	</c:when>
                  	<c:otherwise>
                  		
                  		<img src="/Kmarket/img/product/ico_great_seller.gif" alt="딜러" class="dealer2" /><br />
                  	</c:otherwise>
                  </c:choose>
                  <c:choose>
                  	<c:when test="${vo.score eq 0}">
                  		<h6>등록된 상품평이 없습니다.</h6>
                  	</c:when>
                  	<c:otherwise>
                  		<h6 class="rating star${vo.score}">상품평</h6>
                  	</c:otherwise>
                  </c:choose>
                </td>
              </tr>
			</c:forEach>

            </tbody>
          </table>
          
          <div class="paging">
           <c:if test="${pageGroupStart > 1}">
            <span class="prev">
              <a href="/Kmarket/product/list.do?cate1=${cate1}&cate2=${cate2}&listSort=${listSort}&pg=${pageGroupStart-1}&search=${search}"><i class="fa-light fa-less-than"></i>이전</a>
            </span>
             </c:if>
           
            <span class="num">
             <c:forEach var="num" begin="${pageGroupStart}" end="${pageGroupEnd}">
               <a href="/Kmarket/product/list.do?cate1=${cate1}&cate2=${cate2}&listSort=${listSort}&pg=${num}&search=${search}" class="num ${num == currentPage ? 'on' : 'off'}">${num}</a>
             </c:forEach>
            </span>
           <c:if test="${pageGroupEnd < lastPageNum}">
            <span class="next">
              <a href="/Kmarket/product/list.do?cate1=${cate1}&cate2=${cate2}&listSort=${listSort}&pg=${pageGroupEnd+1}&search=${search}">다음<i class="fa-light fa-greater-than"></i></a>
            </span>
            </c:if>
          </div>
        </section>
        <!-- section list 끝 -->
      </main>
      <!-- 메인 끝 -->
<jsp:include page="./_footer.jsp"/>