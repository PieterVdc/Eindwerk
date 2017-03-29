<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title}</title>
<LINK href="CSS/style.css" rel="stylesheet" type="text/css">
<script src="JS/script.js"></script>
</head>
<body>
	<div>
		<nav>
			<ul>
				<li><a href="login">Afmelden</a></li>
				<li><a href="opdrachtbeheer">Opdrachten</a></li>
				<li><a href="taakbeheer">Taken</a></li>
				<li><a href="klantbeheer">Klanten</a></li>
				<li><a href="facturatiebeheer">Facturatie</a></li>
				<li><a href="materiaalbeheer">Materialen</a></li>
				<li><a href="personeelbeheer">Personeel</a></li>
				<li><a href="bedrijfsgegevens">Bedrijfsgegevens</a></li>
			</ul>
		</nav>
		<div class="content">
			<jsp:include page="${pagename}.jsp"></jsp:include>

		</div>
	</div>
</body>
</html>