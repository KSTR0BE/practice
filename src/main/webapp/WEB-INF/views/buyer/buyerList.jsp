<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<a href='<c:url value="/buyer/buyerInsert.do" />' class="btn btn-success">신규 제조사 등록</a>
<table class="table table-bordered">
	<thead class="table dark">
		<tr>
			<th>제조사아이디</th>
			<th>분류명</th>
			<th>제조사이름</th>
			<th>지역1</th>
			<th>담당자명</th>
			<th>연락처</th>
			<th>거래품목수</th>
		</tr>
	</thead>
	<tbody id="list-body">
<%-- 	<c:choose> --%>
<%-- 		<c:when test="${not empty buyerList}"> --%>
<%-- 			<c:forEach items="${buyerList }" var="i"> --%>
<!-- 				<tr> -->
<%-- 					<td>${i.buyerId }</td> --%>
<%-- 					<td>${i.lprod.lprodNm }</td> --%>
<!-- 					<td> -->
<%-- 					<c:url value="/buyer/buyerDetail.do" var="detailUrl" scope="request" > --%>
<%-- 						<c:param name="what" value="${i.buyerId }"></c:param> --%>
<%-- 					</c:url> --%>
<!-- 					<a  -->
<!-- 					data-bs-toggle="offcanvas"  -->
<!-- 					href="#offcanvasExample"  -->
<!-- 					role="button" -->
<!-- 					aria-controls="offcanvasExample"  -->
<%-- 					data-detail-url="${detailUrl }"> --%>
					
<%-- 					${i.buyerName } --%>
<!-- 					</a> -->
<!-- 					</td> -->
<%-- 					<td>${i.buyerAdd1 }</td> --%>
<%-- 					<td>${i.buyerComtel }</td> --%>
<%-- 					<td>${i.buyerCharger }</td> --%>
<%-- 					<td>${i.cartCount }</td> --%>
<!-- 				</tr> -->
<%-- 			</c:forEach> --%>
<%-- 		</c:when> --%>
<%-- 		<c:otherwise> --%>
<!-- 			<tr> -->
<!-- 				<td colspan="7"> 해당 제조사 없음.</td> -->
<!-- 			</tr> -->
<%-- 		</c:otherwise> --%>
<%-- 	</c:choose> --%>
	</tbody>
</table>

<div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
	<div class="offcanvas-header">
	    <h5 class="offcanvas-title" id="offcanvasExampleLabel">상세정보</h5>
	    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
	</div>
	<div class="offcanvas-body">
		<div>
	
	  	</div>
	</div>
</div>
<script src="${cPath }/resources/js/app/buyer/buyerList.js"></script>