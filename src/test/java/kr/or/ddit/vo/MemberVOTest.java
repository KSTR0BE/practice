package kr.or.ddit.vo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import kr.or.ddit.validate.groups.DeleteGroup;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.validate.groups.UpdateGroup;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class MemberVOTest {
	static Validator validator;
	
	@BeforeAll
	static void selUpBeforeClass() {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}
	
	@Test
	void Test() {
		MemberVO target = new MemberVO();
//		target.setMemId("a001");
//		target.setMemPass("aaDf12$");
//		target.setMemName("이름");
//		target.setMemMail("as@gmail.com");
//		target.setMemZip("12345");
//		target.setMemAdd1("주소1");
//		target.setMemAdd2("주소2");
//		target.setMemHometel("111-123-1234");
//		target.setMemRegno1("111111");
//		target.setMemRegno2("1111111");
		Set<ConstraintViolation<MemberVO>> constraintViolations = validator.validate(target, UpdateGroup.class);
		boolean valid = constraintViolations.isEmpty();
		log.info("검증 통과여부 : {}", valid);
		for(ConstraintViolation<MemberVO> single : constraintViolations) {
			log.info("===>{}",single);
		}
	}
	
	@Test
	void test2() {
		MemberVO target = new MemberVO();
		Map<String, String> errors = new LinkedHashMap<String, String>();
		validate(target, errors, UpdateGroup.class);
		boolean valid = errors.isEmpty();
		log.info("검증 통과 여부 : {}",valid);
		log.info("통과하지 못한 개수 : {}",errors.size());
	}
	
	static <T> void validate(T target, Map<String, String> errors, Class...groups) { //... 가변형 파라미터
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(target, groups);
		boolean valid = constraintViolations.isEmpty();
		log.info("검증 통과여부 : {}", valid);
		for(ConstraintViolation<T> single : constraintViolations) {
			log.info("===>{}",single);
			errors.put(single.getPropertyPath().toString(), single.getMessage());
		}
	}
	

}
