-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tempo de Geração: 
-- Versão do Servidor: 5.5.27
-- Versão do PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `atendimentos`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `chamados`
--

CREATE TABLE IF NOT EXISTS `chamados` (
  `idChamado` int(11) NOT NULL AUTO_INCREMENT,
  `prioridade` varchar(45) DEFAULT NULL,
  `codPrioridade` int(30) DEFAULT NULL,
  `numChamado` int(30) DEFAULT NULL,
  `despacho` int(30) DEFAULT NULL,
  `respnsavel` varchar(30) DEFAULT NULL,
  `descricao` varchar(64) DEFAULT NULL,
  `dataInicial` date DEFAULT NULL,
  `dataFinal` date DEFAULT NULL,
  `horarioInicial` time DEFAULT NULL,
  `horarioFinal` time DEFAULT NULL,
  PRIMARY KEY (`idChamado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `prioridades`
--

CREATE TABLE IF NOT EXISTS `prioridades` (
  `idPrioridade` int(11) NOT NULL AUTO_INCREMENT,
  `numChamado` int(30) DEFAULT NULL,
  `codPrioridade` int(30) DEFAULT NULL,
  `codFuncionario` int(30) DEFAULT NULL,
  `status` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`idPrioridade`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `prioridades`
--

INSERT INTO `prioridades` (`idPrioridade`, `numChamado`, `codPrioridade`, `codFuncionario`, `status`) VALUES
(1, 33223, 323232, 545523, 'OKOK'),
(2, 12122121, 444444, 55353535, 'yyyyyy');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
