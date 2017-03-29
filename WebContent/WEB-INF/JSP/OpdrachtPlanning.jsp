klant: ${klantnaam}
Datum gecreerd: ${aanmaakDatum}
Opdracht: ${OpdrachtNaam}
Deadline: ${Deadline}
Adres: ${Adres}
Omschrijving: ${Omschrijving}

<div class="tab">
  <a href="javascript:void(0)" class="tablinks" onclick="openTab(event, 'NieuwePlanning')">NieuwePlanning</a>
  <a href="javascript:void(0)" class="tablinks" onclick="openTab(event, 'reedsGepland')">reedsGepland</a>
</div>

<div id="NieuwePlanning" class="tabcontent">
<form action="">
	Kies datum: <input type="date"/>
	Kies Werknemer:  <select>
  		<option value="1">Bob Smith</option>
	</select> 
	<input type="submit"/>
</form>
Op de gekozen datum reeds toegewezen taken voor de gekozen werknemer
<ul>
<li>Lorem</li>
<li>Ipsm</li>
</ul>

</div>

<div id="reedsGepland" class="tabcontent">
  <table>
	<tr>
		<th>Naam Werknemer</th>
		<th>Datum</th>
		<th></th>
	</tr>
	<tr>
		<td>Porem</td>
		<td>00/00/0000</td>
		<td><a>Delete</a></td>
	</tr>
</table>
</div>
<div>
Vooruitgang
 <table>
	<tr>
		<th>Naam Werknemer</th>
		<th>Datum</th>
		<th>uur</th>
		<th>inhoud</th>
		<th>opmerking</th>
		<th></th>
	</tr>
	<tr>
		<td>Porem</td>
		<td>00/00/0000</td>
		<td>00:00</td>
		<td>Gestart</td>
		<td>lorem</td>
		<td><a>Delete</a></td>
	</tr>
</table>
</div>


