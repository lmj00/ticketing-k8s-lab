package com.lmj.ticketing.infrastructure.persistence.concert;

import com.lmj.ticketing.domain.concert.Concert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertRepository extends JpaRepository<Concert, Long> {
}

