package kr.co.kmarket.controller.admin.cs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.co.kmarket.service.AdminCsService;

@WebServlet("/admin/cs/notice/delete.do")
public class AdminCsNoticeDeleteController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	AdminCsService service = AdminCsService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("csType", req.getParameter("csType"));
		
		String arr[] = req.getParameterValues("arrNo[]");
		
		String notNo = req.getParameter("notNo");
		
		String arrNo[] = new String[10];
		if(StringUtils.isNotEmpty(notNo)) {
			arrNo[0] = notNo;
		}else {
			arrNo = arr;
		}
		int result = service.deleteAdminCsNotice(arrNo);
		
		service.jsonObj("result", result, resp);
		
		
		
	}

}
