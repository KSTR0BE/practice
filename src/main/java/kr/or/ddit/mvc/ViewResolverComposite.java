package kr.or.ddit.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ViewResolverComposite implements ViewResolver {
	private List<ViewResolver> viewResiolvers;
	{
		viewResiolvers = new ArrayList<ViewResolver>();
		viewResiolvers.add(new ContentNegotiatingViewResolver());
		viewResiolvers.add(new TilesViewResolver());
		viewResiolvers.add(new InternalResourceViewResolver());
	}
	@Override
	public void resolveView(String logicalViewName, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if(logicalViewName.startsWith("redirect:")) {
			String view = logicalViewName.replace("redirect:", req.getContextPath());
			resp.sendRedirect(view);
		} else if(logicalViewName.startsWith("forward:")) {
			String view = logicalViewName.replace("forward:", "");
			req.getRequestDispatcher(view).forward(req, resp);
		} else {
			for(ViewResolver single : viewResiolvers) {
				try {
					single.resolveView(logicalViewName, req, resp);
					log.info("{}가 {}라는 논리적 뷰 네임을 해결했음.", single.getClass().getSimpleName(), logicalViewName);
					break;					
				} catch (Exception e) {
					log.warn("{}가 {}라는 논리적 뷰 네임을 해결하는데 실패했음. 다음 resolver에게 제어전달", 
							single.getClass().getSimpleName(), logicalViewName);
					continue;
				}
			}
		}
	}

}
