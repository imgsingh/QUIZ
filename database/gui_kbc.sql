-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 17, 2016 at 09:22 PM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `gui_kbc`
--

-- --------------------------------------------------------

--
-- Table structure for table `highscores_table`
--

CREATE TABLE IF NOT EXISTS `highscores_table` (
  `dbusername` varchar(20) NOT NULL,
  `dbmoney` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `highscores_table`
--

INSERT INTO `highscores_table` (`dbusername`, `dbmoney`) VALUES
('lucky', 10000000),
('mohit', 10000000),
('deepak', 10000000),
('jimmy', 10000000),
('nikhil', 10000000),
('mannu', 10000000),
('simmi', 10000000),
('Navjot', 6400000),
('jackie', 6400000),
('df', 50000),
('h', 0),
('satinder singh', 50000),
('amar', 10000000),
('mini', 50000),
('jk', 0);

-- --------------------------------------------------------

--
-- Table structure for table `questions_table`
--

CREATE TABLE IF NOT EXISTS `questions_table` (
  `dbS_No` int(10) NOT NULL,
  `dbquestion` varchar(100) NOT NULL,
  `dbchoice1` varchar(100) NOT NULL,
  `dbchoice2` varchar(100) NOT NULL,
  `dbchoice3` varchar(100) NOT NULL,
  `dbchoice4` varchar(100) NOT NULL,
  `dbans` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='holds the questions and answers';

--
-- Dumping data for table `questions_table`
--

INSERT INTO `questions_table` (`dbS_No`, `dbquestion`, `dbchoice1`, `dbchoice2`, `dbchoice3`, `dbchoice4`, `dbans`) VALUES
(1, 'What is the capital of India ?', 'Chandigarh', 'Gujarat', 'Maharashtra', 'New Delhi', 'New Delhi'),
(2, 'Facebook is mainly based on which language ?', 'Python', 'PHP', 'Java', 'Ruby', 'PHP'),
(3, 'Who is the Prime Minister of India ?', 'Rahul Gandhi', 'Arvind Kejriwal', 'Narendra Modi', 'Prakash Singh Badal', 'Narendra Modi'),
(4, 'how many strings does a violin have ?', '4', '3', '2', '5', '4'),
(5, 'what sport is played at wimbledon ?', 'tennis', 'badminton', 'chess', 'cricket', 'tennis'),
(6, 'the 1st network that inherited the internet was ?', 'vnet', 'inet', 'arpanet', 'nsf net', 'arpanet'),
(7, 'favourites are accessible from _menu ?', 'title', 'shop', 'menu', 'start', 'start'),
(8, 'hockey was introduced in asian games in ?', '1958 in tokyo', '1962 in jakarta', '1966 in bangkok', '1970 in bangkok', '1958 in tokyo'),
(9, 'goa shipyard limited was established in ?', '1958', '1957', '1959', '1955', '1957'),
(10, 'FRS stands for ?', 'Fellow Research System', 'Federation of Regulation Society', 'Fellow of Royal Society', 'None of above', 'Fellow of Royal Society'),
(11, 'chanakya was prime minister of ?', 'chandra gupta', 'chandra gupta 2', 'chandra gupta maurya', 'ashoka', 'chandra gupta maurya');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
