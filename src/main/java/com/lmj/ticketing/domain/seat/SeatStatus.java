package com.lmj.ticketing.domain.seat;

/**
 * 좌석의 비즈니스 상태 ({@code docs/domain-rules.md} 기준).
 */
public enum SeatStatus {
    AVAILABLE,
    HELD,
    RESERVED
}
