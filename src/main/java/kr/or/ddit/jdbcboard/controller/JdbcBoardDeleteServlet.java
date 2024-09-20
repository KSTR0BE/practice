package kr.or.ddit.jdbcboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.jdbcboard.service.JdbcBoardService;
import kr.or.ddit.jdbcboard.service.JdbcBoardServiceImpl;

@WebServlet("/jdbcboard/delete.do")
public class JdbcBoardDeleteServlet extends HttpServlet {
	private JdbcBoardService service = new JdbcBoardServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String what = req.getParameter("what");
		if(what == null || !what.matches("\\d+")) {
			resp.sendError(400, "글번호 이상해!");
			return;
		}
		int boardNo = Integer.parseInt(what);
		service.removeJdbcBoard(boardNo);
		resp.sendRedirect(req.getContextPath()+"/jdbcboard/list.do");
	}
}
