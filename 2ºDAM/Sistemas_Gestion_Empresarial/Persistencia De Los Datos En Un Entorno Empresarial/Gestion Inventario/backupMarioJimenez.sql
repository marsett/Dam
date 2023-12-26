-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema bdgestion
--

CREATE DATABASE IF NOT EXISTS bdMarioJimenez;
USE bdMarioJimenez;

--
-- Definition of table `articulos`
--

DROP TABLE IF EXISTS `articulos`;
CREATE TABLE `articulos` (
  `codigoArticulo` int(10) unsigned NOT NULL auto_increment,
  `descripcionArticulo` varchar(45) NOT NULL,
  `marcaArticulo` varchar(45) NOT NULL,
  `modeloArticulo` varchar(45) NOT NULL,
  `tipoArticulo` varchar(45) NOT NULL,
  `referenciaArticulo` varchar(45) NOT NULL,
  PRIMARY KEY  (`codigoArticulo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `articulos`
--

/*!40000 ALTER TABLE `articulos` DISABLE KEYS */;
/*!40000 ALTER TABLE `articulos` ENABLE KEYS */;


--
-- Definition of table `fichasinventario`
--

DROP TABLE IF EXISTS `fichasinventario`;
CREATE TABLE `fichasinventario` (
  `codigoArticulo` int(10) unsigned NOT NULL auto_increment,
  `fechaFichaInventario` varchar(45) NOT NULL,
  `precioFichaInventario` double NOT NULL,
  `ubicacionFichaInventario` varchar(45) NOT NULL,
  `codigoFicha` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`codigoFicha`),
  KEY `codigoArticulo` (`codigoArticulo`),
  CONSTRAINT `codigoArticulo` FOREIGN KEY (`codigoArticulo`) REFERENCES `articulos` (`codigoArticulo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fichasinventario`
--

/*!40000 ALTER TABLE `fichasinventario` DISABLE KEYS */;
/*!40000 ALTER TABLE `fichasinventario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
