package kr.co.kmarket.controller.admin.cs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.AdminCsService;

@WebServlet("/admin/cs/cateList.do")
public class AdminCsCateController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	AdminCsService service = AdminCsService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String csType = req.getParameter("csType");
		String cate = req.getParameter("cate");
		String cate1 = req.getParameter("cate1");
		if(cate.equals("1")) {
			// cs 1번 카테고리
			service.gsonTojson(service.selectCsCate1(csType), resp);
		}else {
			// cs 2번 카테고리
			if(!csType.equals("notice")) service.gsonTojson(service.selectCsCate2(csType, cate1), resp);
		}
		
		
	}

}
