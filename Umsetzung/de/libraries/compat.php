<?php
ini_set('arg_separator.output', '&amp;');
setlocale(LC_ALL, 'de_DE.UTF-8');

if (function_exists('date_default_timezone_set') === true) {
	date_default_timezone_set('Europe/Berlin');
} else {
	ini_set('date.timezone', 'Europe/Berlin');
}

// Support register_globals
if (ini_get('register_globals')) {
	foreach (array_keys($_REQUEST) as $key) {
		if ($_REQUEST[$key] === $$key) {
			unset($$key);
		}
	}
}

// Support get_magic_quotes_gpc and magic_quotes_sybase
if ((function_exists('get_magic_quotes_gpc') && get_magic_quotes_gpc()) || ini_get('magic_quotes_sybase')) {
	$_COOKIE = array_map_recursive('stripslashes', $_COOKIE, true);
	$_GET = array_map_recursive('stripslashes', $_GET, true);
	$_POST = array_map_recursive('stripslashes', $_POST, true);
	$_REQUEST = array_map_recursive('stripslashes', $_REQUEST, true);
}

// Support magic_quotes_runtime
if (ini_get('magic_quotes_runtime') && function_exists('set_magic_quotes_runtime')) {
	set_magic_quotes_runtime(0);
}

/*
 * FUNCTIONS
 */
function array_map_recursive($callback, $array, $mapkeys = false) {
	if ($callback !== null && is_callable($callback) === true) {
		foreach ($array as $key => $value) {
			if ($mapkeys === true) {
				unset($array[$key]);
				$key = call_user_func($callback, $key);
			}
			if (is_array($value) === true) {
				$array[$key] = array_map_recursive($callback, $value);
			} else {
				$array[$key] = call_user_func($callback, $value);
			}
		}
	}
	return $array;
}

// Support date_default_timezone_set (PHP < 5.1.0)
if (function_exists('date_default_timezone_set') === false) {
	function date_default_timezone_set($timezone_identifier) {
		return (ini_set('date.timezone', $timezone_identifier) !== false);
	}
}

// Support exif_imagetype
if (function_exists('exif_imagetype') === false) {
	function exif_imagetype($filename) {
		$info = getimagesize($filename);
		if ($info === false) {
			return false;
		}
		return $info[2];
	}
}

// Support fnmatch (PHP < 5.3.0 on Windows)
if (function_exists('fnmatch') === false) {
	@define('FNM_PATHNAME', 1);
	@define('FNM_NOESCAPE', 2);
	@define('FNM_PERIOD', 4);
	@define('FNM_CASEFOLD', 16);
	
	function fnmatch($pattern, $string, $flags = 0) {
		$modifiers = '';
		$replace = array(
			'\\*' => '.*',
			'\\?' => '.',
			'\\[\\!' => '[^',
			'\\[' => '[',
			'\\]' => ']',
			'\\.' => '\\.',
			'\\' => '\\\\'
		);
		if (($flags & FNM_NOESCAPE) !== 0) {
			unset($replace['\\']);
		}
		if (($flags & FNM_PATHNAME) !== 0) {
			$replace['\\*'] = '[^/]*';
		}
		if (($flags & FNM_PERIOD) !== 0 && strpos($string, '.') === 0 && strpos($pattern, '.') !== 0) { // utf8
			return false;
		}
		if (($flags & FNM_CASEFOLD) !== 0) {
			$modifiers = 'i';
		}
		if ( /* utf8 */ preg_match('/^' . strtr(preg_quote($pattern, '/'), $replace) . '$/su' . $modifiers, $string) === 1) {
			return true;
		}
		return false;
	}
}

// Support hex2bin (PHP < 5.4.0)
if (function_exists('hex2bin') === false) {
	function hex2bin($data) {
		return pack('H*', $data);
	}
}

// Support lcfirst (PHP < 5.3.0) // utf8
if (!function_exists('lcfirst')) {
	function lcfirst($str) { // utf8
		return strtolower(substr($str, 0, 1)) . substr($str, 1); // utf8
	}
}

// Support parse_ini_string (PHP < 5.3.0)
//if (function_exists('parse_ini_string') === false) {
//	@define('INI_SCANNER_NORMAL', 0);
//	@define('INI_SCANNER_RAW', 1);
//	
//	function parse_ini_string($ini, $process_sections = false, $scanner_mode = INI_SCANNER_NORMAL) {
//		$file = files('GetTemporaryPath');
//		files('WriteFile', $file, $content);
//		$return = parse_ini_file($file, $process_sections);
//		files('Delete', $file);
//		return $return;
//	}
//}

// Support quoted_printable_encode (PHP < 5.3.0)
if (function_exists('quoted_printable_encode') === false) {
	function quoted_printable_encode($str) {
		$line = 0;
		$return = '';
		for ($i = 0; $i < /* utf8 */ strlen($str); $i++) {
			$ord = /* utf8 */ ord($str[$i]);
			if (31 < $ord && $ord < 61 || 61 < $ord && $ord < 127) {
				if ($line === 75) {
					$line = 0;
					$return .= '=' . "\r\n";
				}
				$line++;
				$return .= $str[$i];
			} else {
				if ($line > 72) {
					$line = 0;
					$return .= '=' . "\r\n";
				}
				$line += 3;
				$return .= '=' . /* utf8 */ strtoupper(bin2hex($str[$i]));
			}
		}
		return $return;
	}
}

// Support PHP_EOL (PHP < 5.0.2)
if (defined('PHP_EOL') === false) {
	if ( /* utf8 */ strtolower(substr(PHP_OS, 0, 3)) === 'win') {
		define('PHP_EOL', "\r\n");
	} else if ( /* utf8 */ strtolower(substr(PHP_OS, 0, 3)) === 'mac') {
		define('PHP_EOL', "\r");
	} else {
		define('PHP_EOL', "\n");
	}
}

// Support ENT_IGNORE (PHP < 5.3.0)
@define('ENT_IGNORE', 4);

// Support ENT_* (PHP < 5.4.0)
@define('ENT_DISALLOWED', 128);
@define('ENT_HTML401', 0);
@define('ENT_HTML5', 48);
@define('ENT_SUBSTITUTE', 8);
@define('ENT_XHTML', 32);
@define('ENT_XML1', 16);
?>