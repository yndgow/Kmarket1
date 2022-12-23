package kr.co.kmarket.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.kmarket.service.AdminService;
import kr.co.kmarket.vo.ProductCate1VO;
import kr.co.kmarket.vo.ProductCate2VO;

@WebServlet("/admin/product/cate.do")
public class AdminCateListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	AdminService service = AdminService.INSTANCE; 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		
		if(cate1.equals("1")) {
			List<ProductCate1VO> cates1 = service.selectCategory1ByAdmin();
			//service.gsonTojson(cates1, resp);
			service.gsonTojson(cates1, resp);
//			Gson gson = new Gson();
//			String jsonData = gson.toJson(cates1);
//			PrintWriter writer = resp.getWriter();
//			writer.print(jsonData);
			
		}
		else {
			List<ProductCate2VO> cates2 = service.selectCategory2ByAdmin(cate2);
			service.gsonTojson(cates2, resp);
		}
		
	}
}
