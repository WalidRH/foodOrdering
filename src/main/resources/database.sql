-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: localhost    Database: food_ordering
-- ------------------------------------------------------
-- Server version	8.0.19

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
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idclient`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES ('402881e973833e870173833e8a6c0000','Walid','Rahou','testWalid@gmail.com','$2a$10$g2zCQxBbVrE13FLCFdgkzuEfwU9BBMOcUrQsJwRfNcSqhf6GKL4oy','ADMIN',''),('402881e97383c6fc017383c7a1b60000','hasnae','Rahou','testHasna@gmail.com','$2a$10$b6CBTGxDWh4N1zBUGnPWqOYesYCx6UN/QnfNmw9M.xbUxcNRD.UjC','ADMIN',''),('402881e97383c6fc017383c9cb170001','hasnae','ACH','kbida@gmail.com','$2a$10$CKoTRLGJTN1wSYB.451vrOBqOtEBCz6lydmxzMsQZv5sV4arSAjJC','',''),('402881e97383cba6017383cc59d20000','hasnae','ACH','HasnaACH@gmail.com','$2a$10$f0ky4A2BMz/ImqhDqqicC.rJvLqzS77c5nJ229kpWVKisaoyAyRji','',''),('402881e973884b490173884b4e280000','test','ACH','Hasnatest@gmail.com','$2a$10$1JRqOVf0OF04ZMbjbFlfF.vGp/tvdA0QT5DyTDFKB.IIgrESJF46W','',''),('402881e9738852b90173885497e30000','achab','ACH','Hasnaacheab@gmail.com','$2a$10$kKoWw8tjCgrVnjGEbfzbFOz.POTj9EAWbFd811FBmTq90UaGttTaa','USER',''),('402881e9738852b90173885944530001','Walid','RH','RahouwWalid17@gmail.com','$2a$10$50gcdLC.bl87fd69sTGstuv41jT2bUmrislq496WYYbkVbZnH1mR2','ADMIN',''),('402881ef753d884901753d933a320000','Walid','RH','testRHWal@gmail.com','$2a$10$EjW0QbpFA2dVL3FJJ.PZLe4Hc9SStTGCX55BhHODgaXGMDi14R44y','USER',NULL),('402881ef753d959201753d9618f40000','Walid','RH','testsignUP@gmail.com','$2a$10$qyLCotBlgAGQEDMYjlQR6OS73DtBAE/2mgJqwquvlxxzcArR93Qrq','USER','0613500070'),('402881ef753d959201753da477210001','Walid','RH','testsign@gmail.com','$2a$10$/dv5ovDUyOkbWDoiFihD1OewlGNR3D61Cv4wlNKsXUaXCzHGzIB0i','USER','0613500070'),('402881ef753d959201753da840710002','Walid','RH','tegn@gmail.com','$2a$10$s6pvP8QBN64hX/FI6X9HfOMThztKJ0UEffzSoJYVipqqP7dyYjWNu','USER','0613500070'),('402881ef753dc19c01753dc53e1a0000','wal','Walid','testIHMSignUP@gmail.com','$2a$10$K2M/nkkC41EuNcjXf0P3o.dLLsPVh3XEO/3n.i3yOPijtLiTFXVK.','USER','0613500070'),('ff80818175140825017514b7db3f0000','hasnae','rahou','hasnina@gmail.com','$2a$10$FdyqmL9zBazxi6xmT.9cv..c8wY3DtF/YNPQ9D5tE8zVEkoAYnVHS','USER',''),('ff80818175140825017514be064b0001','hasnae','kbida','testHS@test.com','$2a$10$ZdVKQLKkk9a/MOYUdSW3/eOlRdhrcd6NZIG.nTYSqolEulFVVuuH6','USER',''),('ff80818175140825017514c1363c0002','hasnae','kbida','test1234@test.com','$2a$10$6fCAyUumaJV3FY0M9d4Lf.IYHpVOcAHl.jBfzmKMFCoy4EPAUgRCu','USER',''),('ff80818175140825017514c3b0130003','hasnae','Kbida','HSTest@gmail.com','$2a$10$3mgjI5Pu/f9Tljab0NwpfO4VEgQ8mrwXie/Q3x1lsoPmcIFkr/w4y','USER',''),('ff80818175140825017514c4a11f0004','hasnae','lfjnv','hasnaeRH@gmail.com','$2a$10$naPlco5vT3uGj9.j4jdVXOswAkO4rWZyw2UsJrZbrgx6WKMS3QlHe','USER',''),('ff808181753d9fa201753da91bc60000','Walid','RH','te@gmail.com','$2a$10$PXZhvQ1rVAipsrysEQVn7ujlPS7COuSoAaV62UuIdWlc8K.EqBD.2','USER','0613500070'),('ff808181753db02c01753db089470000','Walid','RH','wh@gmail.com','$2a$10$0ZEOHumvMO/Md7aI7ms4OuEoGtmdbK4sDy6Oxv7NFyqPL.fENvZia','USER','0613500070');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `idmenu` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `categorie` varchar(45) DEFAULT NULL,
  `price` decimal(50,0) DEFAULT NULL,
  `image` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`idmenu`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'emince Poulet','plat',36,'1.jpg'),(2,'burger','sandwich',25,'burger.jpg'),(3,'sandwich poulet','sandwich',36,'shwarma.jpg'),(4,'lasagne','patte',30,'2.jpg'),(23,'pizza thon','pizza',22,'pizzaThon.jpeg');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordering`
--

DROP TABLE IF EXISTS `ordering`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordering` (
  `id_order` int NOT NULL AUTO_INCREMENT,
  `id_client` varchar(50) DEFAULT NULL,
  `id_menu` int DEFAULT NULL,
  `quantity_order` double DEFAULT NULL,
  `tracking_state` varchar(45) DEFAULT NULL,
  `date_order` datetime(1) DEFAULT NULL,
  `nb_person` int DEFAULT NULL,
  `serve_date` datetime(1) DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  PRIMARY KEY (`id_order`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordering`
--

LOCK TABLES `ordering` WRITE;
/*!40000 ALTER TABLE `ordering` DISABLE KEYS */;
INSERT INTO `ordering` VALUES (9,'402881e9738852b90173885944530001',1,3,NULL,'2020-08-09 20:01:27.4',2,'2020-08-09 21:52:51.0',0),(30,'402881e9738852b90173885944530001',2,5,'Valid','2020-10-13 20:52:21.0',0,NULL,125),(31,'402881e9738852b90173885944530001',1,5,'Valid','2020-10-16 21:25:18.0',0,NULL,180),(32,'402881e9738852b90173885944530001',2,4,'Valid','2020-10-16 22:11:41.0',4,'1970-01-01 00:00:00.0',100),(33,'402881e9738852b90173885944530001',3,7,'Valid','2020-10-16 22:11:51.0',4,'1970-01-01 00:00:00.0',252),(34,'402881e9738852b90173885944530001',3,3,'Valid','2020-10-17 00:17:44.0',0,NULL,108),(35,'402881e9738852b90173885944530001',2,15,'Valid','2020-10-17 00:17:58.0',0,NULL,375),(36,'402881e9738852b90173885944530001',1,6,'Valid','2020-10-17 00:25:16.0',4,'1970-01-01 00:00:00.0',216),(37,'402881e9738852b90173885944530001',2,8,'Valid','2020-10-17 00:25:26.0',4,'1970-01-01 00:00:00.0',200),(38,'402881e9738852b90173885944530001',1,5,'Valid','2020-10-17 01:10:03.0',5,'2020-10-17 22:11:02.0',180),(39,'402881e9738852b90173885944530001',4,7,'Valid','2020-10-17 01:10:15.0',5,'2020-10-17 22:11:02.0',210),(40,'402881e9738852b90173885944530001',3,5,'Valid','2020-10-17 01:12:31.0',4,'2020-10-17 04:13:00.0',180),(41,'402881e9738852b90173885944530001',1,5,'Valid','2020-10-17 02:13:42.0',5,'2020-10-17 05:14:08.0',180),(43,'402881e9738852b90173885944530001',4,5,'Valid','2020-10-18 00:18:37.0',0,NULL,150),(45,'402881e9738852b90173885944530001',4,5,'Valid','2020-10-19 20:51:55.0',0,NULL,150),(47,'402881e9738852b90173885944530001',2,7,'Valid','2020-10-19 22:31:44.0',0,NULL,175),(50,'402881e9738852b90173885944530001',2,3,'Valid','2020-10-19 23:20:08.0',0,NULL,75),(56,'402881e9738852b90173885944530001',3,5,'Valid','2020-10-26 16:04:50.0',0,NULL,180),(59,'402881e9738852b90173885944530001',4,1,'Valid','2020-10-26 16:08:46.0',0,NULL,30),(60,'402881e9738852b90173885944530001',2,1,'Valid','2020-10-26 16:10:48.0',0,NULL,25),(63,'402881e9738852b90173885944530001',1,1,'Valid','2020-10-26 16:12:07.0',0,NULL,36),(64,'402881e9738852b90173885944530001',2,1,'Valid','2020-10-26 16:30:32.0',0,NULL,25),(70,'402881e9738852b90173885944530001',2,1,'Submitted','2020-10-30 18:14:50.2',0,NULL,25);
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

-- Dump completed on 2020-11-09 23:29:58
