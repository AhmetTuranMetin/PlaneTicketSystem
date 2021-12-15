-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: ucakbileti
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bilet`
--

DROP TABLE IF EXISTS `bilet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bilet` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ucusId` int NOT NULL,
  `uyeId` int NOT NULL,
  `koltukNo` varchar(18) COLLATE utf8_turkish_ci DEFAULT NULL,
  `tip` varchar(25) COLLATE utf8_turkish_ci DEFAULT NULL,
  `paket` varchar(25) COLLATE utf8_turkish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ucusId` (`ucusId`),
  KEY `uyeId` (`uyeId`),
  CONSTRAINT `bilet_ibfk_1` FOREIGN KEY (`ucusId`) REFERENCES `ucus` (`iducus`),
  CONSTRAINT `bilet_ibfk_2` FOREIGN KEY (`uyeId`) REFERENCES `uye` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bilet`
--

LOCK TABLES `bilet` WRITE;
/*!40000 ALTER TABLE `bilet` DISABLE KEYS */;
INSERT INTO `bilet` VALUES (97,21,12,'5 B','Sat?n Al','Avantaj (Fiyata  30 TL)'),(98,20,12,'Koltuk Secilmedi','Rezervasyon','Standart'),(99,19,13,'Koltuk Secilmedi','Sat?n Al','Standart'),(100,21,13,'2 F','Sat?n Al','Avantaj (Fiyata  30 TL)'),(101,20,13,'Koltuk Secilmedi','Rezervasyon','Standart');
/*!40000 ALTER TABLE `bilet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-14 19:50:13
