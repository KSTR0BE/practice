package kr.or.ddit.jdbcboard.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

import kr.or.ddit.jdbcboard.exception.JdbcBoardException;
import kr.or.ddit.jdbcboard.service.JdbcBoardService;
import kr.or.ddit.jdbcboard.service.JdbcBoardServiceImpl;
import kr.or.ddit.vo.JdbcBoardVO;

@WebServlet("/jdbcboard/detail.do")
public class JdbcBoardDetailServlet extends HttpServlet {
	private JdbcBoardService service = new JdbcBoardServiceImpl();
	
//	private void validate(JdbcBoardVO boardVO, Map<String, String> errors) {
//		boolean valid= true;
//		if(boardVO.getBoardNo() == null) {
//			valid = false;
//			errors.put("id", "필수 아이디 누락");
//		}
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String what = req.getParameter("what");
		if(what==null || !what.matches("\\d+")) {
			resp.sendError(400, "글번호가 없거나, 정상적이지 않음.");
			return;
		}
		int boardNo = Integer.parseInt(what);
		try {
			JdbcBoardVO board = service.retrieveJdbcBoard(boardNo);
			req.setAttribute("board", board);
//			String view = "/WEB-INF/views/jdbcBoard/detail.jsp";	
			String view = "/jdbcBoard/detail.miles";
			req.getRequestDispatcher(view).forward(req, resp);
			
		} catch (JdbcBoardException e) {
			resp.sendError(404, e.getMessage());
		}
		
		
		
//		Map<String , String> errors = new HashedMap();
//		validate(boardVO, errors);
//		if(errors.isEmpty()) {
//			req.setAttribute("boardVO", boardVO);
//			
//			view = "/WEB-INF/views/jdbcBoard/detail.jsp";
//		} else {
//			view = req.getContextPath()+"/jdbcBoard/list.do";
//		}
//		req.getRequestDispatcher(view).forward(req, resp);			
		
		
	}
}
