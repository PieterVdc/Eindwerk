<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Mijn Taken</h1>
<div>
	<h2>Nieuw Taak/Wijzig Taak</h2>
	<form action="" method="POST">
		<input name="id" type="hidden" value="${editId}">
		
		<br />
		<label for=naam>Naam: </label>
		<input name="naam" value="${editTaak.naam}">
		<br />
		<label for="materials">Materialen: </label>
		<select name = "materials" multiple="multiple">
			<c:forEach items="${matList}" var="mat">
  			<option value="${mat.id}" 
				<c:forEach var="item" items="${editTaak.materialList}">
  					<c:if test="${item eq mat.id}">
   	 					selected="selected"
  					</c:if>
				</c:forEach>
  			>${mat.naam}</option>
  			</c:forEach>
		</select> 
		<input type="submit" value="Opslaan">
	</form>
</div>

<table>
	<tr>
		<th>naam</th>
		<th>Materialen</th>
		<th></th>
	</tr>
	<c:forEach items="${taakList}" var="taak">
		<tr>
			<td>${taak.naam}</td>
			<td>${taak.materiaalString}</td>
			<td><a href="taakbeheer?edit=${taak.id}">Wijzigen</a> <a href="taakbeheer?delete=${taak.id}">Verwijderen</a></td>
		</tr>

	</c:forEach>

</table>