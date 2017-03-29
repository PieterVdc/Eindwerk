<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>
	<c:if test="${particulier}">Particulier</c:if>
	<c:if test="${bedrijf}">Bedrijf</c:if>
	klant
</h1>

<div>
	<h2>Gegevens</h2>
	<form action="">
		<c:if test="${type=='particulier'}">
			<label for="voornaam">Voornaam: </label>
			<input id="voornaam" value="${klant.voornaam}"/>
			<br />
			<label for=Familienaam>Familienaam: </label>
			<input id="Familienaam" value="${klant.familienaam}">
			<br />
		</c:if>
		<c:if test="${type=='bedrijf'}">
			<label for="Bedrijfsnaam">Bedrijfsnaam: </label>
			<input id="Bedrijfsnaam" value="${klant.bedrijfsnaam}"/>
			<br />
			<label for=contactpersoon>contactpersoon: </label>
			<input id="contactpersoon" value="${klant.contactpersoon}">
			<br />
			<label for=btwnr>btwnr: </label>
			<input id="btwnr" value="${klant.btwNr}">
			<br />
		</c:if>
		<label for="tel">tel: </label> <input id="tel" value="${klant.tel}"/><br />
		<label for=gsm>gsm: </label> <input id="gsm" value="${klant.gsm}"><br />
		<label for=email>email: </label> <input id="email" type="email" value="${klant.email}"><br />
		<input type="submit" value="Submit">
	</form>
</div>

<jsp:include page="adressen.jsp"></jsp:include>

<div>
	<h2>Exporteer alle prestaties van deze klant</h2>
	<div>
		<form action="">
			<label for=startDatum>startdatum: </label> <input id="startDatum" type="date"><br />
			<label for=eindDatum>einddatum: </label> <input id="eindDatum" type="date"><br />
			<input type="submit" value="Exporteer">
		</form>
	</div>
</div>