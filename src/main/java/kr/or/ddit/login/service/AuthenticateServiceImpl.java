package kr.or.ddit.login.service;

import kr.or.ddit.login.exception.AuthenticateException;
import kr.or.ddit.login.exception.BadCredentialException;
import kr.or.ddit.login.exception.UserDeleteFoundException;
import kr.or.ddit.login.exception.UserNotFoundException;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

/**
 * TDD(Test Driven Development, 테스트 주도형 개발 방법론)
 * 1. 테스트 조건 설정
 * 2. 테스트 케이스 구현
 * 3. 테스트가 성공하도록 로직을 변경하는 작업을 반복.
 *
 */
public class AuthenticateServiceImpl implements AuthenticateService {
	private MemberDAO dao = new MemberDAOImpl();
	
	@Override
	public MemberVO authenticate(MemberVO inputData) throws AuthenticateException {

		MemberVO saved = dao.selectMemberByUsername(inputData.getMemId());
		if(saved == null) {
			throw new UserNotFoundException(inputData.getMemId());
		} else if(saved.isMemDelete()) {
			throw new UserDeleteFoundException(inputData.getMemId());
		} else {
			String inputPass = inputData.getMemPass();
			String savedPass = saved.getMemPass();
			if(savedPass.equals(inputPass)) {
				return saved;
			} else {
				throw new BadCredentialException();
			}			
		}

		
		//최대한 구체적으로 비번오류, 아이디오류, 성공, 이모든것을 테스트까지
		//inpuatdata에 Id가 널값이 뜨는지 확인
//		if(inputData.getMemId()==null) {
//			UserNotFoundException(inputData.getMemId());
//		} else if(inputData.equals(dao.selectMemberByUsername(inputData.getMemId())) {
//			
//		}
//		//inpuatdata에 비밀번호가 널값이 뜨는지 확인
		
		
		
	}

}
