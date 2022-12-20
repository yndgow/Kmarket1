package kr.co.kmarket.controller.admin.cs;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.AdminCsService;
import kr.co.kmarket.vo.AdminCsNoticeCate1VO;

@WebServlet("/admin/cs/cateList.do")
public class AdminCsCateController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	AdminCsService service = AdminCsService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<AdminCsNoticeCate1VO> cates1 = service.selectCate1ByCs();
		service.gsonTojson(cates1, resp);
		
		
	}

}
