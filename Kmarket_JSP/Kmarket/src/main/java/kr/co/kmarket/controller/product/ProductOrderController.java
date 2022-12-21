package kr.co.kmarket.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.kmarket.service.ProductService;
import kr.co.kmarket.vo.MemberVO;
import kr.co.kmarket.vo.ProductCartVO;
import kr.co.kmarket.vo.ProductOrderItemVO;
import kr.co.kmarket.vo.ProductOrderVO;
import kr.co.kmarket.vo.ProductVO;

@WebServlet("/product/order.do")
public class ProductOrderController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// aside 공통 
		req.setAttribute("categories1", service.selectCategory1());
		req.setAttribute("categories2", service.selectCategory2());
		
		String cartNo[] = req.getParameterValues("cartNo");
		if(cartNo == null) {
			// 한건 셀렉 - 바로 주문하기(상품에서가져오기)
			ProductVO vo = service.selectProduct(req.getParameter("prodNo"));
			vo.setCount(Integer.parseInt(req.getParameter("count")));
			req.setAttribute("cart", vo);
		}else {
			// 선택된 상품만 셀렉 - 장바구니
			req.setAttribute("carts", service.selectProductCartForOrder(cartNo, req.getParameter("uid")));
		}
		
		// 주문정보 셀렉
		req.setAttribute("order", service.selectOrder(req.getParameter("uid")));
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/product/order.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uid = req.getParameter("uid");
		String ordNo = req.getParameter("ordNo");
		
		// 주문 상품 입력
		//////////////////////// 
		String cartNo[] = req.getParameterValues("cartNo");
		if(cartNo == null) {
			ProductOrderItemVO vo = new ProductOrderItemVO();
			vo.setOrdNo(ordNo);
			vo.setProdNo(req.getParameter("prodNo"));
			vo.setCount(req.getParameter("count"));
			vo.setPrice(req.getParameter("price"));
			vo.setDiscount(req.getParameter("discount"));
			vo.setPoint(req.getParameter("cartPoint"));
			vo.setDelivery(req.getParameter("delivery"));
			vo.setTotal(req.getParameter("total"));
			service.insertProductOrderItem(vo);
		}else{
			List<ProductCartVO> cartList = service.selectProductCartForOrder(cartNo, uid); // cartNo 로 상품정보 불러오기
			service.insertProductOrderItem(cartList, ordNo); // order item 입력
		}
		
		
		
		// 주문 정보 업데이트
		ProductOrderVO povo = new ProductOrderVO();
		String usedPoint = req.getParameter("usedPoint");
		if(usedPoint== "") usedPoint = "0"; 
		povo.setUsedPoint(usedPoint);
		povo.setOrdTotPrice(req.getParameter("ordTotPrice"));
		povo.setRecipName(req.getParameter("name"));
		povo.setRecipHp(req.getParameter("hp"));
		povo.setRecipZip(req.getParameter("zip"));
		povo.setRecipAddr1(req.getParameter("addr1"));
		povo.setRecipAddr2(req.getParameter("addr2"));
		povo.setOrdPayment(req.getParameter("payments"));
		povo.setOrdComplete(0);
		
		service.updateProductOrder(povo, uid, ordNo);
		
		// 포인트 적립/사용
		String cartPoint[] = req.getParameterValues("cartPoints");
		int savePoint = 0;
		if(cartPoint==null) {
			// 바로 주문하기 단건인 경우 
			savePoint = Integer.parseInt(req.getParameter("cartPoint"));
			service.insertPoint(uid, savePoint, ordNo);
		}else {
			for(int i=0; i<cartPoint.length; i++) {
				savePoint += Integer.parseInt(cartPoint[i]);
			}
			service.insertPoint(uid, savePoint, ordNo); // 포인트 테이블입력
		}
		
		// session
		HttpSession sess = req.getSession();
		MemberVO mem = (MemberVO) sess.getAttribute("sessUser");
		int memP = mem.getPoint();
		int usP = Integer.parseInt(usedPoint);
		int resultPoint = memP - usP + savePoint;
		mem.setPoint(resultPoint);
		sess.setAttribute("sessUser", mem);		

		// DB
		service.updateMemberPoint(resultPoint, uid);
		
		// 장바구니 주문 물품 삭제
		if(cartNo != null) {
			service.deleteProductCartOrderd(cartNo);
		}
		
		// 페이지 이동
		resp.sendRedirect("/Kmarket/product/complete.do?ordNo="+ordNo);
	}
}
