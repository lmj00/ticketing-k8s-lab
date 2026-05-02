package com.lmj.ticketing.application.reservation;

import org.springframework.stereotype.Service;

@Service
public class ReservationApplicationService {

    /**
     * 홀드 기반 예약 확정. Flyway 스키마·리포지토리 연동 후 구현한다.
     */
    public void confirmReservation(long holdId, long userId) {
        throw new UnsupportedOperationException("Phase 1: implement after schema and persistence");
    }
}
