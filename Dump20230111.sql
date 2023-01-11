-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: sql.freedb.tech    Database: freedb_rprprojekat
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `APPOINTMENTS`
--

DROP TABLE IF EXISTS `APPOINTMENTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `APPOINTMENTS` (
  `appointments_id` int NOT NULL,
  `service` varchar(45) NOT NULL,
  `time` date NOT NULL,
  `duration` int NOT NULL,
  `price` varchar(45) NOT NULL,
  `user_id` int NOT NULL,
  `stylist_id` int NOT NULL,
  PRIMARY KEY (`appointments_id`),
  KEY `user_id_idx` (`user_id`),
  KEY `stylist_id_idx` (`stylist_id`),
  CONSTRAINT `stylist_id` FOREIGN KEY (`stylist_id`) REFERENCES `STYLIST` (`stylist_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `USER` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `APPOINTMENTS`
--

LOCK TABLES `APPOINTMENTS` WRITE;
/*!40000 ALTER TABLE `APPOINTMENTS` DISABLE KEYS */;
/*!40000 ALTER TABLE `APPOINTMENTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `STYLIST`
--

DROP TABLE IF EXISTS `STYLIST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `STYLIST` (
  `stylist_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  PRIMARY KEY (`stylist_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `STYLIST`
--

LOCK TABLES `STYLIST` WRITE;
/*!40000 ALTER TABLE `STYLIST` DISABLE KEYS */;
INSERT INTO `STYLIST` VALUES (1,'Nejra','Adilovic','062877807');
/*!40000 ALTER TABLE `STYLIST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER`
--

DROP TABLE IF EXISTS `USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `USER` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `admin` tinyint NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER`
--

LOCK TABLES `USER` WRITE;
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;
INSERT INTO `USER` VALUES (1,'Edwin','Graca','egraca@etf.unsa.ba','062877807','edwingraca','edwingraca',0),(2,'Tajra','Selimovic','tselimovic2@etf.unsa.ba','062877807','tajraselimovic','tselimovic2',0),(3,'Ilhan','Hasicic','ihasicic1@etf.unsa.ba','062877807','1234567890','ihasicic1',0),(4,'Dalila','Kršlak','dkrslak1@etf.unsa.ba','060236070','daliladalila','dkrslak1',0),(5,'Nejra','Adilovic','nadilovic2@etf.unsa.ba','062877807','nejra1234','nadilovic2',1),(6,'Sara','Biogradlic','sbiogradlic@etf.unsa.ba','061234567','sarasara','sbiogradlic',0);
/*!40000 ALTER TABLE `USER` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-11 11:43:23
