package kr.or.ddit.jdbcboard.service;

import java.util.List;

import kr.or.ddit.vo.JdbcBoardVO;

/**
 * 게시글 (등록, 조회, 수정, 삭제)하기 위한 logic layer
 *
 */
public interface JdbcBoardService {
	public boolean createJdbcBoard(JdbcBoardVO boardVO);
	public List<JdbcBoardVO>retrieveJdbcBoardList();
	/**
	 * 한건의 게시글 조회
	 * @param boardNo 조회할 게시글 번호
	 * @return 해당 글이 없는 경우, unchecked JdbcBoardException(boardNo) 발생시킴
 	 */
	public JdbcBoardVO retrieveJdbcBoard(int boardNo);
	/**
	 * @param boardVO
	 * @return 수정할 대상 글이 없는 경우, unchecked JdbcBoardException(boardNo) 발생시킴
	 */
	public boolean modifyJdbcBoard(JdbcBoardVO boardVO);
	/**
	 * @param boardNo
	 * @return 삭제할 대상 글이 없는 경우, unchecked JdbcBoardException(boardNo) 발생시킴
	 */
	public boolean removeJdbcBoard(int boardNo);
}
