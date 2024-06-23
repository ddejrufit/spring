<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="jQuery.js"></script>
<script type="text/javascript" src="test.js"></script>
</head>
<body>
	<table border="1">
		<tr>
			<td>id : <input>
			</td>
		</tr>
		<tr>
			<td>pw : <input type="password"></td>
		</tr>
		<tr>
			<td>pwChk : <input type="password">
			</td>
		</tr>
		<tr>
			<td>name : <input>
			</td>
		</tr>
		<tr>
			<td>addr: <input id="addr1" readonly="readonly"> <br>
				<input id="addr2" readonly="readonly"><br> <input>
			</td>
		</tr>
		<tr>
			<td><button>가입</button></td>
		</tr>
	</table>
</body>
</html>