package com.lmj.ticketing.domain.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * API/도메인 예외에 매핑되는 오류 코드 ({@code docs/domain-rules.md}).
 */
@Getter
@RequiredArgsConstructor
public enum BookingErrorCode {
    CONCERT_NOT_FOUND(HttpStatus.NOT_FOUND, "공연을 찾을 수 없습니다"),
    SHOW_NOT_FOUND(HttpStatus.NOT_FOUND, "회차를 찾을 수 없습니다"),
    SEAT_NOT_FOUND(HttpStatus.NOT_FOUND, "좌석을 찾을 수 없습니다"),
    HOLD_NOT_FOUND(HttpStatus.NOT_FOUND, "선점 정보를 찾을 수 없습니다. 좌석을 다시 선택해 주세요"),

    HOLD_ALREADY_EXISTS(HttpStatus.CONFLICT, "이미 선점된 좌석입니다"),
    SEAT_ALREADY_RESERVED(HttpStatus.CONFLICT, "이미 예매된 좌석입니다"),
    HOLD_EXPIRED(HttpStatus.CONFLICT, "선택 시간이 만료되었습니다. 좌석을 다시 선택해 주세요"),
    HOLD_OWNER_MISMATCH(HttpStatus.FORBIDDEN, "본인이 선점한 좌석만 예매할 수 있습니다");

    private final HttpStatus status;
    private final String message;
}
