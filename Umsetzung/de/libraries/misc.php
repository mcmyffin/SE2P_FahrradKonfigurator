<?php
function service_misc_stringToBytes($value) {
	// get integer and a valid string
	$return = intval($value);
	$value = /* utf8 */ trim(strval($value));

	// -1 means unlimited
	if ($return < 0) {
		return INF;
	}

	// get unit character
	$unit = strtolower(substr($value, -1)); // utf8
	if ($unit === 'b') {
		$unit = strtolower(substr($value, -2, -1)); // utf8
	}

	// multiply by unit
	switch ($unit) {
		case 't':
			$return *= 1024;
		case 'g':
			$return *= 1024;
		case 'm':
			$return *= 1024;
		case 'k':
			$return *= 1024;
		break;
	}
	return $return;
}
?>