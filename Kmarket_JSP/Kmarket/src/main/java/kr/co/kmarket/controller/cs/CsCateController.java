package kr.co.kmarket.controller.cs;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.service.CsService;
import kr.co.kmarket.vo.CsCate1VO;
import kr.co.kmarket.vo.CsCate2VO;

@WebServlet("/cs/qna/cate.do")
public class CsCateController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	CsService service = CsService.INSTANCE; 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate1 = req.getParameter("cate1");
		String cate2 = req.getParameter("cate2");
		
		if(cate1.equals("1")) {
			List<CsCate1VO> cates1 = service.selectCate1ByCs();
			service.gsonTojson(cates1, resp);
		}else {
			List<CsCate2VO> cates2 = service.selectCate2ByCs(cate2);
			service.gsonTojson(cates2, resp);
		}
		
	}

}
