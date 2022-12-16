package kr.co.kmarket.controller.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.ProductService;
import kr.co.kmarket.vo.ProductCartVO;

@WebServlet("/product/cart.do")
public class ProductCartController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// aside 공통 
		req.setAttribute("categories1", service.selectCategory1());
		req.setAttribute("categories2", service.selectCategory2());
		req.setAttribute("carts", service.selectCart(req.getParameter("uid")));
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/product/cart.jsp");
		dispatcher.forward(req, resp);
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
