package kr.or.ddit.buyer.dao;

import java.util.List;

import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.LprodVO;

public interface BuyerMapper {
	public int insertBuyer(BuyerVO buyer);
	public BuyerVO selectBuyer(String buyerId);
	public List<BuyerVO> selectBuyerList();
	public int updateBuyer(BuyerVO buyer);
}
