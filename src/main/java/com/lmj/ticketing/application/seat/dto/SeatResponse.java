package com.lmj.ticketing.application.seat.dto;

import com.lmj.ticketing.domain.seat.Seat;
import com.lmj.ticketing.domain.seat.SeatStatus;

public record SeatResponse(
        Long id,
        Long showId,
        String seatNo,
        String grade,
        int price,
        SeatStatus status
) {
    public static SeatResponse from(Seat seat) {
        return new SeatResponse(
                seat.getId(),
                seat.getShow().getId(),
                seat.getSeatNo(),
                seat.getGrade(),
                seat.getPrice(),
                seat.getStatus()
        );
    }
}
