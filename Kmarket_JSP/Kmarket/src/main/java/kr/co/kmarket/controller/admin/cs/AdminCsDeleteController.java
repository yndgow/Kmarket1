package kr.co.kmarket.controller.admin.cs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.co.kmarket.service.AdminCsService;

@WebServlet("/admin/cs/delete.do")		
public class AdminCsDeleteController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	AdminCsService service = AdminCsService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// qna view에서 삭제
		
		String qnaNo = req.getParameter("qnaNo");
		if(StringUtils.isNotEmpty(qnaNo)) {
			service.jsonObj("result", service.deleteAdminCsQna(qnaNo), resp);
		}else {
			String faNo = req.getParameter("faNo");
			service.jsonObj("result", service.deleteAdminCsFaq(faNo), resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 체크삭제
		String arrNo[] =req.getParameterValues("arrNo[]");
		String csType = req.getParameter("csType");
		if(csType.equals("qna")) {
			int result = service.deleteAdminCsCheckQna(arrNo);
			service.jsonObj("result", result, resp);
		}else {
			int result = service.deleteAdminCsCheckFaq(arrNo);
			service.jsonObj("result", result, resp);
		}
		
		
	}

}
