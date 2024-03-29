<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		border-collapse: collapse;
		margin-top: 30px;
		margin-right:30px;
	}
	
	td, th {
		padding: 10px;
		font-size: 1.3em;
		border: 1px solid black;
		text-align: center;
	}
	nav ul{
		widows: 1200px;
		display: flex;
		flex-flow: row nowrap;
		justify-content: space-around;
		list-style-type: none;
	}
	nav a:visited, nav a:link {
 		text-decoration: none;
 		color : black;
 		font-size: 24px;
 		display: inline-block;
 		padding:10px 0px;
	}
	nav a:hover{
		border-bottom: 2px solid black ;
		font-weight: bold;
	}
	.container{
		width: 1200px;
		display: flex;
		flex-flow: row nowrap;
		margin:0 auto;
		justify-content: center;
	}
	.frm_major{
		width: 300px;
		display: flex;
		flex-flow: column nowrap;
		margin-top:30px;
	}
	.frm_major > * {
		height: 70px;
		font-size: 20px;
	}
	tbody input {
		font-size : 20px;
		border : none;
		outline: none;
		text-align: center;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	function btnUpdateClick(){
		//console.log($(this).parent().parent().find('input'));
		let d = {};
		$(this).parent().parent().find('input').each((idx, item)=>{
			d[$(item).attr('name')] = $(item).val();
		});
		console.log(d);
		$.ajax({
			url : '/major/update/'+d.majorNo,
			data : JSON.stringify(d),
			type:'put',
			contentType:'application/json; charset=utf-8',
			dataType : 'json',
			success : function(r){
				const tag = r.list.reduce((acc,cur,idx) => {
					return acc + `<tr><td><input type='text' name='majorNo' value='\${cur.majorNo }'></td><td><input type='text' name='majorName' value='\${cur.majorName }'></td><td><button class='btn_update'>수정</button> <button class='btn_delete'>삭제</button></td></tr>`;
				},'');
				console.log(tag);
				$('.container > table > tbody').html(tag);
				$('.btn_update').click(btnUpdateClick);
				$('.btn_delete').click(btnDeleteClick);
			}
		});
	}
	function btnDeleteClick(){
		let d = {
				majorNo : $(this).parent().parent().find('input').first().val()
		};
		console.log(d);
		$.ajax({
			url : '/major/delete/'+d.majorNo,
			data : JSON.stringify(d),
			type:'delete',
			dataType : 'json',
			success : function(r){
				const tag = r.list.reduce((acc,cur,idx) => {
					return acc + `<tr><td><input type='text' name='majorNo' value='\${cur.majorNo }'></td><td><input type='text' name='majorName' value='\${cur.majorName }'></td><td><button class='btn_update'>수정</button> <button class='btn_delete'>삭제</button></td></tr>`;
				},'');
				console.log(tag);
				$('.container > table > tbody').html(tag);
				$('.btn_update').click(btnUpdateClick);
				$('.btn_delete').click(btnDeleteClick);
			}
		});
	}
	$(function(){
		$(".btn_major").click(function() {
			let d = {
					majorNo : $('#txt_major_no').val(),
					majorName : $('#txt_major_name').val()
			};
			console.log(d);
			$.ajax({
				url : '/major/insert',
				data : d,
				type : 'post',
				dataType : 'json',
				success : function(r){
					console.log(r);
					//받아온 데이터를 tbody에 새로 태그를 만들어서 변경
					const tag = r.list.reduce((acc,cur,idx) => {
						return acc + `<tr><td><input type='text' name='majorNo' value='\${cur.majorNo }'></td><td><input type='text' name='majorName' value='\${cur.majorName }'></td><td><button class='btn_update'>수정</button><button class='btn_delete'>삭제</button></td></tr>`;
					},'');
					console.log(tag);
					$('.container > table > tbody').html(tag);
					$('.btn_update').click(btnUpdateClick);
					$('.btn_delete').click(btnDeleteClick);
				}
			});
		});
		$('.btn_update').click(btnUpdateClick);
		$('.btn_delete').click(btnDeleteClick);
	});

</script>
</head>
<body>
	<nav>
 		<ul>
 			<li><a href="/main">홈</a></li>
 			<li><a href="/student/insert/view">학생정보 등록</a></li>
 			<li><a href="/major">학과 관리</a></li>
 			<li><a href="scholarshipMain.do">장학생 관리</a></li>
 			<li><a href="/login">로그아웃</a></li>
 		</ul>
 	</nav>
 	<div class="container">
	<table>
		<thead>
			<tr>
				<th>학과번호</th>
				<th>학과명</th>
				<th>작업</th>
			</tr>
		</thead>			
		<tbody>
			<c:forEach var="major" items="${requestScope.majorList }">
				<tr>
					<td><input type='text' name='majorNo' value='${major.majorNo }' readonly></td>
					<td><input type='text' name='majorName' value='${major.majorName }'></td>
					<td>
						<button class='btn_update'>수정</button>
						<button class='btn_delete'>삭제</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="frm_major">
		<input type="text" id="txt_major_no" placeholder="학과번호 입력">
		<input type="text" id="txt_major_name" placeholder="학과명 입력">
		<button type="button" class="btn_major">등록</button>
	</div>
 	</div>
</body>
</html>










