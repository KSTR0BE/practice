package kr.or.ddit.jdbcboard.exception;

public class JdbcBoardException extends RuntimeException {

	public JdbcBoardException(int boardNo) {
		super(String.format("%d 번 글이 존재하지 않음.", boardNo));
	}

	
}
