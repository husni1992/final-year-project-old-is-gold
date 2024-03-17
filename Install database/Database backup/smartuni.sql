-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 24, 2014 at 07:28 PM
-- Server version: 5.5.32
-- PHP Version: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `smartuni`
--
CREATE DATABASE IF NOT EXISTS `smartuni` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `smartuni`;

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE IF NOT EXISTS `courses` (
  `course_id` varchar(20) NOT NULL,
  `course_name` varchar(200) NOT NULL,
  `course_fee` varchar(20) NOT NULL,
  `course_duration` varchar(20) NOT NULL,
  `allocatedLab` varchar(20) NOT NULL,
  `lecDay` int(5) NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`course_id`, `course_name`, `course_fee`, `course_duration`, `allocatedLab`, `lecDay`) VALUES
('1', 'Project Management', '450000', '1 years', 'Lab1', 4),
('2', 'Ethical ', '375000', '1 years', 'Lab2', 4),
('589', 'Software engineering', '5200000', '2years', 'Lab2', 4);

-- --------------------------------------------------------

--
-- Table structure for table `lecattendance`
--

CREATE TABLE IF NOT EXISTS `lecattendance` (
  `lec_id` varchar(20) NOT NULL,
  `lec_name` varchar(100) NOT NULL,
  `lec_room` varchar(20) NOT NULL,
  `Date` varchar(20) NOT NULL,
  `Time` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lecattendance`
--

INSERT INTO `lecattendance` (`lec_id`, `lec_name`, `lec_room`, `Date`, `Time`) VALUES
('51', 'Shamir Dias', 'Lab1_02375194', '2014-04-23', '17:02:30 PM'),
('52', 'Miss Roshini ', 'Lab2_04523035', '2014-04-23', '17:02:41 PM'),
('52', 'Miss Roshini ', 'Lab2_04523035', '2014-04-23', '18:04:57 PM'),
('52', 'Miss Roshini ', 'Lab2_04523035', '2014-04-23', '18:05:30 PM'),
('12364', 'Priyanga', 'Lab2_0498164', '2014-04-23', '18:57:22 PM');

-- --------------------------------------------------------

--
-- Table structure for table `lecturers`
--

CREATE TABLE IF NOT EXISTS `lecturers` (
  `lec_id` int(20) NOT NULL,
  `lec_name` varchar(50) NOT NULL,
  `lec_rfid` varchar(20) NOT NULL,
  `lec_mobile` varchar(50) NOT NULL,
  `lec_addr` varchar(50) NOT NULL,
  `lec_course` varchar(50) NOT NULL,
  `course_id` varchar(20) NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lecturers`
--

INSERT INTO `lecturers` (`lec_id`, `lec_name`, `lec_rfid`, `lec_mobile`, `lec_addr`, `lec_course`, `course_id`) VALUES
(51, 'Shamir Dias', 'Lab1_02375194', '+94776511996', 'Colombo 4 ', 'Project Management', '1'),
(52, 'Miss Roshini ', 'Lab2_04523035', '+94776511996', 'Colombo 8', 'Ethical ', '2'),
(12364, 'Priyanga', 'Lab2_0498164', '+94776511996', 'Col - 8', 'Software engineering', '589');

-- --------------------------------------------------------

--
-- Table structure for table `logintable`
--

CREATE TABLE IF NOT EXISTS `logintable` (
  `userlevel` int(5) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `logintable`
--

INSERT INTO `logintable` (`userlevel`, `username`, `password`) VALUES
(1, 'anfal', 'sytz'),
(0, 'husni', '12365');

-- --------------------------------------------------------

--
-- Table structure for table `studattendance`
--

CREATE TABLE IF NOT EXISTS `studattendance` (
  `stud_id` varchar(20) NOT NULL,
  `stud_name` varchar(50) NOT NULL,
  `lec_room` varchar(20) NOT NULL,
  `Date` varchar(20) NOT NULL,
  `Time` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studattendance`
--

INSERT INTO `studattendance` (`stud_id`, `stud_name`, `lec_room`, `Date`, `Time`) VALUES
('163', 'Sheron Fernando', 'Lab2_049141132', '2014-04-23', '17:31:35 PM'),
('161', 'M.G.Husny Ahamed', 'Lab1_04981182', '2014-04-23', '17:36:22 PM'),
('161', 'M.G.Husny Ahamed', 'Lab1_04981182', '2014-04-23', '17:36:29 PM'),
('161', 'M.G.Husny Ahamed', 'Lab1_04981182', '2014-04-23', '18:13:23 PM'),
('12344', 'Shehan mihiranga', 'Lab2_04913374', '2014-04-23', '18:58:07 PM'),
('12344', 'Shehan mihiranga', 'Lab2_04913374', '2014-04-23', '18:58:27 PM');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE IF NOT EXISTS `students` (
  `stud_id` int(20) NOT NULL,
  `stud_name` varchar(50) NOT NULL,
  `stud_rfid` varchar(20) NOT NULL,
  `stud_mobile` varchar(50) NOT NULL,
  `stud_addr` varchar(50) NOT NULL,
  `stud_course` varchar(50) NOT NULL,
  `course_id` varchar(20) NOT NULL,
  `fee` int(20) NOT NULL,
  `paid` int(20) NOT NULL,
  PRIMARY KEY (`stud_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`stud_id`, `stud_name`, `stud_rfid`, `stud_mobile`, `stud_addr`, `stud_course`, `course_id`, `fee`, `paid`) VALUES
(161, 'M.G.Husny Ahamed', 'Lab1_04981182', '+94776511996', 'Raddolugama', 'Project Management', '1', 450000, 375200),
(162, 'Kasun Chamara', 'Lab1_04942196', '+94776511996', 'Seeduwa', 'Project Management', '1', 450000, 178000),
(163, 'Sheron Fernando', 'Lab2_049141132', '+94776511996', 'Kurana', 'Ethical ', '2', 375000, 290400),
(164, 'Mahesh Perera', 'Lab2_04910249', '+94776511996', 'Seeduwa kotugoda', 'Ethical ', '2', 375000, 140500),
(12344, 'Shehan mihiranga', 'Lab2_04913374', '+94773064805', 'Col 9', 'Software engineering', '589', 5200000, 4000000),
(4545454, 'Lahiru', 'Lab1_049118100', '+94773064805', 'Matara', 'Project Management', '1', 450000, 120000);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
