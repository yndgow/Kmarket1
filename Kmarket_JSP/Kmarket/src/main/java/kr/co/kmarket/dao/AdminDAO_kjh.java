package kr.co.kmarket.dao;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.Sql_hong;
import kr.co.kmarket.db.Sql_kjh;
import kr.co.kmarket.vo.AdminCsNoticeCate1VO;
import kr.co.kmarket.vo.AdminCsNoticeCate2VO;
import kr.co.kmarket.vo.CsCate1DTO;
import kr.co.kmarket.vo.CsCate2DTO;
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
			psmt = conn.prepareStatement(Sql_kjh.SELECT_IMG_FILENAME);
			psmt.setString(1, prodNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new ProductVO();
				vo.setThumb1(rs.getString(1));
				vo.setThumb2(rs.getString(2));
				vo.setThumb3(rs.getString(3));
				vo.setDetail(rs.getString(4));
			}
			close();
		} catch (Exception e) {
			// TODO: handle exception
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
			rs = stmt.executeQuery(Sql_hong.SELECT_CATEGORY1_BY_CS_ADMIN_NOTICE);
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
		
	
	// 전체 게시물 카운트
	public int selectCountTotal() {
		int total = 0;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(Sql_hong.SELECT_COUNT_TOTAL_NOTICE);
			
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
	
	// cs notice 전체 list 출력
	public List<CsNoticeVO> selectAllNoticeArticles(int start){
		logger.info("selectAllNoticeArticles start...");
		List<CsNoticeVO> allArticles = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_hong.SELECT_ADMIN_ALL_NOTICE_ARTICLES);
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
			psmt = conn.prepareStatement(Sql_hong.SELECT_ADMIN_NOTICE_ARTICLES);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
