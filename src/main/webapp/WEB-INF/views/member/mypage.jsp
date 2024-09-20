<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table table-bordered">
	<tr>
		<th>EL: 스크립트 언어, 객체의 프로퍼티에 대한 접근(.propName, ['propName'])</th>
		<td>${member.memId },${member['memId'] }</td>
	</tr>
	<tr>
		<th>회원아이디</th>
		<td>${member.memId}</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>${member.memPass}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${member.memName}</td>
	</tr>
	<tr>
		<th>주민번호1</th>
		<td>${member.memRegno1}</td>
	</tr>
	<tr>
		<th>주민번호2</th>
		<td>${member.memRegno2}</td>
	</tr>
	<tr>
		<th>생일</th>
		<td>${member.memBir}</td>
	</tr>
	<tr>
		<th>우편번호</th>
		<td>${member.memZip}</td>
	</tr>
	<tr>
		<th>주소1</th>
		<td>${member.memAdd1}</td>
	</tr>
	<tr>
		<th>주소2</th>
		<td>${member.memAdd2}</td>
	</tr>
	<tr>
		<th>집 번호</th>
		<td>${member.memHometel}</td>
	</tr>
	<tr>
		<th>회사번호</th>
		<td>${member.memComtel}</td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td>${member.memHp}</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${member.memMail}</td>
	</tr>
	<tr>
		<th>직업</th>
		<td>${member.memJob}</td>
	</tr>
	<tr>
		<th>취미</th>
		<td>${member.memLike}</td>
	</tr>
	<tr>
		<th>기념</th>
		<td>${member.memMemorial}</td>
	</tr>
	<tr>
		<th>기념일</th>
		<td>${member.memMemorialday}</td>
	</tr>
	<tr>
		<th>마일리지</th>
		<td>${member.memMileage}</td>
	</tr>
	<tr>
		<th>탈퇴여부</th>
		<td>${member.memDelete}</td>
	</tr>
	<tr>
		<th>권한</th>
		<td>${member.memRole}</td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="button" data-bs-toggle="modal" data-bs-target="#exampleModal" class="btn btn-danger">탈퇴</button>
			<a class="btn btn-primary" href="${pageContext.request.contextPath }/member/memberUpdate.do">수정</a>
		</td>
	</tr>
</table>

<h4>구매상품목록</h4>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>구매번호</th>
			<th>구매일자</th>
			<th>일련번호</th>
			<th>상품내역(분류명, 상품명, 제조사명, 구매수량, 구매금액)</th>
		</tr>
	</thead>
	<c:forEach items="${member.cartList }" var="cart">
	<tbody>
		<tr>
			<td>${cart.cartNo }</td>
			<td>${cart.cartDate }</td>
			<td>${cart.cartSeq }</td>
			<td>
				<table class="table table-striped-columns">
					<thead class="table-dark">
						<tr>
							<th>분류명</th>
							<th>상품명</th>
							<th>제조사명</th>
							<th>구매수량</th>
							<th>구매금액</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${cart.cartProdList}" var="cartProd" >
					<c:set var="prod" value="${cartProd.prod }"/>
						<tr>
							<td>${prod.lprod.lprodNm }</td>
							<c:url value="/prod/prodDetail.do" var="prodUrl">
								<c:param name="what" value="${prod.prodId }"></c:param>
							</c:url>
							<td><a href="${prodUrl }">${cartProd.prod.prodName }</a></td>
							<c:url value="/buyer/buyerDetail.do" var="buyerUrl">
								<c:param name="what" value="${prod.buyer.buyerId }"></c:param>
							</c:url>
							<td><a href="${buyerUrl}">${cartProd.prod.buyer.buyerName }</a></td>
							<td>${cartProd.cartQty }</td>
							<td>${cartProd.cartQty * cartProd.prod.prodPrice } </td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</td>
		</tr>
	</tbody>
	</c:forEach>
</table>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <form action="<c:url value='/member/memberDelete.do' />" method="post">
      <div class="modal-body">
      탈퇴 확인 </br>
      아이디 : ${member.memId} </br></br>
      비밀번호 : <input type="password" name="memPass" required />
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-danger">Delete</button>
      </div>
      </form>
    </div>
  </div>
</div>

