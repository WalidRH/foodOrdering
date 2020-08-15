-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: 192.168.1.20    Database: food_ordering_app
-- ------------------------------------------------------
-- Server version	5.7.31-0ubuntu0.16.04.1

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
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `idclient` varchar(50) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(1000) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`idclient`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES ('402881e973833e870173833e8a6c0000','Walid','Rahou','testWalid@gmail.com','$2a$10$g2zCQxBbVrE13FLCFdgkzuEfwU9BBMOcUrQsJwRfNcSqhf6GKL4oy','ADMIN'),('402881e97383c6fc017383c7a1b60000','hasnae','Rahou','testHasna@gmail.com','$2a$10$b6CBTGxDWh4N1zBUGnPWqOYesYCx6UN/QnfNmw9M.xbUxcNRD.UjC','ADMIN'),('402881e97383c6fc017383c9cb170001','hasnae','ACH','kbida@gmail.com','$2a$10$CKoTRLGJTN1wSYB.451vrOBqOtEBCz6lydmxzMsQZv5sV4arSAjJC',''),('402881e97383cba6017383cc59d20000','hasnae','ACH','HasnaACH@gmail.com','$2a$10$f0ky4A2BMz/ImqhDqqicC.rJvLqzS77c5nJ229kpWVKisaoyAyRji',''),('402881e973884b490173884b4e280000','test','ACH','Hasnatest@gmail.com','$2a$10$1JRqOVf0OF04ZMbjbFlfF.vGp/tvdA0QT5DyTDFKB.IIgrESJF46W',''),('402881e9738852b90173885497e30000','achab','ACH','Hasnaacheab@gmail.com','$2a$10$kKoWw8tjCgrVnjGEbfzbFOz.POTj9EAWbFd811FBmTq90UaGttTaa','USER'),('402881e9738852b90173885944530001','Walid','RH','RahouwWalid17@gmail.com','$2a$10$50gcdLC.bl87fd69sTGstuv41jT2bUmrislq496WYYbkVbZnH1mR2','USER');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `idmenu` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` decimal(50,0) DEFAULT NULL,
  PRIMARY KEY (`idmenu`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'emince Poulet',36),(2,'lasagne',30),(3,'burger',25),(4,'chawara',36);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordering`
--

DROP TABLE IF EXISTS `ordering`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordering` (
  `id_order` int(11) NOT NULL AUTO_INCREMENT,
  `id_client` varchar(50) DEFAULT NULL,
  `id_menu` int(11) DEFAULT NULL,
  `quantity_order` double DEFAULT NULL,
  `tracking_state` varchar(45) DEFAULT NULL,
  `date_order` datetime(1) DEFAULT NULL,
  `nb_person` int(11) DEFAULT NULL,
  `serve_date` datetime(1) DEFAULT NULL,
  PRIMARY KEY (`id_order`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordering`
--

LOCK TABLES `ordering` WRITE;
/*!40000 ALTER TABLE `ordering` DISABLE KEYS */;
INSERT INTO `ordering` VALUES (3,'402881e973833e870173833e8a6c0000',2,3,'Onprepare','2020-08-01 18:46:41.5',0,NULL),(4,'402881e973833e870173833e8a6c0000',2,3,'Onprepare','2020-08-09 17:51:38.4',0,NULL),(5,'402881e973833e870173833e8a6c0000',3,3,'OnServed','2020-09-19 18:52:51.0',0,NULL),(7,'402881e9738852b90173885944530001',1,3,NULL,'2020-08-09 18:52:51.0',0,NULL),(8,'402881e9738852b90173885944530001',1,3,NULL,'2020-08-09 19:50:33.1',2,'2020-08-09 21:52:51.0'),(9,'402881e9738852b90173885944530001',1,3,NULL,'2020-08-09 20:01:27.4',2,'2020-08-09 21:52:51.0'),(10,'402881e9738852b90173885944530001',1,3,NULL,'2020-08-15 00:00:00.0',0,NULL),(11,'402881e9738852b90173885944530001',1,3,NULL,'2020-08-15 18:39:52.5',0,NULL),(12,'402881e9738852b90173885944530001',1,3,NULL,'2020-08-15 18:59:17.8',0,NULL);
/*!40000 ALTER TABLE `ordering` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-15 21:56:44
