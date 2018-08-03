-- MySQL dump 10.13  Distrib 5.5.53, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: springboot
-- ------------------------------------------------------
-- Server version	8.0.11

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
  `appid` varchar(50) DEFAULT NULL,
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
INSERT INTO `open_user` VALUES ('wxe22a8310f6aadeff','oP_cK0TkMzc86uqhgBmWUq_OdPs8','27AB627DE9846E8AB0B70829D316BED8','aQttT4v2f0vByyxqOpLu0Q==',NULL,'');
/*!40000 ALTER TABLE `open_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_type`
--

DROP TABLE IF EXISTS `product_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `union_id` varchar(50) NOT NULL,
  `cate_name` varchar(100) DEFAULT NULL COMMENT '分类名称',
  `cate_logo` varchar(200) DEFAULT NULL COMMENT '分类图标',
  `is_show` tinyint(4) DEFAULT '1',
  `is_delete` tinyint(4) DEFAULT '0',
  `sort_order` int(11) DEFAULT '50',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='产品分类表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_type`
--

LOCK TABLES `product_type` WRITE;
/*!40000 ALTER TABLE `product_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `union_id` varchar(50) NOT NULL COMMENT '组织id',
  `title` varchar(100) DEFAULT NULL,
  `picture` varchar(150) DEFAULT NULL COMMENT '产品封面图',
  `cid` int(11) DEFAULT NULL COMMENT '分类id',
  `price` int(11) NOT NULL DEFAULT '1000000' COMMENT '商品价格，以分为单位保存',
  `original_price` int(11) DEFAULT NULL COMMENT '原价',
  `short_description` varchar(1000) DEFAULT NULL COMMENT '商品简介',
  `description` text COMMENT '商品描述',
  `stock` int(11) NOT NULL COMMENT '总库存',
  `is_show` tinyint(4) DEFAULT '0',
  `is_recommend` tinyint(4) DEFAULT '0',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除',
  `created_at` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='商品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `union_group`
--

DROP TABLE IF EXISTS `union_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `union_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `union_name` varchar(150) DEFAULT NULL COMMENT '组织名称',
  `union_id` varchar(50) DEFAULT NULL COMMENT '组织id',
  `union_description` varchar(255) DEFAULT NULL,
  `createtime` int(11) DEFAULT NULL COMMENT '创建时间',
  `is_delete` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `union_group_union_id_uindex` (`union_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='组织表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `union_group`
--

LOCK TABLES `union_group` WRITE;
/*!40000 ALTER TABLE `union_group` DISABLE KEYS */;
INSERT INTO `union_group` VALUES (1,'橙蓝','18a411e4-30d1-40cf-ad25-5a579cbd5edf','这是第一个组织，你好',NULL,0),(2,'小程序柠檬商城','3ea86196-7507-4052-a4d4-4bb9487cba85','小程序柠檬商城1',NULL,0),(3,'1231239999','b5b40a7a-d65e-47e3-91ca-787064796b67','44444444444',NULL,1);
/*!40000 ALTER TABLE `union_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  `user_address` varchar(500) NOT NULL,
  `user_password` varchar(100) NOT NULL,
  `created_at` int(11) DEFAULT NULL,
  `token` varchar(500) DEFAULT NULL,
  `union_id` varchar(50) NOT NULL COMMENT '组织id',
  `is_delete` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'lurongze','','','F730FD868D1550C7B41D783DD67FE6FF',1529748103,'eyJsb2dpblRpbWUiOjE1MzMyODQ2OTYsIm5hbWUiOiJsdXJvbmd6ZSIsInNpZ24iOiIxQkNGRjhDNEQzQjE4RTRGM0E5NTIzQzM5NjhCMDdBQSIsImlkIjoxfQ==','',0),(2,'陆荣泽4','1946755280@qq.com','广州市','21312312',NULL,'','0',1),(3,'AAAA','AAAA','AAQWEQ','41D58883E50B53870FCA159FCEF8A1F8',1531195985,'','0',1),(4,'小明','123123','123123','67BDE276A6182E41FDF7DC7F629A1114',1531210264,'','0',1),(5,'小红','123123','12312','5C7384FD5D8572DA2EDA746E7F2B51E4',1531213557,'','0',1),(6,'22222','111','1111','FC9D41C66E354D20D799ECB0F60C2C64',1531217321,'','0',1),(7,'1231231','123123','12312313','1C1A76F3B72AB40FAB215B623CAB21F6',1532657165,'','0',1),(8,'lrz','123123','123131','F730FD868D1550C7B41D783DD67FE6FF',1532657262,'eyJsb2dpblRpbWUiOjE1MzI2ODQ1NDgsIm5hbWUiOiJscnoiLCJzaWduIjoiODYyMkZFMUM1Nzc1NUM5Q0JDNkNGRTNEMjA1RTEwN0YiLCJpZCI6OH0=','18a411e4-30d1-40cf-ad25-5a579cbd5edf',0),(9,'12312312313','12313','12313','A29FB138C6EBB76D7D94D9E9F5800389',1532657267,'','0',1),(10,'12312312','312312312312','3123123123','5219A99933DD63BB2A5AC74214E462F3',1532657317,'','0',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `union_id` varchar(20) NOT NULL,
  `role_name` varchar(255) NOT NULL,
  `is_delete` tinyint(4) DEFAULT '0',
  `sort_order` int(11) DEFAULT '50',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'0','管理员',0,50),(2,'0','产品管理员',0,51),(3,'0','66666666',1,0);
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

-- Dump completed on 2018-08-03 18:01:48
