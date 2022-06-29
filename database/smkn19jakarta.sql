-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 29, 2022 at 04:00 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smkn19jakarta`
--

-- --------------------------------------------------------

--
-- Table structure for table `jurusan_siswa`
--

CREATE TABLE `jurusan_siswa` (
  `id_jurusan` int(11) NOT NULL,
  `nama_jurusan` varchar(50) NOT NULL,
  `kode_jurusan` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tabelsiswa`
--

CREATE TABLE `tabelsiswa` (
  `nis` varchar(20) NOT NULL,
  `nisn` varchar(20) NOT NULL,
  `nama_siswa` varchar(50) NOT NULL,
  `tempat_lahir_siswa` varchar(50) NOT NULL,
  `tanggal_lahir_siswa` date NOT NULL,
  `alamat_siswa` text NOT NULL,
  `jenis_kelamin_siswa` varchar(10) NOT NULL,
  `agama_siswa` varchar(30) NOT NULL,
  `jurusan_siswa` varchar(50) NOT NULL,
  `kelas_siswa` varchar(10) NOT NULL,
  `no_telp_siswa` varchar(15) NOT NULL,
  `email_siswa` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tabelsiswa`
--

INSERT INTO `tabelsiswa` (`nis`, `nisn`, `nama_siswa`, `tempat_lahir_siswa`, `tanggal_lahir_siswa`, `alamat_siswa`, `jenis_kelamin_siswa`, `agama_siswa`, `jurusan_siswa`, `kelas_siswa`, `no_telp_siswa`, `email_siswa`) VALUES
('12044', '201912044', 'ABDUL ROSYADI', 'Jakarta', '2002-06-04', 'Banten', 'Laki-laki', 'Islam', 'Akuntansi', '10', '81273878123', 'abdulrosyadi@gmail.com'),
('12048', '201912048', 'ADITYA RAMLAN', 'Bogor', '1999-11-28', 'Bekasi', 'Laki-laki', 'Islam', 'Akuntansi', '10', '18387231', 'adityaramlan@gmail.com'),
('12059', '201912059', 'ALFIAN WILLY', 'Yogyakarta', '1999-06-07', 'Tangerang', 'Laki-laki', 'Islam', 'Akuntansi', '10', '12371283', 'alfianwilly@gmail.com'),
('12064', '201912064', 'ALQOWIYUL AZZAHRA', 'Banten', '2002-09-30', 'Bogor', 'Perempuan', 'Islam', 'Akuntansi', '10', '81823702349', 'alqowiyulazzahra@gmail.com'),
('12069', '201912069', 'ANDHIKA PRATAMA', 'Bekasi', '2002-04-28', 'Yogyakarta', 'Laki-laki', 'Islam', 'Akuntansi', '10', '12371217', 'andhikapratama@gmail.com'),
('12090', '201912090', 'AZHAR ARDHIAN YAFSYAR', 'Tangerang', '1998-01-19', 'Banten', 'Laki-laki', 'Islam', 'Akuntansi', '10', '1,98231E+14', 'azharardhianyafsyar@gmail.com'),
('12098', '201912098', 'DANISHA BINTANG RAYYAN', 'Bogor', '2000-05-26', 'Bekasi', 'Perempuan', 'Islam', 'Akuntansi', '10', '9324', 'danishabintangrayyan@gmail.com'),
('12106', '201912106', 'DIVA NAZWA NAZALA', 'Yogyakarta', '2003-02-03', 'Tangerang', 'Perempuan', 'Islam', 'Akuntansi', '10', '81273878123', 'divanazwanazala@gmail.com'),
('12109', '201912109', 'EDHELWISE SAGITA', 'Banten', '1999-09-18', 'Banten', 'Perempuan', 'Islam', 'Akuntansi', '10', '18387231', 'edhelwisesagita@gmail.com'),
('12114', '201912114', 'FACHRI FEBRIAN', 'Bekasi', '2002-02-28', 'Bekasi', 'Laki-laki', 'Islam', 'Akuntansi', '10', '12371283', 'fachrifebrian@gmail.com'),
('12120', '201912120', 'FEBRIYAN IRVANSYAH SUMITRA', 'Tangerang', '2000-02-19', 'Tangerang', 'Laki-laki', 'Islam', 'Akuntansi', '10', '81823702349', 'febriyanirvansyahsumitra@gmail.com'),
('12124', '201912124', 'FIRHAN SYAHLEFI', 'Banten', '1999-03-17', 'Bogor', 'Laki-laki', 'Islam', 'Akuntansi', '10', '12371217', 'firhansyahlefi@gmail.com'),
('12126', '201912126', 'HABIBI RAFI AHMAD RAIZ', 'Bekasi', '2002-09-11', 'Yogyakarta', 'Laki-laki', 'Islam', 'Akuntansi', '10', '1,98231E+14', 'habibirafiahmadraiz@gmail.com'),
('12137', '201912137', 'INE CAROLINE', 'Tangerang', '2002-05-06', 'Banten', 'Perempuan', 'Islam', 'Akuntansi', '10', '9324', 'inecaroline@gmail.com'),
('12143', '201912143', 'KEVIN DWINOV MUNIR', 'Bogor', '2000-07-08', 'Bekasi', 'Laki-laki', 'Islam', 'Akuntansi', '10', '12371283', 'kevindwinovmunir@gmail.com'),
('12160', '201912160', 'MUHAMAD ARDIANSAH', 'Yogyakarta', '1999-07-30', 'Tangerang', 'Laki-laki', 'Islam', 'Akuntansi', '10', '81823702349', 'muhamadardiansah@gmail.com'),
('12162', '201912162', 'MUHAMAD EDWARD', 'Banten', '2003-01-21', 'Jakarta', 'Laki-laki', 'Islam', 'Akuntansi', '10', '12371217', 'muhamadedward@gmail.com'),
('12163', '201912163', 'MUHAMAD FAIZ ATHALLAH', 'Bekasi', '2003-04-01', 'Bogor', 'Laki-laki', 'Islam', 'Akuntansi', '10', '1,98231E+14', 'muhamadfaizathallah@gmail.com'),
('12167', '201912167', 'MUHAMAD RENALDHI MULYADI', 'Tangerang', '1998-01-19', 'Yogyakarta', 'Laki-laki', 'Islam', 'Akuntansi', '10', '9324', 'muhamadrenaldhimulyadi@gmail.com'),
('12170', '201912170', 'MUHAMMAD AL GIFFARI', 'Jakarta', '1999-12-01', 'Banten', 'Laki-laki', 'Islam', 'Akuntansi', '10', '81273878123', 'muhammadalgiffari@gmail.com'),
('12183', '201912183', 'MUHAMMAD VICKY NUR AKMAL', 'Bogor', '1999-02-22', 'Bekasi', 'Laki-laki', 'Islam', 'Akuntansi', '10', '18387231', 'muhammadvickynurakmal@gmail.com'),
('12189', '201912189', 'NADIA BUNGA SEPTIAWATI', 'Yogyakarta', '1999-12-30', 'Tangerang', 'Perempuan', 'Islam', 'Akuntansi', '10', '12371283', 'nadiabungaseptiawati@gmail.com'),
('12200', '201912200', 'NAILAH SALSABILA', 'Banten', '2002-11-12', 'Bogor', 'Perempuan', 'Islam', 'Akuntansi', '10', '81823702349', 'nailahsalsabila@gmail.com'),
('12216', '201912216', 'OCTIVA SUCI ROSZAYANTIH', 'Bekasi', '2002-09-23', 'Yogyakarta', 'Perempuan', 'Islam', 'Akuntansi', '10', '81823702349', 'octivasuciroszayantih@gmail.com'),
('12221', '201912221', 'RADHITYA ANANDA RIZKY', 'Tangerang', '2003-12-18', 'Banten', 'Laki-laki', 'Islam', 'Akuntansi', '10', '12371217', 'radhityaanandarizky@gmail.com'),
('12226', '201912226', 'RAHMA AFRILIA', 'Bogor', '2003-07-12', 'Bekasi', 'Perempuan', 'Islam', 'Akuntansi', '10', '1,98231E+14', 'rahmaafrilia@gmail.com'),
('12229', '201912229', 'RAJA BY HAQI', 'Yogyakarta', '2003-08-03', 'Tangerang', 'Laki-laki', 'Islam', 'Akuntansi', '10', '9324', 'rajabyhaqi@gmail.com'),
('12239', '201912239', 'RYAN PRASETIO RAMADHAN', 'Banten', '2002-06-29', 'Banten', 'Laki-laki', 'Islam', 'Akuntansi', '10', '12371283', 'ryanprasetioramadhan@gmail.com'),
('12248', '201912248', 'SALWA FAJRIYAH', 'Bekasi', '2000-10-21', 'Jakarta', 'Perempuan', 'Islam', 'Akuntansi', '10', '81823702349', 'salwafajriyah@gmail.com'),
('12251', '201912251', 'SARAH PUTRI RIJANI', 'Tangerang', '1999-10-22', 'Jakarta', 'Perempuan', 'Islam', 'Akuntansi', '10', '12371217', 'sarahputririjani@gmail.com'),
('12261', '201912261', 'SOPIA FRADELLA', 'Banten', '2001-03-26', 'Jakarta', 'Perempuan', 'Islam', 'Akuntansi', '10', '1,98231E+14', 'sopiafradella@gmail.com'),
('12264', '201912264', 'SYAFAAH DAFINA ALIAH', 'Jakarta', '2001-05-08', 'Jakarta', 'Perempuan', 'Islam', 'Akuntansi', '10', '9324', 'syafaahdafinaaliah@gmail.com'),
('12272', '201912272', 'THORIQ RIVAI', 'Jakarta', '2002-09-24', 'Jakarta', 'Laki-laki', 'Islam', 'Akuntansi', '10', '81273878123', 'thoriqrivai@gmail.com'),
('12279', '201912279', 'WIDA NAHYATUL NAFISAH', 'Jakarta', '2003-12-17', 'Jakarta', 'Perempuan', 'Islam', 'Akuntansi', '10', '18387231', 'widanahyatulnafisah@gmail.com'),
('281923', '1239298', 'Fauzi Ajah', 'Jakarta', '1998-05-20', 'Nax Klender', 'Laki-Laki', 'ISLAM', 'Item 3', '10', '085776509645', 'fauzimaulanahabibi@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_kelas`
--

CREATE TABLE `tabel_kelas` (
  `id_kelas` int(11) NOT NULL,
  `kelas` varchar(20) NOT NULL,
  `id_jurusan` varchar(50) NOT NULL,
  `kelompok_kelas` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tabel_kelas`
--

INSERT INTO `tabel_kelas` (`id_kelas`, `kelas`, `id_jurusan`, `kelompok_kelas`) VALUES
(123, '10', 'Akuntansi', 'AK');

-- --------------------------------------------------------

--
-- Table structure for table `tabel_tu`
--

CREATE TABLE `tabel_tu` (
  `id_tu` int(11) NOT NULL,
  `nama_tu` varchar(50) NOT NULL,
  `jenis_kelamin_tu` varchar(10) NOT NULL,
  `nip_nikki` varchar(20) NOT NULL,
  `tempat_lahir_tu` varchar(30) NOT NULL,
  `tanggal_lahir_tu` date NOT NULL,
  `golongan_darah_tu` varchar(20) NOT NULL,
  `jabatan_tu` varchar(20) NOT NULL,
  `jurusan_tu` varchar(50) NOT NULL,
  `tahun_masuk_tu` varchar(10) NOT NULL,
  `alamat_tu` text NOT NULL,
  `no_hp_tu` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tabel_tu`
--

INSERT INTO `tabel_tu` (`id_tu`, `nama_tu`, `jenis_kelamin_tu`, `nip_nikki`, `tempat_lahir_tu`, `tanggal_lahir_tu`, `golongan_darah_tu`, `jabatan_tu`, `jurusan_tu`, `tahun_masuk_tu`, `alamat_tu`, `no_hp_tu`) VALUES
(1, 'Sri Ratnasari, S.E.', 'Perempuan', '197702232010012005', 'Kebumen', '0000-00-00', 'A', 'Kasubbag Tata Usaha', ' S1, Ilmu Ekonomi, 2001', '2010-01-01', ' Puri Alam Kencana 2, Blok N1, No.7, Nanggewer Mekar, Cibinong, Bogor', '081779059970'),
(2, ' Rita Yusniar S, S.Ap.', 'Perempuan', '1019548', 'Jakarta', '0000-00-00', 'A', 'TU / PHL', ' S1, Administrasi Public, 2009', '2016-01-02', ' Perum Mekar Sari blok B8 no.42, Bekasi, Jawa Barat', '081315946940'),
(3, ' Eka Herawati, S.Pd.', 'Perempuan', '1013550', 'Cikulur', '0000-00-00', 'A', 'TU / PHL', ' S1, Pendidikan Ekonomi, 2015', '2016-01-02', ' Jl. Uranium no.8, Kelurahan Grogol Utara, Kebayoran Lama, Jakarta Selatan', '081617002425'),
(4, ' Ferdy Irawan, S.Pd.', 'Laki-laki', '1013549', 'Jakarta', '0000-00-00', 'A', 'TU / PHL', ' S1, Pendidikan Matematika, 2006', '2016-01-02', ' Jl. Sulaiman Gg amal 1, no.47, Palmerah, Jakarta Barat', '081381151175'),
(5, ' Muhammad Ramli, S.Pd.', 'Laki-laki', '1013551', 'Kupang', '0000-00-00', 'A', 'TU / PHL', ' S1, Pendidikan Ekonomi, 2017', '2016-01-02', ' Jl. Mampang Prapatan, Jakarta Selatan', '082111087453'),
(6, ' Andi Ami', 'Laki-laki', '1013557', 'Jakarta', '0000-00-00', 'A', 'TU / PHL', ' SMK, Persiapan Grafika, 2001', '2018-01-02', ' Jl. Rawa Simpruk 1B, Kebayoran Lama, Jakarta Selatan', '081315443886'),
(7, ' Adeng Nugraha', 'Laki-laki', '1013554', 'Tasikmalaya', '0000-00-00', 'A', 'TU / PHL', ' D2, Tarbiyah, 2007', '2018-01-02', ' Jl. Danau Limboto no.11, Bendungan Hilir, Tanah Abang, Jakarta Pusat', '081210078691'),
(8, ' Putu Arya Ranesda, S.Kom.', 'Laki-laki', '1021462', 'Padang', '0000-00-00', 'A', 'TU / PHL', ' S1, Sistem Informasi, 2017', '2019-01-02', ' Pondok Kukusan Permai Blok M03, Beji, Depok', '081288388842'),
(9, ' Slamet Budi Santoso', 'Laki-laki', '1013552', 'Jakarta', '0000-00-00', 'A', 'PENJAGA SEKOLAH / PH', ' STM, Mesin Produksi, 1987', '2016-01-02', ' Jl. Menteng Atas Selatan III, Menteng Atas, Setia Budi, Jakarta Selatan', '085691360906'),
(10, ' Sri Dadi', 'Laki-laki', '1020613', 'Karang Anyar', '0000-00-00', 'A', 'PENJAGA SEKOLAH / PH', ' SMA, 1996', '2019-01-02', ' Jl. Rawa Simpruk 1B, Kebayoran Lama, Jakarta Selatan', '087820808754'),
(11, ' Barkatullah', 'Laki-laki', '1013553', 'Cirebon', '0000-00-00', 'A', 'CARAKA / PHL', ' SMA, 1990', '2018-01-02', ' Jl. Cipinang Timur, Pulo Gadung, Jakarta Timur', '087883322837'),
(12, ' Supriyadi', 'Laki-laki', '1013555', 'Jepara', '0000-00-00', 'A', 'CARAKA / PHL', ' Paket C, Bekasi, 2014', '2018-01-02', ' Jl. Angke Barat, Angke, Tambora, Jakarta Barat', '085884876994'),
(13, ' Muhammad Argil Ramadhani', 'Laki-laki', '1013556', 'Brebes', '0000-00-00', 'A', 'CARAKA / PHL', ' SMA, 2010', '2018-01-02', ' Jl. Haji Rohimin no.125, Kelurahan Ulujami, Pesanggrahan, Jakarta Selatan', '087887686401'),
(1231, 'Dhepi Panjul', 'Perempuan', '87128736788', 'Jakarta', '1996-06-12', 'A', 'Kepala Sekolah', 'Item 2', '2016', 'Cilon', '085652735277');

-- --------------------------------------------------------

--
-- Table structure for table `tb_guru`
--

CREATE TABLE `tb_guru` (
  `kode_guru` varchar(50) NOT NULL,
  `nip_guru` varchar(50) NOT NULL,
  `nama_guru` varchar(30) NOT NULL,
  `tempat_lahir_guru` varchar(20) NOT NULL,
  `tanggal_lahir_guru` varchar(30) NOT NULL,
  `jenis_kelamin_guru` varchar(20) NOT NULL,
  `mata_pelajaran_guru` varchar(30) NOT NULL,
  `no_hp_guru` varchar(50) NOT NULL,
  `alamat_guru` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_guru`
--

INSERT INTO `tb_guru` (`kode_guru`, `nip_guru`, `nama_guru`, `tempat_lahir_guru`, `tanggal_lahir_guru`, `jenis_kelamin_guru`, `mata_pelajaran_guru`, `no_hp_guru`, `alamat_guru`) VALUES
('123a', '123', 'Fauzi', 'La', '12121997', 'LAKI-LAKI', 'MTK', '08111111111111', 'Bogor'),
('KASJDHS', '91827393', 'ANWAR', 'TASIK', 'RAHASIA', 'LAKI-LAKI', 'PEMROGRAMAN', '012732392', 'JAKARTA SELATAN');

-- --------------------------------------------------------

--
-- Table structure for table `tb_jurusan`
--

CREATE TABLE `tb_jurusan` (
  `kode_jurusan` varchar(20) NOT NULL,
  `nama_jurusan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_jurusan`
--

INSERT INTO `tb_jurusan` (`kode_jurusan`, `nama_jurusan`) VALUES
('ap', 'Adminitrasi Perkantoran'),
('cerita', 'i'),
('ceritas', 'cerita'),
('s', 'asda');

-- --------------------------------------------------------

--
-- Table structure for table `tb_mapel`
--

CREATE TABLE `tb_mapel` (
  `kode_mapel` varchar(20) NOT NULL,
  `nama_mapel` varchar(100) NOT NULL,
  `kode_jurusan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_mapel`
--

INSERT INTO `tb_mapel` (`kode_mapel`, `nama_mapel`, `kode_jurusan`) VALUES
('admin', 'admin', 'Admin Perkantoran'),
('asa', 'ass', 'AP'),
('asad', 'asdas', 'Admin Perkantoran');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(50) NOT NULL,
  `level` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `level`) VALUES
(1, 'super.admin', 'admin123', 'super.admin'),
(2, 'fauzi', 'guru123', 'guru');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jurusan_siswa`
--
ALTER TABLE `jurusan_siswa`
  ADD PRIMARY KEY (`id_jurusan`);

--
-- Indexes for table `tabelsiswa`
--
ALTER TABLE `tabelsiswa`
  ADD PRIMARY KEY (`nis`);

--
-- Indexes for table `tabel_kelas`
--
ALTER TABLE `tabel_kelas`
  ADD PRIMARY KEY (`id_kelas`);

--
-- Indexes for table `tabel_tu`
--
ALTER TABLE `tabel_tu`
  ADD PRIMARY KEY (`id_tu`);

--
-- Indexes for table `tb_jurusan`
--
ALTER TABLE `tb_jurusan`
  ADD PRIMARY KEY (`kode_jurusan`);

--
-- Indexes for table `tb_mapel`
--
ALTER TABLE `tb_mapel`
  ADD PRIMARY KEY (`kode_mapel`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jurusan_siswa`
--
ALTER TABLE `jurusan_siswa`
  MODIFY `id_jurusan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
