package kr.co.kmarket.controller.admin.cs;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.AdminCsService;
import kr.co.kmarket.vo.CsCate2DTO;

@WebServlet("/admin/cs/cate.do")
public class AdminCsCateController_kjh extends HttpServlet{
	private static final long serialVersionUID = 1L;
	AdminCsService service = AdminCsService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String csType = req.getParameter("csType");
		String cate1 = req.getParameter("cate1");
		List<CsCate2DTO> cate2List = service.selectAdminCsCate2(csType, cate1);
		service.gsonTojson(cate2List, resp);
	}
	

}
