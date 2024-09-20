package kr.or.ddit.member.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.VcartProdVO;
import kr.or.ddit.vo.VcartVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class MemberDAOImplTest {
	private MemberDAO dao = new MemberDAOImpl();

	@Test
	void testSelectMemberByUsername() {
		fail("Not yet implemented");
	}

	@Test
	void testSelectMember() {
		MemberVO member = dao.selectMember("a001");
		assertNotNull(member);
		log.info("{}의 구매내역", member.getMemId());
		for(VcartVO single : member.getCartList()) {
			log.info("{}에 구매한 일련번호 {}번 구매내역, 구매번호 : {}", single.getCartDate(), single.getCartSeq(), single.getCartNo() );	
			for(VcartProdVO cartProd: single.getCartProdList()) {
				log.info("구매번호 : {}, 상품명 : {}, 제조사 : {}, 분류명 : {}, 구매수량 : {} 구매금액 : {}",
						cartProd.getCartNo(), cartProd.getProd().getProdName()
						, cartProd.getProd().getBuyer().getBuyerName()
						, cartProd.getProd().getLprod().getLprodNm()
						, cartProd.getCartQty()
						, (cartProd.getCartQty() * cartProd.getProd().getProdPrice()));
			}
		}
//		a001의 구매내역
//		2020-01-01에 구매한 일련번호 3번 구매내역, 구매번호 : 2020010100003
//		구매번호 : 2020010100003, 구매상품명 : 모니터, 제조사 : 삼성전자, 분류명 : 전자제품, 구매수량 : 3, 구매금액 : 3000
	}

	@Test
	void testSelectMemberList() {
		fail("Not yet implemented");
	}

	@Test
	void testInsertMember() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateMember() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteMember() {
		fail("Not yet implemented");
	}

}
