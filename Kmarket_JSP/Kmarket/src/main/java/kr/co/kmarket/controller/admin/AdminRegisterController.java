package kr.co.kmarket.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.AdminService;
import kr.co.kmarket.vo.ProductVO;

@WebServlet("/admin/product/register.do")
public class AdminRegisterController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	AdminService service = AdminService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String prodCate1 = req.getParameter("category1");
		String prodCate2 = req.getParameter("category2");
		String prodName = req.getParameter("prodName");
		String descript = req.getParameter("descript");
		String company = req.getParameter("company");
		String price = req.getParameter("price");
//		String point = req.getParameter("point");
//		String stock = req.getParameter("stock");
//		String delivery = req.getParameter("delivery");
//		String discount = req.getParameter("discount");
		
		ProductVO vo = new ProductVO();
		vo.setProdCate1(prodCate1);
		vo.setProdCate1(prodCate2);
		vo.setProdName(prodName);
		vo.setDescript(descript);
		vo.setCompany(company);
		vo.setPrice(price);
		
		int result = service.insertProductByAdmin(vo);
		
		if(result >0) resp.sendRedirect("./admin/product/register.do?success=100");
	}
}
