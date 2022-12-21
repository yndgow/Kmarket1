package kr.co.kmarket.controller.admin.cs;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.AdminCsService;

@WebServlet("/admin/cs/list.do")
public class AdminCsListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	AdminCsService service = AdminCsService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		String csType = req.getParameter("csType");
		
		List<Object> csList = service.selectAdminCsFaqList(cate1, cate2, csType);
		
		service.gsonTojson(csList, resp);
	}

}
