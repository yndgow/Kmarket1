package kr.co.kmarket.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.kmarket.service.ProductService;
import kr.co.kmarket.vo.ProductOrderItemVO;

@WebServlet("/product/cart.do")
public class ProductCartController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// aside 공통 
		req.setAttribute("categories1", service.selectCategory1());
		req.setAttribute("categories2", service.selectCategory2());
		req.setAttribute("carts", service.selectCarts(req.getParameter("uid")));
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/product/cart.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 장바구니에서 주문으로

		String jsonStr = service.getBody(req);
		ObjectMapper om = new ObjectMapper();
		List<ProductOrderItemVO> m = om.readValue(jsonStr, new TypeReference<List<ProductOrderItemVO>>(){});
		
		for(int i=0; i<m.size(); i++) {
			System.out.println(m.get(i).getPrice());
		}
	}
}
