<div class="content">
	<div class="headline">Account</div><br />
	<div id="form">
		<form action="index.php?section=account#form" method="post" onsubmit="">
			<input name="session" type="hidden" value="" />
			<div class="text" style="padding-left: 30px;">
				<p>
					<label class="text" for="username">Benutzername</label><br />
					<input id="username" name="username" value="" size="42" />
				</p>
				<p>
					<label class="text" for="email">E-Mail-Adresse</label><br />
					<input id="email" name="email" type="email" value="" size="42" />
				</p>
				<p>
					<label class="text" for="password">Passwort</label><br />
					<input id="password" name="password" type="password" value="" size="42" />
				</p><br />
				<p>
					Anrede<br />
					<select size="1" style="width: 92px;">
						<option>Frau</option>
						<option>Herr</option>
					</select>
				</p>
				<p>
					<label class="text" for="surname">Vorname</label><br />
					<input id="surname" name="surname" value="" size="42" />
				</p>
				<p>
					<label class="text" for="lastname">Nachname</label><br />
					<input id="lastname" name="lastname" value="" size="42" />
				</p>

				<p>
					Geb. Datum<br />
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
					<label class="text" for="location">PLZ, Ort</label><br />
					<input id="plz" name="plz" value="" size="5" />
					<input id="location" name="location" value="" size="33" />
				</p>
				<p>
					<label class="text" for="street">Straße, Nr.</label><br />
					<input id="street" name="street" value="" size="42" />
				</p>
				<p>
					<label class="text" for="phone">Telefonnummer</label><br />
					<input id="phone" name="phone" type="tel" value="" size="42" />
				</p>
				<p><br />
					<input id="submit" style="cursor: pointer !important; margin-top: 3px; width: 317px;" type="submit" value="Ändern" />
				</p><br />
			</div>
		</form>
	</div>
</div>

