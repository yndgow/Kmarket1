package kr.co.kmarket.controller.index;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.ProductService;

@WebServlet("/index.do")
public class IndexController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// aside 공통 
		req.setAttribute("categories1", service.selectCategory1());
		req.setAttribute("categories2", service.selectCategory2());
		
		// 베스트 배너 list
		req.setAttribute("products", service.selectBestList());
		
		// 히트 상품 배너 list
		req.setAttribute("hitProducts", service.selectHitList());
		
		// 추천 상품 배너 list
		req.setAttribute("scoreProducts", service.selectScoreList());
		
		// 최신 상품 배너 list
		req.setAttribute("newProducts", service.selectNewList());
		
		// 할인 상품 배너 list
		req.setAttribute("disProducts", service.selectDisList());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/index.jsp");
		dispatcher.forward(req, resp);
	}

}
