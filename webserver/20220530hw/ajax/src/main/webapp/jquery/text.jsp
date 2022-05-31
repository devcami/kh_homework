<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery - text</title>
<script src="<%= request.getContextPath() %>/js/jquery-3.6.0.js"></script>
<style>
table {border : 1px solid #000; border-collapse: collapse; margin: 10px 0;}
th, td {border : 1px solid #000; text-align: center; padding: 3px; }
table img {width: 100px;}
</style>
</head>
<body>
	<h1>text</h1>
	<button id="btn1">text</button>
	<script>
	btn1.addEventListener('click', (e) => {
		$.ajax({
			url : "<%= request.getContextPath() %>/jquery/text", <%-- 요청보낼 url --%>
			method : "GET", <%-- 전송방식(GET : default 생략가능) | POST | PUT | PATCH ... --%>
			data : { <%-- 사용자 입력값 직렬화 처리 후 서버에 전달할 값 - GET : url에 추가 , POST : body부분에 추가 --%>
				q : "abcde",
				mode : 123,
				isFinal : true
			},
			dataType : "text", <%-- 응답한 데이터 타입 지정 text | html | script | json | xml --%>
			beforeSend(){
				<%-- 요청 전 호출메소드 --%>
				console.log("beforeSend");
			},
			success(responseText){
				<%-- 성공 시 실행되는 메소드 : xhr.responseText 를 후 처리하고 success 메소드에 전달 --%>
				// readyState == 4 && status == 200
				console.log("success : ", responseText); 
			},
			error(xhr, textStatus, error){
				<%-- 실패 시 실행되는 메소드 --%>
				 // readyState == 4 && status != 200
				console.log("error : ", xhr, textStatus, error); //xhr : jqxhr 확장된 xhr객체임
			},
			complete(){
				<%-- 응답후 (성공이든 실패든) 반드시 실행되는 메소드 --%>
				console.log("complete");
			}
		});
	});
	</script>
	
	<button id="btn2">csv</button>
	<table id="tbl-celeb">
		<thead>
			<tr>
				<th>No</th>
				<th>이름</th>
				<th>타입</th> <!-- select tag -->
				<th>프로필</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<script>
	/**
	 * csv comma separated value
	 * 
	 */
	btn2.addEventListener('click', (e) => {
		$.ajax({
			url : "<%= request.getContextPath() %>/jquery/csv",
			method : "GET",
			dataType : "text", 
			success(response){
				console.log(response);
				const celebStrs = response.split("\n");
				const tbody = document.querySelector("#tbl-celeb tbody");
				tbody.innerHTML = "";
				celebStrs.forEach((celebStr) => {
					if(celebStr === '') return; // 마지막 '' 
					const celeb = celebStr.split(",");
					// console.log(celeb);
					const tr = document.createElement("tr");
					const tdNo = document.createElement("td");
					tdNo.append(celeb[0]);
					const tdName = document.createElement("td");
					tdName.append(celeb[1]);
					const tdType = document.createElement("td");
					const select = document.createElement("select");
					// ACTOR, SINGER, MODEL, COMEDIAN, ENTERTAINER;
					const option1 = document.createElement("option")
					option1.value = "ACTOR";
					option1.innerHTML = "ACTOR";
					const option2 = document.createElement("option")
					option2.value = "SINGER";
					option2.innerHTML = "SINGER";
					const option3 = document.createElement("option")
					option3.value = "MODEL";
					option3.innerHTML = "MODEL";
					const option4 = document.createElement("option")
					option4.value = "COMEDIAN";
					option4.innerHTML = "COMEDIAN";
					const option5 = document.createElement("option")
					option5.value = "ENTERTAINER";
					option5.innerHTML = "ENTERTAINER";
					select.append(option1, option2, option3, option4, option5);
					select.value = celeb[2];
					// select.disabled = "disabled";
					tdType.append(select);
					const tdProfile = document.createElement("td");
					const img = document.createElement("img");
					img.src = `<%= request.getContextPath() %>/images/\${celeb[3]}`
					tdProfile.append(img);
					tr.append(tdNo, tdName, tdType, tdProfile);
					tbody.append(tr);
				});
			},
			error(xhr, textStatus, err){
				console.log("error : ", xhr, textStatus, err);
			}
			
		});
	});
	</script>
</body>
</html>