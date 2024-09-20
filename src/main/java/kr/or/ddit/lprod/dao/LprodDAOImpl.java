package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.LprodVO;

public class LprodDAOImpl implements LprodMapper {

	private SqlSessionFactory factory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public int insertLprod(LprodVO lprod) {
		try(
				SqlSession session = factory.openSession();	
				){
			//mapper proxy
			LprodMapper proxy = session.getMapper(LprodMapper.class);
			int cnt =  proxy.insertLprod(lprod);
			if(cnt > 0) session.commit();
			return cnt;
			
		}
	}
	
	@Override
	public List<LprodVO> selectLprodList() {
		try(
			SqlSession session = factory.openSession();	
		){
			//mapper proxy
			LprodMapper proxy = session.getMapper(LprodMapper.class);
			return proxy.selectLprodList();
		}
	}

}
