package kr.co.kmarket.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.kmarket.dao.AdminDAO;
import kr.co.kmarket.dao.AdminDAO_kjh;
import kr.co.kmarket.vo.AdminCsNoticeCate1VO;
import kr.co.kmarket.vo.CsCate1DTO;
import kr.co.kmarket.vo.CsCate2DTO;
import kr.co.kmarket.vo.CsFaqVO;
import kr.co.kmarket.vo.CsNoticeVO;
import kr.co.kmarket.vo.CsQnaVO;

public enum AdminCsService {
	INSTANCE;
	
	AdminDAO_kjh dao = AdminDAO_kjh.getInstance();
	AdminDAO dao2 = AdminDAO.getInstance();
	
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
	public int selectCountTotalNotice() {
		return dao.selectCountTotalNotice();
	}
	
	public int selectCountTotalNoticeCate1(String cate1) {
		return dao.selectCountTotalNoticeCate1(cate1);
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
	
	// admin cs notice
	public int deleteAdminCsNotice(String[] arrNo) {
		return dao2.deleteAdminCsNotice(arrNo);
	}
	
	public int insertAdminCsNot(CsNoticeVO vo) {
		return dao2.insertAdminCsNot(vo);
	}
	
	public int updateAdminCsNotice(CsNoticeVO vo) {
		return dao2.updateAdminCsNotice(vo);
	}
	
	
	
	// 김지홍 faq qna 작업
	// category 1 cate1
	public List<CsCate1DTO> selectAdminCsCate1(String csType){
		String tableName = "";
		if(csType.equals("faq")) {
			tableName = "km_cs_faq_cate1";
		}else if(csType.equals("qna")){
			tableName = "km_cs_qna_cate1";
		}else {
			tableName = "km_cs_notice_cate1";
		}
		return dao.selectAdminCsCate1(tableName);
	}
	
	// category 2 cate2
	public List<CsCate2DTO> selectAdminCsCate2(String csType, String cate1) {
		String tableName = "";
		if(csType.equals("faq")) {
			tableName = "km_cs_faq_cate2";
		}else if(csType.equals("qna")){
			tableName = "km_cs_qna_cate2";
		}else {
			tableName = "km_cs_notice_cate2";
		}
		return dao.selectAdminCsCate2(tableName, cate1);
	}
	
	// faq qna list cate1 1 cate1 1 default
	public List<Object> selectAdminCsFaqList(String cate1, String cate2, String csType, int start){
		boolean cateEmpty = StringUtils.isEmpty(cate1); 
		if(csType.equals("faq")) {
			if(cateEmpty) { //
				cate1 = "1";
				cate2 = "1";
			}
			return dao.selectAdminCsFaqList(cate1, cate2);
			
		}else if(csType.equals("qna")) {
			if(cateEmpty) {
				return dao.selectAdminCsQnaListAll(start);
			}
			return dao.selectAdminCsQnaList(cate1, cate2, start);
		}
		
		return null;
	}	
	// insert faq
	public int insertAdminCsFaq(CsFaqVO vo) {
		return dao.insertAdminCsFaq(vo);
	}
	// count faq cate2 max 10
	public int selectCountFaqCate2(String cate1, String cate2){
		return dao.selectCountFaqCate2(cate1, cate2);
	}
	// qna view
	public CsQnaVO selectAdminCsQnaView(String cate1, String cate2, String qnaNo){
		return dao.selectAdminCsQnaView(cate1, cate2, qnaNo);
	}
	public CsFaqVO selectAdminCsFaqView(String cate1, String cate2, String qnaNo){
		return dao.selectAdminCsFaqView(cate1, cate2, qnaNo);
	}
	
	// update qna answer
	public int updateQnaAnswer(String answer, String qnaNo){
		return dao.updateQnaAnswer(answer, qnaNo);
	}
	// qna count total all
	public int selectCountTotalQna(){
		return dao.selectCountTotalQna();
	}
	// qna count total cate
	public int selectCountTotalQnaCate(String cate1, String cate2){
		return dao.selectCountTotalQnaCate(cate1, cate2);
	}
	// qna delete
	public int deleteAdminCsQna(String qnaNo){
		return dao.deleteAdminCsQna(qnaNo);
	}
	// delete check qna
	public int deleteAdminCsCheckQna(String[] arrNo){
		return dao.deleteAdminCsCheckQna(arrNo);
	}
	// delete check faq
	public int deleteAdminCsCheckFaq(String[] arrNo){
		return dao.deleteAdminCsCheckFaq(arrNo);
	}
	// delete faq
	public int deleteAdminCsFaq(String arrNo) {
		return dao.deleteAdminCsFaq(arrNo);
	}
	// select faq
	public CsFaqVO selectAdminCsFaqView(String faNo) {
		return dao.selectAdminCsFaqView(faNo);
	}
	// update faq
	public int updateAdminFaq(CsFaqVO vo) {
		return dao.updateAdminFaq(vo);
	}
	
	public List<CsCate1DTO> selectFaqCateList(){
		return dao.selectFaqCateList();
	}
	
	
	
	// json property 추가 후 json 반환
	public void jsonObj(String key, int value, HttpServletResponse resp) throws IOException {
		JsonObject json = new JsonObject();
		json.addProperty(key, value);
		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());
	}
}
