-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: springboot
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
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
 SET character_set_client = utf8mb4 ;
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
INSERT INTO `open_user` VALUES ('wxe22a8310f6aadeff','oP_cK0TkMzc86uqhgBmWUq_OdPs8','1A869DCA6E3CC26160F947B84161E561',NULL,NULL,'');
/*!40000 ALTER TABLE `open_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_specification`
--

DROP TABLE IF EXISTS `product_specification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product_specification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL COMMENT '关联的产品id',
  `title` varchar(200) DEFAULT NULL COMMENT '规格名称',
  `stock` int(11) DEFAULT '0' COMMENT '规格库存',
  `price` int(11) DEFAULT '0' COMMENT '规格价格',
  `max` int(11) DEFAULT NULL COMMENT '限购数量',
  `is_show` tinyint(4) DEFAULT '1',
  `is_delete` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='产品规格';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_specification`
--

LOCK TABLES `product_specification` WRITE;
/*!40000 ALTER TABLE `product_specification` DISABLE KEYS */;
INSERT INTO `product_specification` VALUES (7,1,'规格1',2,1,3,1,0),(8,1,'规格2',22,12,33,1,0),(9,1,'111',0,0,0,1,1),(10,1,'123123',2,1,1,1,0),(11,3,'12323',0,0,0,1,0),(12,NULL,'12323',2,1,3,1,0),(13,NULL,'xxxx',1,1,1,1,0),(14,NULL,'123',1,1,0,1,0),(15,7,'wwwwwwww',7,8,5,1,0);
/*!40000 ALTER TABLE `product_specification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_type`
--

DROP TABLE IF EXISTS `product_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `union_id` varchar(50) NOT NULL,
  `cate_name` varchar(100) DEFAULT NULL COMMENT '分类名称',
  `cate_logo` varchar(200) DEFAULT NULL COMMENT '分类图标',
  `is_show` tinyint(4) DEFAULT '1',
  `is_delete` tinyint(4) DEFAULT '0',
  `sort_order` int(11) DEFAULT '50',
  `pid` int(11) DEFAULT '0' COMMENT '父id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='产品分类表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_type`
--

LOCK TABLES `product_type` WRITE;
/*!40000 ALTER TABLE `product_type` DISABLE KEYS */;
INSERT INTO `product_type` VALUES (1,'0','衣服','https://vue-1253286615.cos.ap-guangzhou.myqcloud.com/2fb7bf72-ce6d-44d4-ad55-25c6b92b91b9.png',1,0,50,0),(2,'0','123123','12312312',1,1,50,0),(3,'0','分类1','https://vue-1253286615.cos.ap-guangzhou.myqcloud.com/ef7aa958-453f-4cf3-81f9-983cabb71173.png',0,0,50,0),(4,'0','3333333333333vvv','https://vue-1253286615.cos.ap-guangzhou.myqcloud.com/283c6749-e85e-4e67-b563-dd62b2227bd4.png',0,0,50,1),(5,'0','vvvv','',1,0,50,1),(6,'0','hahahh333','https://vue-1253286615.cos.ap-guangzhou.myqcloud.com/1e0ba09e-8412-4f5f-809e-c429a2baa591.jpg',1,0,52,3);
/*!40000 ALTER TABLE `product_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
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
  `is_show` tinyint(4) DEFAULT '1',
  `is_recommend` tinyint(4) DEFAULT '0',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除',
  `created_at` datetime DEFAULT NULL,
  `sort_order` int(11) DEFAULT '50',
  `picture_list` varchar(2000) DEFAULT NULL COMMENT '轮播图',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='商品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'0','123123','https://vue-1253286615.cos.ap-guangzhou.myqcloud.com/40735f06-6944-4db8-8e4f-f4a7881871db.png',4,2,3,'商品简述\n','商品详情\n',1,1,0,0,'2018-08-29 00:00:00',50,'[{\"name\":\"https://vue-1253286615.cos.ap-guangzhou.myqcloud.com/50d99ae3-b80c-461d-953c-6bc138cf3668.png\",\"url\":\"https://vue-1253286615.cos.ap-guangzhou.myqcloud.com/50d99ae3-b80c-461d-953c-6bc138cf3668.png\",\"uid\":1535534222947,\"status\":\"success\"},{\"name\":\"https://vue-1253286615.cos.ap-guangzhou.myqcloud.com/8bdaa536-33f1-41f8-8d21-96fe15eb7c16.jpg\",\"url\":\"https://vue-1253286615.cos.ap-guangzhou.myqcloud.com/8bdaa536-33f1-41f8-8d21-96fe15eb7c16.jpg\"}]'),(2,'0','12312','https://vue-1253286615.cos.ap-guangzhou.myqcloud.com/3b873773-00cb-43c7-bc2b-41c2d148b754.png',6,463,542,'123131','12313123',1,1,0,0,'2018-08-29 11:52:15',50,'[{\"name\":\"https://vue-1253286615.cos.ap-guangzhou.myqcloud.com/a4118ec4-35ec-46e9-83a2-118099f4a840.png\",\"url\":\"https://vue-1253286615.cos.ap-guangzhou.myqcloud.com/a4118ec4-35ec-46e9-83a2-118099f4a840.png\",\"uid\":1535534774485,\"status\":\"success\"},{\"name\":\"https://vue-1253286615.cos.ap-guangzhou.myqcloud.com/b8f21aff-46a6-43b6-a5c1-461437c553b9.png\",\"url\":\"https://vue-1253286615.cos.ap-guangzhou.myqcloud.com/b8f21aff-46a6-43b6-a5c1-461437c553b9.png\"}]'),(3,'0','123123','',4,0,0,'123','123213',1,1,0,1,'2018-09-01 14:03:23',50,'[]'),(4,'0','xxx','',5,0,0,'123','123123',0,1,0,1,'2018-09-01 14:04:24',50,'[]'),(5,'0','xxxxx','',4,0,0,'qeqweq','weqweqwe',0,1,0,1,'2018-09-01 14:30:48',50,'[]'),(6,'0','123123','',4,0,0,'12313','123123',0,1,0,1,'2018-09-01 14:34:24',50,'[]'),(7,'0','wwwwwwwww','',4,0,0,'wqeqe','qweqweqwe',0,1,0,0,'2018-09-01 14:42:29',50,'[]');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_permission`
--

DROP TABLE IF EXISTS `role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `permission` varchar(50) NOT NULL COMMENT '权限key值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_permission`
--

LOCK TABLES `role_permission` WRITE;
/*!40000 ALTER TABLE `role_permission` DISABLE KEYS */;
INSERT INTO `role_permission` VALUES (149,2,'/system'),(150,2,'/user/list'),(151,2,'/user/delete'),(152,2,'/user/role/list'),(153,2,'/user/role/detail');
/*!40000 ALTER TABLE `role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `union_group`
--

DROP TABLE IF EXISTS `union_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
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
INSERT INTO `union_group` VALUES (1,'橙蓝','18a411e4-30d1-40cf-ad25-5a579cbd5edf','这是第一个组织，你好',NULL,0),(2,'小程序柠檬商城','3ea86196-7507-4052-a4d4-4bb9487cba85','小程序柠檬商城1234',NULL,0),(3,'1231239999','b5b40a7a-d65e-47e3-91ca-787064796b67','44444444444',NULL,1);
/*!40000 ALTER TABLE `union_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `union_setting`
--

DROP TABLE IF EXISTS `union_setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `union_setting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `union_id` varchar(50) NOT NULL,
  `title` varchar(100) DEFAULT NULL COMMENT '配置名',
  `key_name` varchar(50) NOT NULL COMMENT '配置key 值',
  `key_value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='组织的一些配置';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `union_setting`
--

LOCK TABLES `union_setting` WRITE;
/*!40000 ALTER TABLE `union_setting` DISABLE KEYS */;
INSERT INTO `union_setting` VALUES (1,'0','腾讯云存储SecretId','tencentCosSecretId','AKIDSoxyoi4LrCMJ2YrulOnzx1vZzJUPITcU'),(2,'0','腾讯云存储SecretId','tencentCosSecretKey','nNhkX7Rr56tTuAHBsMejYDhz3sVxBAxe'),(3,'0','微信支付SecretId','wePaySecretId','12312313'),(4,'0','微信支付SecretId','wePayCosSecretKey','66666'),(5,'0','腾讯云存储Bucket','tencentCosBucket','vue-1253286615'),(6,'0','腾讯云存储Region','tencentCosRegion','ap-guangzhou');
/*!40000 ALTER TABLE `union_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
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
  `role_id` int(9) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'lurongze','','','F730FD868D1550C7B41D783DD67FE6FF',1529748103,'eyJsb2dpblRpbWUiOjE1MzU3ODMzMTksIm5hbWUiOiJsdXJvbmd6ZSIsInNpZ24iOiIyRTdGMjNFMTgwODAxQTFEODU0NjBDNkUxNTRBQzAzOSIsImlkIjoxfQ==','0',0,0),(2,'陆荣泽4','1946755280@qq.com','广州市','21312312',NULL,'','0',1,0),(3,'AAAA','AAAA','AAQWEQ','41D58883E50B53870FCA159FCEF8A1F8',1531195985,'','0',1,0),(4,'小明','123123','123123','67BDE276A6182E41FDF7DC7F629A1114',1531210264,'','0',1,0),(5,'小红','123123','12312','5C7384FD5D8572DA2EDA746E7F2B51E4',1531213557,'','0',1,0),(6,'22222','111','1111','FC9D41C66E354D20D799ECB0F60C2C64',1531217321,'','0',1,0),(7,'1231231','123123','12312313','1C1A76F3B72AB40FAB215B623CAB21F6',1532657165,'','0',1,0),(8,'lrz','lrz@qq.com','广州市','F730FD868D1550C7B41D783DD67FE6FF',1532657262,'eyJsb2dpblRpbWUiOjE1MzQyMzUwMDEsIm5hbWUiOiJscnoiLCJzaWduIjoiMkNFOUQ5NzFEQkIwNzBGNjQ3QkZGRTkwRTY5MkM5QUEiLCJpZCI6OH0=','18a411e4-30d1-40cf-ad25-5a579cbd5edf',0,2),(9,'12312312313','12313','12313','A29FB138C6EBB76D7D94D9E9F5800389',1532657267,'','0',1,0),(10,'12312312','312312312312','3123123123','5219A99933DD63BB2A5AC74214E462F3',1532657317,'','0',1,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_role` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `union_id` varchar(20) NOT NULL,
  `role_name` varchar(255) NOT NULL,
  `is_delete` tinyint(4) DEFAULT '0',
  `sort_order` int(11) DEFAULT '50',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'0','管理员',0,50),(2,'0','产品管理员',0,56),(3,'0','66666666',1,0),(4,'0','1231231',1,0),(5,'0','1312313123',1,4),(6,'0','6666666666666666',1,0),(7,'0','踩踩踩踩踩踩5xxx',1,0);
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

-- Dump completed on 2018-09-01 14:49:11
