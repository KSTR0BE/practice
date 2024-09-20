package kr.or.ddit.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.mvc.ViewResolverComposite;

@WebServlet("/login/logout.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션 만료시킴.
		HttpSession session = request.getSession();
		session.invalidate();
		//웰컴페이지로 이동 리다이렉트로 인증시스템에서 어떤경우에도 포워드로 사용하지 않는다.
		String lvn = "redirect:/";
		new ViewResolverComposite().resolveView(lvn, request, response);
		
	}

}
