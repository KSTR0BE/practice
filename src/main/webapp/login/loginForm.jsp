<%@page import="java.util.Objects"%>
<%@page import="kr.or.ddit.commons.utils.CookieUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String message = (String)session.getAttribute("authUser");
	if(message!=null && !message.trim().isEmpty()){
		%>
		<script>
			alert("<%=message%>");
		</script>
		<%
		session.removeAttribute("message"); //flash 방식
	}
// 	String idName = "";
// 	String cookieName = new CookieUtils(request).getCookieValue("idSave");
// 	if(cookieName != null && cookieName.trim().isEmpty()){
// 		idName = "cookieName";
// 	} else {
// 		idName = "";
// 	}
		
// 	boolean check = false;
// 	check = new CookieUtils(request).isExists(cookieName);
// 	boolean chked = false;
// 	if(check){
// 		chked = true;
// 	} else {
// 		chked = false;
// 	}
	CookieUtils utils = new CookieUtils(request);
	boolean isExists =  utils.isExists("idCookie");
	String saveId = Objects.toString(utils.getCookieValue("idCookie"), "");
	
	
%>
</head>
<body>
<form method="post" action="<%=request.getContextPath() %>/login/loginProcess.do">
	<input type="text" name="memId" value="<%=saveId %>" placeholder="아이디" />
	<input type="password" name="memPass" placeholder="비밀번호" />
	<input type="checkbox" name="idSave" <%=isExists?"checked":"" %>/>아이디 기억하기
<!-- 	체크박스가 체크된 경우, -->
<!-- 	로그인에 성공했다면, 해당 아이디를 일주일동안 저장하고, 현재 재접속시 저장된 아이디를 UI 복원, -->
<!-- 	체크되지 않은 경우, -->
<!-- 	로그인에 성공했을때, 저장된 아이디가 있는 경우. 제거함. -->
	<button type="submit">로그인</button>
</form>
</body>
</html>