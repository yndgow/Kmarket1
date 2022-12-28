package kr.co.kmarket.controller.admin.cs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.AdminCsService;
import kr.co.kmarket.service.CsService;
import kr.co.kmarket.vo.CsNoticeVO;

@WebServlet("/admin/cs/notice/modify.do")
public class AdminCsNoticeModifyController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	CsService service = CsService.INSTANCE;
	AdminCsService service1 = AdminCsService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String notNo = req.getParameter("notNo");
		req.setAttribute("notice", service.selectNoticeArticle(notNo));
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/cs/notice/modify.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CsNoticeVO vo = new CsNoticeVO();
		vo.setCate1(req.getParameter("cate1"));
		vo.setNotTitle(req.getParameter("title"));
		vo.setNotContent(req.getParameter("content"));
		vo.setNotNo(req.getParameter("notNo"));
		
		service1.updateAdminCsNotice(vo);
		
		resp.sendRedirect("/Kmarket/admin/cs/notice/view.do?notNo="+req.getParameter("notNo"));
	}

}
