<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>    
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/board.css" />

<script>
/**
* boardEnrollFrm 유효성 검사
*/
window.onload = () => {
	document.boardEnrollFrm,onsubmit = (e) => {
		const frm = e.target;
		
		//제목을 작성하지 않은 경우 폼제출할 수 없음.
		const titleVal = frm.title.value.trim(); //좌우 공백 제거된 상태로 가져오기.
		//console.log(titleVal);
		if(!/^.+$/.test(titleVal)){
			alert('제목을 작성해주세요.');				
			frm.title.select();
			return false;
		}
		
		//내용을 작성하지 않은 경우 폼제출할 수 없음.
		const contentVal = frm.content.value.trim(); 
		console.log(contentVal);
 		if(!/^(.|\n)+$/.test(contentVal)){ //아무글자(.)가 아닌 개행문자가 있어서 인식못함. -> (.|\n)으로 바꿔줘야 함.
			alert('내용을 작성해주세요.');				
			frm.content.select();
			return false;
		}
		return true;
	}
}
</script>
<section id="board-container">
<h2>게시판 작성</h2>
<form
	name="boardEnrollFrm"
	action="<%=request.getContextPath() %>/board/boardEnroll" 
	method="post"
	enctype="multipart/form-data">
	<table id="tbl-board-view">
	<tr>
		<th>제 목</th>
		<td><input type="text" name="title" required></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>
			<input type="text" name="memberId" value="<%= loginMember.getMemberId() %>" readonly/>
		</td>
	</tr>
	<tr>
		<th>첨부파일</th>
		<td>			
			<input type="file" name="upFile1">
			<br>
			<input type="file" name="upFile2">
		</td>
	</tr>
	<tr>
		<th>내 용</th>
		<td><textarea rows="5" cols="40" name="content"></textarea></td>
	</tr>
	<tr>
		<th colspan="2">
			<input type="submit" value="등록하기">
		</th>
	</tr>
</table>
</form>
</section>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
