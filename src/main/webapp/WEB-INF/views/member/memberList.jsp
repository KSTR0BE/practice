<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!-- SSR(동기) : EL + JSTL -->
<table class="table">
	<thead>
		<tr>
			<th>회원아이디</th>
			<th>이름</th>
			<th>휴대폰</th>
			<th>주소1</th>
			<th>이메일</th>
			<th>마일리지</th>
		</tr>
	</thead>
	<tbody>
	<c:choose>
		<c:when test="${not empty list }">
			<c:forEach items="${list }" var="i">
			<tr>
				<td>${i.memId }</td>
				<td>${i.memName }</td>
				<td>${i.memHp }</td>
				<td>${i.memAdd1 }</td>
				<td>${i.memMail }</td>
				<td>${i.memMileage }</td>
			</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="6"> 회원이 없음.</td>
			</tr>
		</c:otherwise>
	</c:choose>
	</tbody>
</table>