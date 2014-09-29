<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Заказ | Ladyka Andrei</title>
</head>
<body>
<h1>Заказ.</h1><br>
<h3>В БД хранится информация о заказах магазина и товарах в них.</h3>
<h4>Для заказа необходимо хранить:</h4>
	<ul>
	<li>номер заказа</li>
	<li>товары в заказе</li>
	<li>дату поступления</li>
	</ul>
	
	<h4>Для товаров в заказе необходимо хранить:</h4>
	<ul>
	<li>товар</li>
	<li>количество</li>
	</ul>
	
	<h4>Для товара необходимо хранить</h4>
	<ul>
	<li>название</li>
	<li>описание</li>
	<li>цену</li>
	</ul>
<ul>
	<li>Вывести полную информацию о заданном заказе.<a href="orders">Список всех заказов</a></li>
	<li><form method="get" action="task2">Вывести номера заказов, сумма которых не превосходит заданную <input type="text" name="price" size="10">, и количество различных товаров равно заданному <input type="text"  name="shipments" size="10">.<input type="submit" value="Отправить"></form></li>
	<li><form method="get" action="task3">Вывести номера заказов, содержащих заданный товар.<input type="text"  name="shipmentid" size="10"><input type="submit" value="Отправить"></form></li>
	<li><form method="get" action="task4">Вывести номера заказов, не содержащих заданный товар и поступивших в течение текущего дня.<input type="text"  name="shipmentid" size="10"><input type="submit" value="Отправить"></form></li>
	<li><form method="get" action="task5">Сформировать новый заказ, состоящий из товаров, заказанных в текущий день.<input type="submit" value="Отправить"></form></li>
	<li><form method="get" action="task6">Удалить все заказы, в которых присутствует заданное количество<input type="text"  name="count" size="10"> заданного товара.<input type="text"  name="shipmentid" size="10"><input type="submit" value="Отправить"></form></li>
</ul>
</body>
</html>