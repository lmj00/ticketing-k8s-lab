package com.lmj.ticketing.application.show;

import com.lmj.ticketing.application.show.dto.ShowResponse;
import com.lmj.ticketing.infrastructure.persistence.show.ConcertShowRepository;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShowQueryService {

    private final ConcertShowRepository concertShowRepository;

    public List<ShowResponse> findAllByConcertId(Long concertId) {
        return concertShowRepository.findByConcertIdOrderByShowAtAsc(concertId)
                .stream()
                .map(ShowResponse::from)
                .toList();
    }
}
