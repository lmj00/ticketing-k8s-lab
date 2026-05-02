CREATE TABLE concert (
    id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE concert_show (
    id BIGINT NOT NULL AUTO_INCREMENT,
    concert_id BIGINT NOT NULL,
    show_at DATETIME(6) NOT NULL,
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    PRIMARY KEY (id),
    CONSTRAINT fk_show_concert FOREIGN KEY (concert_id) REFERENCES concert (id),
    INDEX idx_show_concert_id (concert_id),
    INDEX idx_show_show_at (show_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE seat (
    id BIGINT NOT NULL AUTO_INCREMENT,
    show_id BIGINT NOT NULL,
    seat_no VARCHAR(20) NOT NULL,
    grade VARCHAR(30) NOT NULL,
    price INT NOT NULL,
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    PRIMARY KEY (id),
    CONSTRAINT fk_seat_show FOREIGN KEY (show_id) REFERENCES concert_show (id),
    UNIQUE KEY uk_seat_show_seat_no (show_id, seat_no),
    INDEX idx_seat_show_id (show_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE seat_hold (
    id BIGINT NOT NULL AUTO_INCREMENT,
    show_id BIGINT NOT NULL,
    seat_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    status VARCHAR(20) NOT NULL,
    expires_at DATETIME(6) NOT NULL,
    idempotency_key VARCHAR(100) NULL,
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6),
    PRIMARY KEY (id),
    CONSTRAINT fk_hold_show FOREIGN KEY (show_id) REFERENCES concert_show (id),
    CONSTRAINT fk_hold_seat FOREIGN KEY (seat_id) REFERENCES seat (id),
    UNIQUE KEY uk_hold_idempotency_key (idempotency_key),
    INDEX idx_hold_seat_status_expires (seat_id, status, expires_at),
    INDEX idx_hold_user_status (user_id, status),
    INDEX idx_hold_expires_at (expires_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE reservation (
    id BIGINT NOT NULL AUTO_INCREMENT,
    reservation_no VARCHAR(40) NOT NULL,
    show_id BIGINT NOT NULL,
    seat_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    hold_id BIGINT NOT NULL,
    status VARCHAR(20) NOT NULL,
    idempotency_key VARCHAR(100) NULL,
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    PRIMARY KEY (id),
    CONSTRAINT fk_res_show FOREIGN KEY (show_id) REFERENCES concert_show (id),
    CONSTRAINT fk_res_seat FOREIGN KEY (seat_id) REFERENCES seat (id),
    CONSTRAINT fk_res_hold FOREIGN KEY (hold_id) REFERENCES seat_hold (id),
    UNIQUE KEY uk_reservation_no (reservation_no),
    UNIQUE KEY uk_res_show_seat (show_id, seat_id),
    UNIQUE KEY uk_res_idempotency_key (idempotency_key),
    INDEX idx_res_user_created (user_id, created_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
