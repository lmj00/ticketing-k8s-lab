package com.lmj.ticketing.infrastructure.persistence.reservation;

import com.lmj.ticketing.domain.reservation.Reservation;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findByIdempotencyKey(String idempotencyKey);

    boolean existsByShowIdAndSeatId(Long showId, Long seatId);
}

