<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������ ������ Mainȭ��</title>
</head>
<body>
	<c:if test="${msg == 'success'}">
	<h2>${sessionScope.userName} ${sessionScope.userId}�� ȯ���մϴ�.</h2>
	</c:if>
</body>
</html>