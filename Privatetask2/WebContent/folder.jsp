<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Список содержимого каталога</title>
</head>
<body>
	<table>
		<c:forEach var="file" items="${files}">
			<tr>
				<td> <a href="main?path=<c:out value="${file.filePath}" />"><c:out value="${file.fileName}" /> </a>				
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>