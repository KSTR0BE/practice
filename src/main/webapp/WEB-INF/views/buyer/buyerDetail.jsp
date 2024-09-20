<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<table class="table table-bordered">
	<tr>
		<th>제조사아이디</th>
		<td>${buyer.buyerId}</td>
	</tr>
	<tr>
		<th>제조사명</th>
		<td>${buyer.buyerName}</td>
	</tr>
	<tr>
		<th>분류명</th>
		<td>${buyer.lprod.lprodNm}</td>
	</tr>
	<tr>
		<th>은행명</th>
		<td>${buyer.buyerBank}</td>
	</tr>
	<tr>
		<th>계좌번호</th>
		<td>${buyer.buyerBankno}</td>
	</tr>
	<tr>
		<th>계좌주</th>
		<td>${buyer.buyerBankname}</td>
	</tr>
	<tr>
		<th>우편번호</th>
		<td>${buyer.buyerZip}</td>
	</tr>
	<tr>
		<th>주소1</th>
		<td>${buyer.buyerAdd1}</td>
	</tr>
	<tr>
		<th>주소2</th>
		<td>${buyer.buyerAdd2}</td>
	</tr>
	<tr>
		<th>연락처</th>
		<td>${buyer.buyerComtel}</td>
	</tr>
	<tr>
		<th>팩스번호</th>
		<td>${buyer.buyerFax}</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${buyer.buyerMail}</td>
	</tr>
	<tr>
		<th>담당자</th>
		<td>${buyer.buyerCharger}</td>
	</tr>
	<tr>
		<th>내선번호</th>
		<td>${buyer.buyerTelext}</td>
	</tr>
	<tr>
		<th>거래품목</th>
		<td>
			<table class="table table-striped-columns">
				<thead class="table-dark">
					<tr>
						<th>상품아이디</th>
						<th>상품명</th>
						<th>구매가</th>
						<th>판매가</th>
					</tr>
				</thead>
				<tbody>
				<c:set var="prodList" value="${buyer.prodList}" />
				<c:choose>
					<c:when test="${not empty prodList }">
					<c:forEach items="${prodList}" var="i">
					<tr>
						<td>${i.prodId}</td>
						<td>
							<c:url value="/prod/prodDetail.do" var="detailUrl">
								<c:param name="what" value="${i.prodId }" />
							</c:url>
							<a href="${detailUrl}">${i.prodName}</a>
						</td>
						<td>${i.prodCost}</td>
						<td>${i.prodPrice}</td>
					</tr>
					</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="4"> 거래품목 없음.</td>
						</tr>
					</c:otherwise>
				</c:choose>
				</tbody>
			</table>
		</td>
	</tr>
</table>