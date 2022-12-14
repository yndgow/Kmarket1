<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="./_header.jsp"/>
        <main id="member">
            <div class="findId">
                <nav>
                    <h1>아이디 찾기</h1>
                        <p>
                            HOME > 로그인 > <b>아이디찾기</b>
                        </p>
                </nav>
                <form action="#">
                    <table border="0">
                        <tr>
                            <td>이름</td>
                            <td>
                                <input type="text" name="name" placeholder="이름 입력">
                            </td>
                        </tr>
                        <tr>
                            <td>이메일</td>
                            <td>
                                <div>
                                    <input type="email" name="email" placeholder="이메일 입력">
                                    <button type="button" class="btnConfirm">인증번호 받기</button>
                                </div>
                                <div>
                                    <input type="text" name="auth" placeholder="인증번호 입력">
                                    <button type="button" class="btnConfirm">확인</button>
                                </div>
                            </td>
                        </tr>
                    </table>
                    <a href="#" class="banner">
                        <img src="/Kmarket/img/member/member_login_banner.jpg" alt="1만원 할인 쿠폰 받기">
                    </a>
                </form>
                <div>
                    <a href="/Kmarket/member/login.do" class="btnCancel">취소</a>
                    <a href="/Kmarket/member/login.do" class="btnNext">다음</a>
                </div>
                <img src="/Kmarket/img/member/member_certifi_logo.gif" alt="banner">
            </div>
        </main>
<jsp:include page="./_footer.jsp"/>