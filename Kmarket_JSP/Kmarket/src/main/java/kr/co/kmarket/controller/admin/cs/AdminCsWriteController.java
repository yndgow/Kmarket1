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

@WebServlet("/admin/cs/write.do")
public class AdminCsWriteController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	AdminCsService service = AdminCsService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String csType = req.getParameter("csType");
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		req.setAttribute("cate1", cate1);
		req.setAttribute("cate2", cate2);
		req.setAttribute("csType", csType);
		
		// 1차유형 출력
		req.setAttribute("cate1List", service.selectAdminCsCate1(csType)); 
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/cs/faq/write.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String csType = req.getParameter("csType");
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		// faq 등록
		CsFaqVO vo = new CsFaqVO();
		vo.setCate1(cate1);
		vo.setCate2(cate2);
		vo.setFaContent(req.getParameter("content"));
		vo.setFaTitle(req.getParameter("title"));
		vo.setRegip(req.getRemoteAddr());
		
		service.insertAdminCsFaq(vo);
		resp.sendRedirect("/Kmarket/admin/cs/"+csType+"/list.do?csType="+csType+"&cate1="+cate1+"&cate2="+cate2);
	}
}
