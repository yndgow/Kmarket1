package kr.co.kmarket.controller.admin.cs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.AdminCsService;

@WebServlet("/admin/cs/qna/update.do")
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

		service.jsonObj("result", result, resp);
		
	}

}
