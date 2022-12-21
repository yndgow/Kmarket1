package kr.co.kmarket.controller.admin.cs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.AdminCsService;
import kr.co.kmarket.service.CsService;

@WebServlet("/admin/cs/qna/list.do")
public class AdminCsQnaListController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	AdminCsService service = AdminCsService.INSTANCE;
	CsService service2 = CsService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String csType = req.getParameter("csType");
		req.setAttribute("csType", csType);
		
		// 1차유형 출력
		req.setAttribute("cate1List", service.selectAdminCsCate1(csType)); 
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/cs/qna/list.jsp");
		dispatcher.forward(req, resp);
	}

}
