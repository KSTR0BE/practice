<%@page import="kr.or.ddit.vo.JdbcBoardVO"%>
<%@page import="java.awt.dnd.DropTargetAdapter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap-5.3.3-dist/css/bootstrap.min.css">
<%
	JdbcBoardVO board = (JdbcBoardVO)request.getAttribute("board");
%>
<table class="table table-dark table-striped-columns">
		<tr>
			<th>글번호</th>
			<td><%=board.getBoardNo() %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=board.getBoardTitle() %></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=board.getBoardWriter() %></td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><%=board.getBoardDate() %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><%=board.getBoardContent() %></td>
		</tr>

</table>
