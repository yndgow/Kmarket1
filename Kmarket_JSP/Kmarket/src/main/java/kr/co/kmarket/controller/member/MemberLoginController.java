package kr.co.kmarket.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 100 회원아님 or 로그인 실패 201 로그아웃
		String success = req.getParameter("success");
		if(success == null) success = "201";
		req.setAttribute("success", success);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/member/login.jsp");
		dispatcher.forward(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String uid = req.getParameter("uid");
		String pass = req.getParameter("pass");
		String auto = req.getParameter("auto");
		
		MemberVO vo = service.selectMember(uid, pass);
		
				// 로그인 처리
				if(vo != null) {
					// 회원 맞음
					HttpSession session = req.getSession(); // 현재 클라이언트 세션 구함
					session.setAttribute("sessUser", vo);
					
					// 자동로그인 처리
					if(auto != null) {
						String sessId = session.getId();
						
						// 쿠키생성
						Cookie cookie = new Cookie("SESSID", sessId);
						cookie.setPath("/");
						cookie.setMaxAge(60*60*24*3);
						resp.addCookie(cookie);
						
						// 세션정보 데이터베이스 저장
						service.updateMemberForSession(uid, sessId);
					}
					
					resp.sendRedirect("/Karket/index.do");
					
				}else {
					// 회원 아님
					resp.sendRedirect("/Kamrket/member/login.do?success=100");			
				}	
	
	}
}
