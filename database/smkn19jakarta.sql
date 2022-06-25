-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 25 Jun 2022 pada 16.45
-- Versi server: 10.4.17-MariaDB
-- Versi PHP: 8.0.2

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
-- Struktur dari tabel `tb_guru`
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
-- Dumping data untuk tabel `tb_guru`
--

INSERT INTO `tb_guru` (`kode_guru`, `nip_guru`, `nama_guru`, `tempat_lahir_guru`, `tanggal_lahir_guru`, `jenis_kelamin_guru`, `mata_pelajaran_guru`, `no_hp_guru`, `alamat_guru`) VALUES
('001', '209440234', 'rifwan', 'jakarta', '22-06-3003', 'LAKI-LAKI', 'mtk', '08223444393', 'bogor'),
('123a', '123', 'Fauzi', 'La', '12121997', 'LAKI-LAKI', 'MTK', '08111111111111', 'Bogor');

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(50) NOT NULL,
  `level` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `level`) VALUES
(1, 'super.admin', 'admin123', 'super.admin'),
(2, 'fauzi', 'guru123', 'guru');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_guru`
--
ALTER TABLE `tb_guru`
  ADD PRIMARY KEY (`kode_guru`);

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
