package com.example.demo.controller;

import com.example.demo.entity.Ktp;
import com.example.demo.service.KtpService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ktp")
@CrossOrigin(origins = "*") // Allow CORS for AJAX calls
public class KtpController {

    @Autowired
    private KtpService ktpService;

    @PostMapping
    public ResponseEntity<?> createKtp(@Valid @RequestBody Ktp ktp) {
        try {
            return ResponseEntity.ok(ktpService.save(ktp));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Ktp> getAllKtp() {
        return ktpService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getKtpById(@PathVariable Integer id) {
        return ktpService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateKtp(@PathVariable Integer id, @Valid @RequestBody Ktp ktpDetails) {
        try {
            return ResponseEntity.ok(ktpService.update(id, ktpDetails));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteKtp(@PathVariable Integer id) {
        try {
            ktpService.delete(id);
            return ResponseEntity.ok("Data KTP berhasil dihapus");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
