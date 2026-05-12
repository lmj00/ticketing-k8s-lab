package com.lmj.ticketing.application.show.dto;

import com.lmj.ticketing.domain.show.ConcertShow;
import java.time.LocalDateTime;

public record ShowResponse(
        Long id,
        Long concertId,
        LocalDateTime showAt
) {
    public static ShowResponse from(ConcertShow show) {
        return new ShowResponse(
                show.getId(),
                show.getConcert().getId(),
                show.getShowAt()
        );
    }
}
