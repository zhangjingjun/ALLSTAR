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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ceremony`
--

LOCK TABLES `Ceremony` WRITE;
/*!40000 ALTER TABLE `Ceremony` DISABLE KEYS */;
INSERT INTO `Ceremony` VALUES (1,'OSCAR',2016),(2,'OSCAR',2015),(3,'OSCAR',2014),(4,'OSCAR',2013),(5,'OSCAR',2012),(6,'OSCAR',2011),(7,'OSCAR',2010),(8,'OSCAR',2009),(9,'OSCAR',2008),(10,'OSCAR',2007),(14,'OSCAR',1995),(15,'Golden Globes',1995),(16,'OSCAR',1973),(17,'Golden Globes',1973),(18,'OSCAR',1975),(19,'Golden Globes',1975),(20,'Golden Globes',2009),(21,'OSCAR',1994),(22,'Golden Globes',1994),(23,'OSCAR',1958),(24,'Golden Globes',1958),(25,'OSCAR',2004),(26,'Golden Globes',2004);
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
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MAward`
--

LOCK TABLES `MAward` WRITE;
/*!40000 ALTER TABLE `MAward` DISABLE KEYS */;
INSERT INTO `MAward` VALUES (1,1,2,'Best Picture','Nominee'),(2,1,1,'Best Picture','Nominee'),(3,1,3,'Best Adapted Screenplay','Nominee'),(4,1,2,'Best Adapted Screenplay','Winner'),(5,1,3,'Best Original Score','Nominee'),(6,1,1,'Best Sound Editing','Winner'),(7,1,1,'Best Sound Mixing','Winner'),(8,1,1,'Best Production Design','Winner'),(9,1,1,'Best Makeup and Hairstyling','Winner'),(10,1,3,'Best Cinematography','Nominee'),(11,1,1,'Best Cinematography','Nominee'),(12,1,1,'Best Costume Design','Winner'),(13,1,3,'Best Costume Design','Nominee'),(14,1,1,'Best Film Editing','Winner'),(15,1,2,'Best Film Editing','Nominee'),(16,1,1,'Best Visual Effects','Nominee'),(17,15,5,'Best Screenplay','Nominee'),(18,16,6,'Best Picture','Winner'),(19,14,5,'Best Picture','Nominee'),(20,14,5,'Best Screenplay','Nominee'),(21,14,5,'Best Sound','Nominee'),(22,14,5,'Best Music','Nominee'),(23,14,5,'Best Editing','Nominee'),(24,16,6,'Best Screenplay','Winner'),(25,16,6,'Best Costume Design','Nominee'),(26,16,6,'Best Sound','Nominee'),(27,16,6,'Best Editing','Nominee'),(28,16,6,'Best Music','Nominee'),(29,17,6,'Best Motion Picture','Winner'),(30,17,6,'Best Screenplay','Winner'),(31,17,6,'Best Original Score','Winner'),(32,18,7,'Best Picture','Winner'),(33,18,7,'Best Screenplay','Winner'),(34,18,7,'Best Music','Winner'),(35,18,7,'Best Costume Design','Nominee'),(36,19,7,'Best Motion Picture','Nominee'),(37,19,7,'Best Screenplay','Nominee'),(38,8,8,'Best Sound','Winner'),(39,8,8,'Best Editing','Nominee'),(40,8,8,'Best Makeup','Nominee'),(41,8,8,'Best Visual Effects','Nominee'),(42,21,9,'Best Picture','Winner'),(43,21,9,'Best Screenplay','Winner'),(44,21,9,'Best Cinematography','Winner'),(45,21,9,'Best Music','Winner'),(46,21,9,'Best Costume Design','Nominee'),(47,21,9,'Best Sound','Nominee'),(48,21,9,'Best Makeup','Nominee'),(49,22,9,'Best Motion Picture','Winner'),(50,22,9,'Best Screenplay','Winner'),(51,22,9,'Best Original Score','Nominee'),(52,23,10,'Best Picture','Nominee'),(53,23,10,'Best Screenplay','Nominee'),(54,24,10,'Best Motion Picture','Nominee'),(55,14,11,'Best Screenplay','Winner'),(56,14,11,'Best Picture','Nominee'),(57,14,11,'Best Editing','Nominee'),(58,15,11,'Best Screenplay','Winner'),(59,15,11,'Best Motion Picture','Nominee'),(60,25,12,'Best Picture','Winner'),(61,25,12,'Best Screenplay','Winner'),(62,25,12,'Best Editing','Winner'),(63,25,12,'Best Costume Design','Winner'),(64,25,12,'Best Makeup','Winner'),(65,25,12,'Best Music','Winner'),(66,25,12,'Best Sound','Winner'),(67,25,12,'Best Visual Effects','Winner'),(68,26,12,'Best Motion Picture','Winner');
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
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Movie`
--

LOCK TABLES `Movie` WRITE;
/*!40000 ALTER TABLE `Movie` DISABLE KEYS */;
INSERT INTO `Movie` VALUES (1,'Mad Max: Fury Road',2015,'Action','English',1,8.1),(2,'The Big Short',2015,'Drama','English',2,7.9),(3,'Carol',2015,'Drama','English',3,7.4),(4,'Joy',2015,'Drama','English',4,6.6),(5,'The Shawshank Redemption',1994,'Drama','English',89,9.3),(6,'The Godfather',1972,'Drama','English',160,9.2),(7,'The Godfather: Part II',1974,'Drama','English',160,9),(8,'The Dark Knight',2008,'Action','English',219,9),(9,'Schindlers List',1994,'Drama','English',211,8.9),(10,'12 Angry Men',1957,'Drama','English',157,8.9),(11,'Pulp Fiction',1994,'Drama','English',149,8.9),(12,'The Lord of the Rings III',2003,'Fantasy','English',155,8.9),(13,'Fight Club',1999,'Drama','English',4,8.9),(14,'The Lord of the Rings I',2001,'Fantasy','English',155,8.8),(15,'Star Wars: Episode V',1980,'Fantasy','English',142,8.8),(16,'Forrest Gump',1994,'Drama','English',160,8.8),(17,'Inception',2010,'Sci-Fi','English',219,8.8),(18,'The Lord of the Rings II',2002,'Fantasy','English',155,8.7),(19,'Goodfellas',1990,'Fantasy','English',219,8.7),(20,'The Matrix',1999,'Sci-Fi','English',219,8.7),(21,'Star Wars',1977,'Fantasy','English',142,8.7),(22,'Se7en',1995,'Drama','English',155,8.6),(23,'The Silence of the Lambs',1991,'Drama','English',157,8.6),(24,'The Usual Suspects',1995,'Drama','English',63,8.6),(25,'Saving Private Ryan',1998,'Drama','English',101,8.6),(26,'Interstellar',2014,'Sci-Fi','English',219,8.6),(27,'American History X',1998,'Drama','English',155,8.6),(28,'The Green Mile',1999,'Drama','English',89,8.5),(29,'Terminator 2: Judgment Day',1991,'Sci-Fi','English',137,8.5),(30,'The Departed',2006,'Drama','English',219,8.5),(31,'Back to the Future',1985,'Sci-Fi','English',211,8.5),(32,'Gladiator',2000,'Drama','English',101,8.5),(33,'The Prestige',2006,'Drama','English',203,8.5),(34,'Django Unchained',2012,'Western','English',95,8.5);
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
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PAward`
--

LOCK TABLES `PAward` WRITE;
/*!40000 ALTER TABLE `PAward` DISABLE KEYS */;
INSERT INTO `PAward` VALUES (1,4,1,'Best Director','Nominee',2),(2,3,1,'Best Director','Nominee',1),(3,10,1,'Best Actress','Nominee',3),(4,13,1,'Best Actress','Nominee',4),(5,5,1,'Best Supporting Actor','Nominee',2),(6,11,1,'Best Supporting Actress','Nominee',3),(7,142,14,'Best Actor','Nominee',5),(8,177,16,'Best Supporting Actor','Nominee',6),(9,111,16,'Best Actor','Winner',6),(10,234,16,'Best Director','Nominee',6),(11,234,17,'Best Director','Winner',6),(12,111,17,'Best Actor','Winner',6),(13,177,17,'Best Actor','Nominee',6),(14,14,18,'Best Actor','Winner',7),(15,234,18,'Best Director','Winner',7),(16,177,18,'Best Actor','Nominee',7),(17,177,19,'Best Actor','Nominee',7),(18,234,19,'Best Director','Nominee',7),(19,70,8,'Best Supporting Actor','Winner',8),(20,70,20,'Best Supporting Actor','Winner',8),(21,236,21,'Best Director','Winner',9),(22,236,22,'Best Director','Winner',9),(23,23,21,'Best Actor','Nominee',9),(24,59,24,'Best Actor','Nominee',10),(25,238,14,'Best Actor','Nominee',11),(26,240,14,'Best Supporting Actor','Nominee',11),(27,239,14,'Best Actress','Nominee',11),(28,237,14,'Best Director','Nominee',11),(29,237,15,'Best Director','Nominee',11),(30,239,15,'Best Actress','Nominee',11),(31,240,15,'Best Supporting Actor','Nominee',11),(32,238,15,'Best Actor','Nominee',11),(33,241,25,'Best Director','Winner',12),(34,241,26,'Best Director','Winner',12);
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
INSERT INTO `Participate` VALUES (1,1,'Actress'),(2,1,'Actor'),(3,1,'Director'),(4,2,'Director'),(5,2,'Actor'),(6,2,'Actor'),(7,2,'Actor'),(8,2,'Actor'),(9,3,'Director'),(10,3,'Actress'),(11,3,'Actress'),(12,4,'Director'),(13,4,'Actress'),(14,4,'Actor'),(56,5,'Actor'),(142,5,'Actor'),(233,5,'Director'),(111,6,'Actor'),(177,6,'Actor'),(234,6,'Director'),(14,7,'Actor'),(177,7,'Actor'),(234,7,'Director'),(5,8,'Actor'),(235,8,'Director'),(23,9,'Actor'),(236,9,'Director'),(69,11,'Actor'),(220,11,'Actor'),(237,11,'Actor'),(237,11,'Director'),(238,11,'Actor'),(239,11,'Actress'),(240,11,'Actor'),(10,12,'Actress'),(71,12,'Actor'),(241,12,'Director'),(8,13,'Actor'),(243,13,'Director'),(10,14,'Actress'),(18,14,'Actor'),(71,14,'Actor'),(241,14,'Director'),(43,15,'Actor'),(113,15,'Actor'),(115,15,'Actor'),(244,15,'Director'),(213,16,'Actor'),(245,16,'Director'),(2,17,'Actor'),(33,17,'Actor'),(121,17,'Actor'),(140,17,'Actor'),(235,17,'Director'),(10,18,'Actress'),(71,18,'Actor'),(119,18,'Actor'),(241,18,'Director'),(122,19,'Actor'),(246,19,'Director'),(85,20,'Actor'),(149,20,'Actor'),(193,20,'Actress'),(208,20,'Actor'),(247,20,'Director'),(43,21,'Actor'),(113,21,'Actor'),(115,21,'Actor'),(248,21,'Director'),(8,22,'Actor'),(138,22,'Actor'),(142,22,'Actor'),(243,22,'Director'),(93,23,'Actor'),(249,23,'Director'),(92,24,'Actor'),(103,24,'Actor'),(183,24,'Actor'),(199,24,'Actor'),(250,24,'Director'),(26,25,'Actor'),(128,25,'Actor'),(213,25,'Actor'),(215,25,'Actor'),(236,25,'Director'),(33,26,'Actor'),(49,26,'Actor'),(152,26,'Actress'),(235,26,'Director'),(139,27,'Actor'),(66,28,'Actor'),(213,28,'Actor'),(233,28,'Director'),(79,29,'Actor'),(139,29,'Actor'),(173,29,'Actress'),(26,30,'Actor'),(68,30,'Actor'),(132,30,'Actor'),(246,30,'Director'),(53,31,'Actor'),(245,31,'Director'),(21,32,'Actor'),(38,32,'Actor'),(5,33,'Actor'),(33,33,'Actor'),(224,33,'Actor'),(235,33,'Director'),(121,34,'Actor'),(148,34,'Actor'),(172,34,'Actor'),(237,34,'Director');
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
) ENGINE=InnoDB AUTO_INCREMENT=251 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Person`
--

LOCK TABLES `Person` WRITE;
/*!40000 ALTER TABLE `Person` DISABLE KEYS */;
INSERT INTO `Person` VALUES (1,'Charlize','Theron','Female','1975-08-07','South Africa',40),(2,'Tom','Hardy','Male','1977-12-15','UK',38),(3,'George','Miller','Male','1945-03-03','Australia',71),(4,'Adam','Mckay','Male','1968-04-17','US',47),(5,'Christian','Bale','Male','1974-01-30','UK',42),(6,'Steve','Carell','Male','1962-08-16','US',53),(7,'Ryan','Gosling','Male','1980-11-12','Canada',35),(8,'Brad','Pitt','Male','1963-12-18','US',52),(9,'Todd','Haynes','Male','1961-01-02','US',55),(10,'Cate','BlanChett','Female','1969-05-14','Australia',46),(11,'Rooney','Mara','Female','1985-04-17','US',30),(12,'David','Russell','Male','1958-08-20','US',57),(13,'Jennifer','Lawrence','Female','1990-08-15','US',25),(14,'Robert','De Niro','Male','1943-08-17','US',72),(15,'Shinichi','Himori','Male','1907-01-10','US',109),(16,'Alfred','Abel','Male','1879-03-12','US',137),(17,'Tom','Hulce','Male','1953-12-06','US',63),(18,'Alan','Howard','Male','1937-08-05','US',79),(19,'Fred','MacMurray','Male','1908-08-30','US',108),(20,'Peter','Brocco','Male','1903-01-16','US',113),(21,'Russell','Crowe','Male','1964-04-07','US',52),(22,'Rumi','Hiiragi','Female','1987-08-01','US',29),(23,'Liam','Neeson','Male','1952-06-07','US',64),(24,'George','OBrien','Male','1899-04-19','US',117),(25,'Tony','Curtis','Male','1925-06-03','US',91),(26,'Matt','Damon','Male','1970-10-08','US',46),(27,'Tim','Allen','Male','1953-06-13','US',63),(28,'Adrien','Brody','Male','1973-04-14','US',43),(29,'Phyllis','Smith','Female','1951-07-10','US',65),(30,'Thomas','Bo','Male','1963-11-27','US',53),(31,'Anthony','Perkins','Male','1932-04-04','US',84),(32,'Jodie','Foster','Female','1962-11-19','US',54),(33,'Michael','Caine','Male','1933-03-14','US',83),(34,'Natalie','Portman','Female','1981-06-09','US',35),(35,'George','Caine','Male','1927-10-18','US',89),(36,'Graham','Chapman','Male','1941-01-08','US',75),(37,'Mads','Mikkelsen','Male','1965-11-22','US',51),(38,'Joaquin','Phoenix','Male','1974-10-28','US',42),(39,'James','Robinson','Male','1983-09-06','US',33),(40,'Joel','Edgerton','Male','1974-06-23','US',42),(41,'Enzo','Cannavale','Male','1928-04-05','US',88),(42,'Claudia','Cardinale','Female','1938-04-15','US',78),(43,'Mark','Hamill','Male','1951-09-25','US',65),(44,'Christopher','Plummer','Male','1929-12-13','US',87),(45,'Ginnifer','Goodwin','Female','1978-05-22','US',38),(46,'Shirley','MacLaine','Female','1934-04-24','US',82),(47,'Jared','Leto','Male','1971-12-26','US',45),(48,'John','Megna','Male','1952-11-09','US',64),(49,'Matthew','McConaughey','Male','1969-11-04','US',47),(50,'Edward','Asner','Male','1929-11-15','US',87),(51,'Hitoshi','Takagi','Male','1925-02-26','US',91),(52,'Ralph','Meeker','Male','1920-11-21','US',96),(53,'Christopher','Lloyd','Male','1938-10-22','US',78),(54,'Bonnie','Bedelia','Female','1948-03-25','US',68),(55,'Edward','Norton','Male','1969-08-18','US',47),(56,'Tim','Robbins','Male','1958-10-16','US',58),(57,'Walter','Huston','Male','1883-04-05','US',133),(58,'Brad','Pitt','Male','1963-12-18','US',53),(59,'Henry','Fonda','Male','1905-05-16','US',111),(60,'Grace','Kelly','Female','1929-11-12','US',87),(61,'Ed','Harris','Male','1950-11-28','US',66),(62,'Gregory','Peck','Male','1916-04-05','US',100),(63,'Spencer','Breslin','Male','1992-05-18','US',24),(64,'Emilia','Fox','Female','1974-07-31','US',42),(65,'Miles','Teller','Male','1987-02-20','US',29),(66,'David','Morse','Male','1953-10-11','US',63),(67,'Tyrone','Power','Male','1914-05-05','US',102),(68,'Martin','Sheen','Male','1940-08-03','US',76),(69,'Bruce','Willis','Male','1955-03-19','US',61),(70,'Heath','Ledger','Male','1979-04-04','US',37),(71,'Sean','Astin','Male','1971-02-25','US',45),(72,'Virginia','Cherrill','Female','1908-04-12','US',108),(73,'Anne','Baxter','Female','1923-05-07','US',93),(74,'Shelley','Duvall','Female','1949-07-07','US',67),(75,'Burt','Lancaster','Male','1913-11-02','US',103),(76,'Tom','Skerritt','Male','1933-08-25','US',83),(77,'Joan','Fontaine','Female','1917-10-22','US',99),(78,'Faye','Dunaway','Female','1941-01-14','US',75),(79,'Arnold','Schwarzenegger','Male','1947-07-30','US',69),(80,'Billy','Crudup','Male','1968-07-08','US',48),(81,'Steve','McQueen','Male','1930-03-24','US',86),(82,'Buster','Keaton','Male','1895-10-04','US',121),(83,'James','Garner','Male','1928-04-07','US',88),(84,'Brie','Larson','Female','1989-10-01','US',27),(85,'Hugo','Weaving','Male','1960-04-04','US',56),(86,'Chika','Sakamoto','Female','1959-08-17','US',57),(87,'Kirk','Douglas','Male','1916-12-09','US',100),(88,'Kim','Novak','Female','1933-02-13','US',83),(89,'Barbara','Stanwyck','Female','1907-07-16','US',109),(90,'Malcolm','McDowell','Male','1943-06-13','US',73),(91,'Guy','Pearce','Male','1967-10-05','US',49),(92,'Gabriel','Byrne','Male','1950-05-12','US',66),(93,'Anthony','Hopkins','Male','1937-12-31','US',79),(94,'Michael','Berryman','Male','1948-09-04','US',68),(95,'Amanda','Plummer','Female','1957-03-23','US',59),(96,'Jonah','Hill','Male','1983-12-20','US',33),(97,'Donna','DeLory','Female','1964-09-10','US',52),(98,'Martina','Gedeck','Female','1961-09-14','US',55),(99,'Matthew','Broderick','Male','1962-03-21','US',54),(100,'Alida','Valli','Female','1921-05-31','US',95),(101,'Joseph','Cotten','Male','1905-05-15','US',111),(102,'Paul','Newman','Male','1925-01-26','US',91),(103,'Stephen','Baldwin','Male','1966-05-12','US',50),(104,'Bengt','Ekerot','Male','1920-02-08','US',96),(105,'John','Fiedler','Male','1925-02-03','US',91),(106,'Martin','Balsam','Male','1919-11-04','US',97),(107,'Ingrid','Bergman','Female','1915-08-29','US',101),(108,'Rutger','Hauer','Male','1944-01-23','US',72),(109,'Gene','Kelly','Male','1912-08-23','US',104),(110,'Bibi','Andersson','Female','1935-11-11','US',81),(111,'Marlon','Brando','Male','1924-04-03','US',92),(112,'Vera','Miles','Female','1929-08-23','US',87),(113,'Alec','Guinness','Male','1914-04-02','US',102),(114,'Donna','Reed','Female','1921-01-27','US',95),(115,'Harrison','Ford','Male','1942-07-13','US',74),(117,'Robert','Redford','Male','1936-08-18','US',80),(118,'Cathy','Moriarty','Female','1960-11-29','US',56),(119,'Bruce','Allpress','Male','1930-08-25','US',86),(120,'Janet','Gaynor','Female','1906-10-06','US',110),(121,'Leonardo','DiCaprio','Male','1974-11-11','US',42),(122,'Ray','Liotta','Male','1954-12-18','US',62),(124,'Takashi','Shimura','Male','1905-03-12','US',111),(125,'Nicoletta','Braschi','Female','1960-04-19','US',56),(127,'Jonathan','Taylor','Male','1981-09-08','US',35),(128,'Dennis','Farina','Male','1944-02-29','US',72),(129,'Robert','Duvall','Male','1931-01-05','US',85),(132,'Jack','Nicholson','Male','1937-04-22','US',79),(133,'Alexandre','Rodrigues','Male','1983-05-21','US',33),(134,'Diahnne','Abbott','Female','1945-05-01','US',71),(135,'Robin','Williams','Male','1951-07-21','US',65),(137,'Amy','Poehler','Female','1971-09-16','US',45),(138,'Andrew','Kevin','Male','1964-08-14','US',52),(139,'Edward','Furlong','Male','1977-08-02','US',39),(140,'Joseph','Gordon-Levitt','Male','1981-02-17','US',35),(141,'Leila','Hatami','Female','1972-10-01','US',44),(142,'Morgan','Freeman','Male','1937-06-01','US',79),(143,'Miyu','Irino','Male','1988-02-19','US',28),(144,'Jason','Bateman','Male','1969-01-14','US',47),(145,'Jeff','Bridges','Male','1949-12-04','US',67),(146,'Matthew','Modine','Male','1959-03-22','US',57),(147,'Paulette','Goddard','Female','1910-06-03','US',106),(148,'Christoph','Waltz','Male','1956-10-04','US',60),(149,'Keanu','Reeves','Male','1964-09-02','US',52),(151,'Jack','Oakie','Male','1903-11-12','US',113),(152,'Ellen','Burstyn','Female','1932-12-07','US',84),(153,'Laurence','Olivier','Male','1907-05-22','US',109),(154,'Mack','Swain','Male','1876-02-16','US',140),(155,'John','Cazale','Male','1935-08-12','US',81),(156,'Takuya','Kimura','Male','1972-11-13','US',44),(157,'Annette','Bening','Female','1958-05-29','US',58),(158,'John','Cleese','Male','1939-10-27','US',77),(159,'Tom','Hardy','Male','1977-09-15','US',39),(160,'Christopher','Carley','Male','1978-05-31','US',38),(161,'John','Hurt','Male','1940-01-22','US',76),(162,'Eva','Marie','Female','1924-07-04','US',92),(163,'Eli','Wallach','Male','1915-12-07','US',101),(164,'William','Holden','Male','1918-04-17','US',98),(165,'Jason','Flemyng','Male','1966-09-25','US',50),(167,'Steven','Bauer','Male','1956-12-02','US',60),(168,'Carrie','Henn','Female','1976-05-07','US',40),(169,'Leandro','Firmino','Male','1978-06-23','US',38),(170,'Sean','Lawlor','Male','1954-01-25','US',62),(171,'Aamir','Khan','Male','1965-03-14','US',51),(172,'Jamie','Foxx','Male','1967-12-13','US',49),(173,'Linda','Hamilton','Female','1956-09-26','US',60),(174,'Ivana','Baquero','Female','1994-06-11','US',22),(175,'Roberto','Benigni','Male','1952-10-27','US',64),(176,'Gene','Hackman','Male','1930-01-30','US',86),(177,'Al','Pacino','Male','1940-04-25','US',76),(178,'Jacob','Tremblay','Male','2006-10-05','US',10),(179,'Billy','Bob','Male','1955-08-04','US',61),(180,'Bruno','Ganz','Male','1941-03-22','US',75),(181,'Ben','Kingsley','Male','1943-12-31','US',73),(182,'Jim','Carrey','Male','1962-01-17','US',54),(183,'Kevin','Spacey','Male','1959-07-26','US',57),(184,'Jack','Lemmon','Male','1925-02-08','US',91),(186,'Sean','Connery','Male','1930-08-25','US',86),(187,'Patrick','Magee','Male','1922-03-31','US',94),(188,'Gary','Oldman','Male','1958-03-21','US',58),(189,'Dorothy','Comingore','Female','1913-08-24','US',103),(190,'Cary','Grant','Male','1904-01-18','US',112),(191,'Alexandra','Maria','Female','1978-11-12','US',38),(192,'Marilyn','Monroe','Female','1926-06-01','US',90),(193,'Carrie-Anne','Moss','Female','1967-08-21','US',49),(195,'Kate','Winslet','Female','1975-10-05','US',41),(196,'Keir','Dullea','Male','1936-05-30','US',80),(197,'Sharon','Stone','Female','1958-03-10','US',58),(198,'Karen','Allen','Female','1951-10-05','US',65),(199,'Benicio','Del','Male','1967-02-19','US',49),(200,'Jean','Arthur','Female','1900-10-17','US',116),(201,'Dexter','Fletcher','Male','1966-01-31','US',50),(202,'Soledad','Villamil','Female','1969-06-19','US',47),(203,'Min-sik','Choi','Male','1962-01-22','US',54),(204,'Bette','Davis','Female','1908-04-05','US',108),(205,'Enzo','Staiola','Male','1939-11-15','US',77),(206,'Adam','Baldwin','Male','1962-02-27','US',54),(207,'Akira','Terao','Male','1947-05-18','US',69),(208,'Laurence','Fishburne','Male','1961-07-30','US',55),(209,'Christian','Bale','Male','1974-01-30','US',42),(210,'Charles','Chaplin','Male','1889-04-16','US',127),(211,'Gary','Lockwood','Male','1937-02-21','US',79),(212,'John','Goodman','Male','1952-06-20','US',64),(213,'Tom','Hanks','Male','1956-07-09','US',60),(214,'Sigourney','Weaver','Female','1949-10-08','US',67),(215,'Tom','Sizemore','Male','1961-11-29','US',55),(216,'Ryan','Reynolds','Male','1976-10-23','US',40),(217,'Gloria','Swanson','Female','1899-03-27','US',117),(218,'Tatsuya','Nakadai','Male','1932-12-13','US',84),(219,'Marlene','Dietrich','Female','1901-12-27','US',115),(220,'Tim','Roth','Male','1961-05-14','US',55),(221,'Clint','Eastwood','Male','1930-05-31','US',86),(223,'James','Woods','Male','1947-04-18','US',69),(224,'Hugh','Jackman','Male','1968-10-12','US',48),(225,'Lamberto','Maggiorani','Male','1909-08-28','US',107),(226,'Karl','Malden','Male','1912-03-22','US',104),(227,'Peter','Sellers','Male','1925-09-08','US',91),(228,'Harvey','Keitel','Male','1939-05-13','US',77),(229,'Spencer','Tracy','Male','1900-04-05','US',116),(230,'Lee','Van','Male','1925-01-09','US',91),(231,'Humphrey','Bogart','Male','1899-12-25','US',117),(232,'James','Stewart','Male','1908-05-20','US',108),(233,'Frank','Darabont','Male','1959-01-28','US',57),(234,'Francis','Coppola','Male','1939-04-07','US',77),(235,'Christopher','Nolan','Male','1970-07-30','US',45),(236,'Steven','Spielberg','Male','1946-12-18','US',69),(237,'Quentin','Tarantino','Male','1963-03-27','US',53),(238,'John','Travolta','Male','1954-02-18','US',62),(239,'Uma','Thurman','Female','1970-04-29','US',45),(240,'Samuel','Jackson','Male','1948-12-21','US',67),(241,'Peter','Jackson','Male','1961-10-31','New Zealand',54),(242,'Sergio','Leone','Male','1929-01-03','Italy',87),(243,'David','Fincher','Male','1962-08-28','US',53),(244,'Irvin','Kershner','Male','1923-11-27','US',87),(245,'Robert','Zemeckis','Male','1952-05-14','US',63),(246,'Martin','Scorsese','Male','1942-11-17','US',73),(247,'Lana','Wachowski','Female','1965-06-21','US',50),(248,'George','Lucas','Male','1944-05-14','US',71),(249,'Jonathan','Demme','Male','1944-02-22','US',72),(250,'Bryan','Singer','Male','1965-09-17','US',50);
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
) ENGINE=InnoDB AUTO_INCREMENT=230 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Studio`
--

LOCK TABLES `Studio` WRITE;
/*!40000 ALTER TABLE `Studio` DISABLE KEYS */;
INSERT INTO `Studio` VALUES (1,'Kennedy Miller Mitchell','Australia'),(2,'Regency Enterprises','US'),(3,'Film4 Productions','UK'),(4,'20th Century Fox','US'),(5,'Zagreb Film','Croatia'),(6,'Jadran Film','Croatia'),(7,'Croatia Film','Croatia'),(8,'Barrandov Studios','Czech Republic'),(9,'Nordisk Film','Denmark'),(10,'Saga Studios','Denmark'),(11,'ADASTRA Films','France'),(12,'Disneynature','France'),(13,'Les Films du Poisson','France'),(14,'Gaumont Film Company','France'),(15,'Path','France'),(16,'StudioCanal','France'),(17,'Bavaria Film','Germany'),(18,'Constantin Film','Germany'),(19,'Deutsche Film-Aktiengesellschaft(DEFA)','Germany'),(20,'Neue deutsche Filmgesellschaft','Germany'),(21,'Rialto Film','Germany'),(22,'Studio Babelsberg','Germany'),(23,'Universum Film AG(UFA)','Germany'),(24,'Wild Bunch','Germany'),(25,'Cinecitt','Italy'),(26,'Titanus','Italy'),(27,'Eiken','Japan'),(28,'Enoki Films','Japan'),(29,'Kadokawa Pictures','Japan'),(30,'Makino Film Productions','Japan'),(31,'Nikkatsu','Japan'),(32,'Shintoho','Japan'),(33,'Shochiku','Japan'),(34,'Studio Ghibli','Japan'),(35,'Taish_ Katsuei','Japan'),(36,'Tennenshoku Katsud_ Shashin','Japan'),(37,'Toei Company','Japan'),(38,'Toho','Japan'),(39,'Yokota Sh_kai','Japan'),(40,'Yoshizawa Sh_ten','Japan'),(41,'ACT 2 CAM','UK'),(42,'Anglo-Amalgamated Productions Ltd.','UK'),(43,'Aura Films','UK'),(44,'BBC Films','UK'),(45,'British Lion Films','UK'),(46,'DNA Films','UK'),(47,'Dragon International Film Studios','UK'),(48,'Ealing Films Ltd.','UK'),(49,'Elstree Studios','UK'),(50,'Eon Productions','UK'),(51,'Film Tank','UK'),(52,'Fingercuff Productions','UK'),(53,'Gainsborough Pictures','UK'),(54,'Gate Studios','UK'),(55,'Hammer Film Productions Ltd.','UK'),(56,'Heyday Films','UK'),(57,'Intermedia','UK'),(58,'ITC EntertainmentProductions','UK'),(59,'Magma Pictures','UK'),(60,'Marv Films','UK'),(61,'Merton Park Studios','UK'),(62,'Pinewood Studios','UK'),(63,'PolyGram Filmed Entertainment','UK'),(64,'Rank Organisation Film Productions Ltd.','UK'),(65,'Shepperton Studios','UK'),(66,'Syncopy Inc.','UK'),(67,'Teddington Studios','UK'),(68,'Three Mills Studios','UK'),(69,'Twickenham Studios','UK'),(70,'Vertigo Films','UK'),(71,'Warp Films','UK'),(72,'Working Title Films','UK'),(73,'3ality Digital','US'),(74,'40 Acres and a Mule Filmworks','US'),(75,'606 Films','US'),(76,'2929 Productions','US'),(77,'Allied Artists Pictures Corporation','US'),(78,'Amblin Entertainment','US'),(79,'American International Pictures','US'),(80,'American Zoetrope','US'),(81,'Artisan Entertainment','US'),(82,'AvnetKerner Productions','US'),(83,'Batjac Productions Inc.','US'),(84,'Blinding Edge Pictures','US'),(85,'Blue Sky Studios','US'),(86,'Capitol Films','US'),(87,'Caravan Pictures','US'),(88,'Carolco Pictures','US'),(89,'Castle Rock Entertainment','US'),(90,'CBS Films','US'),(91,'Cedar Grove Productions','US'),(92,'Christie Film Company','US'),(93,'Cinemation Industries','US'),(94,'Cinergi Pictures','US'),(95,'Columbia Pictures','US'),(96,'Columbia TriStar Motion Picture Group','US'),(97,'Compass International Pictures','US'),(98,'Davis Entertainment','US'),(99,'Destination Films','US'),(100,'Dimension Films','US'),(101,'DreamWorks','US'),(102,'DreamWorks Animation','US'),(103,'E1 Entertainment','US'),(104,'Edison Black Maria','US'),(105,'Electric Entertainment','US'),(106,'Elevating Entertainment Motion Pictures','US'),(107,'Embassy Pictures','US'),(108,'Esperanto Filmoj','US'),(109,'Essanay Studios','US'),(110,'Famous Players-Lasky','US'),(111,'Film Booking Offices of America','US'),(112,'Filmways','US'),(113,'Fine Line Features','US'),(114,'First Look Studios','US'),(115,'First National','US'),(116,'Five & Two Pictures','US'),(117,'Flavor Unit Entertainment','US'),(118,'Focus Features','US'),(119,'Four Star Television','US'),(120,'Fox Film Corporation','US'),(121,'Fox Searchlight Pictures','US'),(122,'Gener8Xion Entertainment','US'),(123,'Golan-Globus','US'),(124,'Goldwyn Pictures','US'),(125,'Hallmark Productions','US'),(126,'Hannover House','US'),(127,'Happy Madison Productions','US'),(128,'Heritage Film Project','US'),(129,'Hollywood Pictures','US'),(130,'IFC Films','US'),(131,'Image Entertainment','US'),(132,'Interscope Pictures','US'),(133,'Kalem Company','US'),(134,'Keystone Studios','US'),(135,'Legendary Pictures','US'),(136,'Liberty Films','US'),(137,'Lightstorm Entertainment','US'),(138,'Lightyear Entertainment','US'),(139,'Limelight Department','US'),(140,'Lions Gate Entertainment','US'),(141,'Lubin Studios','US'),(142,'Lucasfilm','US'),(143,'Magnolia Pictures','US'),(144,'Marvel Studios','US'),(145,'Mascot Pictures Corporation','US'),(146,'Mercury Radio Arts','US'),(147,'Metro Pictures','US'),(148,'Metro-Goldwyn-Mayer','US'),(149,'Miramax Films','US'),(150,'Monogram Pictures','US'),(151,'Mutual Film','US'),(152,'Neo Art & Logic','US'),(153,'Newmarket Films','US'),(154,'Nestor Studios','US'),(155,'New Line Cinema','US'),(156,'Original Film','US'),(157,'Orion Pictures Corporation','US'),(158,'Overture Films','US'),(159,'Pacific International Enterprises','US'),(160,'Paramount Pictures','US'),(161,'Paramount Vantage','US'),(162,'Picturehouse','US'),(163,'Pixar Animation Studios','US'),(164,'Possibility Pictures','US'),(165,'Praise Pictures','US'),(166,'Premium Picture Productions','US'),(167,'Producers Releasing Corporation','US'),(168,'Promenade Pictures','US'),(169,'Pure Flix Entertainment','US'),(170,'Reliance-Majestic Studios','US'),(171,'Republic Pictures','US'),(172,'RKO Pictures','US'),(173,'Rogue Pictures','US'),(174,'Rolfe Photoplays','US'),(175,'Rooster Teeth Productions','US'),(176,'Samuel Goldwyn Films','US'),(177,'Scott Free','US'),(178,'Screen Gems','US'),(179,'Screen Media Films','US'),(180,'Selig Polyscope Company','US'),(181,'Selznick International Pictures','US'),(182,'Sherwood Pictures','US'),(183,'Sierra Pictures','US'),(184,'Silver Pictures','US'),(185,'Skydance Productions','US'),(186,'Solax Studios','US'),(187,'Sony Pictures Animation','US'),(188,'Sony Pictures Classics','US'),(189,'Soup2Nuts','US'),(190,'Spiderwood Productions','US'),(191,'Spyglass Entertainment','US'),(192,'Square Pictures','US'),(193,'Strand Releasing','US'),(194,'Streamline Pictures','US'),(195,'Sun Haven Studios','US'),(196,'Summit Entertainment','US'),(197,'Temple Hill Entertainment','US'),(198,'Thanhouser Company','US'),(199,'The Samuel Goldwyn Company','US'),(200,'THINKFilm','US'),(201,'Through A Glass Productions','US'),(202,'Tiffany Pictures','US'),(203,'Touchstone Pictures','US'),(204,'Trimark Pictures','US'),(205,'TriStar Pictures','US'),(206,'Troma Entertainment','US'),(207,'20th Century Fox','US'),(208,'Uncommon Productions','US'),(209,'United ArtistsEntertainment','US'),(210,'US Productions','US'),(211,'Universal Studios','US'),(212,'Illumination Entertainment','US'),(213,'Victor Studios','US'),(214,'Vitagraph Studios','US'),(215,'Vivendi Entertainment','US'),(216,'Walden Media','US'),(217,'The Walt Disney Studios','US'),(218,'Walt Disney Pictures','US'),(219,'Warner Bros','US'),(220,'Warner Independent Pictures','US'),(221,'The Weinstein Company','US'),(222,'Tyler Perry Studios','US'),(223,'Welling Films','US'),(224,'Western Film Exchange','US'),(225,'The Whartons Studio','US'),(226,'World Wide Pictures','US'),(227,'Worldview Entertainment','US'),(228,'WWE Studios','US'),(229,'Yari Film Group','US');
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

-- Dump completed on 2016-03-30 14:00:41
