package kr.co.kmarket.controller.admin.cs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.AdminCsService;
import kr.co.kmarket.vo.CsNoticeVO;

@WebServlet("/admin/cs/notice/write.do")
public class AdminCsNoticeWriteController extends HttpServlet{
	AdminCsService service = AdminCsService.INSTANCE;
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.setAttribute("csType", req.getParameter("csType"));
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/cs/notice/write.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CsNoticeVO vo = new CsNoticeVO();
		vo.setC1Name(req.getParameter("c1Name"));
		vo.setNotTitle(req.getParameter("notTitle"));
		vo.setNotContent(req.getParameter("notContent"));
		
		service.insertAdminCsNot(vo);
		
	}
}
