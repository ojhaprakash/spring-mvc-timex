-- MySQL dump 10.13  Distrib 5.5.28, for osx10.6 (i386)
--
-- Host: localhost    Database: timex
-- ------------------------------------------------------
-- Server version	5.5.28-log

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
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `departmentCode` varchar(2) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`departmentCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES ('AC','Accounting'),('CS','Customer Support'),('HR','Human Resources'),('IT','Information Technology');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `employeeCode` varchar(1) DEFAULT NULL,
  `managerId` int(11) DEFAULT NULL,
  `password` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Mike Dover','mike.dover@mountainpirate.ca','H',3,'7c6a61c68ef8b9b6b061b28c348bc1ed7921cb53'),(2,'Ajay Kumar','ajay.kumar@mountainpirate.ca','H',3,'7c6a61c68ef8b9b6b061b28c348bc1ed7921cb53'),(3,'Teresa Walker','teresa.walker@mountainpirate.ca','M',4,'7c6a61c68ef8b9b6b061b28c348bc1ed7921cb53'),(4,'Tom Brady','tom.brady@mountainpirate.ca','E',NULL,'7c6a61c68ef8b9b6b061b28c348bc1ed7921cb53'),(5,'Sabina Pathak','sabina.pathak@gmail.com','M',4,'7c6a61c68ef8b9b6b061b28c348bc1ed7921cb53'),(6,'Prakash Ojha','ojhaprakash@gmail.com','H',5,'7c6a61c68ef8b9b6b061b28c348bc1ed7921cb53');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timesheet`
--

DROP TABLE IF EXISTS `timesheet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timesheet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employeeId` int(11) NOT NULL,
  `statusCode` varchar(1) DEFAULT 'U',
  `periodEndingDate` date DEFAULT NULL,
  `departmentCode` varchar(2) DEFAULT NULL,
  `minutesMon` int(11) DEFAULT '0',
  `minutesTue` int(11) DEFAULT '0',
  `minutesWed` int(11) DEFAULT '0',
  `minutesThu` int(11) DEFAULT '0',
  `minutesFri` int(11) DEFAULT '0',
  `minutesSat` int(11) DEFAULT '0',
  `minutesSun` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `employeeId` (`employeeId`),
  KEY `department` (`departmentCode`),
  CONSTRAINT `timesheet_ibfk_1` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timesheet`
--

LOCK TABLES `timesheet` WRITE;
/*!40000 ALTER TABLE `timesheet` DISABLE KEYS */;
INSERT INTO `timesheet` VALUES (1,2,'P','2006-08-19','IT',480,480,360,480,480,0,0),(2,1,'A','2006-08-19','HR',0,0,480,480,480,0,0),(3,2,'P','2014-07-18','CS',480,400,300,200,100,40,20),(4,6,'U','2014-07-25','CS',400,480,200,200,200,10,10),(5,6,'U','2014-08-01','IT',480,400,400,400,400,0,0);
/*!40000 ALTER TABLE `timesheet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-08-01 20:37:20
