package kr.or.ddit.jdbcboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.enumpkg.MimeType;
import kr.or.ddit.jdbcboard.service.JdbcBoardService;
import kr.or.ddit.jdbcboard.service.JdbcBoardServiceImpl;
import kr.or.ddit.vo.JdbcBoardVO;

/**
 * 게시판(CRUD) : /jdbcboard
 * 글작성 : insert.do
 * 글조회 : 
 * -단건 : detail.do?what=34
 * -다건 : list.do
 * 글수정 : update.do
 * 글삭제 : delete.do
 */
@WebServlet("/jdbcboard/list.do")
public class JdbcBoardListServlet extends HttpServlet {
	
	private JdbcBoardService service = new JdbcBoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<JdbcBoardVO> boardList = service.retrieveJdbcBoardList();
		req.setAttribute("boardList", boardList);
		
		String accept =req.getHeader("accept");
		
		String view = null;
		if(accept.contains("json")) {
			view = "/jsonView";		
		} else {
//			view = "/WEB-INF/views/jdbcBoard/list.jsp";
//			view = "/WEB-INF/views/layout.jsp";
			view = "/jdbcBoard/list.miles";
		}
		req.getRequestDispatcher(view).forward(req, resp);
	}

}
