<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<c:set var="userPrincipal" value="${pageContext.request.userPrincipal }"/>

<tiles:insertAttribute name="preScript" />


<c:if test="${not empty message }">
	<script>
		alert("${message}");
	</script>
	<c:remove var="message" scope="session"/>
</c:if>


</head>
<body>
<h4>공통제목 - 타일즈 레이아웃 1</h4>
<main>

	<tiles:insertAttribute name="contentPage" />

</main>
	<tiles:insertAttribute name="postScript" />


<%-- <jsp:include page="/WEB-INF/includee/postScript.jsp" /> --%>
</body>
</html>