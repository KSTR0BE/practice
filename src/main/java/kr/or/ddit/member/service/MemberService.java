package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.login.exception.UserNotFoundException;
import kr.or.ddit.vo.MemberVO;

public interface MemberService {
	/**
	 * 상세 정보 조회
	 * @param memId
	 * @return 존재하지 않는 경우, {@link UserNotFoundException}
	 */
	public MemberVO retrieveMember(String memId);
	
	/**
	 * 회원 목록 조회(페이징 지원 예정)
	 * @return
	 */
	public List<MemberVO> retrieveMemberList();
	
	/**
	 * 회원 가입
	 * @param member
	 * @return PKDUPLICATED, OK, FAILED
	 */
	public ServiceResult createMember(MemberVO member);
	
	/**
	 * 회원 수정
	 * @param member
	 * @return INVALIDPASSWORD, OK, FAILED
	 */
	public ServiceResult modifyMember(MemberVO member);
	
	
	/**
	 * 회원 탈퇴
	 * @param inputData 탈퇴할 회원의 아이디와 인증에 사용할 비밀번호
	 * @return INVALIDPASSWORD, OK, FAILED
	 */
	public ServiceResult removeMember(MemberVO inputData);

}
