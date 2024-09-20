package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
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
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberInsert.do")
public class MemberInsertServlet extends HttpServlet {
	MemberService service = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String lvn = "member/memberInsert";
		
		new ViewResolverComposite().resolveView(lvn, req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1. 모든 파라미터를 받고 --> MemberVO(command object)로 바인드 함.
		MemberVO member = new MemberVO();
		req.setAttribute("member", member);
		
		CustomBeanUtils.populate(member, req.getParameterMap());
		
//		2. MemberVO(command object)에 대한 검증
		Map<String, String> errors = new HashMap<String, String>();
		req.setAttribute("errors", errors);
		ValidateUtils.validate(member, errors, InsertGroup.class);
//		3. 검증 통과
		String lvn = null;
		if(errors.isEmpty()) {
//			가입 로직 실행 
			ServiceResult result = service.createMember(member);
			if(ServiceResult.OK.equals(result)) {
//			- 가입 성공 : mypage로 이동(redirect)
				lvn= "redirect:/";
			} else {
//			- 중복, 추가 실패 : memberInsert 이동(기존 데이터, 메세지)
				req.setAttribute("message", "중복된 ID");
				lvn= "member/memberInsert";
			}
		} else {
//		4. 검증 실패 : memberInsert 이동(기존 데이터, 검증 결과)
			lvn= "member/memberInsert";
		}
		new ViewResolverComposite().resolveView(lvn, req, resp);
	}		
		
	
}
