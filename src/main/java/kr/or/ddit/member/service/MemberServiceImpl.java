package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.login.exception.AuthenticateException;
import kr.or.ddit.login.exception.UserNotFoundException;
import kr.or.ddit.login.service.AuthenticateService;
import kr.or.ddit.login.service.AuthenticateServiceImpl;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	private MemberDAO dao = new MemberDAOImpl();
	private AuthenticateService authService = new AuthenticateServiceImpl();
		
	@Override
	public MemberVO retrieveMember(String memId) {
		MemberVO member =  dao.selectMember(memId);
		if(member == null)
			throw new UserNotFoundException(memId);
		return member;
	}

	@Override
	public List<MemberVO> retrieveMemberList() {
		return dao.selectMemberList();
	}

	@Override
	public ServiceResult createMember(MemberVO member) {
		ServiceResult result = null;
		if(dao.selectMember(member.getMemId())==null) {
			result = dao.insertMember(member) > 0 ? ServiceResult.OK : ServiceResult.FAILED;
			
		} else {
			result = ServiceResult.PKDUPLICATED;
		}
		return result;
	}

	@Override
	public ServiceResult modifyMember(MemberVO member) {
		ServiceResult result = null;
		try {
			authService.authenticate(member);	
			result = dao.updateMember(member) > 0 ? ServiceResult.OK : ServiceResult.FAILED;
		} catch (AuthenticateException e) {
			result = ServiceResult.INVALIDPASSWORD;
		}
		return result;
	}

	@Override
	public ServiceResult removeMember(MemberVO inputData) {
		ServiceResult result = null;
		try {
			authService.authenticate(inputData);	
			result = dao.deleteMember(inputData.getMemId()) > 0 ? ServiceResult.OK : ServiceResult.FAILED;
		} catch (AuthenticateException e) {
			result = ServiceResult.INVALIDPASSWORD;
		}
		return result;
	}

}
