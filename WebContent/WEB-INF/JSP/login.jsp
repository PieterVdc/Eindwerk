<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	login
	<form action="" method="POST">
		gebruiker: <input type="text" name="user"> <br /> wachtwoord:
		<input type="text" name="pw" /><br />
		<c:if test="${invalid}">
			onbestaande user/pw combo<br />
		</c:if>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>