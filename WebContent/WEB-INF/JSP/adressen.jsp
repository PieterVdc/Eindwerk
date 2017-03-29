<div>
	<h2>Adres(sen)</h2>
	<div class="tab">
		<a href="javascript:void(0)" class="tablinks"
			onclick="openTab(event, 'Adres1')">Adres1</a> <a
			href="javascript:void(0)" class="tablinks"
			onclick="openTab(event, 'newAdres')">+</a>
	</div>

	<div id="Adres1" class="tabcontent">
		<form action="">
			<label for="straat">straat: </label> <input id="straat" /><br />
			<label for=nr>nr: </label> <input id="nr" type="number"><br />
			<label for=postcode>for=postcode: </label> <input id="for=postcode" type="number" min="1000" max="9999"><br />
			<label for="gemeente">gemeente: </label> <input id="gemeente" /><br />
			<input type="submit" value="Opslaan">
		</form>
		<button>Verwijder</button>
	</div>
</div>