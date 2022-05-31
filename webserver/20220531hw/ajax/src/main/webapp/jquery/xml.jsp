<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery - xml</title>
<script src="<%= request.getContextPath() %>/js/jquery-3.6.0.js"></script>
<style>
table {border : 1px solid #000; border-collapse: collapse; margin: 10px 0;}
th, td {border : 1px solid #000; text-align: center; padding: 3px; }
table img {width: 100px;}
</style>
</head>
<body>
	<h1>xml</h1>
	<button id="btn1">sample</button>
	<div id="result-sample">
		<table id="tbl-books">
			<thead>
				<tr>
					<th>분류</th>
					<th>제목</th>
					<th>저자</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
	<script>
	btn1.addEventListener('click', () => {
		$.ajax({
			url : "<%= request.getContextPath() %>/jquery/sample.xml",
			method : "GET",
			dataType : "xml",
			success(doc){ //doc = resp
				// 응답받은 xml을 jquery가 parsing처리 후 DOM으로 전달.
				console.log(doc);	//#document 형식의 객체로 데이터가 넘어옴.
				console.dir(doc);
				
				const root = doc.querySelector(":root"); //넘어온 xml doc에서 찾은거임
				//console.log(root);
				//사용자 정의 속성 가져오기 : root.attributes(NamedNodeMap타입)
				console.log(root.myattr); //undefined
				console.log(root.attributes.myattr); //myattr="hello"
				console.log(root.getAttribute("myattr")); //hello

				const tbody = document.querySelector("#tbl-books tbody");
				tbody.innerHTML = "";
				// books는 진짜배열이 아니라서 forEach안됨 -> 배열로 변경
				const books = [...root.children]; // Array.from(유사배열)
				console.log(books);
				
				books.forEach((book) => {
					const [subject, title, author] = book.children; //book 아래 자식들 : 배열 구조분해 할당
					// console.log(subject, title, author);
					// CDATA -> textContent
					tbody.innerHTML += `<tr>
						<td>\${subject.innerHTML}</td>
						<td>\${title.textContent}</td> 
						<td>\${author.innerHTML}</td>
					</tr>`;
					
				});
			},
			error : console.log
		});
	});
	</script>
	
	<button id="btn2">celeb</button>
	<table id="tbl-celeb">
		<thead>
			<tr>
				<th>No</th>
				<th>이름</th>
				<th>타입</th> <!-- select tag -->
				<th>프로필</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	<script>
	btn2.addEventListener('click', () => {
		$.ajax({
			url : "<%= request.getContextPath() %>/jquery/xml",
			// dataType : "xml", method : "GET" 응답데이터를 보고 자동으로 지정 -> 생략처리
			success(doc){
				//console.log(doc); //xml file doc
				const root = doc.querySelector(":root");
				console.log(`총 \${root.getAttribute("len")}개의 데이터가 조회되었습니다.`);
				const celebs = [...root.children];
				document.querySelector("#tbl-celeb tbody").innerHTML = 
					celebs.reduce((html, celeb) => {
						const [name, type, profile] = celeb.children; //iterator를 구현
						console.log(celeb.children);
					
						const tr = `<tr>
							<td>\${celeb.getAttribute("no")}</td>
							<td>\${name.textContent}</td>
							<td>\${type.textContent}</td>
							<td>
								<img src="<%= request.getContextPath() %>/images/\${profile.innerHTML}" alt="" />
							</td>
						</tr>`;
						return html + tr;
					}, "");
				
				<%-- const tbody = document.querySelector("#tbl-celeb tbody");
				tbody.innerHTML = "";
				celebs.forEach((celeb) => {
					const[name, type, profile] = celeb.children;
					tbody.innerHTML += `<tr>
						<td>\${celeb.getAttribute("no")}</td>
						<td>\${name.innerHTML}</td>
						<td>\${type.innerHTML}</td>
						<td><img src="<%= request.getContextPath() %>/images/\${profile.innerHTML}" alt="" /></td>
					</tr>`;
				}); --%>
			},
			error : console.log
		});
	});
	</script>
	
	<hr />
	<h2>일일 박스오피스 조회</h2>
	<div><input type="date" name="targetDt" id="targetDt" /></div>
	<table id="tbl-daily-boxoffice">
		<thead>
			<tr>
				<th>순위</th>
				<th>영화제목</th>
				<th>누적관객수</th> <!-- audiAcc -->
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	<script>
	/**
	 * @실습문제 - 페이지 로딩이 완료되면 어제 날짜로 박스오피스 조회를 자동으로 처리
	 */
	window.onload = () => {
	<% 
		LocalDate today = LocalDate.now();
		LocalDate yesterday = today.minusDays(1);
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");        
   		String targetDt = yesterday.format(formatter);
	%>
		document.querySelector("#targetDt").value = '<%= targetDt %>';
		dailyBoxoffice();
	}
	
	const dailyBoxoffice = (e) => {
		const val = document.querySelector("#targetDt").value.replaceAll("-", "");
		//console.log(val);
		
		$.ajax({
			url : "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml",
			data : {
				key : '4c7da9c13daf07fcee9ece7979fcc4a2',
				targetDt : `\${val}`
			},
			success(doc){
				const root = doc.querySelector(":root");
				const movies = [...root.lastChild.children];
				const tbody = document.querySelector("#tbl-daily-boxoffice tbody")
				tbody.innerHTML = "";
				
				movies.forEach((movie) => {
					const rank = movie.getElementsByTagName("rank")[0];
					const movieNm = movie.getElementsByTagName("movieNm")[0];
					const audiAcc = movie.getElementsByTagName("audiAcc")[0];
					
					tbody.innerHTML += `
					<tr>
						<td>\${rank.textContent}</td>
						<td>\${movieNm.textContent}</td>
						<td>\${audiAcc.textContent}</td>
					</tr>`;
					
				});
			},
			error : console.log
		});
	}
	
	targetDt.addEventListener('change', () => {
		dailyBoxoffice();
	});
	</script>
</body>
</html>