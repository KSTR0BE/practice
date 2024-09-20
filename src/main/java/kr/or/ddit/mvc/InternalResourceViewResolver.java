package kr.or.ddit.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InternalResourceViewResolver implements ViewResolver {

	@Override
	public void resolveView(String logicalViewMain, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String prefix = "/WEB-INF/views/";
		String suffix = ".jsp";
		String view = prefix + logicalViewMain + suffix;
		req.getRequestDispatcher(view).forward(req, resp);		
	}

}
