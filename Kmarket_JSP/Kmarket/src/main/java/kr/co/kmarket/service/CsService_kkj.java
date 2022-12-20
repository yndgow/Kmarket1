package kr.co.kmarket.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.kmarket.dao.CsDAO_kkj;
import kr.co.kmarket.vo.CsNoticeVO;

public enum CsService_kkj {
	INSTANCE;
	CsDAO_kkj dao = CsDAO_kkj.getInstance();
	
		
	public List<CsNoticeVO> selectNoticeArticles(int start){
		return dao.selectNoticeArticles(start);
	}
	
	public int selectCountTotal() {
		return dao.selectCountTotal();
	}
	
	public CsNoticeVO selectNoticeArticle(String no) {
		return dao.selectNoticeArticle(no);
	}


	//cs list 출력 홍민준
//	public List<CsQnaVO> selectQnaArticles(){
//		return dao.selectQnaArticles(start);
		
//	}
	//cs view 출력
	public CsQnaVO selectQnaArticle(String qnaNo) {
		return dao.selectQnaArticle(qnaNo);
	}

	
		public int getLastPageNum(int total) {
			
			int lastPageNum = 0;
			
			if(total % 10 == 0){
				lastPageNum = total / 10;
			}else{
				lastPageNum = total / 10 + 1;
			}
			
			return lastPageNum;
		}
		
		public int[] getPageGroupNum(int currentPage, int lastPageNum) {
			int currentPageGroup = (int)Math.ceil(currentPage / 10.0);
			int pageGroupStart = (currentPageGroup - 1) * 10 + 1;
			int pageGroupEnd = currentPageGroup * 10;
			
			if(pageGroupEnd > lastPageNum){
				pageGroupEnd = lastPageNum;
			}
			
			int[] result = {pageGroupStart, pageGroupEnd};
			
			return result;
		}
		
		public int getPageStartNum(int total, int currentPage) {
			int start = (currentPage - 1) * 10;
			return total - start;
		}
		
		public int getCurrentPage(String pg) {
			int currentPage = 1;
			
			if(pg != null){
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