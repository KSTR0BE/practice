package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.commons.utils.CustomBeanUtils;
import kr.or.ddit.lprod.dao.LprodDAOImpl;
import kr.or.ddit.lprod.dao.LprodMapper;
import kr.or.ddit.mvc.TilesViewResolver;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.validate.ValidateUtils;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.vo.LprodVO;
import kr.or.ddit.vo.ProdVO;

/**
 * 1. 파라미터를 command object에 바인드함
 * 2. command object를 대상으로 검증 : ValidateUtils
 * 3. 검증통과 errors.isEmpty
 * 	-로직 실행
 * 	-액선의 결과를 보여줄 수 있는 뷰 선택
 * 		PRG패턴인 경우, 논리적 뷰는 "redirect:"으로 시작함.
 * 4. 검증 실패
 * 	- 입력 UI 로 논리적 뷰 선택
 * 5. ViewResolver의 이용.
 */
@WebServlet("/prod/prodInsert.do")
public class prodInsertServlet extends HttpServlet {
	ProdService service = new ProdServiceImpl();
	LprodMapper lprodDAO = new LprodDAOImpl();
	
	private void addAttribute(HttpServletRequest req) {
		List<LprodVO> lprodList = lprodDAO.selectLprodList();
		req.setAttribute("lprodList", lprodList);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		addAttribute(req);
		String logicalViewName = "prod/prodInsert";
		new ViewResolverComposite().resolveView(logicalViewName, req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		addAttribute(req);
		
//		1. 모든파라미터를 command onject에 바인드함
		ProdVO prod = new ProdVO();
		req.setAttribute("prod", prod);
		
		CustomBeanUtils.populate(prod, req.getParameterMap());
		
//		2. command object를 대상으로 검수 수행
		Map<String, String>errors = new LinkedHashMap<String, String>();
		req.setAttribute("errors", errors);
		ValidateUtils.validate(prod, errors, InsertGroup.class);
//		3.검증 통과시
		String logicalViewName = null;
		if(errors.isEmpty()) {
//			- 로직실행
			service.createProd(prod);
			logicalViewName = "redirect:/prod/prodList.do";
		} else {
//		4. 검증 실패시
//			- 다시 정상 데이터를 입력할 수 있는 UI페이지로 뷰를 결정(기존 데이터, 검증 결과 데이터 전달).
			logicalViewName = "prod/prodInsert"; //로지컬 뷰 메인

		}
//		5. 뷰 레이어로 이동
		new ViewResolverComposite().resolveView(logicalViewName, req, resp);
		
	}
}