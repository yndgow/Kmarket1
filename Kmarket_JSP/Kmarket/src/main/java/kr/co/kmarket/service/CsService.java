package kr.co.kmarket.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.kmarket.dao.CsDAO;
import kr.co.kmarket.vo.CsCate1DTO;
import kr.co.kmarket.vo.CsCate2DTO;
import kr.co.kmarket.vo.CsFaqVO;
import kr.co.kmarket.vo.CsNoticeVO;
import kr.co.kmarket.vo.CsQnaVO;

public enum CsService {
	INSTANCE;
	CsDAO dao = CsDAO.getInstance();
	
	//cs 문의하기 등록 홍민준
	public int InsertArticleQnaOfCs(CsQnaVO vo){
		return dao.InserArticleQna(vo);
	}
	//cs cate1 출력 홍민준
	public List<CsCate1DTO> selectCate1ByCs(){
		return dao.selectCate1ByCs();
	}
	//cs cate2 출력 홍민준
	public List<CsCate2DTO> selectCate2ByCs(String cate2){
		return dao.selectCate2ByCs(cate2);
	}
	
	// cs index qna list 출력 홍민준
	public List<CsQnaVO> selectIndexQnaArticles(){
		return dao.selectIndexQnaArticles();
	}
	
	
	//cs list 출력 홍민준
	public List<CsQnaVO> selectQnaArticles(String cate1, int start){
		return dao.selectQnaArticles(cate1, start);
	}
	
	public int selectCountTotalQnaCate1(String cate1) {
		return dao.selectCountTotalQnaCate1(cate1);
	}
	
	//cs view 출력
	public CsQnaVO selectQnaArticle(String qnaNo) {
		return dao.selectQnaArticle(qnaNo);
	}
	
	// 공지사항 글 불러오기	
	public List<CsNoticeVO> selectNoticeArticles(String cate1, int start){
		return dao.selectNoticeArticles(cate1, start);
	}
	
	// 공지사항 리스트 페이징작업
	public int selectCountTotalNotice() {
		return dao.selectCountTotalNotice();
	}
	
	// 공지사항 리스트 카테고리별 페이징 작업
	public int selectCountCateTotal(String cate1) {
		return dao.selectCountCateTotal(cate1);
	}
	
	// 공지사항 글보기
	public CsNoticeVO selectNoticeArticle(String notNo) {
		return dao.selectNoticeArticle(notNo);
	}

	// 자주묻는질문 글 불러오기
	public List<CsFaqVO> selectFaqArticles(String cate1){
		return dao.selectFaqArticles(cate1);
	}
	
	// 자주묻는질문 카테고리 불러오기
	public List<CsCate2DTO> selectFaqCates(String cate1){
		return dao.selectFaqCates(cate1);
	}
	
	// 자주묻는질문 글보기
	public CsFaqVO selectFaqArticle(String faNo) {
		return dao.selectFaqArticle(faNo);
	}
	
	// cs초기화면에 공지사항 최신글 5개 불러오기
	public List<CsNoticeVO> selectIndexNoticeArticles(){
		return dao.selectIndexNoticeArticles();
	}
	

	// 페이징작업
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
