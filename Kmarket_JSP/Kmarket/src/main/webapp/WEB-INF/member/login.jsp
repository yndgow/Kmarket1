<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./_header.jsp"/>
<script>
	let success = ${success};
		if(success == 100){
			alert('회원정보가 일치하지 않거나 가입하지 않은 회원입니다.');
		}
		if(success == 300){
			alert('먼저 로그인을 하셔야 합니다.');
		}
</script>

        <main id="member">
            <div class="login">
                <nav>
                    <h1>로그인</h1>
                    <p>
                        HOME > <b>로그인</b>
                    </p>
                </nav>

                <form action="/Kmarket/member/login.do" method="post">
                    <table border="0">
                        <tr>
                            <td>아이디</td>
                            <td><input type="text" name="uid" placeholder="아이디 입력" ></td>
                        </tr>
                        <tr>
                            <td>비밀번호</td>
                            <td><input type="password" name="pass" placeholder="비밀번호 입력"></td>
                        </tr>
                    </table>
                    <input type="submit" value="로그인">
                    <span>
                        <label><input type="checkbox" name="auto">자동 로그인</label>
                        <a href="/Kmarket/member/findId.do">아이디찾기</a>
                        <a href="#">비밀번호찾기</a>
                        <a href="/Kmarket/member/join.do">회원가입</a>
                    </span>

                    <a href="#" class="banner"><img src="/Kmarket/img/member/member_login_banner.jpg" alt="1만원 할인쿠폰"></a>
                </form>
                <img src="/Kmarket/img/member/member_certifi_logo.gif" alt="banner">
            </div>
        </main>
<jsp:include page="./_footer.jsp"/>