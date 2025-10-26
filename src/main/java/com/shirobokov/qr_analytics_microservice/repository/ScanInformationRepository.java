package com.shirobokov.qr_analytics_microservice.repository;


import com.shirobokov.qr_analytics_microservice.entity.ScanInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScanInformationRepository extends JpaRepository<ScanInformation, Integer> {


}
