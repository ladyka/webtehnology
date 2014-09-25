-- MySQL dump 10.13  Distrib 5.5.38, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: work2v6
-- ------------------------------------------------------
-- Server version	5.5.38-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `shipment`
--

DROP TABLE IF EXISTS `shipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `description` text NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment`
--

LOCK TABLES `shipment` WRITE;
/*!40000 ALTER TABLE `shipment` DISABLE KEYS */;
INSERT INTO `shipment` VALUES (1,'Бетономешалка Park 74008','Бетономешалка оснащена двигателем 220V/50 Гц, мощностью 0,22 кВт. Емкость барабана 63 литра. Рычаг механизма наклона. Венец из чугунного сплава. Двойная электрозащита IP44D. Габариты: 111х55х93.5 см. Вес 27 кг.',1890000),(2,'Бетономешалка Limex 125LP','Бетономешалка с разборной стальной чашей с пластиковым венцом. Объем чаши 130 л. Асинхронный двигатель с фазосдвигающим конденсатором.',3246000),(3,'Бетономешалка ECO CM-140','Бетономешалка с электрическим приводом предназначена для перемешивания сухих материалов и приготовления цементных и цементно-известковых смесей. Чугунный венец. Объем барабана 140 л, мощность 650 Вт. Объем готовой смеси: 90 л. Электропитание: 230В/50Гц.',2809000);
/*!40000 ALTER TABLE `shipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipmentorder`
--

DROP TABLE IF EXISTS `shipmentorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipmentorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `comment` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipmentorder`
--

LOCK TABLES `shipmentorder` WRITE;
/*!40000 ALTER TABLE `shipmentorder` DISABLE KEYS */;
INSERT INTO `shipmentorder` VALUES (1,'2014-09-19 12:18:09','first'),(2,'2014-09-19 12:18:22','second'),(3,'2014-09-20 12:18:26','third'),(4,'2014-09-21 12:18:35','zero');
/*!40000 ALTER TABLE `shipmentorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipmentorder_has_shipment`
--

DROP TABLE IF EXISTS `shipmentorder_has_shipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipmentorder_has_shipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `SHIPMENTORDER_id` int(11) NOT NULL,
  `SHIPMENT_id` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_SHIPMENTORDER_has_SHIPMENT_SHIPMENT1_idx` (`SHIPMENT_id`),
  KEY `fk_SHIPMENTORDER_has_SHIPMENT_SHIPMENTORDER_idx` (`SHIPMENTORDER_id`),
  CONSTRAINT `fk_SHIPMENTORDER_has_SHIPMENT_SHIPMENTORDER` FOREIGN KEY (`SHIPMENTORDER_id`) REFERENCES `shipmentorder` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_SHIPMENTORDER_has_SHIPMENT_SHIPMENT1` FOREIGN KEY (`SHIPMENT_id`) REFERENCES `shipment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipmentorder_has_shipment`
--

LOCK TABLES `shipmentorder_has_shipment` WRITE;
/*!40000 ALTER TABLE `shipmentorder_has_shipment` DISABLE KEYS */;
INSERT INTO `shipmentorder_has_shipment` VALUES (1,1,1,2),(2,1,2,1),(3,2,3,2),(4,3,1,4),(5,4,2,1),(6,4,3,2),(7,4,1,10),(8,1,3,5);
/*!40000 ALTER TABLE `shipmentorder_has_shipment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-09-25 22:09:45
