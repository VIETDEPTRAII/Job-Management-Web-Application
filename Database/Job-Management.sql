-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: job-management
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `jobs`
--

DROP TABLE IF EXISTS `jobs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jobs` (
  `job_id` int(11) NOT NULL AUTO_INCREMENT,
  `jobname` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `jobtype` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `salary` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `company` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `location` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `desc` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobs`
--

LOCK TABLES `jobs` WRITE;
/*!40000 ALTER TABLE `jobs` DISABLE KEYS */;
INSERT INTO `jobs` VALUES (1,'Full Stack Developer','Full Time','$2200','Facebook','New York City, USA','Implementation of Web/Java application Implementation of Rest APIs '),(2,'Front-end Developer','Full Time','$1500','Google','New York City, USA','Being responsible for designing, developing VietTech products and outsourcing on the .NET/JAVA(Backend), Angular (Frontend) platform. Possess problem...'),(3,'Back-end Developer','Full Time','$1600','Microsoft','Orlando City, USA','Salary: Up to 1,600 USD (and + 1 Month Base Salary Bonus) To guide and assist junior members in development work and knowledge sharing. Help in...'),(4,'Spring Boot Developer','Full Time','$1900','ISC Quang trung','Ho Chi Minh City, VietNam','We need Java Backend Developers who love startup and open-minded environmentYour responsibilities will include:  Implement the microservices on backend...'),(7,'AngularJS Developer','Full Time','$1200','ISC Quang Trung','Vietnam','Implementation of Web/Java application Implementation of Rest APIs '),(10,'NodeJS Developer','Full Time','$1500','ISC Quang Trung','Vietnam','Chúng tôi cần tuyển lập trình viên NodeJS có kinh nghiệm làm việc với NodeJS trên 1 năm'),(11,'Angular 8 Developer','Full Time','$1300','ISC Quang Trung','Vietnam','Implementation of Web/Java application Implementation of Rest APIs '),(16,'Python Developer','Full Time','$1300','ISC Quang Trung','Vietnam','Implementation of Web/Python application Implementation of Rest APIs'),(18,'PHP Developer','Full Time','$1200','Facebook','New York City, USA','Implementation of Web/PHP application Implementation of Rest APIs'),(20,'RubyDeveloper','Full Time','$2000','Facebook','New York City, USA','Implementation of Web/Rubyapplication Implementation of Rest APIs');
/*!40000 ALTER TABLE `jobs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(150) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'nguyenthanhviet31031998@gmail.com','$2a$10$0aJcB6Vv7VQMqrC3Vn79u.5dmhLj5lmQRe6hCXjkc3RhXnqqMa2MG'),(2,'admin123@gmail.com','$2a$10$0aJcB6Vv7VQMqrC3Vn79u.5dmhLj5lmQRe6hCXjkc3RhXnqqMa2MG');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-24  5:26:55
