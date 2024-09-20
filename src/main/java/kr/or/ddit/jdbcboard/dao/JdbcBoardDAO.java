package kr.or.ddit.jdbcboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.JdbcBoardVO;

/**
 * JDBC_BOARD엔터티를 대상으로 crud를 위한 persistence layer
 *
 */
public interface JdbcBoardDAO {
	public int insertJdbcBorad(JdbcBoardVO boardVO);
	public List<JdbcBoardVO> selectJdbcBoardList();
	public JdbcBoardVO selectJdbcBoard(@Param("no") int boardNo);
	int updateJdbcBoard(JdbcBoardVO boardVO);
	int deleteJdbcBoard(@Param("boardNo") int boardNo);
	

}
