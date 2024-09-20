package kr.or.ddit.buyer.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.BuyerVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class BuyerDAOImplTest {
	
	BuyerMapper mapper = new BuyerDAOImpl(); 
	
	@Test
	void testInsertBuyer() {
		BuyerVO buyer = new BuyerVO();
		buyer.setBuyerName("샘숭");
		buyer.setBuyerLgu("P101");
		buyer.setBuyerComtel("123");
		buyer.setBuyerFax("123");
		buyer.setBuyerMail("123");
		int cnt = mapper.insertBuyer(buyer);
		assertEquals(1, cnt);
		
		
	}

	@Test
	void testSelectBuyer() {
		BuyerVO buyer = mapper.selectBuyer("P10101");
		log.info("조회 결과 : {}",buyer);
		buyer.getProdList().forEach((p)->log.info("조회된 상품 : {}", buyer));
	}

	@Test
	void testSelectBuyerList() {
		assertNotNull(mapper.selectBuyerList());
	}

	@Test
	void testUpdateBuyer() {
		fail("Not yet implemented");
	}
	
	

}
