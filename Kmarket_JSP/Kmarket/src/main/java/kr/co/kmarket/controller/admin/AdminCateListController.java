package kr.co.kmarket.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.AdminService;
import kr.co.kmarket.vo.ProductCate1VO;

@WebServlet("/admin/product/cate.do")
public class AdminCateListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	AdminService service = AdminService.INSTANCE; 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate = req.getParameter("cate");
		
		if(cate.equals("1")) {
			List<ProductCate1VO> cates1 = service.selectCategoryByAdmin();
			service.gsonTojson(cates1, resp);
		}
		else {
			
		}
		
	}
}
