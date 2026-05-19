package com.lmj.ticketing.presentation.seat;

import com.lmj.ticketing.application.seat.SeatQueryService;
import com.lmj.ticketing.application.seat.dto.SeatResponse;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shows/{showId}/seats")
public class SeatController {

    private final SeatQueryService seatQueryService;

    @GetMapping
    public List<SeatResponse> getSeatsByShow(@PathVariable Long showId) {
        return seatQueryService.findAllByShowId(showId);
    }
}
