<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
<section id="cs">
        <div class="qna">
            <nav>
                <div>
                    <p>홈<span>></span>문의하기</p>
                </div>
            </nav>
            <jsp:include page="./cate/_cate${cate1}.jsp"/>
			<section class="write">
                <article>
                    <form action="/Kmarket/cs/qna/write.do" method="post">
                    	<input type="hidden" name="uid" value="${uid}"/>
                        <table class="asktest">
                            <tr>
                                <td>문의유형</td>
                                <td>
                                    <select name="c1Name">
                                        <option value="0">문의유형</option>
                                     
                                    </select>
                                    <select name="c2Name">
                                        <option value="0">상세유형</option>
                                     
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>문의제목</td>
                                <td><input type="text" name="title" placeholder="제목을 입력하세요."></td>
                            </tr>
                            <tr>
                                <td>문의내용</td>
                                <td>
                                    <textarea name="content" placeholder="내용을 입력하세요."></textarea>
                                </td>
                            </tr>
                        </table>
                        <div class="btnGroupQna">
                            <a href="./list.do?cate1=1" class="btnList">취소하기</a>
                            <input type="submit" class="btnSubmit" value="등록하기">
                        </div>
                    </form>
                </article>
            </section>
      </div>
</section>
<jsp:include page="../_footer.jsp"/>