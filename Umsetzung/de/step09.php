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
		<b>Zubehör:</b><br /><br />
		Sie haben die Auswahl zwischen:<br /><br />
		<form action="index.php?section=step09#form">
			<table style="border-spacing: 0px;">
				<tr>
					<td align="center" height="20px" width="200px"><b>Artikel</b></td>
					<td align="left" height="20px" width="40px"><b>✓</b></td>
				</tr>
				<tr>
					<td align="center" height="20px" width="200px">Fahrradhelm</td>
					<td align="left" height="20px" width="40px"><input type="checkbox" name="Zubehoer" value="Fahrradhelm" /></td>
				</tr>
				<tr>
					<td align="center" height="20px" width="200px">Fahrradschloss</td>
					<td align="left" height="20px" width="40px"><input type="checkbox" name="Zubehoer" value="Fahrradschloss" /></td>
				</tr>
				<tr>
					<td align="center" height="20px" width="200px">Fahrradpumpe</td>
					<td align="left" height="20px" width="40px"><input type="checkbox" name="Zubehoer" value="Fahrradpumpe" /></td>
				</tr>
				<tr>
					<td align="center" height="20px" width="200px">Fahrradklingel</td>
					<td align="left" height="20px" width="40px"><input type="checkbox" name="Zubehoer" value="Fahrradklingel" /></td>
				</tr>
			</table><br />
		</form>
		Im <a href="index.php?section=bestellen">letzten Schritt</a> können Sie abschließend Ihre Konfiguration ansehen und direkt bestellen.<br /><br />
	</div>
</div>
<div id="menu">
	<div id="info">
		<div id="info-bg-left"></div>
		<div id="info-bg-center"><div class="info">Aktueller Preis: php€</div></div>
		<div id="info-bg-right"></div>
	</div>
	<div id="next"><a href="index.php?section=bestellen"><img alt="Next" src="de/get/next.png" /></a></div>
</div>