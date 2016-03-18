-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: 127.0.0.1    Database: ALLSTAR
-- ------------------------------------------------------
-- Server version	5.7.10

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
-- Table structure for table `Ceremony`
--

DROP TABLE IF EXISTS `Ceremony`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Ceremony` (
  `CID` int(11) NOT NULL AUTO_INCREMENT,
  `CName` varchar(45) NOT NULL,
  `CYear` year(4) NOT NULL,
  PRIMARY KEY (`CID`),
  UNIQUE KEY `CID_UNIQUE` (`CID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ceremony`
--

LOCK TABLES `Ceremony` WRITE;
/*!40000 ALTER TABLE `Ceremony` DISABLE KEYS */;
INSERT INTO `Ceremony` VALUES (1,'88th Academy Awards',2016),(2,'87th Academy Awards',2015),(3,'86th Academy Awards',2014),(4,'85th Academy Awards',2013),(5,'84th Academy Awards',2012),(6,'83th Academy Awards',2011),(7,'82th Academy Awards',2010),(8,'81th Academy Awards',2009),(9,'80th Academy Awards',2008),(10,'79th Academy Awards',2007);
/*!40000 ALTER TABLE `Ceremony` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MAward`
--

DROP TABLE IF EXISTS `MAward`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MAward` (
  `MAID` int(11) NOT NULL AUTO_INCREMENT,
  `CID` int(11) NOT NULL,
  `MVID` int(11) NOT NULL,
  `MTitle` varchar(45) NOT NULL,
  `MIsWinner` enum('Nominee','Winner') NOT NULL,
  PRIMARY KEY (`MAID`),
  UNIQUE KEY `MAID_UNIQUE` (`MAID`),
  KEY `MACID_idx` (`CID`),
  KEY `MAMID_idx` (`MVID`),
  CONSTRAINT `MACID` FOREIGN KEY (`CID`) REFERENCES `Ceremony` (`CID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `MAMID` FOREIGN KEY (`MVID`) REFERENCES `Movie` (`MVID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MAward`
--

LOCK TABLES `MAward` WRITE;
/*!40000 ALTER TABLE `MAward` DISABLE KEYS */;
INSERT INTO `MAward` VALUES (1,1,2,'Best Picture','Nominee'),(2,1,1,'Best Picture','Nominee'),(3,1,3,'Best Adapted Screenplay','Nominee'),(4,1,2,'Best Adapted Screenplay','Winner'),(5,1,3,'Best Original Score','Nominee'),(6,1,1,'Best Sound Editing','Winner'),(7,1,1,'Best Sound Mixing','Winner'),(8,1,1,'Best Production Design','Winner'),(9,1,1,'Best Makeup and Hairstyling','Winner'),(10,1,3,'Best Cinematography','Nominee'),(11,1,1,'Best Cinematography','Nominee'),(12,1,1,'Best Costume Design','Winner'),(13,1,3,'Best Costume Design','Nominee'),(14,1,1,'Best Film Editing','Winner'),(15,1,2,'Best Film Editing','Nominee'),(16,1,1,'Best Visual Effects','Nominee');
/*!40000 ALTER TABLE `MAward` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Movie`
--

DROP TABLE IF EXISTS `Movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Movie` (
  `MVID` int(11) NOT NULL AUTO_INCREMENT,
  `MName` varchar(45) NOT NULL,
  `MYear` year(4) NOT NULL,
  `Genres` varchar(45) NOT NULL,
  `Language` varchar(45) NOT NULL,
  `SID` int(11) NOT NULL,
  `Rating` double NOT NULL,
  PRIMARY KEY (`MVID`),
  UNIQUE KEY `MID_UNIQUE` (`MVID`),
  KEY `SID_idx` (`SID`),
  CONSTRAINT `SID` FOREIGN KEY (`SID`) REFERENCES `Studio` (`SID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Movie`
--

LOCK TABLES `Movie` WRITE;
/*!40000 ALTER TABLE `Movie` DISABLE KEYS */;
INSERT INTO `Movie` VALUES (1,'Mad Max: Fury Road',2015,'Action','English',1,8.1),(2,'The Big Short',2015,'Drama','English',2,7.9),(3,'Carol',2015,'Drama','English',3,7.4),(4,'Joy',2015,'Drama','English',4,6.6);
/*!40000 ALTER TABLE `Movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PAward`
--

DROP TABLE IF EXISTS `PAward`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PAward` (
  `PAID` int(11) NOT NULL AUTO_INCREMENT,
  `PID` int(11) NOT NULL,
  `CID` int(11) NOT NULL,
  `PTitle` varchar(45) NOT NULL,
  `PIsWinner` enum('Nominee','Winner') NOT NULL,
  `MVID` int(11) NOT NULL,
  PRIMARY KEY (`PAID`),
  UNIQUE KEY `PAID_UNIQUE` (`PAID`),
  KEY `PID_idx` (`PID`),
  KEY `CID_idx` (`CID`),
  KEY `MID_idx` (`MVID`),
  CONSTRAINT `ACID` FOREIGN KEY (`CID`) REFERENCES `Ceremony` (`CID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `AMID` FOREIGN KEY (`MVID`) REFERENCES `Movie` (`MVID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `APID` FOREIGN KEY (`PID`) REFERENCES `Person` (`PID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PAward`
--

LOCK TABLES `PAward` WRITE;
/*!40000 ALTER TABLE `PAward` DISABLE KEYS */;
INSERT INTO `PAward` VALUES (1,4,1,'Best Director','Nominee',2),(2,3,1,'Best Director','Nominee',1),(3,10,1,'Best Actress','Nominee',3),(4,13,1,'Best Actress','Nominee',4),(5,5,1,'Best Supporting Actor','Nominee',2),(6,11,1,'Best Supporting Actress','Nominee',3);
/*!40000 ALTER TABLE `PAward` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Participate`
--

DROP TABLE IF EXISTS `Participate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Participate` (
  `PID` int(11) NOT NULL,
  `MVID` int(11) NOT NULL,
  `Role` varchar(45) NOT NULL,
  PRIMARY KEY (`PID`,`MVID`,`Role`),
  KEY `MID_idx` (`MVID`),
  CONSTRAINT `MID` FOREIGN KEY (`MVID`) REFERENCES `Movie` (`MVID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `PID` FOREIGN KEY (`PID`) REFERENCES `Person` (`PID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Participate`
--

LOCK TABLES `Participate` WRITE;
/*!40000 ALTER TABLE `Participate` DISABLE KEYS */;
INSERT INTO `Participate` VALUES (1,1,'Actress'),(2,1,'Actor'),(3,1,'Director'),(4,2,'Director'),(5,2,'Actor'),(6,2,'Actor'),(7,2,'Actor'),(8,2,'Actor'),(9,3,'Director'),(10,3,'Actress'),(11,3,'Actress'),(12,4,'Director'),(13,4,'Actress'),(14,4,'Actor');
/*!40000 ALTER TABLE `Participate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Person`
--

DROP TABLE IF EXISTS `Person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Person` (
  `PID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) NOT NULL,
  `LastName` varchar(45) NOT NULL,
  `Gender` enum('Male','Female') NOT NULL,
  `DoB` date NOT NULL,
  `Nationality` varchar(45) NOT NULL,
  `Age` int(11) NOT NULL,
  PRIMARY KEY (`PID`),
  UNIQUE KEY `PID_UNIQUE` (`PID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Person`
--

LOCK TABLES `Person` WRITE;
/*!40000 ALTER TABLE `Person` DISABLE KEYS */;
INSERT INTO `Person` VALUES (1,'Charlize','Theron','Female','1975-08-07','South Africa',40),(2,'Tom','Hardy','Male','1977-12-15','UK',38),(3,'George','Miller','Male','1945-03-03','Australia',71),(4,'Adam','Mckay','Male','1968-04-17','US',47),(5,'Christian','Bale','Male','1974-01-30','UK',42),(6,'Steve','Carell','Male','1962-08-16','US',53),(7,'Ryan','Gosling','Male','1980-11-12','Canada',35),(8,'Brad','Pitt','Male','1963-12-18','US',52),(9,'Todd','Haynes','Male','1961-01-02','US',55),(10,'Cate','BlanChett','Female','1969-05-14','Australia',46),(11,'Rooney','Mara','Female','1985-04-17','US',30),(12,'David','Russell','Male','1958-08-20','US',57),(13,'Jennifer','Lawrence','Female','1990-08-15','US',25),(14,'Robert','De Niro','Male','1943-08-17','US',72);
/*!40000 ALTER TABLE `Person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Studio`
--

DROP TABLE IF EXISTS `Studio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Studio` (
  `SID` int(11) NOT NULL AUTO_INCREMENT,
  `SName` varchar(45) NOT NULL,
  `Country` varchar(45) NOT NULL,
  PRIMARY KEY (`SID`),
  UNIQUE KEY `SID_UNIQUE` (`SID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Studio`
--

LOCK TABLES `Studio` WRITE;
/*!40000 ALTER TABLE `Studio` DISABLE KEYS */;
INSERT INTO `Studio` VALUES (1,'Kennedy Miller Mitchell','Australia'),(2,'Regency Enterprises','US'),(3,'Film4 Productions','UK'),(4,'20th Century Fox','US');
/*!40000 ALTER TABLE `Studio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-18 12:55:12
