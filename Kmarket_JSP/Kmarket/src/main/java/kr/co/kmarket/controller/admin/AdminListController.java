package kr.co.kmarket.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import kr.co.kmarket.service.AdminService;
import kr.co.kmarket.vo.MemberVO;
import kr.co.kmarket.vo.ProductVO;

@WebServlet("/admin/product/list.do")
public class AdminListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	AdminService service = AdminService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pg = req.getParameter("pg");
		String searchContent = req.getParameter("searchContent");
		String searchCate= req.getParameter("search");
		HttpSession sess = req.getSession();
		MemberVO vo = (MemberVO) sess.getAttribute("sessUser");
		String seller = vo.getUid();
		int currentPage = service.getCurrentPage(pg);// 현재 페이지 번호
		
		//페이지 번호
		int total = 0; // 전체 게시물 갯수 
		if(StringUtils.isEmpty(searchContent)) {
			if(seller.equals("admin")) {
				total = service.selectCountTotalAdmin();
			}else {
				total = service.selectCountTotalProdSeller(seller);
			}
		}else {
			total = service.selectCountTotalKeywordSearchCate(searchContent, searchCate);
		}
		
		int lastPageNum = service.getLastPageNum(total);// 마지막 페이지 번호
		int[] result = service.getPageGroupNum(currentPage, lastPageNum);// 페이지 그룹 start, end 번호
		int pageStartNum = service.getPageStartNum(total, currentPage);// 페이지 시작번호
		int start = service.getStartNum(currentPage);// 시작 인덱스
	
		
		List<ProductVO> products = new ArrayList<>();
		if(StringUtils.isEmpty(searchContent)) {
			if(seller.equals("admin")) {
				products = service.selectProductsAdmin(start);
			}else {
				products = service.selectProducts(seller, start);
			}
		}else {
			products = service.selectproductByKeyword(searchContent, start, searchCate);
		}
		
		req.setAttribute("lastPageNum", lastPageNum);		
		req.setAttribute("currentPage", currentPage);		
		req.setAttribute("pageGroupStart", result[0]);
		req.setAttribute("pageGroupEnd", result[1]);
		req.setAttribute("pageStartNum", pageStartNum+1);
		req.setAttribute("searchContent", searchContent);
		req.setAttribute("searchCate", searchCate);
		req.setAttribute("products", products);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/admin/product/list.jsp");
		dispatcher.forward(req, resp);
	}
	

}
