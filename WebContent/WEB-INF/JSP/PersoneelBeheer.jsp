<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Mijn Personeel</h1>
<Button>Voeg Personeelslid toe</Button>
<table>
	<tr>
		<th>Voornaam</th>
		<th>familienaam</th>
		<th>takenlijst</th>
		<th></th>
	</tr>
	<c:forEach items="${PersoneelList}" var="pers">
		<tr>
			<td>${pers.voornaam}</td>
			<td>${pers.familienaam}</td>
			<td><a href="PersoneelTakenlijst?id=${pers.id}">Bekijk takenlijst</a></td>
			<td><a href="RersoneelDetail?id=${pers.id}">Wijzigen</a></td>
		</tr>

	</c:forEach>
</table>