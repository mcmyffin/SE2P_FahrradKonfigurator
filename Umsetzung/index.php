<!DOCTYPE html>
<?php
// Compatibility
include_once 'de/libraries/compat.php';

// Session initialization
ini_set('session.use_cookies', true);
ini_set('session.use_only_cookies', true);
@session_start();

if (isset($_SESSION) === false) {
	$_SESSION = array();
}
?>
<html id="html" lang="de" xmlns="http://www.w3.org/1999/xhtml" xml:lang="de">
	<head>
		<link href="de/get/favicon.ico" rel="shortcut icon" type="image/x-icon" />
		<link href="de/style.css" rel="stylesheet" type="text/css" />
		<meta charset="utf-8" /> 
		<meta content="index,follow" name="robots" />
		<title>Willkommen beim Fahrradkonfigurator</title>
	</head>
	<body bgcolor="#f4f4f4">
		<div id="logo-bg">
			<div id="logo"><a href="index.php?section=index"><img alt="Fahrradkonfigurator" src="de/get/logo.png" /></a></div>
			<div id="logo-extend"><b style="font-size: 164.5%;">Fahrradkonfigurator</b><br />Der schnelle Weg zu Ihrem Fahrrad</div>
		</div>
		<div id="navbar-bg">
			<div id="navbar">
				<div id="navbar-bg-left"></div>
				<div id="navbar-bg-center">
					<div id="navbar-buttons" class="navbar">
					<img alt=" | " src="de/get/break.png" style="position: absolute; margin: auto; margin-top: -6px; margin-left: -9px;" /> &nbsp; 
					<a href="index.php?section=main">News</a>
					<img alt=" | " src="de/get/break.png" style="position: absolute; margin: auto; margin-top: -6px; left: 65px;" /> &nbsp; &nbsp; &nbsp; 
					<a href="index.php?section=konfigurator">Konfigurator</a>
					<img alt=" | " src="de/get/break.png" style="position: absolute; margin: auto; margin-top: -6px; left: 194px;" /> &nbsp; &nbsp; &nbsp; 
					<a href="index.php?section=login">Mein Konto</a>
					<img alt=" | " src="de/get/break.png" style="position: absolute; margin: auto; margin-top: -6px; left: 312px;" /> &nbsp; &nbsp; &nbsp; 
					<a href="index.php?section=warenkorb">Warenkorb</a>
					<img alt=" | " src="de/get/break.png" style="position: absolute; margin: auto; margin-top: -6px; left: 426px;" /> &nbsp; &nbsp; &nbsp; 
					<a href="index.php?section=kontakt">Kontakt</a>
					<img alt=" | " src="de/get/break.png" style="position: absolute; margin: auto; margin-top: -6px; left: 517px;" /></div>
				</div>
				<div id="navbar-bg-right"></div>
			</div>
		</div>
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
		<div id="footer-bg">
			<div id="footer">
				<div id="footer-bg-left"></div>
				<div id="footer-bg-center">
					<div id="footer-text-left" class="footer">Copyright by <b>SEP/02</b></div>
					<div id="footer-text-right" class="footer"><a href="index.php?section=agb">AGB</a> &nbsp; &nbsp; | &nbsp; &nbsp; <a href="index.php?section=kontakt">Kontakt</a> &nbsp; &nbsp; | &nbsp; &nbsp; <a href="index.php?section=impressum">Impressum</a></div>
				</div>
				<div id="footer-bg-right"></div>
			</div>
		<div>
	</body>
</html>