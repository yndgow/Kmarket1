package kr.co.kmarket.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.kmarket.dao.CsDAO;
import kr.co.kmarket.vo.CsCate1VO;
import kr.co.kmarket.vo.CsCate2VO;
import kr.co.kmarket.vo.CsQnaVO;

public enum CsService {
	INSTANCE;
	CsDAO dao = CsDAO.getInstance();
	
	//cs 문의하기 등록 홍민준
	public int InsertArticleQnaOfCs(CsQnaVO vo){
		return dao.InserArticleQna(vo);
	}
	//cs cate1 출력 홍민준
	public List<CsCate1VO> selectCate1ByCs(){
		return dao.selectCate1ByCs();
	}
	//cs cate2 출력 홍민준
	public List<CsCate2VO> selectCate2ByCs(String cate2){
		return dao.selectCate2ByCs(cate2);
	}
	
	//cs list 출력 홍민준
	public List<CsQnaVO> selectQnaArticles(){
		return dao.selectQnaArticles();
		
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
