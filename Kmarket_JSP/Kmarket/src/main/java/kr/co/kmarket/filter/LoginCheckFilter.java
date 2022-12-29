package kr.co.kmarket.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.vo.MemberVO;


public class LoginCheckFilter implements Filter {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private List<String> uriList;

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 필터를 동작할 요청주소 리스트 구성
		uriList = new ArrayList<>();
		uriList.add("/Kmarket/product/cart.do");
		//uriList.add("/Kmarket/product/list.do");
		uriList.add("/Kmarket/cs/qna/write.do");
		uriList.add("/Kmarket/admin/index.do");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		logger.info("LoginCheckFilter...0");
		
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		
		logger.debug("LoginCheckFilter...1");
		
		if(uriList.contains(uri)) {
			
			HttpSession sess = req.getSession();
			MemberVO sessUser = (MemberVO)sess.getAttribute("sessUser");
			
			logger.debug("LoginCheckFilter...2");
			if(sessUser == null) { // 로그인을 안했으면
				logger.debug("LoginCheckFilter...3");
				((HttpServletResponse) response).sendRedirect("/Kmarket/member/login.do?success=300");
				return;
			}
		}
		
		logger.debug("LoginCheckFilter...4");
		chain.doFilter(request, response);		
	}
}