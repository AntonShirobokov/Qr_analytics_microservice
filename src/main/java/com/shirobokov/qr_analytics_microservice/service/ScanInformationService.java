package com.shirobokov.qr_analytics_microservice.service;


import com.shirobokov.qr_analytics_microservice.repository.ScanInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScanInformationService {

    private final ScanInformationRepository scanInformationRepository;



}
