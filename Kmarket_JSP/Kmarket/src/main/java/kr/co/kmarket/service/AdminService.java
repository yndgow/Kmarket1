package kr.co.kmarket.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.co.kmarket.dao.AdminDAO;
import kr.co.kmarket.vo.ProductVO;

public enum AdminService {
	INSTANCE;
	AdminDAO dao = AdminDAO.getInstance();
	
	public int insertProductByAdmin(ProductVO vo) {
		return dao.insertProductByAdmin(vo);
		
	}
	
	public List<ProductVO> selectProductByAdmin(String uid){
		return dao.selectProductByAdmin(uid);
	}
	
	// 파일 이름 변경
	public String reNameFile(String fName, String uid, String savePath) {
		int idx = fName.lastIndexOf("."); // 확장자 인덱스
		String ext = fName.substring(idx); // 확장자 구분
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss_"); // 날짜형식 
		String now = sdf.format(new Date()); // 오늘 날짜 포맷 적용
		String newName = now + uid + ext; // 새로운 파일 이름
		File oriFile = new File(savePath + "/" + fName); // 실제 저장된 파일 객체
		File newFIle = new File(savePath + "/" + newName); // 변경할 파일 객체
		oriFile.renameTo(newFIle);
		return newName;
	}
	
	
}
