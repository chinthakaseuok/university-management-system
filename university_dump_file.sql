-- MySQL dump 10.17  Distrib 10.3.16-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: university
-- ------------------------------------------------------
-- Server version	10.3.16-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `lecturer`
--

DROP TABLE IF EXISTS `lecturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lecturer` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `age` int(2) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecturer`
--

LOCK TABLES `lecturer` WRITE;
/*!40000 ALTER TABLE `lecturer` DISABLE KEYS */;
INSERT INTO `lecturer` VALUES (1,'Nalin Warnajith',42,'warnajith_n','warna_123'),(2,'Lankeshwara Munasinghe',40,'munasinghe_l','munasi_123'),(3,'Anura pushpakumara',32,'pushpaku_a','pushpaku_123');
/*!40000 ALTER TABLE `lecturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `age` int(2) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Chinthaka chathuranga',22,'chathura','chathura_123'),(2,'Thilinna Madhushan',22,'thilina','thilina_123'),(3,'Chanaka Madushan',21,'madushan','madu_123'),(4,'Sisitha Jayawardhana',22,'sjayawardhana','sj456'),(5,'Neminda Prabashwara',21,'nppiyasena','npp789'),(6,'Jeewantha Lahiru',23,'jlahiru','jl753'),(7,'Bemal Dvanitha',22,'bdvanitha','bd456'),(8,'Lahiru Ekanayake',21,'lahiru','12345'),(9,'sahan',22,'sahan','1234'),(10,'dimanka',22,'dima','dima123');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `subject_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `subject_code` varchar(15) NOT NULL,
  `subject_name` varchar(50) NOT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'SENG 12223','Data stuctures & Algorithems'),(2,'SENG 12212','Introduction to Databases'),(3,'SENG 12232','Object Orianted Progrmming');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_has_lecturer`
--

DROP TABLE IF EXISTS `subject_has_lecturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject_has_lecturer` (
  `lecturer_lecturer_id` int(10) unsigned NOT NULL,
  `subject_subject_id` int(15) unsigned NOT NULL,
  PRIMARY KEY (`lecturer_lecturer_id`,`subject_subject_id`),
  KEY `subject_subject_id` (`subject_subject_id`),
  CONSTRAINT `subject_has_lecturer_ibfk_1` FOREIGN KEY (`subject_subject_id`) REFERENCES `subject` (`subject_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `subject_has_lecturer_ibfk_2` FOREIGN KEY (`lecturer_lecturer_id`) REFERENCES `lecturer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_has_lecturer`
--

LOCK TABLES `subject_has_lecturer` WRITE;
/*!40000 ALTER TABLE `subject_has_lecturer` DISABLE KEYS */;
INSERT INTO `subject_has_lecturer` VALUES (1,1),(1,3),(3,1),(3,2),(3,3);
/*!40000 ALTER TABLE `subject_has_lecturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_has_student`
--

DROP TABLE IF EXISTS `subject_has_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject_has_student` (
  `student_student_id` int(10) unsigned NOT NULL,
  `subject_subject_id` int(15) unsigned NOT NULL,
  PRIMARY KEY (`student_student_id`,`subject_subject_id`),
  KEY `subject_subject_id` (`subject_subject_id`),
  CONSTRAINT `subject_has_student_ibfk_3` FOREIGN KEY (`student_student_id`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `subject_has_student_ibfk_4` FOREIGN KEY (`subject_subject_id`) REFERENCES `subject` (`subject_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_has_student`
--

LOCK TABLES `subject_has_student` WRITE;
/*!40000 ALTER TABLE `subject_has_student` DISABLE KEYS */;
INSERT INTO `subject_has_student` VALUES (1,1),(1,2),(1,3),(2,1),(2,2),(3,1),(3,3),(4,2),(4,3),(5,1),(6,2),(7,1),(7,3),(8,1),(8,2),(8,3),(9,1),(10,1),(10,2),(10,3);
/*!40000 ALTER TABLE `subject_has_student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-29 22:08:55
