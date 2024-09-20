package kr.or.ddit.login.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.vo.MemberVOWrapper;

/**
 * 1. 보호자원을 요청한 경우라면, (로그인이 되었다는 전제를 깐다.)
 * 2. 사용자에게 부여된 역할을 확인하고,
 * 3. 자원에 설정된 허가 정보와 역할 정보가 일치하는지 확인.
 *  - 일치(권한 소유함) - 통과
 *  - 불일치(권한 없음) - 403 Forbidden
 *
 */
public class AuthorizationFilter implements Filter{
	
	//1. 어플리케이션 에서 securedResources를가져온다
	Map<String, String>securedResources = null;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		Map<String, String[]> securedResources = (Map) request.getServletContext().getAttribute("securedResources");
		boolean pass = false;
		
		String uri = req.getRequestURI();
		int cpLength = req.getContextPath().length();
		uri = uri.substring(cpLength);
		
		
		if(securedResources.containsKey(uri)) {
			MemberVOWrapper wrapper = (MemberVOWrapper) req.getUserPrincipal();
			// 김용호는 반장이다.
			// 정윤지는 부반장이다.
			String userRole = wrapper.getRealUser().getMemRole();
			// 출석부는 반장만 조회할 수 있다.
			String[] roles = securedResources.get(uri);
			
			int status = Arrays.binarySearch(roles, userRole);
			
			if(status >= 0) {
				pass = true;
			} else {
				pass = true;
			}
			
		} else {
			pass = true;
		}
		
		if(pass) {
			chain.doFilter(request, response);
		} else {
			resp.sendError(HttpServletResponse.SC_FORBIDDEN, "보호 자원에 대한 권한 없음.");
		}
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
