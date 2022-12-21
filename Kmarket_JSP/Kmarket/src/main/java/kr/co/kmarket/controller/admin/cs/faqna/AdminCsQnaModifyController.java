package kr.co.kmarket.controller.admin.cs.faqna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.AdminCsService;

public class AdminCsQnaModifyController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	AdminCsService service = AdminCsService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 답변 업데이트
		String answer = req.getParameter("answer");
		String qnaNo = req.getParameter("qnaNo");
		int result = service.updateQnaAnswer(answer, qnaNo);
		if(result > 0) {
			// 1차 2차 카테고리 pg
			resp.sendRedirect("/Kmarket/admin/cs/qna/list.do?csType=qna");
		}
		
	}

}
