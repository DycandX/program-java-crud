/*
SQLyog Professional v13.1.1 (64 bit)
MySQL - 5.7.33 : Database - dataku
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `r_customer` */

DROP TABLE IF EXISTS `r_customer`;

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
  `pwd` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `CustomerID` (`id`),
  KEY `UserID` (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Table structure for table `r_dosen` */

DROP TABLE IF EXISTS `r_dosen`;

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
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `r_mhs` */

DROP TABLE IF EXISTS `r_mhs`;

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
  `masuk_thn` int(11) DEFAULT NULL,
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
  `thn_lulus` int(11) DEFAULT '0',
  PRIMARY KEY (`nim`),
  KEY `nim` (`nim`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `r_pegawai` */

DROP TABLE IF EXISTS `r_pegawai`;

CREATE TABLE `r_pegawai` (
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
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `r_supplier` */

DROP TABLE IF EXISTS `r_supplier`;

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
  `userid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `SupplierID` (`id`),
  KEY `UserID` (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Table structure for table `t_pmb` */

DROP TABLE IF EXISTS `t_pmb`;

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
  `thn_lulus` int(11) DEFAULT '0',
  PRIMARY KEY (`no_reg`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
