package kr.co.kmarket.dao;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.Sql_kjh;
import kr.co.kmarket.vo.CsCate1DTO;
import kr.co.kmarket.vo.CsCate2DTO;
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
	
	// cs 카테고리 1차 출력
	public List<CsCate1DTO> selectCsCate1(String csType) {
		logger.info("selectCsCate1");
		List<CsCate1DTO> cate1List = new ArrayList<>(); 
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM " + csType);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsCate1DTO vo = new CsCate1DTO();
				vo.setCate1(rs.getInt(1));
				vo.setC1Name(rs.getString(2));
				cate1List.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("cate1List : " + cate1List);
		return cate1List;
	}
	
	// cs 카테고리 2차 출력
	public List<CsCate2DTO> selectCsCate2(String csType, String cate1) {
		logger.info("selectCsCate2");
		List<CsCate2DTO> cate2List = new ArrayList<>(); 
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM " + csType + " WHERE `cate1` = ?");
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
	
	// cs list 출력
}
