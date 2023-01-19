-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: rentcar
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `mantenimiento`
--
CREATE TABLE rentcar;

USE rentcar;

DROP TABLE IF EXISTS `mantenimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mantenimiento` (
  `mantenimiento_id` int NOT NULL AUTO_INCREMENT,
  `mantenimiento_date` datetime(6) DEFAULT NULL,
  `total` decimal(19,2) DEFAULT NULL,
  `vehiculo_id` int DEFAULT NULL,
  PRIMARY KEY (`mantenimiento_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mantenimiento`
--

LOCK TABLES `mantenimiento` WRITE;
/*!40000 ALTER TABLE `mantenimiento` DISABLE KEYS */;
INSERT INTO `mantenimiento` VALUES (2,'2023-01-19 03:42:41.198000',99999.00,1),(3,'2023-01-19 03:42:41.198000',22222.00,1),(4,'2023-01-19 03:47:33.669000',878787.36,1),(5,'2023-01-19 13:20:35.139000',96666.36,1);
/*!40000 ALTER TABLE `mantenimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculo` (
  `vehiculo_id` int NOT NULL AUTO_INCREMENT,
  `anio` varchar(255) DEFAULT NULL,
  `cilindrada` decimal(19,2) DEFAULT NULL,
  `kilometraje` decimal(19,2) DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `patente` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vehiculo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
INSERT INTO `vehiculo` VALUES (1,'2023',8.00,36000.00,'Nissan','VANETTE','DDD-6');
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo_detalle`
--

DROP TABLE IF EXISTS `vehiculo_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculo_detalle` (
  `vehiculo_detalle_id` int NOT NULL AUTO_INCREMENT,
  `capacidad_maletero` decimal(19,2) DEFAULT NULL,
  `capacidad_toneladas` decimal(19,2) DEFAULT NULL,
  `ejes` int DEFAULT NULL,
  `pasajeros` int DEFAULT NULL,
  `puerta` int DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `vehiculo_detalle_tipo` varchar(255) DEFAULT NULL,
  `vehiculo_vehiculo_id` int DEFAULT NULL,
  PRIMARY KEY (`vehiculo_detalle_id`),
  KEY `FK70ap3mgjl8w5rxnj7uwk9qe9o` (`vehiculo_vehiculo_id`),
  CONSTRAINT `FK70ap3mgjl8w5rxnj7uwk9qe9o` FOREIGN KEY (`vehiculo_vehiculo_id`) REFERENCES `vehiculo` (`vehiculo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo_detalle`
--

LOCK TABLES `vehiculo_detalle` WRITE;
/*!40000 ALTER TABLE `vehiculo_detalle` DISABLE KEYS */;
INSERT INTO `vehiculo_detalle` VALUES (1,0.00,5.00,9,2,1,'REDNDO','CAMION',1);
/*!40000 ALTER TABLE `vehiculo_detalle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-19 17:27:25
