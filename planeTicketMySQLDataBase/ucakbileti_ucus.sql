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
-- Table structure for table `ucus`
--

DROP TABLE IF EXISTS `ucus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ucus` (
  `iducus` int NOT NULL AUTO_INCREMENT,
  `kalkis` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `varis` varchar(50) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `tarih` date NOT NULL,
  `saat` varchar(10) COLLATE utf8_turkish_ci NOT NULL,
  `kalkisHavaalani` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `varisHavaalani` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `fiyat` decimal(5,2) NOT NULL,
  `firma` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  PRIMARY KEY (`iducus`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ucus`
--

LOCK TABLES `ucus` WRITE;
/*!40000 ALTER TABLE `ucus` DISABLE KEYS */;
INSERT INTO `ucus` VALUES (19,'Ankara','İzmir','2021-12-14','20:00','Ankara Esenboğa Havaalanı','Adnan Menderes Havaalanı',350.00,'Pegasus'),(20,'Kastamonu','Ankara','2021-12-17','17:30','Kastamonu Havaalanı','Esenboğa Havaalanı',349.99,'Anadolu Jet'),(21,'Ankara','İstanbul','2021-12-20','18:00','Ankara Esenboğa Havaalanı','Sabiha Gökçen Havaalanı',400.00,'SunExpress');
/*!40000 ALTER TABLE `ucus` ENABLE KEYS */;
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
