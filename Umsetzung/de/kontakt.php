<?php
// Email library
include_once 'libraries/emails.php';

// GetRandomString($length = 5)
$maximum = 1;
while (pow(PHP_INT_MAX, 1 / $maximum) > 36) {
	$maximum++;
}
define('SERVICE_MISC_GETRANDOMSTRING_MAXIMUM', $maximum - 1);
unset($maximum);

function service_misc_GetRandomString($length = 5) {
	$return = '';
	while ($length > SERVICE_MISC_GETRANDOMSTRING_MAXIMUM) {
		$return .= service_misc_GetRandomString(SERVICE_MISC_GETRANDOMSTRING_MAXIMUM);
		$length -= SERVICE_MISC_GETRANDOMSTRING_MAXIMUM;
	}
	return $return . /* utf8 */ str_pad(base_convert(mt_rand(0, pow(36, $length) - 1), 10, 36), $length, '0', STR_PAD_LEFT);
}

$send = true;
$status = '';
$success = false;

// Handling input
if (isset($_REQUEST['session']) && is_string($_REQUEST['session'])) {
	$session = $_REQUEST['session'];
} else {
	$session = '';
	$send = false;
}
if (isset($_REQUEST['name']) && is_string($_REQUEST['name'])) {
	$name = $_REQUEST['name'];
	if (trim($name) === '') {
		$send = false;
	}
} else {
	$name = '';
	$send = false;
}
if (isset($_REQUEST['phone']) && is_string($_REQUEST['phone'])) {
	$phone = $_REQUEST['phone'];
	if (trim($phone) === '') {
		$send = false;
	}
} else {
	$phone = '';
	$send = false;
}
if (isset($_REQUEST['email']) && is_string($_REQUEST['email'])) {
	$email = $_REQUEST['email'];
	if (trim($email) === '') {
		$send = false;
	}
} else {
	$email = '';
	$send = false;
}
if (isset($_REQUEST['subject']) && is_string($_REQUEST['subject'])) {
	$subject = $_REQUEST['subject'];
	if (trim($subject) === '') {
		$send = false;
	}
} else {
	$subject = '';
	$send = false;
}
if (isset($_REQUEST['message']) && is_string($_REQUEST['message'])) {
	$message = $_REQUEST['message'];
	if (trim($message) === '') {
		$send = false;
	}
} else {
	$message = '';
	$send = false;
}

if ($session !== '' && $send === false || (isset($_SESSION['kontakt-session']) === false || $session !== $_SESSION['kontakt-session']) && $send === true) {
	$status = '<div class="warning">Bitte kontrolliere die Eingaben und best&auml;tige.</div>';
	$send = false;
}
$session = service_misc_GetRandomString();
$_SESSION['kontakt-session'] = $session;

if ($send === true) {
	$data = array(
		'from' => array(array($name => $email)),
		'to' => array(array('Fahrradkonfigurator' => 'Henning.Kahl@web.de')),
		'bcc' => null,
		'cc' => array(array($name => $email)),
		'reply-to' => array(array($name => $email)),
		'message' => 'Vielen Dank f�r deine Anfrage. Wir werden diese schnellstm&ouml;glich bearbeiten.' . "\n\n\n" . 'Folgende Daten hast du bei uns angegeben:' . "\n\n" . 'Telefon: ' . $phone . "\n" . 'Betreff: ' . $subject . "\n\n" . $message,
		'subject' => 'Kontaktformular: Fahrradkonfigurator.de'
	);
	
	if (service_emails_Send($data['from'], $data['to'], $data['message'], $data['subject'], $data) === true) {
		$success = true;
		$name = '';
		$email = '';
		$subject = '';
		$message = '';
	} else {
		$status = '<div class="error">Fehler beim Senden der Nachricht.</div>';
	}
}
?>
<?php
	if ($success) {
		echo '<div class="success">Deine Anfrage wurde gesendet.</div>';
	} else {
		echo $status;
?>
<div class="content">
	<div class="headline">Kontaktformular</div><br />
	<iframe width="606px" height="196px" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://www.openstreetmap.org/export/embed.html?bbox=10.020722150802612%2C53.555963183773336%2C10.024605989456177%2C53.55755329954288&amp;layer=mapnik" style="border: 1px solid #aaa; right: 0px; position: absolute; top: 36px;"></iframe>
	<div id="form">
		<form action="index.php?section=kontakt#form" method="post" onsubmit="if (this.submitted === true) { return false; } this.submitted = true; document.getElementById('submit').value = 'bitte warten...';">
			<input name="session" type="hidden" value="<?php echo htmlspecialchars($session, ENT_QUOTES, 'UTF-8'); ?>" />
			<p>
				<label class="text" for="name">Dein Name</label><br />
				<input id="name" name="name" value="<?php echo htmlspecialchars($name, ENT_QUOTES, 'UTF-8'); ?>" size="30" />
			</p>
			<p>
				<label class="text" for="phone">Deine Telefonnummer</label><br />
				<input id="phone" name="phone" type="tel" value="<?php echo htmlspecialchars($phone, ENT_QUOTES, 'UTF-8'); ?>" size="30" />
			</p>
			<p>
				<label class="text" for="email">Deine E-Mail-Adresse</label><br />
				<input id="email" name="email" type="email" value="<?php echo htmlspecialchars($email, ENT_QUOTES, 'UTF-8'); ?>" size="30" />
			</p>
			<p>
				<label class="text" for="subject">Betreff</label><br />
				<input id="subject" name="subject" value="<?php echo htmlspecialchars($subject, ENT_QUOTES, 'UTF-8'); ?>" size="30" />
			</p>
			<p>
				<label class="text" for="message" style="width: 100%;">Deine Nachricht</label><br />
				<textarea id="message" name="message" rows="8" style="resize: vertical; width: 100%;"><?php echo htmlspecialchars($message, ENT_QUOTES, 'UTF-8'); ?></textarea>
			</p>
			<p>
				<input id="submit" style="width: 100%;" type="submit" value="Senden" />
			</p>
		</form>
	</div>
</div>
<?php } ?>