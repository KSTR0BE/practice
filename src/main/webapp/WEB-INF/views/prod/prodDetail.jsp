<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table table-bordered">
	<tr>
		<th>상품명</th>
		<td>${prod.prodName}</td>
	</tr>
	<tr>
		<th>분류명</th>
		<td>${prod.lprod.lprodNm }</td>
	</tr>
	<tr>
		<th>제조사정보</th>
		<td>
			<table class="table table-striped-columns">
				<thead class="table-dark">
					<tr>
						<th>제조사이름</th>
						<th>소재지(지역1)</th>
						<th>담당자명</th>
						<th>이메일</th>
					</tr>
				</thead>
				<tbody>
				<c:set var="buyer" value="${prod.buyer }" />
					<tr>
						<td>${buyer.buyerName }</td>
						<td>${buyer.buyerAdd1 }</td>
						<td>${buyer.buyerCharger }</td>
						<td>${buyer.buyerMail }</td>
					</tr>		
				</tbody>
			</table>
		</td>
	</tr>
	<tr>
		<th>구매가</th>
		<td>${prod.prodCost}</td>
	</tr>
	<tr>
		<th>판매가</th>
		<td>${prod.prodPrice}</td>
	</tr>
	<tr>
		<th>세일가</th>
		<td>${prod.prodSale}</td>
	</tr>
	<tr>
		<th>요약정보</th>
		<td>${prod.prodOutline}</td>
	</tr>
	<tr>
		<th>상세정보</th>
		<td>${prod.prodDetail}</td>
	</tr>
	<tr>
		<th>상품이미지</th>
		<td>${prod.prodImg}</td>
	</tr>
	<tr>
		<th>총재고</th>
		<td>${prod.prodTotalstock}</td>
	</tr>
	<tr>
		<th>입고일</th>
		<td>${prod.prodInsdate}</td>
	</tr>
	<tr>
		<th>적정재고</th>
		<td>${prod.prodProperstock}</td>
	</tr>
	<tr>
		<th>크기</th>
		<td>${prod.prodSize}</td>
	</tr>
	<tr>
		<th>색상</th>
		<td>${prod.prodColor}</td>
	</tr>
	<tr>
		<th>배송방법</th>
		<td>${prod.prodDelivery}</td>
	</tr>
	<tr>
		<th>단위</th>
		<td>${prod.prodUnit}</td>
	</tr>
	<tr>
		<th>입고량</th>
		<td>${prod.prodQtyin}</td>
	</tr>
	<tr>
		<th>출고량</th>
		<td>${prod.prodQtysale}</td>
	</tr>
	<tr>
		<th>마일리지</th>
		<td>${prod.prodMileage}</td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="javascript:;" onclick="history.back()" class="btn btn-secondary">뒤로가기</a>
			<a href='<c:url value="/prod/prodList.do" />' class="btn btn-primary" >목록으로</a>
		</td>
	</tr>

</table>