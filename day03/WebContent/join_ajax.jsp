<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<form action="joinOk.jsp" name="joinForm" method="post">
		<label>
			아이디 <input type="text" name="userId" placeholder="5자 이상으로 작성해주세요.">
			<input type="button" value="중복검사" onclick="send()">
		</label>
		<p id="result">
		</p>
		패스워드 <input type="text" name="userPw" placeholder="5자 이상으로 작성해주세요.">
		<br>
		이름 <input type="text" name="userName" placeholder="*필수작성">
		<br>
		나이 <input type="text" name="userAge" placeholder="*필수작성">
		<br>
		전화번호 <input type="text" name="userPhone" placeholder="010-0000-0000">
		<br>
		생일 <input type="text" name="userBirth" placeholder="ex)1999-00-00">
		<br>
		<input type="submit" value="완료">
	</form>
	<form action="login.jsp">
		<button>로그인</button>
	</form>
</body>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
	let check = true;

	$("input[name='userId']").on("focus", function(){
		check = true;
	});
	
	$("input[type='submit']").on("click", function(e){
		e.preventDefault();

		if(check){
			alert("아이디 중복검사를 진행해주세요.");
			return;
		}

		joinForm.submit();
	});

	function send(){
		var $value = $("input[name='userId']").val();
		
		if(!$value || $value.length < 5){
			alert("아이디를 확인해주세요.");
			return;
		}
		
		$.ajax({
			url: "checkId_ajax.jsp",
			type: "get",
			data: "userId=" + $value,
			contentType: "application/x-www-form-urlencoded",
			dataType: "text",
			success: function(result){
				result = result.trim();
				if(JSON.parse(result)){
					$("p#result").text("중복된 아이디입니다.");
					check = true;
				}else{
					$("p#result").text("사용가능한 아이디입니다.");
					check = false;
				}
			},
			error: function(xhr, status, error){
				console.log(error);
			}
		});
		
	}
</script>
</html>













