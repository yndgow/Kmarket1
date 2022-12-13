<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>케이마켓::대한민국 1등 온라인 쇼핑몰</title>    
     <link rel="shortcut icon" type="image/x-icon" href="./img/favicon.ico" />
    <script src="https://kit.fontawesome.com/e8f010a863.js" crossorigin="anonymous"></script>
    <script src="http://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="/Kmarket/member/css/style.css"/>
    <script src="/Kmarket/member/js/validation2.js"></script>
    <script src="/Kmarket/member/js/postcode.js"></script>
</head>
<body>
    <div id="wrapper">
        <header>
            <div class="top">
              <div>
                <a href="/Kmarket/member/login.do">로그인</a>
                <a href="/Kmarket/member/join.do">회원가입</a>
                <a href="#">마이페이지</a>
                <a href=""><i class="fa-solid fa-cart-shopping"></i>&nbsp;장바구니</a>
              </div>
            </div>
            <div class="logo">
              <div>
                <a href="/Kmarket/index.do">
                  <img src="/Kmarket/img/header_logo.png" alt="케이마켓">
                </a>
              
              </div>
            </div>
          </header>
        <main id="member">
            <div class="registerSeller">
                <nav>
                    <h1>판매자 회원가입</h1>
                </nav>

                <form action="/Kmarket/member/registerSeller.do" method="post">
                    <section>
                        <table>
                            <caption>회원가입</caption>
                            <tr>
                                <th><span class="essential">*</span>아이디</th>
                                <td>
                                    <input type="text" name="uid" id="uid" placeholder="아이디를 입력">
                                    <span class="resultUid">&nbsp;영문, 숫자로 4~12자까지 설정해 주세요.</span>
                                </td>
                            </tr>
                            <tr>
                                <th><span class="essential">*</span>비밀번호</th>
                                <td>
                                    <input type="password" name="pass1" placeholder="비밀번호를 입력">
                                    <span class="resultPass">&nbsp;영문, 숫자, 특수문자를 조합하여 8~12자까지 설정해 주세요.</span>
                                </td>
                            </tr>
                            <tr>
                                <th><span class="essential">*</span>비밀번호확인</th>
                                <td>
                                    <input type="password" name="pass2" placeholder="비밀번호를 확인">
                                    <span></span>
                                </td>
                            </tr>
                        </table>
                    </section>
                    <section>
                        <table>
                            <caption>판매자 정보입력</caption>
                            <tr>
                                <th><span class="essential">*</span>회사명</th>
                                <td>
                                    <input type="text" name="company" placeholder="회사명 입력">
                                    <span class="resultCompany">&nbsp;(주)포함 입력, 예) 케이마켓</span>
                                </td>
                            </tr>
                            <tr>
                                <th><span class="essential">*</span>대표자</th>
                                <td>
                                    <input type="text" name="ceo" placeholder="대표자 입력">
                                    <span class="resultCeo"></span>
                                </td>
                            </tr>
                            <tr>
                                <th><span class="essential">*</span>사업자등록번호</th>
                                <td>
                                    <input type="text" name="bizRegNum" placeholder="사업자등록번호 입력">
                                    <span class="resultBiz">&nbsp;-표시 포함 12자리 입력</span>
                                </td>
                            </tr>
                            <tr>
                                <th><span class="essential">*</span>통신판매업신고 번호</th>
                                <td>
                                    <input type="text" name="comRegNum" placeholder="통신판매업신고 입력">
                                    <span class="resultCom">&nbsp;-표시 포함, 예) 강남-12345, 제 1-01-23-4567호, 2017-경기성남-0011</span>
                                </td>
                            </tr>
                            <tr>
                                <th><span class="essential">*</span>전화번호</th>
                                <td>
                                    <input type="text" name="tel" placeholder="전화번호 입력">
                                    <span class="resultTel">&nbsp;-표시 포함, 지역번호 포함</span>
                                </td>
                            </tr>
                            <tr>
                                <th><span class="essential"></span>팩스</th>
                                <td>
                                <input type="text" name="fax" placeholder="팩스번호 입력">
                                <span class="resultFax">-표시포함</span>
                                </td>
                            </tr>
                            <tr class="addr">
								<th><span class="essential">*</span>회사주소</th>
								<td>
									<div>
										<input type="text" name="zip" id="zip"
											placeholder="우편번호 입력 클릭" onclick="postcode()" readonly />
											<span class="resultZip"></span>
									</div>
									<div>
										<input type="text" name="addr1" id="addr1" size="50"
											placeholder="주소를 검색하세요." readonly />
									</div>
									<div>
										<input type="text" name="addr2" id="addr2" size="50"
											placeholder="상세주소를 입력하세요." />
											<span class="resultAddr"></span>
									</div>
								</td>
							</tr>
                        </table>
                    </section>
                    
                    <div>
                        <input type="submit" class="join" value="회원가입">
                    </div>
                </form>
            </div>


        </main>
        <footer>
            <ul>
                <li><a href="#">회사소개</a></li>
                <li><a href="#">서비스이용약관</a></li>
                <li><a href="#">개인정보처리방침</a></li>
                <li><a href="#">전자금융거래약관</a></li>
            </ul>
            <div>
                <p><img src="./img/footer_logo.png" alt="로고"></p>
                <p>
                  <strong>(주)KMARKET</strong><br />
                  부산시 강남구 테헤란로 152 (역삼동 강남파이낸스센터)<br />
                  대표이사 : 홍길동<br />
                  사업자등록번호 : 220-81-83676 사업자정보확인<br />
                  통신판매업신고 : 강남 10630호 Fax : 02-589-8842
                </p>
                <p>
                  <strong>고객센터</strong><br />
                  Tel : 1234-5678 (평일 09:00~18:00)<br />
                  스마일클럽/SVIP 전용 : 1522-5700 (365일 09:00~18:00)<br />
                  경기도 부천시 원미구 부일로 223(상동) 투나빌딩 6층<br />
                  Fax : 051-123-4567 | Mail : kmarket@kmarket.co.kr<br />
                </p>
            </div>              
        </footer>
          <div class="topBtn" onclick="window.scrollTo(0,0);">
            <img src="./img/top.png" alt="탑으로" />
        </div>
    </div>
</body>
</html>