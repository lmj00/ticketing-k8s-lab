package com.lmj.ticketing.infrastructure.persistence.show;

import com.lmj.ticketing.domain.show.ConcertShow;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertShowRepository extends JpaRepository<ConcertShow, Long> {
    List<ConcertShow> findByConcertIdOrderByShowAtAsc(Long concertId);
}

