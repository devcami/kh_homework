<%@page import="java.util.List"%>
<%@page import="board.model.dto.BoardExt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<% 
	String pagebar = (String) request.getAttribute("pagebar");
	List<BoardExt> list = (List<BoardExt>) request.getAttribute("list");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/board.css" />
<section id="board-container">
	<h2>게시판 </h2>
	<table id="tbl-board">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>첨부파일</th><%--첨부파일이 있는 경우 /images/file.png 표시 width:16px --%>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
		<% if(list != null && !list.isEmpty()) {
				for(BoardExt board :list) {%>
				<tr>
					<td><%= board.getNo() %></td>
					<td><%= board.getTitle() %></td>
					<td><%= board.getMemberId() %></td>
					<td><%= board.getRegDate() %></td>
					<td><% if(board.getAttachCount() > 0) { %> 
							<img src="<%= request.getContextPath() %>/images/file.png">
						<%} else {  }%>
					</td>
					<td><%= board.getReadCount() %></td>
				</tr>
		<% } 
		} else { %>
			<tr>
				<td colspan="6">조회된 게시글이 없습니다.</td>
			</tr>
		<% } %>
<%-- 			<tr>
				<td>1</td>
				<td>봄이 왔습니다.</td>
				<td>honggd</td>
				<td>2022-05-23</td>
				<td></td>
				<td>10</td>
			</tr>
			<tr>
				<td>2</td>
				<td>봄이 갔습니다.</td>
				<td>honggd</td>
				<td>2022-06-23</td>
				<td>
					<img src="<%= request.getContextPath() %>/images/file.png" alt="">
				</td>
				<td>13</td>
			</tr> --%>
		</tbody>
	</table>

	<div id='pageBar'>
		<%= pagebar %>
	</div>
</section>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
