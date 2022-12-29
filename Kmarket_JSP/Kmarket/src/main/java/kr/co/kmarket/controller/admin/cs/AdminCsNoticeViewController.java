package kr.co.kmarket.controller.admin.cs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.CsService;
import kr.co.kmarket.vo.CsNoticeVO;

@WebServlet("/admin/cs/notice/view.do")
public class AdminCsNoticeViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CsService service1 = CsService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String notNo = req.getParameter("notNo");
		String cate1 = req.getParameter("cate1");
		
		CsNoticeVO article = service1.selectNoticeArticle(notNo);
		
		req.setAttribute("article", article);
		req.setAttribute("cate1", cate1);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/cs/notice/view.jsp");
		dispatcher.forward(req, resp);
	}
}
