package kr.co.kmarket.dao;


import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.Sql;
import kr.co.kmarket.vo.AdminCsNoticeCate1VO;
import kr.co.kmarket.vo.CsCate1DTO;
import kr.co.kmarket.vo.CsCate2DTO;
import kr.co.kmarket.vo.CsFaqVO;
import kr.co.kmarket.vo.CsNoticeVO;
import kr.co.kmarket.vo.CsQnaVO;
import kr.co.kmarket.vo.ProductVO;

public class AdminDAO_kjh extends DBHelper {

	private static AdminDAO_kjh instance = new AdminDAO_kjh();
	public static AdminDAO_kjh getInstance() {
		return instance;
	}
	private AdminDAO_kjh() {}
	
	// 로거 생성
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public ProductVO selectImg(String prodNo) {
		ProductVO vo = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_IMG_FILENAME);
			psmt.setString(1, prodNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new ProductVO();
				vo.setThumb1(rs.getString(1));
				vo.setThumb2(rs.getString(2));
				vo.setThumb3(rs.getString(3));
				vo.setDetail(rs.getString(4));
				vo.setEtc3(rs.getString(5));
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("vo: "+vo);
		return vo;
		
	}
	
	//cs cate1 출력
	public List<AdminCsNoticeCate1VO> selectCate1ByCs(){
		logger.info("SELECT_CATEGORY1_BY_CS_ADMIN_NOTICE start...");
		List<AdminCsNoticeCate1VO> cates = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_CATEGORY1_BY_CS_ADMIN_NOTICE);
			while(rs.next()){
				AdminCsNoticeCate1VO vo = new AdminCsNoticeCate1VO();
				vo.setCate1(rs.getInt(1));
				vo.setC1Name(rs.getString(2));
				cates.add(vo);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("cates : "+cates);
		return cates;
	}
		
	
	// 전체 게시물 카운트 notice count all
	public int selectCountTotalNotice() {
		int total = 0;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(Sql.SELECT_COUNT_TOTAL_NOTICE);
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("total : "+total);
		return total;
	}
	
	// notice count cate1
	public int selectCountTotalNoticeCate1(String cate1) {
		logger.info("selectCountTotalNoticeCate1");
		int total = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_COUNT_TOTAL_NOTICE_CATE1);
			psmt.setString(1, cate1);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.debug("total : " + total);
		return total;
	}	
	
	
	// cs notice 전체 list 출력
	public List<CsNoticeVO> selectAllNoticeArticles(int start){
		logger.info("selectAllNoticeArticles start...");
		List<CsNoticeVO> allArticles = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_ADMIN_ALL_NOTICE_ARTICLES);
			psmt.setInt(1, start);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsNoticeVO vo = new CsNoticeVO();
				vo.setNotNo(rs.getInt(1));
				vo.setUid(rs.getString(2));
				vo.setCate1(rs.getInt(3));
				vo.setNotTitle(rs.getString(4));
				vo.setNotContent(rs.getString(5));
				vo.setHit(rs.getInt(6));
				vo.setRegip(rs.getString(7));
				vo.setRdate(rs.getString(8));
				vo.setC1Name(rs.getString(9));
				allArticles.add(vo);
			}
			close();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("allArticles : "+allArticles);
		return allArticles;
	}
	
	// cs notice 유형별 list 출력
	public List<CsNoticeVO> selectNoticeArticles(String cate1, int start) {
		logger.info("selectNoticeArticles start...");
		List<CsNoticeVO> articles = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_ADMIN_NOTICE_ARTICLES);
			psmt.setString(1, cate1);
			psmt.setInt(2, start);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsNoticeVO vo = new CsNoticeVO();
				vo.setNotNo(rs.getInt(1));
				vo.setUid(rs.getString(2));
				vo.setCate1(rs.getInt(3));
				vo.setNotTitle(rs.getString(4));
				vo.setNotContent(rs.getString(5));
				vo.setHit(rs.getInt(6));
				vo.setRegip(rs.getString(7));
				vo.setRdate(rs.getString(8));
				vo.setC1Name(rs.getString(9));
				articles.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("articles : "+articles);
		return articles;
	}
	
	// 여기부터 김지홍 작업부분
	// cs category 1 list
	public List<CsCate1DTO> selectAdminCsCate1(String tableName) {
		logger.info("selectCsCate1...kjh");
		List<CsCate1DTO> cate1List = new ArrayList<>(); 
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM " + tableName);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsCate1DTO vo = new CsCate1DTO();
				vo.setCate1(rs.getInt(1));
				vo.setC1Name(rs.getString(2));
				cate1List.add(vo);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("cate1List : "+cate1List);
		return cate1List;
	}

	// cs category 2 list
	public List<CsCate2DTO> selectAdminCsCate2(String tableName, String cate1) {
		logger.info("selectCsCate2...kjh");
		List<CsCate2DTO> cate2List = new ArrayList<>(); 

		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE `cate1` = ?");
			
			psmt.setString(1, cate1);
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsCate2DTO vo = new CsCate2DTO();
				vo.setCate1(rs.getInt(1));
				vo.setCate2(rs.getInt(2));
				vo.setC2Name(rs.getString(3));
				cate2List.add(vo);
			}
			close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("cate2List : " + cate2List);
		return cate2List;
	}

	// faq list
	public List<Object> selectAdminCsFaqList(String cate1, String cate2){
		logger.info("selectAdminCsFaqList...kjh");
		List<Object> faqList = new ArrayList<>(); 

		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_ADMIN_CS_FAQ_LIST_CATE);
			psmt.setString(1, cate1);
			psmt.setString(2, cate2);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsFaqVO vo = new CsFaqVO();
				vo.setFaNo(rs.getInt(1));
				vo.setUid(rs.getString(2));
				vo.setCate1(rs.getInt(3));
				vo.setCate2(rs.getInt(4));
				vo.setFaTitle(rs.getString(5));
				vo.setFaContent(rs.getString(6));
				vo.setHit(rs.getInt(7));
				vo.setRegip(rs.getString(8));
				vo.setRdate(rs.getString(9).substring(2,10));
				vo.setC1Name(rs.getString(10));
				vo.setC2Name(rs.getString(11));
				faqList.add(vo);
			}
			close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("faqList : " + faqList);
		return faqList;
	}
	
	// qna list
	public List<Object> selectAdminCsQnaList(String cate1, String cate2, int start){
		logger.info("selectAdminCsQnaList...kjh");
		List<Object> qnaList = new ArrayList<>(); 

		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_ADMIN_CS_QNA_LIST_CATE);
			psmt.setString(1, cate1);
			psmt.setString(2, cate2);
			psmt.setInt(3, start);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsQnaVO vo = new CsQnaVO();
				vo.setQnaNo(rs.getInt(1));
				vo.setUid(rs.getString(2).replaceAll("(?<=.{3}).", "*"));
				vo.setCate1(rs.getInt(3));
				vo.setCate2(rs.getInt(4));
				vo.setQnaTitle(rs.getString(5));
				vo.setQnaContent(rs.getString(6));
				vo.setRegip(rs.getString(7));
				vo.setRdate(rs.getString(8).substring(2,10));
				vo.setQnaCond(rs.getString(9));
				vo.setAnswer(rs.getString(10));
				vo.setC1Name(rs.getString(11));
				vo.setC2Name(rs.getString(12));
				qnaList.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("qnaList : " + qnaList);
		return qnaList;
	}
	
	// qna list all
	public List<Object> selectAdminCsQnaListAll(int start){
		logger.info("selectAdminCsQnaListAll...kjh");
		List<Object> qnaList = new ArrayList<>(); 

		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_ADMIN_CS_QNA_LIST_ALL);
			psmt.setInt(1, start);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsQnaVO vo = new CsQnaVO();
				vo.setQnaNo(rs.getInt(1));
				vo.setUid(rs.getString(2).replaceAll("(?<=.{3}).", "*"));
				vo.setCate1(rs.getInt(3));
				vo.setCate2(rs.getInt(4));
				vo.setQnaTitle(rs.getString(5));
				vo.setQnaContent(rs.getString(6));
				vo.setRegip(rs.getString(7));
				vo.setRdate(rs.getString(8).substring(2,10));
				vo.setQnaCond(rs.getString(9));
				vo.setAnswer(rs.getString(10));
				vo.setC1Name(rs.getString(11));
				vo.setC2Name(rs.getString(12));
				qnaList.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("qnaList : " + qnaList);
		return qnaList;
	}
	
	
	// faq insert
	public int insertAdminCsFaq(CsFaqVO vo) {
		logger.info("insertAdminCsFaq...kjh");
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.INSERT_ADMIN_CS_FAQ);
			psmt.setInt(1, vo.getCate1());
			psmt.setInt(2, vo.getCate2());
			psmt.setString(3, vo.getFaTitle());
			psmt.setString(4, vo.getFaContent());
			psmt.setString(5, vo.getRegip());
			result = psmt.executeUpdate();
			
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}
	
	// faq cate2 count
	public int selectCountFaqCate2(String cate1, String cate2){
		logger.info("selectCountFaqCate2...kjh");
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_COUNT_FAQ_CATE2);
			psmt.setString(1, cate1);
			psmt.setString(2, cate2);
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}
	
	// qna view
	public CsQnaVO selectAdminCsQnaView(String cate1, String cate2, String qnaNo){
		logger.info("selectAdminCsQnaView...kjh");
		CsQnaVO vo = null; 

		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_ADMIN_CS_QNA_VIEW);
			psmt.setString(1, cate1);
			psmt.setString(2, cate2);
			psmt.setString(3, qnaNo);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new CsQnaVO();
				vo.setQnaNo(rs.getInt(1));
				vo.setUid(rs.getString(2).replaceAll("(?<=.{3}).", "*"));
				vo.setCate1(rs.getInt(3));
				vo.setCate2(rs.getInt(4));
				vo.setQnaTitle(rs.getString(5));
				vo.setQnaContent(rs.getString(6));
				vo.setRegip(rs.getString(7));
				vo.setRdate(rs.getString(8).substring(2,10));
				vo.setQnaCond(rs.getString(9));
				vo.setAnswer(rs.getString(10));
				vo.setC1Name(rs.getString(11));
				vo.setC2Name(rs.getString(12));
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("vo : " + vo);
		return vo;
	}
	
	
	// update qna answer
	public int updateQnaAnswer(String answer, String qnaNo){
		logger.info("updateQnaAnswer...kjh");
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_QNA_ANSWER);
			psmt.setString(1, answer);
			psmt.setString(2, qnaNo);
			result = psmt.executeUpdate();
			close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}
	

	// qna count total all
	public int selectCountTotalQna(){
		logger.info("selectCountTotalQna...kjh");
		int result = 0;

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_COUNT_TOTAL_QNA);
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}
	
	
	// qna count total cate
	public int selectCountTotalQnaCate(String cate1, String cate2){
		logger.info("selectCountTotalQnaCate...kjh");
		int result = 0;

		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_COUNT_TOTAL_QNA_CATE);
			psmt.setString(1, cate1);
			psmt.setString(2, cate2);
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}
	
	// delete update qna
	public int deleteAdminCsQna(String qnaNo){
		logger.info("deleteAdminCsQna...kjh");
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.DELETE_QNA);
			psmt.setString(1, qnaNo);
			result = psmt.executeUpdate();
			close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}
	
	// delete check qna
	public int deleteAdminCsCheckQna(String[] arrNo){
		logger.info("deleteAdminCsCheckQna...kjh");
		int result = 0;
		for(int i=0; i<arrNo.length; i++) {
			try {
				conn = getConnection();
				psmt = conn.prepareStatement(Sql.DELETE_QNA);
				psmt.setString(1, arrNo[i]);
				result += psmt.executeUpdate();
				close();

			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		
		logger.debug("result : " + result);
		return result;
	}
	
	// cs faq view
	public CsFaqVO selectAdminCsFaqView(String cate1, String cate2, String faNo) {
		logger.info("selectAdminCsFaqView...kjh");
		CsFaqVO vo = null; 

		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_ADMIN_CS_FAQ_VIEW);
			psmt.setString(1, cate1);
			psmt.setString(2, cate2);
			psmt.setString(3, faNo);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new CsFaqVO();
				vo.setFaNo(rs.getInt(1));
				vo.setUid(rs.getString(2));
				vo.setCate1(rs.getInt(3));
				vo.setCate2(rs.getInt(4));
				vo.setFaTitle(rs.getString(5));
				vo.setFaContent(rs.getString(6));
				vo.setHit(rs.getInt(7));
				vo.setRegip(rs.getString(8));
				vo.setRdate(rs.getString(9).substring(2,10));
				vo.setC1Name(rs.getString(10));
				vo.setC2Name(rs.getString(11));
			}
			close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("vo : " + vo);
		return vo;
	}

	// delete check faq
	public int deleteAdminCsCheckFaq(String[] arrNo) {
		logger.info("deleteAdminCsCheckFaq...kjh");
		int result = 0;
		for(int i=0; i<arrNo.length; i++) {
			try {
				conn = getConnection();
				psmt = conn.prepareStatement(Sql.DELETE_FAQ);
				psmt.setString(1, arrNo[i]);
				result += psmt.executeUpdate();
				close();
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		logger.debug("result : " + result);
		return result;
	}
	
	// delete faq
	public int deleteAdminCsFaq(String arrNo) {
		logger.info("deleteAdminCsCheckFaq...kjh");
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.DELETE_FAQ);
			psmt.setString(1, arrNo);
			result += psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}
	
	// cs faq view
	public CsFaqVO selectAdminCsFaqView(String faNo) {
		logger.info("selectAdminCsFaqView...kjh");
		CsFaqVO vo = null; 

		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_FAQ_VIEW_FANO);
			psmt.setString(1, faNo);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new CsFaqVO();
				vo.setFaNo(rs.getInt(1));
				vo.setUid(rs.getString(2));
				vo.setCate1(rs.getInt(3));
				vo.setCate2(rs.getInt(4));
				vo.setFaTitle(rs.getString(5));
				vo.setFaContent(rs.getString(6));
				vo.setHit(rs.getInt(7));
				vo.setRegip(rs.getString(8));
				vo.setRdate(rs.getString(9).substring(2,10));
				vo.setC1Name(rs.getString(10));
				vo.setC2Name(rs.getString(11));
			}
			close();

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("vo : " + vo);
		return vo;
	}
	
	// faq insert
	public int updateAdminFaq(CsFaqVO vo) {
		logger.info("updateAdminFaq...kjh");
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_ADMIN_FAQ);
			psmt.setString(1, vo.getFaTitle());
			psmt.setString(2, vo.getFaContent());
			psmt.setString(3, vo.getRegip());
			psmt.setInt(4, vo.getCate1());
			psmt.setInt(5, vo.getCate2());
			psmt.setInt(6, vo.getFaNo());
			
			result = psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}
	
	public List<CsCate1DTO> selectFaqCateList(){
		List<CsCate1DTO> cateList = new ArrayList<>();
		
		logger.info("selectFaqCateList");
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_FAQ_CATE_LIST);
			while(rs.next()) {
				CsCate1DTO vo = new CsCate1DTO();
				vo.setCate1(rs.getInt(1));
				vo.setC1Name(rs.getString(2));
				vo.setCate2(rs.getInt(3));
				vo.setC2Name(rs.getString(4));
				cateList.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("cateList : " + cateList);
		return cateList;
	}
	
	
	
	
	
}

