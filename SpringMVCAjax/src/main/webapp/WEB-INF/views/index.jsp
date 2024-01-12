<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('button').click(function() {
			$.ajax({
				url : "/callData",
				data : "data="+$(this).attr("class"),
				type : "post",
				dataType: "json",
				success:function(r){
					$('#result').html(r.result);
				},
				error:function(xhr,status,error){
					console.log(xhr.status);
					console.log(xhr.responseJSON);
					$('#result').html(xhr.responseJSON.error+" "+xhr.responseJSON.result);
				}
			});
		});

	});
</script>
</head>
<body>
	<button type="button" class="true">정상 데이터 호출</button>
	<button type="button" class="false">Exception 호출</button>
	<hr>
	<div id="result"></div>
</body>
</html>