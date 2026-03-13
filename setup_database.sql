-- Create Database
CREATE DATABASE IF NOT EXISTS spring3;
USE spring3;

-- Create KTP Table
CREATE TABLE IF NOT EXISTS ktp (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nomorKtp VARCHAR(20) UNIQUE NOT NULL,
    namaLengkap VARCHAR(255) NOT NULL,
    alamat VARCHAR(255) NOT NULL,
    tanggalLahir DATE NOT NULL,
    jenisKelamin VARCHAR(20) NOT NULL
);
