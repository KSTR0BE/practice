<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="kr.or.ddit.db.ConnectionFactoryWithDS"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01/performanceCheck.jsp</title>
</head>
<body>
<h4>요청 처리에 걸리는 소요 시간</h4>
<%
	long sum = 0;
	long avg = 0;
	long start = System.currentTimeMillis();
			
		for(int i = 1; i <101; i++){
		MemberVO member = null;

			try (
				Connection conn = ConnectionFactoryWithDS.getConnection();
				Statement stmt = conn.createStatement();
			) {
				String sql = "SELECT MEM_ID, MEM_NAME FROM MEMBER WHERE MEM_ID = 'a001'";
				ResultSet rs = stmt.executeQuery(sql);
				if(rs.next()){
					member = new MemberVO();
					member.setMemId(rs.getString("MEM_ID"));
					member.setMemName(rs.getString("MEM_NAME"));
				}
			}//커넥션이 열고 닫히는 시간이 오래걸리는데 반복문이 더 빨리 실행되어 닫히기도 전에 열리기 때문에 그게 쌓여서 30개 이상 걸려 터진 것
			
			out.println(member);
		}
	long end = System.currentTimeMillis();
	sum = end-start;
	avg = sum/100;
	//개발용 디비는 한번에 30개 미만의 커넥션만 가능
%>
<br/>
소요시간 : T1(DB 접근) + T2(처리 시간) <br/>
소요시간 : (T1(DB 접근) + T2(처리 시간)) * 100 <br/>
소요시간 : (T1(DB 접근) + T2(처리 시간)* 100)<br/>

pooling 안할때<br/>

평균 소요시간(T1 + T2) : 10ms --> 0ms<br/>
평균 소요시간(T1 + T2) * 100 : 168ms --> 27ms<br/>
평균 소요시간(T1 + T2 * 100) : 14ms<br/>
평균 소요시간(T1 * 100 + T2) : 650ms<br/>

pooling 안할때<br/>

<p>
====>소요시간 :<%=sum %>ms
</p>
평균 소요 시간 : <%=avg %>ms
</body>
</html>