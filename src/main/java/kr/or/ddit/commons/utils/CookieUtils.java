package kr.or.ddit.commons.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 쿠키의 생성과 조회를 지원하는 유틸리티
 *
 */
public class CookieUtils {
	private Map<String, Cookie> cookieMap;
	
	public CookieUtils(HttpServletRequest req) {
		cookieMap = new HashMap<>();
		Cookie[] cookies = req.getCookies();
		if(cookies!=null) {
			for(Cookie single : cookies) {
				cookieMap.put(single.getName(), single);
			}
		}
	}
	
	public Cookie getCookie(String name) {
		return cookieMap.get(name);
	}
	
	public String getCookieValue(String name) {
		Cookie finded = getCookie(name);
		String decodedValue;
		try {
			if(finded != null) {
				decodedValue = URLDecoder.decode(finded.getValue(), "UTF-8");
				return decodedValue;
			} else {
				return null;
			}
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean isExists(String name) {
		return cookieMap.containsKey(name);
		
	}
	
	public static Cookie createCookie(String name, String value) {
		String encodedValue;
		try {
			encodedValue = URLEncoder.encode(value, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
			//예외 전환의 목적
//			1. 좀더 구체적으로 상황을 표현할 수 있는 예외로 전환.
//			2. 원본 예외의 특성을 변경하고 싶을때
		}
		Cookie cookie = new Cookie(name, encodedValue);
		return cookie;
	}

	public static Cookie createCookie(String name, String value, int maxAge) {
		Cookie cookie = createCookie(name, value);
		cookie.setMaxAge(maxAge);
		return cookie;
	}
	public static Cookie createCookie(String name, String value, String path) {
		Cookie cookie = createCookie(name, value);
		cookie.setPath(path);
		return cookie;
	}
	public static Cookie createCookie(String name, String value, String path, int maxAge) {
		Cookie cookie = createCookie(name, value);
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}
	
}
