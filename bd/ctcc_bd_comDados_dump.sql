CREATE DATABASE  IF NOT EXISTS `bd_transporte_cantinho_do_ceu` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_transporte_cantinho_do_ceu`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bd_transporte_cantinho_do_ceu
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `avaria`
--

DROP TABLE IF EXISTS `avaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `avaria` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `tipo` varchar(250) DEFAULT NULL,
  `descricao` text,
  `data_registo` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_actualizacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaria`
--

LOCK TABLES `avaria` WRITE;
/*!40000 ALTER TABLE `avaria` DISABLE KEYS */;
INSERT INTO `avaria` VALUES (1,'Desgaste de calços','O desgaste de calços prejudica a travagem. ','2022-05-08 20:23:48','2022-05-08 20:23:48'),(2,'Qalquer','Uma avaria qualquer.','2022-05-10 11:03:31','2022-05-10 11:03:31');
/*!40000 ALTER TABLE `avaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrinha`
--

DROP TABLE IF EXISTS `carrinha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrinha` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `capacidade` int NOT NULL DEFAULT '13',
  `lugares_ocupados` int NOT NULL DEFAULT '0',
  `matricula` varchar(50) NOT NULL,
  `data_registo` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `matricula` (`matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrinha`
--

LOCK TABLES `carrinha` WRITE;
/*!40000 ALTER TABLE `carrinha` DISABLE KEYS */;
INSERT INTO `carrinha` VALUES (6,15,0,'AAA525MC','2022-04-29 22:00:00'),(7,20,0,'ACN458MP','2022-04-29 22:00:00'),(9,15,0,'ABC520MC','2022-05-02 22:00:00'),(10,30,0,'AAA356MP','2022-05-07 22:00:00'),(11,30,0,'ACD325MC','2022-05-07 22:00:00'),(12,15,0,'AAB478MP','2022-05-09 22:00:00'),(13,15,0,'ASD145MC','2022-05-09 22:00:00'),(14,30,0,'ASS455MP','2022-05-09 22:00:00');
/*!40000 ALTER TABLE `carrinha` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrinhaavaria`
--

DROP TABLE IF EXISTS `carrinhaavaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrinhaavaria` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_avaria` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_resolucao` timestamp NULL DEFAULT NULL,
  `carrinha_id` bigint NOT NULL,
  `avaria_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `carrinha_id` (`carrinha_id`),
  KEY `avaria_id` (`avaria_id`),
  CONSTRAINT `carrinhaavaria_ibfk_1` FOREIGN KEY (`carrinha_id`) REFERENCES `carrinha` (`id`),
  CONSTRAINT `carrinhaavaria_ibfk_2` FOREIGN KEY (`avaria_id`) REFERENCES `avaria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrinhaavaria`
--

LOCK TABLES `carrinhaavaria` WRITE;
/*!40000 ALTER TABLE `carrinhaavaria` DISABLE KEYS */;
/*!40000 ALTER TABLE `carrinhaavaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrinhamotorista`
--

DROP TABLE IF EXISTS `carrinhamotorista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrinhamotorista` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_alocacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `motorista_funcionario_id` bigint NOT NULL,
  `carrinha_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `motorista_funcionario_id` (`motorista_funcionario_id`),
  KEY `carrinha_id` (`carrinha_id`),
  CONSTRAINT `carrinhamotorista_ibfk_1` FOREIGN KEY (`motorista_funcionario_id`) REFERENCES `motorista` (`funcionario_id`),
  CONSTRAINT `carrinhamotorista_ibfk_2` FOREIGN KEY (`carrinha_id`) REFERENCES `carrinha` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrinhamotorista`
--

LOCK TABLES `carrinhamotorista` WRITE;
/*!40000 ALTER TABLE `carrinhamotorista` DISABLE KEYS */;
/*!40000 ALTER TABLE `carrinhamotorista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contaencarregado`
--

DROP TABLE IF EXISTS `contaencarregado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contaencarregado` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome_utilizador` varchar(30) NOT NULL,
  `palavra_passe` varchar(100) NOT NULL,
  `encarregado_id` bigint NOT NULL,
  `data_registo` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_actualizacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome_utilizador` (`nome_utilizador`),
  KEY `encarregado_id` (`encarregado_id`),
  CONSTRAINT `contaencarregado_ibfk_1` FOREIGN KEY (`encarregado_id`) REFERENCES `encarregado` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contaencarregado`
--

LOCK TABLES `contaencarregado` WRITE;
/*!40000 ALTER TABLE `contaencarregado` DISABLE KEYS */;
/*!40000 ALTER TABLE `contaencarregado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contafuncionario`
--

DROP TABLE IF EXISTS `contafuncionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contafuncionario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `palavra_passe` varchar(100) NOT NULL,
  `funcionario_id` bigint NOT NULL,
  `data_registo` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_actualizacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `perfil_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `funcionario_id` (`funcionario_id`),
  KEY `perfil_id` (`perfil_id`),
  CONSTRAINT `contafuncionario_ibfk_1` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `contafuncionario_ibfk_2` FOREIGN KEY (`perfil_id`) REFERENCES `perfil` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contafuncionario`
--

LOCK TABLES `contafuncionario` WRITE;
/*!40000 ALTER TABLE `contafuncionario` DISABLE KEYS */;
INSERT INTO `contafuncionario` VALUES (18,'$2a$10$HWYgEMMN2D.dnNh5n70LSOgqCsphfdleVQAYI.NClYXi/xfvKSCPi',30,'2022-05-19 11:49:34','2022-05-19 11:49:34',5),(20,'$2a$10$aNPkymzw/RtxwNx/N3l6WO5H916jOaa5yMI4ShjKkvkyHu67PDqAC',33,'2022-06-01 19:47:41','2022-06-01 19:47:41',3),(21,'$2a$10$uyWtu1uc.Qqcgs5TUlS45u2QzyEqdS2FeF2jMXxorWzfvrAKd2Q1q',34,'2022-06-02 12:45:03','2022-06-02 12:45:03',4),(22,'$2a$10$6TlxmlWriWAIT3Isd.R92uc7iQBgeFM4fn9mmTjNg8EaHLoJkXFNO',35,'2022-06-06 21:30:02','2022-06-06 21:30:02',1),(23,'$2a$10$6WLa/1LvIgrETdbPm45cQOGuGwUrA7OGVWlD3ajWTyrDTUXPS6uyy',36,'2022-06-06 21:34:44','2022-06-06 21:34:44',1);
/*!40000 ALTER TABLE `contafuncionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crianca`
--

DROP TABLE IF EXISTS `crianca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crianca` (
  `id` bigint NOT NULL,
  `nome` varchar(200) NOT NULL,
  `apelido` varchar(45) NOT NULL,
  `data_nascimento` date NOT NULL,
  `encarregado_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm4uvwcomfywx92iohgrj1agix` (`encarregado_id`),
  CONSTRAINT `FKm4uvwcomfywx92iohgrj1agix` FOREIGN KEY (`encarregado_id`) REFERENCES `encarregado` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crianca`
--

LOCK TABLES `crianca` WRITE;
/*!40000 ALTER TABLE `crianca` DISABLE KEYS */;
/*!40000 ALTER TABLE `crianca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crianca_encarregado`
--

DROP TABLE IF EXISTS `crianca_encarregado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crianca_encarregado` (
  `crianca_id` bigint NOT NULL,
  `encarregado_id` bigint NOT NULL,
  PRIMARY KEY (`crianca_id`,`encarregado_id`),
  KEY `encarregado_id` (`encarregado_id`),
  CONSTRAINT `crianca_encarregado_ibfk_1` FOREIGN KEY (`crianca_id`) REFERENCES `crianca` (`id`),
  CONSTRAINT `crianca_encarregado_ibfk_2` FOREIGN KEY (`encarregado_id`) REFERENCES `encarregado` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crianca_encarregado`
--

LOCK TABLES `crianca_encarregado` WRITE;
/*!40000 ALTER TABLE `crianca_encarregado` DISABLE KEYS */;
/*!40000 ALTER TABLE `crianca_encarregado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `educadora`
--

DROP TABLE IF EXISTS `educadora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `educadora` (
  `funcionario_id` bigint NOT NULL,
  PRIMARY KEY (`funcionario_id`),
  CONSTRAINT `educadora_ibfk_1` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educadora`
--

LOCK TABLES `educadora` WRITE;
/*!40000 ALTER TABLE `educadora` DISABLE KEYS */;
INSERT INTO `educadora` VALUES (35),(36);
/*!40000 ALTER TABLE `educadora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `encarregado`
--

DROP TABLE IF EXISTS `encarregado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `encarregado` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `apelido` varchar(45) NOT NULL,
  `telefone` varchar(16) DEFAULT NULL,
  `telefone_alternativo` varchar(16) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  `data_registo` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_actualizacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `telefone_alternativo` (`telefone_alternativo`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `encarregado`
--

LOCK TABLES `encarregado` WRITE;
/*!40000 ALTER TABLE `encarregado` DISABLE KEYS */;
INSERT INTO `encarregado` VALUES (1,'Felizardo','Nhantumbo','855203698',NULL,NULL,'2022-05-08 20:36:16','2022-05-08 20:36:16'),(2,'Bartolomeu da Silva','Nhantumbo','879632569',NULL,NULL,'2022-05-10 11:01:43','2022-05-10 11:01:43');
/*!40000 ALTER TABLE `encarregado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrega`
--

DROP TABLE IF EXISTS `entrega`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrega` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `educadora_id` bigint NOT NULL,
  `crianca_id` bigint NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `crianca_id` (`crianca_id`),
  KEY `FKjplcg75j6c8mv05hlf06iwl5p` (`educadora_id`),
  CONSTRAINT `entrega_ibfk_1` FOREIGN KEY (`educadora_id`) REFERENCES `educadora` (`funcionario_id`),
  CONSTRAINT `entrega_ibfk_2` FOREIGN KEY (`crianca_id`) REFERENCES `crianca` (`id`),
  CONSTRAINT `FKjplcg75j6c8mv05hlf06iwl5p` FOREIGN KEY (`educadora_id`) REFERENCES `funcionario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrega`
--

LOCK TABLES `entrega` WRITE;
/*!40000 ALTER TABLE `entrega` DISABLE KEYS */;
/*!40000 ALTER TABLE `entrega` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `apelido` varchar(45) NOT NULL,
  `data_nascimento` date NOT NULL,
  `sexo` enum('M','F') NOT NULL,
  `tipo_documento` enum('BI','Cartão de Eleitor','Carta de Condução','Passaporte') NOT NULL,
  `nr_documento` varchar(13) NOT NULL,
  `telefone` varchar(16) NOT NULL,
  `telefone_alternativo` varchar(16) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  `DATA_REGISTO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DATA_ACTUALIZACAO` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nr_documento_UNIQUE` (`nr_documento`),
  UNIQUE KEY `telefone_UNIQUE` (`telefone`),
  UNIQUE KEY `telefone_alternativo_UNIQUE` (`telefone_alternativo`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (30,'Cleiton Ferndandes','Muianga','2001-12-26','M','BI','100236521452C','842675934','870184517','cleitonfernandes.cm@gmail.com','2022-05-19 11:49:34','2022-05-19 11:49:34'),(33,'Pedro Alberto Carlos','Nhantumbo','1987-05-26','M','BI','159365214521C','847539512','878541256',NULL,'2022-06-01 19:47:40','2022-06-01 19:47:40'),(34,'Noémia Beatriz','Pedro','1978-10-26','F','BI','152365875236C','875823652','824566547',NULL,'2022-06-02 12:45:02','2022-06-02 12:45:02'),(35,'Matilde','Zacarias','1990-06-21','F','BI','159632569652C','857569856','874123256','matilde205@gmail.com','2022-06-06 21:30:01','2022-06-06 21:30:01'),(36,'Felizarda','Zebedeu','1993-03-23','F','BI','100362541598C','823215265','853624265','felizarda333@gmail.com','2022-06-06 21:34:44','2022-06-06 21:34:44');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario_logs`
--

DROP TABLE IF EXISTS `funcionario_logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario_logs` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `login` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `logout` timestamp NULL DEFAULT NULL,
  `conta_funcionario_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `conta_funcionario_id` (`conta_funcionario_id`),
  CONSTRAINT `funcionario_logs_ibfk_1` FOREIGN KEY (`conta_funcionario_id`) REFERENCES `contafuncionario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario_logs`
--

LOCK TABLES `funcionario_logs` WRITE;
/*!40000 ALTER TABLE `funcionario_logs` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario_logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario_residencia`
--

DROP TABLE IF EXISTS `funcionario_residencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario_residencia` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `quarteirao` int NOT NULL,
  `id_funcionario` bigint NOT NULL,
  `id_zona` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_funcionario` (`id_funcionario`),
  KEY `id_zona` (`id_zona`),
  CONSTRAINT `funcionario_residencia_ibfk_1` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `funcionario_residencia_ibfk_2` FOREIGN KEY (`id_zona`) REFERENCES `zona` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario_residencia`
--

LOCK TABLES `funcionario_residencia` WRITE;
/*!40000 ALTER TABLE `funcionario_residencia` DISABLE KEYS */;
INSERT INTO `funcionario_residencia` VALUES (12,1,30,7),(21,4,33,3),(22,4,34,48),(23,4,35,34),(24,5,36,3);
/*!40000 ALTER TABLE `funcionario_residencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grupo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_formacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_fim` timestamp NULL DEFAULT NULL,
  `motorista_funcionario_id` bigint NOT NULL,
  `educadora_funcionario_id` bigint NOT NULL,
  `data_registo` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_actualizacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `motorista_funcionario_id` (`motorista_funcionario_id`),
  KEY `FK8i1x2vgqq9wv4ejo95keiqynb` (`educadora_funcionario_id`),
  CONSTRAINT `FK8i1x2vgqq9wv4ejo95keiqynb` FOREIGN KEY (`educadora_funcionario_id`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `grupo_ibfk_1` FOREIGN KEY (`motorista_funcionario_id`) REFERENCES `motorista` (`funcionario_id`),
  CONSTRAINT `grupo_ibfk_2` FOREIGN KEY (`educadora_funcionario_id`) REFERENCES `educadora` (`funcionario_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motorista`
--

DROP TABLE IF EXISTS `motorista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motorista` (
  `funcionario_id` bigint NOT NULL,
  PRIMARY KEY (`funcionario_id`),
  CONSTRAINT `motorista_ibfk_1` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motorista`
--

LOCK TABLES `motorista` WRITE;
/*!40000 ALTER TABLE `motorista` DISABLE KEYS */;
INSERT INTO `motorista` VALUES (33);
/*!40000 ALTER TABLE `motorista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfil` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` VALUES (5,'Administrador'),(1,'Educadora'),(2,'Gestor de transportes'),(3,'Motorista'),(4,'Secretária');
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rota`
--

DROP TABLE IF EXISTS `rota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rota` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_registo` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_actualizacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rota`
--

LOCK TABLES `rota` WRITE;
/*!40000 ALTER TABLE `rota` DISABLE KEYS */;
/*!40000 ALTER TABLE `rota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rotacrianca`
--

DROP TABLE IF EXISTS `rotacrianca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rotacrianca` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_alocacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_fim` timestamp NULL DEFAULT NULL,
  `rota_id` bigint NOT NULL,
  `crianca_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `rota_id` (`rota_id`),
  KEY `crianca_id` (`crianca_id`),
  CONSTRAINT `rotacrianca_ibfk_1` FOREIGN KEY (`rota_id`) REFERENCES `rota` (`id`),
  CONSTRAINT `rotacrianca_ibfk_2` FOREIGN KEY (`crianca_id`) REFERENCES `crianca` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rotacrianca`
--

LOCK TABLES `rotacrianca` WRITE;
/*!40000 ALTER TABLE `rotacrianca` DISABLE KEYS */;
/*!40000 ALTER TABLE `rotacrianca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rotagrupo`
--

DROP TABLE IF EXISTS `rotagrupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rotagrupo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_alocacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_fim` timestamp NULL DEFAULT NULL,
  `grupo_id` bigint NOT NULL,
  `rota_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `grupo_id` (`grupo_id`),
  KEY `rota_id` (`rota_id`),
  CONSTRAINT `rotagrupo_ibfk_1` FOREIGN KEY (`grupo_id`) REFERENCES `grupo` (`id`),
  CONSTRAINT `rotagrupo_ibfk_2` FOREIGN KEY (`rota_id`) REFERENCES `rota` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rotagrupo`
--

LOCK TABLES `rotagrupo` WRITE;
/*!40000 ALTER TABLE `rotagrupo` DISABLE KEYS */;
/*!40000 ALTER TABLE `rotagrupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viagem`
--

DROP TABLE IF EXISTS `viagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `viagem` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `hora_inicio` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `hora_fim` timestamp NULL DEFAULT NULL,
  `grupo_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `grupo_id` (`grupo_id`),
  CONSTRAINT `viagem_ibfk_1` FOREIGN KEY (`grupo_id`) REFERENCES `grupo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viagem`
--

LOCK TABLES `viagem` WRITE;
/*!40000 ALTER TABLE `viagem` DISABLE KEYS */;
/*!40000 ALTER TABLE `viagem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zona`
--

DROP TABLE IF EXISTS `zona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zona` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(250) NOT NULL,
  `cidade` enum('Maputo','Matola') NOT NULL,
  `data_registo` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_actualizacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zona`
--

LOCK TABLES `zona` WRITE;
/*!40000 ALTER TABLE `zona` DISABLE KEYS */;
INSERT INTO `zona` VALUES (1,'Alto Maé A, Distrito de KaMpfumo','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(2,'Alto Maé B, Distrito de KaMpfumo','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(3,'Central A, Distrito de KaMpfumo','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(4,'Central B, Distrito de KaMpfumo','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(5,'Central C, Distrito de KaMpfumo','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(6,'Coop, Distrito de KaMpfumo','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(7,'Malhangalene A, Distrito de KaMpfumo','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(8,'Malhangalene B, Distrito de KaMpfumo','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(9,'Polana-Cimento A, Distrito de KaMpfumo','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(10,'Polana-Cimento B, Distrito de KaMpfumo','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(11,'Sommerschield, Distrito de KaMpfumo','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(12,'Bairro do Aeroporto A, Distrito de Nlhamankulo','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(13,'Bairro do Aeroporto B, Distrito de Nlhamankulo','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(14,'Chamanculo A, Distrito de Nlhamankulo','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(15,'Chamanculo B, Distrito de Nlhamankulo','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(16,'Chamanculo C, Distrito de Nlhamankulo','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(17,'Chamanculo D, Distrito de Nlhamankulo','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(18,'Malanga, Distrito de Nlhamankulo','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(19,'Minkadjuine, Distrito de Nlhamankulo','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(20,'Munhuana, Distrito de Nlhamankulo','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(21,'Unidade 7, Distrito de Nlhamankulo','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(22,'Xipamanine, Distrito de Nlhamankulo','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(23,'Mafalala, Distrito de KaMaxakeni','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(24,'Maxaquene A, Distrito de KaMaxakeni','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(25,'Maxaquene B, Distrito de KaMaxakeni','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(26,'Maxaquene C, Distrito de KaMaxakeni','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(27,'Maxaquene D, Distrito de KaMaxakeni','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(28,'Polana Caniço A, Distrito de KaMaxakeni','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(29,'Polana Caniço B, Distrito de KaMaxakeni','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(30,'Urbanização, Distrito de KaMaxakeni','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(31,'3 de Feverreiro, Distrito de KaMavota','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(32,'Albazine, Distrito de KaMavota','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(33,'Costa do Sol, Distrito de KaMavota','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(34,'FPLM, Distrito de KaMavota','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(35,'Ferroviário, Distrito de KaMavota','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(36,'Hulene A, Distrito de KaMavota','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(37,'Hulene B, Distrito de KaMavota','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(38,'Laulane, Distrito de KaMavota','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(39,'Mahotas, Distrito de KaMavota','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(40,'Mavalane A, Distrito de KaMavota','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(41,'Mavalane B, Distrito de KaMavota','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(42,'25 de Junho A, Distrito de KaMubukwana','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(43,'25 de Junho B, Distrito de KaMubukwana','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(44,'Bagamoyo, Distrito de KaMubukwana','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(45,'George Dimitrov, Distrito de KaMubukwana','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(46,'Ingagóia A, Distrito de KaMubukwana','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(47,'Inhagóia B, Distrito de KaMubukwana','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(48,'Jardim, Distrito de KaMubukwana','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(49,'Luis Cabral, Distrito de KaMubukwana','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(50,'Magoanine A, Distrito de KaMubukwana','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(51,'Magoanine B, Distrito de KaMubukwana','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(52,'Magoanine C, Distrito de KaMubukwana','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(53,'Malhazine, Distrito de KaMubukwana','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(54,'Nsalene, Distrito de KaMubukwana','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(55,'Zimpeto, Distrito de KaMubukwana','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(56,'Inguide, Distrito de KaTembe','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(57,'Incassane, Distrito de KaTembe','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(58,'Guachene, Distrito de KaTembe','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(59,'Chali, Distrito de KaTembe','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(60,'Chamissava, Distrito de KaTembe','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(61,'Ribzwene, Distrito de KaNyaka','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(62,'Inguane, Distrito de KaNyaka','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30'),(63,'Nhanquene, Distrito de KaNyaka','Maputo','2022-05-25 20:12:30','2022-05-25 20:12:30');
/*!40000 ALTER TABLE `zona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zonarota`
--

DROP TABLE IF EXISTS `zonarota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zonarota` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_atribuicao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data_fim` timestamp NULL DEFAULT NULL,
  `rota_id` bigint NOT NULL,
  `zona_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `rota_id` (`rota_id`),
  KEY `zona_id` (`zona_id`),
  CONSTRAINT `zonarota_ibfk_1` FOREIGN KEY (`rota_id`) REFERENCES `rota` (`id`),
  CONSTRAINT `zonarota_ibfk_2` FOREIGN KEY (`zona_id`) REFERENCES `zona` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zonarota`
--

LOCK TABLES `zonarota` WRITE;
/*!40000 ALTER TABLE `zonarota` DISABLE KEYS */;
/*!40000 ALTER TABLE `zonarota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd_transporte_cantinho_do_ceu'
--

--
-- Dumping routines for database 'bd_transporte_cantinho_do_ceu'
--
/*!50003 DROP PROCEDURE IF EXISTS `adicionar_educadora` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `adicionar_educadora`(
	_nome VARCHAR(200),
	_apelido VARCHAR(45),
	_data_nascimento DATE,
	_sexo ENUM('M', 'F'),
	_tipo_documento ENUM('BI','Cartão de Eleitor','Carta de Condução','Passaporte'),
	_nr_documento VARCHAR(13),
	_telefone VARCHAR(16),
	_telefone_alternativo VARCHAR(16),
	_email VARCHAR(256),
	_residencia TEXT
)
begin
	declare id_funcionario int;
	INSERT INTO funcionario(nome, apelido, data_nascimento, sexo, tipo_documento, nr_documento, telefone, telefone_alternativo, email, residencia) 
    values(_nome, _apelido, _data_nascimento, _sexo, _tipo_documento, _nr_documento, _telefone, _telefone_alternativo, _email, _residencia);
	SELECT id into @id_funcionario from funcionario where nr_documento = _nr_documento;
    insert into educadora values(@id_educadora);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `adicionar_motorista` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `adicionar_motorista`(
	_nome VARCHAR(200),
	_apelido VARCHAR(45),
	_data_nascimento DATE,
	_sexo ENUM('M', 'F'),
	_tipo_documento ENUM('BI','Cartão de Eleitor','Carta de Condução','Passaporte'),
	_nr_documento VARCHAR(13),
	_telefone VARCHAR(16),
	_telefone_alternativo VARCHAR(16),
	_email VARCHAR(256),
	_residencia TEXT
)
begin
	declare id_funcionario int;
	INSERT INTO funcionario(nome, apelido, data_nascimento, sexo, tipo_documento, nr_documento, telefone, telefone_alternativo, email, residencia) 
    values(_nome, _apelido, _data_nascimento, _sexo, _tipo_documento, _nr_documento, _telefone, _telefone_alternativo, _email, _residencia);
	SELECT id into @id_funcionario from funcionario where nr_documento = _nr_documento;
    insert into motorista values(@id_funcionario);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `migrar_residencia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `migrar_residencia`()
BEGIN
		DECLARE i INT DEFAULT 0;
        DECLARE j INT DEFAULT 0;
        DECLARE _id_zona INT;
        DECLARE _id_funcionario INT;
        DELETE FROM funcionario_residencia;
 
		/*Selecionar id de cada zona*/
        pega_zona: LOOP
			/*ID DE ZONAS*/
			SELECT id INTO _id_zona FROM zona WHERE nome = ANY (SELECT LEFT(residencia, length(residencia)-8) FROM funcionario) LIMIT i, 1;
			SET j = 0;
                /*Selecionar id de funcionario cuja residencia e igual a zona correspodente ao id actual*/
                preenche_funcionario_zona: LOOP
                    
					/*ID DE FUNCIONARIO ACTUAL*/
					SET _id_funcionario = (SELECT id FROM funcionario
					WHERE residencia LIKE CONCAT((SELECT nome FROM zona WHERE nome = ANY (SELECT LEFT(residencia, length(residencia)-8)
					FROM funcionario) LIMIT i, 1), '%') LIMIT j, 1);
                    SET j = j+1;
                    IF _id_funcionario IS NOT NULL THEN
						/*Introduzir id de funcionario actual e zona actual na tabela zona_funcionario*/
						INSERT INTO funcionario_residencia(quarteirao, id_funcionario, id_zona)
						VALUES (01, _id_funcionario, _id_zona);
                        ITERATE preenche_funcionario_zona;
					ELSE
						LEAVE preenche_funcionario_zona;
					END IF;
				END LOOP preenche_funcionario_zona;
				
                SET i = i+1;
                IF _id_zona IS NOT NULL THEN
                    ITERATE pega_zona;
				ELSE
					LEAVE pega_zona;
				END IF;
		END LOOP pega_zona;
				
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-09  8:06:06
