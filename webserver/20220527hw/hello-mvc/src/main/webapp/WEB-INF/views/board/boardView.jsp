<%@page import="board.model.dto.BoardComment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.model.dto.Attachment"%>
<%@page import="java.util.List"%>
<%@page import="board.model.dto.BoardExt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	BoardExt board = (BoardExt) request.getAttribute("board");	
	List<BoardComment> comments = board.getBoardComments(); 
	boolean canEdit = loginMember != null 
			&& (loginMember.getMemberId().equals(board.getMemberId()) 
					|| loginMember.getMemberRole() == MemberRole.A);
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/board.css" />
<section id="board-container">
	<h2>게시판</h2>
	<table id="tbl-board-view">
		<tr>
			<th>글번호</th>
			<td><%= board.getNo() %></td>
		</tr>
		<tr>
			<th>제 목</th>
			<td><%= board.getTitle() %></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%= board.getMemberId() %></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td><%= board.getReadCount() %></td>
		</tr>
		<%
			List<Attachment> attachments = board.getAttachments();
			if(attachments != null && !attachments.isEmpty()){
				for(Attachment attach : attachments){ 
		%>
		<tr>
			<th>첨부파일</th>
			<td>
				<%-- 첨부파일이 있을경우만, 이미지와 함께 original파일명 표시 --%>
				<img alt="첨부파일" src="<%=request.getContextPath() %>/images/file.png" width=16px>
				<%-- 첨부파일의 originalFilename --%>
				<a href="<%= request.getContextPath() %>/board/fileDownload?no=<%= attach.getNo() %>"><%= attach.getOriginalFilename() %></a>
			</td>
		</tr>
		<% 	}
		} %>
		<tr>
			<th>내 용</th>
			<td><%= board.getContent() %></td>
		</tr>
		<% if(canEdit){ %>
		<tr>
			<%-- 작성자와 관리자만 마지막행 수정/삭제버튼이 보일수 있게 할 것 --%>
			<th colspan="2">
				<input type="button" value="수정하기" onclick="updateBoard()">
				<input type="button" value="삭제하기" onclick="deleteBoard()">
			</th>
		</tr>
		<%} %>
	</table>
    <hr style="margin-top:30px;" />    
    
    <div class="comment-container">
        <div class="comment-editor">
            <form
            action="<%=request.getContextPath()%>/board/boardCommentEnroll" method="post" name="boardCommentFrm">
                <input type="hidden" name="boardNo" value="<%= board.getNo() %>" />
                <input type="hidden" name="memberId" value="<%= loginMember != null ? loginMember.getMemberId() : "" %>" />
                <input type="hidden" name="commentLevel" value="1" />
                <input type="hidden" name="commentRef" value="0" />    
                <textarea name="content" cols="59" rows="3"></textarea>
                <button type="submit" id="btn-comment-enroll1" >등록</button>
            </form>
        </div>
        <!--table#tbl-comment-->
        <% if(comments != null && !comments.isEmpty()) {%>
        <table id="tbl-comment">
        	<tbody>
        	<% for(BoardComment bc : comments){ 
	        		boolean canDelete = loginMember != null
	        				&& (loginMember.getMemberId().equals(bc.getMemberId()) 
	        					|| loginMember.getMemberRole() == MemberRole.A);
        		
       				if(bc.getCommentLevel() == 1){ %>
	        		<tr class="level1">
	        			<td>
	        				<sub class="comment-writer"><%= bc.getMemberId() != null ? bc.getMemberId() : "(알 수 없는 사용자)" %></sub>
	        				<sub class="comment-date"><%= bc.getRegDate() %></sub>
	        				<br />
	        				<%= bc.getContent() %>
	       				</td>
	       				<td>
	       					<button class="btn-reply" value="<%= bc.getNo() %>">답글</button>
	        				<% if(canDelete){ %>
	       					<button class="btn-delete" value="<%= bc.getNo() %>">삭제</button>
	        				<%} %>
	       				</td>
	        		</tr>
        	<% 		} else { %>
	        		<tr class="level2">
	        			<td>
	        				<sub class="comment-writer"><%= bc.getMemberId() != null ? bc.getMemberId() : "(알 수 없는 사용자)"%></sub>
	        				<sub class="comment-date"><%= bc.getRegDate() %></sub>
	        				<br />
	        				<%= bc.getContent() %>
	       				</td>
	       				<td>
	       					<%-- 대댓글 까지만 적용했기 때문에 답글버튼은 작성 굳이 안해도 됨. --%>
	        				<% if(canDelete){ %>
	       					<button class="btn-delete" value="<%= bc.getNo() %>" >삭제</button>
	        				<%} %>
	       				</td>
	        		</tr>
      		<% 		}
        		} %>
        	</tbody>
        </table>
        <% } %>
    </div>
</section>
<%-- .btn-delete click handler Frm을 동적으로 전송 --%>
<form 
	action="<%= request.getContextPath() %>/board/boardCommentDelete" 
	name="boardCommentDelFrm"
	method="POST">
	<input type="hidden" name="commentNo" value="" />
	<input type="hidden" name="boardNo" value="<%= board.getNo() %>"/>
</form>
<script>
document.querySelectorAll(".btn-delete").forEach((button) =>{
	button.onclick = (e) => {
		const btnVal = e.target.value
		document.querySelector("[name=commentNo]").value = btnVal;
		deleteBoardComment();
	};
});
const deleteBoardComment = () => {
	if(confirm('정말 삭제하시겠습니까?'))
		document.boardCommentDelFrm.submit();
}
/**
 *  답글 버튼(.btn-reply) 클릭 시 동적으로 버튼 생성하기
 *	tbody > tr > td > .btn-reply
 */
document.querySelectorAll(".btn-reply").forEach((button) =>{
	button.onclick = (e) => {
		if(<%= loginMember == null %>){
			loginAlert();
			return;
		}
		
		const {value : commentRef} = e.target;
		console.log(commentRef);
		
		//tr > td > form[name=boardCommentFrm]
 <%--   <form action="<%=request.getContextPath()%>/board/boardCommentEnroll" method="post" name="boardCommentFrm">
            <input type="hidden" name="boardNo" value="<%= board.getNo() %>" />
            <input type="hidden" name="memberId" value="<%= loginMember != null ? loginMember.getMemberId() : "" %>" />
            <input type="hidden" name="commentLevel" value="1" />
            <input type="hidden" name="commentRef" value="0" />    
            <textarea name="content" cols="60" rows="3"></textarea>
            <button type="submit" id="btn-comment-enroll1" >등록</button>
        </form> --%>

		const tr = document.createElement("tr");
		const td = document.createElement("td");
		td.colSpan = "2";
		td.style.textAlign = "left";
		
		const form = document.createElement("form");
		form.name = "boardCommentFrm";
		form.action = "<%= request.getContextPath() %>/board/boardCommentEnroll";
		form.method = "POST";
		form.onsubmit = commentSubmitHandler; //동적 생성한 요소는 핸들러도 새로 등록해줘야함
		
		// Servlet에 전달하기 위함 Frm
		const inputBoardNo = document.createElement("input");
		inputBoardNo.type = "hidden";
		inputBoardNo.name = "boardNo";
		inputBoardNo.value = "<%= board.getNo() %>";
		
		const inputMemberId = document.createElement("input");
		inputMemberId.type = "hidden";
		inputMemberId.name = "memberId";
		inputMemberId.value = "<%= loginMember != null ? loginMember.getMemberId() : "" %>";
		
		const inputCommentLevel = document.createElement("input");
		inputCommentLevel.type = "hidden";
		inputCommentLevel.name = "commentLevel";
		inputCommentLevel.value = "2";
		
		const inputCommentRef = document.createElement("input");
		inputCommentRef.type = "hidden";
		inputCommentRef.name = "commentRef";
		inputCommentRef.value = commentRef;
		
		// 실제로 보여지는 Frm
		const textarea = document.createElement("textarea");
		textarea.name = "content";
		textarea.cols = "55";
		textarea.rows = "1";
		
		const button = document.createElement("button");
		button.className = "btn-comment-enroll2";
		button.innerText = "등록";
		
		form.append(inputBoardNo);
		form.append(inputMemberId);
		form.append(inputCommentLevel);
		form.append(inputCommentRef);
		form.append(textarea);
		form.append(button);
		
		td.append(form);
		tr.append(td);
		
		console.log(tr);
		
		// 1. 부모요소 찾기 : tbody
		const parent = e.target.parentElement.parentElement.parentElement; // td - tr - tbody
		//console.log(parent); 
		
		// 2. 기준요소 찾기 : 다음 tr (ref)
		const ref = e.target.parentElement.parentElement.nextElementSibling;
		console.log(ref);
		// 생성된 tr 추가
		parent.insertBefore(tr, ref);
		
		// 이벤트 핸들링은 1회만 허용.
		e.target.onclick = null;
	};
});

document.querySelector("textarea[name=content]").onfocus = (e) => {
	if(<%= loginMember == null %>)
		loginAlert();
};


const commentSubmitHandler = (e) => {
	if(<%= loginMember == null %>){
		loginAlert();
		return false;		
	}
	
	const contentVal = e.target.content.value.trim();
	if(!/^(.|\n)+$/.test(contentVal)){
		alert("댓글 내용을 작성해주세요.");
		e.target.content.focus();
		return false;
	}
};

document.boardCommentFrm.onsubmit = commentSubmitHandler;

const loginAlert = () => {
	alert("로그인 후 이용할 수 있습니다.");
	document.querySelector("#memberId").focus(); <%-- 로그인 폼 안의 아이디에 포커스 --%>
};

</script>
<% if(canEdit){ %>
<form 
	name="boardDelFrm" 
	action="<%= request.getContextPath() %>/board/boardDelete"
	method="POST">
	<input type="hidden" name="no" value="<%= board.getNo() %>" />
</form>
<script>
<%-- 
	POST /board/boardDelete 
	- no 전송해서 게시글 삭제
	- upload/board/file경로에 저장 된 파일 삭제 : java.io.File 기능 사용
--%>
const deleteBoard = () => {
	if(confirm('정말 삭제하시겠습니까?'))
		document.boardDelFrm.submit();
}

const updateBoard = () => {
	location.href = "<%= request.getContextPath() %>/board/boardUpdate?no=<%= board.getNo() %>";
}
</script>
<% } %>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
