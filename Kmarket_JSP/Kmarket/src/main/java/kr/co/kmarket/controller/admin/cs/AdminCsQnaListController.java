package kr.co.kmarket.controller.admin.cs;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.co.kmarket.service.AdminCsService;
import kr.co.kmarket.service.CsService;

@WebServlet("/admin/cs/qna/list.do")
public class AdminCsQnaListController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	AdminCsService service = AdminCsService.INSTANCE;
	CsService service2 = CsService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String csType = req.getParameter("csType");
		req.setAttribute("csType", csType);
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		req.setAttribute("cate1", cate1);
		req.setAttribute("cate2", cate2);
		
		
		// 1차유형 출력
		req.setAttribute("cate1List", service.selectAdminCsCate1(csType)); 
		
		// 페이징
		String pg = req.getParameter("pg");
		int currentPage = service.getCurrentPage(pg);// 현재 페이지 번호
		int total = 0; // 전체 게시물 갯수
		
		// cate1 이 없으면 전체갯수 있으면 cate1, 2 에 따른 전체갯수
		if(StringUtils.isEmpty(cate1)) {
			total = service.selectCountTotalQna();
		}else {
			total = service.selectCountTotalQnaCate(cate1, cate2);
		}
		
		int lastPageNum = service.getLastPageNum(total);// 마지막 페이지 번호
		int[] result = service.getPageGroupNum(currentPage, lastPageNum);// 페이지 그룹 start, end 번호
		int pageStartNum = service.getPageStartNum(total, currentPage);// 페이지 시작번호
		int start = service.getStartNum(currentPage);// 시작 인덱스
		
		req.setAttribute("lastPageNum", lastPageNum);		
		req.setAttribute("currentPage", currentPage);		
		req.setAttribute("pageGroupStart", result[0]);
		req.setAttribute("pageGroupEnd", result[1]);
		req.setAttribute("pageStartNum", pageStartNum+1);
		
		// qna 리스트 출력
		
		List<Object> qnaList = service.selectAdminCsFaqList(cate1, cate2, csType, start);
		req.setAttribute("qnaList", qnaList);
		
		//service.gsonTojson(qnaList, resp);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/cs/qna/list.jsp");
		dispatcher.forward(req, resp);
	}

}
