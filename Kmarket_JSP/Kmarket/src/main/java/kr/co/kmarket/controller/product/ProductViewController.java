package kr.co.kmarket.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.co.kmarket.service.ProductService;
import kr.co.kmarket.vo.ProductCartVO;
import kr.co.kmarket.vo.ProductReviewVO;
import kr.co.kmarket.vo.ProductVO;

@WebServlet("/product/view.do")
public class ProductViewController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// aside 공통 
		req.setAttribute("categories1", service.selectCategory1());
		req.setAttribute("categories2", service.selectCategory2());
		
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		
		// 상품 출력
		String prodNo = req.getParameter("prodNo");
		ProductVO vo = service.selectProduct(prodNo);
		req.setAttribute("product", vo);
		
		// 메인페이지 에서 바로 접근시
		if(StringUtils.isEmpty(cate1) || StringUtils.isEmpty(cate2)) {
			cate1 = String.valueOf(vo.getProdCate1());
			cate2 = String.valueOf(vo.getProdCate2());
		}
		
		// nav 카테고리 
		req.setAttribute("cate1", cate1);
		req.setAttribute("cate2", cate2);
		
		// 상품 조회수 업데이트
		service.updateProductHit(prodNo);
		
		// 리뷰 페이징 
		String pg = req.getParameter("pg");
		
		int currentPage = service.getCurrentPage(pg);// 현재 페이지 번호
		int total = 0; // 전체 게시물 갯수
		total = service.selectCountTotalReview(prodNo);
		int lastPageNum = service.getLastPageNum(total);// 마지막 페이지 번호
		int[] result = service.getPageGroupNum(currentPage, lastPageNum);// 페이지 그룹 start, end 번호
		int pageStartNum = service.getPageStartNum(total, currentPage);// 페이지 시작번호
		int start = service.getStartNum(currentPage);// 시작 인덱스
		
		req.setAttribute("lastPageNum", lastPageNum);		
		req.setAttribute("currentPage", currentPage);		
		req.setAttribute("pageGroupStart", result[0]);
		req.setAttribute("pageGroupEnd", result[1]);
		req.setAttribute("pageStartNum", pageStartNum+1);
		
		// 리뷰 출력
		List<ProductReviewVO> reviews = service.selectReviews(prodNo, start);
		
		if(pg == null || pg.equals("")) {
			// view 페이지 첫 진입시
			req.setAttribute("reviews", reviews);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/product/view.jsp");
			dispatcher.forward(req, resp);
		}else {
			// review 페이지번호 선택시 리뷰 json 출력
			service.gsonTojson(reviews, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductCartVO vo = new ProductCartVO();
		vo.setUid(req.getParameter("uid"));
		vo.setProdNo(req.getParameter("prodNo"));
		vo.setCount(req.getParameter("count"));
		vo.setPrice(req.getParameter("price"));
		vo.setDiscount(req.getParameter("discount"));
		vo.setDelivery(req.getParameter("delivery"));
		
		int result = service.insertProductCart(vo);
		service.jsonObj("result", result, resp);
	}

}
