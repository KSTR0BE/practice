package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.mvc.TilesViewResolver;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.vo.BuyerVO;

@WebServlet("/buyer/buyerList.do")
public class BuyerListServlet extends HttpServlet {
	private BuyerService service = new BuyerServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BuyerVO> buyerList = service.retrieveList();
		
		req.setAttribute("bList", buyerList);
		
		String lvn = "buyer/buyerList"; //logical view name
		new ViewResolverComposite().resolveView(lvn, req, resp);
	
		
		
		
	
	}
}
