package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.vo.LprodVO;

public interface LprodService {
	public void createLprod(LprodVO lprod);
	public List<LprodVO> retrieveLprodList();
}
