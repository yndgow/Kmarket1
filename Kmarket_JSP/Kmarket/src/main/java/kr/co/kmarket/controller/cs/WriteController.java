package kr.co.kmarket.controller.cs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.CsService;
import kr.co.kmarket.vo.CsQnaVO;

@WebServlet("/cs/write.do")
public class WriteController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	CsService service = CsService.INSTANCE;
	
	@Override
	public void init() throws ServletException {
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cs/write.jsp");
		dispatcher.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
//		String uid = req.getParameter("uid");
		String qnaTitle = req.getParameter("title");
		String qnaContent = req.getParameter("content");
//		String regip = req.getRemoteAddr();
		
		
		String uid = "test";
		String regip = req.getRemoteAddr();
		
		CsQnaVO vo = new CsQnaVO();
		vo.setUid(uid);
		vo.setQnaTitle(qnaTitle);
		vo.setQnaContent(qnaContent);
		vo.setRegip(regip);
		
		service.InsertArticleQnaOfCs(vo);
		
		resp.sendRedirect("/qna/list.jsp");
	
	}
	

}
