<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- 
    1. 입력폼을 만들어서(대신 Id는 넣지 않는다 이미 쿼리에서 만들어 주기 때문에)
    2. 데이터가 들어가는거 확인
    3. 서블릿에서 메소드 받아오고
    4. 화면 출력 설정하고
    5.끝
     -->
<form method="post">
<table>
	<tr>
		<th>제조사명</th>
		<td><input type="text" name="buyerName" class="form-control"
			required value="${buyer.buyerName}"><span class="text-danger">${errors.buyerName }</span></td>
	</tr>
	<tr>
		<th>분류코드</th>
		<td><select name="buyerLgu" class="form-control" required>
				<option value>분류 선택</option>
				<c:forEach items="${ lprodList}" var="lprod">
				<option label="${lprod.lprodNm}" value="${lprod.lprodGu}"
					${lprod.lprodGu eq buyer.buyerLgu ? "selected" : "" }
				 />
				</c:forEach>
			</select> <span class="text-danger">${errors.buyerLgu }</span></td>
	</tr>
	<tr>
		<th>은행명</th>
		<td><input type="text" name="buyerBank" class="form-control"
			value="${buyer.buyerBank}"><span class="text-danger">${errors.buyerBank }</span></td>
	</tr>
	<tr>
		<th>계좌번호</th>
		<td><input type="text" name="buyerBankno" class="form-control"
			value="${buyer.buyerBankno}"><span class="text-danger">${errors.buyerBankno }</span></td>
	</tr>
	<tr>
		<th>계좌주</th>
		<td><input type="text" name="buyerBankname" class="form-control"
			value="${buyer.buyerBankname}"><span class="text-danger">${errors.buyerBankname }</span></td>
	</tr>
	<tr>
		<th>우편번호</th>
		<td><input type="text" name="buyerZip" class="form-control"
			value="${buyer.buyerZip}"><span class="text-danger">${errors.buyerZip }</span></td>
	</tr>
	<tr>
		<th>주소1</th>
		<td><input type="text" name="buyerAdd1" class="form-control"
			value="${buyer.buyerAdd1}"><span class="text-danger">${errors.buyerAdd1 }</span></td>
	</tr>
	<tr>
		<th>주소2</th>
		<td><input type="text" name="buyerAdd2" class="form-control"
			value="${buyer.buyerAdd2}"><span class="text-danger">${errors.buyerAdd2 }</span></td>
	</tr>
	<tr>
		<th>연락처</th>
		<td><input type="text" name="buyerComtel" class="form-control"
			required value="${buyer.buyerComtel}"><span
			class="text-danger">${errors.buyerComtel }</span></td>
	</tr>
	<tr>
		<th>팩스번호</th>
		<td><input type="text" name="buyerFax" class="form-control"
			required value="${buyer.buyerFax}"><span class="text-danger">${errors.buyerFax }</span></td>
	</tr>
	<tr>
		<th>이메일</th>
		<td><input type="text" name="buyerMail" class="form-control"
			required value="${buyer.buyerMail}"><span class="text-danger">${errors.buyerMail }</span></td>
	</tr>
	<tr>
		<th>담당자</th>
		<td><input type="text" name="buyerCharger" class="form-control"
			value="${buyer.buyerCharger}"><span class="text-danger">${errors.buyerCharger }</span></td>
	</tr>
	<tr>
		<th>내선번호</th>
		<td><input type="text" name="buyerTelext" class="form-control"
			value="${buyer.buyerTelext}"><span class="text-danger">${errors.buyerTelext }</span></td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="submit" class="btn btn-primary">제조사 추가</button>
		</td>
	</tr>
</table>
</form>