package com.early_express.hub_delivery_service.domain.hub_delivery.infrastructure.client.hub_driver;

import com.early_express.hub_delivery_service.domain.hub_delivery.infrastructure.client.hub_driver.dto.DriverAssignRequest;
import com.early_express.hub_delivery_service.domain.hub_delivery.infrastructure.client.hub_driver.dto.DriverAssignResponse;
import com.early_express.hub_delivery_service.domain.hub_delivery.infrastructure.client.hub_driver.dto.DriverCompleteRequest;
import com.early_express.hub_delivery_service.domain.hub_delivery.infrastructure.client.hub_driver.dto.DriverOperationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * HubDriver Service Feign Client
 * 허브 배송 담당자 서비스와의 동기 통신
 */
@FeignClient(
        name = "hub-driver-service",
//        url = "${client.hub-driver-service.url}",
        configuration = HubDriverClientConfig.class
)
public interface HubDriverClient {

    /**
     * 드라이버 자동 배정
     * - HubDelivery 생성 후 호출
     * - 배정 가능한 드라이버 중 우선순위가 가장 낮은 드라이버에게 배정
     *
     * @param request 배정 요청 (hubDeliveryId)
     * @return 배정된 드라이버 정보
     */
    @PostMapping("/v1/hub-driver/internal/drivers/assign")
    DriverAssignResponse assignDriver(@RequestBody DriverAssignRequest request);

    /**
     * 배송 완료 통지
     * - HubDelivery 완료 시 호출
     * - 드라이버 상태를 AVAILABLE로 변경하고 통계 업데이트
     *
     * @param driverId 드라이버 ID
     * @param request 완료 요청 (deliveryTimeMin)
     * @return 작업 결과
     */
    @PutMapping("/v1/hub-driver/internal/drivers/{driverId}/complete")
    DriverOperationResponse completeDelivery(
            @PathVariable("driverId") String driverId,
            @RequestBody DriverCompleteRequest request
    );

    /**
     * 배송 취소 통지
     * - HubDelivery 취소 시 호출
     * - 드라이버 배정 해제 및 상태를 AVAILABLE로 변경
     *
     * @param driverId 드라이버 ID
     * @return 작업 결과
     */
    @PutMapping("/v1/hub-driver/internal/drivers/{driverId}/cancel")
    DriverOperationResponse cancelDelivery(@PathVariable("driverId") String driverId);
}
