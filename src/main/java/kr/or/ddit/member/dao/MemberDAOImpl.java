package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {

	private SqlSessionFactory factory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public MemberVO selectMemberByUsername(String memId) {
		try(
				SqlSession session = factory.openSession();	
			){
//				return session.selectOne("kr.or.ddit.member.dao.MemberDAO.selectMemberByUsername", memId);
			
				//mapper proxy <-서버부하가 많이 됨. 그래서 싱글톤으로 만들어서 하면되는데 그건 Spring에서 함
				MemberDAO proxy = session.getMapper(MemberDAO.class);
				return proxy.selectMemberByUsername(memId);
			}
		}

	@Override
	public MemberVO selectMember(String memId) {
		try(
				SqlSession session = factory.openSession();	
			){
				//mapper proxy
				MemberDAO proxy = session.getMapper(MemberDAO.class);
				return proxy.selectMember(memId);
			}
	}

	@Override
	public List<MemberVO> selectMemberList() {
		try(
				SqlSession session = factory.openSession();	
			){
				//mapper proxy
				MemberDAO proxy = session.getMapper(MemberDAO.class);
				return proxy.selectMemberList();
			}
	}

	@Override
	public int insertMember(MemberVO member) {
		try(
				SqlSession session = factory.openSession();	
				){
			//mapper proxy
			MemberDAO proxy = session.getMapper(MemberDAO.class);
			int cnt = proxy.insertMember(member);
			if(cnt > 0) session.commit();
			return cnt;
		}
	}

	@Override
	public int updateMember(MemberVO member) {
		try(
				SqlSession session = factory.openSession();	
				){
			//mapper proxy
			MemberDAO proxy = session.getMapper(MemberDAO.class);
			int cnt = proxy.updateMember(member);
			if(cnt > 0) session.commit();
			return cnt;
		}
		
	}

	@Override
	public int deleteMember(String memId) {
		try(
				SqlSession session = factory.openSession();	
				){
			//mapper proxy
			MemberDAO proxy = session.getMapper(MemberDAO.class);
			int cnt = proxy.deleteMember(memId);
			if(cnt > 0) session.commit();
			return cnt;
		}
	}
}
