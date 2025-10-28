package com.shirobokov.qr_analytics_microservice.repository;


import com.shirobokov.qr_analytics_microservice.entity.ScanInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ScanInformationRepository extends JpaRepository<ScanInformation, Integer> {


    @NativeQuery("SELECT COUNT(*) FROM scan_information where qr_code_id = ?1")
    Integer getCountOfRedirect(UUID qrCodeId);


}
