CREATE DATABASE  IF NOT EXISTS `forum` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `forum`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: forum
-- ------------------------------------------------------
-- Server version	5.7.19

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
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `messgae_id` bigint(20) unsigned NOT NULL,
  `send_id` varchar(45) NOT NULL,
  `send_username` varchar(45) DEFAULT NULL,
  `receive_id` varchar(45) NOT NULL,
  `receive_username` varchar(45) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`messgae_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统通知';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `post_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `author_id` varchar(45) NOT NULL,
  `create_datetime` datetime NOT NULL,
  `cover` varchar(45) DEFAULT NULL COMMENT '封面图片路径',
  `theme` tinyint(3) unsigned NOT NULL COMMENT '主题id，可根据id从表theme获取',
  `traffic` mediumint(9) unsigned NOT NULL COMMENT '帖子访问量',
  `top` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否为精华置顶帖子，0-否  1-是',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子概要信息（即不包含帖子内容）';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_comment`
--

DROP TABLE IF EXISTS `post_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post_comment` (
  `post_id` bigint(20) unsigned NOT NULL,
  `floor_id` int(10) unsigned NOT NULL,
  `comment_id` int(11) NOT NULL,
  `send_id` varchar(45) NOT NULL COMMENT '发表回复，发表评论的id',
  `send_username` varchar(45) DEFAULT NULL,
  `receive_id` varchar(45) NOT NULL COMMENT '被回复，被评论人的id',
  `receive_username` varchar(45) DEFAULT NULL,
  `comment` text NOT NULL,
  `create_dateime` datetime NOT NULL,
  PRIMARY KEY (`post_id`,`floor_id`,`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子评论（一个元组表示一个针对某个楼层的评论）';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_comment`
--

LOCK TABLES `post_comment` WRITE;
/*!40000 ALTER TABLE `post_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `post_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_content`
--

DROP TABLE IF EXISTS `post_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post_content` (
  `post_id` bigint(20) unsigned NOT NULL,
  `floor_id` int(10) unsigned NOT NULL,
  `content` text NOT NULL COMMENT '帖子内容',
  `create_datetime` datetime NOT NULL,
  `authod_id` varchar(45) NOT NULL,
  `authod_username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`post_id`,`floor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子内容（一个元组表示一个帖子楼层）';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_content`
--

LOCK TABLES `post_content` WRITE;
/*!40000 ALTER TABLE `post_content` DISABLE KEYS */;
/*!40000 ALTER TABLE `post_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `report` (
  `report_id` bigint(20) unsigned NOT NULL,
  `send_id` varchar(45) NOT NULL,
  `send_username` varchar(45) DEFAULT NULL,
  `create_datetime` datetime NOT NULL,
  `post_id` bigint(20) DEFAULT NULL,
  `floor_id` int(11) DEFAULT NULL,
  `comment_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`report_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='举报信息,不确定有没有举报用户的功能，此处暂时缺少此属性';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theme`
--

DROP TABLE IF EXISTS `theme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `theme` (
  `theme_id` tinyint(4) NOT NULL,
  `theme_name` varchar(10) NOT NULL,
  PRIMARY KEY (`theme_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主题';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theme`
--

LOCK TABLES `theme` WRITE;
/*!40000 ALTER TABLE `theme` DISABLE KEYS */;
/*!40000 ALTER TABLE `theme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` char(32) NOT NULL COMMENT '使用md5加密，固定长度32个字符',
  `salt` char(24) NOT NULL COMMENT '密码盐值，固定长度24位字符',
  `role` tinyint(4) unsigned NOT NULL DEFAULT '1' COMMENT '0-管理员\r   1-普通用户   2-黑名单用户',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='此表用于保存用户的验证信息和角色权限';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_information`
--

DROP TABLE IF EXISTS `user_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_information` (
  `user_id` varchar(45) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `head` varchar(45) DEFAULT NULL COMMENT '头像，保存头像图片路径',
  `register_date` datetime NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='此表保存用户的个人信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_information`
--

LOCK TABLES `user_information` WRITE;
/*!40000 ALTER TABLE `user_information` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_information` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-29 21:37:11
