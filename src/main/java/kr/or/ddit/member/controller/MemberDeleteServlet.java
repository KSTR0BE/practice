package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.TilesViewResolver;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.MemberVOWrapper;

@WebServlet("/member/memberDelete.do")
public class MemberDeleteServlet extends HttpServlet {
	MemberService service = new MemberServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//비밀번호를 받아서
		String memPass = req.getParameter("memPass");
		if(StringUtils.isBlank(memPass)) {
			resp.sendError(400, "필수 파라미터 누락");
			return;
		}
		
		MemberVO inputData = new MemberVO();
		MemberVOWrapper principal = (MemberVOWrapper)req.getUserPrincipal();
		inputData.setMemId(principal.getName());
		inputData.setMemPass(memPass);
		ServiceResult result = service.removeMember(inputData);
		String lvn = null;
		if(ServiceResult.OK.equals(result)) {
			lvn = "forward:/login/logout.do";
		} else {
			String message = "비밀번호 오류";
			req.getSession().setAttribute("message", message);
			lvn = "redirect:/mypage";
		}
		
		new ViewResolverComposite().resolveView(lvn, req, resp);
		//principal에 있는 정보를 받아서 서로 맞는지 틀린지 비교한다.
//	
//		MemberVOWrapper wrapper = (MemberVOWrapper)req.getUserPrincipal();
//		String realId = wrapper.getRealUser().getMemId();
//		String realPass = wrapper.getRealUser().getMemPass();
//		MemberVO member = new MemberVO();
//		member.setMemId(realId);
//		member.setMemPass(realPass);
//		System.out.println(member);
//		String msg = "";
//		String view = "";
//		ServiceResult result = service.removeMember(member);
//		if(result == ServiceResult.OK ) {
//			view = "/";
//			msg = "성공";
//		} else if (result == ServiceResult.INVALIDPASSWORD ) {
//			view = "/mypage";
//			msg = "틀림";
//		} else if (result == ServiceResult.FAILED) {
//			view = "/mypage";
//			msg = "실패";
//		}
//		req.getSession().setAttribute("msg", msg);
//		resp.sendRedirect(req.getContextPath()+ view );
//		

	}
	
}
