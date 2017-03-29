<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Mijn Taken</h1>
<div>
	<h2>Nieuw Materiaal/Wijzig Materiaal</h2>
	<form action="" method="POST">
		<input name="id" type="hidden" value="${matId}">
		<label for="Soort">Soort: </label>
		<select name = "soort">
			<c:forEach items="${soortList}" var="soort">
  			<option value="${soort.id}">${soort.naam}</option>
  			</c:forEach>
		</select> 
		<br />
		<label for=naam>Naam: </label>
		<input name="naam" value="${editMat.naam}">
		<br />
		<label for=eenheidsmaat>Eenheidsmaat: </label>
		<input name="eenheidsmaat" value="${editMat.eenheid}">
		<br />
		<label for=eenheidsprijs>Eenheidsprijs: </label>
		<input name="eenheidsprijs" type="number" value="${editMat.eenheidsprijs}">
		<br />
		<input type="submit" value="Opslaan">
	</form>
</div>

<table>
	<tr>
		<th>Soort</th>
		<th>Naam</th>
		<th>eenheid</th>
		<th>Eenheidsprijs</th>
		<th></th>
	</tr>
	<c:forEach items="${matList}" var="mat">
		<tr>
			<td>${mat.materiaalCategorie.naam}</td>
			<td>${mat.naam}</td>
			<td>${mat.eenheid}</td>
 			<td>${mat.eenheidsprijs}</td>
			<td><a href="materiaalbeheer?edit=${mat.id}">Wijzigen</a> <a href="materiaalbeheer?delete=${mat.id}">Verwijderen</a></td>
		</tr>

	</c:forEach>

</table>