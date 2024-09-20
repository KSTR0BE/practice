package kr.or.ddit.lprod.controller;

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
import kr.or.ddit.lprod.service.LprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.mvc.TilesViewResolver;
import kr.or.ddit.validate.ValidateUtils;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.LprodVO;

//@WebServlet("")
public class LprodInsertServlet extends HttpServlet {
	LprodService service = new LprodServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String logicalViewName = "lprod/lprodInsert";
		new TilesViewResolver().resolveView(logicalViewName, req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LprodVO lprod = new LprodVO();
		req.setAttribute("lprod", lprod);
		
		CustomBeanUtils.populate(lprod, req.getParameterMap());
		
//		2. command object를 대상으로 검수 수행
		Map<String, String>errors = new LinkedHashMap<String, String>();
		req.setAttribute("errors", errors);
		ValidateUtils.validate(lprod, errors, InsertGroup.class);
//		3.검증 통과시
		String logicalViewName = null;
		if(errors.isEmpty()) {
//			- 로직실행
			service.createLprod(lprod);
			logicalViewName = "redirect:/lprod/lprodList.do";
		} else {
//		4. 검증 실패시
//			- 다시 정상 데이터를 입력할 수 있는 UI페이지로 뷰를 결정(기존 데이터, 검증 결과 데이터 전달).
			logicalViewName = "buyer/buyerInsert"; //로지컬 뷰 메인

		}
//		5. 뷰 레이어로 이동
		new TilesViewResolver().resolveView(logicalViewName, req, resp);
		
	}
}
