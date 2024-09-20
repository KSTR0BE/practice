package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.commons.exception.PkNotFoundException;
import kr.or.ddit.prod.dao.ProdDAOImpl;
import kr.or.ddit.prod.dao.ProdMapper;
import kr.or.ddit.vo.ProdVO;

public class ProdServiceImpl implements ProdService {
	private ProdMapper mapper = new ProdDAOImpl();

	@Override
	public void createProd(ProdVO prod) {
		mapper.insertProd(prod);

	}

	@Override
	public ProdVO retrieveProd(String prodId) {
		if(prodId == null) {
			throw new PkNotFoundException(prodId);
		}
		return mapper.selectProd(prodId);
	}

	@Override
	public List<ProdVO> retrieveProdList() {
		return mapper.selectProdList();
	}

	@Override
	public void modifyProd(ProdVO prod) {
		// TODO Auto-generated method stub

	}

}
