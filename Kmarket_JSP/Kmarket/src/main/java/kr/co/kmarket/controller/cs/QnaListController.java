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
import kr.co.kmarket.vo.CsQnaVO;

@WebServlet("/cs/qna/list.do")
public class QnaListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private CsService service = CsService.INSTANCE;
	
	@Override
	public void init() throws ServletException {
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<CsQnaVO> articles = service.selectQnaArticles();
		
		req.setAttribute("articles", articles);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/qna/list.jsp");
		dispatcher.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	

}
