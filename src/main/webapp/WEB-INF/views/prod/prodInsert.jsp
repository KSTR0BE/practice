<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<th>상품아이디</th>
			<td><input type="text" name="prodId" class="form-control"
				required value="${prod.prodId}"><span class="text-danger">${errors.prodId }</span></td>
		</tr>
		<tr>
			<th>상품명</th>
			<td><input type="text" name="prodName" class="form-control"
				required value="${prod.prodName}"><span class="text-danger">${errors.prodName }</span></td>
		</tr>
		<tr>
			<th>분류코드</th>
			<td><input type="text" name="prodLgu" class="form-control"
				required value="${prod.prodLgu}"><span class="text-danger">${errors.prodLgu }</span></td>
		</tr>
		<tr>
			<th>분류코드</th>
			<td><select name="prodLgu" class="form-control" required>
					<option value>분류 선택</option>
					<c:forEach items="${ lprodList}" var="lprod">
						<option label="${lprod.lprodNm}" value="${lprod.lprodGu}"
							${lprod.lprodGu eq prod.prodLgu ? "selected" : "" } />
					</c:forEach>
			</select> <span class="text-danger">${errors.prodLgu }</span></td>
		</tr>
		<tr>
			<th>제조시코드</th>
			<td><input type="text" name="prodBuyer" class="form-control"
				required value="${prod.prodBuyer}"><span class="text-danger">${errors.prodBuyer }</span></td>
		</tr>
		<tr>
			<th>구매가</th>
			<td><input type="number" name="prodCost" class="form-control"
				required value="${prod.prodCost}"><span class="text-danger">${errors.prodCost }</span></td>
		</tr>
		<tr>
			<th>판매가</th>
			<td><input type="number" name="prodPrice" class="form-control"
				required value="${prod.prodPrice}"><span class="text-danger">${errors.prodPrice }</span></td>
		</tr>
		<tr>
			<th>세일가</th>
			<td><input type="number" name="prodSale" class="form-control"
				required value="${prod.prodSale}"><span class="text-danger">${errors.prodSale }</span></td>
		</tr>
		<tr>
			<th>요약정보</th>
			<td><input type="text" name="prodOutline" class="form-control"
				required value="${prod.prodOutline}"><span
				class="text-danger">${errors.prodOutline }</span></td>
		</tr>
		<tr>
			<th>상세정보</th>
			<td><input type="text" name="prodDetail" class="form-control"
				value="${prod.prodDetail}"><span class="text-danger">${errors.prodDetail }</span></td>
		</tr>
		<tr>
			<th>상품이미지</th>
			<td><input type="text" name="prodImg" class="form-control"
				required value="${prod.prodImg}"><span class="text-danger">${errors.prodImg }</span></td>
		</tr>
		<tr>
			<th>총재고</th>
			<td><input type="number" name="prodTotalstock"
				class="form-control" required value="${prod.prodTotalstock}"><span
				class="text-danger">${errors.prodTotalstock }</span></td>
		</tr>
		<tr>
			<th>입고일</th>
			<td><input type="date" name="prodInsdate" class="form-control"
				value="${prod.prodInsdate}"><span class="text-danger">${errors.prodInsdate }</span></td>
		</tr>
		<tr>
			<th>적정재고</th>
			<td><input type="number" name="prodProperstock"
				class="form-control" required value="${prod.prodProperstock}"><span
				class="text-danger">${errors.prodProperstock }</span></td>
		</tr>
		<tr>
			<th>크기</th>
			<td><input type="text" name="prodSize" class="form-control"
				value="${prod.prodSize}"><span class="text-danger">${errors.prodSize }</span></td>
		</tr>
		<tr>
			<th>색상</th>
			<td><input type="text" name="prodColor" class="form-control"
				value="${prod.prodColor}"><span class="text-danger">${errors.prodColor }</span></td>
		</tr>
		<tr>
			<th>배송방법</th>
			<td><input type="text" name="prodDelivery" class="form-control"
				value="${prod.prodDelivery}"><span class="text-danger">${errors.prodDelivery }</span></td>
		</tr>
		<tr>
			<th>단위</th>
			<td><input type="text" name="prodUnit" class="form-control"
				value="${prod.prodUnit}"><span class="text-danger">${errors.prodUnit }</span></td>
		</tr>
		<tr>
			<th>입고량</th>
			<td><input type="number" name="prodQtyin" class="form-control"
				value="${prod.prodQtyin}"><span class="text-danger">${errors.prodQtyin }</span></td>
		</tr>
		<tr>
			<th>출고량</th>
			<td><input type="number" name="prodQtysale" class="form-control"
				value="${prod.prodQtysale}"><span class="text-danger">${errors.prodQtysale }</span></td>
		</tr>
		<tr>
			<th>마일리지</th>
			<td><input type="number" name="prodMileage" class="form-control"
				value="${prod.prodMileage}"><span class="text-danger">${errors.prodMileage }</span></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="submit" class="btn btn-primary">상품 추가</button>
			</td>
		</tr>
	</table>
</form>