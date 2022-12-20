package kr.co.kmarket.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.kmarket.service.MemberService;
import kr.co.kmarket.vo.MemberVO;

@WebServlet("/member/login.do")
public class MemberLoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	MemberService service = MemberService.INSTANCE;
	
	
	@Override
	public void init() throws ServletException {
	}
	
	String prodNo = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 100 회원아님 or 로그인 실패 201 로그아웃
		String success = req.getParameter("success");
		if(success == null) {
			success = "201";
		}
		req.setAttribute("success", success);
		
		// 상품 장바구니,구매하기 로그인 처리 김지홍
		prodNo = req.getParameter("prodNo");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/member/login.jsp");
		dispatcher.forward(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String uid = req.getParameter("uid");
		String pass = req.getParameter("pass");
		
		MemberVO vo = service.selectMember(uid, pass);
		
				// 로그인 처리
				if(vo != null) {
					// 회원 맞음
					HttpSession session = req.getSession(); // 현재 클라이언트 세션 구함
					session.setAttribute("sessUser", vo);
				
					// 상품번호를 가지고 있다면 로그인후 상품페이지로 김지홍
					if(prodNo != null && !prodNo.equals("")) {
						resp.sendRedirect("/Kmarket/product/view.do?prodNo="+prodNo);
					}else {
						resp.sendRedirect("/Kmarket/index.do");
					}
					
					
				}else {
					// 회원 아님
					resp.sendRedirect("/Kmarket/member/login.do?success=100");			
				}	
	
	}
}
