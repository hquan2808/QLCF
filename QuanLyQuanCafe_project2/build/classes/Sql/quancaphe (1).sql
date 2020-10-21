-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 21, 2020 at 02:13 PM
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
-- Table structure for table `banhang`
--

CREATE TABLE `banhang` (
  `ban` int(11) NOT NULL,
  `tenNuoc` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `soLuong` int(11) NOT NULL,
  `thanhTien` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `datban`
--

CREATE TABLE `datban` (
  `tenKH` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `sdt` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ban` int(11) NOT NULL,
  `thoiGian` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ngay` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `thanhToan` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ghiChu` varchar(150) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `datban`
--

INSERT INTO `datban` (`tenKH`, `sdt`, `ban`, `thoiGian`, `ngay`, `thanhToan`, `ghiChu`) VALUES
('Phidz', '0123456789', 22, '5:20', '19/10/2020', 'Đã thanh toán', 'Xin chỗ khuất :))))'),
('Phi', '1234456789', 1, '0:00', '18/10/2020', 'Không', 'abcd');

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `tenNuoc` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `soLuong` int(50) NOT NULL,
  `thanhTien` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`tenNuoc`, `soLuong`, `thanhTien`) VALUES
('Cà Phê', 1, '12,000 VNĐ');

-- --------------------------------------------------------

--
-- Table structure for table `qldu`
--

CREATE TABLE `qldu` (
  `maNuoc` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `loaiNuoc` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `tenNuoc` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `giaBan` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `donVi` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `soLuong` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `qldu`
--

INSERT INTO `qldu` (`maNuoc`, `loaiNuoc`, `tenNuoc`, `giaBan`, `donVi`, `soLuong`) VALUES
('CF01', 'Cafe', 'Cà Phê', '12,000 VNĐ', 'Ly', 90),
('CF02', 'Cafe', 'Cà Phê Không Đường', '8000 VNĐ', 'Ly', 97),
('TĐ01', 'Nước Giải Khát', 'Trà Đường', '8000 VNĐ', 'Ly', 93),
('BN001', 'Bánh ngọt', 'Bánh Ngọt', '20,000 VNĐ', 'Cái', 13),
('CF003', 'Cafe', 'Cà Phê Sữa', '20,000 VNĐ', 'Ly', 12),
('TX002', 'Cafe', 'Trà Xanh 0 Độ', '12,000 VNĐ', 'Chai', 25),
('C2001', 'Nước Giải Khát', 'C2', '7,000 VNĐ', 'Chai', 58);

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
('1', 'Nguyễn Hồng Phi', '20/11/2001', '0338678732', 'Nam', 'Hà Nội', 'Phidz', '123', 'Quản lí'),
('2', 'Quân', '01/01/2001', '0123456789', 'Nam', 'Hà Nội', 'Quandz', '123', 'Quản lí'),
('3', 'User', '01/01/2001', '0123456789', 'Nam', 'Hà Nội', 'User', '123', 'Nhân viên'),
('4', 'Nguyễn Văn A', '20/11/2001', '0123456789', 'Nữ', 'Hà Nội', 'abc', '123', 'Nhân viên');

-- --------------------------------------------------------

--
-- Table structure for table `thongke`
--

CREATE TABLE `thongke` (
  `ban` int(11) NOT NULL,
  `tongTien` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `tienKH` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `tienThua` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `tenNV` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ngay` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `thoiGian` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `thongke`
--

INSERT INTO `thongke` (`ban`, `tongTien`, `tienKH`, `tienThua`, `tenNV`, `ngay`, `thoiGian`) VALUES
(14, '14,000 VNĐ', '15,000 VNĐ', '1,000 VNĐ', 'Nguyễn Hồng Phi', 'Sunday 18/10/2020', '23:10:44'),
(18, '14,000 VNĐ', '15,000 VNĐ', '1,000 VNĐ', 'Nguyễn Hồng Phi', 'Sunday 18/10/2020', '23:10:51'),
(25, '40,000 VNĐ', '40,000 VNĐ', '0 VNĐ', 'Nguyễn Hồng Phi', 'Sunday 18/10/2020', '23:10:57'),
(13, '14,000 VNĐ', '15,000 VNĐ', '1,000 VNĐ', 'Nguyễn Hồng Phi', 'Sunday 18/10/2020', '23:11:53'),
(14, '20,000 VNĐ', '20,000 VNĐ', '0 VNĐ', 'Nguyễn Hồng Phi', 'Sunday 18/10/2020', '23:48:04'),
(9, '7,000 VNĐ', '8,000 VNĐ', '1,000 VNĐ', 'Nguyễn Hồng Phi', 'Sunday 18/10/2020', '23:52:45'),
(18, '40,000 VNĐ', '50,000 VNĐ', '10,000 VNĐ', 'User', 'Tuesday 20/10/2020', '00:32:07'),
(19, '14,000 VNĐ', '15,000 VNĐ', '1,000 VNĐ', 'Nguyễn Hồng Phi', 'Tuesday 20/10/2020', '01:07:02'),
(12, '16,000 VNĐ', '20,000 VNĐ', '4,000 VNĐ', 'Nguyễn Hồng Phi', 'Tuesday 20/10/2020', '01:10:43'),
(14, '40,000 VNĐ', '50,000 VNĐ', '10,000 VNĐ', 'Nguyễn Hồng Phi', 'Tuesday 20/10/2020', '01:21:01'),
(8, '7,000 VNĐ', '10,000 VNĐ', '3,000 VNĐ', 'Nguyễn Hồng Phi', 'Tuesday 20/10/2020', '01:24:58'),
(8, '8,000 VNĐ', '10,000 VNĐ', '2,000 VNĐ', 'Nguyễn Hồng Phi', 'Tuesday 20/10/2020', '01:26:57'),
(14, '16,000 VNĐ', '22,000 VNĐ', '6,000 VNĐ', 'Nguyễn Hồng Phi', 'Tuesday 20/10/2020', '01:31:02'),
(14, '20,000 VNĐ', '20,000 VNĐ', '0 VNĐ', 'Nguyễn Hồng Phi', 'Tuesday 20/10/2020', '15:16:51'),
(14, '8,000 VNĐ', '10,000 VNĐ', '2,000 VNĐ', 'Nguyễn Hồng Phi', 'Tuesday 20/10/2020', '15:25:47'),
(7, '8,000 VNĐ', '9,000 VNĐ', '1,000 VNĐ', 'Nguyễn Hồng Phi', 'Tuesday 20/10/2020', '15:26:50'),
(8, '12,000 VNĐ', '15,000 VNĐ', '3,000 VNĐ', 'Nguyễn Hồng Phi', 'Tuesday 20/10/2020', '15:29:41'),
(8, '12,000 VNĐ', '15,000 VNĐ', '3,000 VNĐ', 'Nguyễn Hồng Phi', 'Tuesday 20/10/2020', '15:31:15'),
(4, '24,000 VNĐ', '25,000 VNĐ', '1,000 VNĐ', 'Nguyễn Hồng Phi', 'Tuesday 20/10/2020', '15:33:05'),
(9, '12,000 VNĐ', '15,000 VNĐ', '3,000 VNĐ', 'Nguyễn Hồng Phi', 'Tuesday 20/10/2020', '15:34:49'),
(8, '24,000 VNĐ', '25,000 VNĐ', '1,000 VNĐ', 'User', 'Tuesday 20/10/2020', '15:35:56'),
(19, '14,000 VNĐ', '15,000 VNĐ', '1,000 VNĐ', 'Nguyễn Hồng Phi', 'Tuesday 20/10/2020', '20:06:37'),
(9, '20,000 VNĐ', '20,000 VNĐ', '0 VNĐ', 'Nguyễn Hồng Phi', 'Tuesday 20/10/2020', '20:07:37'),
(15, '16,000 VNĐ', '20,000 VNĐ', '4,000 VNĐ', 'Nguyễn Hồng Phi', 'Tuesday 20/10/2020', '22:18:43'),
(9, '24,000 VNĐ', '50,000 VNĐ', '26,000 VNĐ', 'Nguyễn Hồng Phi', 'Tuesday 20/10/2020', '22:21:10'),
(8, '8,000 VNĐ', '10,000 VNĐ', '2,000 VNĐ', 'Nguyễn Hồng Phi', 'Tuesday 20/10/2020', '22:27:45'),
(3, '20,000 VNĐ', '25,000 VNĐ', '5,000 VNĐ', 'Nguyễn Hồng Phi', 'Tuesday 20/10/2020', '22:30:21'),
(13, '12,000 VNĐ', '15,000 VNĐ', '3,000 VNĐ', 'Nguyễn Hồng Phi', 'Tuesday 20/10/2020', '22:55:37');

-- --------------------------------------------------------

--
-- Table structure for table `thongtinhoadon`
--

CREATE TABLE `thongtinhoadon` (
  `ban` int(11) NOT NULL,
  `tongTien` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tienKH` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tienThua` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tenNV` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ngay` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `thoiGian` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `thongtinhoadon`
--

INSERT INTO `thongtinhoadon` (`ban`, `tongTien`, `tienKH`, `tienThua`, `tenNV`, `ngay`, `thoiGian`) VALUES
(13, '12,000 VNĐ', '15,000 VNĐ', '3,000 VNĐ', 'Nguyễn Hồng Phi', 'Tuesday 20/10/2020', '22:55:37');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `banhang`
--
ALTER TABLE `banhang`
  ADD PRIMARY KEY (`ban`);

--
-- Indexes for table `datban`
--
ALTER TABLE `datban`
  ADD PRIMARY KEY (`tenKH`);

--
-- Indexes for table `qldu`
--
ALTER TABLE `qldu`
  ADD PRIMARY KEY (`maNuoc`);

--
-- Indexes for table `qlnv`
--
ALTER TABLE `qlnv`
  ADD PRIMARY KEY (`maNV`);

--
-- Indexes for table `thongtinhoadon`
--
ALTER TABLE `thongtinhoadon`
  ADD PRIMARY KEY (`ban`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
