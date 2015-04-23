-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 23. Apr 2015 um 13:19
-- Server Version: 10.0.17-MariaDB-1~trusty-log
-- PHP-Version: 5.5.9-1ubuntu4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `FahrradKonfi`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `AdresseT`
--

CREATE TABLE IF NOT EXISTS `AdresseT` (
  `A_ID` int(11) NOT NULL AUTO_INCREMENT,
  `A_strasse` varchar(127) NOT NULL,
  `A_hausnummer` int(6) NOT NULL,
  `A_plz` int(11) NOT NULL,
  `A_Stadt` varchar(32) NOT NULL,
  `A_adresszusatz` varchar(63) NOT NULL,
  PRIMARY KEY (`A_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `BeschreibungT`
--

CREATE TABLE IF NOT EXISTS `BeschreibungT` (
  `B_ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`B_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `FelgenT`
--

CREATE TABLE IF NOT EXISTS `FelgenT` (
  `F_ID` int(11) NOT NULL AUTO_INCREMENT,
  `F_bild` varchar(127) NOT NULL,
  `F_BESCH` int(11) NOT NULL,
  PRIMARY KEY (`F_ID`),
  KEY `F_BESCH` (`F_BESCH`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `GabelT`
--

CREATE TABLE IF NOT EXISTS `GabelT` (
  `G_ID` int(11) NOT NULL AUTO_INCREMENT,
  `G_bild` varchar(127) NOT NULL,
  `G_BESCH` int(11) NOT NULL,
  PRIMARY KEY (`G_ID`),
  KEY `G_BESCH` (`G_BESCH`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `KundeT`
--

CREATE TABLE IF NOT EXISTS `KundeT` (
  `K_ID` int(11) NOT NULL AUTO_INCREMENT,
  `K_vorname` varchar(63) NOT NULL,
  `K_nachname` varchar(63) NOT NULL,
  `K_passwort` varchar(127) NOT NULL,
  `K_email` varchar(63) NOT NULL,
  `K_adresse` int(11) NOT NULL,
  `K_telefon` int(11) NOT NULL,
  PRIMARY KEY (`K_ID`),
  UNIQUE KEY `K_email` (`K_email`),
  KEY `K_adresse` (`K_adresse`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `MantelT`
--

CREATE TABLE IF NOT EXISTS `MantelT` (
  `M_ID` int(11) NOT NULL AUTO_INCREMENT,
  `M_bild` varchar(127) NOT NULL,
  `M_BESCH` int(11) NOT NULL,
  PRIMARY KEY (`M_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `RahmenT`
--

CREATE TABLE IF NOT EXISTS `RahmenT` (
  `R_ID` int(11) NOT NULL AUTO_INCREMENT,
  `R_hoehe` int(3) NOT NULL,
  `R_form` varchar(32) NOT NULL,
  `R_reifengröße` int(3) NOT NULL,
  `R_bild` varchar(127) NOT NULL,
  `R_BESCH` int(11) NOT NULL,
  PRIMARY KEY (`R_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `SattelT`
--

CREATE TABLE IF NOT EXISTS `SattelT` (
  `S_ID` int(11) NOT NULL AUTO_INCREMENT,
  `S_bild` varchar(127) NOT NULL,
  `S_BESCH` int(11) NOT NULL,
  PRIMARY KEY (`S_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `TeileT`
--

CREATE TABLE IF NOT EXISTS `TeileT` (
  `T_ID` int(11) NOT NULL AUTO_INCREMENT,
  `T_bild` varchar(127) NOT NULL,
  `T_BESCH` int(11) NOT NULL,
  PRIMARY KEY (`T_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `VorbauT`
--

CREATE TABLE IF NOT EXISTS `VorbauT` (
  `V_ID` int(11) NOT NULL AUTO_INCREMENT,
  `V_bild` varchar(127) NOT NULL,
  `V_BESCH` int(11) NOT NULL,
  PRIMARY KEY (`V_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `FelgenT`
--
ALTER TABLE `FelgenT`
  ADD CONSTRAINT `FelgenT_ibfk_1` FOREIGN KEY (`F_BESCH`) REFERENCES `BeschreibungT` (`B_ID`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `GabelT`
--
ALTER TABLE `GabelT`
  ADD CONSTRAINT `GabelT_ibfk_1` FOREIGN KEY (`G_BESCH`) REFERENCES `BeschreibungT` (`B_ID`) ON DELETE NO ACTION;

--
-- Constraints der Tabelle `KundeT`
--
ALTER TABLE `KundeT`
  ADD CONSTRAINT `KundeT_ibfk_1` FOREIGN KEY (`K_adresse`) REFERENCES `AdresseT` (`A_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
