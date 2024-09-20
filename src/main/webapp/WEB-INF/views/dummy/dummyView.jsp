<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>
<%
	Object model = request.getAttribute("model");
%>
<%=model %>
<%
// 	request.getRequestDispatcher("/WEB-INF/views/dummy/formUI.jsp").include(request, response);
	pageContext.include("/WEB-INF/views/dummy/formUI.jsp");
%>
<script>
	console.log("dummyView.jsp에서 확인 : ", $);
</script>
</body>
</html>
