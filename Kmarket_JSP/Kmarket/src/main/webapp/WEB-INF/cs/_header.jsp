<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>케이마켓 고객센터</title>
    <link rel="shortcut icon" type="image/x-icon" href="/Kmarket/img/member/favicon.ico" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script> 
    <link rel="icon" href="data:;base64,iVBORw0KGgo=">   
    <script src="/Kmarket/js/cs/cateJs.js"></script>
    <link rel="icon" href="data:;base64,iVBORw0KGgo=">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="/Kmarket/css/cs/style.css">
</head>
<body>
    <div id="wrapper">
        <header>
        <div class="top">
          <div>
          	<c:choose>
				<c:when test="${empty sessUser}">
					<a href="/Kmarket/member/login.do">로그인</a>
					<a href="/Kmarket/member/join.do">회원가입</a>
				</c:when>
				<c:otherwise>
					<!-- 삭제 예정 시작-->
					<a href="" class="sessUser_uid">${sessUser.uid}</a>
					<!-- 삭제 예정 끝-->
					<input type="hidden" class="uid" value="${sessUser.uid}"/>
					<c:set var="uid" value="${sessUser.uid}"/>
					<c:choose>
						<c:when test="${sessUser.level eq 7}">
							<a href="/Kmarket/admin/index.do?uid=${uid}">관리자</a>
						</c:when>
						<c:when test="${sessUser.level eq 5}">
							<a href="/Kmarket/admin/index.do?uid=${uid}">사업자</a>
						</c:when>
					</c:choose>
					<a href="/Kmarket/member/logout.do">로그아웃</a>
					<a href="">마이페이지</a>
				</c:otherwise>
            </c:choose>
           
            <a href="/Kmarket/product/cart.do?uid=${sessUser.uid}"><i class="fa-solid fa-cart-shopping" aria-hidden="true"></i>&nbsp;장바구니</a>
          </div>
        </div>
        <div class="logo">
          <div>
            <a href="/Kmarket/">
              <img src="/Kmarket/img/header_logo.png" alt="헤더로고" />
            </a>
          </div>
        </div>
        </header>
                