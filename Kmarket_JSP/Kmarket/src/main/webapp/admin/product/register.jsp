<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>케이마켓::관리자</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="https://kit.fontawesome.com/20962f3e4b.js" crossorigin="anonymous"></script>    
    <script src="../js/gnb.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="../css/admin.css">
</head>
<body>
    <div id="admin-wrapper">
        <header>
            <div>
                <a href="../index.html" class="logo">
                    <img src="../img/admin_logo.png" alt="admin_logo">
                </a>
                <p>
                    <span>홍길동님 반갑습니다.</span>
                    <a href="#">HOME |</a>
                    <a href="#">로그아웃 |</a>
                    <a href="#">고객센터</a> 
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
                            <li><a href="/Kmarket/admin/product/list.do">상품현황</a></li>
                            <li><a href="/Kmarket/admin/product/register.do">상품등록</a></li>
                            <li><a href="#">재고관리</a></li>
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
                        <a href="#"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>게시판관리</a>
                        <ol>
                            <li><a href="#">게시판현황</a></li>
                            <li><a href="#">고객문의</a></li>
                        </ol>
                    </li>
                </ul>
            </aside>
            
            <section id="admin-product-register">
                <nav>
                    <h3>상품등록</h3>
                    <p>
                        HOME > 상품관리 > <strong>상품등록</strong>
                    </p>
                </nav>

                <article>
                    <form action="/Kmarket/admin/product/register.do" method="post" enctype="multipart/form-data">
                        <section>
                            <h4>상품분류</h4>
                            <p>
                                기본분류는 반드시 선택하셔야 합니다. 하나의 상품에 1개의 분류를 지정 합니다.
                            </p>
                            <table>
                                <tr>
                                    <td>1차 분류</td>
                                    <td>
                                        <select name="category1">
                                            <option value="0">1차 분류 선택</option>
                                            
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>2차 분류</td>
                                    <td>
                                        <select name="category2">
                                            <option value="0">2차 분류 선택</option>
                                            <option value="10">여성의류</option>
                                            <option value="11">남성의류</option>
                                            <option value="12">언더웨어</option>
                                            <option value="13">신발</option>
                                            <option value="14">가방/잡화</option>
                                            <option value="15">쥬얼리/시계</option>
                                            <option value="16">화장품/향수</option>
                                            <option value="17">바디/헤어</option>
                                        </select>
                                    </td>
                                </tr>
                            </table>
                        </section>
                        <section>
                            <h4>기본정보</h4>
                            <p>
                                기본정보는 반드시 입력해야 합니다.
                            </p>
                            <table>
                                <tr>
                                    <td>상품명</td>
                                    <td><input type="text" name="prodName"/></td>
                                </tr>
                                <tr>
                                    <td>기본설명</td>
                                    <td>
                                        <span>상품명 하단에 상품에 대한 추가적인 설명이 필요한 경우에 입력</span>
                                        <input type="text" name="descript"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>제조사</td>
                                    <td><input type="text" name="company"/></td>
                                </tr>
                                <tr>
                                    <td>판매가격</td>
                                    <td><input type="text" name="price"/>원</td>
                                </tr>                                    
                                <tr>
                                    <td>할인율</td>
                                    <td>
                                        <span>0을 입력하면 할인율 없음</span>
                                        <input type="text" name="discount"/>원
                                    </td>
                                </tr>
                                <tr>
                                    <td>포인트</td>
                                    <td>
                                        <span>0을 입력하면 포인트 없음</span>
                                        <input type="text" name="point"/>점
                                    </td>
                                </tr>
                                <tr>
                                    <td>재고수량</td>
                                    <td><input type="text" name="stock"/>개</td>
                                </tr>
                                <tr>
                                    <td>배송비</td>
                                    <td>
                                        <span>0을 입력하면 배송비 무료</span>
                                        <input type="text" name="delivery"/>원
                                    </td>
                                </tr>
                                <tr>
                                    <td>상품 썸네일</td>
                                    <td>
                                        <span>크기 190 x 190, 상품 목록에 출력될 이미지 입니다. </span>
                                        <input type="file" name="thumb1"/>

                                        <span>크기 230 x 230, 상품 메인에 출력될 이미지 입니다. </span>
                                        <input type="file" name="thumb2"/>

                                        <span>크기 456 x 456, 상품 상세에 출력될 이미지 입니다. </span>
                                        <input type="file" name="thumb3"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>상세 상품정보</td>
                                    <td>
                                        <span>크기 가로 940px 높이 제약없음, 크기 최대 1MB, 상세페이지 상품정보에 출력될 이미지 입니다.</span>
                                        <input type="file" name="detail"/>
                                    </td>
                                </tr>
                            </table>
                        </section>
                        <section>
                            <h4>상품정보 제공고시</h4>
                            <p>
                                [전자상거래에 관한 상품정보 제공에 관한 고시] 항목에 의거 등록해야 되는 정보입니다.
                            </p>
                            <table>
                                <tr>
                                    <td>상품번호</td>
                                    <td><input type="text" name="prodCode"/></td>
                                </tr>
                                <tr>
                                    <td>상품상태</td>
                                    <td><input type="text" name="status"/></td>
                                </tr>
                                <tr>
                                    <td>부가세 면세여부</td>
                                    <td><input type="text" name="duty"/></td>
                                </tr>
                                <tr>
                                    <td>영수증발행</td>
                                    <td><input type="text" name="receipt"/></td>
                                </tr>
                                <tr>
                                    <td>사업자구분</td>
                                    <td><input type="text" name="bizType"/></td>
                                </tr>
                                <tr>
                                    <td>브랜드</td>
                                    <td><input type="text" name="brand"/></td>
                                </tr>
                                <tr>
                                    <td>원산지</td>
                                    <td><input type="text" name="origin"/></td>
                                </tr>
                                <tr>
                                    <td>제품소재</td>
                                    <td><input type="text" name="material"/></td>
                                </tr>
                                <tr>
                                    <td>색상</td>
                                    <td><input type="text" name="color"/></td>
                                </tr>
                                <tr>
                                    <td>치수</td>
                                    <td><input type="text" name="size"/></td>
                                </tr>
                                <tr>
                                    <td>제조자/수입국</td>
                                    <td><input type="text" name="manuCompany"/></td>
                                </tr>
                                <tr>
                                    <td>제조국</td>
                                    <td><input type="text" name="manuCountry"/></td>
                                </tr>
                                <tr>
                                    <td>취급시 주의사항</td>
                                    <td><input type="text" name="warning"/></td>
                                </tr>
                                <tr>
                                    <td>제조연월</td>
                                    <td><input type="text" name="manuDate"/></td>
                                </tr>
                                <tr>
                                    <td>품질보증기준</td>
                                    <td><input type="text" name="qa"/></td>
                                </tr>
                                <tr>
                                    <td>A/S 책임자와 전화번호</td>
                                    <td><input type="text" name="as"/></td>
                                </tr>
                                <tr>
                                    <td>주문후 예상 배송기간</td>
                                    <td><input type="text" name="deliveryTime"/></td>
                                </tr>
                            </table>       
                        </section>

                        <input type="submit" value="등록하기">
                    </form>
                </article>

                <p class="ico alert">
                    <strong>Warning!</strong>
                    전자상거래 등에서의 상품 등의 정보제공에 관한 고시에 따라 총 35개 상품군에 대해 상품 특성 등을 양식에 따라 입력할 수 있습니다.
                
                </p>
            </section>
          
        </main>

        <footer>
            <div>
                <p>Copyright ©kmarket.co.kr All rights reserved. KMARKET ADMINISTRATOR Version 5.4.1.2</p>
            </div>
        </footer>
    </div>
</body>
</html>