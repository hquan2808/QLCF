-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 16, 2020 at 10:07 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quancaphe`
--

-- --------------------------------------------------------

--
-- Table structure for table `qlnv`
--

CREATE TABLE `qlnv` (
  `maNV` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `tenNV` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ngaySinh` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `sdt` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `gioiTinh` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `diaChi` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `taiKhoan` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `matKhau` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `Roll` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `qlnv`
--

INSERT INTO `qlnv` (`maNV`, `tenNV`, `ngaySinh`, `sdt`, `gioiTinh`, `diaChi`, `taiKhoan`, `matKhau`, `Roll`) VALUES
('1', 'Nguyễn Hồng Phi', '20/11/2001', '0338678732', 'Nam', 'Hà Nội', 'Phidz', '123', '1'),
('2', 'Quân', '01/01/2001', '0123456789', 'Nam', 'Hà Nội', 'Quandz', '123', '1'),
('3', 'User', '01/01/2001', '0123456789', 'Nữ', 'Hà Nội', 'User', '123', '2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `qlnv`
--
ALTER TABLE `qlnv`
  ADD PRIMARY KEY (`maNV`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
