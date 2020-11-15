-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 15, 2020 at 02:37 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `crewmate`
--

-- --------------------------------------------------------

--
-- Table structure for table `tblban`
--

CREATE TABLE `tblban` (
  `MaBan` int(11) NOT NULL,
  `TenBan` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `TrangThai` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tblban`
--

INSERT INTO `tblban` (`MaBan`, `TenBan`, `TrangThai`) VALUES
(1, 'Bàn 1', 'Đã đặt trước'),
(2, 'Bàn 2', 'Đang phục vụ'),
(3, 'Bàn 3', 'Đã đặt trước'),
(4, 'Bàn 4', 'Trống'),
(5, 'Bàn 5', 'Trống'),
(6, 'Bàn 6', 'Trống'),
(7, 'Bàn 7', 'Đang phục vụ'),
(8, 'Bàn 8', 'Trống'),
(9, 'Bàn 9', 'Đã đặt trước'),
(10, 'Bàn 10', 'Đang phục vụ'),
(11, 'Bàn 11', 'Đã đặt trước'),
(13, 'Bàn 12', 'Trống'),
(14, 'Bàn 13', 'Đang phục vụ'),
(15, 'Bàn 14', 'Đang phục vụ'),
(16, 'Bàn 15', 'Trống'),
(17, 'Bàn 16', 'Trống'),
(18, 'Bàn 17', 'Đang phục vụ'),
(19, 'Bàn 18', 'Trống'),
(25, 'Bàn 19', 'Đã đặt trước'),
(31, 'Bàn 20', 'Trống'),
(43, 'Bàn 21', 'Đã đặt trước');

-- --------------------------------------------------------

--
-- Table structure for table `tblchitiethd`
--

CREATE TABLE `tblchitiethd` (
  `MaChiTietHD` int(11) NOT NULL,
  `MaHoaDon` int(11) NOT NULL,
  `MaMon` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `Gia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tblchitiethd`
--

INSERT INTO `tblchitiethd` (`MaChiTietHD`, `MaHoaDon`, `MaMon`, `SoLuong`, `Gia`) VALUES
(392, 213, 13, 1, 17000),
(393, 213, 6, 1, 25000),
(394, 214, 11, 1, 25000),
(395, 215, 19, 1, 22000),
(396, 215, 15, 1, 22000),
(397, 216, 1, 1, 25000),
(398, 216, 2, 1, 23000),
(399, 217, 11, 1, 25000),
(400, 218, 1, 1, 25000),
(401, 219, 19, 1, 22000),
(402, 220, 1, 1, 25000),
(453, 261, 1, 1, 25000),
(454, 262, 1, 1, 25000),
(455, 262, 16, 1, 18000),
(456, 263, 1, 1, 25000),
(457, 263, 11, 1, 25000),
(458, 264, 1, 1, 25000),
(459, 264, 19, 1, 22000),
(460, 265, 1, 1, 25000),
(461, 265, 5, 1, 23000),
(462, 265, 15, 1, 22000),
(463, 267, 13, 1, 17000),
(464, 267, 11, 1, 25000),
(465, 268, 17, 1, 25000),
(466, 268, 16, 1, 18000),
(471, 271, 1, 1, 25000),
(472, 271, 11, 1, 25000),
(473, 272, 1, 1, 25000),
(474, 272, 3, 1, 22000),
(475, 273, 1, 1, 25000),
(476, 273, 3, 1, 22000),
(477, 274, 1, 1, 25000),
(478, 274, 15, 1, 22000),
(491, 286, 1, 1, 25000),
(492, 286, 11, 1, 25000),
(493, 287, 1, 1, 25000),
(494, 287, 19, 1, 22000),
(495, 288, 11, 1, 25000),
(496, 289, 1, 1, 25000),
(497, 290, 1, 1, 25000),
(498, 290, 5, 1, 23000),
(499, 291, 1, 1, 25000),
(500, 292, 6, 1, 25000),
(501, 293, 1, 1, 25000),
(502, 294, 1, 1, 25000),
(503, 294, 15, 1, 22000),
(504, 295, 1, 1, 25000),
(505, 296, 6, 2, 25000),
(506, 296, 13, 2, 17000),
(507, 297, 15, 2, 22000),
(508, 297, 11, 1, 25000),
(509, 298, 11, 1, 25000),
(510, 298, 15, 1, 22000),
(511, 298, 16, 1, 18000),
(512, 299, 1, 1, 25000),
(513, 299, 19, 1, 22000),
(514, 299, 6, 1, 25000),
(517, 300, 1, 1, 25000),
(518, 300, 19, 1, 22000),
(519, 301, 1, 2, 25000),
(520, 301, 17, 2, 25000),
(521, 302, 3, 2, 22000),
(522, 302, 5, 2, 23000),
(523, 303, 3, 1, 22000),
(524, 303, 15, 1, 22000),
(525, 304, 1, 2, 25000),
(526, 305, 19, 2, 22000),
(527, 305, 13, 2, 17000),
(528, 306, 9, 2, 23000),
(529, 306, 13, 2, 17000),
(530, 307, 11, 1, 25000),
(531, 307, 16, 1, 18000),
(532, 308, 1, 1, 25000),
(533, 308, 15, 1, 22000),
(534, 309, 1, 1, 25000),
(535, 310, 19, 1, 22000),
(536, 311, 1, 1, 25000),
(537, 312, 1, 2, 25000),
(538, 313, 1, 2, 25000),
(539, 314, 17, 2, 25000),
(540, 315, 4, 2, 25000),
(541, 316, 4, 2, 25000),
(542, 317, 8, 2, 25000),
(543, 318, 1, 2, 25000),
(544, 319, 1, 2, 25000),
(545, 320, 2, 2, 23000),
(546, 321, 4, 2, 25000),
(547, 322, 1, 2, 25000),
(548, 323, 19, 1, 22000),
(549, 324, 2, 1, 23000),
(550, 325, 11, 2, 25000),
(551, 326, 1, 2, 25000),
(552, 327, 1, 2, 25000),
(553, 327, 17, 2, 25000),
(554, 327, 14, 1, 22000),
(555, 327, 13, 1, 17000),
(556, 328, 19, 1, 22000),
(557, 329, 1, 1, 25000),
(558, 329, 13, 1, 17000),
(559, 330, 1, 1, 25000),
(560, 330, 19, 1, 22000),
(561, 331, 1, 1, 25000),
(562, 331, 15, 1, 22000),
(563, 331, 14, 1, 22000),
(564, 328, 6, 1, 25000),
(565, 328, 14, 1, 22000),
(566, 304, 6, 1, 25000),
(567, 332, 1, 2, 25000),
(568, 332, 15, 1, 22000),
(569, 333, 17, 1, 25000),
(570, 333, 19, 1, 22000),
(571, 334, 15, 1, 22000),
(572, 334, 1, 1, 25000),
(573, 334, 17, 1, 25000),
(574, 335, 15, 1, 22000),
(575, 336, 11, 1, 25000),
(576, 337, 1, 1, 25000),
(577, 338, 19, 1, 22000),
(578, 339, 19, 1, 22000),
(579, 340, 17, 1, 25000),
(580, 340, 19, 1, 22000),
(581, 341, 1, 1, 25000),
(582, 342, 1, 2, 25000),
(583, 343, 11, 1, 25000),
(584, 344, 1, 1, 25000),
(585, 345, 19, 1, 22000),
(586, 346, 19, 1, 22000),
(587, 347, 19, 1, 22000),
(588, 348, 75, 1, 18000),
(589, 348, 11, 1, 25000),
(590, 348, 5, 1, 23000),
(591, 349, 1, 1, 25000),
(592, 349, 19, 1, 22000),
(593, 349, 12, 1, 20000),
(594, 350, 11, 3, 25000),
(595, 351, 11, 1, 25000),
(596, 351, 12, 1, 20000),
(597, 351, 75, 1, 18000);

-- --------------------------------------------------------

--
-- Table structure for table `tblhoadon`
--

CREATE TABLE `tblhoadon` (
  `MaHoaDon` int(11) NOT NULL,
  `GiamGia` int(11) DEFAULT NULL,
  `MaBan` int(11) NOT NULL,
  `GioDen` datetime NOT NULL,
  `TongTien` int(11) DEFAULT NULL,
  `TrangThai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tblhoadon`
--

INSERT INTO `tblhoadon` (`MaHoaDon`, `GiamGia`, `MaBan`, `GioDen`, `TongTien`, `TrangThai`) VALUES
(213, 10, 2, '2020-10-04 03:30:34', 37800, 1),
(214, NULL, 2, '2020-09-04 03:31:29', 25000, 1),
(215, NULL, 18, '2020-10-04 03:31:59', 44000, 1),
(216, NULL, 15, '2020-09-04 03:32:06', 48000, 1),
(217, NULL, 13, '2020-08-04 03:32:13', 25000, 1),
(218, NULL, 2, '2020-07-04 03:40:40', NULL, 0),
(219, NULL, 18, '2020-06-04 03:40:44', NULL, 0),
(220, NULL, 4, '2020-06-04 04:20:08', 25000, 1),
(261, NULL, 16, '2020-07-05 21:41:31', 25000, 1),
(262, 15, 16, '2020-08-05 21:58:59', 36550, 1),
(263, NULL, 16, '2020-09-05 22:50:23', 50000, 1),
(264, NULL, 31, '2020-11-05 22:51:48', 47000, 1),
(265, 50, 31, '2020-11-05 22:58:09', 35000, 1),
(267, NULL, 10, '2020-11-06 13:18:15', 42000, 1),
(268, NULL, 10, '2020-11-06 13:20:03', 43000, 1),
(271, NULL, 10, '2020-11-06 19:31:18', 50000, 1),
(272, 15, 10, '2020-11-06 19:32:43', 39950, 1),
(273, NULL, 10, '2020-11-06 19:58:46', 47000, 1),
(274, NULL, 10, '2020-11-06 20:03:59', 47000, 1),
(286, 5, 16, '2020-11-07 22:07:50', 47500, 1),
(287, 5, 10, '2020-11-07 23:37:48', 44650, 1),
(288, NULL, 31, '2020-11-08 00:26:31', 25000, 1),
(289, NULL, 16, '2020-11-08 00:27:43', 25000, 1),
(290, NULL, 16, '2020-11-08 00:31:45', 48000, 1),
(291, NULL, 5, '2020-11-08 00:33:43', 25000, 1),
(292, NULL, 5, '2020-09-08 00:40:06', 25000, 1),
(293, NULL, 5, '2020-09-08 00:42:36', 25000, 1),
(294, NULL, 10, '2020-09-08 00:48:37', 47000, 1),
(295, NULL, 10, '2020-09-08 00:52:09', 25000, 1),
(296, NULL, 10, '2020-09-08 00:53:43', 84000, 1),
(297, NULL, 31, '2020-09-08 00:56:39', 69000, 1),
(298, NULL, 5, '2020-09-08 01:28:13', 65000, 1),
(299, NULL, 16, '2020-10-08 01:32:20', 72000, 1),
(300, NULL, 16, '2020-10-08 01:52:30', 47000, 1),
(301, 25, 5, '2020-10-08 22:49:18', 75000, 1),
(302, 5, 10, '2020-10-09 00:10:53', 85500, 1),
(303, 20000, 5, '2020-10-09 00:23:17', 24000, 1),
(304, 12000, 5, '2020-10-09 00:33:10', 63000, 1),
(305, 15000, 10, '2020-10-09 12:48:16', 63000, 1),
(306, 10, 16, '2020-10-09 13:22:34', 72000, 1),
(307, 5, 16, '2020-10-09 13:28:03', 40850, 1),
(308, 5, 16, '2020-10-09 13:29:12', 44650, 1),
(309, 5, 31, '2020-08-09 13:30:24', 23750, 1),
(310, 5, 16, '2020-08-09 13:38:56', 20900, 1),
(311, 10, 31, '2020-08-09 13:40:35', 22500, 1),
(312, 10, 31, '2020-08-09 13:49:15', 45000, 1),
(313, 10, 19, '2020-08-09 13:51:21', 45000, 1),
(314, 10, 31, '2020-08-09 13:52:44', 45000, 1),
(315, 10, 31, '2020-08-09 13:58:54', 45000, 1),
(316, 10, 31, '2020-08-09 14:00:32', 45000, 1),
(317, 10, 31, '2020-06-09 14:02:18', 45000, 1),
(318, 10, 16, '2020-06-09 14:04:03', 45000, 1),
(319, 10, 31, '2020-06-09 14:04:49', 45000, 1),
(320, 10, 31, '2020-06-09 14:05:55', 41400, 1),
(321, 10, 16, '2020-06-09 14:08:25', 45000, 1),
(322, 10, 31, '2020-06-09 14:09:16', 45000, 1),
(323, 5000, 31, '2020-06-09 14:50:54', 17000, 1),
(324, 2000, 31, '2020-06-09 14:52:04', 21000, 1),
(325, 10, 16, '2020-06-09 18:44:57', 45000, 1),
(326, 5, 16, '2020-06-11 00:19:41', 47500, 1),
(327, 15, 31, '2020-06-11 00:23:19', 118150, 1),
(328, 40000, 16, '2020-05-11 00:28:58', 29000, 1),
(329, 15, 31, '2020-05-11 01:07:55', 35700, 1),
(330, 50, 14, '2020-05-11 01:11:01', 23500, 1),
(331, 10, 7, '2020-05-11 01:24:36', 62100, 1),
(332, 5, 10, '2020-05-11 02:11:32', 68400, 1),
(333, NULL, 16, '2020-05-11 02:13:36', 47000, 1),
(334, 5, 10, '2020-05-11 02:16:54', 68400, 1),
(335, 5, 16, '2020-05-11 02:20:11', 20900, 1),
(336, NULL, 10, '2020-05-11 02:24:04', 25000, 1),
(337, NULL, 10, '2020-05-11 02:28:30', 25000, 1),
(338, 5, 16, '2020-05-11 02:32:12', 20900, 1),
(339, NULL, 16, '2020-05-11 02:33:36', 22000, 1),
(340, 20000, 16, '2020-05-11 02:37:31', 27000, 1),
(341, 5, 10, '2020-05-11 20:41:40', 23750, 1),
(342, 15, 10, '2020-11-11 21:37:10', 42500, 1),
(343, NULL, 10, '2020-11-11 21:39:33', 25000, 1),
(344, NULL, 10, '2020-11-11 21:40:56', 25000, 1),
(345, NULL, 10, '2020-11-11 21:43:11', 22000, 1),
(346, NULL, 10, '2020-11-11 21:44:22', 22000, 1),
(347, NULL, 10, '2020-11-11 21:45:07', 22000, 1),
(348, 25, 10, '2020-11-15 00:57:51', NULL, 0),
(349, 20000, 7, '2020-11-15 00:58:03', NULL, 0),
(350, NULL, 15, '2020-11-15 00:58:23', NULL, 0),
(351, NULL, 14, '2020-11-15 00:58:56', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tblkhachhang`
--

CREATE TABLE `tblkhachhang` (
  `MaKhachHang` int(11) NOT NULL,
  `MaHD` int(11) NOT NULL,
  `TenKH` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `SDT` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblkhachhang`
--

INSERT INTO `tblkhachhang` (`MaKhachHang`, `MaHD`, `TenKH`, `SDT`) VALUES
(1, 291, 'Nguyễn Phi', '0338678732');

-- --------------------------------------------------------

--
-- Table structure for table `tblnhommon`
--

CREATE TABLE `tblnhommon` (
  `MaLoai` int(11) NOT NULL,
  `TenLoai` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `MauSac` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tblnhommon`
--

INSERT INTO `tblnhommon` (`MaLoai`, `TenLoai`, `MauSac`) VALUES
(1, 'Cà Phê', '#ac3939'),
(2, 'Trà', '#66b3ff'),
(3, 'Sinh Tố', '#9900ff'),
(4, 'Milkshake', '#ffcc00'),
(5, 'Bánh Mì', '#ffcc33'),
(31, 'Chè', '#0000cc');

-- --------------------------------------------------------

--
-- Table structure for table `tblqlnv`
--

CREATE TABLE `tblqlnv` (
  `idNV` int(11) NOT NULL,
  `tenNV` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `DiaChi` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `SDT` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `Roll` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngaySinh` varchar(50) NOT NULL,
  `GioiTinh` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `TaiKhoan` varchar(100) NOT NULL,
  `MatKhau` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaCLV` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tblqlnv`
--

INSERT INTO `tblqlnv` (`idNV`, `tenNV`, `DiaChi`, `SDT`, `Roll`, `ngaySinh`, `GioiTinh`, `TaiKhoan`, `MatKhau`, `MaCLV`) VALUES
(1, 'Trần Hoàng Quân', 'Hà Nội', '0936506675', 'Quản lí', '20/11/2001', 'Nam', 'hquan2808', '81dc9bdb52d04dc20036dbd8313ed055', 1),
(3, 'User', 'Hà nội', '0338678732', 'Nhân viên', '01-01-2001', 'Nữ', 'User', '202cb962ac59075b964b07152d234b70', 1),
(4, 'Nguyễn Hồng Phi', 'Hà Nội', '0338678732', 'Quản lí', '20-11-2001', 'Nam', 'Phidz', '81dc9bdb52d04dc20036dbd8313ed055', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblthucdon`
--

CREATE TABLE `tblthucdon` (
  `MaMon` int(11) NOT NULL,
  `TenMon` varchar(55) COLLATE utf8_unicode_ci NOT NULL,
  `MaLoai` int(11) NOT NULL,
  `DonGia` int(11) NOT NULL,
  `DVT` varchar(55) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tblthucdon`
--

INSERT INTO `tblthucdon` (`MaMon`, `TenMon`, `MaLoai`, `DonGia`, `DVT`) VALUES
(1, 'Đá xay', 1, 25000, 'Ly'),
(2, 'Sữa Đá', 1, 23000, 'Ly'),
(3, 'Đen Đá', 1, 22000, 'Ly'),
(4, 'Sữa Nóng', 1, 25000, 'Ly'),
(5, 'Đen Nóng', 1, 23000, 'Ly'),
(6, 'Sen Vàng', 2, 25000, 'Ly'),
(7, 'Thạch Đào', 2, 22000, 'Ly'),
(8, 'Thanh Đào', 2, 25000, 'Ly'),
(9, 'Thạch Vải', 2, 23000, 'Ly'),
(10, 'Xanh Đậu Đỏ', 2, 25000, 'Ly'),
(11, 'Chanh Đá Xay', 3, 25000, 'Ly'),
(12, 'Sô-Cô-La', 3, 20000, 'Ly'),
(13, 'Thịt Nướng', 5, 17000, 'Cái'),
(14, 'Gà Xé', 5, 22000, 'Cái'),
(15, 'Chả Lụa Xá Xíu', 5, 22000, 'Cái'),
(16, 'Xíu Mại', 5, 18000, 'Cái'),
(17, 'Trà Xanh Mát Cha', 4, 25000, 'Ly'),
(18, 'Hoa Hồng', 4, 22000, 'Ly'),
(19, 'Xoài', 4, 22000, 'Ly'),
(75, 'Đậu Đỏ', 31, 18000, 'Ly');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tblban`
--
ALTER TABLE `tblban`
  ADD PRIMARY KEY (`MaBan`);

--
-- Indexes for table `tblchitiethd`
--
ALTER TABLE `tblchitiethd`
  ADD PRIMARY KEY (`MaChiTietHD`),
  ADD KEY `MaHoaDon` (`MaHoaDon`),
  ADD KEY `MaMon` (`MaMon`);

--
-- Indexes for table `tblhoadon`
--
ALTER TABLE `tblhoadon`
  ADD PRIMARY KEY (`MaHoaDon`),
  ADD KEY `MaBan` (`MaBan`);

--
-- Indexes for table `tblkhachhang`
--
ALTER TABLE `tblkhachhang`
  ADD PRIMARY KEY (`MaKhachHang`);

--
-- Indexes for table `tblnhommon`
--
ALTER TABLE `tblnhommon`
  ADD PRIMARY KEY (`MaLoai`);

--
-- Indexes for table `tblqlnv`
--
ALTER TABLE `tblqlnv`
  ADD PRIMARY KEY (`idNV`);

--
-- Indexes for table `tblthucdon`
--
ALTER TABLE `tblthucdon`
  ADD PRIMARY KEY (`MaMon`),
  ADD KEY `MaLoai` (`MaLoai`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tblban`
--
ALTER TABLE `tblban`
  MODIFY `MaBan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `tblchitiethd`
--
ALTER TABLE `tblchitiethd`
  MODIFY `MaChiTietHD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=598;

--
-- AUTO_INCREMENT for table `tblhoadon`
--
ALTER TABLE `tblhoadon`
  MODIFY `MaHoaDon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=352;

--
-- AUTO_INCREMENT for table `tblkhachhang`
--
ALTER TABLE `tblkhachhang`
  MODIFY `MaKhachHang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `tblnhommon`
--
ALTER TABLE `tblnhommon`
  MODIFY `MaLoai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `tblqlnv`
--
ALTER TABLE `tblqlnv`
  MODIFY `idNV` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tblthucdon`
--
ALTER TABLE `tblthucdon`
  MODIFY `MaMon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tblchitiethd`
--
ALTER TABLE `tblchitiethd`
  ADD CONSTRAINT `tblchitiethd_ibfk_1` FOREIGN KEY (`MaHoaDon`) REFERENCES `tblhoadon` (`MaHoaDon`),
  ADD CONSTRAINT `tblchitiethd_ibfk_2` FOREIGN KEY (`MaMon`) REFERENCES `tblthucdon` (`MaMon`);

--
-- Constraints for table `tblhoadon`
--
ALTER TABLE `tblhoadon`
  ADD CONSTRAINT `tblhoadon_ibfk_1` FOREIGN KEY (`MaBan`) REFERENCES `tblban` (`MaBan`);

--
-- Constraints for table `tblthucdon`
--
ALTER TABLE `tblthucdon`
  ADD CONSTRAINT `tblthucdon_ibfk_1` FOREIGN KEY (`MaLoai`) REFERENCES `tblnhommon` (`MaLoai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
