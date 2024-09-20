package kr.or.ddit.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentNegotiatingViewResolver implements ViewResolver {

	@Override
	public void resolveView(String viewName, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String accept = req.getHeader("accept");
		if(accept.toLowerCase().contains("json")) {
			String view = "/jsonView";
			req.getRequestDispatcher(view).forward(req, resp);
		} else {
			throw new RuntimeException("accept 헤더로 응답의 content-type을 결정하는데 실패했음. ");
		}

	}

}
