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
import kr.co.kmarket.vo.CsCate2DTO;
import kr.co.kmarket.vo.CsFaqVO;

@WebServlet("/cs/faq/list.do")
public class FaqListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	CsService service = CsService.INSTANCE;
	
	@Override
	public void init() throws ServletException {
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		req.setAttribute("cate1", cate1);
		req.setAttribute("cate2", cate2);
		
		// 글 가져오기
		List<CsFaqVO> articles = service.selectFaqArticles(cate1); 
				
		// 카테고리 가져오기
		List<CsCate2DTO> cates = service.selectFaqCates(cate1);
				
		req.setAttribute("articles", articles);
		req.setAttribute("cates", cates);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/cs/faq/list.jsp");
		dispatcher.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	

}
