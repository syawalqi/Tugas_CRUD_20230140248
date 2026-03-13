package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "ktp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ktp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nomorKtp", unique = true, nullable = false)
    @NotBlank(message = "Nomor KTP tidak boleh kosong")
    private String nomorKtp;

    @Column(name = "namaLengkap", nullable = false)
    @NotBlank(message = "Nama lengkap tidak boleh kosong")
    private String namaLengkap;

    @Column(name = "alamat", nullable = false)
    @NotBlank(message = "Alamat tidak boleh kosong")
    private String alamat;

    @Column(name = "tanggalLahir", nullable = false)
    @NotNull(message = "Tanggal lahir tidak boleh kosong")
    private LocalDate tanggalLahir;

    @Column(name = "jenisKelamin", nullable = false)
    @NotBlank(message = "Jenis kelamin tidak boleh kosong")
    private String jenisKelamin;
}
