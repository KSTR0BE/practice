package kr.or.ddit.lprod.dao;

import java.util.List;


import kr.or.ddit.vo.LprodVO;

public interface LprodMapper {
	
	public int insertLprod(LprodVO lprod);
	public List<LprodVO> selectLprodList();
}
