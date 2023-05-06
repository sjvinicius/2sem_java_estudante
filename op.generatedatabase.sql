-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.4.22-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para estudante_2sem_cc
CREATE DATABASE IF NOT EXISTS `estudante_2sem_cc` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `estudante_2sem_cc`;

-- Copiando estrutura para tabela estudante_2sem_cc.aluno
CREATE TABLE IF NOT EXISTS `aluno` (
  `ALUNO_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `RGM` varchar(50) NOT NULL,
  `NASC` varchar(50) NOT NULL,
  `CPF` varchar(50) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `END` varchar(50) NOT NULL,
  `MUN` varchar(50) NOT NULL,
  `UF` varchar(50) NOT NULL,
  `CELULAR` varchar(50) NOT NULL,
  `CRIACAO_DATA` datetime DEFAULT NULL,
  `ALTERACAO_DATA` datetime NOT NULL DEFAULT curdate(),
  `STATUS` char(1) CHARACTER SET utf8 NOT NULL DEFAULT 'A',
  PRIMARY KEY (`ALUNO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela estudante_2sem_cc.alunocursocampus
CREATE TABLE IF NOT EXISTS `alunocursocampus` (
  `ALUNOCURSOCAMPUS_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ALUNO_ID` int(10) unsigned NOT NULL DEFAULT 0,
  `CURSOCAMPUS_ID` int(10) unsigned NOT NULL DEFAULT 0,
  `CRIACAO_DATA` datetime DEFAULT NULL,
  `ALTERACAO_DATA` datetime NOT NULL DEFAULT curdate(),
  `STATUS` char(1) CHARACTER SET utf8 NOT NULL DEFAULT 'A',
  PRIMARY KEY (`ALUNOCURSOCAMPUS_ID`),
  KEY `ALUNO_ID` (`ALUNO_ID`),
  KEY `CURSOCAMPUS_ID` (`CURSOCAMPUS_ID`),
  CONSTRAINT `FK__aluno` FOREIGN KEY (`ALUNO_ID`) REFERENCES `aluno` (`ALUNO_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_alunocursocampus_cursocampus` FOREIGN KEY (`CURSOCAMPUS_ID`) REFERENCES `cursocampus` (`CURSOCAMPUS_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela estudante_2sem_cc.avaliacao
CREATE TABLE IF NOT EXISTS `avaliacao` (
  `AVALIACAO_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ALUNO_ID` int(10) unsigned NOT NULL DEFAULT 0,
  `DISCPLINA_ID` int(10) unsigned NOT NULL DEFAULT 0,
  `SEM` int(10) unsigned NOT NULL DEFAULT 0,
  `FALTA` int(10) unsigned NOT NULL DEFAULT 0,
  `NOTA` int(10) unsigned NOT NULL DEFAULT 0,
  `CRIACAO_DATA` datetime DEFAULT NULL,
  `ALTERACAO_DATA` datetime NOT NULL DEFAULT curdate(),
  `STATUS` char(1) CHARACTER SET utf8 NOT NULL DEFAULT 'A',
  PRIMARY KEY (`AVALIACAO_ID`),
  KEY `FK_avaliacao_aluno` (`ALUNO_ID`),
  KEY `FK_avaliacao_disciplina` (`DISCPLINA_ID`),
  CONSTRAINT `FK_avaliacao_aluno` FOREIGN KEY (`ALUNO_ID`) REFERENCES `aluno` (`ALUNO_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_avaliacao_disciplina` FOREIGN KEY (`DISCPLINA_ID`) REFERENCES `disciplina` (`DISCIPLINA_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela estudante_2sem_cc.campus
CREATE TABLE IF NOT EXISTS `campus` (
  `CAMPUS_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NOME` varchar(50) NOT NULL DEFAULT '0',
  `CRIACAO_DATA` datetime DEFAULT NULL,
  `ALTERACAO_DATA` datetime NOT NULL DEFAULT curdate(),
  `STATUS` char(1) CHARACTER SET utf8 NOT NULL DEFAULT 'A',
  PRIMARY KEY (`CAMPUS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela estudante_2sem_cc.curso
CREATE TABLE IF NOT EXISTS `curso` (
  `CURSO_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `NOME` varchar(50) NOT NULL DEFAULT '',
  `CRIACAO_DATA` datetime DEFAULT NULL,
  `ALTERACAO_DATA` datetime NOT NULL DEFAULT curdate(),
  `STATUS` char(1) CHARACTER SET utf8 NOT NULL DEFAULT 'A',
  PRIMARY KEY (`CURSO_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela estudante_2sem_cc.cursocampus
CREATE TABLE IF NOT EXISTS `cursocampus` (
  `CURSOCAMPUS_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NOME` varchar(50) NOT NULL DEFAULT '0',
  `CRIACAO_DATA` datetime DEFAULT NULL,
  `ALTERACAO_DATA` datetime NOT NULL DEFAULT curdate(),
  `STATUS` char(1) CHARACTER SET utf8 NOT NULL DEFAULT 'A',
  PRIMARY KEY (`CURSOCAMPUS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela estudante_2sem_cc.disciplina
CREATE TABLE IF NOT EXISTS `disciplina` (
  `DISCIPLINA_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `NOME` varchar(50) NOT NULL DEFAULT '0',
  `CRIACAO_DATA` datetime DEFAULT NULL,
  `ALTERACAO_DATA` datetime NOT NULL DEFAULT curdate(),
  `STATUS` char(1) CHARACTER SET utf8 NOT NULL DEFAULT 'A',
  PRIMARY KEY (`DISCIPLINA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela estudante_2sem_cc.disciplinacurso
CREATE TABLE IF NOT EXISTS `disciplinacurso` (
  `DISCIPLINACURSO_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DISCIPLINA_ID` int(10) unsigned NOT NULL,
  `CURSO_ID` int(10) unsigned NOT NULL,
  `CRIACAO_DATA` datetime DEFAULT NULL,
  `ALTERACAO_DATA` datetime NOT NULL DEFAULT curdate(),
  `STATUS` char(1) CHARACTER SET utf8 NOT NULL DEFAULT 'A',
  PRIMARY KEY (`DISCIPLINACURSO_ID`),
  KEY `DISCIPLINA_ID` (`DISCIPLINA_ID`),
  KEY `CURSO_ID` (`CURSO_ID`),
  CONSTRAINT `FK_disciplinacurso_curso` FOREIGN KEY (`CURSO_ID`) REFERENCES `curso` (`CURSO_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_disciplinacurso_disciplina` FOREIGN KEY (`DISCIPLINA_ID`) REFERENCES `disciplina` (`DISCIPLINA_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Exportação de dados foi desmarcado.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
