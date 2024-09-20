package kr.or.ddit.jdbcboard.service;

import java.util.List;

import kr.or.ddit.jdbcboard.dao.JdbcBoardDAO;
import kr.or.ddit.jdbcboard.dao.JdbcBoardDAOImpl;
import kr.or.ddit.jdbcboard.exception.JdbcBoardException;
import kr.or.ddit.vo.JdbcBoardVO;

public class JdbcBoardServiceImpl implements JdbcBoardService {
	
	private JdbcBoardDAO dao = new JdbcBoardDAOImpl();

	@Override
	public boolean createJdbcBoard(JdbcBoardVO boardVO) {
		return dao.insertJdbcBorad(boardVO) > 0;
	}

	@Override
	public List<JdbcBoardVO> retrieveJdbcBoardList() {
		return dao.selectJdbcBoardList();
	}

	@Override
	public JdbcBoardVO retrieveJdbcBoard(int boardNo) {
		JdbcBoardVO board = dao.selectJdbcBoard(boardNo);
		if(board == null) {
			throw new JdbcBoardException(boardNo);
		}
		return board;
	}

	@Override
	public boolean modifyJdbcBoard(JdbcBoardVO boardVO) {
		retrieveJdbcBoard(boardVO.getBoardNo());
		return dao.updateJdbcBoard(boardVO) > 0 ;

	}

	@Override
	public boolean removeJdbcBoard(int boardNo) {
		retrieveJdbcBoard(boardNo);
		return dao.deleteJdbcBoard(boardNo) > 0;
	}

}
