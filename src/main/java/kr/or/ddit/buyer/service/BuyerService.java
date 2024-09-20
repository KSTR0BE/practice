package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.commons.exception.PkNotFoundException;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.LprodVO;

public interface BuyerService {
	public void createBuyer(BuyerVO buyer); 
	/**
	 * 제조사 상세 조회
	 * @param buyerId 조회할 제조사의 PK
	 * @return 존재하지 않는다면, {@link PkNotFoundException}
	 */
	public BuyerVO retrieveBuyer(String buyerId) throws PkNotFoundException;
	public List<BuyerVO> retrieveList();
	public void modifyBuyer(BuyerVO buyer);
}
