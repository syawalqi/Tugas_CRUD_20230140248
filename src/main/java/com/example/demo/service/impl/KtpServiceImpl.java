package com.example.demo.service.impl;

import com.example.demo.dto.KtpRequest;
import com.example.demo.dto.KtpResponse;
import com.example.demo.entity.Ktp;
import com.example.demo.mapper.KtpMapper;
import com.example.demo.repository.KtpRepository;
import com.example.demo.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KtpServiceImpl implements KtpService {

    @Autowired
    private KtpRepository ktpRepository;

    @Autowired
    private KtpMapper ktpMapper;

    @Override
    @Transactional
    public KtpResponse create(KtpRequest request) {
        if (ktpRepository.findByNomorKtp(request.getNomorKtp()).isPresent()) {
            throw new RuntimeException("Nomor KTP sudah terdaftar!");
        }

        Ktp ktp = new Ktp();
        ktp.setNomorKtp(request.getNomorKtp());
        ktp.setNamaLengkap(request.getNamaLengkap());
        ktp.setAlamat(request.getAlamat());
        ktp.setTanggalLahir(request.getTanggalLahir());
        ktp.setJenisKelamin(request.getJenisKelamin());

        ktpRepository.save(ktp);
        return ktpMapper.toResponse(ktp);
    }

    @Override
    @Transactional(readOnly = true)
    public List<KtpResponse> getAll() {
        List<Ktp> ktps = ktpRepository.findAll();
        return ktps.stream()
                .map(ktpMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public KtpResponse getById(Integer id) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data KTP tidak ditemukan!"));
        return ktpMapper.toResponse(ktp);
    }

    @Override
    @Transactional
    public KtpResponse update(Integer id, KtpRequest request) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data KTP tidak ditemukan!"));

        if (!ktp.getNomorKtp().equals(request.getNomorKtp())) {
            if (ktpRepository.findByNomorKtp(request.getNomorKtp()).isPresent()) {
                throw new RuntimeException("Nomor KTP baru sudah digunakan!");
            }
        }

        ktp.setNomorKtp(request.getNomorKtp());
        ktp.setNamaLengkap(request.getNamaLengkap());
        ktp.setAlamat(request.getAlamat());
        ktp.setTanggalLahir(request.getTanggalLahir());
        ktp.setJenisKelamin(request.getJenisKelamin());

        ktpRepository.save(ktp);
        return ktpMapper.toResponse(ktp);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data KTP tidak ditemukan!"));
        ktpRepository.delete(ktp);
    }
}
