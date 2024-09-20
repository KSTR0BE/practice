package kr.or.ddit.db;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.JdbcBoardVO;

class CustomSqlSessionFactoryBuilderTest {
	
	@Test
	void testSqlSession() {
		SqlSessionFactory factory =  CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
//		세션 : 통로(Connect full), 시간(Connect less)
		try(
			SqlSession session = factory.openSession();
		){
			List<JdbcBoardVO> boardList = session.selectList("kr.or.ddit.jdbcboard.dao.JdbcBoardDAO.selectJdbcBoardList");
			assertNotNull(boardList);
			assertNotEquals(0, boardList.size());
		}
	}

	@Test
	void testSqlSessionFactory() {
		SqlSessionFactory factory =  CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
		System.out.println(factory);
	}

}
