<h1>Opdracht</h1>
<form>
<label for="klant">klant</label>
 <select id="klant">
  <option value="1">Klant1</option>
  <option value="saab">Klant2</option>
</select> 
Datum gecreerd: 00/00/2000
<label for="deadline">deadline</label><input type="date"/>
<label for="omschrijving">omschrijving</label><textarea rows="10" cols="20" id="omschrijving"></textarea>
<input type="button" value="Voeg nieuwe taak toe" />
<input type="button" value="Voeg  gebruikt materiaal toe" />
<input type="submit" value="Opslaan" />
</form>





<div class="tab">
  <a href="javascript:void(0)" class="tablinks" onclick="openTab(event, 'Takenlijst')">Takenlijst</a>
  <a href="javascript:void(0)" class="tablinks" onclick="openTab(event, 'GebruikteMaterialen')">GebruikteMaterialen</a>
</div>

<div id="Takenlijst" class="tabcontent">
  <table>
	<tr>
		<th>Categorie</th>
		<th>voortgang</th>
		<th>datum gecreerd</th>
		<th>datum gestart</th>
		<th>Deadline</th>
		<th>Omschrijving</th>
		<th></th>
		<th></th>
	</tr>
	<tr>
		<td>Lorem</td>
		<td>niet gestart</td>
		<td>00/00/0000</td>
		<td>00/00/0000</td>
		<td>00/00/0000</td>
		<td>Lorem ipsum..</td>
		<td><a>Details</a></td>
		<td><a>Verwijderen</a></td>
	</tr>
</table>
</div>

<div id="GebruikteMaterialen" class="tabcontent">
  <table>
	<tr>
		<th>Soort</th>
		<th>Naam</th>
		<th>hoeveelheid</th>
		<th>eenheidsmaat</th>
		<th>eenheidsprijs</th>
		<td><a>Details</a></td>
	</tr>
	<tr>
		<td>Porem</td>
		<td>Ipsor</td>
		<td>0</td>
		<td>kg</td>
		<td>00</td>
		<td><a>Delete</a></td>
	</tr>
</table>
</div>