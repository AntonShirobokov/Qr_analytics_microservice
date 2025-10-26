package com.shirobokov.qr_analytics_microservice.rabbitmq.listener;


import com.shirobokov.qr_analytics_microservice.entity.ScanInformation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class AnalyticsListener {

    @RabbitListener(queues={"analytics_queue"})
    public void getEvent(ScanInformation scanEvent) {

        log.info("++++++++++ Получено сообщение из очереди: {} ++++++++++", scanEvent);
    }

}
