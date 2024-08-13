package com.myatlas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    // Конфигурация для RestTemplate, который может использоваться для вызова внешних API
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // Другие общие конфигурации приложения могут быть добавлены сюда

    // Пример: Если нужно, можно добавить бин для маппера объектов
    // @Bean
    // public ModelMapper modelMapper() {
    //     return new ModelMapper();
    // }
}
