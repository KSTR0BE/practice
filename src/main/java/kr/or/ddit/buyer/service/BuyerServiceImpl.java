package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.dao.BuyerDAOImpl;
import kr.or.ddit.buyer.dao.BuyerMapper;
import kr.or.ddit.commons.exception.PkNotFoundException;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.LprodVO;

public class BuyerServiceImpl implements BuyerService {
	private BuyerMapper mapper = new BuyerDAOImpl();

	@Override
	public void createBuyer(BuyerVO buyer) {
		mapper.insertBuyer(buyer);
	}

	@Override
	public BuyerVO retrieveBuyer(String buyerId) throws PkNotFoundException {
		if(buyerId == null) {
			throw new PkNotFoundException(buyerId);
		}
		return mapper.selectBuyer(buyerId);
	}

	@Override
	public List<BuyerVO> retrieveList() {
		return mapper.selectBuyerList();
	}

	@Override
	public void modifyBuyer(BuyerVO buyer) {

	}


}
