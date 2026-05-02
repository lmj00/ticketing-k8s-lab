package com.lmj.ticketing.domain.hold;

/**
 * {@code seat_hold} 행의 상태 (TTL 만료·취소·확정 반영).
 */
public enum SeatHoldStatus {
    HELD,
    EXPIRED,
    CANCELLED,
    CONFIRMED
}
