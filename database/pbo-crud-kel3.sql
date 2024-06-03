-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 03, 2024 at 07:01 PM
-- Server version: 8.0.37
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbo-crud-kel3`
--

-- --------------------------------------------------------

--
-- Table structure for table `r_customer`
--

CREATE TABLE `r_customer` (
  `id` varchar(50) NOT NULL,
  `kode` varchar(50) DEFAULT NULL,
  `nama` varchar(200) DEFAULT NULL,
  `jenisid` varchar(50) DEFAULT NULL,
  `cp` varchar(50) DEFAULT NULL,
  `alamat` varchar(200) DEFAULT NULL,
  `telp` varchar(50) DEFAULT NULL,
  `fax` varchar(50) DEFAULT NULL,
  `kota` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `jt` decimal(19,2) DEFAULT '0.00',
  `disc` decimal(19,2) DEFAULT '0.00',
  `AWAL` decimal(19,2) DEFAULT NULL,
  `Piutang` decimal(19,2) DEFAULT NULL,
  `Bayar` decimal(19,2) DEFAULT NULL,
  `Akhir` decimal(19,2) DEFAULT NULL,
  `tgl` date DEFAULT NULL,
  `userid` varchar(100) DEFAULT NULL,
  `pwd` varchar(200) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `r_dosen`
--

CREATE TABLE `r_dosen` (
  `id` varchar(60) NOT NULL DEFAULT '',
  `nip` varchar(60) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `tempat` varchar(255) DEFAULT NULL,
  `lahir` datetime DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `agama` varchar(20) DEFAULT NULL,
  `hp` varchar(255) DEFAULT NULL,
  `jabatan` varchar(200) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `kota` varchar(255) DEFAULT NULL,
  `aktif` varchar(2) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `r_mhs`
--

CREATE TABLE `r_mhs` (
  `nim` varchar(30) NOT NULL DEFAULT '',
  `nama` varchar(255) DEFAULT NULL,
  `prodi_id` varchar(20) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  `pmb` varchar(1) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `tempat` varchar(255) DEFAULT NULL,
  `lahir` datetime DEFAULT NULL,
  `agama` varchar(15) DEFAULT NULL,
  `tahun` double DEFAULT NULL,
  `masuk_thn` int DEFAULT NULL,
  `semester` double DEFAULT NULL,
  `kelas_id` varchar(10) DEFAULT NULL,
  `jenjang_id` varchar(2) DEFAULT NULL,
  `dosen_id` varchar(30) DEFAULT NULL,
  `baru` varchar(1) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `photo_wisuda` varchar(255) DEFAULT NULL,
  `no_reg` varchar(255) DEFAULT NULL,
  `tgl` datetime DEFAULT NULL,
  `alamat_1` mediumtext,
  `telp_1` varchar(255) DEFAULT NULL,
  `sekolah` mediumtext,
  `kota` varchar(255) DEFAULT NULL,
  `prodi_id_1` varchar(20) DEFAULT NULL,
  `prodi_id_2` varchar(20) DEFAULT NULL,
  `bpk` varchar(255) DEFAULT NULL,
  `ibu` varchar(255) DEFAULT NULL,
  `alamat_2` mediumtext,
  `telp_2` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `referensi` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nik` varchar(30) NOT NULL,
  `income_id` varchar(2) NOT NULL,
  `sts_reg` varchar(100) DEFAULT NULL,
  `nisn` varchar(100) DEFAULT NULL,
  `kel` mediumtext,
  `kec` mediumtext,
  `kode_pos` varchar(50) DEFAULT NULL,
  `kipk` varchar(2) DEFAULT '0',
  `thn_lulus` int DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `r_pegawai`
--

CREATE TABLE `r_pegawai` (
  `id` int NOT NULL,
  `nip` varchar(60) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `tempat` varchar(255) DEFAULT NULL,
  `lahir` datetime DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `agama` varchar(20) DEFAULT NULL,
  `hp` varchar(255) DEFAULT NULL,
  `jabatan` varchar(200) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `kota` varchar(255) DEFAULT NULL,
  `aktif` varchar(2) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `r_pegawai`
--

INSERT INTO `r_pegawai` (`id`, `nip`, `nama`, `tempat`, `lahir`, `sex`, `agama`, `hp`, `jabatan`, `alamat`, `kota`, `aktif`, `status`, `email`) VALUES
(1, 'NIP001', 'John Doe', 'Jakarta', '1980-01-01 00:00:00', 'M', 'Christian', '081234567890', 'Manager', 'Jl. Sudirman No.1', 'Jakarta', 'Y', 'Active', 'john.doe@example.com'),
(2, 'NIP002', 'Jane Smith', 'Bandung', '1985-05-15 00:00:00', 'F', 'Muslim', '081234567891', 'Assistant Manager', 'Jl. Asia Afrika No.2', 'Bandung', 'Y', 'Active', 'jane.smith@example.com'),
(3, 'NIP003', 'Alice Johnson', 'Surabaya', '1990-10-30 00:00:00', 'F', 'Hindu', '081234567892', 'Secretary', 'Jl. Pemuda No.3', 'Surabaya', 'N', 'Inactive', 'alice.johnson@example.com'),
(4, 'NIP004', 'Robert Brown', 'Medan', '1975-03-25 00:00:00', 'M', 'Buddhist', '081234567893', 'Director', 'Jl. Diponegoro No.4', 'Medan', 'Y', 'Active', 'robert.brown@example.com'),
(5, 'NIP005', 'Michael Davis', 'Semarang', '1988-08-20 00:00:00', 'M', 'Christian', '081234567894', 'Engineer', 'Jl. Gajah Mada No.5', 'Semarang', 'N', 'Inactive', 'michael.davis@example.com'),
(6, 'NIP006', 'Mary Wilson', 'Yogyakarta', '1992-12-12 00:00:00', 'F', 'Muslim', '081234567895', 'Technician', 'Jl. Malioboro No.6', 'Yogyakarta', 'Y', 'Active', 'mary.wilson@example.com'),
(7, 'NIP007', 'Patricia Taylor', 'Denpasar', '1983-04-18 00:00:00', 'F', 'Hindu', '081234567896', 'Accountant', 'Jl. Legian No.7', 'Denpasar', 'N', 'Inactive', 'patricia.taylor@example.com'),
(8, 'NIP008', 'James Moore', 'Makassar', '1978-09-09 00:00:00', 'M', 'Buddhist', '081234567897', 'HR Manager', 'Jl. Pattimura No.8', 'Makassar', 'Y', 'Active', 'james.moore@example.com'),
(9, 'NIP009', 'Jennifer Thomas', 'Palembang', '1987-07-07 00:00:00', 'F', 'Christian', '081234567898', 'Marketing Manager', 'Jl. Merdeka No.9', 'Palembang', 'N', 'Inactive', 'jennifer.thomas@example.com'),
(10, 'NIP010', 'Charles Anderson', 'Bogor', '1984-02-02 00:00:00', 'M', 'Muslim', '081234567899', 'Sales Manager', 'Jl. Pajajaran No.10', 'Bogor', 'Y', 'Active', 'charles.anderson@example.com'),
(11, 'NIP011', 'Lisa Martinez', 'Padang', '1991-06-06 00:00:00', 'F', 'Hindu', '081234567800', 'Admin', 'Jl. Sudirman No.11', 'Padang', 'N', 'Inactive', 'lisa.martinez@example.com'),
(12, 'NIP012', 'Thomas Rodriguez', 'Manado', '1986-11-11 00:00:00', 'M', 'Buddhist', '081234567801', 'Support', 'Jl. Sam Ratulangi No.12', 'Manado', 'Y', 'Active', 'thomas.rodriguez@example.com'),
(13, 'NIP013', 'Sarah Lewis', 'Bali', '1979-03-03 00:00:00', 'F', 'Christian', '081234567802', 'Designer', 'Jl. Sunset Road No.13', 'Bali', 'N', 'Inactive', 'sarah.lewis@example.com'),
(14, 'NIP014', 'Daniel Lee', 'Balikpapan', '1982-09-20 00:00:00', 'M', 'Muslim', '081234567803', 'Architect', 'Jl. MT Haryono No.14', 'Balikpapan', 'Y', 'Active', 'daniel.lee@example.com'),
(15, 'NIP015', 'Laura King', 'Pontianak', '1993-01-05 00:00:00', 'F', 'Hindu', '081234567804', 'Supervisor', 'Jl. Gajah Mada No.15', 'Pontianak', 'N', 'Inactive', 'laura.king@example.com'),
(16, 'NIP016', 'Paul Scott', 'Banjarmasin', '1977-05-25 00:00:00', 'M', 'Buddhist', '081234567805', 'Consultant', 'Jl. Lambung Mangkurat No.16', 'Banjarmasin', 'Y', 'Active', 'paul.scott@example.com'),
(17, 'NIP017', 'Karen Walker', 'Malang', '1995-12-15 00:00:00', 'F', 'Christian', '081234567806', 'Analyst', 'Jl. Ijen No.17', 'Malang', 'N', 'Inactive', 'karen.walker@example.com'),
(18, 'NIP018', 'Mark Hill', 'Jayapura', '1989-10-01 00:00:00', 'M', 'Muslim', '081234567807', 'Developer', 'Jl. Yos Sudarso No.18', 'Jayapura', 'Y', 'Active', 'mark.hill@example.com'),
(19, 'NIP019', 'Emma Allen', 'Batam', '1981-02-28 00:00:00', 'F', 'Hindu', '081234567808', 'Strategist', 'Jl. Ahmad Yani No.19', 'Batam', 'N', 'Inactive', 'emma.allen@example.com'),
(20, 'NIP020', 'Steven Young', 'Bandar Lampung', '1984-07-17 00:00:00', 'M', 'Buddhist', '081234567809', 'Planner', 'Jl. Pangeran Antasari No.20', 'Bandar Lampung', 'Y', 'Active', 'steven.young@example.com');

-- --------------------------------------------------------

--
-- Table structure for table `r_pegawai_backup`
--

CREATE TABLE `r_pegawai_backup` (
  `id` varchar(60) CHARACTER SET latin1 NOT NULL DEFAULT '',
  `nip` varchar(60) CHARACTER SET latin1 DEFAULT NULL,
  `nama` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `tempat` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `lahir` datetime DEFAULT NULL,
  `sex` varchar(2) CHARACTER SET latin1 DEFAULT NULL,
  `agama` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `hp` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `jabatan` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  `alamat` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `kota` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `aktif` varchar(2) CHARACTER SET latin1 DEFAULT NULL,
  `status` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `email` varchar(255) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `r_supplier`
--

CREATE TABLE `r_supplier` (
  `id` varchar(50) NOT NULL,
  `nama` varchar(200) DEFAULT NULL,
  `cp` varchar(200) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `telp` varchar(255) DEFAULT NULL,
  `kota` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `jt` decimal(19,0) DEFAULT '0',
  `disc` decimal(19,2) DEFAULT '0.00',
  `AWAL` decimal(19,4) DEFAULT NULL,
  `Hutang` decimal(19,4) DEFAULT NULL,
  `Bayar` decimal(19,4) DEFAULT NULL,
  `Akhir` decimal(19,4) DEFAULT NULL,
  `tgl` datetime DEFAULT NULL,
  `userid` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `t_pmb`
--

CREATE TABLE `t_pmb` (
  `no_reg` varchar(50) NOT NULL,
  `tgl` date NOT NULL,
  `nama` varchar(200) NOT NULL,
  `tempat` varchar(200) NOT NULL,
  `lahir` date NOT NULL,
  `sex` varchar(20) NOT NULL,
  `agama` varchar(20) NOT NULL,
  `alamat_1` mediumtext NOT NULL,
  `telp_1` varchar(200) NOT NULL,
  `sekolah` mediumtext NOT NULL,
  `kota` varchar(200) NOT NULL,
  `prodi_id_1` varchar(20) NOT NULL,
  `prodi_id_2` varchar(50) NOT NULL,
  `kelas_id` varchar(2) NOT NULL,
  `bpk` varchar(200) NOT NULL,
  `ibu` varchar(200) NOT NULL,
  `alamat_2` mediumtext NOT NULL,
  `telp_2` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `status` varchar(1) NOT NULL,
  `referensi` mediumtext NOT NULL,
  `prodi_id` varchar(20) NOT NULL,
  `pmb` varchar(2) NOT NULL,
  `nik` varchar(30) NOT NULL,
  `income_id` varchar(2) NOT NULL,
  `nisn` varchar(100) DEFAULT NULL,
  `kel` mediumtext,
  `kec` mediumtext,
  `kode_pos` varchar(50) DEFAULT NULL,
  `kipk` varchar(2) DEFAULT '0',
  `thn_lulus` int DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `r_customer`
--
ALTER TABLE `r_customer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `CustomerID` (`id`),
  ADD KEY `UserID` (`userid`);

--
-- Indexes for table `r_dosen`
--
ALTER TABLE `r_dosen`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `r_mhs`
--
ALTER TABLE `r_mhs`
  ADD PRIMARY KEY (`nim`),
  ADD KEY `nim` (`nim`);

--
-- Indexes for table `r_pegawai`
--
ALTER TABLE `r_pegawai`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `r_supplier`
--
ALTER TABLE `r_supplier`
  ADD PRIMARY KEY (`id`),
  ADD KEY `SupplierID` (`id`),
  ADD KEY `UserID` (`userid`);

--
-- Indexes for table `t_pmb`
--
ALTER TABLE `t_pmb`
  ADD PRIMARY KEY (`no_reg`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `r_pegawai`
--
ALTER TABLE `r_pegawai`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
