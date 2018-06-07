-- MySQL dump 10.13  Distrib 5.5.53, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: springboot
-- ------------------------------------------------------
-- Server version	5.5.53

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
-- Table structure for table `open_user`
--

DROP TABLE IF EXISTS `open_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `open_user` (
  `openid` varchar(50) DEFAULT NULL,
  `session_key` varchar(50) NOT NULL,
  `wx_session` varchar(50) DEFAULT NULL,
  `unionid` varchar(50) DEFAULT NULL,
  `info` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`session_key`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `open_user`
--

LOCK TABLES `open_user` WRITE;
/*!40000 ALTER TABLE `open_user` DISABLE KEYS */;
INSERT INTO `open_user` VALUES ('oP_cK0TkMzc86uqhgBmWUq_OdPs8','EA152449ECC8F1B8AC5F6E9548FA2CA1','AhH6p/KESZS93IsIFyw8Jg==',NULL,NULL);
/*!40000 ALTER TABLE `open_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `address` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (27,'name2','1946755280@qq.com','广州市越秀区'),(2,'name','1946755280@qq.com','广州市'),(3,'name','1946755280@qq.com','广州市'),(4,'name','1946755280@qq.com','广州市'),(5,'name','1946755280@qq.com','广州市'),(6,'name','1946755280@qq.com','广州市'),(7,'name7','1946755280@qq.com','广州市'),(8,'name','1946755280@qq.com','广州市'),(9,'name','1946755280@qq.com','广州市'),(10,'name','1946755280@qq.com','广州市'),(11,'name','1946755280@qq.com','广州市'),(12,'name','1946755280@qq.com','广州市'),(13,'name','1946755280@qq.com','广州市'),(14,'name','1946755280@qq.com','广州市'),(15,'name','1946755280@qq.com','广州市'),(16,'name','1946755280@qq.com','广州市'),(17,'name','1946755280@qq.com','广州市'),(18,'name','1946755280@qq.com','广州市'),(19,'name','1946755280@qq.com','广州市'),(20,'name','1946755280@qq.com','广州市'),(21,'name','1946755280@qq.com','广州市'),(22,'name','1946755280@qq.com','广州市'),(23,'name','1946755280@qq.com','广州市'),(24,'name','1946755280@qq.com','广州市'),(25,'name','1946755280@qq.com','广州市'),(26,'name','1946755280@qq.com','广州市'),(28,'name','1946755280@qq.com','广州市'),(29,'name','1946755280@qq.com','广州市'),(30,'name','1946755280@qq.com','广州市'),(31,'name','1946755280@qq.com','广州市'),(32,'name','1946755280@qq.com','广州市'),(42,'lurongze','1946755280@qq.com','广州市'),(34,'name','1946755280@qq.com','广州市'),(35,'name','1946755280@qq.com','广州市'),(36,'name','1946755280@qq.com','广州市'),(37,'name','1946755280@qq.com','广州市'),(38,'name','1946755280@qq.com','广州市'),(39,'name','1946755280@qq.com','广州市'),(40,'name','1946755280@qq.com','广州市'),(41,'add陆荣泽','add 1946755280@qq.com','add 广州市'),(43,'name','1946755280@qq.com','广州市'),(44,'陆荣泽','1946755280@qq.com','广州市'),(45,'陆荣泽','1946755280@qq.com','广州市'),(46,'陆荣泽1','1946755280@qq.com','广州市'),(47,'name','1946755280@qq.com','广州市'),(48,'test-name','1946755280@qq.com','广州市'),(49,'nametest','1946755280@qq.com','广州市'),(50,'nametest','1946755280@qq.com','广州市'),(51,'nametest123','1946755280@qq.com','广州市');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_info` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `uid` int(9) NOT NULL,
  `phone` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (1,41,'15021618114'),(2,1,'15021618114'),(3,1,'15021618114'),(4,1,'15021618114'),(5,1,'15021618114');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `role` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-07 16:28:47
