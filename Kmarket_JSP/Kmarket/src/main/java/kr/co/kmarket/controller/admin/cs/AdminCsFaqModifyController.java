package kr.co.kmarket.controller.admin.cs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.AdminCsService;
import kr.co.kmarket.vo.CsFaqVO;

@WebServlet("/admin/cs/faq/modify.do")
public class AdminCsFaqModifyController extends HttpServlet{
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
		
		//req.setAttribute("cateList", service.selectFaqCateList());
		req.setAttribute("cate1List", service.selectAdminCsCate1(csType)); 
		
		String faNo = req.getParameter("faNo");
		
		req.setAttribute("faq", service.selectAdminCsFaqView(faNo)); 
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/cs/faq/modify.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		String csType = req.getParameter("csType");
		String faNo = req.getParameter("faNo");
		
		CsFaqVO vo = new CsFaqVO();
		vo.setFaTitle(req.getParameter("title"));
		vo.setFaContent(req.getParameter("content"));
		vo.setRegip(req.getRemoteAddr());
		vo.setFaNo(faNo);
		vo.setCate1(cate1);
		vo.setCate2(cate2);
		
		service.updateAdminFaq(vo);
		resp.sendRedirect("/Kmarket/admin/cs/faq/view.do?csType="+csType+"&cate1="+cate1+"&cate2="+cate2+"&no="+faNo);
	}
}
