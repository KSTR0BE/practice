package kr.or.ddit.login.filter;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.MemberVOWrapper;

/**
 * 원본 요청을 받고, 로그인 여부를 확인한 후,
 * 로그인이 된 상태라면, wrapper request 정의하고,
 * wrapper request 내부에 Principal 구현체를 넣어줌.
 *
 */
public class GeneratePrincipalFilter implements Filter {
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.printf("%s 필터 초기화 완료\n", this.getClass().getSimpleName());
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request; //원본 요청 받기
		HttpSession session = req.getSession();
		MemberVO authUser = (MemberVO) session.getAttribute("authUser");
		if(authUser!=null) { //wrapper request 정의
			HttpServletRequestWrapper wrapper =
					new HttpServletRequestWrapper(req) {
				@Override
				public Principal getUserPrincipal() {
					Principal principal = new MemberVOWrapper(authUser);
					return principal;
				}
			};
			chain.doFilter(wrapper, response);
		} else {
			chain.doFilter(request, response);			
		}
	}
	
	@Override
	public void destroy() {
		
	}

}
