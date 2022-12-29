<%@page import="java.util.Date"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="./_header.jsp"/>
       <section>
        	<nav>
          		<h1>상품보기</h1>
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
        <!-- section view 시작 -->
          <section class="view">
          <!-- 개별 파트 시작 -->
          <article class="info">
            <div class="image">
              <img src="http://13.125.215.198:8080/file/thumb/${product.etc3}/${product.thumb3}" alt="상품사진" />
            </div>
            <div class="summary">
              <div class="view_seller">
                <h1>${product.seller}</h1>
                <h2>상품번호 : <span class="prodNo">${product.prodNo}</span></h2>
              </div>
              <div class="view_content">
                <p>${product.prodName}<br /></p>
                <p>${product.descript}</p>
                <br />
                <div class="view_star star2-4"></div>
                <a href="/Kmarket/product/review.do?prodNo=${product.prodNo}">상품평보기</a><br />
              </div>
              <div class="view_price">
                
                <c:if test="${product.discount ne 0}">
                  	<del class="ori_price"><fmt:formatNumber value="${product.price}" 	pattern="#,###"/>원</del><span class="discount">${product.discount}%↓</span><br />
                  </c:if>
                 <c:choose>
                  <c:when test="${product.discount ne 0}">
                  	<ins class="cur_price"><fmt:formatNumber value="${product.price * (100-product.discount)/100}" pattern="#,###"/>원</ins><br />
                  </c:when>
                  <c:otherwise>
                  	<ins class="cur_price">
                  		<fmt:formatNumber value="${product.price}"  pattern="#,###"/>원
                  	</ins><br />
                  </c:otherwise>
                  </c:choose>
                
              </div>
              
              <div class="view_delivery">
              <!-- 2일뒤 날짜 -->
              	<c:set var="daythree" value="<%= new Date(new Date().getTime() + 60*60*24*1000*2) %>"/>
              
                <c:choose>
               		<c:when test="${product.delivery eq 0}">
						<p>
							<span class="free">무료배송</span>
							
					모레<fmt:formatDate value="${daythree}" type="DATE" pattern="(E) MM/dd"/>&nbsp;도착예정
	          			</p>
                 	</c:when>
                 	<c:otherwise>
                 		<p>
                 			<span class="nofree">배송비: ${product.delivery}</span>
							모레<fmt:formatDate value="${daythree}" type="DATE" pattern="(E) MM-dd"/>&nbsp;도착예정
                 		</p>
                 	</c:otherwise>
                </c:choose>
                
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
                <p>총 상품금액 <span><fmt:formatNumber value="${product.price * (100-product.discount)/100}" pattern="#,###"/>원</span></p>
              </div>
              <div class="view_button">
	            <input type="hidden" name="prodNo" value="${product.prodNo}">
              	<input type="hidden" name="ori_price" value="${product.price}">
              	<input type="hidden" name="cur_price" value="${product.price * (100-product.discount)/100}">
              	<input type="hidden" name="discount" value="${product.discount}">
           		<input type="hidden" name="delivery" value="${product.delivery}">
                <button class="btnCart">장바구니</button>
                <button class="btnBuy">구매하기</button>
              </div>
            </div>
          </article>
          <article class="detail">
            <nav>
              <h1>상품정보</h1>
            </nav>
            <img src="http://13.125.215.198:8080/file/thumb/${product.etc3}/${product.detail}" alt="상품사진1" />
            
          </article>
          <article class="notice">
            <nav>
              <h1>상품 정보 제공 고시<span>[전자상거래에 관한 상품정보 제공에 관한 고시] 항목에 의거 등록된 정보입니다.]</span></h1>
            </nav>
            <table>
              <tr>
                <td>상품번호</td>
                <td>${product.prodNo}</td>
              </tr>
              <tr>
                <td>상품상태</td>
                <td>${product.status}</td>
              </tr>
              <tr>
                <td>부가세 면세여부</td>
                <td>${product.duty}</td>
              </tr>
              <tr>
                <td>영수증발행</td>
                <td>${product.receipt}</td>
              </tr>
              <tr>
                <td>사업자구분</td>
                <td>${product.bizType}</td>
              </tr>
              <tr>
                <td>브랜드</td>
                <td>블루포스</td>
              </tr>
              <tr class="tr_line">
                <td>원산지</td>
                <td>${product.origin}</td>
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
            <c:forEach var="review" items="${reviews}">
            <ul>
              <li>
                <div>
                  <h5 class="star2-${review.rating}"></h5>
                  <p class="ordUid">${review.uid}<span class="ordDate">&nbsp;${review.rdate}</span></p>
                </div>
              </li>
              <!-- ORDER -->
              <li><h3>${review.prodName}</h3></li>
              <li>
              ${review.content}
              </li>
            </ul>
            </c:forEach>
           
          </article>

          <div class="paging">
           <c:if test="${pageGroupStart > 1}">
            <span class="prev">
              <a href="/Kmarket/product/view.do?prodNo=${product.prodNo}&pg=${pageGroupStart-1}"><i class="fa-light fa-less-than"></i>이전</a>
            </span>
             </c:if>
           
            <span class="num">
             <c:forEach var="num" begin="${pageGroupStart}" end="${pageGroupEnd}">
               <a href="/Kmarket/product/view.do?prodNo=${product.prodNo}&pg=${num}" class="num ${num == currentPage ? 'on' : 'off'}">${num}</a>
             </c:forEach>
            </span>
           <c:if test="${pageGroupEnd < lastPageNum}">
            <span class="next">
              <a href="/Kmarket/product/view.do?prodNo=${product.prodNo}&pg=${pageGroupEnd+1}">다음<i class="fa-light fa-greater-than"></i></a>
            </span>
            </c:if>
          </div>

        </section>
        <!-- section list 끝 -->
      </main>
      <!-- 메인 끝 -->
<jsp:include page="./_footer.jsp"/>