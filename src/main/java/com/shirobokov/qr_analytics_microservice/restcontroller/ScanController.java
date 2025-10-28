package com.shirobokov.qr_analytics_microservice.restcontroller;

import com.shirobokov.qr_analytics_microservice.service.ScanInformationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ScanController {

    private final ScanInformationService scanInformationService;

    @GetMapping("/{qrCodeId}")
    public ResponseEntity<?> getCountOfRedirect(@PathVariable UUID qrCodeId) {

        Integer count = scanInformationService.getCountOfRedirect(qrCodeId);

        log.info("{} Количество сканирований qr кода {}: {}", this.getClass().getName(), qrCodeId, count);

        return ResponseEntity.ok(Map.of("countOfRedirect", count));
    }
}
