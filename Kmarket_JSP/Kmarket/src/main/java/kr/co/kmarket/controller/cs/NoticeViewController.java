package kr.co.kmarket.controller.cs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.CsService;
import kr.co.kmarket.vo.CsNoticeVO;

@WebServlet("/cs/notice/view.do")
public class NoticeViewController extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	CsService service = CsService.INSTANCE;
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String notNo = req.getParameter("notNo");
		String cate1 = req.getParameter("cate1");
		
		CsNoticeVO article = service.selectNoticeArticle(notNo);
		
		req.setAttribute("article", article);
		req.setAttribute("cate1", cate1);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/cs/notice/view.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
