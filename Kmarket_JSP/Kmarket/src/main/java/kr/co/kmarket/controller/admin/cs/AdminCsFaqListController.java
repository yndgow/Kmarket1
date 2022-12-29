package kr.co.kmarket.controller.admin.cs;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.AdminCsService;

@WebServlet("/admin/cs/faq/list.do")
public class AdminCsFaqListController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	AdminCsService service = AdminCsService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String csType = req.getParameter("csType");
		req.setAttribute("csType", csType);
		
		// 1차유형 출력
		req.setAttribute("cate1List", service.selectAdminCsCate1(csType)); 
		
		// 리스트 출력
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		req.setAttribute("cate1", cate1);
		req.setAttribute("cate2", cate2);
		List<Object> faqList =service.selectAdminCsFaqList(cate1, cate2, csType, 0);
		req.setAttribute("faqList", faqList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/cs/faq/list.jsp");
		dispatcher.forward(req, resp);
	}

}
