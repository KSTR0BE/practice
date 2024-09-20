<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02/elDesc.jsp</title>
</head>
<h4>EL(Expression Language, 표현언어)</h4>
<body>
<pre>
	: 데이터를 출력하는 목적으로 사용되는 스크립트 형태의 언어
	-Scope를 통해 공유되는 속성 데이터에 접근하기 위한 언어.
	<%
		String test = "테스트";
		request.setAttribute("dummyReq", test);
		session.setAttribute("dummySession", test);
		application.setAttribute("dummyApp", test);
		request.setAttribute("dummy", "더미요청");
		session.setAttribute("dummy", "더미세션");
		session.setAttribute("dummy-1", "더미세션1");
		
		request.setAttribute("target", "  "); //JAVA isEmpty와 똑같이 작동함
		List list = new ArrayList();
		list.add("asdf");
		request.setAttribute("targetList", list);
		
	%>
	표현식 : <%=test %>, 
			<%=request.getAttribute("dummyReq") %>,
			<%=session.getAttribute("dummySession") %>,
			<%=application.getAttribute("dummyApp") %>
	표현언어 : ${dummyReq }	, ${dummySession }, ${dummyApp }
			===> ${dummy }
	scope에 접근하는 기본 객체 : requestScope, sessionScope, applicationScope
			----> ${sessionScope.dummy }, ${sessionScope['dummy'] }
			----> ${sessionScope['dummy-1'] }
	지원가능한 연산자 : 산술연산자, 논리연산자(and, or, not), 비교연산자(eq[==], ne[!=], gt[>], lt[<], ge[>=], le[<=] )
			${4/2 }, ${3/2 }, ${"1" + 2 }, ${asd + 3 }, ${"3" + "4" }
<%-- 			${asd + 3 }	asd 존재하지않는속성 null이라 0으로 표시 --%>
<%-- 			${"3" + "4a" } ""안에 값을 숫자로 파싱하려다 보니 500에러 --%>
			${true and true }, ${true and asd }
<%-- 			${true and asd } 존재하지않는속성 null이라 false로 표시 --%>
			${3 lt 4 }, ${3 le 4 }, ${3 ne 4 }
			단항연산자 : --, ++ 지원불가 empty(전위 연산자) 지원함 - 속성 데이터의 존재여부나 해당 데이터의 empty여부 판단에 사용.
			${not empty dummy }, ${empty asdf }
			target의 존재 여부 : ${empty target }
			targetList의 존재 여부 : ${not empty targetList } <!-- 길이 체크 사이즈 체크 -->
			삼항연산자 : 조건식 ? 참표현 : 거짓표현 <!-- = JAVA삼항연산자 -->
			${ empty targetList? "비어있다" : "비어있지 않다" }
</pre>

</body>
</html>