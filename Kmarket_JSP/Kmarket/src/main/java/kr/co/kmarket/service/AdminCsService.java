package kr.co.kmarket.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.kmarket.dao.AdminDAO_kjh;
import kr.co.kmarket.vo.CsCate1DTO;
import kr.co.kmarket.vo.CsCate2DTO;

public enum AdminCsService {
	INSTANCE;
	
	AdminDAO_kjh dao = AdminDAO_kjh.getInstance();
	
	// cs cate1 출력
	public List<CsCate1DTO> selectCsCate1(String csType) {
		
		if(csType.equals("notice")) {
			csType = "km_cs_notice_cate1";
		}else if(csType.equals("faq")) {
			csType = "km_cs_faq_cate1";
		}else if(csType.equals("qna")) {
			csType = "km_cs_qna_cate1";
		}
		
		return dao.selectCsCate1(csType);
	}
	
	public List<CsCate2DTO> selectCsCate2(String csType, String cate1){
			
		if(csType.equals("faq")) {
			csType = "km_cs_faq_cate2";
		}else if(csType.equals("qna")) {
			csType = "km_cs_qna_cate2";
		}
		
		return dao.selectCsCate2(csType, cate1);
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
