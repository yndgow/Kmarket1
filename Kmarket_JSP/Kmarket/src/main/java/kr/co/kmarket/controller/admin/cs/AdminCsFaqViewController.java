package kr.co.kmarket.controller.admin.cs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.AdminCsService;

@WebServlet("/admin/cs/faq/view.do")
public class AdminCsFaqViewController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	AdminCsService service = AdminCsService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String csType = req.getParameter("csType");
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");

		req.setAttribute("csType", csType);
		req.setAttribute("cate1", cate1);
		req.setAttribute("cate2", cate2);
		
		String no = req.getParameter("no");		
		
		req.setAttribute("faq", service.selectAdminCsFaqView(cate1, cate2, no)); 
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/cs/faq/view.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String arrNo[] = req.getParameterValues("arrNo[]");
		int result = service.deleteAdminCsCheckFaq(arrNo);
		service.jsonObj("result", result, resp);
	}
}
