<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="student.reg">
	이름:<input name="s_name" placeholder="이름"><p>
	별명:<input name="s_nickname" placeholder="별명"><p>
	<button>등록</button>
	</form>
	<hr>
	<c:forEach var="s" items="${students }">
	<h2>${s.s_name } - ${s.s_nickname }</h2>
	</c:forEach>
	<hr>
	<form action="test.reg">
	과목명: <input name="t_title">
	<select name="t_y">
	<c:forEach var="y" begin="2023" end="2024">
		<option>${y }</option>	
	 </c:forEach>
	</select>년
	<select name="t_m">
	<c:forEach var="m" begin="1" end="12">
		<option>${m }</option>	
	 </c:forEach>
	</select>월
	<select name="t_d">
	<c:forEach var="d" begin="1" end="31">
		<option>${d }</option>	
	 </c:forEach>
	</select><p>
	
	<button>입력</button>
	</form>
	<hr>
	<c:forEach var="t" items="${tests }">
	<h2>${t.t_tilte } - <fmt:formatDate value="${t.t_when }" type="date" dateStyle="long"/> </h2>
	</c:forEach>
	<hr><h1>${r }</h1>
</body>
</html>