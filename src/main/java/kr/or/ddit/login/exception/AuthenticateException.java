package kr.or.ddit.login.exception;

/**
 * 인증 실패 상황을 포괄적으로 표현하기 위한  unchecked 예외
 *
 */
public class AuthenticateException extends RuntimeException {

	public AuthenticateException() {
		super();
	}

	public AuthenticateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AuthenticateException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuthenticateException(String message) {
		super(message);
	}

	public AuthenticateException(Throwable cause) {
		super(cause);
	}

}
