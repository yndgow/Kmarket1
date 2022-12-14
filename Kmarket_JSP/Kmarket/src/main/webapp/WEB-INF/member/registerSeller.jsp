<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="./_header.jsp"/>
<script src="/Kmarket/js/member/validation2.js"></script>
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
                                    <span class="resultBiz">&nbsp;-표시 포함 12자리 입력 예) 123-12-12345</span>
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
                                <span class="resultFax">&nbsp;-표시포함 예) 1234-123-1234</span>
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
<jsp:include page="./_footer.jsp"/>