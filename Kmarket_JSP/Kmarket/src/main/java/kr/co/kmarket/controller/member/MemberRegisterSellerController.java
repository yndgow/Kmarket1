package kr.co.kmarket.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.MemberService;
import kr.co.kmarket.vo.MemberVO;

@WebServlet("/member/registerSeller.do")
public class MemberRegisterSellerController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	MemberService service = MemberService.INSTANCE;
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/member/registerSeller.jsp");
		dispatcher.forward(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String uid = req.getParameter("uid");
		String pass2 = req.getParameter("pass2");
		String company = req.getParameter("company");
		String ceo = req.getParameter("ceo");
		String bizRegNum = req.getParameter("bizRegNum");
		String comRegNum = req.getParameter("comRegNum");
		String tel = req.getParameter("tel");
		String fax = req.getParameter("fax");
		String zip = req.getParameter("zip");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String regip = req.getRemoteAddr();
		
		MemberVO vo = new MemberVO();
		vo.setUid(uid);
		vo.setPass(pass2);
		vo.setCompany(company);
		vo.setCeo(ceo);
		vo.setBizRegNum(bizRegNum);
		vo.setComRegNum(comRegNum);
		vo.setTel(tel);
		vo.setFax(fax);
		vo.setZip(zip);
		vo.setAddr1(addr1);
		vo.setAddr2(addr2);
		vo.setRegip(regip);
		
		
		//데이터베이스 처리
		service.insertMember(vo);
		
		
		//리다이렉트
		resp.sendRedirect("/Kmarket/member/login.do");
		
	
	}
}
