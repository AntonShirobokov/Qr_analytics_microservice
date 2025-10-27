package com.shirobokov.qr_analytics_microservice.api_integrations.client;


import com.shirobokov.qr_analytics_microservice.dto.IpInfoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@RequiredArgsConstructor
@Slf4j
public class IpAddressClient {

    private final RestClient restClientForIPWHO;

    public IpInfoDTO getIpInfo(String ip){
        IpInfoDTO ipInfoDTO = restClientForIPWHO.get()
                .uri("https://api.ipwho.org/ip/{ipAddress}?get=continent,country,region,city,postal_Code,latitude,longitude", ip)
                .accept(MediaType.APPLICATION_JSON)
                .exchange((request, response) -> {
                    if (response.getStatusCode().is5xxServerError()) {
                        log.info("{} Ошибка на сервере сайта https://api.ipwho.org", this.getClass().getName());
                        return new IpInfoDTO();
                    }
                    else if (response.getStatusCode().is4xxClientError()) {
                        log.info("{} Информацию про ip {} найти не удалось", this.getClass().getName(), ip);
                        return new IpInfoDTO();
                    }
                    else {
                        log.info("{} Тело ответа {}", this.getClass().getName(), response.getBody());
                        return response.bodyTo(IpInfoDTO.class);
                    }
        });


        log.info("{} Информация о ip {}: {}, с сайта https://ipwho.org/", this.getClass().getName(), ip, ipInfoDTO);

        return ipInfoDTO;
    }
}
