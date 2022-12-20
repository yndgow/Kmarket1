package kr.co.kmarket.controller.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.ProductService;

@WebServlet("/product/order.do")
public class ProductOrderController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// aside 공통 
		req.setAttribute("categories1", service.selectCategory1());
		req.setAttribute("categories2", service.selectCategory2());
		
		String cartNo[] = req.getParameterValues("cartNo");
		
		// 선택된 상품만 셀렉
		req.setAttribute("carts", service.selectProductCartForOrder(cartNo));
		
		// 주문정보 셀렉
		req.setAttribute("order", service.selectOrder(req.getParameter("uid")));
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/product/order.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// order item 입력
		
		// order 업데이트
	}

}
