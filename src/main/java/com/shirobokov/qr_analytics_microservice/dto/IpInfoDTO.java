package com.shirobokov.qr_analytics_microservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

@Data
public class IpInfoDTO {

    private boolean success;

    private IpData data;

    @Data
    public static class IpData {
        private String continent;
        private String country;
        private String region;
        private String city;
        @JsonProperty("postal_Code")
        private String postalCode;
        private Float latitude;
        private Float longitude;
    }
}
