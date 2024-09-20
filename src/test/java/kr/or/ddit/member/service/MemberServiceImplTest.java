package kr.or.ddit.member.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.MemberVO;

class MemberServiceImplTest {
	
	MemberService service = new MemberServiceImpl();
	
	@Test
	void testRetrieveMember() {
		fail("Not yet implemented");
	}

	@Test
	void testRetrieveMemberList() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateMember() {
		fail("Not yet implemented");
	}

	@Test
	void testModifyMember() {
		MemberVO member = service.retrieveMember("b001");
		member.setMemPass("1004");
		member.setMemZip("12345");
		member.setMemAdd1("대전 중구 오류동");
		member.setMemAdd2("대덕인재개발원");
		assertEquals(ServiceResult.OK, service.modifyMember(member));
	}
	
	@Test
	void testModifyMemberInvalidpassword() {
		MemberVO member = new MemberVO();
		member.setMemId("jm9808");
		member.setMemPass("asd");
		ServiceResult result = service.modifyMember(member);
		assertEquals(ServiceResult.INVALIDPASSWORD, result);
	}

	
	@Test
	void testRemoveMemberOK() {
		MemberVO inputData = new MemberVO();
		inputData.setMemId("a001");
		inputData.setMemPass("asdfasdf");
		ServiceResult result = service.removeMember(inputData);
		assertEquals(ServiceResult.OK, result);
	}
	
	@Test
	void testRemoveMemberInvaildpssword() {
		MemberVO inputData = new MemberVO();
		inputData.setMemId("a001");
		inputData.setMemPass("1111");
		ServiceResult result = service.removeMember(inputData);
		assertEquals(ServiceResult.INVALIDPASSWORD, result);
	}

}
