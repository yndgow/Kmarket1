package kr.co.kmarket.controller.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.kmarket.service.ProductService;
import kr.co.kmarket.vo.MemberVO;
import kr.co.kmarket.vo.ProductOrderVO;

@WebServlet("/product/cart.do")
public class ProductCartController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// aside 공통 
		req.setAttribute("categories1", service.selectCategory1());
		req.setAttribute("categories2", service.selectCategory2());
		req.setAttribute("carts", service.selectCarts(req.getParameter("uid")));
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/product/cart.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 장바구니에서 주문으로
		
		
		// 세션 가져오기
		HttpSession sess = req.getSession();
		MemberVO mem = (MemberVO) sess.getAttribute("sessUser");
		
		// product order 객체 생성
		ProductOrderVO povo = new ProductOrderVO();
		povo.setOrdUid(mem.getUid());
		povo.setOrdCount(req.getParameter("cartCount"));
		povo.setOrdPrice(req.getParameter("cartPrice"));
		povo.setOrdDiscount(req.getParameter("cartDiscount"));
		povo.setOrdDelivery(req.getParameter("cartDelivery"));
		povo.setSavePoint(req.getParameter("cartPoint"));
		povo.setOrdTotPrice(req.getParameter("cartTotal"));
		
		povo.setRecipName(mem.getName());
		povo.setRecipHp(mem.getHp());
		povo.setRecipZip(mem.getZip());
		povo.setRecipAddr1(mem.getAddr1());
		povo.setRecipAddr2(mem.getAddr2());
		
		int result = service.insertProductOrder(povo);
		
		// 쿼리 생성
		String cartNo[] = req.getParameterValues("cartProduct");
		if(cartNo != null) {
			String query = "";
			for(int i=0; i<cartNo.length; i++) {
				query += cartNo[i];
				if(i < cartNo.length-1) {
					query += "&cartNo=";
				}
			}
			resp.sendRedirect("/Kmarket/product/order.do?uid="+mem.getUid()+"&cartNo="+query);
		}else {
			service.jsonObj("result", result, resp);
		}
		
		
		
		//JSON 문자열을 리스트로 받을때(Jackson)
//		String jsonStr = service.getBody(req);
//		ObjectMapper om = new ObjectMapper();
//		List<ProductOrderItemVO> m = om.readValue(jsonStr, new TypeReference<List<ProductOrderItemVO>>(){});
		
	}
}
