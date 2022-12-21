<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./_header.jsp"/>
		<section class="write">
              <aside>
                  <h2>문의하기</h2>
                  <ul>
                      <li class="on"><a href="#">회원</a></li>
                      <li><a href="#">쿠폰/이벤트</a></li>
                      <li><a href="#">주문/결제</a></li>
                      <li><a href="#">배송</a></li>
                      <li><a href="#">취소/반품/교환</a></li>
                      <li><a href="#">여행/숙박/항공</a></li>
                      <li><a href="#">안전거래</a></li>
                  </ul>
              </aside>
              <article>
                  <form action="/Kmarket/cs/qna/write.do" method="post">
                      <table>
                          <tr>
                              <td>문의유형</td>
                              <td>
                                  <select name="c1Name">
                                      <option value="0">문의유형</option>
                                   
                                  </select>
                              </td>
                              <td>
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
                      <div>
                          <a href="./list.do" class="btnList">취소하기</a>
                          <input type="submit" class="btnSubmit" value="등록하기">
                      </div>
                  </form>
              </article>
          </section>
      </div>
</section>
<jsp:include page="./_footer.jsp"/>