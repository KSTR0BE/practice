package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.MemberVO;

/**
 * 인증 및 회원 관리를 위한 Persistence layer
 *
 */
public interface MemberDAO {	
	/**
	 * username(사용자 식별데이터)로 조회된 회원 정보(아이디, 비밀번호, 이름, 휴대폰, 역할)
	 * @param memId
	 * @return
	 */
	public MemberVO selectMemberByUsername(@Param("username") String memId);
	
	/**
	 * 마이페이지 처리를 위한 한사람의 상세 정보 조회.
	 * @param memId
	 * @return
	 */
	public MemberVO selectMember(String memId);
	
	/**
	 * 전체 회원 목록 조회, --> 페이징 처리 추가 예정
	 * @return
	 */
	public List<MemberVO>selectMemberList();
	
	/**
	 * 신규 회원 등록
	 * @param memberVO
	 * @return
	 */
	public int insertMember(MemberVO memberVO);
	
	/**
	 * 회원정보 수정
	 * @param memberVO
	 * @return
	 */
	public int updateMember(MemberVO memberVO);
	
	/**
	 * 회원정보 삭제
	 * @param memId
	 * @return
	 */
	public int deleteMember(String memId);
}