<?php
global $service_emails;
$service_emails = array();

/*
 * FUNCTIONS
 */
function service_emails_Check($email) {
	if ( /* utf8 */ strpos($email, '.') === 0) {
		return false;
	}
	// $email = data('Encode', 'punycode', $email);
	if ( /* utf8 */ strlen($email) > 254) {
		return false;
	}
	$email = /* utf8 */ explode('@', $email);
	if (count($email) !== 2) {
		return false;
	}
	// local-part
	if (preg_match('/^[A-Za-z0-9\\.\\!#\\$%&\'\\*\\+\\-\\/\\=\\?\\^_`\\{\\|\\}~]{1,64}$/', $email[0]) === 0 || substr($email[0], -1) === '.' || strpos($email[0], '..') !== false) { // utf8
		return false;
	}
	// domain-part
	if (strpos($email[1], '.') === 0 || substr($email[1], -1) === '.' || strpos($email[1], '..') !== false) { // utf8
		return false;
	}
	foreach ( /* utf8 */ explode('.', $email[1]) as $label) {
		if (preg_match('/^[A-Za-z0-9\\-]{1,63}$/', $label) === 0 || substr($label, 0, 1) === '-' || substr($label, -1) === '-') { // utf8
			return false;
		}
	}
	return true;
}

/*
 * $params:
 *  -> attachments
 *  -> bcc
 *  -> cc
 *  -> encoding
 *  -> html
 *  -> organization
 *  -> priority
 *  -> reply-to
 *  -> sender
 */
function service_emails_Send($from, $to, $content, $subject = '', $params = null) {
	global $service_emails;
	
	// Params
//	$attachments = null;
	$bcc = null;
	$cc = null;
	$encoding = 'UTF-8';
	$html = false;
	$organization = null;
	$priority = null;
	$replyto = null;
	$sender = null;
	if (is_array($params) === true) {
//		if (isset($params['attachments']) === true) {
//			$attachments = $params['attachments'];
//		}
		if (isset($params['bcc']) === true) {
			$bcc = $params['bcc'];
		}
		if (isset($params['cc']) === true) {
			$cc = $params['cc'];
		}
		if (isset($params['encoding']) === true) {
			$encoding = $params['encoding'];
		}
		if (isset($params['html']) === true) {
			if (is_string($params['html']) === true) {
				$html = $params['html'];
			} else if ($params['html'] === true) {
				$html = $content;
				$content = strip_tags($content);
			}
		}
		if (isset($params['organization']) === true) {
			$organization = $params['organization'];
		}
		if (isset($params['priority']) === true) {
			$priority = $params['priority'];
		}
		if (isset($params['reply-to']) === true) {
			$replyto = $params['reply-to'];
		}
		if (isset($params['sender']) === true) {
			$sender = $params['sender'];
		}
	}
	
	// Encoding
	$service_emails['encoding'] = $encoding;
	
	// To
	$to = private_service_emails_GetMailboxList($to);
	if ($to === false || $to === '') {
		return false;
	}
	
	// Content-Type
	$body = array();
	$contentType = 'text/plain; charset=' . $encoding;
	if ($html !== false) {
		$htmlBoundary = md5(uniqid(microtime()));
		$contentType = 'multipart/alternative; boundary=' . $htmlBoundary;
		$body[] = 'This is a multi-part message in MIME format.';
	}
//	if ($attachments !== null) {
//		$boundary = md5(uniqid(microtime()));
//		$contentType = 'multipart/mixed; boundary=' . $boundary;
//		$body = array('This is a multi-part message in MIME format.');
//		if ($html !== false) {
//			$body[] = '--' . $boundary;
//			$body[] = 'Content-Type: multipart/alternative; boundary=' . $htmlBoundary;
//			$body[] = '';
//		}
//	}
	
	// Header
	$header = array();
	$header[] = 'MIME-Version: 1.0';
	$header[] = 'Content-Type: ' . $contentType;
	$header[] = 'Date: ' . date('r');
	$header[] = 'Message-ID: <' . md5(uniqid(microtime())) . '@' . $_SERVER['SERVER_NAME'] . '>';
	// $header[] = 'User-Agent: oneye/' . SYSTEM_VERSION;
	
	// From
	$from = private_service_emails_GetMailboxList($from);
	if ($from === false || $from === '') {
		return false;
	}
	$header[] = 'From: ' . $from;
	
	// Bcc
	if ($bcc !== null) {
		$bcc = private_service_emails_GetMailboxList($bcc);
		if ($bcc === false) {
			return false;
		}
		if ($bcc !== '') {
			$header[] = 'Bcc: ' . $bcc;
		}
	}
	
	// Cc
	if ($cc !== null) {
		$cc = private_service_emails_GetMailboxList($cc);
		if ($cc === false) {
			return false;
		}
		if ($cc !== '') {
			$header[] = 'Cc: ' . $cc;
		}
	}
	
	// Organization
	if ($organization !== null) {
		$organization = private_service_emails_Encode($organization);
		if ($organization !== '') {
			$header[] = 'Organization: ' . $organization;
		}
	}
	
	// Priority
	if ($priority === 1) {
		$header[] = 'X-Priority: 1 (Highest)';
	} else if ($priority === 2) {
		$header[] = 'X-Priority: 2 (High)';
	} else if ($priority === 4) {
		$header[] = 'X-Priority: 4 (Low)';
	} else if ($priority === 5) {
		$header[] = 'X-Priority: 5 (Lowest)';
	}
	
	// Reply-To
	if ($replyto !== null) {
		$replyto = private_service_emails_GetMailboxList($replyto);
		if ($replyto === false) {
			return false;
		}
		if ($replyto !== '') {
			$header[] = 'Reply-To: ' . $replyto;
		}
	}
	
	// Sender
	if ($sender !== null) {
		$sender = private_service_emails_GetMailbox($sender);
		if ($sender === false) {
			return false;
		}
		$header[] = 'Sender: ' . $sender;
	}
	
	// Body
	$content = str_replace(array("\r\n", "\r", "\n"), array("\n", "\n", PHP_EOL), $content);
	if ($html !== false) {
		$body[] = '--' . $htmlBoundary;
		$body[] = 'Content-Type: text/plain; charset=' . $encoding;
		$body[] = 'Content-Transfer-Encoding: quoted-printable';
		$body[] = '';
		$body[] = quoted_printable_encode($content);
		$body[] = '--' . $htmlBoundary;
		$body[] = 'Content-Type: text/html; charset=' . $encoding;
		$body[] = 'Content-Transfer-Encoding: quoted-printable';
		$body[] = '';
		$body[] = quoted_printable_encode($html);
		$body[] = '--' . $htmlBoundary . '--';
		$body[] = '';
	} else {
		$header[] = 'Content-Transfer-Encoding: quoted-printable';
		$body[] = quoted_printable_encode(str_replace(array("\r\n", "\r", "\n"), array("\n", "\n", PHP_EOL), $content));
	}
//	if ($attachments !== null) {
//		if (is_array($attachments) === false) {
//			$attachments = array($attachments);
//		}
//		foreach ($attachments as $attachment) {
//			if (isset($attachment['content']) === false) {
//				$attachment['content'] = files('ReadFile', $attachment['path']);
//			}
//			if (isset($attachment['filename']) === false) {
//				$attachment['filename'] = files('Basename', $attachment['path']);
//				if ($attachment['filename'] === false) {
//					return false;
//				}
//			}
//			if (isset($attachment['type']) === false) {
//				$attachment['type'] = files('Extension', $attachment['path']);
//			}
//			$attachment['type'] = extern('ContentType', $attachment['type']);
//			if ($attachment['type'] === false) {
//				$attachment['type'] = 'text/plain';
//			}
//			$body[] = '--' . $boundary;
//			$body[] = 'Content-Type: ' . $attachment['type'] . '; name=' . private_service_emails_Encode($attachment['filename']);
//			$body[] = 'Content-Transfer-Encoding: base64';
//			if ($attachment['filename'] !== false) {
//				$body[] = 'Content-Disposition: attachment; filename=' . private_service_emails_Encode($attachment['filename']);
//			}
//			$body[] = '';
//			$body[] = /* utf8 */ chunk_split(base64_encode($attachment['content']));
//		}
//		$body[] = '--' . $boundary . '--';
//	}
	
	// Mail
	return mail($to, private_service_emails_Encode($subject), implode(PHP_EOL, $body), implode(PHP_EOL, $header));
}

/*
 * PRIVATE
 */
function private_service_emails_Encode($string) {
	global $service_emails;
	
	$string = quoted_printable_encode($string);
	if ( /* utf8 */ strpos($string, '=') !== false) {
		$string = str_replace('=' . "\r\n", '?=' . PHP_EOL . ' =?' . $service_emails['encoding'] . '?Q?', $string);
		$string = '=?' . $service_emails['encoding'] . '?Q?' . $string . '?=';
	}
	return $string;
}

function private_service_emails_GetMailbox($object) {
	if (is_string($object) === true && service_emails_Check($object) === true) {
		return $object;
	} else if (is_array($object) === true && count($object) > 0) {
		$keys = array_keys($object);
		if (service_emails_Check($object[$keys[0]]) === true) {
			if (is_string($keys[0]) === true) {
				$value = private_service_emails_Encode($keys[0]);
				if ($value === $keys[0]) {
					$value = '"' . $value . '"';
				}
				return $value . ' <' . $object[$keys[0]] . '>';
			}
			return $object[$keys[0]];
		}
	}
	return false;
}

function private_service_emails_GetMailboxList($object) {
	if (is_array($object) === false) {
		$object = array($object);
	}
	$return = '';
	foreach ($object as $mailbox) {
		$mailbox = private_service_emails_GetMailbox($mailbox);
		if ($mailbox === false) {
			return false;
		}
		if ($return !== '') {
			$return .= ',';
		}
		$return .= $mailbox;
	}
	return $return;
}
?>