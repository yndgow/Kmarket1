package kr.co.kmarket.controller.adimin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.dao.ProductDAO;

@WebServlet("/admin/product/register.do")
public class ProductRegisterContorller extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getParameter("category1");
		req.getParameter("category2");
		req.getParameter("prodName");
		req.getParameter("descript");
		req.getParameter("company");
		req.getParameter("price");
		req.getParameter("point");
		req.getParameter("stock");
		req.getParameter("delivery");
		req.getParameter("discount");
		
		
	}
}
