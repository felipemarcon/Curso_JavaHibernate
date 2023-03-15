CREATE DATABASE  IF NOT EXISTS `vestibularbd` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `vestibularbd`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: vestibularbd
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `questao`
--

DROP TABLE IF EXISTS `questao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questao` (
  `codquestao` int NOT NULL AUTO_INCREMENT,
  `numeropergunta` int NOT NULL,
  `pergunta` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  `alt_a` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  `alt_b` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  `alt_c` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  `alt_d` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  `resp` int NOT NULL,
  `questionario` int NOT NULL,
  PRIMARY KEY (`codquestao`),
  KEY `questionario` (`questionario`),
  CONSTRAINT `questao_ibfk_1` FOREIGN KEY (`questionario`) REFERENCES `questionario` (`idquestionario`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questao`
--

LOCK TABLES `questao` WRITE;
/*!40000 ALTER TABLE `questao` DISABLE KEYS */;
INSERT INTO `questao` VALUES (1,1,'Qual a cor da capa do Super homem','Vermeio','Red','Vermelhio','azul',4,1),(2,2,'Quantas patas tem um cachorro','2','4','9','1',2,1),(3,3,'Quantos dias tem o ano','2','3','4','365',4,1),(4,1,'teste 1','tst a','tst b','tst c','tst d',1,2),(5,2,'ques2','alta','altb','alc','ald',4,2),(6,2,'perg','a','b','c','d',2,2),(7,1,'Quem é o rei dos trilhos','Leo trevisol','Jonas','Duda Abreu','Enzao',4,3),(8,1,'1','1','1','1','1',1,4),(9,2,'2','2','2','2','2',2,4),(10,3,'3','3','3','3','3',3,4),(11,4,'4','4','4','4','4',4,4),(12,5,'5','5','5','5','5',1,4),(13,1,'1','1','1','1','1',1,5),(14,2,'2','2','2','2','2',2,5),(15,3,'3','3','3','3','3',3,5),(16,4,'4','4','4','4','4',4,5),(17,5,'5','5','5','5','5',1,5),(18,6,'6','6','6','6','6',2,5);
/*!40000 ALTER TABLE `questao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-08 21:23:07
