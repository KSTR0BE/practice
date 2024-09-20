package kr.or.ddit.jdbcboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.JdbcBoardVO;

public class JdbcBoardDAOImpl implements JdbcBoardDAO {

	private SqlSessionFactory factory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	/**
	 *	글번호는 board_seq.nextval로 생성함.
	 */
	@Override
	public int insertJdbcBorad(JdbcBoardVO boardVO) {
		try(
				SqlSession session = factory.openSession(true);
			){
				int cnt = session.insert("kr.or.ddit.jdbcboard.dao.JdbcBoardDAO.insertJdbcBorad", boardVO);
				return cnt;
			}
	}

	@Override
	public List<JdbcBoardVO> selectJdbcBoardList() {
		try(
				SqlSession session = factory.openSession();	
			){
				return session.selectList("kr.or.ddit.jdbcboard.dao.JdbcBoardDAO.selectJdbcBoardList");
			}
	}

	@Override
	public JdbcBoardVO selectJdbcBoard(int boardNo) {
		try(
				SqlSession session = factory.openSession();	
			){
				return session.selectOne("kr.or.ddit.jdbcboard.dao.JdbcBoardDAO.selectJdbcBoard", boardNo);
			}
		
	}


	@Override
	public int updateJdbcBoard(JdbcBoardVO boardVO) {
		try(
			SqlSession session = factory.openSession(true);	
		){
			return session.update("kr.or.ddit.jdbcboard.dao.JdbcBoardDAO.updateJdbcBoard", boardVO);
		}
		
		
	}

	@Override
	public int deleteJdbcBoard(int boardNo) {
		try(
				SqlSession session = factory.openSession(true);	
			){
				return session.delete("kr.or.ddit.jdbcboard.dao.JdbcBoardDAO.deleteJdbcBoard", boardNo);
			}
	}

}
