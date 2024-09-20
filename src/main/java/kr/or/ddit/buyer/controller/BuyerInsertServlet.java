
package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.commons.utils.CustomBeanUtils;
import kr.or.ddit.lprod.dao.LprodDAOImpl;
import kr.or.ddit.lprod.dao.LprodMapper;
import kr.or.ddit.mvc.TilesViewResolver;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.validate.ValidateUtils;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.LprodVO;

@WebServlet("/buyer/buyerInsert.do")
public class BuyerInsertServlet extends HttpServlet {
	BuyerService service = new BuyerServiceImpl();
	LprodMapper lprodDAO = new LprodDAOImpl();
	
	private void addAttribute(HttpServletRequest req) {
		List<LprodVO> lprodList = lprodDAO.selectLprodList();
		req.setAttribute("lprodList", lprodList);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		addAttribute(req);
		String logicalViewName = "buyer/buyerInsert";
		new ViewResolverComposite().resolveView(logicalViewName, req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		addAttribute(req);
		
//		1. 모든파라미터를 command onject에 바인드함
		BuyerVO buyer = new BuyerVO();
		req.setAttribute("buyer", buyer);
		
		CustomBeanUtils.populate(buyer, req.getParameterMap());
		
//		2. command object를 대상으로 검수 수행
		Map<String, String>errors = new LinkedHashMap<String, String>();
		req.setAttribute("errors", errors);
		ValidateUtils.validate(buyer, errors, InsertGroup.class);
//		3.검증 통과시
		String logicalViewName = null;
		if(errors.isEmpty()) {
//			- 로직실행
			service.createBuyer(buyer);
//			- 새로 등록된 제조사의 상세 페이지로 뷰를 결정
			logicalViewName = "redirect:/buyer/buyerDetail.do?what=" + buyer.getBuyerId();
		} else {
//		4. 검증 실패시
//			- 다시 정상 데이터를 입력할 수 있는 UI페이지로 뷰를 결정(기존 데이터, 검증 결과 데이터 전달).
			logicalViewName = "buyer/buyerInsert"; //로지컬 뷰 메인

		}
//		5. 뷰 레이어로 이동
		new ViewResolverComposite().resolveView(logicalViewName, req, resp);
	}
}
