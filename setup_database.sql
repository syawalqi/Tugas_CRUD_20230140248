-- Create Database
CREATE DATABASE IF NOT EXISTS spring3;
USE spring3;

-- Create KTP Table
CREATE TABLE IF NOT EXISTS ktp (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nomor_ktp VARCHAR(20) UNIQUE NOT NULL,
    nama_lengkap VARCHAR(255) NOT NULL,
    alamat VARCHAR(255) NOT NULL,
    tanggal_lahir DATE NOT NULL,
    jenis_kelamin VARCHAR(20) NOT NULL
);
