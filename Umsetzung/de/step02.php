<div id="timeline-bg">
	<div id="timeline">
		<table height="50px" width="850px">
			<colgroup>
			<?php
			$count=8; //auslesen der Datein auch Namen mit php
			for($i=0; $i < $count; $i++){
				echo "<col>";
				echo "<col width=\"6px\">";
			}
			?>
			</colgroup>
			<tr>
			<?php
			for($i=0; $i < $count; $i++){
				echo "<td align=\"center\"><b class=\"text\">test</b></td>";
				echo "<td><img alt=\"|\" height=\"41px\" src=\"de/get/timeline-break.png\" /></td>";
			}
			?>
			</tr>
		</table>
	</div>
</div>
<div id="view-bg">
	<div id="view"></div>
</div>
<div id="infobox-bg">
	<div id="infobox"></div>
</div>
<div id="menu">
	<div id="last"><a href="index.php?section=step02"><img alt="Last" src="de/get/last.png" /></a></div>
	<div id="info">
		<div id="info-bg-left"></div>
		<div id="info-bg-center"><div class="info">Aktueller Preis: php€</div></div>
		<div id="info-bg-right"></div>
	</div>
	<div id="next"><a href="index.php?section=step03"><img alt="Next" src="de/get/next.png" /></a></div>
</div>