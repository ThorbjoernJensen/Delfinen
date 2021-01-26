-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: delfinen_db
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `member_id` int NOT NULL AUTO_INCREMENT,
  `fornavn` text,
  `efternavn` text,
  `adresse` text,
  `postnr` int DEFAULT NULL,
  `by` text,
  `koen` text,
  `engagement` text,
  `medlemstype` text,
  `aargang` int DEFAULT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'Hans','Soerensen','Agernvej 3',3700,'Roenne','m','passiv','motionist',2000),(2,'Jens','Kofoed','Agrevej 5',3700,'Roenne','m','aktiv','konkurrence',2001),(3,'Peter','Lundin','Ahlegaardsvejen 7',3700,'Roenne','m','aktiv','konkurrence',2002),(4,'Frederik','Carlsen','Ahlstrandsvej 12',3700,'Roenne','m','aktiv','konkurrence',2005),(5,'Peter','Petersen','Ahornvej 54',3700,'Roenne','m','aktiv','konkurrence',1999),(6,'Ida','Kofoed','Blekingevej 43',3700,'Roenne','k','aktiv','konkurrence',1999),(7,'Bente','Svendsen','Blemmelyngvejen 32',3700,'Roenne','k','aktiv','motionist',1998),(8,'Tove','Joergensen','Blommehaven 2',3700,'Roenne','k','aktiv','konkurrence',1995),(9,'Soeren','Langeland','Danielstraede 4',3700,'Roenne','m','aktiv','konkurrence',1996),(10,'Jacob','Soerensen','Degnebrovejen 5',3700,'Roenne','m','aktiv','konkurrence',1996),(11,'Nikolaj','Kofoed','Dittes Vej 1',3700,'Roenne','m','aktiv','konkurrence',1970),(12,'Nynne','Sofia','Doktorbakken 112',3700,'Roenne','k','aktiv','konkurrence',1975),(13,'Per','Joergensen','Doktordammen 76',3760,'Gudhjem','m','passiv','konkurrence',1980),(14,'Ole','Lukoeje','Ejnar Jensens Vej 32',3730,'Nexoe','m','aktiv','konkurrence',1985),(15,'Rasmus','Kofoed','Ejnar Mikkelsensvej 6',3740,'Svanneke','m','aktiv','konkurrence',1990),(16,'Jens','Nielsen','Ekkodalsvejen 6',3740,'Svanneke','m','aktiv','motionist',1950),(17,'Marinus','Bastiansen','Elisabetsvej 11',3730,'Nexoe','m','aktiv','konkurrence',1955),(18,'Jesper','Find Nilsen','Ellebakken 4',3760,'Gudhjem','m','aktiv','konkurrence',1958),(19,'Lars','Kofoed','Ellebyvej 56',3740,'Svanneke','m','aktiv','konkurrence',1959),(20,'Soeren','Olsen','Fabriksvej 45',3770,'Allinge','m','aktiv','konkurrence',1960),(21,'Emil','Joergensen','Falckvej 7',3740,'Svanneke','m','aktiv','konkurrence',1954),(22,'Benjamin','Soerensen','Falsterbovej 98',3760,'Gudhjem','m','aktiv','konkurrence',1943),(23,'Rigmor','Jensen','Fasanvangen 8',3782,'Klemmensker','k','aktiv','konkurrence',2000),(24,'Ulrikke','Kofoed','Glappevej 34',3730,'Nexoe','k','aktiv','konkurrence',2001),(25,'Karla','Svendsen','Glastorvet 3',3782,'Klemmensker','k','aktiv','motionist',2002),(26,'Soerine','Olsen','Glasvaerksvej 6',3760,'Gudhjem','k','aktiv','konkurrence',2005),(27,'Magda','Boulet','Glentevangen 8',3782,'Klemmensker','k','aktiv','konkurrence',1999),(28,'Viktor','Soerensen','Godthaabsvej 42',3782,'Klemmensker','m','passiv','konkurrence',1999),(29,'Frank','Kofoed','Hallandsvej 65',3782,'Klemmensker','m','aktiv','konkurrence',1980),(30,'Karl','Nielsen','Hallebakken 87',3760,'Gudhjem','m','aktiv','konkurrence',1985),(31,'Ulrik','Pedersen','Halledalsvej 74',3770,'Allinge','m','aktiv','konkurrence',1990),(32,'Jeppe','Soerensen','Hallegaardsvejen 25',3740,'Svanneke','m','aktiv','konkurrence',1950),(33,'Mathias','Kofoed','Helligdomsvej 67',3700,'Roenne','m','aktiv','konkurrence',1955),(34,'Marcus','Nielsen','Helligpedervej 27',3770,'Allinge','m','aktiv','motionist',1958),(35,'Joshua','Johansen','Helsevej 28',3700,'Roenne','m','aktiv','konkurrence',1959),(36,'Kenneth','Soerensen','Henrik Hansensgade 29',3700,'Roenne','m','aktiv','konkurrence',1980),(37,'Dorthe','Schou','Hentregaardsvej 61',3760,'Gudhjem','k','aktiv','konkurrence',1985),(38,'Dorte','Kofoed','Jomfrudalen 64',3700,'Roenne','k','aktiv','konkurrence',1990),(39,'Johan','Frederiksen','Jomfruskoven 3',3700,'Roenne','m','aktiv','konkurrence',1950),(40,'Johanne','Nielsen','Jomfrustien 14',3730,'Nexoe','k','passiv','konkurrence',1955),(41,'Inger','Lundbaek','Jons Kapelvej 17',3700,'Roenne','k','aktiv','konkurrence',1958),(42,'Rikke','Soerensen','Jordbaerdalen 6',3700,'Roenne','k','aktiv','konkurrence',1959),(43,'Vibeke','Wagener','Jordbaerhaven 8',3700,'Roenne','k','aktiv','motionist',2002),(44,'Charlotte','Nielsen','Knudsvej 10',3700,'Roenne','k','passiv','konkurrence',2005),(45,'Mats','Edin','Kobbevej 62',3770,'Allinge','m','aktiv','konkurrence',1999),(46,'Bjoern','Andersen','Kodalsvejen 12',3770,'Allinge','m','aktiv','konkurrence',1999),(47,'Jakob','Skov','Kofoedsvej 7',3730,'Nexoe','m','aktiv','konkurrence',1998),(48,'Joenke','Svendsen','Jomfrudalen 13',3770,'Allinge','m','aktiv','konkurrence',1995),(49,'Svend','Svin','Jomfruskoven 21',3770,'Allinge','m','aktiv','motionist',2004),(50,'Preben','Fistelbach',NULL,NULL,NULL,NULL,'aktiv','motionist',1971),(51,'Preben','Fisenbarch',NULL,NULL,NULL,NULL,'aktiv','konkurrence',1941),(52,'Preben','Fisenbarch',NULL,NULL,NULL,NULL,'aktiv','konkurrence',1941),(53,'Lotte','Knastenløs',NULL,NULL,NULL,NULL,'aktiv','motionist',1978),(54,'Finn','Feber',NULL,NULL,NULL,NULL,'aktiv','motionist',2002);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscription`
--

DROP TABLE IF EXISTS `subscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscription` (
  `payment_id` int NOT NULL AUTO_INCREMENT,
  `due_date` varchar(45) NOT NULL,
  `amount` int NOT NULL,
  `year` int DEFAULT NULL,
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscription`
--

LOCK TABLES `subscription` WRITE;
/*!40000 ALTER TABLE `subscription` DISABLE KEYS */;
INSERT INTO `subscription` VALUES (1,'-2004',3000,2021),(2,'1998',3000,2021),(3,'21-12-2021',3000,2021),(4,'21-12-2021',3000,2021),(5,'21-12-2021',3000,2021),(6,'21-12-2021',3000,2021),(7,'21-12-2021',3000,2021),(8,'21-12-2021',3000,2021),(9,'21-12-2021',3000,2021),(10,'21-12-2021',3000,2021),(11,'21-12-2021',3000,2021),(12,'21-12-2021',3000,2021),(13,'21-12-2021',3000,2021),(14,'21-12-2021',3000,2021);
/*!40000 ALTER TABLE `subscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscription_payments`
--

DROP TABLE IF EXISTS `subscription_payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscription_payments` (
  `payment_id` int NOT NULL AUTO_INCREMENT,
  `subscription_id` int NOT NULL,
  `member_id` int DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `status` tinyint DEFAULT '1',
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=246 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscription_payments`
--

LOCK TABLES `subscription_payments` WRITE;
/*!40000 ALTER TABLE `subscription_payments` DISABLE KEYS */;
INSERT INTO `subscription_payments` VALUES (1,10,1,1200,1),(2,10,2,1200,1),(3,10,3,1200,1),(4,10,4,1000,1),(5,10,5,1200,1),(6,10,6,1200,1),(7,10,7,1200,1),(8,10,8,1200,0),(9,10,9,1200,1),(10,10,10,1200,1),(11,10,11,1200,1),(12,10,12,1200,1),(13,10,13,1200,1),(14,10,14,1200,1),(15,10,15,1200,1),(16,10,16,1600,1),(17,10,17,1600,1),(18,10,18,1600,1),(19,10,19,1600,1),(20,10,20,1600,1),(21,10,21,1600,1),(22,10,22,1600,1),(23,10,23,1200,1),(24,10,24,1200,1),(25,10,25,1200,1),(26,10,26,1000,1),(27,10,27,1200,1),(28,10,28,1200,1),(29,10,29,1200,1),(30,10,30,1200,1),(31,10,31,1200,1),(32,10,32,1600,1),(33,10,33,1600,1),(34,10,34,1600,1),(35,10,35,1600,1),(36,10,36,1200,1),(37,10,37,1200,1),(38,10,38,1200,1),(39,10,39,1600,1),(40,10,40,1600,1),(41,10,41,1600,1),(42,10,42,1600,1),(43,10,43,1200,1),(44,10,44,1000,1),(45,10,45,1200,1),(46,10,46,1200,1),(47,10,47,1200,1),(48,10,48,1200,1),(49,10,49,1000,0),(50,11,1,1200,1),(51,11,2,1200,1),(52,11,3,1200,1),(53,11,4,1000,1),(54,11,5,1200,1),(55,11,6,1200,1),(56,11,7,1200,1),(57,11,8,1200,0),(58,11,9,1200,1),(59,11,10,1200,1),(60,11,11,1200,1),(61,11,12,1200,1),(62,11,13,1200,1),(63,11,14,1200,1),(64,11,15,1200,1),(65,11,16,1600,1),(66,11,17,1600,1),(67,11,18,1600,1),(68,11,19,1600,1),(69,11,20,1600,1),(70,11,21,1600,1),(71,11,22,1600,1),(72,11,23,1200,1),(73,11,24,1200,1),(74,11,25,1200,1),(75,11,26,1000,1),(76,11,27,1200,1),(77,11,28,1200,1),(78,11,29,1200,1),(79,11,30,1200,1),(80,11,31,1200,1),(81,11,32,1600,1),(82,11,33,1600,1),(83,11,34,1600,1),(84,11,35,1600,1),(85,11,36,1200,1),(86,11,37,1200,1),(87,11,38,1200,1),(88,11,39,1600,1),(89,11,40,1600,1),(90,11,41,1600,1),(91,11,42,1600,1),(92,11,43,1200,1),(93,11,44,1000,1),(94,11,45,1200,1),(95,11,46,1200,1),(96,11,47,1200,1),(97,11,48,1200,1),(98,11,49,1000,0),(99,12,1,1200,1),(100,12,2,1200,1),(101,12,3,1200,1),(102,12,4,1000,1),(103,12,5,1200,1),(104,12,6,1200,1),(105,12,7,1200,1),(106,12,8,1200,0),(107,12,9,1200,1),(108,12,10,1200,1),(109,12,11,1200,1),(110,12,12,1200,1),(111,12,13,1200,1),(112,12,14,1200,1),(113,12,15,1200,1),(114,12,16,1600,1),(115,12,17,1600,1),(116,12,18,1600,1),(117,12,19,1600,1),(118,12,20,1600,1),(119,12,21,1600,1),(120,12,22,1600,1),(121,12,23,1200,1),(122,12,24,1200,1),(123,12,25,1200,1),(124,12,26,1000,1),(125,12,27,1200,1),(126,12,28,1200,1),(127,12,29,1200,1),(128,12,30,1200,1),(129,12,31,1200,1),(130,12,32,1600,1),(131,12,33,1600,1),(132,12,34,1600,1),(133,12,35,1600,1),(134,12,36,1200,1),(135,12,37,1200,1),(136,12,38,1200,1),(137,12,39,1600,1),(138,12,40,1600,1),(139,12,41,1600,1),(140,12,42,1600,1),(141,12,43,1200,1),(142,12,44,1000,1),(143,12,45,1200,1),(144,12,46,1200,1),(145,12,47,1200,1),(146,12,48,1200,1),(147,12,49,1000,0),(148,13,1,1200,1),(149,13,2,1200,1),(150,13,3,1200,1),(151,13,4,1000,1),(152,13,5,1200,1),(153,13,6,1200,1),(154,13,7,1200,1),(155,13,8,1200,0),(156,13,9,1200,1),(157,13,10,1200,1),(158,13,11,1200,1),(159,13,12,1200,1),(160,13,13,1200,1),(161,13,14,1200,1),(162,13,15,1200,1),(163,13,16,1600,1),(164,13,17,1600,1),(165,13,18,1600,1),(166,13,19,1600,1),(167,13,20,1600,1),(168,13,21,1600,1),(169,13,22,1600,1),(170,13,23,1200,1),(171,13,24,1200,1),(172,13,25,1200,1),(173,13,26,1000,1),(174,13,27,1200,1),(175,13,28,1200,1),(176,13,29,1200,1),(177,13,30,1200,1),(178,13,31,1200,1),(179,13,32,1600,1),(180,13,33,1600,1),(181,13,34,1600,1),(182,13,35,1600,1),(183,13,36,1200,1),(184,13,37,1200,1),(185,13,38,1200,1),(186,13,39,1600,1),(187,13,40,1600,1),(188,13,41,1600,1),(189,13,42,1600,1),(190,13,43,1200,1),(191,13,44,1000,1),(192,13,45,1200,1),(193,13,46,1200,1),(194,13,47,1200,1),(195,13,48,1200,1),(196,13,49,1000,0),(197,14,1,1200,1),(198,14,2,1200,1),(199,14,3,1200,1),(200,14,4,1000,1),(201,14,5,1200,1),(202,14,6,1200,1),(203,14,7,1200,1),(204,14,8,1200,1),(205,14,9,1200,1),(206,14,10,1200,1),(207,14,11,1200,1),(208,14,12,1200,1),(209,14,13,1200,1),(210,14,14,1200,1),(211,14,15,1200,1),(212,14,16,1600,1),(213,14,17,1600,1),(214,14,18,1600,1),(215,14,19,1600,1),(216,14,20,1600,1),(217,14,21,1600,1),(218,14,22,1600,1),(219,14,23,1200,1),(220,14,24,1200,1),(221,14,25,1200,1),(222,14,26,1000,1),(223,14,27,1200,1),(224,14,28,1200,1),(225,14,29,1200,1),(226,14,30,1200,1),(227,14,31,1200,1),(228,14,32,1600,1),(229,14,33,1600,1),(230,14,34,1600,1),(231,14,35,1600,1),(232,14,36,1200,1),(233,14,37,1200,1),(234,14,38,1200,1),(235,14,39,1600,1),(236,14,40,1600,1),(237,14,41,1600,1),(238,14,42,1600,1),(239,14,43,1200,1),(240,14,44,1000,1),(241,14,45,1200,1),(242,14,46,1200,1),(243,14,47,1200,1),(244,14,48,1200,1),(245,14,49,1000,1);
/*!40000 ALTER TABLE `subscription_payments` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-26 13:11:09
