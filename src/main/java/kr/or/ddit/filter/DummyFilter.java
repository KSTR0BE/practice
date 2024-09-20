package kr.or.ddit.filter;

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

public class DummyFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("===============request 전처리===============");
		
		HttpServletRequestWrapper wrapper = 
				new HttpServletRequestWrapper((HttpServletRequest)request) {
			@Override
			public String getParameter(String name) {
				if ("type".equals(name)) {
					return "intj";
				} else {
					return super.getParameter(name);
				}
			}
			@Override
			public Principal getUserPrincipal() {
				
				return super.getUserPrincipal();
			}
		};
			
		
		
		chain.doFilter(wrapper, response);
		System.out.println("---------------response 후처리---------------");
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
