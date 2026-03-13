package com.example.demo.controller;

import com.example.demo.dto.KtpRequest;
import com.example.demo.dto.KtpResponse;
import com.example.demo.model.WebResponse;
import com.example.demo.service.KtpService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ktp")
@CrossOrigin(origins = "*")
public class KtpController {

    @Autowired
    private KtpService ktpService;

    @PostMapping
    public WebResponse<KtpResponse> create(@Valid @RequestBody KtpRequest request) {
        KtpResponse ktpResponse = ktpService.create(request);
        return WebResponse.<KtpResponse>builder()
                .code(HttpStatus.OK.value())
                .status("OK")
                .data(ktpResponse)
                .message("Data KTP berhasil ditambahkan")
                .build();
    }

    @GetMapping
    public WebResponse<List<KtpResponse>> getAll() {
        List<KtpResponse> ktpResponses = ktpService.getAll();
        return WebResponse.<List<KtpResponse>>builder()
                .code(HttpStatus.OK.value())
                .status("OK")
                .data(ktpResponses)
                .build();
    }

    @GetMapping("/{id}")
    public WebResponse<KtpResponse> getById(@PathVariable Integer id) {
        KtpResponse ktpResponse = ktpService.getById(id);
        return WebResponse.<KtpResponse>builder()
                .code(HttpStatus.OK.value())
                .status("OK")
                .data(ktpResponse)
                .build();
    }

    @PutMapping("/{id}")
    public WebResponse<KtpResponse> update(@PathVariable Integer id, @Valid @RequestBody KtpRequest request) {
        KtpResponse ktpResponse = ktpService.update(id, request);
        return WebResponse.<KtpResponse>builder()
                .code(HttpStatus.OK.value())
                .status("OK")
                .data(ktpResponse)
                .message("Data KTP berhasil diperbarui")
                .build();
    }

    @DeleteMapping("/{id}")
    public WebResponse<String> delete(@PathVariable Integer id) {
        ktpService.delete(id);
        return WebResponse.<String>builder()
                .code(HttpStatus.OK.value())
                .status("OK")
                .data("OK")
                .message("Data KTP berhasil dihapus")
                .build();
    }
}
