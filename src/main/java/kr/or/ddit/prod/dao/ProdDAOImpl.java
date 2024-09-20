package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.ProdVO;

/**
 * INSERT/UPDATE/DELETE -- COMMIT 필요
 *
 */
public class ProdDAOImpl implements ProdMapper {
	
	private SqlSessionFactory factory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public int insertProd(ProdVO prod) {
		try(
			SqlSession session = factory.openSession();	
		){
			//mapper proxy
			ProdMapper proxy = session.getMapper(ProdMapper.class);
			int cnt = proxy.insertProd(prod);
			if(cnt > 0 ) session.close();
			return cnt;
		}
	}

	@Override
	public ProdVO selectProd(String prodId) {
		try(
			SqlSession session = factory.openSession();	
		){
			//mapper proxy
			ProdMapper proxy = session.getMapper(ProdMapper.class);
			return proxy.selectProd(prodId);
		}
	}

	@Override
	public List<ProdVO> selectProdList() {
		try(
			SqlSession session = factory.openSession();	
		){
			//mapper proxy
			ProdMapper proxy = session.getMapper(ProdMapper.class);
			return proxy.selectProdList();
		}
	}

	@Override
	public int updateProd(ProdVO prod) {
		try(
			SqlSession session = factory.openSession();	
		){
			//mapper proxy
			ProdMapper proxy = session.getMapper(ProdMapper.class);
			int cnt = proxy.updateProd(prod);
			if(cnt > 0 ) session.close();
			return cnt;
		}
	}

}
