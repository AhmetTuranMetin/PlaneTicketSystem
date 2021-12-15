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
-- Table structure for table `uye`
--

DROP TABLE IF EXISTS `uye`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uye` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rol` varchar(10) NOT NULL,
  `tc` varchar(11) NOT NULL,
  `ad` varchar(50) NOT NULL,
  `cinsiyet` varchar(7) NOT NULL,
  `yas` int NOT NULL,
  `dTarih` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `sifre` varchar(18) NOT NULL,
  PRIMARY KEY (`id`,`tc`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uye`
--

LOCK TABLES `uye` WRITE;
/*!40000 ALTER TABLE `uye` DISABLE KEYS */;
INSERT INTO `uye` VALUES (2,'Admin','26455480914','Ahmet Turan Metin','Erkek',22,'1999-12-14','admin@gmail.com','1818'),(12,'Üye','00011122233','Hasan Kaya','Erkek',41,'1980-02-11','atm180641@gmail.com','1234'),(13,'Üye','00000000000','Aylin Pekmez','Kadın',25,'1996-06-06','ahmetturanmetin18@gmail.com','0000');
/*!40000 ALTER TABLE `uye` ENABLE KEYS */;
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
