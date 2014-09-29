<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Заказы</title>
</head>
<body>
	<table>
		<tr>
			<td>Номер заказа</td>
			<td>Время заказа</td>
			<td>Имя товаря</td>
			<td>Описание товара</td>
			<td>Цена товара</td>
			<td>Колличество заказанного товара</td>
		</tr>
		<c:set var="id" value="0" scope="page" />
		<c:forEach var="shipmentOrderView" items="${orderViews}">
			<tr>
				<td> <a href="task1?id=<c:out value="${shipmentOrderView.shipmentOrderId}" />"><c:out value="${shipmentOrderView.shipmentOrderId}" /> </a>
				
				</td>
				<td><c:out value="${shipmentOrderView.timestamp}" /></td>
				<td><c:out value="${shipmentOrderView.shipmentName}" /></td>
				<td><c:out value="${shipmentOrderView.shipmentDescription}" /></td>
				<td><c:out value="${shipmentOrderView.shipmentPrice}" /></td>
				<td><c:out value="${shipmentOrderView.count}" /></td>
			</tr>
			<c:set var="id" value="${shipmentOrderView.shipmentOrderId}" scope="page" />
		</c:forEach>
	</table>
	<div align="right">Всего : <c:out value="${priceTotal}"></c:out>.</div>
</body>
</html>