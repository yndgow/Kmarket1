package kr.co.kmarket.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.kmarket.dao.AdminDAO_kjh;
import kr.co.kmarket.vo.AdminCsNoticeCate1VO;
import kr.co.kmarket.vo.CsNoticeVO;

public enum AdminCsService {
	INSTANCE;
	
	AdminDAO_kjh dao = AdminDAO_kjh.getInstance();
	
	//cs cate1 출력 홍민준
	public List<AdminCsNoticeCate1VO> selectCate1ByCs(){
		return dao.selectCate1ByCs();
	}
	
	// notice list 전체 출력
	public List<CsNoticeVO> selectAllNoticeArticles(int start){
		return dao.selectAllNoticeArticles(start);
	}
	
	// notice list 유형별 출력
	public List<CsNoticeVO> selectNoticeArticles(String cate1, int start){
		return dao.selectNoticeArticles(cate1,start);
	}
	
	
	// list pg 처리
	public int selectCountTotal() {
		return dao.selectCountTotal();
	}
	
	public int getLastPageNum(int total) {
		int lastPageNum = 0 ;
		if(total % 10 == 0) {
			lastPageNum = total / 10;
		}else {
			lastPageNum = total / 10 + 1;
		}
		return lastPageNum;
	}
	
	public int[] getPageGroupNum(int currentPage, int lastPageNum) {
		int currentPageGroup = (int)Math.ceil(currentPage/10.0);
		int pageGroupStart = (currentPageGroup - 1) * 10 + 1;
		int pageGroupEnd = currentPageGroup * 10;
		
		if(pageGroupEnd > lastPageNum) {
			pageGroupEnd = lastPageNum;
		}
		
		int [] result = {pageGroupStart, pageGroupEnd};
		
		return result;
	}
	
	public int getPageStartNum(int total, int currentPage) {
		int start = (currentPage -1) * 10;
		return total - start;
	}
	
	public int getCurrentPage(String pg) {
		int currentPage = 1;
		if(pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		return currentPage;
	}
	
	public int getStartNum(int currentPage) {
		return (currentPage - 1) * 10;
	}
	
	// list json 변환 메서드 김지홍
	public void gsonTojson(Object obj, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/x-json; charset=UTF-8");
		Gson gson = new Gson();
		String jsonData = gson.toJson(obj);
		PrintWriter writer = resp.getWriter();
		writer.print(jsonData);
	}
}
