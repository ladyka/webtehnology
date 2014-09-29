<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
    <title>Task4</title>
</head>
<body>
    <form name="task4" method="get" action="task4">
        <p> <!-- Это твоя херня переделанная мною, чтоб параметры, джсп не обязательно! -->
            <b>Type:</b><br>
            <input type="radio" name="browser" value="cube" checked="checked"> cube
            <br />
            <input type="text" name="cube_l" size="10">
            <br />
            <input type="radio" name="browser" value="parallelepiped"> parallelepiped
            <br />
            <input type="text" name="p_l" size="10">
            <br />
            <input type="text" name="p_w" size="10">
            <br />
            <input type="text" name="p_h" size="10">
            <br />
            <input type="radio" name="browser" value="sphere"> sphere
            <br />
            <input type="text" name="s_R" size="10">
            <br />
            <input type="radio" name="browser" value="torus"> torus
            <br />
            <input type="text" name="t_R1" size="10">
            <br />
            <input type="text" name="t_R2" size="10">
            <br />
            <input type="radio" name="browser" value="tetrahedron"> tetrahedron
            <br />
            <input type="text" name="a" size="10">
            <br />
            <input type="text" name="b" size="10">
            <br />
            <input type="text" name="c" size="10">
            <br />
            <input type="text" name="h" size="10">
            <br />
        </p>
        <p>
            Accuracy:
            <br />
            <input type="text" name="accuracy" size="10">
            <br />
        </p>
        <p>
            <input type="submit" value="Submit">
        </p>
    </form>
</body>
</html>