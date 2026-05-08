package com.lmj.ticketing.application.concert.dto;

import com.lmj.ticketing.domain.concert.Concert;
import java.time.LocalDateTime;

public record ConcertResponse(
        Long id,
        String title,
        LocalDateTime createdAt
) {
    public static ConcertResponse from(Concert concert) {
        return new ConcertResponse(
                concert.getId(),
                concert.getTitle(),
                concert.getCreatedAt()
        );
    }
}
