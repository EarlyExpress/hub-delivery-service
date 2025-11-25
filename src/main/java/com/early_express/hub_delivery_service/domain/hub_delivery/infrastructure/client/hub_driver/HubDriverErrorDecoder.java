package com.early_express.hub_delivery_service.domain.hub_delivery.infrastructure.client.hub_driver;

import com.early_express.hub_delivery_service.domain.hub_delivery.domain.exception.HubDeliveryErrorCode;
import com.early_express.hub_delivery_service.domain.hub_delivery.domain.exception.HubDeliveryException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

/**
 * HubDriver Client 에러 디코더
 * HubDriver Service의 HTTP 에러를 도메인 예외로 변환
 */
@Slf4j
public class HubDriverErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        log.error("HubDriver Service 호출 실패 - Method: {}, Status: {}",
                methodKey, response.status());

        return switch (response.status()) {
            case 400 -> new HubDeliveryException(
                    HubDeliveryErrorCode.DRIVER_NOT_ASSIGNED,
                    "드라이버 배정 요청이 올바르지 않습니다."
            );
            case 404 -> new HubDeliveryException(
                    HubDeliveryErrorCode.DRIVER_NOT_ASSIGNED,
                    "배정 가능한 드라이버를 찾을 수 없습니다."
            );
            case 500 -> new HubDeliveryException(
                    HubDeliveryErrorCode.DRIVER_NOT_ASSIGNED,
                    "드라이버 서비스 내부 오류가 발생했습니다."
            );
            case 503 -> new HubDeliveryException(
                    HubDeliveryErrorCode.DRIVER_NOT_ASSIGNED,
                    "드라이버 서비스를 사용할 수 없습니다."
            );
            default -> defaultErrorDecoder.decode(methodKey, response);
        };
    }
}
