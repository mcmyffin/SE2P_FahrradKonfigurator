<div class="content">	
	<div class="headline">Registrieren</div><br />	
	<div id="form">
		<form action="index.php?section=registrieren#form" method="post" onsubmit="">
			<input name="session" type="hidden" value="" />
			<div class="text">
				<p>
					<label class="text" for="username">Benutzername*</label><br />
					<input id="username" name="username" value="" size="40" />
				</p>
				<p>
					<label class="text" for="password">Passwort*</label><br />
					<input id="password" name="password" type="password" value="" size="40" />
				</p>
				<p>
					<label class="text" for="password">Passwort wiederholen*</label><br />
					<input id="password" name="password" type="password" value="" size="40" />
				</p>
				<p>
					<label class="text" for="email">E-Mail-Adresse*</label><br />
					<input id="email" name="email" type="email" value="" size="40" />
				</p>
				<p>
					<label class="text" for="email">E-Mail-Adresse wiederholen*</label><br />
					<input id="email" name="email" type="email" value="" size="40" />
				</p>
				<p>
					Geb. Datum*<br />
					<select size="1">
					<option>&nbsp; &nbsp;-- Tag --&nbsp; &nbsp;</option>
						<?php
						for($i=1, $days=31; $i <= $days; $i++){
							echo "<option>";
							echo $i;
							echo "</option>";
						}
						?>					
					</select>
					<select size="1">
						<option>&nbsp; &nbsp; -- Monat -- &nbsp; &nbsp;</option>
						<option>Januar</option>
						<option>Februar</option>
						<option>März</option>
						<option>April</option>
						<option>Mai</option>
						<option>Juni</option>
						<option>Juli</option>
						<option>August</option>
						<option>September</option>
						<option>Oktober</option>
						<option>November</option>
						<option>Dezember</option>
					</select>
					<select size="1">
						<option>&nbsp; &nbsp;-- Jahr --&nbsp; &nbsp;</option>
						<?php
						for($i=2001, $days=1900; $i >= $days; $i--){
							echo "<option>";
							echo $i;
							echo "</option>";
						}
						?>					
					</select>
				</p>
				<p>
					<input id="submit" style="cursor: pointer !important; margin-top: 3px; width: 721px;" type="submit" value="Registrieren" />
				</p>
			</div>
			<div class="text" style="margin-left: 418px; position: absolute; top: 58px;">
				<p>
					Anrede*<br />
					<select size="1">
						<option>&nbsp; &nbsp; -- Anrede -- &nbsp; &nbsp;</option>
						<option>Frau</option>
						<option>Herr</option>
					</select>
				</p>
				<p>
					<label class="text" for="surname">Vorname*</label><br />
					<input id="surname" name="surname" value="" size="40" />
				</p>
				<p>
					<label class="text" for="lastname">Nachname*</label><br />
					<input id="lastname" name="lastname" value="" size="40" />
				</p>
				<p>
					<label class="text" for="location">PLZ, Ort*</label><br />
					<input id="plz" name="plz" value="" size="5" />
					<input id="location" name="location" value="" size="31" />
				</p>
				<p>
					<label class="text" for="street">Straße, Nr.*</label><br />
					<input id="street" name="street" value="" size="40" />
				</p>
				<p>
					<label class="text" for="phone">Telefonnummer*</label><br />
					<input id="phone" name="phone" type="tel" value="" size="40" />
				</p>
			</div>
		</form>
	</div>
</div>