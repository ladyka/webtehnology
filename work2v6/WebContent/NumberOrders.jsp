<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Номера аказов</title>
</head>
<body>
	<table>
		<tr>
			<td>Номер заказа</td>
		</tr>
		<c:set var="id" value="0" scope="page" />
		<c:forEach var="orderNum" items="${numbers}">
			<tr>
				<td> <a href="task1?id=<c:out value="${orderNum}" />"><c:out value="${orderNum}" /> </a>				
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>