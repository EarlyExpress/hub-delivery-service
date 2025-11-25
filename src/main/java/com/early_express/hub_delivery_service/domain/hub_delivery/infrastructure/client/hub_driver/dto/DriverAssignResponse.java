package com.early_express.hub_delivery_service.domain.hub_delivery.infrastructure.client.hub_driver.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 드라이버 배정 응답 DTO
 * HubDriver Service → HubDelivery Service
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverAssignResponse {

    private String driverId;
    private String userId;
    private String driverName;
    private String status;
    private LocalDateTime assignedAt;

    /**
     * 배정 성공 여부 확인
     */
    public boolean isSuccess() {
        return driverId != null && !driverId.isBlank();
    }
}
