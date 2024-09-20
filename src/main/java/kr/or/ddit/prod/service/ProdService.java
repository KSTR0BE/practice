package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.commons.exception.PkNotFoundException;
import kr.or.ddit.vo.ProdVO;

public interface ProdService {
	public void createProd(ProdVO prod);
	/**
	 * 상품 상세 조회
	 * @param prodId 조회할 상품의 PK
	 * @return 존쟁하지 않는다면, {@link PkNotFoundException}
	 */
	public ProdVO retrieveProd(String prodId);
	public List<ProdVO> retrieveProdList();
	public void modifyProd(ProdVO prod);
}
