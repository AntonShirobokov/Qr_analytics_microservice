package com.shirobokov.qr_analytics_microservice.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name="scan_information")
public class ScanInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="scan_id")
    private Integer scanId;

    @Column(name="qr_code_id")
    private UUID qrCodeId;

    @Column(name="ip_address")
    private String ipAddress;

    @Column(name="scan_at")
    private LocalDateTime scanAt;

    @Column(name="continent")
    private String continent;

    @Column(name="country")
    private String country;

    @Column(name="region")
    private String region;

    @Column(name="city")
    private String city;

    @Column(name="postal_code")
    private String postal_code;

    @Column(name="latitude")
    private Float latitude;

    @Column(name="longitude")
    private Float longitude;

}
