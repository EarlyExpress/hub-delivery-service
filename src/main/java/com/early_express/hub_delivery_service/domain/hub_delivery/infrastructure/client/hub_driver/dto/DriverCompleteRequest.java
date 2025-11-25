package com.early_express.hub_delivery_service.domain.hub_delivery.infrastructure.client.hub_driver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 배송 완료 통지 요청 DTO
 * HubDelivery Service → HubDriver Service
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverCompleteRequest {

    private Long deliveryTimeMin;

    public static DriverCompleteRequest of(Long deliveryTimeMin) {
        return DriverCompleteRequest.builder()
                .deliveryTimeMin(deliveryTimeMin)
                .build();
    }
}
