<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<a href="<c:url value='/prod/prodInsert.do'/>" class="btn btn-primary">신규 상품 등록</a>
<table class="table table-bordered">
	<thead class="table dark">
		<tr>
			<th>상품명</th>
			<th>분류명</th>
			<th>제조사명</th>
			<th>구매가</th>
			<th>판매가</th>
			<th>세일가</th>
			<th>구매지수</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${not empty prodList}">
				<c:forEach items="${prodList }" var="i">
					<tr>
					<td>
						<c:url value="/prod/prodDetail.do" var="prodDetailUrl">
							<c:param name="what" value="${i.prodId }" />
						</c:url>
						<a 
						data-bs-toggle="offcanvas" 
						href="#offcanvas" 
						role="button"
						aria-controls="offcanvasRight" 
						data-detail-url="${prodDetailUrl }">
						${i.prodName }
						</a>
					</td>
						<td>${i.lprod.lprodNm }</td>
						<td>
						<c:url value="/buyer/buyerDetail.do" var="buyerDetailUrl">
							<c:param name="what" value="${i.buyer.buyerId }" />
						</c:url>
						<a 
						data-bs-toggle="offcanvas" 
						href="#offcanvas" 
						role="button"
						aria-controls="offcanvasRight" 
						data-detail-url="${buyerDetailUrl }" >${i.buyer.buyerName }</a>
						</td>
						<td>${i.prodCost }</td>
						<td>${i.prodPrice }</td>
						<td>${i.prodSale }</td>
						<td>${i.cartCount }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="7">해당 제조사 없음.</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>

<div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvas" aria-labelledby="offcanvasRightLabel">
	<div class="offcanvas-header">
	    <h5 class="offcanvas-title" id="offcanvasRightLabel">상세정보</h5>
	    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
	</div>
	<div class="offcanvas-body">
		<div>
	
	  	</div>
	</div>
</div>
<script src="${cPath }/resources/js/app/prod/prodList.js"></script>