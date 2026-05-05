package com.lmj.ticketing.infrastructure.persistence.hold;

import com.lmj.ticketing.domain.hold.SeatHold;
import com.lmj.ticketing.domain.hold.SeatHoldStatus;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatHoldRepository extends JpaRepository<SeatHold, Long> {
    Optional<SeatHold> findByIdempotencyKey(String idempotencyKey);

    Optional<SeatHold> findBySeatIdAndStatusIn(Long seatId, List<SeatHoldStatus> statuses);

    List<SeatHold> findByStatusAndExpiresAtBefore(SeatHoldStatus status, LocalDateTime now);
}

