package kr.or.ddit.commons.utils;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang3.StringUtils;

public class CustomBeanUtils {
	static {
		Converter dateConverter = new Converter() {
			//마이바티스, 롬복도 이러한 리플렉션 구조 하에 일어난다.
			@Override
			public <T> T convert(Class<T> type, Object value) {
				if(value == null || StringUtils.isBlank(value.toString())) {
					return null;
				} else {
//	            	return (T) LocalDate.parse(value.toString());
					try {
						return (T)type.getDeclaredMethod("parse", CharSequence.class).invoke(null, value.toString());
						// pasrse라는 메소드중에 차시퀀스의 파라미터를 가진 애를 가져와 없으면 못가져옴
						//Declared를 하면 접근제어자가 무엇이든 가져올 수 있다.
						//invoke
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
							| NoSuchMethodException | SecurityException e) {
						throw new RuntimeException(e);
					}
				}
			}
		};
		ConvertUtils.register(dateConverter, Year.class);
		ConvertUtils.register(dateConverter, YearMonth.class);
		ConvertUtils.register(dateConverter, LocalDate.class);
		ConvertUtils.register(dateConverter, LocalDateTime.class);
	}
	
	public static void populate(Object bean, Map map) {
		try {	
			BeanUtils.populate(bean, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
}
