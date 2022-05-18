<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%
	List<Member> list = (List<Member>) request.getAttribute("list");
%>
<!-- 관리자용 admin.css link -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin.css" />
<style>
div#search-container {width:100%; margin:0 0 10px 0; padding:3px; background-color: rgba(0, 188, 212, 0.3);}
div#search-memberId {display: inline-block;}
div#search-memberName{display:none;}
div#search-gender{display:none;}
</style>
<section id="memberList-container">
	<h2>회원관리</h2>
	    <div id="search-container">
	        <label for="searchType">검색타입 :</label> 
	        <select id="searchType">
	            <option value="member_id">아이디</option>        
	            <option value="member_name">회원명</option>
	            <option value="gender">성별</option>
	        </select>
	        <div id="search-memberId" class="search-type">
	            <form action="<%=request.getContextPath()%>/admin/memberFinder">
	                <input type="hidden" name="searchType" value="member_id"/>
	                <input type="text" name="searchKeyword"  size="25" placeholder="검색할 아이디를 입력하세요."/>
	                <button type="submit">검색</button>            
	            </form>    
	        </div>
	        <div id="search-memberName" class="search-type">
	            <form action="<%=request.getContextPath()%>/admin/memberFinder">
	                <input type="hidden" name="searchType" value="member_name"/>
	                <input type="text" name="searchKeyword" size="25" placeholder="검색할 이름을 입력하세요."/>
	                <button type="submit">검색</button>            
	            </form>    
	        </div>
	        <div id="search-gender" class="search-type">
	            <form action="<%=request.getContextPath()%>/admin/memberFinder">
	                <input type="hidden" name="searchType" value="gender"/>
	                <input type="radio" name="searchKeyword" value="M" checked> 남
	                <input type="radio" name="searchKeyword" value="F"> 여
	                <button type="submit">검색</button>
	            </form>
	        </div>
  		  </div>
	<table id="tbl-member">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>회원권한</th>
				<th>성별</th>
				<th>생년월일</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>취미</th>
				<th>가입일</th>
			</tr>
		</thead>
		<tbody>
		<% if(list != null && !list.isEmpty()){
				for(Member member : list) { %>	
				<tr>
					<td><%= member.getMemberId() %></td>
					<td><%= member.getMemberName() %></td>
					<td>
						<select class="member-role" data-member-id="<%= member.getMemberId() %>">
							<option value="<%= MemberRole.A %>" <%= member.getMemberRole() == MemberRole.A ? "selected" : "" %>>관리자</option>
							<option value="<%= MemberRole.U %>" <%= member.getMemberRole() == MemberRole.U ? "selected" : "" %>>일반회원</option>
						</select>
					</td>
					<td><%= member.getGender() != null? member.getGender() : "" %></td>
					<td><%= member.getBirthday() != null? member.getBirthday() : "" %></td>
					<td><%= member.getEmail() != null? member.getEmail() : "" %></td>
					<td><%= member.getPhone() %></td>
					<td><%= member.getAddress() != null ? member.getAddress() : "" %></td>
					<td><%= member.getHobby() != null? member.getHobby() : "" %></td>
					<td><%= member.getEnrollDate() %></td>
				</tr>
			<% } %>
		<%} else { %>
			<tr>
				<td colspan="10">조회된 회원이 없습니다.</td>
			</tr>
		<% } %>
		
		</tbody>
	</table>
</section>
<form 
	action="<%= request.getContextPath() %>/admin/memberRoleUpdate" 
	name="updateMemberRoleFrm"
	method="POST">
	<input type="hidden" name="memberId" />
	<input type="hidden" name="memberRole" />
</form>

<script>
window.onload = () => {
	const uri = new URL(window.location.href);
	//console.log(typeof uri.searchParams.get('searchType'), uri.searchParams.get('searchType'));
	const searchType = uri.searchParams.get('searchType');
	const searchKeyword = uri.searchParams.get('searchKeyword');
	const selectTag = document.getElementById('searchType');

	if(searchType != null && searchType != ""){
		document.querySelectorAll(".search-type").forEach((div) => {
			div.style.display = "none";
		});
		let id = "";
		if(searchType == "member_id"){
		 	selectTag.value = "member_id";
		 	id = "search-memberId";
		} else if(searchType == "member_name"){
		 	selectTag.value = "member_name";
		 	id = "search-memberName";
		} else {
			selectTag.value = "gender";		
			id = "search-gender";
		}
		const div = document.querySelector(`#\${id}`);
		div.style.display = "inline-block";
		if(searchType == "gender"){
			if(searchKeyword == "F"){
				document.querySelector('[value=F]').checked = true;
			}else{
				document.querySelector('[value=M]').checked = true;
			}
		}else{
			div.firstElementChild.firstElementChild.nextElementSibling.value = searchKeyword;
		}
	}
};

searchType.addEventListener('change', (e) => {
	const {value} = e.target; //구조분해할당	
	console.log(value);
	document.querySelectorAll(".search-type").forEach((div) => {
		div.style.display = "none";
	});
	let id = "";
	switch(value){
		case "member_id" : id = "search-memberId"; break;
		case "member_name" : id = "search-memberName"; break;
		case "gender" : id = "search-gender"; break;
	}
	document.querySelector(`#\${id}`).style.display = "inline-block";
});

document.querySelectorAll(".member-role").forEach((select) => {
	select.addEventListener('change', (e) => {
		//console.dir(e.target); 
		//console.log(e.target.dataset.memberId); 
		//console.log(e.target.value); // "U "A"
		
		const memberId = e.target.dataset.memberId;
		const memberRole = e.target.value;
		
		// Template String : ES6 vs jsp EL : 두 문법이 겹친다
		// -> jsp에서 Template String 문법 사용 시 반드시 escaping처리 할 것.
		// ` \${} `
		if(confirm(`[\${memberId}]의 권한을 [\${memberRole}]로 변경하시겠습니까?`)){
			const frm = document.updateMemberRoleFrm;
			frm.memberId.value = memberId;
			frm.memberRole.value = memberRole;
			frm.submit();
		}
		else{
			//select 태그 하위에 selected속성을 가진 태그를 찾아 selected를 true..
			//권한 변경 취소를 누를 경우 바꾸지않은 원래 권한으로 보여지도록.
			e.target.querySelector("[selected]").selected = true;
		}
	});
});
</script>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
