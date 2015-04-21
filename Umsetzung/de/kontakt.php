<div class="content">
	<div class="headline">Kontaktformular</div><br />
	<div id="form">
		<form action="index.php?section=kontakt#form" method="post" >
			<input name="session" type="hidden" value="" />
			<p>
				<label class="text" for="name">Dein Name</label><br />
				<input id="name" name="name" value="" size="30" />
			</p>
			<p>
				<label class="text" for="phone">Deine Telefonnummer</label><br />
				<input id="phone" name="phone" type="tel" value="" size="30" />
			</p>
			<p>
				<label class="text" for="email">Deine E-Mail-Adresse</label><br />
				<input id="email" name="email" type="email" value="" size="30" />
			</p>
			<p>
				<label class="text" for="subject">Betreff</label><br />
				<input id="subject" name="subject" value="" size="30" />
			</p>
			<p>
				<label class="text" for="message" style="width: 100%;">Deine Nachricht</label><br />
				<textarea id="message" name="message" rows="8" style="resize: vertical; width: 100%;"></textarea>
			</p>
			<p>
				<input id="submit" style="width: 100%;" type="submit" value="Senden" />
			</p>
		</form>
	</div>
</div>