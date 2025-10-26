package com.shirobokov.qr_analytics_microservice.restcontroller;


import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/test")
    public ResponseEntity<?> testController() {
        return ResponseEntity.ok("Hello world!");
    }

    private final ApplicationContext ctx;

    @GetMapping("/all-beans")
    public Map<String, String> getAllBeans() {
        Map<String, String> result = new LinkedHashMap<>();

        // Получаем все имена бинов из контекста
        String[] allBeanNames = ctx.getBeanDefinitionNames();

        // Перебираем все имена и кладем в результат реальный класс объекта
        for (String beanName : allBeanNames) {
            Object bean = ctx.getBean(beanName);
            result.put(beanName, bean.getClass().getName());
        }

        return result;
    }

    @GetMapping("/rabbit-beans")
    public Map<String, String> getRabbitBeans() {
        Map<String, String> result = new LinkedHashMap<>();

        // Список типов бинов RabbitMQ
        Class<?>[] types = {
                ConnectionFactory.class,
                RabbitTemplate.class,
                RabbitAdmin.class,
                MessageListenerContainer.class
        };

        // Для каждого типа ищем бины и выводим их реальные классы
        for (Class<?> type : types) {
            Map<String, ?> beans = ctx.getBeansOfType(type);
            beans.forEach((name, bean) -> result.put(name, bean.getClass().getName()));
        }

        return result;
    }
}
