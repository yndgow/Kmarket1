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

@WebServlet("/cs/qna/write.do")
public class QnaWriteController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	CsService service = CsService.INSTANCE;
	
	@Override
	public void init() throws ServletException {
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/cs/qna/write.jsp");
		dispatcher.forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String uid = "test";
//		String uid = req.getParameter("uid");
		String cate1 = req.getParameter("c1Name");
		String cate2 = req.getParameter("c2Name");
		String qnaTitle = req.getParameter("title");
		String qnaContent = req.getParameter("content");
		String regip = req.getRemoteAddr();
		
		
		CsQnaVO vo = new CsQnaVO();
		vo.setUid(uid);
		vo.setCate1(cate1);
		vo.setCate2(cate2);
		vo.setQnaTitle(qnaTitle);
		vo.setQnaContent(qnaContent);
		vo.setRegip(regip);
		
		
		service.InsertArticleQnaOfCs(vo);
		
		resp.sendRedirect("/Kmarket/WEB-INF/cs/qna/list.jsp");
			
			
		
	
	}
	

}