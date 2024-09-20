package kr.or.ddit.login.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.commons.utils.CookieUtils;
import kr.or.ddit.login.exception.AuthenticateException;
import kr.or.ddit.login.service.AuthenticateService;
import kr.or.ddit.login.service.AuthenticateServiceImpl;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.MemberVOWrapper;

/**
 * 인증시스템에서는 dispatch구조를 사용하지 않음
 * 1. 인증 성공 : 웰컴페이지로 이동
 * 2. 인증 실패 : loginForm으로 이동 (메세지 전달)
 * 		1) 사용자 없음.
 * 		2) 비번 오류.
 *
 */
@WebServlet("/login/loginProcess.do")
public class LoginProcessServlet extends HttpServlet {
	private AuthenticateService service = new AuthenticateServiceImpl();
	
	private void validate(MemberVO inputData, Map<String, String> errors) {
		if(inputData.getMemId()==null || inputData.getMemId().trim().isEmpty()) {
			errors.put("memId", "아이디 필수");
		}
		if(inputData.getMemPass()==null || inputData.getMemPass().trim().isEmpty()) {
			errors.put("memPass", "비밀번호 필수");
		}
	}
	
	@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. 요청, 검증
		request.setCharacterEncoding("UTF-8");
		String memId = request.getParameter("memId"); //재료 가져오기
		String memPass = request.getParameter("memPass");
		MemberVO inputData = new MemberVO(); //그릇생성
		inputData.setMemId(memId); //그릇에 담기
		inputData.setMemPass(memPass);
		
		Map<String, String> errors = new HashMap<>();
		validate(inputData, errors);
		//errors가 비어있느냐에 따라 성공여부 확인 가능
		if(!errors.isEmpty()) {
			response.sendError(400, errors.toString());
			return;
		}
		
		String lvn  = null;
		HttpSession session =  request.getSession();
		
		try {
			MemberVO authMember = service.authenticate(inputData);
			// 한사람의 인증정보(MemberVO)를 -> Principal 구현체로 표현.
			// --> adapter(wrapper)pattern 적용, adapter has a adaptee
			
			session.setAttribute("authUser", authMember);
			
			int maxAge = -1;
			String idSave = request.getParameter("idSave");
			if(idSave!=null && !idSave.trim().isEmpty()) {
				maxAge = 60*60*24*7;
			} else {
				maxAge = 0;
			}
			Cookie idCookie = 
			CookieUtils.createCookie("idCookie", authMember.getMemId(), request.getContextPath(), maxAge);
			response.addCookie(idCookie);
			
			lvn = "redirect:/";
		} catch (AuthenticateException e) {
			String message = e.getMessage();
			session.setAttribute("message", message);
			lvn = "redirect:/login/loginForm.jsp";
		}
		new ViewResolverComposite().resolveView(lvn, request, response);
	}
//			HttpSession session = request.getSession();
//			session.invalidate();
//			String memId = request.getParameter("memId");
//			String memPass = request.getParameter("memPass");
//			
//			MemberVO memVO = new MemberVO(memId, memPass);
//			
//			if(service.authenticate(memVO)==null) {
//				String location = request.getContextPath() + "/";	
//				response.sendRedirect(location);
//				throw new UserNotFoundException(memId);
//			} else {
//				String location = request.getContextPath() + "/login/loginForm.jsp";	
//				response.sendRedirect(location);
//			}


}