<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>관리자 로그인 페이지</title>
	
<script>
 $(document).ready(function(){
	$("#btnLogin").click(function(){
		var userId = $("#userId").val();
		var userPw = $("#userPw").val();
		
		if(userId == ""){
			alert("아이디를 입력하세요.");
			$("#userId").focus();
			return;
		}
		else(userPw == ""){
			alert("패스워드를 입력하세요.");
			$("#userPw").focus();
			return;
		}
		//폼 내부의 데이터를 전송할 주소
		document.LoginPage.action="${path}/admin/loginCheck.do"
		
		//제출
		document.LoginPage.submit();
	}); 
 });
</script>
</head>
<body>
<h1>관리자 로그인 페이지</h1>

<form name="LoginPage" method="post" >
	<p><input type="text" name="userId" id="userId" placeholder="아이디"></p>
	<p><input type="password" name="userPw" id="userPw" placeholder="비밀번호"></p>
	<p><input type="checkbox" name="useCookie">로그인 유지</p>
	<p><button type="button" id="btnLogin">로그인</button></p>
	<c:if test="${msg == 'failure'}">
		<div style="color:red">
			아이디 또는 비밀번호가 일치하지 않습니다.
		</div>
	</c:if>
	<c:if test="${msg == 'logout'}">
		<div style="color: red">
			로그아웃되었습니다.
		</div>
	</c:if>
</form>

</body>
</html>
