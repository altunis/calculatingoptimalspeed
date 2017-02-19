-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.30-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema viraj
--

CREATE DATABASE IF NOT EXISTS viraj;
USE viraj;

--
-- Definition of table `arabalar`
--

DROP TABLE IF EXISTS `arabalar`;
CREATE TABLE `arabalar` (
  `arabaid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `marka` varchar(15) NOT NULL,
  `uzunluk` double NOT NULL,
  `tekeruzunlugu` double NOT NULL,
  `tekergenisligi` double NOT NULL,
  PRIMARY KEY (`arabaid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `arabalar`
--

/*!40000 ALTER TABLE `arabalar` DISABLE KEYS */;
INSERT INTO `arabalar` (`arabaid`,`marka`,`uzunluk`,`tekeruzunlugu`,`tekergenisligi`) VALUES 
 (1,'MAN',7.5,1.6,0.8),
 (2,'Mercedes',8,1.5,0.7),
 (3,'BMC',8.25,0.7,1.6);
/*!40000 ALTER TABLE `arabalar` ENABLE KEYS */;


--
-- Definition of table `virajlar`
--

DROP TABLE IF EXISTS `virajlar`;
CREATE TABLE `virajlar` (
  `virajid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `virajad` varchar(20) NOT NULL,
  `surtunmekatsayisi` double NOT NULL,
  `egim` double NOT NULL,
  `yaricap` double NOT NULL,
  PRIMARY KEY (`virajid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `virajlar`
--

/*!40000 ALTER TABLE `virajlar` DISABLE KEYS */;
INSERT INTO `virajlar` (`virajid`,`virajad`,`surtunmekatsayisi`,`egim`,`yaricap`) VALUES 
 (1,'Baglarbasi Viraji',0.4,20,35),
 (2,'Ataevler Viraji',0.3,35,40),
 (3,'F.S.M. Kavsagi',0.5,30,40);
/*!40000 ALTER TABLE `virajlar` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
