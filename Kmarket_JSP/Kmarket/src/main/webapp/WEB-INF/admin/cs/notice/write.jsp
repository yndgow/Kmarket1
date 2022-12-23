<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../_header.jsp"/>
  <section id="admin-product-list">
    <nav>
      <h3>공지사항 작성</h3>
      <p>HOME > 고객센터 > <strong>공지사항</strong></p>
    </nav>
    <section>
    <form action="/Kmarket/admin/cs/notice/write.do" method="post">
      <table class="update">
        <tr>
          <th>유형</th>
          <td>
            <select name="sel1">
              <option value="0">1차유형</option>
              <option value="1">고객서비스</option>
              <option value="2">안전거래</option>
              <option value="3">위해상품</option>
              <option value="4">이벤트 당첨</option>
            </select>
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td><input type="text" name="title" id="title" /></td>
        </tr>
        <tr>
          <th>내용</th>
          <td><textarea name="content" id="content"></textarea></td>
        </tr>
      </table>
    </form>
      <div class="btnGroup">
        <input type="button" class="btnAdminCsDel btnCancle" value="취소" />
        <input type="button" class="btnAdminCsWri btnWrite" value="등록하기" />
      </div>
    </section>
  </section>
</main>
<jsp:include page="../_footer.jsp"/>