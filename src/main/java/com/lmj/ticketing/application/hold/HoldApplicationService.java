package com.lmj.ticketing.application.hold;

import org.springframework.stereotype.Service;

@Service
public class HoldApplicationService {

    /**
     * 좌석 홀드 생성. Flyway 스키마·리포지토리 연동 후 구현한다.
     */
    public void createHold(long showId, long seatId, long userId) {
        throw new UnsupportedOperationException("Phase 1: implement after schema and persistence");
    }
}
