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
import kr.co.kmarket.vo.ProductVO;

@WebServlet("/product/list.do")
public class ProductListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProductVO> products = service.selectProductList(req.getParameter("listSort"));
		req.setAttribute("products", products);
		//String cate1 =req.getParameter("cate1");
		//String cate2 = req.getParameter("cate2");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/list.jsp");
		dispatcher.forward(req, resp);
	}
}
