package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.MemberVOWrapper;

@WebServlet("/mypage")
public class MypageServlet extends HttpServlet{
	private MemberService service = new MemberServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberVOWrapper principal =  (MemberVOWrapper)req.getUserPrincipal();
		MemberVO authUser = principal.getRealUser();
		MemberVO detail = service.retrieveMember(authUser.getMemId());
		
		req.setAttribute("member", detail);
		String lvn= "member/mypage";
		new ViewResolverComposite().resolveView(lvn, req, resp);
		
		
	
	}
}
