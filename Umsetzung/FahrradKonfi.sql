-- phpMyAdmin SQL Dump
-- version 4.4.3
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 18. Jun 2015 um 17:01
-- Server-Version: 5.5.43-0ubuntu0.14.04.1
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
  `A_ID` int(11) NOT NULL,
  `A_strasse` varchar(127) NOT NULL,
  `A_hausnummer` int(6) NOT NULL,
  `A_plz` int(11) NOT NULL,
  `A_Stadt` varchar(32) NOT NULL,
  `A_adresszusatz` varchar(63) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `AdresseT`
--

INSERT INTO `AdresseT` (`A_ID`, `A_strasse`, `A_hausnummer`, `A_plz`, `A_Stadt`, `A_adresszusatz`) VALUES
(1, 'Dada Straße', 1, 10000, 'Dadamstadt', 'Damnit!'),
(4, 'Ja...hm.. Berliner tor glaub ich', 234, 20223, 'HambuuuuuuuurgNicht!', 'UzUz2'),
(19, '123', 123, 123, '123', ''),
(20, '213', 123, 123, '', '');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `BeschreibungT`
--

CREATE TABLE IF NOT EXISTS `BeschreibungT` (
  `B_ID` int(11) NOT NULL,
  `B_text` text NOT NULL,
  `B_kurzbesch` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `BeschreibungT`
--

INSERT INTO `BeschreibungT` (`B_ID`, `B_text`, `B_kurzbesch`) VALUES
(1, 'Dieser Rahmen wurde speziell auf die Wünsche eines gemütlichen Fahrers zugeschnitten. Die einmalig schnittige Form, macht den Rahmen zu den Besten seiner Klasse, eigentlich schon eine eigene Klasse für sich.\r\nWenn sie es liebten, sich in aller Ruhe und Entspannung auf den Weg zu machen, so haben sie Ihren Rahmen gefunden.', 'Gemütliches Fahrrad zum Fahren in der Stadt, oder auf der Bundesbahn.\r\nGenießen Sie das Schöne Wetter, uns fahren sie ihren Ziel entgegen.'),
(2, 'Die einzigartige Arluminiumstahllegierung hilft den Rahmen, doch leicht zu sein, aber auch viel auszuhalten. Niemand wird es je schaffen, diesen Rahmen zu biegen oder zu brechen (es sei denn es handelt sich um ein Auto, LKW, Motorrad, Motorboot, Segelboot, Lastkran, LF16, LF20, SW, Fußgänger, Steinchen, Steine, Meteoren, Pacman, Bilderrahmen, Glas, Laptops, Banken, Geldscheinen [Vorzugweise 500er Scheine], sowie alle Dingen, die mit Kohlenstoff oder den Periodensystem der Elemente zu tun haben). Das einmalige Design (Made with Paint form MiniSoft Doorswof) bietet die die volle Unterstützung auf allen ihren Fahrten.', 'Das sportliche Fahrrad für lange Wegstrecken.\r\nWindschnittig und leicht.'),
(3, 'Ein wahrer Klassiker, kein Mountainbike Rahmen wurde öfter verkauft, laut einer Umfrage (5 von 9 befragten kauften diesen Rahmen). Es ist einer der Stabilsten Rahmen auf den Markt, keiner Kann ihn wieder stehen, keiner kann sich ihn widersetzen. Mit seinen 30kg Eigengewicht, zerstört er noch so störrischen Ast auf den Weg oder auch Fußgänger.\r\nHergestellt von RahmendotCorp in einer kleine Holzhütte in Neuseeland aus alten Einkaufwagen, was will man mehr?', 'Der Klassiker unter den Bergfahrern. \r\nStabil, gefedert, dicke Reifen.'),
(4, 'Was ist besser als das Alte? Natürlich das Neue. Neue Aerodynamik, neue Dämpfer, einfach ein neues Erlebnis auf Feld, Wiese und Berge. Fahren sie ihre Lieblingsstrecke mit neuen Geschwindigkeiten. Im Gegensatz zu unseren Klassik Modell wiegt dieser Rahmen nur 15kg, das ist ein Ersparnis von 50% des Gewichtes.', 'Das neue Modell.\r\nBessere Aerodynamik, bessere Dämpfung.'),
(5, 'Sie kennen ihre Sanfte Federung von ihrem Kissen und wünschten sich, ihr Fahrrad könnte das gleiche? Dank der neuen FederSanftTM Technologie von SanfteFederFürAlleUndDichOhneNachteile, ist das möglich. Vergessen sie die alten Methoden über Ölbeckenfederung oder Luftfederung. Diese Technologie greift auf Ökologisch produzierte Gänsefedern zurück (die Gänse wachsen glücklich auf!), und baut sie mittels eines einzigartigen Konstrukts in die Gabel ein. So sorgen diese Feder hier, wie auch in ihren Bett oder sonst wo für eine Sanfte Federung.', 'Neue FederSanftTM Technologie.\r\nRustikal, robust, stabil, unzerstörbar, gefedert (mit Gänsefedern).'),
(6, 'Eine weiterer Fortschritt in der Gabel Technologie. Eine neue zylinderförmige Konstruktion, in welcher Öl und eine Stahlfeder liegt, bietet Komfort beim fahren. Ebenfalls ist dank des Smartclose Systems kein unnötiges nach vorn beugen mehr notwendig, um die Gabel Starr zu stellen. Ganz simpel den Knopf am Lenker betätigen und ihre Smartclose System Gabel stellt sich starr.', 'Feder im offenen Ölbecken.\r\nSmartclose System.'),
(7, 'Einfach klassisch. Eine Starrgabel ist immer der richtige Weg für die Stadt. Sie ist sehr leicht und bietet damit nicht das Gewichtsproblem anderer Gabeln.', 'Starr, hart, klassisch.\r\nLeicht und funktionell.'),
(8, 'Reine Stahlfelgen waren mal Out. Doch heutzutage ist es umso wichtiger eine stabile Felge zu besitzen. In Zeiten der Schlaglöcher auf Fahrradwegen, die die Felgen zusätzlich belasten, kann man auf diese Felgen nicht verzichten. Der verbaute deutsche Qualitätsstahl (Import aus Südost Neuseeland) trägt gravierend zur Stabilität bei. Neben seine Beständigkeit gegen Wind, hilft diese Felge ebenfalls durch seine runde Form bei der Fortbewegung.', 'Hochwertiger deutscher Qualitätsstahl.\r\nElegant und subtil.'),
(9, 'Eine leichte Felge aus Aluminium. Diese Hohlkammerfelge bietet ein exzellentes Gewicht und sorgt so für einen schnellen Antrieb. Je leichter ihr Fahrrad, desto weniger müssen sie voran treiben. Mit dieser Felge stellt sich ihnen nichts in den Weg, die Hohlkammer Felge bietet ihnen durch den parabelförmigen Aufbau die Beste Stabilität zum besten Gewicht.', 'Reis fest leicht, generisch.\r\nDie Felge für viele Wege.'),
(10, 'Ein neuer Mantel, mit alter Technologie. Doch alt ist doch nicht schlimm, sondern sehr oft auch besser. Dies trifft sicherlich auf diesen Mantel zu. Er besteht aus einer geheimen Mixtur aus verschiedenen Gummisorte (alte Autoreifen bevorzugt). Der größte Vorteil bleibt dennoch die Unplattbarkeit des Reifens. Dieser benötigt keinen Schlauch mehr, sondern besteht nur aus den Mantel. Der Mantel selbst ist vollgummi. So ersparen sie sich das lästige nach hause schieben mit einen platten Reifen. Durch die Dauerhafte Festigkeit des Mantels haben sie auch einen sehr geringen Rollwiderstand, der das zusätzliche Gewicht ausgleicht.', 'Unplattbar (manchmal), kein aufpumpen mehr.\r\nGeringer Rollwiederstand.'),
(11, 'Mit der neuen Schneeketten Technologie für Fahrradmäntel sind sie auch für den Tiefsten Winter ausgestattet. Die befestigten Schneeketten, sorgen für halt auf jeden Eis. Aus rechtlichen Gründen sollten sie aber meiden, nicht vereiste Wege damit zu benutzen.', 'Selbst im Winter schnell.\r\nStoppbar, auch auf Eis.'),
(12, 'Der Standard auf jeden besseren Tourenrad. Dieser Mantel bietet viel Sicherheit auf vielen Touren rund um den Globus. Er rollt nicht nur gut, sondern ist mit vielen Wassern gewaschen. Eine extra 3mm dicke Zusatzschicht bietet zusätzlichen Schutz vor den Übeln der Straße.', 'Schnell leicht, Dick.\r\nIn vielen Fällen unplattbar.'),
(13, 'Der einzigartige Kuscheligion. Unser erster Sattel nur aus Wolle und ohne Zusatzstoffe (exklusive Heißkleber). Für lange Fahrten nicht geeignet, doch in der Kürze liegt ja bekanntlich die Würze...', 'Weich, kuschelig, beliebt.\r\nWie auf Wolke Sieben'),
(14, 'Dieser Sattel ist was für wahre Fans von Bequemlichkeit und Stil. Seine Gel-Schicht sorgt auch auf mittleren Strecken für angenehmes Fahren. Ein muss für jede Tour.', 'Style wie mit CSS, Elegant wie HTML5.\r\nSportlich, allwetter- tauglich.'),
(15, 'Ein höchst fortschrittlicher  Helm, der sie in jeder Lebenslage schützt vor jeden Schaden (am Kopf. Bitte beachten sie, dass evtl. Unfälle trotz des Helms tödlich enden können. Dieser Helm dient lediglich zur schau und bietet keine Sicherheit auf regulären Fahrten.)', 'Sicher unterwegs.\r\nLeicht und Stabil.'),
(16, 'Dieser stylischer Lenker, welcher in Holland (Niederlande) designt wurde, ist das Absolute must hav'' bei jeden Stadtrad. Auch wenn sein Gewicht (mit 10kg) relativ hoch ist, so bietet er die Nötige Standfestigkeit, um auch gegen LKW zu bestehen. Evtl. sollte man aber mit der Vorderbremse aufpassen...', 'Stadttauglich, design in Holland.\r\nAuf jeder Straße ein must hav''.');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `FelgenT`
--

CREATE TABLE IF NOT EXISTS `FelgenT` (
  `F_ID` int(11) NOT NULL,
  `F_bild` varchar(127) NOT NULL,
  `F_BESCH` int(11) NOT NULL,
  `F_preis` int(11) NOT NULL,
  `F_reifengroesse` int(3) NOT NULL,
  `F_name` varchar(128) NOT NULL,
  `F_narbendynamo` tinyint(1) NOT NULL,
  `F_formTyp` int(11) NOT NULL,
  `F_formTypID` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `FelgenT`
--

INSERT INTO `FelgenT` (`F_ID`, `F_bild`, `F_BESCH`, `F_preis`, `F_reifengroesse`, `F_name`, `F_narbendynamo`, `F_formTyp`, `F_formTypID`) VALUES
(1, '', 8, 60, 28, 'Stahliodraht 28"', 1, 28, 8),
(2, '', 8, 60, 26, 'Stahliodraht 26"', 1, 26, 9),
(3, '', 9, 80, 26, 'Swissalu 26"', 1, 26, 9),
(4, '', 9, 80, 28, 'Swissalu 28"', 1, 28, 8);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `FormTypT`
--

CREATE TABLE IF NOT EXISTS `FormTypT` (
  `Fo_ID` int(11) NOT NULL,
  `Fo_gabel` int(11) NOT NULL,
  `Fo_felgen` int(11) NOT NULL,
  `Fo_vorbau` int(11) NOT NULL,
  `Fo_mantel` int(11) NOT NULL,
  `Fo_rahmen` int(11) NOT NULL,
  `Fo_teile` int(11) NOT NULL,
  `Fo_sattel` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `FormTypT`
--

INSERT INTO `FormTypT` (`Fo_ID`, `Fo_gabel`, `Fo_felgen`, `Fo_vorbau`, `Fo_mantel`, `Fo_rahmen`, `Fo_teile`, `Fo_sattel`) VALUES
(1, 1, 28, 1, 28, -1, 0, 0),
(2, 18, 28, 18, 28, -1, 0, 0),
(3, 18, 26, 18, 26, -1, 0, 0),
(4, 18, 26, 18, 26, -1, 0, 0),
(5, -1, 26, 18, 26, 0, 0, 0),
(6, -1, 28, 18, 28, 0, 0, 0),
(7, -1, 28, 1, 28, 0, 0, 0),
(8, 0, -1, 0, 28, 0, 0, 0),
(9, 0, -1, 0, 26, 0, 0, 0),
(10, 0, 26, 0, -1, 0, 0, 0),
(11, 0, 28, 0, -1, 0, 0, 0),
(12, 0, 0, 0, 0, 0, 0, -1),
(13, 0, 0, 0, 0, 0, 0, 0),
(14, 1, 0, -1, 0, 0, 0, 0),
(15, 18, 0, -1, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `GabelT`
--

CREATE TABLE IF NOT EXISTS `GabelT` (
  `G_ID` int(11) NOT NULL,
  `G_bild` varchar(127) NOT NULL,
  `G_BESCH` int(11) NOT NULL,
  `G_formTyp` int(11) NOT NULL,
  `G_formTypID` int(11) NOT NULL,
  `G_schaftlaenge` int(11) NOT NULL,
  `G_steuersatz` int(11) NOT NULL,
  `G_felgenbrems` tinyint(1) NOT NULL,
  `G_scheibenbrems` tinyint(1) NOT NULL,
  `G_licht` tinyint(1) NOT NULL,
  `G_reifengroesse` int(3) NOT NULL,
  `G_preis` int(11) NOT NULL,
  `G_name` varchar(256) NOT NULL,
  `G_farbe` varchar(256) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `GabelT`
--

INSERT INTO `GabelT` (`G_ID`, `G_bild`, `G_BESCH`, `G_formTyp`, `G_formTypID`, `G_schaftlaenge`, `G_steuersatz`, `G_felgenbrems`, `G_scheibenbrems`, `G_licht`, `G_reifengroesse`, `G_preis`, `G_name`, `G_farbe`) VALUES
(1, '', 5, 18, 5, 400, 18, 1, 1, 1, 26, 120, 'Helly Yeah', ''),
(2, '', 6, 18, 6, 400, 18, 1, 0, 1, 28, 130, 'FACK', ''),
(3, '', 7, 1, 7, 300, 1, 1, 0, 1, 28, 30, 'YOU', '');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `KundeT`
--

CREATE TABLE IF NOT EXISTS `KundeT` (
  `K_ID` int(11) NOT NULL,
  `K_vorname` varchar(63) NOT NULL,
  `K_nachname` varchar(63) NOT NULL,
  `K_passwort` varchar(127) NOT NULL,
  `K_email` varchar(63) NOT NULL,
  `K_adresse` int(11) NOT NULL,
  `K_telefon` int(11) NOT NULL,
  `K_gebdatum` varchar(11) NOT NULL,
  `K_anrede` varchar(12) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `KundeT`
--

INSERT INTO `KundeT` (`K_ID`, `K_vorname`, `K_nachname`, `K_passwort`, `K_email`, `K_adresse`, `K_telefon`, `K_gebdatum`, `K_anrede`) VALUES
(1, 'Dada', 'Dumdum', 'kenntKeiner', 'dada@dumdum.de', 1, 123, '', ''),
(2, 'Herbert', 'Lappen', 'wie Passwort?', 'MeineMail@Da.bitte', 4, 2147483647, '', ''),
(5, 'Ichbins', 'Duda', '12345', 'hallo@dude.de', 19, 451, '1223321', 'Herr'),
(9, 'alkjnd', 'aslkdn', 'lkjand', 'asjdn', 19, 1231, 'asldkn', '');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `MantelT`
--

CREATE TABLE IF NOT EXISTS `MantelT` (
  `M_ID` int(11) NOT NULL,
  `M_bild` varchar(127) NOT NULL,
  `M_BESCH` int(11) NOT NULL,
  `M_name` varchar(128) NOT NULL,
  `M_formTyp` int(11) NOT NULL,
  `M_formTypID` int(11) NOT NULL,
  `M_durchm` int(11) NOT NULL,
  `M_reifengroesse` int(3) NOT NULL,
  `M_preis` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `MantelT`
--

INSERT INTO `MantelT` (`M_ID`, `M_bild`, `M_BESCH`, `M_name`, `M_formTyp`, `M_formTypID`, `M_durchm`, `M_reifengroesse`, `M_preis`) VALUES
(1, '', 10, 'VollgummiProfiler', 28, 11, 200, 28, 33),
(2, '', 10, 'VollgummiProfiler', 26, 10, 200, 26, 33),
(3, '', 11, 'Schneekette', 26, 10, 150, 26, 40),
(4, '', 11, 'Schneekette', 28, 11, 150, 28, 40),
(5, '', 12, 'Strecke', 28, 11, 150, 28, 40),
(6, '', 12, 'Strecke', 26, 10, 150, 26, 40);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `RahmenT`
--

CREATE TABLE IF NOT EXISTS `RahmenT` (
  `R_ID` int(11) NOT NULL,
  `R_hoehe` varchar(256) NOT NULL,
  `R_form` int(11) NOT NULL,
  `R_reifengroesse` int(3) NOT NULL,
  `R_bild` varchar(127) NOT NULL,
  `R_BESCH` int(11) NOT NULL,
  `R_steuersatz` int(11) NOT NULL,
  `R_schafthoehe` int(11) NOT NULL,
  `R_zusatzbefest` int(3) NOT NULL,
  `R_scheibenbrems` tinyint(1) NOT NULL,
  `R_felgenbrems` tinyint(1) NOT NULL,
  `R_tretlager` int(11) NOT NULL,
  `R_formTyp` int(11) NOT NULL,
  `R_formTypID` int(11) NOT NULL,
  `R_name` varchar(128) NOT NULL,
  `R_preis` int(11) NOT NULL,
  `R_gepaektraeger` tinyint(1) NOT NULL,
  `R_licht` tinyint(1) NOT NULL,
  `R_farbe` varchar(256) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `RahmenT`
--

INSERT INTO `RahmenT` (`R_ID`, `R_hoehe`, `R_form`, `R_reifengroesse`, `R_bild`, `R_BESCH`, `R_steuersatz`, `R_schafthoehe`, `R_zusatzbefest`, `R_scheibenbrems`, `R_felgenbrems`, `R_tretlager`, `R_formTyp`, `R_formTypID`, `R_name`, `R_preis`, `R_gepaektraeger`, `R_licht`, `R_farbe`) VALUES
(2, '45#46#47#48#50#52', 0, 28, '', 1, 1, 150, 2, 0, 1, 1, 0, 1, 'Gemütliches Cittybike', 200, 1, 1, 'Orange#Blau#Rot'),
(4, '44#47#50', 0, 28, '', 2, 18, 150, 1, 1, 0, 1, 2, 2, 'Arlu', 200, 0, 1, 'Blau#Rot'),
(5, '47', 0, 26, '', 3, 18, 200, 0, 1, 0, 2, 1, 3, 'Mounti Mount', 300, 0, 0, 'Rot'),
(6, '45', 0, 26, '', 4, 18, 250, 2, 1, 0, 1, 1, 4, 'Mounti Neu Mount', 350, 0, 0, 'Blau');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `SattelT`
--

CREATE TABLE IF NOT EXISTS `SattelT` (
  `S_ID` int(11) NOT NULL,
  `S_bild` varchar(127) NOT NULL,
  `S_BESCH` int(11) NOT NULL,
  `S_name` varchar(128) NOT NULL,
  `S_preis` int(11) NOT NULL,
  `S_formTyp` int(11) NOT NULL,
  `S_formTypID` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `SattelT`
--

INSERT INTO `SattelT` (`S_ID`, `S_bild`, `S_BESCH`, `S_name`, `S_preis`, `S_formTyp`, `S_formTypID`) VALUES
(1, '', 13, 'Kuscheligion', 20, 0, 12),
(2, '', 14, 'Sportife', 20, 0, 12);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `TeileT`
--

CREATE TABLE IF NOT EXISTS `TeileT` (
  `T_ID` int(11) NOT NULL,
  `T_bild` varchar(127) NOT NULL,
  `T_BESCH` int(11) NOT NULL,
  `T_name` varchar(128) NOT NULL,
  `T_preis` int(11) NOT NULL,
  `T_zusatzBelegt` tinyint(1) NOT NULL,
  `T_formTyp` int(11) NOT NULL,
  `T_formTypID` int(11) NOT NULL,
  `T_gepaeck` tinyint(1) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `TeileT`
--

INSERT INTO `TeileT` (`T_ID`, `T_bild`, `T_BESCH`, `T_name`, `T_preis`, `T_zusatzBelegt`, `T_formTyp`, `T_formTypID`, `T_gepaeck`) VALUES
(1, '', 15, 'SicherHelm', 9, 0, 0, 13, 0);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `VorbauT`
--

CREATE TABLE IF NOT EXISTS `VorbauT` (
  `V_ID` int(11) NOT NULL,
  `V_bild` varchar(127) NOT NULL,
  `V_BESCH` int(11) NOT NULL,
  `V_preis` int(11) NOT NULL,
  `V_schaftgroesse` int(11) NOT NULL,
  `V_formTyp` int(11) NOT NULL,
  `V_formTypID` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `VorbauT`
--

INSERT INTO `VorbauT` (`V_ID`, `V_bild`, `V_BESCH`, `V_preis`, `V_schaftgroesse`, `V_formTyp`, `V_formTypID`) VALUES
(1, '', 16, 20, 1, 1, 14),
(2, '', 16, 20, 18, 18, 15);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `AdresseT`
--
ALTER TABLE `AdresseT`
  ADD PRIMARY KEY (`A_ID`);

--
-- Indizes für die Tabelle `BeschreibungT`
--
ALTER TABLE `BeschreibungT`
  ADD PRIMARY KEY (`B_ID`);

--
-- Indizes für die Tabelle `FelgenT`
--
ALTER TABLE `FelgenT`
  ADD PRIMARY KEY (`F_ID`),
  ADD KEY `F_BESCH` (`F_BESCH`),
  ADD KEY `F_formTypID` (`F_formTypID`);

--
-- Indizes für die Tabelle `FormTypT`
--
ALTER TABLE `FormTypT`
  ADD PRIMARY KEY (`Fo_ID`),
  ADD KEY `Fo_ID` (`Fo_ID`);

--
-- Indizes für die Tabelle `GabelT`
--
ALTER TABLE `GabelT`
  ADD PRIMARY KEY (`G_ID`),
  ADD KEY `G_BESCH` (`G_BESCH`),
  ADD KEY `G_formTypID` (`G_formTypID`);

--
-- Indizes für die Tabelle `KundeT`
--
ALTER TABLE `KundeT`
  ADD PRIMARY KEY (`K_ID`),
  ADD UNIQUE KEY `K_email` (`K_email`),
  ADD KEY `K_adresse` (`K_adresse`);

--
-- Indizes für die Tabelle `MantelT`
--
ALTER TABLE `MantelT`
  ADD PRIMARY KEY (`M_ID`),
  ADD KEY `M_BESCH` (`M_BESCH`),
  ADD KEY `M_formTypID` (`M_formTypID`);

--
-- Indizes für die Tabelle `RahmenT`
--
ALTER TABLE `RahmenT`
  ADD PRIMARY KEY (`R_ID`),
  ADD KEY `R_BESCH` (`R_BESCH`),
  ADD KEY `R_formTypID` (`R_formTypID`),
  ADD KEY `R_formTypID_2` (`R_formTypID`);

--
-- Indizes für die Tabelle `SattelT`
--
ALTER TABLE `SattelT`
  ADD PRIMARY KEY (`S_ID`),
  ADD KEY `S_BESCH` (`S_BESCH`),
  ADD KEY `S_formTypID` (`S_formTypID`);

--
-- Indizes für die Tabelle `TeileT`
--
ALTER TABLE `TeileT`
  ADD PRIMARY KEY (`T_ID`),
  ADD KEY `T_BESCH` (`T_BESCH`),
  ADD KEY `T_formTypID` (`T_formTypID`);

--
-- Indizes für die Tabelle `VorbauT`
--
ALTER TABLE `VorbauT`
  ADD PRIMARY KEY (`V_ID`),
  ADD KEY `V_BESCH` (`V_BESCH`),
  ADD KEY `V_formTypID` (`V_formTypID`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `AdresseT`
--
ALTER TABLE `AdresseT`
  MODIFY `A_ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT für Tabelle `BeschreibungT`
--
ALTER TABLE `BeschreibungT`
  MODIFY `B_ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT für Tabelle `FelgenT`
--
ALTER TABLE `FelgenT`
  MODIFY `F_ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT für Tabelle `FormTypT`
--
ALTER TABLE `FormTypT`
  MODIFY `Fo_ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT für Tabelle `GabelT`
--
ALTER TABLE `GabelT`
  MODIFY `G_ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT für Tabelle `KundeT`
--
ALTER TABLE `KundeT`
  MODIFY `K_ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT für Tabelle `MantelT`
--
ALTER TABLE `MantelT`
  MODIFY `M_ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT für Tabelle `RahmenT`
--
ALTER TABLE `RahmenT`
  MODIFY `R_ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT für Tabelle `SattelT`
--
ALTER TABLE `SattelT`
  MODIFY `S_ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT für Tabelle `TeileT`
--
ALTER TABLE `TeileT`
  MODIFY `T_ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT für Tabelle `VorbauT`
--
ALTER TABLE `VorbauT`
  MODIFY `V_ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `FelgenT`
--
ALTER TABLE `FelgenT`
  ADD CONSTRAINT `FelgenT_ibfk_1` FOREIGN KEY (`F_BESCH`) REFERENCES `BeschreibungT` (`B_ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `FelgenT_ibfk_2` FOREIGN KEY (`F_formTypID`) REFERENCES `FormTypT` (`Fo_ID`);

--
-- Constraints der Tabelle `GabelT`
--
ALTER TABLE `GabelT`
  ADD CONSTRAINT `GabelT_ibfk_1` FOREIGN KEY (`G_BESCH`) REFERENCES `BeschreibungT` (`B_ID`) ON DELETE NO ACTION,
  ADD CONSTRAINT `GabelT_ibfk_2` FOREIGN KEY (`G_formTypID`) REFERENCES `FormTypT` (`Fo_ID`);

--
-- Constraints der Tabelle `KundeT`
--
ALTER TABLE `KundeT`
  ADD CONSTRAINT `KundeT_ibfk_1` FOREIGN KEY (`K_adresse`) REFERENCES `AdresseT` (`A_ID`) ON DELETE CASCADE;

--
-- Constraints der Tabelle `MantelT`
--
ALTER TABLE `MantelT`
  ADD CONSTRAINT `MantelT_ibfk_1` FOREIGN KEY (`M_BESCH`) REFERENCES `BeschreibungT` (`B_ID`),
  ADD CONSTRAINT `MantelT_ibfk_2` FOREIGN KEY (`M_formTypID`) REFERENCES `FormTypT` (`Fo_ID`);

--
-- Constraints der Tabelle `RahmenT`
--
ALTER TABLE `RahmenT`
  ADD CONSTRAINT `RahmenT_ibfk_1` FOREIGN KEY (`R_BESCH`) REFERENCES `BeschreibungT` (`B_ID`),
  ADD CONSTRAINT `RahmenT_ibfk_2` FOREIGN KEY (`R_formTypID`) REFERENCES `FormTypT` (`Fo_ID`);

--
-- Constraints der Tabelle `SattelT`
--
ALTER TABLE `SattelT`
  ADD CONSTRAINT `SattelT_ibfk_1` FOREIGN KEY (`S_BESCH`) REFERENCES `BeschreibungT` (`B_ID`),
  ADD CONSTRAINT `SattelT_ibfk_2` FOREIGN KEY (`S_formTypID`) REFERENCES `FormTypT` (`Fo_ID`);

--
-- Constraints der Tabelle `TeileT`
--
ALTER TABLE `TeileT`
  ADD CONSTRAINT `TeileT_ibfk_1` FOREIGN KEY (`T_BESCH`) REFERENCES `BeschreibungT` (`B_ID`),
  ADD CONSTRAINT `TeileT_ibfk_2` FOREIGN KEY (`T_formTypID`) REFERENCES `FormTypT` (`Fo_ID`);

--
-- Constraints der Tabelle `VorbauT`
--
ALTER TABLE `VorbauT`
  ADD CONSTRAINT `VorbauT_ibfk_1` FOREIGN KEY (`V_BESCH`) REFERENCES `BeschreibungT` (`B_ID`),
  ADD CONSTRAINT `VorbauT_ibfk_2` FOREIGN KEY (`V_formTypID`) REFERENCES `FormTypT` (`Fo_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
