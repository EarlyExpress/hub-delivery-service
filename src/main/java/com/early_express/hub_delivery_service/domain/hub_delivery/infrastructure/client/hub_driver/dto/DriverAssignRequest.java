package com.early_express.hub_delivery_service.domain.hub_delivery.infrastructure.client.hub_driver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 드라이버 자동 배정 요청 DTO
 * HubDelivery Service → HubDriver Service
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverAssignRequest {

    private String hubDeliveryId;

    public static DriverAssignRequest of(String hubDeliveryId) {
        return DriverAssignRequest.builder()
                .hubDeliveryId(hubDeliveryId)
                .build();
    }
}
