package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.vo.ProdVO;

/**
 * 엔터티를 대상으로 CRUD 지원
 *
 */
public interface ProdMapper {
	public int insertProd(ProdVO prod);
	public ProdVO selectProd(String prodId);
	public List<ProdVO> selectProdList();
	public int updateProd(ProdVO prod);
}
