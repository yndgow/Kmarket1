package kr.co.kmarket.controller.cs;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.CsService;
import kr.co.kmarket.vo.CsNoticeVO;
import kr.co.kmarket.vo.CsQnaVO;

@WebServlet("/cs/index.do")
public class IndexController extends HttpServlet{
	CsService service = CsService.INSTANCE;
	private static final long serialVersionUID = 1L;
	CsService service2 = CsService.INSTANCE;
	@Override
	public void init() throws ServletException {
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		// index qna list 글 가져오기
		List<CsQnaVO> articles = service.selectIndexQnaArticles();
		
		req.setAttribute("articles", articles);
		
		// index notice list 최신글 5개 가져오기
		List<CsNoticeVO> notArticles = service2.selectIndexNoticeArticles();
		
		req.setAttribute("notArticles", notArticles);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/cs/index.jsp");
		dispatcher.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	

}
