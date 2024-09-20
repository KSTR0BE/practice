<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.invalid {
		border: 2px solid red;
	}
</style>    
    
    
    
<form method="post">
<table class="table table-strip">
	<tr>
		<th>제목</th>
		<td>
			<input type="text" name="boardTitle" class="form-control invalid" value="${board.boardTitle}" required/>
			<span class="invalid">${errors.boardTitle }</span>
		</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>
			<input type="text" name="boardWriter" class="form-control" value="${board.boardWriter}" required/>
			<span class="invalid">${errors.boardWriter }</span>
		</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>
			<textarea name="boardContent" class="form-control" >${board.boardContent}</textarea>
			<span class="invalid">${errors.boardContent }</span>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="submit" class="btn btn-primary">전송</button>
			<button type="reset" class="btn btn-danger">취소</button>
		</td>
	</tr>
</table>
</form>

<script src="<%=request.getContextPath()%>/resources/js/app/jdbcBoard/insert.js"></script>
