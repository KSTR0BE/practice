<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02/jstlDesc.jsp</title>
</head>
<body>
<h4>JSTL(Jsp Standard Tag Library)</h4>
<pre>
	커스텀 태그 : 필요에 의해 개발자에 의해 새로 정의된 태그
		사용 절차
		1. 라이브러리 jar(의존성) 필요
		2. taglib 지시자로 커스텀 태그 로딩 필요(접두어 결정)
 		3. <접두어:테그명 /> 형태로 사용.
 		
 		core 태그 종류
 		1. 속성 지원 : set (정의, 할당), remove(제거)
 			<c:set var="attrname" value="속성값" scope="request" />
 			${attrname }
 			<c:remove var="attrname" scope="request"/>
 			-->${attrname }
 		2. 조건문
 			- 단일 조건문 : if(조건식){}
 			<c:set var="targetList" value='<%=Arrays.asList("1", "2", "3") %>'></c:set>
 			<c:if test="${empty targetList }">
 				targetList 없음.
 			</c:if>
 			<c:if test="${not empty targetList }">
 				targetList 있음.
 			</c:if>
 			
	 		- 다중 조건문 : choose when otherwise
 			<c:choose>
	 			<c:when test="${not empty targetList }">
	 				targetList 있음.
	 			</c:when>
	 			<c:otherwise>
	 				targetList 없음.
	 			</c:otherwise>
 			</c:choose>
 		3. 반복문 : forEach, forTokens
 			for( 초기값; 종료조건; 증감식;), for(블럭변수 : 반복대상 집합객체)
 			<c:forEach begin="1" end="5" step="1" var="i">
 				${i }
 			</c:forEach>
 			
 			향상식
 			<c:forEach items="${targetList }" var="num">
 				${num * 100}
 			</c:forEach>
 			아버지가방에들어가신다
 			아버지 가방에 들어가신다
 			아버지가 방에 들어가신다
 			문장을 구성하는 글자는 같은데 띄어쓰기라는 문자로 문장이 3개의 토큰으로 쪼개진다.
 			
 			selectmem_idfrommember;
 			select mem_id frommember;
 			select mem_idfrom member;
 			
 			
 			<c:forTokens items="select mem_idfrom member;" delims=" " var="token">
 				${token }
 			</c:forTokens>
 			
 		4. 기타 : url
 			<c:url value="/member/memberDelete.do" var="genUrl">
 				<c:param name="param1" value="1" />
 				<c:param name="param2" value="2" />
 			</c:url>
 			${genUrl }

</pre>
</body>
</html>