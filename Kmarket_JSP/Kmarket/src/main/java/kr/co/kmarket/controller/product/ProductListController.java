package kr.co.kmarket.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.ProductService;
import kr.co.kmarket.vo.ProductCate1VO;
import kr.co.kmarket.vo.ProductCate2VO;
import kr.co.kmarket.vo.ProductVO;

@WebServlet("/product/list.do")
public class ProductListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// aside 공통 
		List<ProductCate1VO> categories1 = service.selectCategory1();
		List<ProductCate2VO> categories2 = service.selectCategory2();
		req.setAttribute("categories1", categories1);
		req.setAttribute("categories2", categories2);
		
		String cate1 =req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		String listSort = req.getParameter("listSort");
		if(listSort == null) listSort = "soldDesc";
		String pg = req.getParameter("pg");
		String search = req.getParameter("search");
		
		int currentPage = service.getCurrentPage(pg);// 현재 페이지 번호
		int total = 0; // 전체 게시물 갯수
		if(search == null) {
			total = service.selectCountTotal(cate1, cate2);
		}else {
			//total = service.selectCountTotal(cate1, cate2, search);
		}
		int lastPageNum = service.getLastPageNum(total);// 마지막 페이지 번호
		int[] result = service.getPageGroupNum(currentPage, lastPageNum);// 페이지 그룹 start, end 번호
		int pageStartNum = service.getPageStartNum(total, currentPage);// 페이지 시작번호
		int start = service.getStartNum(currentPage);// 시작 인덱스
		
		// 페이징 
		req.setAttribute("lastPageNum", lastPageNum);		
		req.setAttribute("currentPage", currentPage);		
		req.setAttribute("pageGroupStart", result[0]);
		req.setAttribute("pageGroupEnd", result[1]);
		req.setAttribute("pageStartNum", pageStartNum+1);
		// 검색
		req.setAttribute("search", search);

		// aside 카테고리
		req.setAttribute("cate1", cate1);
		req.setAttribute("cate2", cate2);
		
		// 상품 분류
		req.setAttribute("listSort", listSort);
		
		// 상품 select
		List<ProductVO> products = service.selectProductList(cate1, cate2, listSort, start);
		req.setAttribute("products", products);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/list.jsp");
		dispatcher.forward(req, resp);
	}
}
