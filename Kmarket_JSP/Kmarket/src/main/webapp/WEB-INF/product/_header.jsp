<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>KMarket::product</title>
    <script src="https://kit.fontawesome.com/e8f010a863.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.1.js" integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI=" crossorigin="anonymous"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <link rel="icon" href="data:;base64,iVBORw0KGgo=">
    <link rel="stylesheet" href="/Kmarket/css/product/style.css" />
    <script src="/Kmarket/js/product/script.js"></script>
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
					<a href="" class="sessUser_uid">${sessUser.uid}</a>
					<input type="hidden" name="uid" value="${sessUser.uid}">
					<a href="/Kmarket/member/logout.do">로그아웃</a>
					<a href="">마이페이지</a>
				</c:otherwise>
            </c:choose>
            
            <a href="/Kmarket/product/cart.do?uid=${sessUser.uid}"><i class="fa-solid fa-cart-shopping"></i>&nbsp;장바구니</a>
          </div>
        </div>
        <div class="logo">
          <div>
            <a href="/Kmarket/">
              <img src="../img/header_logo.png" alt="헤더로고" />
            </a>
            <form action="/Kmarket/product/list.do" class="search">
              <input type="text" name="search" />
              <button type="submit" id="search">
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
             <li><a href="/Kmarket/cs/index.do">고객센터</a></li>
             <li><a href="/Kmarket/cs/faq/list.do?cate1=1">FAQ</a></li>
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
            
            <c:forEach var="cates1" items="${categories1}" varStatus="status">
            <li>
              <a href="/Kmarket/product/list.do?cate1=${cates1.cate1}&cate2=&listSort=">
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
                <i class="fa-solid fa-chevron-right"></i>
              </a>
              <ol class="sub_category">
              	<c:forEach var="cates2" items="${categories2}">
              	<c:if test="${cates1.cate1 eq cates2.cate1}">
                <li><a href="/Kmarket/product/list.do?cate1=${cates1.cate1}&cate2=${cates2.cate2}&listSort=soldDesc">${cates2.c2Name}</a></li>
                </c:if>
                
                </c:forEach>
              </ol>
            </li>
            </c:forEach>
            
          </ul>
        </aside>

             