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
		<b>Rahmenfarbe:</b><br /><br />
		Sie haben die Auswahl zwischen:<br /><br />
		<table style="border-spacing: 0px;">
			<tr>
				<td align="center" bgcolor="#fa842b" height="50px" width="85px"></td>
				<td align="center" bgcolor="#48a43f" height="50px" width="85px"></td>
				<td align="center" bgcolor="#3481b9" height="50px" width="85px"></td>
			</tr>
			<tr>
				<td align="center" bgcolor="#f3e03b" height="50px" width="85px"></td>
				<td align="center" bgcolor="#f4f8f4" height="50px" width="85px"></td>
				<td align="center" bgcolor="#0a0a0d" height="50px" width="85px"></td>
			</tr>
		</table><br />
		Im <a href="index.php?section=step03">nächsten Schritt</a> wählen Sie die Rahmengröße aus.<br /><br />
	</div>
</div>
<div id="menu">
	<div id="info">
		<div id="info-bg-left"></div>
		<div id="info-bg-center"><div class="info">Aktueller Preis: php€</div></div>
		<div id="info-bg-right"></div>
	</div>
	<div id="next"><a href="index.php?section=step03"><img alt="Next" src="de/get/next.png" /></a></div>
</div>