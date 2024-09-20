package kr.or.ddit.validate;

import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidateUtils {
	private static Validator validator;
	
	static {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}
	
	
	public static <T> void validate(T target, Map<String, String> errors, Class...groups) { //... 가변형 파라미터
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(target, groups);
		boolean valid = constraintViolations.isEmpty();
		log.debug("검증 통과여부 : {}", valid);
		for(ConstraintViolation<T> single : constraintViolations) {
			log.debug("===>{}",single);
			errors.put(single.getPropertyPath().toString(), single.getMessage());
		}
	}
}
