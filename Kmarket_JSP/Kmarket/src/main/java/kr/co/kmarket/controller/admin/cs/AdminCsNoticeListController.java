package kr.co.kmarket.controller.admin.cs;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.AdminCsService;
import kr.co.kmarket.vo.CsNoticeVO;

@WebServlet("/admin/cs/notice/list.do")
public class AdminCsNoticeListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private AdminCsService service = AdminCsService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pg = req.getParameter("pg");
		String cate1 = req.getParameter("cate1");
		
		//현재 페이지 번호
		int currentPage = service.getCurrentPage(pg);
		
		// 전체 게시물 갯수 
		int total = service.selectCountTotal();
		
		// 마지막 페이지 번호
		int lastPageNum = service.getLastPageNum(total);
		
		// 페이지 그룹 start, end 번호
		int[] result = service.getPageGroupNum(currentPage, lastPageNum);
		
		// 페이지 시작번호
		int pageStartNum = service.getPageStartNum(total, currentPage);
		
		// 시작 인덱스
		int start = service.getStartNum(currentPage);
		
		System.out.println("start : "+start);
		 
		// notice 전체 글 가져오기
		List<CsNoticeVO> allArticles = service.selectAllNoticeArticles(start);
		
		// view 유형별 글 가져오기
		List<CsNoticeVO> articles = service.selectNoticeArticles(cate1, start);
		
		// View에서 데이터 출력을 위한 request Scope 데이터 설정
		req.setAttribute("pg", pg);
		req.setAttribute("allArticles", allArticles);
		req.setAttribute("articles", articles);
		req.setAttribute("lastPageNum", lastPageNum);		
		req.setAttribute("currentPage", currentPage);		
		req.setAttribute("pageGroupStart", result[0]);
		req.setAttribute("pageGroupEnd", result[1]);
		req.setAttribute("pageStartNum", pageStartNum+1);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/cs/notice/list.jsp");
		dispatcher.forward(req, resp);
	}

}