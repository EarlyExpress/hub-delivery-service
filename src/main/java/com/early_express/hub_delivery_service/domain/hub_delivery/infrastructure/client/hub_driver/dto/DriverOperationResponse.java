package com.early_express.hub_delivery_service.domain.hub_delivery.infrastructure.client.hub_driver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 드라이버 작업 응답 DTO
 * HubDriver Service → HubDelivery Service
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverOperationResponse {

    private String driverId;
    private String status;
    private String message;
    private Long timestamp;
}
