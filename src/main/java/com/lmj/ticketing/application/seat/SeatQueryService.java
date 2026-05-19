package com.lmj.ticketing.application.seat;

import com.lmj.ticketing.application.seat.dto.SeatResponse;
import com.lmj.ticketing.infrastructure.persistence.seat.SeatRepository;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SeatQueryService {

    private final SeatRepository seatRepository;

    public List<SeatResponse> findAllByShowId(Long showId) {
        return seatRepository.findByShowIdOrderBySeatNoAsc(showId)
                .stream()
                .map(SeatResponse::from)
                .toList();
    }
}
