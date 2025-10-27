package com.shirobokov.qr_analytics_microservice.service;


import com.shirobokov.qr_analytics_microservice.api_integrations.client.IpAddressClient;
import com.shirobokov.qr_analytics_microservice.dto.IpInfoDTO;
import com.shirobokov.qr_analytics_microservice.entity.ScanInformation;
import com.shirobokov.qr_analytics_microservice.repository.ScanInformationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScanInformationService {

    private final ScanInformationRepository scanInformationRepository;

    private final IpAddressClient ipAddressClient;

    public IpInfoDTO getInformationAboutIp(String ip) {

        IpInfoDTO ipInfoDTO = ipAddressClient.getIpInfo(ip);
        log.info("{} Полученная информация: {}", this.getClass().getName(), ipInfoDTO);
        return ipInfoDTO;
    }

    public void mapAndSaveScanInformation(ScanInformation scanInformation, IpInfoDTO ipInfoDTO) {
        scanInformation.setContinent(ipInfoDTO.getData().getContinent());
        scanInformation.setCountry(ipInfoDTO.getData().getCountry());
        scanInformation.setRegion(ipInfoDTO.getData().getRegion());
        scanInformation.setCity(ipInfoDTO.getData().getCity());
        scanInformation.setPostalCode(ipInfoDTO.getData().getPostalCode());
        scanInformation.setLatitude(ipInfoDTO.getData().getLatitude());
        scanInformation.setLongitude(ipInfoDTO.getData().getLongitude());

        scanInformationRepository.save(scanInformation);

        log.info("{} Сущность {} сохранена", this.getClass().getName(), scanInformation);
    }

}
