package com.example.demo.service;

import com.example.demo.entity.Ktp;
import com.example.demo.repository.KtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KtpService {

    @Autowired
    private KtpRepository ktpRepository;

    public Ktp save(Ktp ktp) {
        if (ktpRepository.findByNomorKtp(ktp.getNomorKtp()).isPresent()) {
            throw new RuntimeException("Nomor KTP sudah terdaftar!");
        }
        return ktpRepository.save(ktp);
    }

    public List<Ktp> findAll() {
        return ktpRepository.findAll();
    }

    public Optional<Ktp> findById(Integer id) {
        return ktpRepository.findById(id);
    }

    public Ktp update(Integer id, Ktp ktpDetails) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data KTP tidak ditemukan!"));

        // Check if nomorKtp is being updated and if the new one already exists
        if (!ktp.getNomorKtp().equals(ktpDetails.getNomorKtp())) {
            if (ktpRepository.findByNomorKtp(ktpDetails.getNomorKtp()).isPresent()) {
                throw new RuntimeException("Nomor KTP baru sudah digunakan!");
            }
        }

        ktp.setNomorKtp(ktpDetails.getNomorKtp());
        ktp.setNamaLengkap(ktpDetails.getNamaLengkap());
        ktp.setAlamat(ktpDetails.getAlamat());
        ktp.setTanggalLahir(ktpDetails.getTanggalLahir());
        ktp.setJenisKelamin(ktpDetails.getJenisKelamin());

        return ktpRepository.save(ktp);
    }

    public void delete(Integer id) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data KTP tidak ditemukan!"));
        ktpRepository.delete(ktp);
    }
}
