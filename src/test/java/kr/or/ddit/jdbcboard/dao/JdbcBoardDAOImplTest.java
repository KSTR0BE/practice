package kr.or.ddit.jdbcboard.dao;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.vo.JdbcBoardVO;

class JdbcBoardDAOImplTest {
	
	JdbcBoardDAO dao = new JdbcBoardDAOImpl();
	static final Logger log = LoggerFactory.getLogger(JdbcBoardDAOImplTest.class);
	
	@Test
	void testInsertJdbcBorad() {
		JdbcBoardVO dummy = new JdbcBoardVO();
		dummy.setBoardTitle("새로 작성한 글");
		dummy.setBoardWriter("새 작성자");
		dummy.setBoardContent(null);
		assertEquals(1, dao.insertJdbcBorad(dummy));
	}

	@Test
	void testSelectJdbcBoardList() {
		assertDoesNotThrow(()->{
			dao.selectJdbcBoardList().forEach(b->log.info("조회된 게시글 : {}", b));			
		});
	}
	
	@Test
	void testSelectJdbcBoard() {
		assertDoesNotThrow(()->{
			assertNotNull(dao.selectJdbcBoard(2));
		});
	}
	
	@Test
	void testUpdateJdbcBoard() {
		JdbcBoardVO dummy = new JdbcBoardVO();
		dummy.setBoardNo(27);
		dummy.setBoardContent("원래 글의 내용을 수정해 버렸음");
		assertEquals(1, dao.updateJdbcBoard(dummy));
	}

	@Test
	void testDeleteJdbcBoard() {
		assertEquals(1, dao.deleteJdbcBoard(1));
	}

}
