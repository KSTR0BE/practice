package kr.or.ddit.login.exception;

/**
 * username에 해당하는 사용자가 없음.
 *
 */
public class UserDeleteFoundException extends AuthenticateException {

	public UserDeleteFoundException(String username) {
		super(String.format("%s 탈퇴된 회원", username));
	}


}
