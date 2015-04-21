<!DOCTYPE html>
<html id="html" lang="de" xmlns="http://www.w3.org/1999/xhtml" xml:lang="de">
	<head>
		<meta charset="utf-8" /> 
		<meta content="index,follow" name="robots" />
		<link href="de/style.css" rel="stylesheet" type="text/css" />
		<title>Willkommen beim Fahrradkonfigurator</title>
	</head>
	<body bgcolor="#f4f4f4">
		<div id="body-bg">
			<div id="body">
				<?php
				include('php/config.php');
				if(isset($_GET['section']) AND isset($dateien[$_GET['section']])){
					if(!file_exists($dateien[$_GET['section']])) echo "Die Datei ist nicht vorhanden.";
					include $dateien[$_GET['section']];}
				else{include $dateien['main'];}
				?>
			</div>
		</div>
	</body>
</html>