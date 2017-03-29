<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Mijn Klanten</h1>
<button type="button">Voeg particulier toe</button>
<button type="button">voeg bedrijf toe</button>



<div class="tab">
	<a href="javascript:void(0)" class="tablinks"
		onclick="openTab(event, 'Particulier')">Particulier</a> <a
		href="javascript:void(0)" class="tablinks"
		onclick="openTab(event, 'Bedrijf')">Bedrijf</a>
</div>

<div id="Particulier" class="tabcontent">
	<table>
		<tr>
			<th>Voornaam</th>
			<th>familienaam</th>
			<th>tel</th>
			<th>gsm</th>
			<th>email</th>
			<th></th>
		</tr>
		<c:forEach items="${particulierList}" var="particulier">
		<tr>
			<td>${particulier.voornaam}</td>
			<td>${particulier.familienaam}</td>
			<td>${particulier.tel}</td>
			<td>${particulier.gsm}</td>
			<td>${particulier.email}</td>
			<td><a href="KlantDetail?edit=${particulier.id}">Details</a></td>
		</tr>
		</c:forEach>
	</table>
</div>

<div id="Bedrijf" class="tabcontent">
	<table>
		<tr>
			<th>Bedrijfsnaam</th>
			<th>contactpersoon</th>
			<th>BTW nr</th>
			<th>tel</th>
			<th>gsm</th>
			<th>email</th>
			<th></th>
		</tr>
		<c:forEach items="${bedrijfList}" var="bedrijf">
		<tr>
			<td>${bedrijf.bedrijfsnaam}</td>
			<td>${bedrijf.contactpersoon}</td>
			<td>${bedrijf.btwNr}</td>
			<td>${bedrijf.tel}</td>
			<td>${bedrijf.gsm}</td>
			<td>${bedrijf.email}</td>
			<td><a href="KlantDetail?edit=${bedrijf.id}">Details</a></td>
		</tr>
		</c:forEach>
	</table>
</div>
