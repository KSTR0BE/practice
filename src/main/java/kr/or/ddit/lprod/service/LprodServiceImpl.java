package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.lprod.dao.LprodDAOImpl;
import kr.or.ddit.lprod.dao.LprodMapper;
import kr.or.ddit.vo.LprodVO;

public class LprodServiceImpl implements LprodService {

	LprodMapper mapper = new LprodDAOImpl();
	
	@Override
	public void createLprod(LprodVO lprod) {
		mapper.insertLprod(lprod);
	}
	
	@Override
	public List<LprodVO> retrieveLprodList() {
		return mapper.selectLprodList();
	}


}
