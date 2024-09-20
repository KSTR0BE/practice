package kr.or.ddit.prod.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ProdDAOImplTest {
	ProdMapper dao = new ProdDAOImpl();
	
	@Test
	void testInsertProd() {
		fail("Not yet implemented");
	}

	@Test
	void testSelectProd() {
		ProdVO prod = dao.selectProd("P101000001");
		log.info("조회 결과 {}", prod);
	}

	@Test
	void testSelectProdList() {
		assertNotNull(dao.selectProdList());
	}

	@Test
	void testUpdateProd() {
		fail("Not yet implemented");
	}

}
