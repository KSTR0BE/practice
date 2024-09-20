package kr.or.ddit.jdbcboard.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.jdbcboard.service.JdbcBoardService;
import kr.or.ddit.jdbcboard.service.JdbcBoardServiceImpl;
import kr.or.ddit.vo.JdbcBoardVO;

@WebServlet("/jdbcboard/insert.do")
public class JdbcBoardInsertServlet extends HttpServlet {
	JdbcBoardService service = new JdbcBoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String view = "/jdbcBoard/insert.miles";
		req.getRequestDispatcher(view).forward(req, resp);
	}
	
	
	
	private void validate(JdbcBoardVO board, Map<String, String> errors) {
		if(board.getBoardTitle()==null || board.getBoardTitle().trim().isEmpty()) {
			errors.put("boardTitle", "글 제목 누락");
		}
		if(board.getBoardWriter()==null || board.getBoardWriter().trim().isEmpty()) {
			errors.put("boardWriter", "글 작성자 누락");
		}
		if(board.getBoardContent()==null || board.getBoardContent().trim().isEmpty()) {
			errors.put("boardContent", "내용 부실");
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JdbcBoardVO board = new JdbcBoardVO();
		req.setAttribute("board", board);
		try {
			BeanUtils.populate(board, req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new ServletException(e);
		}
		Map<String, String> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		validate(board, errors);
		
		if(errors.isEmpty()) {
			service.createJdbcBoard(board);
			resp.sendRedirect(req.getContextPath() + "/jdbcboard/list.do");			
		} else {
			String view = "/jdbcBoard/insert.miles";
			req.getRequestDispatcher(view).forward(req, resp);
		}
		
		
//		req.setCharacterEncoding("UTF-8");
//		JdbcBoardVO boardVO = new JdbcBoardVO();
//		String boardTitle = req.getParameter("boardTitle");
//		String boardWriter = req.getParameter("boardWriter");
//		String boardContent = req.getParameter("boardContent");
//		
//		boardVO.setBoardTitle(boardTitle);
//		boardVO.setBoardWriter(boardWriter);
//		boardVO.setBoardContent(boardContent);
//		
//		service.createJdbcBoard(boardVO);
//		String view = "/jdbcboard/list.do";
//		resp.sendRedirect(req.getContextPath() + view);
		
//		boolean flag = 
//		if(flag) {
//			view = "/jdbcBoard/insert.miles";			
//		} else {
//			view = "/jdbcBoard/insert.miles"
//		}
//		resp.sendRedirect(view);
	
	}
}
