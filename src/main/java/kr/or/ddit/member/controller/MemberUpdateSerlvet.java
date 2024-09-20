package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.commons.utils.CustomBeanUtils;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.TilesViewResolver;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.validate.ValidateUtils;
import kr.or.ddit.validate.groups.UpdateGroup;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.MemberVOWrapper;

@WebServlet("/member/memberUpdate.do")
public class MemberUpdateSerlvet extends HttpServlet {
	MemberService service = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemberVOWrapper principal = (MemberVOWrapper)req.getUserPrincipal();
		MemberVO member = service.retrieveMember(principal.getName());
		req.setAttribute("member", member);
		String lvn = "member/memberForm";
		new ViewResolverComposite().resolveView(lvn, req, resp);
		
		
		
		
//		MemberVOWrapper principal = (MemberVOWrapper)req.getUserPrincipal();
//		MemberVO authUser = principal.getRealUser();
//		
//		MemberVO member = service.retrieveMember(authUser.getMemId());
//		
//		req.setAttribute("member", member);
//		
//		String view = "/member/memberForm.miles";
//		req.getRequestDispatcher(view).forward(req, resp);
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1. 모든 파라미터를 받고 --> MemberVO로 바인드 함.
		MemberVO member = new MemberVO();
		req.setAttribute("member", member);
		
		CustomBeanUtils.populate(member, req.getParameterMap());
		
		try {
			Converter dateConverter = new Converter() {
				
				@Override
				public <T> T convert(Class<T> type, Object value) {
					if(value == null || StringUtils.isBlank(value.toString())) {
						return null;
					} else {
		            	return (T) LocalDate.parse(value.toString());
					}
				}
			};
			
			ConvertUtils.register(dateConverter, LocalDate.class);
			
			
			BeanUtils.populate(member, req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new ServletException(e);
		}
//		2. MemberVO에 대한 검증
		Map<String, String> errors = new HashMap<String, String>();
		req.setAttribute("errors", errors);
		ValidateUtils.validate(member, errors, UpdateGroup.class);
//		3. 검증 통과
		String lvn = null;
		if(errors.isEmpty()) {
//			수정 로직 실행 
			ServiceResult result = service.modifyMember(member);
			if(ServiceResult.OK.equals(result)) {
//			- 수정 성공 : mypage로 이동(redirect)
				lvn = "redirect:/mypage";
				
			} else {
//			- 비번 오류 : memberForm 이동(기존 데이터, 메세지)
				req.setAttribute("message", "비밀번호 오류");
				lvn = "member/memberForm";
			}
			
		} else {
//		4. 검증 실패 : memberForm 이동(기존 데이터, 검증 결과)
			lvn = "member/memberForm";
			
		}
		new ViewResolverComposite().resolveView(lvn, req, resp);
	}		
}
		
//				//검증 X -> 멤버폼 포스트로
//		MemberVO inputData = new MemberVO();
//		
//	      try {
//			req.setAttribute("inputData", inputData);
//			Converter converter = new Converter() {
//	             
//	        	  @Override
//	        	  public <T> T convert(Class<T> type, Object value) {
//	              if(value != null) {
//	            	  String valueStr = value.toString();
//	            	  return (T) LocalDate.parse(valueStr);
//	               } else {
//	                  return null;                  
//	               }
//	                
//	             }
//	          };
//	          ConvertUtils.register(converter, LocalDate.class);
//	          BeanUtils.populate(inputData, req.getParameterMap());
//	      } catch (Exception e) {
//	          throw new ServletException(e);
//	      }
//
//		
//		if(StringUtils.isBlank(inputData.getMemPass())) {
//			resp.sendError(400, "필수 파라미터 누락");
//			return;
//		}
//		
//		MemberVOWrapper principal = (MemberVOWrapper)req.getUserPrincipal();
//		ServiceResult result = service.removeMember(inputData);
//		if(ServiceResult.OK.equals(result)) {
//			resp.sendRedirect(req.getContextPath()+"/mypage");
//		} else {
//			String message = "비밀번호 오류";
//			req.getSession().setAttribute("message", message);
//			resp.sendRedirect(req.getContextPath()+"/member/memberUpdate.do");
//		}
//				//수정성공 -> 마이페이지
//				//2중 인증 비번오류 -> 멤버폼

