package kr.or.ddit.login.service;

import kr.or.ddit.login.exception.AuthenticateException;
import kr.or.ddit.vo.MemberVO;

/**
 * username/password 기반의 인증 여부를 판단하기 위한 business logic layer
 *
 */
public interface AuthenticateService {
	/**
	 * username/password 기반의 인증 로직
	 * @param imputData memId/memPass를 가진 사용자 입력 데이터
	 * @return 인증에 성공한 경우, (아이디, 비번, 이름, 휴대폰, 역할)을 가진 사용자의 저장되어있던 정보.
	 * @throws AuthenticateException 인증 실패시 던져질 예외
	 */
	public MemberVO authenticate(MemberVO imputData) throws AuthenticateException;;
}
