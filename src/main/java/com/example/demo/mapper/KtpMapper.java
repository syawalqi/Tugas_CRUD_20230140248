package com.example.demo.mapper;

import com.example.demo.dto.KtpResponse;
import com.example.demo.entity.Ktp;
import org.springframework.stereotype.Component;

@Component
public class KtpMapper {

    public KtpResponse toResponse(Ktp ktp) {
        return KtpResponse.builder()
                .id(ktp.getId())
                .nomorKtp(ktp.getNomorKtp())
                .namaLengkap(ktp.getNamaLengkap())
                .alamat(ktp.getAlamat())
                .tanggalLahir(ktp.getTanggalLahir())
                .jenisKelamin(ktp.getJenisKelamin())
                .build();
    }
}
