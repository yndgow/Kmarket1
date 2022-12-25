<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>케이마켓::관리자</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="/Kmarket/js/admin/cs/script.js"></script>
    <link rel="icon" href="data:;base64,iVBORw0KGgo=">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
    <link rel="stylesheet" href="/Kmarket/css/admin/admin.css" />
    <link rel="stylesheet" href="/Kmarket/css/admin/cs/style.css" />
    <style>
      .searchbtn {
        position: absolute;
        left: 710px;
        height: 33px;
      }
    </style>
  </head>
  <body>
    <div id="admin-wrapper">
      <header>
        <div>
          <a href="/Kmarket/admin/index.do" class="logo">
            <img src="/Kmarket/img/admin/admin_logo.png" alt="admin_logo" />
          </a>
          <p>
            <c:if test="${sessUser.uid eq admin}">
            	<span>홍길동님 반갑습니다.</span>
            </c:if>
            <a href="/Kmarket/">HOME |</a>
            <a href="/Kmarket/member/logout.do">로그아웃 |</a>
            <a href="/Kmarket/cs/index.do">고객센터</a>
          </p>
        </div>
      </header>

      <main>
        <aside>
          <!-- Global Navigation Bar -->
          <ul id="gnb">
            <li>
              <a href="#"><i class="fa fa-cogs" aria-hidden="true"></i>환경설정</a>
              <ol>
                <li><a href="#">기본환경설정</a></li>
                <li><a href="#">배너관리</a></li>
              </ol>
            </li>
            <li>
              <a href="#"><i class="fas fa-store" aria-hidden="true"></i>상점관리</a>
              <ol>
                <li><a href="#">판매자현황</a></li>
                <li><a href="#">재고관리</a></li>
              </ol>
            </li>
            <li>
              <a href="#"><i class="fa fa-users" aria-hidden="true"></i>회원관리</a>
              <ol>
                <li><a href="#">회원현황</a></li>
                <li><a href="#">포인트관리</a></li>
                <li><a href="#">비회원관리</a></li>
                <li><a href="#">접속자집계</a></li>
              </ol>
            </li>
            <li>
              <a href="#"><i class="fas fa-box-open" aria-hidden="true"></i>상품관리</a>
              <ol>
                <li><a href="/Kmarket/admin/product/list.do">상품목록</a></li>
                <li><a href="/Kmarket/admin/product/register.do">상품등록</a></li>
              </ol>
            </li>
            <li>
              <a href="#"><i class="fa fa-credit-card" aria-hidden="true"></i>주문관리</a>
              <ol>
                <li><a href="#">주문현황</a></li>
                <li><a href="#">매출현황</a></li>
                <li><a href="#">결제관리</a></li>
                <li><a href="#">배송관리</a></li>
              </ol>
            </li>
            <li>
              <a href="#"><i class="fa-regular fa-pen-to-square"></i>게시판관리</a>
              <ol>
                <li><a href="#">게시판현황</a></li>
                <li><a href="#">고객문의</a></li>
              </ol>
            </li>
            <li>
              <a href="javascript:void(0);"><i class="fa-solid fa-headphones"></i>고객센터</a>
              <ol>
                <li><a href="/Kmarket/admin/cs/notice/list.do">공지사항</a></li>
                <li><a href="/Kmarket/admin/cs/faq/list.do?csType=faq">자주묻는질문</a></li>
                <li><a href="/Kmarket/admin/cs/qna/list.do?csType=qna">문의하기</a></li>
              </ol>
            </li>
          </ul>
        </aside>
