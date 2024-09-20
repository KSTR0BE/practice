package kr.or.ddit.buyer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.LprodVO;

public class BuyerDAOImpl implements BuyerMapper {
	
	private SqlSessionFactory factory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public int insertBuyer(BuyerVO buyer) {
		try(
			SqlSession session = factory.openSession();	
		){
			//mapper proxy
			BuyerMapper proxy = session.getMapper(BuyerMapper.class);
			int cnt =  proxy.insertBuyer(buyer);
			if(cnt > 0) session.commit();
			return cnt;
			
		}
	}

	@Override
	public BuyerVO selectBuyer(String buyerId) {
		try(
			SqlSession session = factory.openSession();	
		){
			//mapper proxy
			BuyerMapper proxy = session.getMapper(BuyerMapper.class);
			return proxy.selectBuyer(buyerId);
		}
	}

	@Override
	public List<BuyerVO> selectBuyerList() {
		try(
			SqlSession session = factory.openSession();	
		){
			//mapper proxy
			BuyerMapper proxy = session.getMapper(BuyerMapper.class);
			return proxy.selectBuyerList();
		}
	}

	@Override
	public int updateBuyer(BuyerVO buyer) {
		try(
			SqlSession session = factory.openSession();	
		){
			//mapper proxy
			BuyerMapper proxy = session.getMapper(BuyerMapper.class);
			int cnt =  proxy.updateBuyer(buyer);
			if(cnt > 0) session.commit();
			return cnt;
				
		}
	}

}
