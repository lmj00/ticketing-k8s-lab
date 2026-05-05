package com.lmj.ticketing.domain.reservation;

import com.lmj.ticketing.domain.hold.SeatHold;
import com.lmj.ticketing.domain.seat.Seat;
import com.lmj.ticketing.domain.show.ConcertShow;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reservation_no", nullable = false, length = 40)
    private String reservationNo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "show_id", nullable = false)
    private ConcertShow show;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hold_id", nullable = false)
    private SeatHold hold;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private ReservationStatus status;

    @Column(name = "idempotency_key", length = 100)
    private String idempotencyKey;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    public Reservation(String reservationNo, ConcertShow show, Seat seat, long userId, SeatHold hold, ReservationStatus status, String idempotencyKey) {
        this.reservationNo = reservationNo;
        this.show = show;
        this.seat = seat;
        this.userId = userId;
        this.hold = hold;
        this.status = status;
        this.idempotencyKey = idempotencyKey;
    }
}
