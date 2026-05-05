package com.lmj.ticketing.infrastructure.persistence.seat;

import com.lmj.ticketing.domain.seat.Seat;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByShowIdOrderBySeatNoAsc(Long showId);
}

