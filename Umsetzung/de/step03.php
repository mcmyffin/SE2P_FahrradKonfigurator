<div id="timeline-bg">
	<div id="timeline">
		<table height="50px" width="850px">
			<colgroup>
			<?php
			$count=9; //auslesen der Datein auch Namen mit php
			for($i=0; $i < $count; $i++){
				echo "\t\t\t\t<col>\n";
				echo "\t\t\t\t<col width=\"6px\">\n";
			}
			?>
			</colgroup>
			<tr>
			<?php
			$array = ["Typ","Farbe","Größe","Gabel","Reifen","Schaltung","Sattel","Licht","Zubehör"];
			for($i=0; $i < $count; $i++){
				echo "\t\t\t\t<td align=\"center\"><b class=\"text\">";
				echo $array[$i];
				echo "</b></td>\n";
				echo "\t\t\t\t<td><img alt=\"|\" height=\"41px\" src=\"de/get/timeline-break.png\" /></td>\n";
			}
			?>
			</tr>
		</table>
	</div>
</div>
<div id="view-bg">
	<div id="view"><img alt="$php" height="366px" src="de/get/stadtrad/stadtrad-blau.png" width="591px"/></div>
</div>
<div id="infobox-bg">
	<div id="infobox">
		<b>Rahmengröße:</b><br /><br />
		Sie haben die Auswahl zwischen:<br /><br />
		<form action="index.php?section=step03#form">
			<table style="border-spacing: 0px;">
				<tr>
					<td align="center" height="20px" width="115px"><b>Körpergröße</b></td>
					<td align="center" height="20px" width="115px"><b>Rahmengröße</b></td>
					<td align="center" height="20px" width="10px"><b>✓</b></td>
				</tr>
				<tr>
					<td align="center" height="20px" width="115px">155 - 165 cm</td>
					<td align="center" height="20px" width="115px">35 - 38 cm</td>
					<td align="center" height="20px" width="10px"><input name="Rahmengroesse" type="radio" value="35-38cm" /></td>
				</tr>
				<tr>
					<td align="center" height="20px" width="115px">165 - 170 cm</td>
					<td align="center" height="20px" width="115px">38 - 41 cm</td>
					<td align="center" height="20px" width="10px"><input name="Rahmengroesse" type="radio" value="38-41cm" /></td>
				</tr>
				<tr>
					<td align="center" height="20px" width="115px">170 - 175 cm</td>
					<td align="center" height="20px" width="115px">41 - 43 cm</td>
					<td align="center" height="20px" width="10px"><input name="Rahmengroesse" type="radio"value="41-43cm" /></td>
				</tr>
				<tr>
					<td align="center" height="20px" width="115px">175 - 180 cm</td>
					<td align="center" height="20px" width="115px">43 - 46 cm</td>
					<td align="center" height="20px" width="10px"><input checked="checked" name="Rahmengroesse" type="radio" value="43-46cm" /></td>
				</tr>
				<tr>
					<td align="center" height="20px" width="115px">180 - 185 cm</td>
					<td align="center" height="20px" width="115px">46 - 48 cm</td>
					<td align="center" height="20px" width="10px"><input name="Rahmengroesse" type="radio"value="46-48cm" /></td>
				</tr>
				<tr>
					<td align="center" height="20px" width="115px">185 - 190 cm</td>
					<td align="center" height="20px" width="115px">48 - 53 cm</td>
					<td align="center" height="20px" width="10px"><input name="Rahmengroesse" type="radio" value="48-53cm" /></td>
				</tr>
				<tr>
					<td align="center" height="20px" width="115px">190 - 195 cm</td>
					<td align="center" height="20px" width="115px">53 - 56 cm</td>
					<td align="center" height="20px" width="10px"><input name="Rahmengroesse" type="radio" value="53-56cm" /></td>
				</tr>
				<tr>
					<td align="center" height="20px" width="115px">195 - 200 cm</td>
					<td align="center" height="20px" width="115px">56 - 58 cm</td>
					<td align="center" height="20px" width="10px"><input name="Rahmengroesse" type="radio" value="56-58cm" /></td>
				</tr>
			</table><br />
		</form>
		Im <a href="index.php?section=step04">nächsten Schritt</a> wählen Sie die Fahrradgabel aus.<br /><br />
	</div>
</div>
<div id="menu">
	<div id="info">
		<div id="info-bg-left"></div>
		<div id="info-bg-center"><div class="info">Aktueller Preis: php€</div></div>
		<div id="info-bg-right"></div>
	</div>
	<div id="next"><a href="index.php?section=step04"><img alt="Next" src="de/get/next.png" /></a></div>
</div>