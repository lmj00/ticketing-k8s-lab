package com.lmj.ticketing.domain.error;

/**
 * API/도메인 예외에 매핑되는 오류 코드 ({@code docs/domain-rules.md}).
 */
public enum BookingErrorCode {
    HOLD_ALREADY_EXISTS,
    SEAT_ALREADY_RESERVED,
    HOLD_EXPIRED,
    HOLD_NOT_FOUND,
    HOLD_OWNER_MISMATCH
}
