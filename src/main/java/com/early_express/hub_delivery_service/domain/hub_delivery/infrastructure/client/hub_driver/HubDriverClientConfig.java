package com.early_express.hub_delivery_service.domain.hub_delivery.infrastructure.client.hub_driver;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * HubDriver Client 설정
 */
@Configuration
public class HubDriverClientConfig {

    /**
     * HubDriver 전용 에러 디코더
     */
    @Bean
    public ErrorDecoder hubDriverErrorDecoder() {
        return new HubDriverErrorDecoder();
    }
}
